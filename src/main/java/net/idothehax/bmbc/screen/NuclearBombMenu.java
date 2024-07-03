package net.matty.bmbc.screen;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class NuclearBombMenu extends AbstractContainerMenu {
    private static final int SLOTS_PER_ROW = 2;
    private final Container container;
    private final int containerRows;

    private NuclearBombMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, int pRows) {
        this(pType, pContainerId, pPlayerInventory, new SimpleContainer(2 * pRows), pRows);
    }

    public static NuclearBombMenu twoRows(int pContainerId, Inventory pPlayerInventory) {
        return new NuclearBombMenu(MenuType.HOPPER, pContainerId, pPlayerInventory, 2);
    }


    public NuclearBombMenu(MenuType<?> pType, int pContainerId, Inventory pPlayerInventory, Container pContainer, int pRows) {
        super(pType, pContainerId);
        checkContainerSize(pContainer, pRows * 2);
        this.container = pContainer;
        this.containerRows = pRows;
        pContainer.startOpen(pPlayerInventory.player);
        int i = (this.containerRows - 4) * 18;

        for(int j = 0; j < this.containerRows; ++j) {
            for(int k = 0; k < 2; ++k) {
                this.addSlot(new Slot(pContainer, k + j * 2, 8 + k * 18, 18 + j * 18));
            }
        }

        for(int l = 0; l < 3; ++l) {
            for(int j1 = 0; j1 < 2; ++j1) {
                this.addSlot(new Slot(pPlayerInventory, j1 + l * 2 + 2, 8 + j1 * 18, 103 + l * 18 + i));
            }
        }

        for(int i1 = 0; i1 < 2; ++i1) {
            this.addSlot(new Slot(pPlayerInventory, i1, 8 + i1 * 18, 161 + i));
        }

    }

    /**
     * Determines whether supplied player can use this container
     */
    public boolean stillValid(Player pPlayer) {
        return this.container.stillValid(pPlayer);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);
        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (pIndex < this.containerRows * 2) {
                if (!this.moveItemStackTo(itemstack1, this.containerRows * 2, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.containerRows * 2, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    /**
     * Called when the container is closed.
     */
    public void removed(Player pPlayer) {
        super.removed(pPlayer);
        this.container.stopOpen(pPlayer);
    }

    /**
     * Gets the inventory associated with this chest container.
     *
     * field_75155_e
     */
    public Container getContainer() {
        return this.container;
    }

    public int getRowCount() {
        return this.containerRows;
    }
}