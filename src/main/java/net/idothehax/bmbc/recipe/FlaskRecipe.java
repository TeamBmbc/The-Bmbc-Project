//package net.matty.bmbc.recipe;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
//import net.matty.bmbc.BetterMineBetterCraft;
//import net.minecraft.core.NonNullList;
//import net.minecraft.core.RegistryAccess;
//import net.minecraft.network.FriendlyByteBuf;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.util.GsonHelper;
//import net.minecraft.world.SimpleContainer;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.crafting.*;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.common.crafting.conditions.ICondition;
//import org.jetbrains.annotations.Nullable;
//
//public class FlaskRecipe implements Recipe<SimpleContainer> {
//    private final ResourceLocation id;
//    private final ItemStack output;
//    private final NonNullList<Ingredient> recipeItems;
//
//    public FlaskRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
//        this.id = id;
//        this.output = output;
//        this.recipeItems = recipeItems;
//    }
//
//    @Override
//    public boolean matches(SimpleContainer pContainer, Level pLevel) {
//        if (pLevel.isClientSide()) {
//            return false;
//        }
//
//        if (recipeItems.get(0).test(pContainer.getItem(0)) && recipeItems.get(1).test(pContainer.getItem(1))) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    @Override
//    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess registryAccess) {
//        return output;
//    }
//
//    @Override
//    public NonNullList<Ingredient> getIngredients() {
//        return recipeItems;
//    }
//
//
//    @Override
//    public boolean canCraftInDimensions(int pWidth, int pHeight) {
//        return true;
//    }
//
//    @Override
//    public ItemStack getResultItem(RegistryAccess access) {
//        return output.copy();
//    }
//
//    @Override
//    public ResourceLocation getId() {
//        return id;
//    }
//
//    @Override
//    public RecipeSerializer<?> getSerializer() {
//        return Serializer.INSTANCE;
//    }
//
//    @Override
//    public RecipeType<?> getType() {
//        return Type.INSTANCE;
//    }
//
//    public static class Type implements RecipeType<FlaskRecipe> {
//        private Type() {
//        }
//
//        public static final Type INSTANCE = new Type();
//        public static final String ID = "extrusion";
//    }
//
//    public static class Serializer implements RecipeSerializer<FlaskRecipe> {
//        public static final Serializer INSTANCE = new Serializer();
//        public static final ResourceLocation ID =
//                new ResourceLocation(BetterMineBetterCraft.MOD_ID, "extrusion");
//
//        @Override
//        public FlaskRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
//            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
//
//            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
//            NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);
//
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
//            }
//
//            return new FlaskRecipe(pRecipeId, output, inputs);
//        }
//
//        @Override
//        public @Nullable FlaskRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
//            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
//
//            for (int i = 0; i < inputs.size(); i++) {
//                inputs.set(i, Ingredient.fromNetwork(buf));
//            }
//
//            ItemStack output = buf.readItem();
//            return new FlaskRecipe(id, output, inputs);
//        }
//
//        @Override
//        public FlaskRecipe fromJson(ResourceLocation recipeLoc, JsonObject recipeJson, ICondition.IContext context) {
//            return RecipeSerializer.super.fromJson(recipeLoc, recipeJson, context);
//        }
//
//        public Serializer() {
//            super();
//        }
//
//        @Override
//        public int hashCode() {
//            return super.hashCode();
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            return super.equals(obj);
//        }
//
//        @Override
//        protected Object clone() throws CloneNotSupportedException {
//            return super.clone();
//        }
//
//        @Override
//        public String toString() {
//            return super.toString();
//        }
//
//        @Override
//        protected void finalize() throws Throwable {
//            super.finalize();
//        }
//
//        @Override
//        public void toNetwork(FriendlyByteBuf buf, FlaskRecipe recipe) {
//            buf.writeInt(recipe.getIngredients().size());
//
//            for (Ingredient ing : recipe.getIngredients()) {
//                ing.toNetwork(buf);
//            }
//            buf.writeItemStack(recipe.output, false);
//        }
//
//    }
//}
//