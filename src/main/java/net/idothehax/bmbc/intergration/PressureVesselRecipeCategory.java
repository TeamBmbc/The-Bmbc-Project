package net.matty.bmbc.intergration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.forge.ForgeTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.recipe.PressureVesselRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class PressureVesselRecipeCategory implements IRecipeCategory<PressureVesselRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "digestion");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(BetterMineBetterCraft.MOD_ID, "textures/gui/pressure_vessel_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public PressureVesselRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.PRESSURE_VESSEL.get()));
    }

    @Override
    public RecipeType<PressureVesselRecipe> getRecipeType() {
        return JEIBetterMineBetterCraftPlugin.DIGESTION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Pressure Vessel");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, PressureVesselRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 86, 15).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 55, 15)
                        .addIngredients(ForgeTypes.FLUID_STACK, List.of(recipe.getFluidStack()))
                        .setFluidRenderer(64000, false, 16, 61);

        builder.addSlot(RecipeIngredientRole.OUTPUT, 86, 60).addItemStack(recipe.getResultItem());
    }
}
