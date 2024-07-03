package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModFoodItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModFoodCreativeModTab {
    public static CreativeModeTab FOOD;

    @SubscribeEvent
    public static void registerModFoodCreativeModeTab(CreativeModeTabEvent.Register event) {
        FOOD = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_foods"),
                builder -> builder.icon(() -> new ItemStack(ModFoodItems.COFFEE_CHERRY.get())).title(Component.literal("Bmbc Foods")));
    }
}
