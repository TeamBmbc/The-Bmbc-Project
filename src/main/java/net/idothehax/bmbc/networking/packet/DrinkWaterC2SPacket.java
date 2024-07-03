//package net.matty.bmbc.networking.packet;
//
//import net.matty.bmbc.networking.ModNetworkingPackets;
//import net.matty.bmbc.thirst.PlayerThirstProvider;
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.network.chat.Component;
//import net.minecraft.server.level.ServerLevel;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.sounds.SoundEvents;
//import net.minecraft.sounds.SoundSource;
//import net.minecraft.world.entity.EntityType;
//import net.minecraft.world.entity.MobSpawnType;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraftforge.network.NetworkEvent;
//
//import java.util.function.Supplier;
//
//public class DrinkWaterC2SPacket {
//    private static final String MESSAGE_DRINK_WATER = "message.bmbc.drink_water";
//    private static final String MESSAGE_NO_WATER = "message.bmbc.no_water";
//
//    public DrinkWaterC2SPacket(){
//
//    }
//
//    public DrinkWaterC2SPacket(FriendlyByteBuf buf) {
//
//    }
//
//    public  void toBytes(FriendlyByteBuf buf) {
//
//    }
//
//    public Boolean handle(Supplier<NetworkEvent.Context> supplier) {
//        NetworkEvent.Context context = supplier.get();
//        context.enqueueWork(() -> {
//            // HERE WE ARE ON THE SERVER!
//            ServerPlayer player = context.getSender();
//            ServerLevel level = player.getLevel();
//
//            // Check if player is near water?
//            if(hasWaterAroundThem(player, level, 2)) {
//                // Notify the player that water has been drunk
//                player.sendSystemMessage(Component.translatable(MESSAGE_DRINK_WATER).withStyle(ChatFormatting.DARK_AQUA));
//                // play the drink sound
//                level.playSound(null, player.getOnPos(), SoundEvents.GENERIC_DRINK, SoundSource.PLAYERS,
//                        0.5f, level.random.nextFloat() * 0.1f + 0.9f);
//
//                // increase the water / thirst level of player
//                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
//                    thirst.addThirst(1);
//                    player.sendSystemMessage(Component.literal("Current Thirst " + thirst.getThirst())
//                            .withStyle(ChatFormatting.AQUA));
//                    ModNetworkingPackets.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
//                });
//
//                // Output the current thirst level
//
//            } else {
//                // Notify the player that there is no water around!
//                player.sendSystemMessage(Component.translatable(MESSAGE_NO_WATER).withStyle(ChatFormatting.RED));
//                // Check if player has water bottle on them
//
//                // Output the current thirst level
//                player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
//                    player.sendSystemMessage(Component.literal("Current Thirst " + thirst.getThirst())
//                            .withStyle(ChatFormatting.AQUA));
//                    ModNetworkingPackets.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
//                });
//
//            }
//
//        });
//        return true;
//    }
//
//    private boolean hasWaterAroundThem(ServerPlayer player, ServerLevel level, int size) {
//        return level.getBlockStates(player.getBoundingBox().inflate(size))
//                .filter(state -> state.is(Blocks.WATER)).toArray().length > 0;
//    }
//
//    //private boolean hasWaterBottleOnThem(ServerPlayer player, ServerLevel level) {
//    //    return level.
//    //}
//}
//