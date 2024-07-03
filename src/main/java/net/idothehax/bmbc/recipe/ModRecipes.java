package net.matty.bmbc.recipe;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<RecipeSerializer<AlloySmeltingRecipe>> ALLOY_SMELTER_SERIALIZER =
            SERIALIZERS.register("alloy_smelting", () -> AlloySmeltingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ThreeDPrinterRecipe>> THREE_D_PRINTING_SERIALIZER =
            SERIALIZERS.register("3d_printing", () -> ThreeDPrinterRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<PressureVesselRecipe>> DIGESTION_SERIALIZER =
            SERIALIZERS.register("digestion", () -> PressureVesselRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<ExtruderRecipe>> EXTRUSION_SERIALIZER =
            SERIALIZERS.register("extrusion", () -> ExtruderRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeSerializer<MaceratorRecipe>> MACERATOR_SERIALIZER =
            SERIALIZERS.register("maceration", () -> MaceratorRecipe.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
    }
}
