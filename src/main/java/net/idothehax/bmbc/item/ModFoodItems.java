package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFoodItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // Crops and their seed accomplices
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans",
            () -> new ItemNameBlockItem(ModBlocks.COFFEE_CROP.get(),
                    new Item.Properties()));

    public static final RegistryObject<Item> COFFEE_CHERRY = ITEMS.register("coffee_cherry",
            () -> new Item(new Item.Properties()
                    .food(new FoodProperties.Builder()
                            .nutrition(2)
                            .saturationMod(2f)
                            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,
                                    600, 3), 1.0f)
                            .alwaysEat()
                            .build())));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
