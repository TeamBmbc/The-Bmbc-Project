package net.matty.bmbc.networking.packet;

import net.matty.bmbc.block.entity.PressureVesselBlockEntity;
import net.matty.bmbc.screen.PressureVesselMenu;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class FluidSyncS2CPacket {
    private final FluidStack fluidStack;
    private final BlockPos pos;

    public FluidSyncS2CPacket(FluidStack fluidStack, BlockPos pos){
        this.fluidStack = fluidStack;
        this.pos = pos;
    }

    public FluidSyncS2CPacket(FriendlyByteBuf buf) {
        this.fluidStack = buf.readFluidStack();
        this.pos = buf.readBlockPos();
    }

    public  void toBytes(FriendlyByteBuf buf) {
        buf.writeFluidStack(fluidStack);
        buf.writeBlockPos(pos);
    }

    public Boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE CLIENT!
            if(Minecraft.getInstance().level.getBlockEntity(pos) instanceof PressureVesselBlockEntity blockEntity) {
                blockEntity.setFluid(this.fluidStack);

                if(Minecraft.getInstance().player.containerMenu instanceof PressureVesselMenu menu &&
                    menu.getBlockEntity().getBlockPos().equals(pos)) {
                    menu.setFluid(this.fluidStack);
                }
            }
        });
        return true;
    }
}
