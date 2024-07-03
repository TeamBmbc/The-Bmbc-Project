package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModMineralItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModResourcesCreativeModeTab {
    public static CreativeModeTab BMBC_RESOURCES;

    @SubscribeEvent
    public static void registerModResourcesCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC_RESOURCES = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "ores_and_minerals"),
                builder -> builder.icon(() -> new ItemStack(ModMineralItems.ALUMINIUM_INGOT.get())).title(Component.literal("Ores and Minerals")));
    }
}