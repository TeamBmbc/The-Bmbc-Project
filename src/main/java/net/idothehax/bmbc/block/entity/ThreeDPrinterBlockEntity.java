package net.matty.bmbc.block.entity;

import net.matty.bmbc.block.custom.ThreeDPrinterBlock;
import net.matty.bmbc.recipe.ThreeDPrinterRecipe;
import net.matty.bmbc.screen.ThreeDPrinterMenu;
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
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ThreeDPrinterBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 240;

    public ThreeDPrinterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.THREE_D_PRINTER.get(), pos, state);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> ThreeDPrinterBlockEntity.this.progress;
                    case 1 -> ThreeDPrinterBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> ThreeDPrinterBlockEntity.this.progress = value;
                    case 1 -> ThreeDPrinterBlockEntity.this.maxProgress = value;
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
        return Component.literal("3D Printer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new ThreeDPrinterMenu(id, inventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        nbt.put("inventory", itemHandler.serializeNBT());
        nbt.putInt("three_d_printer.progress", this.progress);

        super.saveAdditional(nbt);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
        progress = nbt.getInt("three_d_printer.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ThreeDPrinterBlockEntity pEntity) {
        if (level.isClientSide()) {
            return;
        }

        if(hasRecipe(pEntity)) {
            if (!state.getValue(ThreeDPrinterBlock.ACTIVE)) {
                state = state.setValue(ThreeDPrinterBlock.ACTIVE, true);
                level.setBlock(pos, state, 3);
            }

            pEntity.progress++;
            setChanged(level, pos, state);

            if(pEntity.progress >= pEntity.maxProgress) {
                craftItem(pEntity);
            }

        } else {
            if (state.getValue(ThreeDPrinterBlock.ACTIVE)) {
                state = state.setValue(ThreeDPrinterBlock.ACTIVE, false);
                level.setBlock(pos, state, 3);
            }

            pEntity.resetProgress();
            setChanged(level, pos, state);
        }
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private static void craftItem(ThreeDPrinterBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<ThreeDPrinterRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ThreeDPrinterRecipe.Type.INSTANCE, inventory, level);

        if(hasRecipe(entity)) {
            entity.itemHandler.extractItem(0, 1, false);
            entity.itemHandler.extractItem(1, 0, false);
            entity.itemHandler.setStackInSlot(2, new ItemStack(recipe.get().getResultItem(level.registryAccess()).getItem(), // Careful this can apparently cause data leaks using level.registryAccess so TODO: Find a better way
                    entity.itemHandler.getStackInSlot(2).getCount() + 1)); // if you add a count in the .json recipe files it will not work pls fix

            entity.resetProgress();
        }
    }

    private static boolean hasRecipe(ThreeDPrinterBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<ThreeDPrinterRecipe> recipe = level.getRecipeManager()
                .getRecipeFor(ThreeDPrinterRecipe.Type.INSTANCE, inventory, level);

        //boolean hasMoldInMoldSlot = entity.itemHandler.getStackInSlot(1).getItem() == ModItems.SCREW_TEMPLATE.get();

        return recipe.isPresent() && canInsertAmountIntoOutputSlot(inventory) &&
                canInsertItemIntoOutputSlot(inventory, recipe.get().getResultItem(level.registryAccess()));
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack stack) {
        return inventory.getItem(2).getItem() == stack.getItem() || inventory.getItem(2).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(2).getMaxStackSize() > inventory.getItem(2).getCount();
    }
}
