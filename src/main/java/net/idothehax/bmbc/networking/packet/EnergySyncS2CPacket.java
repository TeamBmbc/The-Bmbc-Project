package net.matty.bmbc.networking.packet;

import net.matty.bmbc.block.entity.PressureVesselBlockEntity;
import net.matty.bmbc.screen.PressureVesselMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class EnergySyncS2CPacket {
    private final int energy;
    private final BlockPos pos;

    public EnergySyncS2CPacket(int energy, BlockPos pos){
        this.energy = energy;
        this.pos = pos;
    }

    public EnergySyncS2CPacket(FriendlyByteBuf buf) {
        this.energy = buf.readInt();
        this.pos = buf.readBlockPos();
    }

    public  void toBytes(FriendlyByteBuf buf) {
        buf.writeInt(energy);
        buf.writeBlockPos(pos);
    }

    public Boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof PressureVesselBlockEntity blockEntity) {
                blockEntity.setEnergyLevel(energy);

                if(Minecraft.getInstance().player.containerMenu instanceof PressureVesselMenu menu &&
                    menu.getBlockEntity().getBlockPos().equals(pos)) {
                    blockEntity.setEnergyLevel(energy);
                }
            }
        });
        return true;
    }
}
