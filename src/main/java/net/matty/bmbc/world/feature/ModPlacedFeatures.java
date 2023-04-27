package net.matty.bmbc.world.feature;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> SILVER_PLACED_KEY = createKey("silver_ore_deposit");
    public static final ResourceKey<PlacedFeature> BAUXITE_PLACED_KEY = createKey("bauxite_ore_deposit");
    public static final ResourceKey<PlacedFeature> CARNALLITE_PLACED_KEY = createKey("carnallite_ore_placed");
    public static final ResourceKey<PlacedFeature> DOLOMITE_PLACED_KEY = createKey("dolomite_ore_placed");
    public static final ResourceKey<PlacedFeature> EVAPORITE_PLACED_KEY = createKey("evaporite_ore_placed");
    public static final ResourceKey<PlacedFeature> MAGNESITE_PLACED_KEY = createKey("magnesite_ore_placed");
    public static final ResourceKey<PlacedFeature> PEGMATITE_PLACED_KEY = createKey("pegmatite_ore_placed");
    public static final ResourceKey<PlacedFeature> PHOSPHORITE_PLACED_KEY = createKey("phosphorite_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // register placements
        register(context, SILVER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SILVER_ORE_KEY),
                commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));

        register(context, BAUXITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_BAUXITE_ORE_KEY),
                commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384))));

        register(context, CARNALLITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CARNALLITE_ORE_KEY),
                commonOrePlacement(14, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(62), VerticalAnchor.absolute(70))));

        register(context, DOLOMITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_DOLOMITE_ORE_KEY),
                commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(20), VerticalAnchor.absolute(384))));

        register(context, EVAPORITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_EVAPORITE_ORE_KEY),
                commonOrePlacement(22, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-34), VerticalAnchor.absolute(70))));

        register(context, MAGNESITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MAGNESITE_ORE_KEY),
                commonOrePlacement(16, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));

        register(context, PEGMATITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PEGMATITE_ORE_KEY),
                commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));

        register(context, PHOSPHORITE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_PHOSPHORITE_ORE_KEY),
                commonOrePlacement(18, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(384))));
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), placementModifier);
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