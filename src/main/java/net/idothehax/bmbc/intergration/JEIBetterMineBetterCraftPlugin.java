package net.matty.bmbc.intergration;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.recipe.*;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIBetterMineBetterCraftPlugin implements IModPlugin {
    public static RecipeType<AlloySmeltingRecipe> ALLOY_SMELTING_TYPE = new RecipeType<>(AlloySmeltingRecipeCategory.UID, AlloySmeltingRecipe.class);
    public static RecipeType<PressureVesselRecipe> DIGESTION_TYPE = new RecipeType<>(PressureVesselRecipeCategory.UID, PressureVesselRecipe.class);
    public static RecipeType<ExtruderRecipe> EXTRUSION_TYPE = new RecipeType<>(ExtruderRecipeCategory.UID, ExtruderRecipe.class);
    public static RecipeType<MaceratorRecipe> MACERATION_TYPE = new RecipeType<>(MaceratorRecipeCategory.UID, MaceratorRecipe.class);
    public static RecipeType<ThreeDPrinterRecipe> THREE_D_PRINTING_TYPE = new RecipeType<>(ThreeDPrinterRecipeCategory.UID, ThreeDPrinterRecipe.class);

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(BetterMineBetterCraft.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new AlloySmeltingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ExtruderRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new MaceratorRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new PressureVesselRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new ThreeDPrinterRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<ThreeDPrinterRecipe> recipes3dPrinting = rm.getAllRecipesFor(ThreeDPrinterRecipe.Type.INSTANCE);
        List<AlloySmeltingRecipe> recipesAlloySmelting = rm.getAllRecipesFor(AlloySmeltingRecipe.Type.INSTANCE);
        List<PressureVesselRecipe> recipesDigestion = rm.getAllRecipesFor(PressureVesselRecipe.Type.INSTANCE);
        List<ExtruderRecipe> recipesExtrusion = rm.getAllRecipesFor(ExtruderRecipe.Type.INSTANCE);
        List<MaceratorRecipe> recipesMaceration = rm.getAllRecipesFor(MaceratorRecipe.Type.INSTANCE);

        registration.addRecipes(ALLOY_SMELTING_TYPE, recipesAlloySmelting);
        registration.addRecipes(DIGESTION_TYPE, recipesDigestion);
        registration.addRecipes(EXTRUSION_TYPE, recipesExtrusion);
        registration.addRecipes(MACERATION_TYPE, recipesMaceration);
        registration.addRecipes(THREE_D_PRINTING_TYPE, recipes3dPrinting);

    }
}
