//package net.matty.bmbc.block.entity; TODO: Change to battery once its fixed
//
//import net.matty.bmbc.item.ModItems;
//import net.matty.bmbc.screen.MaceratorMenu;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.Containers;
//import net.minecraft.world.MenuProvider;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.capabilities.Capability;
//import net.minecraftforge.common.capabilities.ForgeCapabilities;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//import org.jetbrains.annotations.NotNull;
//import org.jetbrains.annotations.Nullable;
//
//public class RechargerBlockEntity extends BlockEntity implements MenuProvider {
//    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
//        @Override
//        protected void onContentsChanged(int slot) {
//            setChanged();
//        }
//    };
//
//    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
//
//    protected final ContainerData data;
//    private int progress = 0;
//    private int maxProgress = 1200;//24000;
//
//    public RechargerBlockEntity(BlockPos pos, BlockState state) {
//        super(ModBlockEntities.RECHARGER.get(), pos, state);
//        this.data = new ContainerData() {
//            @Override
//            public int get(int index) {
//                return switch (index) {
//                    case 0 -> RechargerBlockEntity.this.progress;
//                    case 1 -> RechargerBlockEntity.this.maxProgress;
//                    default -> 0;
//                };
//            }
//
//            @Override
//            public void set(int index, int value) {
//                switch (index) {
//                    case 0 -> RechargerBlockEntity.this.progress = value;
//                    case 1 -> RechargerBlockEntity.this.maxProgress = value;
//                }
//            }
//
//            @Override
//            public int getCount() {
//                return 2;
//            }
//        };
//    }
//
//    @Override
//    public Component getDisplayName() {
//        return Component.literal("Recharger");
//    }
//
//    @Nullable
//    @Override
//    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
//        return new MaceratorMenu(id, inventory, this, this.data);
//    }
//
//    @Override
//    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
//        if (cap == ForgeCapabilities.ITEM_HANDLER) {
//            return lazyItemHandler.cast();
//        }
//
//        return super.getCapability(cap, side);
//    }
//
//    @Override
//    public void onLoad() {
//        super.onLoad();
//        lazyItemHandler = LazyOptional.of(() -> itemHandler);
//    }
//
//    @Override
//    public void invalidateCaps() {
//        super.invalidateCaps();
//        lazyItemHandler.invalidate();
//    }
//
//    @Override
//    protected void saveAdditional(CompoundTag nbt) {
//        nbt.put("inventory", itemHandler.serializeNBT());
//        nbt.putInt("recharger.progress", this.progress);
//
//        super.saveAdditional(nbt);
//    }
//
//    @Override
//    public void load(CompoundTag nbt) {
//        super.load(nbt);
//        itemHandler.deserializeNBT(nbt.getCompound("inventory"));
//        progress = nbt.getInt("recharger.progress");
//    }
//
//    public void drops() {
//        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
//        for (int i = 0; i < itemHandler.getSlots(); i++) {
//            inventory.setItem(i, itemHandler.getStackInSlot(i));
//        }
//
//        Containers.dropContents(this.level, this.worldPosition, inventory);
//    }
//
//    public static void tick(Level level, BlockPos pos, BlockState state, RechargerBlockEntity pEntity) {
//        if (level.isClientSide()) {
//            return;
//        }
//
//        if(hasRecipe(pEntity)) {
//            pEntity.progress++;
//            setChanged(level, pos, state);
//
//            if(pEntity.progress >= pEntity.maxProgress) {
//                chargeBattery(pEntity);
//            }
//
//        } else {
//            pEntity.resetProgress();
//            setChanged(level, pos, state);
//        }
//    }
//
//    private void resetProgress() {
//        this.progress = 0;
//    }
//
//    private static void chargeBattery(RechargerBlockEntity pEntity) {
//
//        if(hasRecipe(pEntity)) {
//            pEntity.itemHandler.extractItem(0, 1, false);
//            pEntity.itemHandler.setStackInSlot(1, new ItemStack(ModItems.BATTERY.get(),
//                    pEntity.itemHandler.getStackInSlot(1).getCount() + 1));
//
//            pEntity.resetProgress();
//        }
//    }
//
//    private static boolean hasRecipe(RechargerBlockEntity entity) {
//        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
//        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
//            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
//        }
//
//        boolean hasBatteryInSlot = false;
//        for (int b = 0; b < entity.itemHandler.getSlots(); b++) {
//            hasBatteryInSlot = entity.itemHandler.getStackInSlot(b).getItem() == ModItems.BATTERY.get();
//        }
//
//        return hasBatteryInSlot && canInsertItemIntoChargeSlot(inventory, new ItemStack(ModItems.BATTERY.get(), 1));
//    }
//
//    private static boolean canInsertItemIntoChargeSlot(SimpleContainer inventory, ItemStack stack) {
//        return inventory.getItem(1).getItem() == stack.getItem() || inventory.getItem(1).isEmpty();
//    }
//
//    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
//        return inventory.getItem(1).getMaxStackSize() > inventory.getItem(1).getCount();
//    }
//}
