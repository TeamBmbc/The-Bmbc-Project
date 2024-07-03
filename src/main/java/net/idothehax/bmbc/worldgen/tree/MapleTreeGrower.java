package net.matty.bmbc.worldgen.tree;

import net.matty.bmbc.worldgen.feature.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

public class MapleTreeGrower extends AbstractTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource pRandom, boolean pHasFlowers) {
        return ModConfiguredFeatures.MAPLE_KEY;
    }
}
