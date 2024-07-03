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
import net.matty.bmbc.recipe.ExtruderRecipe;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class ExtruderRecipeCategory implements IRecipeCategory<ExtruderRecipe> {
    public final static ResourceLocation UID = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "extrusion");
    public final static ResourceLocation TEXTURE =
            new ResourceLocation(BetterMineBetterCraft.MOD_ID, "textures/gui/extruder_gui.png");

    private final IDrawable background;
    private final IDrawable icon;

    public ExtruderRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.EXTRUDER.get()));
    }

    @Override
    public RecipeType<ExtruderRecipe> getRecipeType() {
        return JEIBetterMineBetterCraftPlugin.EXTRUSION_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.literal("Extruder");
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
    public void setRecipe(IRecipeLayoutBuilder builder, ExtruderRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 42, 36).addIngredients(recipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.INPUT, 63, 36).addIngredients(recipe.getIngredients().get(1));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 105, 36).addItemStack(recipe.getResultItem());
    }
}
