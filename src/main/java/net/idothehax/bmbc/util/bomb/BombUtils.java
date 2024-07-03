package net.matty.bmbc.util.bomb;


// lots of blocks missing
// Property of Siepert
public class BombUtils {
    public static void advancedExplosion(Level pLevel, int x, int y, int z, int radius, boolean nuclearLike) {
        if (!pLevel.isClientSide()) {
            Block air = Blocks.AIR;
            /*List<Block> carbon_ore_replaceable = List.of(Blocks.COAL_ORE, Blocks.DEEPSLATE_COAL_ORE,
                    Blocks.DIAMOND_ORE, Blocks.DEEPSLATE_DIAMOND_ORE,
                    Blocks.EMERALD_ORE, Blocks.DEEPSLATE_EMERALD_ORE,
                    ModBlocks.NUCLEAR_DIAMOND_ORE_REMAINS.get(), ModBlocks.NUCLEAR_EMERALD_ORE_REMAINS.get(),
                    ModBlocks.HOT_NUCLEAR_DIAMOND_ORE_REMAINS.get(), ModBlocks.HOT_
                    NUCLEAR_EMERALD_ORE_REMAINS.get());
            List<Block> carbon_ore_replacers = List.of(ModBlocks.NUCLEAR_DIAMOND_ORE_REMAINS.get(), ModBlocks.NUCLEAR_EMERALD_ORE_REMAINS.get(),
                    ModBlocks.NUCLEAR_DIAMOND_ORE_REMAINS.get(), ModBlocks.NUCLEAR_DIAMOND_ORE_REMAINS.get());
            List<Block> hot_carbon_ore_replacers = List.of(ModBlocks.HOT_NUCLEAR_DIAMOND_ORE_REMAINS.get(),
                    ModBlocks.HOT_NUCLEAR_EMERALD_ORE_REMAINS.get(),
                    ModBlocks.HOT_NUCLEAR_DIAMOND_ORE_REMAINS.get(),
                    ModBlocks.HOT_NUCLEAR_DIAMOND_ORE_REMAINS.get());*/ 
            List<Block> non_replaceable = List.of(Blocks.BEDROCK, Blocks.OBSIDIAN, ModBlocks.OBSIDIAN_GRAVEL.get(),
                    ModBlocks.CONCRETE.get(), ModBlocks.CONCRETE_BRICKS.get(), Blocks.WATER,
                    Blocks.LAVA, Blocks.OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.SPRUCE_LEAVES,
                    Blocks.JUNGLE_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES,
                    Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.MANGROVE_LEAVES,
                    Blocks.CHERRY_LEAVES, ModBlocks.FOUNDATION_CONCRETE.get(), ModBlocks.WATER_SEAL_HATCH.get(),
                    ModBlocks.STEEL_REINFORCED_GLASS.get());
            List<Block> replacers = List.of(ModBlocks.NUCLEAR_REMAINS.get());
            List<Block> hot_replacers = List.of(ModBlocks.HOT_NUCLEAR_REMAINS.get());
            List<Block> instant_evaporate = List.of(Blocks.WATER, Blocks.OAK_LEAVES, Blocks.BIRCH_LEAVES, Blocks.SPRUCE_LEAVES,
                    Blocks.JUNGLE_LEAVES, Blocks.AZALEA_LEAVES, Blocks.FLOWERING_AZALEA_LEAVES, Blocks.TALL_SEAGRASS,
                    Blocks.ACACIA_LEAVES, Blocks.DARK_OAK_LEAVES, Blocks.MANGROVE_LEAVES, Blocks.SEAGRASS,
                    Blocks.CHERRY_LEAVES, Blocks.KELP, Blocks.KELP_PLANT, Blocks.DRIED_KELP_BLOCK, Blocks.SNOW,
                    Blocks.SNOW_BLOCK, Blocks.POWDER_SNOW, Blocks.VINE,
                    Blocks.ICE, Blocks.PACKED_ICE, Blocks.BLUE_ICE);
            List<Block> charred_log_replaceable = List.of(Blocks.ACACIA_LOG, Blocks.BIRCH_LOG, Blocks.CHERRY_LOG, // dead varients
                    Blocks.JUNGLE_LOG, Blocks.MANGROVE_LOG, Blocks.DARK_OAK_LOG, Blocks.OAK_LOG,
                    Blocks.SPRUCE_LOG,
                    Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_CHERRY_LOG,
                    Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_DARK_OAK_LOG,
                    Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_SPRUCE_LOG);
            List<Block> charred_logs = List.of(ModBlocks.CHARRED_LOG.get(), ModBlocks.SMOULDERING_LOG.get(), ModBlocks.CHARRED_LOG.get()); // dead vareints
            Random random = new Random();
            assertValidRadius(radius);

            double h;
            double dist;
            BlockPos pos;
            for (int i = -radius; i <= radius; i++) {
                for (int j = -radius; j <= radius; j++) {
                    for (int k = radius; k >= -radius; k--) {
                        pos = new BlockPos(x + i, y + k, z + j);
                        if (pLevel.getBlockState(pos).getBlock() != Blocks.AIR && pLevel.getBlockState(pos).getBlock() != Blocks.BEDROCK) {
                            h = Math.sqrt(i * i + j * j);
                            dist = Math.sqrt(h * h + (k * k * 2));
                            if (dist <= radius && noReinforcersAbove(pLevel, pos)) {
                                pLevel.setBlock(pos, air.defaultBlockState(), 3);
                            }
                        }
                    }
                }
            }
            if (nuclearLike) {
                for (int i = -radius * 3; i <= radius * 3; i++) {
                    for (int j = -radius * 3; j <= radius * 3; j++) {
                        for (int k = radius * 3; k >= -radius * 3; k--) {
                            pos = new BlockPos(x + i, y + k, z + j);
                            if (instant_evaporate.contains(pLevel.getBlockState(pos).getBlock())) {
                                h = Math.sqrt(i * i + j * j);
                                dist = Math.sqrt(h * h + (k * k * 2));
                                if (dist <= radius * 3 && noReinforcersAbove(pLevel, pos)) {
                                    pLevel.setBlock(pos, air.defaultBlockState(), 3);
                                }
                            }
                        }
                    }
                }
                for (int i = -radius * 4; i <= radius * 4; i++) {
                    for (int j = -radius * 4; j <= radius * 4; j++) {
                        for (int k = radius * 4; k >= -radius * 4; k--) {
                            pos = new BlockPos(x + i, y + k, z + j);
                            if (charred_log_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                h = Math.sqrt(i * i + j * j);
                                dist = Math.sqrt(h * h + (k * k * 2));
                                if (dist <= radius * 4 && noReinforcersAbove(pLevel, pos)) {
                                    pLevel.setBlock(pos, charred_logs.get(random.nextInt(charred_logs.size())).defaultBlockState(), 3);
                                }
                            }
                        }
                    }
                }
                for (int i = -radius * 4; i <= radius * 4; i++) {
                    for (int j = -radius * 4; j <= radius * 4; j++) {
                        for (int k = radius * 4; k >= -radius * 4; k--) {
                            pos = new BlockPos(x + i, y + k, z + j);
                            if (pLevel.getBlockState(pos).getBlock() == Blocks.GRASS_BLOCK) {
                                h = Math.sqrt(i * i + j * j);
                                dist = Math.sqrt(h * h + (k * k * 2));
                                if (dist <= radius * 4 && noReinforcersAbove(pLevel, pos)) {
                                    pLevel.setBlock(pos, Blocks.DIRT_PATH.defaultBlockState(), 3);
                                }
                            }
                        }
                    }
                }
                for (int i = -radius * 3; i <= radius * 3; i++) {
                    for (int j = -radius * 3; j <= radius * 3; j++) {
                        for (int k = radius * 3; k >= -radius * 3; k--) {
                            pos = new BlockPos(x + i, y + k, z + j);
                            if (pLevel.getBlockState(pos).getBlock() == Blocks.WATER) {
                                h = Math.sqrt(i * i + j * j);
                                dist = Math.sqrt(h * h + (k * k * 2));
                                if (dist <= radius * 3 && noReinforcersAbove(pLevel, pos)) {
                                    pLevel.setBlock(pos, air.defaultBlockState(), 3);
                                }
                            }
                        }
                    }
                }
                for (int i = -radius * 2; i <= radius * 2; i++) {
                    for (int j = -radius * 2; j <= radius * 2; j++) {
                        for (int k = radius * 2; k >= -radius * 2; k--) {
                            pos = new BlockPos(x + i, y + k - 1, z + j);
                            h = Math.sqrt(i * i + j * j);
                            dist = Math.sqrt(h * h + (k * k * 2));
                            if (pLevel.getBlockState(pos).getBlock() != air && pLevel.getBlockState(pos).getBlock() != Blocks.BEDROCK) {
                                if (dist <= radius * 2 && noReinforcersAbove(pLevel, pos) && pLevel.getBlockState(pos.above()).getBlock() == air) {
                                    if (!non_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                        if (carbon_ore_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                            if (dist >= radius + 3) {
                                                pLevel.setBlock(pos, carbon_ore_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            } else {
                                                pLevel.setBlock(pos, hot_carbon_ore_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            }
                                        } else {
                                            if (dist >= radius + 3) {
                                                pLevel.setBlock(pos, replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            } else {
                                                pLevel.setBlock(pos, hot_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            }
                                        }
                                    }
                                }
                            }
                            pos = new BlockPos(x + i, y + k - 2, z + j);
                            if (pLevel.getBlockState(pos).getBlock() != air && pLevel.getBlockState(pos).getBlock() != Blocks.BEDROCK) {
                                if (dist <= radius * 2 && noReinforcersAbove(pLevel, pos) && pLevel.getBlockState(pos.above(2)).getBlock() == air) {
                                    if (!non_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                        if (carbon_ore_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                            if (dist >= radius + 3) {
                                                pLevel.setBlock(pos, carbon_ore_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            } else {
                                                pLevel.setBlock(pos, hot_carbon_ore_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            }
                                        } else {
                                            if (dist >= radius + 3) {
                                                pLevel.setBlock(pos, replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            } else {
                                                pLevel.setBlock(pos, hot_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            }
                                        }
                                    }
                                }
                            }
                            pos = new BlockPos(x + i, y + k - 3, z + j);
                            if (pLevel.getBlockState(pos).getBlock() != air && pLevel.getBlockState(pos).getBlock() != Blocks.BEDROCK) {
                                if (dist <= radius && noReinforcersAbove(pLevel, pos) && pLevel.getBlockState(pos.above(3)).getBlock() == air) {
                                    if (!non_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                        if (carbon_ore_replaceable.contains(pLevel.getBlockState(pos).getBlock())) {
                                            if (dist >= radius + 3) {
                                                pLevel.setBlock(pos, carbon_ore_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            } else {
                                                pLevel.setBlock(pos, hot_carbon_ore_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            }
                                        } else {
                                            if (dist >= radius + 3) {
                                                pLevel.setBlock(pos, replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            } else {
                                                pLevel.setBlock(pos, hot_replacers.get(random.nextInt(replacers.size())).defaultBlockState(), 3);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void createMushroomCloud(Level pLevel, int x, int y, int z, float pYield, boolean pSoulLike) {
        ParticleOptions smokePart;
        ParticleOptions ring = ModParticles.SMOKE_PARTICLES.get();
        ParticleOptions fireSmokePart;
        ParticleOptions hugeFireSmoke = ModParticles.HUGE_FIRE_SMOKE_PARTICLES.get();
        float yieldMult;
        boolean isRelativelySmall = pYield <= 5;
        boolean isRelativelyBig = pYield >= 40;
        if (isRelativelySmall) {
            smokePart = ModParticles.SMOKE_PARTICLES.get();
            if (pSoulLike) fireSmokePart = ModParticles.SOULFIRE_SMOKE_PARTICLES.get();
            else fireSmokePart = ModParticles.FIRE_SMOKE_PARTICLES.get();
        } else {
            if (isRelativelyBig) {
                smokePart = ModParticles.GIANT_SMOKE_PARTICLES.get();
                if (pSoulLike) fireSmokePart = ModParticles.GIANT_SOULFIRE_SMOKE_PARTICLES.get();
                else fireSmokePart = ModParticles.GIANT_FIRE_SMOKE_PARTICLES.get();
                ring = ModParticles.HUGE_SMOKE_PARTICLES.get();
            } else {
                smokePart = ModParticles.HUGE_SMOKE_PARTICLES.get();
                if (pSoulLike) fireSmokePart = ModParticles.HUGE_SOULFIRE_SMOKE_PARTICLES.get();
                else fireSmokePart = ModParticles.HUGE_FIRE_SMOKE_PARTICLES.get();
            }
        }

        double degreePerPart = 1;
        if (pYield >= 40) {
            degreePerPart /= pYield / 20;
        }
        double yaw = 0;
        double pitch = 90;
        double xExtend;
        double yExtend;
        double zExtend;
        double xVelocity;
        double yVelocity;
        double zVelocity;
        //the part where the shockwave is made
        while (yaw <= 360) {
            xExtend = MathUtils.getRelative("x", yaw, pitch, 1);
            zExtend = MathUtils.getRelative("z", yaw, pitch, 1);
            xVelocity = MathUtils.getRelative("x", yaw, pitch, pYield / 3);
            zVelocity = MathUtils.getRelative("z", yaw, pitch, pYield / 3);
            pLevel.addParticle(smokePart, x + xExtend + 0.5, y + 0.5, z + zExtend + 0.5, xVelocity, 0, zVelocity);
            pLevel.addParticle(smokePart, x + xExtend + 0.5, y + 0.5, z + zExtend + 0.5, xVelocity * 2, 0, zVelocity * 2);
            pLevel.addParticle(smokePart, x + xExtend + 0.5, y + 0.5, z + zExtend + 0.5, xVelocity * 3, 0, zVelocity * 3);
            yaw += degreePerPart;
        }
        yaw = 0;
        //the mushroom stem (cope seethe mald small cloud)
        //TODO: make the thing work
        float thing = 1;
        if (isRelativelySmall) thing = 0.05f;
        for (float i = 0; i <= pYield*2; i+=thing) {
            pLevel.addParticle(fireSmokePart, x + 0.5, y + 0.5, z + 0.5, 0, i / 2, 0);
            pLevel.addParticle(fireSmokePart, x + 1.5, y + 0.5, z + 0.5, 0, i / 2, 0);
            pLevel.addParticle(fireSmokePart, x + 0.5, y + 0.5, z + 1.5, 0, i / 2, 0);
            pLevel.addParticle(fireSmokePart, x - 0.5, y + 0.5, z + 0.5, 0, i / 2, 0);
            pLevel.addParticle(fireSmokePart, x + 0.5, y + 0.5, z - 0.5, 0, i / 2, 0);
        }
        //the mushroom top
        pitch = 0;
        while (yaw <= 360) {
            while (pitch <= 180) {
                xExtend = MathUtils.getRelative("x", yaw, pitch, 1);
                yExtend = MathUtils.getRelative("y", yaw, pitch, 0.5f);
                zExtend = MathUtils.getRelative("z", yaw, pitch, 1);
                xVelocity = MathUtils.getRelative("x", yaw, pitch, pYield / 3);
                yVelocity = MathUtils.getRelative("y", yaw, pitch, pYield / 12);
                zVelocity = MathUtils.getRelative("z", yaw, pitch, pYield / 3);
                pLevel.addParticle(fireSmokePart, x + xExtend + 0.5, y + yExtend + 0.5 + pYield * 5.5, z + zExtend + 0.5, xVelocity, yVelocity, zVelocity);
                pLevel.addParticle(fireSmokePart, x + xExtend + 0.5, y + yExtend + 0.5 + pYield * 5.5, z + zExtend + 0.5, xVelocity, yVelocity, zVelocity);
                pLevel.addParticle(fireSmokePart, x + xExtend + 0.5, y + yExtend + 0.5 + pYield * 5.5, z + zExtend + 0.5, xVelocity, yVelocity, zVelocity);
                pitch += degreePerPart * 10;
            }
            pitch = 0;
            yaw += degreePerPart * 10;
        }
        //the stereotypical ring
        yaw = 0;
        pitch = 90;
        while (yaw <= 360) {
            xExtend = MathUtils.getRelative("x", yaw, pitch, 1);
            zExtend = MathUtils.getRelative("z", yaw, pitch, 1);
            xVelocity = MathUtils.getRelative("x", yaw, pitch, pYield / 3);
            zVelocity = MathUtils.getRelative("z", yaw, pitch, pYield / 3);
            yieldMult = 1;
            if (isRelativelySmall) yieldMult = 0.5f;
            pLevel.addParticle(ring, x + xExtend + 0.5, y + 0.5 + pYield*4, z + zExtend + 0.5, xVelocity*yieldMult, 0, zVelocity*yieldMult);
            yaw += degreePerPart;
        }
    }
}
