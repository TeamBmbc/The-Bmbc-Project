package net.matty.bmbc.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ExampleC2SPacket {
    public ExampleC2SPacket(){

    }

    public ExampleC2SPacket(FriendlyByteBuf buf) {

    }

    public  void toBytes(FriendlyByteBuf buf) {

    }

    public Boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            // HERE WE ARE ON THE SERVER!
            ServerPlayer player = context.getSender();
            ServerLevel level = player.getLevel();

            //EntityType.GIANT.spawn(level, null, null, player.blockPosition(),
            //        MobSpawnType.COMMAND, true, false);
        });
        return true;
    }
}
