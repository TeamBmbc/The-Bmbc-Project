package net.matty.bmbc.worldgen.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    // Ores
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILVER_ORE_KEY = registerKey("add_silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_BAUXITE_ORE_KEY = registerKey("add_bauxite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CARNALLITE_ORE_KEY = registerKey("add_carnallite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_DOLOMITE_ORE_KEY = registerKey("add_dolomite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EVAPORITE_ORE_KEY = registerKey("add_evaporite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MAGNESITE_ORE_KEY = registerKey("add_magnesite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PEGMATITE_ORE_KEY = registerKey("add_pegmatite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PHOSPHORITE_ORE_KEY = registerKey("add_phosphorite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_URANITE_ORE_KEY = registerKey("add_uranite_ore");

    // Trees
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAPLE_KEY = registerKey("maple");

    // Other
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SILICA_SAND_KEY = registerKey("add_silica_sand");

    //public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCON_GEODE_KEY = registerKey("zircon_geode");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.BASE_STONE_OVERWORLD);

        List<OreConfiguration.TargetBlockState> bauxiteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.BAUXITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> carnalliteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.CARNALLITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> dolomiteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.DOLOMITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> evaporiteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.EVAPORITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> magnesiteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.MAGNESITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> pegmatiteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.PEGMATITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> phosphoriteOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.PHOSPHORITE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> silverOres = List.of(OreConfiguration.target(stoneReplaceables,
                        ModBlocks.SILVER_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> uraniteOres = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.URANITE_ORE.get().defaultBlockState()));


        // Other
        List<OreConfiguration.TargetBlockState> silicaSand = List.of(OreConfiguration.target(stoneReplaceables,
                ModBlocks.SILICA_SAND.get().defaultBlockState()));


        // register keys
        // Ores
        register(context, OVERWORLD_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(silverOres, 26));
        register(context, OVERWORLD_BAUXITE_ORE_KEY, Feature.ORE, new OreConfiguration(bauxiteOres, 26));
        register(context, OVERWORLD_CARNALLITE_ORE_KEY, Feature.ORE, new OreConfiguration(carnalliteOres, 8));
        register(context, OVERWORLD_DOLOMITE_ORE_KEY, Feature.ORE, new OreConfiguration(dolomiteOres, 10));
        register(context, OVERWORLD_EVAPORITE_ORE_KEY, Feature.ORE, new OreConfiguration(evaporiteOres, 9));
        register(context, OVERWORLD_MAGNESITE_ORE_KEY, Feature.ORE, new OreConfiguration(magnesiteOres, 11));
        register(context, OVERWORLD_PEGMATITE_ORE_KEY, Feature.ORE, new OreConfiguration(pegmatiteOres, 11));
        register(context, OVERWORLD_PHOSPHORITE_ORE_KEY, Feature.ORE, new OreConfiguration(phosphoriteOres, 11));
        register(context, OVERWORLD_URANITE_ORE_KEY, Feature.ORE, new OreConfiguration(uraniteOres, 5));

        // Trees
        register(context, MAPLE_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.MAPLE_LOG.get()), // this is our log
                new StraightTrunkPlacer(5, 6, 3), // placing the truck
                BlockStateProvider.simple(ModBlocks.MAPLE_LEAVES.get()), // place leaves in block foliage
                new BlobFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 4),
                new TwoLayersFeatureSize(1, 0, 1)).build()); // Spawning

        // Other
        register(context, OVERWORLD_SILICA_SAND_KEY, Feature.ORE, new OreConfiguration(silicaSand, 22));
    }

    // Ore configuration
    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILVER_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SILVER_ORE.get().defaultBlockState()),
            OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES), ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_BAUXITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.BAUXITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_CARNALLITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.CARNALLITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_DOLOMITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.DOLOMITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_EVAPORITE_ORES = Suppliers.memoize(() -> List.of(
               OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.EVAPORITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_MAGNESITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.MAGNESITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PEGMATITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.PEGMATITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PHOSPHORITE_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.PHOSPHORITE_ORE.get().defaultBlockState())
    ));

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_SILICA_SAND_ORES = Suppliers.memoize(() -> List.of(
            OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES), ModBlocks.SILICA_SAND.get().defaultBlockState())
    ));

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(BetterMineBetterCraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
