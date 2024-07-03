//package net.matty.bmbc.creativemode_tab;
//
//import net.matty.bmbc.BetterMineBetterCraft;
//import net.matty.bmbc.block.ModBlocks;
//import net.minecraft.network.chat.Component;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.CreativeModeTab;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.event.CreativeModeTabEvent;
//import net.minecraftforge.eventbus.api.SubscribeEvent;
//import net.minecraftforge.fml.common.Mod;
//
//@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
//public class ExplosivesCreativeModeTab {
//    public static CreativeModeTab BMBC_EXPLOSIVES;
//
//    @SubscribeEvent
//    public static void registerModBlocksCreativeModeTab(CreativeModeTabEvent.Register event) {
//        BMBC_EXPLOSIVES = event.registerCreativeModeTab(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bmbc_explosives"),
//                builder -> builder.icon(() -> new ItemStack(ModBlocks.C4.get())).title(Component.literal("Bmbc Explosives")));
//    }
//}

