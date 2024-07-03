package net.matty.bmbc.util;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.IntTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.energy.EnergyStorage;

public abstract class BmbcEnergyStorage extends EnergyStorage {
    public BmbcEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public void setEnergy(int energy){
        this.energy = energy;
    }

    public void addEnergy(int energy){
        this.energy += energy;
        if (this.energy > getMaxEnergyStored()){
            this.energy = getEnergyStored();
        }
    }

    public void consumeEnergy(int energy){
        this.energy -= energy;
        if (this.energy < 0){
            this.energy = 0;
        }
    }

    /*@Override
    public CompoundTag serializeNBT(){
        CompoundTag tag = new CompoundTag();
        tag.putInt("energy", getEnergyStored());
        return tag;
    }*/

    public void serializeNBT(CompoundTag tag) {
        tag.putInt("energy", getEnergyStored());
    }

    public void deserializeNBT(CompoundTag tag) {
        setEnergy(tag.getInt("energy"));
    }

    public void setMaxReceive(int amount) {
        this.maxReceive = amount;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        if (!(nbt instanceof IntTag intNbt))
            throw new IllegalArgumentException("VEEnergyStorage: Cannot deserialize to an instance that isn't the default implementation!");
        setEnergy(intNbt.getAsInt());
    }

    public abstract void onEnergyChanged();
}
