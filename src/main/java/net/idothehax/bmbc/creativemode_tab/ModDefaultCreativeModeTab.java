package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDefaultCreativeModeTab {
    public static CreativeModeTab BMBC;

    @SubscribeEvent
    public static void registerModDefaultCompoundsCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RED_PRINTER_FILAMENT.get())).title(Component.literal("This is Bmbc!")));
    }
}
