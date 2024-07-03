package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocksCreativeModeTab {
    public static CreativeModeTab BMBC_BLOCKS;

    @SubscribeEvent
    public static void registerModBlocksCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC_BLOCKS = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_blocks"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.SILVER_LAMP.get())).title(Component.literal("Bmbc Blocks")));
    }
}

