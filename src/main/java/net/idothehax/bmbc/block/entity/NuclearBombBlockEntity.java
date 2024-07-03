//package net.matty.bmbc.block.entity;
//
//import net.matty.bmbc.screen.AlloyFurnaceMenu;
//import net.matty.bmbc.screen.NuclearBombMenu;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.NonNullList;
//import net.minecraft.nbt.CompoundTag;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.ContainerHelper;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.AbstractContainerMenu;
//import net.minecraft.world.inventory.ChestMenu;
//import net.minecraft.world.inventory.ContainerData;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.entity.ChestBlockEntity;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraftforge.common.util.LazyOptional;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//import org.jetbrains.annotations.Nullable;
//
//public class NuclearBombBlockEntity extends BlockEntity {
//    private final ItemStackHandler itemHandler = new ItemStackHandler(6) {
//        @Override
//        protected void onContentsChanged(int slot) {
//            setChanged();
//        }
//    };
//
//    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();
//
//
//    public NuclearBombBlockEntity(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
//        super(pType, pPos, pBlockState);
//    }
//
//    public NuclearBombBlockEntity(BlockPos pPos, BlockState pBlockState) {
//        this(ModBlockEntities.NUCLEAR_BOMB.get(), pPos, pBlockState);
//    }
//
//    /**
//     * Returns the number of slots in the inventory
//     */
//    public int getContainerSize() {
//        return 6;
//    }
//
//    protected Component getDefaultName() {
//        return Component.translatable("container.bmbc.nuclear_bomb");
//    }
//
//    public void load(CompoundTag pTag) {
//        super.load(pTag);
//        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
//        ContainerHelper.loadAllItems(pTag, this.items);
//    }
//
//    protected void saveAdditional(CompoundTag pTag) {
//        super.saveAdditional(pTag);
//        ContainerHelper.saveAllItems(pTag, this.items);
//    }
//
//    protected NonNullList<ItemStack> getItems() {
//        return this.items;
//    }
//
//    protected void setItems(NonNullList<ItemStack> pItems) {
//        this.items = pItems;
//    }
//
//    public static void swapContents(NuclearBombBlockEntity pChest, NuclearBombBlockEntity pOtherChest) {
//        NonNullList<ItemStack> nonnulllist = pChest.getItems();
//        pChest.setItems(pOtherChest.getItems());
//        pOtherChest.setItems(nonnulllist);
//    }
//
//    @Nullable
//    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
//        return new NuclearBombMenu(id, inventory, this);
//    }
//}