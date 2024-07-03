package net.matty.bmbc.worldgen.feature;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    // Ores
    public static final ResourceKey<PlacedFeature> SILVER_PLACED_KEY = createKey("silver_ore_deposit");
    public static final ResourceKey<PlacedFeature> BAUXITE_PLACED_KEY = createKey("bauxite_ore_deposit");
    public static final ResourceKey<PlacedFeature> CARNALLITE_PLACED_KEY = createKey("carnallite_ore_placed");
    public static final ResourceKey<PlacedFeature> DOLOMITE_PLACED_KEY = createKey("dolomite_ore_placed");
    public static final ResourceKey<PlacedFeature> EVAPORITE_PLACED_KEY = createKey("evaporite_ore_placed");
    public static final ResourceKey<PlacedFeature> MAGNESITE_PLACED_KEY = createKey("magnesite_ore_placed");
    public static final ResourceKey<PlacedFeature> PEGMATITE_PLACED_KEY = createKey("pegmatite_ore_placed");
    public static final ResourceKey<PlacedFeature> PHOSPHORITE_PLACED_KEY = createKey("phosphorite_ore_placed");
    public static final ResourceKey<PlacedFeature> URANITE_PLACED_KEY = createKey("uranite_ore_placed");

    // Other
    public static final ResourceKey<PlacedFeature> SILICA_SAND_PLACED_KEY = createKey("silica_sand_placed");

    // Trees
    public static final ResourceKey<PlacedFeature> MAPLE_PLACED_KEY = createKey("maple_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // register placements
        // Ores
        register(context, SILVER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));

        register(context, BAUXITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BAUXITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));

        register(context, CARNALLITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CARNALLITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(14, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(62), VerticalAnchor.absolute(70))));

        register(context, DOLOMITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_DOLOMITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(384))));

        register(context, EVAPORITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EVAPORITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(22, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-34), VerticalAnchor.absolute(70))));

        register(context, MAGNESITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MAGNESITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(16, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));

        register(context, PEGMATITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PEGMATITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));

        register(context, PHOSPHORITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PHOSPHORITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));

        register(context, URANITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_URANITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(13, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));

        // Trees
        register(context, MAPLE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAPLE_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(2, 0.1f, 2), ModBlocks.MAPLE_SAPLING.get()));

        // Other
        register(context, SILICA_SAND_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILICA_SAND_KEY),
                ModOrePlacement.commonOrePlacement(8, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(384))));
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(BetterMineBetterCraft.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}