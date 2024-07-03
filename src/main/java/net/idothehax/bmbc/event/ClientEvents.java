package net.matty.bmbc.event;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.client.ThirstHudOverlay;
import net.matty.bmbc.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void OnKeyInput(InputEvent.Key event) {
            if(KeyBinding.DRINKING_KEY.consumeClick()) {
                Minecraft.getInstance().player.sendSystemMessage(Component.literal(""));
                //ModNetworkingPackets.sendToServer(new DrinkWaterC2SPacket());
            }
        }
    }

    @Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DRINKING_KEY);
        }

        @SubscribeEvent
        public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
            event.registerAboveAll("thirst", ThirstHudOverlay.HUD_THIRST);
        }
    }
}
