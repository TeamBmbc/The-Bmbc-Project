package net.matty.bmbc.block;

import com.google.common.collect.ImmutableList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.ExplosionDamageCalculator;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.Optional;

public class NuclearBombBlock extends Block {
    public static final int MIN_FUELLING = 0;
    public static final int MAX_FUELLING = 4;
    public static final IntegerProperty CHARGE = BlockStateProperties.RESPAWN_ANCHOR_CHARGES;
    private static final ImmutableList<Vec3i> RESPAWN_HORIZONTAL_OFFSETS = ImmutableList.of(new Vec3i(0, 0, -1), new Vec3i(-1, 0, 0), new Vec3i(0, 0, 1), new Vec3i(1, 0, 0), new Vec3i(-1, 0, -1), new Vec3i(1, 0, -1), new Vec3i(-1, 0, 1), new Vec3i(1, 0, 1));
    private static final ImmutableList<Vec3i> RESPAWN_OFFSETS = (new ImmutableList.Builder<Vec3i>()).addAll(RESPAWN_HORIZONTAL_OFFSETS).addAll(RESPAWN_HORIZONTAL_OFFSETS.stream().map(Vec3i::below).iterator()).addAll(RESPAWN_HORIZONTAL_OFFSETS.stream().map(Vec3i::above).iterator()).add(new Vec3i(0, 1, 0)).build();

