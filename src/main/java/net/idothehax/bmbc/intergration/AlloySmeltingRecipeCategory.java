package net.matty.bmbc.intergration;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.recipe.AlloySmeltingRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class AlloySmeltingRecipeCategory implements IRecipeCategory<AlloySmeltingRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "alloy_smelting");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(BetterMineBetterCraft.MOD_ID, "textures/gui/alloy_furnace_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public AlloySmeltingRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ALLOY_FURNACE.get()));
    }

    @Override
    public RecipeType<AlloySmeltingRecipe> getRecipeType() {
        return JEIBetterMineBetterCraftPlugin.ALLOY_SMELTING_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Alloy Smelting");
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
    public void setRecipe(IRecipeLayoutBuilder builder, AlloySmeltingRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 35, 9).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 53, 9).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 105, 36).addItemStack(recipe.getResultItem());
    }
}
