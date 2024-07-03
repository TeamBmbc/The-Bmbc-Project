package net.matty.bmbc.block.entity;

import net.matty.bmbc.block.custom.PressureVesselBlock;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.ModMineralItems;
import net.matty.bmbc.networking.ModNetworkingPackets;
import net.matty.bmbc.networking.packet.EnergySyncS2CPacket;
import net.matty.bmbc.networking.packet.FluidSyncS2CPacket;
import net.matty.bmbc.recipe.PressureVesselRecipe;
import net.matty.bmbc.screen.PressureVesselMenu;
import net.matty.bmbc.util.BmbcEnergyStorage;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fluids.capability.templates.FluidTank;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.Optional;

public class PressureVesselBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(3) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).isPresent();
                case 1 -> stack.getItem() == ModMineralItems.CRUSHED_BAUXITE.get();
                case 2 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private final BmbcEnergyStorage ENERGY_STORAGE = new BmbcEnergyStorage(60000, 256) {
        @Override
        public void onEnergyChanged() {
            setChanged();
            ModNetworkingPackets.sendToClients(new EnergySyncS2CPacket(this.energy, getBlockPos()));
        }
    };

    private static final int ENERGY_REQ = 32; // How much energy is consumed per tick  to craft something


    private final FluidTank FLUID_TANK = new FluidTank(64000) {
        @Override
        protected void onContentsChanged() {
            setChanged();
            if (!level.isClientSide()) {
                ModNetworkingPackets.sendToClients(new FluidSyncS2CPacket(this.fluid, worldPosition));
            }
        }

        @Override
        public boolean isFluidValid(FluidStack stack) {
            return stack.getFluid() == Fluids.WATER || stack.getFluid() == ModFluids.SOURCE_SODIUM_HYDROXIDE.get();
        }
    };

    public void setFluid(FluidStack stack) {
        this.FLUID_TANK.setFluid(stack);
    }

    public FluidStack getFluidStack() {
        return this.FLUID_TANK.getFluid();
    }

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
    private final Map<Direction, LazyOptional<WrappedHandler>> directionWrappedHandlerMap =
            Map.of(Direction.DOWN, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.NORTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 1,
                            (index, stack) -> itemHandler.isItemValid(1, stack))),
                    Direction.SOUTH, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 2, (i, s) -> false)),
                    Direction.EAST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (i) -> i == 1,
                            (index, stack) -> itemHandler.isItemValid(1, stack))),
                    Direction.WEST, LazyOptional.of(() -> new WrappedHandler(itemHandler, (index) -> index == 0 || index == 1,
                            (index, stack) -> itemHandler.isItemValid(0, stack) || itemHandler.isItemValid(1, stack))));

    private LazyOptional<IEnergyStorage> lazyEnergyHandler = LazyOptional.empty();
    private LazyOptional<IFluidHandler> lazyFluidHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public PressureVesselBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PRESSURE_VESSEL.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> PressureVesselBlockEntity.this.progress;
                    case 1 -> PressureVesselBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> PressureVesselBlockEntity.this.progress = value;
                    case 1 -> PressureVesselBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Pressure Vessel");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        ModNetworkingPackets.sendToClients(new EnergySyncS2CPacket(this.ENERGY_STORAGE.getEnergyStored(), getBlockPos()));
        ModNetworkingPackets.sendToClients(new FluidSyncS2CPacket(this.getFluidStack(), worldPosition));
        return new PressureVesselMenu(id, inventory, this, this.data);
    }

    public IEnergyStorage getEnergyStorage() {
        return ENERGY_STORAGE;
    }

    public void setEnergyLevel(int energy) {
        this.ENERGY_STORAGE.setEnergy(energy);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ENERGY) {
            return lazyEnergyHandler.cast();
        }

        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            if(side == null) {
                return lazyItemHandler.cast();
            }

            if(directionWrappedHandlerMap.containsKey(side)) {
                Direction localDir = this.getBlockState().getValue(PressureVesselBlock.FACING);

                if(side == Direction.UP || side == Direction.DOWN) {
                    return directionWrappedHandlerMap.get(side).cast();
                }

                return switch (localDir) {
                    default -> directionWrappedHandlerMap.get(side.getOpposite()).cast();
                    case EAST -> directionWrappedHandlerMap.get(side.getClockWise()).cast();
                    case SOUTH -> directionWrappedHandlerMap.get(side).cast();
                    case WEST -> directionWrappedHandlerMap.get(side.getCounterClockWise()).cast();
                };
            }
        }

        if (cap == ForgeCapabilities.FLUID_HANDLER) {
            return lazyFluidHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
        lazyEnergyHandler = LazyOptional.of(() -> ENERGY_STORAGE);
        lazyFluidHandler = LazyOptional.of(() -> FLUID_TANK);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
        lazyEnergyHandler.invalidate();
        lazyFluidHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("pressure_vessel.progress", this.progress);
        nbt.putInt("pressure_vessel.energy", ENERGY_STORAGE.getEnergyStored());
        nbt = FLUID_TANK.writeToNBT(nbt);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("pressure_vessel.progress");
        ENERGY_STORAGE.setEnergy(nbt.getInt("pressure_vessel.energy"));
        FLUID_TANK.readFromNBT(nbt);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, PressureVesselBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }

        if (hasPowerStorageItemInFirstSlot(pEntity)) {
            pEntity.ENERGY_STORAGE.receiveEnergy(64, false);
        }

        if(hasRecipe(pEntity) && hasEnoughEnergy(pEntity)) {
            pEntity.progress++;
            extractEnergy(pEntity);
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, pos, state);
        }

        if (hasFluidItemInSourceSlot(pEntity)) {
            transferItemFluidToFluidTank(pEntity);
        }
    }

    private static void transferItemFluidToFluidTank(PressureVesselBlockEntity pEntity) {
        pEntity.itemHandler.getStackInSlot(0).getCapability(ForgeCapabilities.FLUID_HANDLER_ITEM).ifPresent(handler -> {
            int drainAmount = Math.min(pEntity.FLUID_TANK.getSpace(), 1000); // get a 1000 out of a tank

            FluidStack stack = handler.drain(drainAmount, IFluidHandler.FluidAction.SIMULATE);
            if (pEntity.FLUID_TANK.isFluidValid(stack)) {
                stack = handler.drain(drainAmount, IFluidHandler.FluidAction.EXECUTE);
                fillTankWithFluid(pEntity, stack, handler.getContainer());
            }

        });
    }

    private static void fillTankWithFluid(PressureVesselBlockEntity pEntity, FluidStack stack, ItemStack container) {
        pEntity.FLUID_TANK.fill(stack, IFluidHandler.FluidAction.EXECUTE);

        pEntity.itemHandler.extractItem(0, 1, false); // remove the bucket
        pEntity.itemHandler.insertItem(0, container, false); // swap for empty bucket or show less if using tank from different mod
    }

    private static boolean hasFluidItemInSourceSlot(PressureVesselBlockEntity pEntity) {
        return pEntity.itemHandler.getStackInSlot(0).getCount() > 0;
    }

    private static void extractEnergy(PressureVesselBlockEntity pEntity) {
        pEntity.ENERGY_STORAGE.extractEnergy(ENERGY_REQ, false);
    }

    private static boolean hasEnoughEnergy(PressureVesselBlockEntity pEntity) {
        return pEntity.ENERGY_STORAGE.getEnergyStored() >= ENERGY_REQ * pEntity.maxProgress;
    }

    private static boolean hasPowerStorageItemInFirstSlot(PressureVesselBlockEntity pEntity) {
        return pEntity.itemHandler.getStackInSlot(0).getItem() == Items.REDSTONE; // TODO: Change to battery once its fixed
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(PressureVesselBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemHandler.getSlots());
        for (int i = 0; i < pEntity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemHandler.getStackInSlot(i));
        }

        Optional<PressureVesselRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(PressureVesselRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(pEntity)) {
            pEntity.FLUID_TANK.drain(recipe.get().getFluidStack().getAmount(), IFluidHandler.FluidAction.EXECUTE);
            pEntity.itemHandler.extractItem(1, 1, false);
            pEntity.itemHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(),
                    pEntity.itemHandler.getStackInSlot(2).getCount() + 1));

            pEntity.resetProgress();
        }
    }

    private static boolean hasRecipe(PressureVesselBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<PressureVesselRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(PressureVesselRecipe.Type.INSTANCE, inventory, level);


        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem(level.registryAccess())) && hasCorrectFluidInTank(entity, recipe);
    }

    private static boolean hasCorrectFluidInTank(PressureVesselBlockEntity entity, Optional<PressureVesselRecipe> recipe) {
        return recipe.get().getFluidStack().equals(entity.FLUID_TANK.getFluid());
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
