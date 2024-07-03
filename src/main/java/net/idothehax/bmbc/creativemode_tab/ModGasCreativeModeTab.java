package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.GasStorageItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModGasCreativeModeTab {
    public static CreativeModeTab BMBC_GASSES;

    @SubscribeEvent
    public static void registerModFluidsCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC_GASSES = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_gasses"),
                builder -> builder.icon(() -> new ItemStack(GasStorageItems.COMPRESSED_HELIUM.get())).title(Component.literal("Gasses")));
    }
}

