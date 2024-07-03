package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModAlloyItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AlloysCreativeModeTab {
    public static CreativeModeTab BMBC_ALLOYS;

    @SubscribeEvent
    public static void registerAlloysCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC_ALLOYS = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_alloys"),
                builder -> builder.icon(() -> new ItemStack(ModAlloyItems.BRASS.get())).title(Component.literal("Alloys")));
    }
}
