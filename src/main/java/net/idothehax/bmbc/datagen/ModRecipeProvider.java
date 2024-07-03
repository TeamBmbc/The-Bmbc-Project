package net.matty.bmbc.datagen;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.ModMachineComponents;
import net.matty.bmbc.item.ModMineralItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {


        //nineBlockStorageRecipes(consumer, RecipeCategory.MISC, ModMineralItems.SILVER.get(), RecipeCategory.MISC,
        //        ModBlocks.SILVER_BLOCK.get());

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MAPLE_PLANKS.get())
                .requires(ModBlocks.MAPLE_LOG.get())
                .unlockedBy("has_maple_log", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModBlocks.MAPLE_PLANKS.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModMachineComponents.COPPER_COIL.get()).group("machine_components")
                .define('#', ModMachineComponents.COPPER_WIRE.get())
                .define('R', ModItems.CABLE_ROLL.get())
                .pattern("###")
                .pattern("#R#")
                .pattern("###")
                .unlockedBy("has_cable_roll", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CABLE_ROLL.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CABLE_ROLL.get()).group("machine_components")
                .define('P', Blocks.OAK_PLANKS)
                .define('S', Items.STICK)
                .pattern("P P")
                .pattern("PSP")
                .pattern("P P")
                .unlockedBy("has_planks", has(ModBlocks.MAPLE_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, Items.STICK, 4).group("sticks")
                .define('#', ModBlocks.MAPLE_PLANKS.get())
                .pattern("#")
                .pattern("#")
                .unlockedBy("has_maple_planks", has(ModBlocks.MAPLE_PLANKS.get()))
                .save(consumer, "stick_from_maple_planks");

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RED_PRINTER_FILAMENT.get()).group("printing_filament")
                .define('R', ModItems.CABLE_ROLL.get())
                .define('D', Items.RED_DYE)
                .define('P', ModItems.PVC_PLASTIC.get())
                .pattern("RP")
                .pattern("D ")
                .unlockedBy("has_cable_roll", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CABLE_ROLL.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLUE_PRINTER_FILAMENT.get()).group("printing_filament")
                .define('R', ModItems.CABLE_ROLL.get())
                .define('D', Items.BLUE_DYE)
                .define('P', ModItems.PVC_PLASTIC.get())
                .pattern("RP")
                .pattern("D ")
                .unlockedBy("has_cable_roll", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CABLE_ROLL.get()).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GREEN_PRINTER_FILAMENT.get()).group("printing_filament")
                .define('R', ModItems.CABLE_ROLL.get())
                .define('D', Items.GREEN_DYE)
                .define('P', ModItems.PVC_PLASTIC.get())
                .pattern("RP")
                .pattern("D ")
                .unlockedBy("has_cable_roll", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModItems.CABLE_ROLL.get()).build()))
                .save(consumer);

        // Machine Components
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModMachineComponents.ELECTRIC_MOTOR.get()).group("machine_components")
                .define('W', ModMachineComponents.COPPER_WIRE.get())
                .define('M', ModMineralItems.MAGNETIC_IRON_INGOT.get())
                .define('I', ModMachineComponents.IRON_ROD.get())
                .define('R', ModMachineComponents.MAGNETIC_IRON_ROD.get())
                .pattern("MWI")
                .pattern("WRW")
                .pattern("IWM")
                .unlockedBy("has_copper_wire", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ModMachineComponents.COPPER_WIRE.get()).build()))
                .save(consumer);
    }

    //protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
    //    oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    //}

    //protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
    //    for(ItemLike itemlike : pIngredients) {
    //        SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike)).save(pFinishedRecipeConsumer, new ResourceLocation(BetterMineBetterCraft.MOD_ID, getItemName(pResult)) + pRecipeName + "_" + getItemName(itemlike));
    //    }

    //}

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeCategory pUnpackedCategory, ItemLike pUnpacked, RecipeCategory pPackedCategory, ItemLike pPacked) {
        nineBlockStorageRecipes(pFinishedRecipeConsumer, pUnpackedCategory, pUnpacked, pPackedCategory, pPacked, getSimpleRecipeName(pPacked), (String)null, getSimpleRecipeName(pUnpacked), (String)null);
    }

    protected static void nineBlockStorageRecipes(Consumer<FinishedRecipe> pFinishedRecipeConsumer,
                                                  RecipeCategory pUnpackedCategory,
                                                  ItemLike pUnpacked,
                                                  RecipeCategory pPackedCategory,
                                                  ItemLike pPacked,
                                                  String pPackedName,
                                                  @Nullable String pPackedGroup,
                                                  String pUnpackedName,
                                                  @Nullable String pUnpackedGroup) {

        ShapelessRecipeBuilder.shapeless(pUnpackedCategory, pUnpacked, 9)
                .requires(pPacked)
                .group(pUnpackedGroup)
                .unlockedBy(getHasName(pPacked), has(pPacked))
                .save(pFinishedRecipeConsumer, new ResourceLocation(BetterMineBetterCraft.MOD_ID, pUnpackedName));

        ShapedRecipeBuilder.shaped(pPackedCategory, pPacked)
                .define('#', pUnpacked)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .group(pPackedGroup)
                .unlockedBy(getHasName(pUnpacked), has(pUnpacked))
                .save(pFinishedRecipeConsumer, new ResourceLocation(BetterMineBetterCraft.MOD_ID, pPackedName));
    }
}
