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
public class ModMachinesCreativeModeTab {
    public static CreativeModeTab BMBC_MACHINES;

    @SubscribeEvent
    public static void registerModBlocksCreativeModeTab(CreativeModeTabEvent.Register event) {
        BMBC_MACHINES = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_machines"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.THREE_D_PRINTER.get())).title(Component.literal("Bmbc Machines")));
    }
}

