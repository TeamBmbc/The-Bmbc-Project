package net.matty.bmbc.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.*;
import net.matty.bmbc.thirst.PlayerThirst;
import net.matty.bmbc.thirst.PlayerThirstProvider;
import net.matty.bmbc.villager.ModVillagers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.TOOLSMITH) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModFoodItems.COFFEE_CHERRY.get(), 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 2),
                    stack, 10, 8, 0.02F));
        }

        if(event.getType() == ModVillagers.SILVERER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(ModFoodItems.COFFEE_BEANS.get(), 3);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 1),
                    stack,10,8,0.02F));
        }

        if(event.getType() == ModVillagers.VENDOR.get()) {
            // Here we do the trades these are sorted by level and in sublevel are sorted alphabetically
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades(); // But first we set up the list for the trades
            //int villagerLevel = 100;

            // items you sell
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(ModMachineComponents.COPPER_WIRE.get(), 3),10,2,0.02F));
            trades.get(1).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(ModMachineComponents.IRON_ROD.get(), 3),10,1,0.02F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 3), new ItemStack(ModMachineComponents.MAGNETIC_IRON_ROD.get(), 3),10,4,0.04F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(ModMachineComponents.COPPER_COIL.get(), 3),10,2,0.02F));
            trades.get(2).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 2), new ItemStack(ModMachineComponents.COPPER_FOIL.get(), 3),10,2,0.02F));
            trades.get(3).add((trader, rand) -> new MerchantOffer(new ItemStack(Items.EMERALD, 5), new ItemStack(ModMachineComponents.ELECTRIC_MOTOR.get(), 1),4,4,0.04F));


        }
    }

    /*@SubscribeEvent
    public static void onItemDropped(ItemTossEvent event) {
        Item item = event.getEntity().getItem().getItem();
        if(!(item instanceof CompoundItem &&((CompoundItem) item).getCompoundElements().contains(BMBC_Main.LITHIUM))) return;
        new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (event.getEntity().isInWater()){
                event.getPlayer().getServer().overworld().explode(null, event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), 2, true, Level.ExplosionInteraction.NONE);
            }
        }).start();
    }*/

    @SubscribeEvent
    public static void doCompatStuff(FMLLoadCompleteEvent event) {
        List<CompoundItem> compoundItems = new ArrayList<>();
        for (Item item: ForgeRegistries.ITEMS.getValues()) {
            if (item instanceof CompoundItem compoundItem) compoundItems.add(compoundItem);
        }
        for (Item item:ForgeRegistries.ITEMS.getValues()) {
            if (item instanceof CompoundItem) continue;
            boolean ImTheException = false;
            if (ForgeRegistries.ITEMS.getKey(item).getPath() == "iron_ingot") {
                CompoundItem.addCompatibleItem(item, new Compound(ElementItems.IRON));
                ImTheException = true;
            } else if (ForgeRegistries.ITEMS.getKey(item).getPath() == "copper_ingot") {
                CompoundItem.addCompatibleItem(item, new Compound(ElementItems.COPPER));
                ImTheException = true;
            } else if (ForgeRegistries.ITEMS.getKey(item).getPath() == "gold_ingot") {
                CompoundItem.addCompatibleItem(item, new Compound(ElementItems.GOLD));
                ImTheException = true;
            }
            if (ImTheException) continue;
            for (CompoundItem compoundItem:compoundItems) {
                if (ForgeRegistries.ITEMS.getKey(item).getPath().replace("aluminum","aluminium") == ForgeRegistries.ITEMS.getKey(compoundItem).getPath()) {
                    CompoundItem.addCompatibleItem(item, compoundItem.getCompound());
                    break;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(PlayerThirstProvider.PLAYER_THIRST).isPresent()) {
                event.addCapability(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "properties"), new PlayerThirstProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(oldStore -> {
                event.getOriginal().getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(PlayerThirst.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                if(thirst.getThirst() > 0 && event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    thirst.subThirst(1);
                    //ModNetworkingPackets.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), ((ServerPlayer) event.player));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                //player.getCapability(PlayerThirstProvider.PLAYER_THIRST).ifPresent(thirst -> {
                //    ModNetworkingPackets.sendToPlayer(new ThirstDataSyncS2CPacket(thirst.getThirst()), player);
                //});
            }
        }
    }
}
