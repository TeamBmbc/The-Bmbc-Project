package net.matty.bmbc.creativemode_tab;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModChemicalCompounds;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModChemicalCompoundsCreativeModeTab {
    public static CreativeModeTab CHEMICAL_COMPOUNDS;

    @SubscribeEvent
    public static void registerModChemicalCompoundsCreativeModeTab(CreativeModeTabEvent.Register event) {
        CHEMICAL_COMPOUNDS = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_chemical_compounds"),
                builder -> builder.icon(() -> new ItemStack(ModChemicalCompounds.ALUMINA.get())).title(Component.literal("Chemical Compounds")));
    }
}