    public NuclearBombBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any().setValue(CHARGE, Integer.valueOf(0)));
    }

    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        //if (pHand == InteractionHand.MAIN_HAND && !isNuclearFuel(itemstack) && isNuclearFuel(pPlayer.getItemInHand(InteractionHand.OFF_HAND))) {
        //    return InteractionResult.PASS;
       //} else if (isNuclearFuel(itemstack) && canBeCharged(pState)) { LOOK we can use this to fill the uranium
       //    charge(pPlayer, pLevel, pPos, pState);
       //    if (!pPlayer.getAbilities().instabuild) {
       //        itemstack.shrink(1);
       //    }

       //     return InteractionResult.sidedSuccess(pLevel.isClientSide);
       // } else if (pState.getValue(CHARGE) == 0) {
       //     return InteractionResult.PASS;
        //} else
        //if (!pLevel.isClientSide) {
        //    explode(pState, pLevel, pPos);
        //}

        return InteractionResult.sidedSuccess(pLevel.isClientSide);
    }


    //private static boolean isNuclearFuel(ItemStack pStack) {
    //    return pStack.is(ModMineralItems.URANIUM_INGOT.get());
    //}

    //private static boolean canBeFuelled(BlockState pState) {
    //    return pState.getValue(CHARGE) < 4;
    //}

    private static boolean isWaterThatWouldFlow(BlockPos pPos, Level pLevel) {
        FluidState fluidstate = pLevel.getFluidState(pPos);
        if (!fluidstate.is(FluidTags.WATER)) {
            return false;
        } else if (fluidstate.isSource()) {
            return true;
        } else {
            float f = (float)fluidstate.getAmount();
            if (f < 2.0F) {
                return false;
            } else {
                FluidState fluidstate1 = pLevel.getFluidState(pPos.below());
                return !fluidstate1.is(FluidTags.WATER);
            }
        }
    }

    public static void explode(Level pLevel, BlockPos pPos, double pRadiusModifier) {
        explode(pLevel, pPos, (LivingEntity)null, pRadiusModifier);
    }

    public static void explode(Level pLevel, BlockPos pPos, @Nullable LivingEntity pEntity, double pRadiusModifier) {
        pLevel.removeBlock(pPos, false);
        boolean flag = Direction.Plane.HORIZONTAL.stream().map(pPos::relative).anyMatch((wouldFlow) -> {
            return isWaterThatWouldFlow(wouldFlow, pLevel);
        });
        final boolean flag1 = flag || pLevel.getFluidState(pPos.above()).is(FluidTags.WATER);
        ExplosionDamageCalculator explosiondamagecalculator = new ExplosionDamageCalculator() {
            public @NotNull Optional<Float> getBlockExplosionResistance(@NotNull Explosion explosion, @NotNull BlockGetter getter, BlockPos pPos, @NotNull BlockState state, @NotNull FluidState fluidState) {
                return pPos.equals(pPos) && flag1 ? Optional.of(Blocks.WATER.getExplosionResistance()) : super.getBlockExplosionResistance(explosion, getter, pPos, state, fluidState);
            }
        };

        if (!pLevel.isClientSide) {
            double d0 = Math.sqrt(pRadiusModifier);
            if (d0 > 15.0D) { // Check blast radius of bomb
                d0 = 250.0D;
            }
            //pLevel.explode(pEntity, pLevel.damageSources().generic(), explosiondamagecalculator, pPos.getX(), pPos.getY(), pPos.getZ(), 150, true, Level.ExplosionInteraction.TNT, true); // fix the nuke from making square crators
            pLevel.explode(pEntity, pPos.getX(), pPos.getY(), pPos.getZ(), 150, Level.ExplosionInteraction.TNT);
        }
    }

    public static boolean canSetSpawn(Level pLevel) {
        return pLevel.dimensionType().respawnAnchorWorks();
    }

    //public static void fuel(@Nullable Entity entity, Level level, BlockPos blockPos, BlockState blockState) {
    //    BlockState blockstate = blockState.setValue(CHARGE, Integer.valueOf(blockState.getValue(CHARGE) + 1));
    //    level.setBlock(blockPos, blockstate, 3);
    //    level.gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(entity, blockstate));
    //    level.playSound((Player)null, (double)blockPos.getX() + 0.5D, (double)blockPos.getY() + 0.5D, (double)blockPos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_CHARGE, SoundSource.BLOCKS, 1.0F, 1.0F);
    //}

    ///**
    // * Called periodically clientside on blocks near the player to show effects (like furnace fire particles).
    // */
    //public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
    //    if (pState.getValue(CHARGE) != 0) {
    //        if (pRandom.nextInt(100) == 0) {
    //            pLevel.playSound((Player)null, (double)pPos.getX() + 0.5D, (double)pPos.getY() + 0.5D, (double)pPos.getZ() + 0.5D, SoundEvents.RESPAWN_ANCHOR_AMBIENT, SoundSource.BLOCKS, 1.0F, 1.0F);
    //        }

    //        double d0 = (double)pPos.getX() + 0.5D + (0.5D - pRandom.nextDouble());
    //        double d1 = (double)pPos.getY() + 1.0D;
    //        double d2 = (double)pPos.getZ() + 0.5D + (0.5D - pRandom.nextDouble());
    //        double d3 = (double)pRandom.nextFloat() * 0.04D;
    //        pLevel.addParticle(ParticleTypes.REVERSE_PORTAL, d0, d1, d2, 0.0D, d3, 0.0D);
    //    }
    //}

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CHARGE);
    }

    public boolean hasAnalogOutputSignal(BlockState pState) {
        return true;
    }

    public static int getScaledChargeLevel(BlockState pState, int pScale) {
        return Mth.floor((float)(pState.getValue(CHARGE) - 0) / 4.0F * (float)pScale);
    }


    public int getAnalogOutputSignal(BlockState pBlockState, Level pLevel, BlockPos pPos) {
        return getScaledChargeLevel(pBlockState, 15);
    }

    //public static Optional<Vec3> findStandUpPosition(EntityType<?> pEntityType, CollisionGetter pLevel, BlockPos pPos) {
    //    Optional<Vec3> optional = findStandUpPosition(pEntityType, pLevel, pPos, true);
    //    return optional.isPresent() ? optional : findStandUpPosition(pEntityType, pLevel, pPos, false);
    //}

    //private static Optional<Vec3> findStandUpPosition(EntityType<?> pEntityType, CollisionGetter pLevel, BlockPos pPos, boolean pSimulate) {
    //    BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos();
//
    //    for(Vec3i vec3i : RESPAWN_OFFSETS) {
    //        blockpos$mutableblockpos.set(pPos).move(vec3i);
    //        Vec3 vec3 = DismountHelper.findSafeDismountLocation(pEntityType, pLevel, blockpos$mutableblockpos, pSimulate);
    //        if (vec3 != null) {
    //            return Optional.of(vec3);
    //        }
    //    }
//
    //    return Optional.empty();
    //}

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }
}