//package net.matty.bmbc.recipe;
//
//import com.google.common.collect.Lists;
//import com.google.common.collect.Maps;
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.CriterionTriggerInstance;
//import net.minecraft.data.recipes.*;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.TagKey;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.crafting.CraftingBookCategory;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.minecraft.world.level.ItemLike;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//import java.util.Map;
//import java.util.function.Consumer;
//
//public class ThreeDPrinterRecipeBuilder implements RecipeBuilder {
//    private final RecipeCategory category;
//    private final Item result;
//    private final int count;
//    private final List<String> rows = Lists.newArrayList();
//    private final Map<Character, Ingredient> key = Maps.newLinkedHashMap();
//    private final Advancement.Builder advancement = Advancement.Builder.advancement();
//    @Nullable
//    private String group;
//
//    public ThreeDPrinterRecipeBuilder(RecipeCategory pCategory, ItemLike pResult, int pCount) {
//        this.category = pCategory;
//        this.result = pResult.asItem();
//        this.count = pCount;
//    }
//
//    /**
//     * Creates a new builder for a 3D printed recipe with 1 item as output
//     **/
//    public static ThreeDPrinterRecipeBuilder printed(RecipeCategory pCategory, ItemLike pResult) {
//        return printed(pCategory, pResult, 1);
//    }
//
//    /**
//     * Creates a new builder for a 3D printed recipe
//     **/
//    public static ThreeDPrinterRecipeBuilder printed(RecipeCategory pCategory, ItemLike pResult, int pCount) {
//        return printed(pCategory, pResult, pCount);
//    }
//
//    public ThreeDPrinterRecipeBuilder define(Character pSymbol, TagKey<Item> pTag) {
//        return this.define(pSymbol, Ingredient.of(pTag));
//    }
//
//    public ThreeDPrinterRecipeBuilder define(Character pSymbol, ItemLike pItem) {
//        return this.define(pSymbol, Ingredient.of(pItem));
//    }
//
//    public ShapedRecipeBuilder define(Character pSymbol, Ingredient pIngredient) {
//        if (this.key.containsKey(pSymbol)) {
//            throw new IllegalArgumentException("Symbol '" + pSymbol + "' is already defined!");
//        } else if (pSymbol == ' ') {
//            throw new IllegalArgumentException("Symbol ' ' (whitespace) is reserved and cannot be defined");
//        } else {
//            this.key.put(pSymbol, pIngredient);
//            return this;
//        }
//    }
//
//    @Override
//    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
//        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
//        return this;
//    }
//
//    @Override
//    public RecipeBuilder group(@Nullable String pGroupName) {
//        this.group = pGroupName;
//        return this;
//    }
//
//    @Override
//    public Item getResult() {
//        return this.result;
//    }
//
//    public static class Result {
//        private final ResourceLocation id;
//        private final Item result;
//        private final int count;
//        private final String group;
//        private final List<String> pattern;
//        private final Map<Character, Ingredient> key;
//        private final Advancement.Builder advancement;
//        private final ResourceLocation advancementId;
//
//        public Result(ResourceLocation pId, Item pResult, int pCount, String pGroup, CraftingBookCategory pCategory, List<String> pPattern, Map<Character, Ingredient> pKey, Advancement.Builder pAdvancement, ResourceLocation pAdvancementId) {
//            super(pCategory);
//            this.id = pId;
//            this.result = pResult;
//            this.count = pCount;
//            this.group = pGroup;
//            this.pattern = pPattern;
//            this.key = pKey;
//            this.advancement = pAdvancement;
//            this.advancementId = pAdvancementId;
//        }
//    }
//}
