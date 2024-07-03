package net.matty.bmbc.energy;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.util.BmbcEnergyStorage;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class BmbcEnergyItemStorage extends BmbcEnergyStorage {
    private final ItemStack itemStack;

    public BmbcEnergyItemStorage(Item.Properties properties, ItemStack itemStack, int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
        this.itemStack = itemStack;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate){
        if(!canReceive()) return 0;
        int energyStored = getEnergyStored();
        int energyReceived = Math.min(capacity - energyStored, Math.min(this.maxReceive, maxReceive));
        if(!simulate) writeEnergy(energyStored + energyReceived);
        return energyReceived;
    }

    @Override
    public int extractEnergy(int maxExtract, boolean simulate){
        if(!canExtract()) return 0;
        int energyExtracted = Math.min(getEnergyStored(), Math.min(this.maxExtract,maxExtract));
        BetterMineBetterCraft.LOGGER.debug("Extracting Energy from item. energyStored: " + getEnergyStored() + " energyExtracted: " + energyExtracted + " new total: " + (getEnergyStored() - energyExtracted) + " Max Extract: " + maxExtract);
        if(!simulate) writeEnergy(getEnergyStored() - energyExtracted);
        return energyExtracted;
    }

    @Override
    public int getEnergyStored(){return this.itemStack.getOrCreateTag().getInt("energy");}

    private void writeEnergy(int amount){this.itemStack.getOrCreateTag().putInt("energy",amount);}

    @Override
    public void onEnergyChanged() {

    }
}
