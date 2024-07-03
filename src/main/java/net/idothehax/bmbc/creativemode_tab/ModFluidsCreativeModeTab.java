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
public class ModFluidsCreativeModeTab {
    public static CreativeModeTab BMBC_FLUIDS;

    @SubscribeEvent
    public static void registerModFluidsCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC_FLUIDS = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_fluids"),
                builder -> builder.icon(() -> new ItemStack(ModItems.SODIUM_HYDROXIDE_BUCKET.get())).title(Component.literal("Fluids")));
    }
}

