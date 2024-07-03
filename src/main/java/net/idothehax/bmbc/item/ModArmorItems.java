package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.item.custom.NBCHazmatArmorItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModArmorItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // Armour items
    // Hazmat Suit
    public static final RegistryObject<Item> NBC_HAZMAT_MASK = ITEMS.register("nbc_hazmat_mask",
            () -> new NBCHazmatArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.HELMET, new Item.Properties()));

    public static final RegistryObject<Item> NBC_HAZMAT_CHESTPLATE = ITEMS.register("nbc_hazmat_chestplate",
            () -> new NBCHazmatArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final RegistryObject<Item> NBC_HAZMAT_LEGGINGS = ITEMS.register("nbc_hazmat_leggings",
            () -> new NBCHazmatArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.LEGGINGS, new Item.Properties()));

    public static final RegistryObject<Item> NBC_HAZMAT_BOOTS = ITEMS.register("nbc_hazmat_boots",
            () -> new NBCHazmatArmorItem(ModArmorMaterials.HAZMAT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
