package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class C4Block extends Block {
    public static final BooleanProperty UNSTABLE = BlockStateProperties.UNSTABLE;
    public C4Block(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.defaultBlockState().setValue(UNSTABLE, Boolean.valueOf(false)));
    }

    private static final VoxelShape SHAPE =
            Block.box(3, 0, 1, 13, 3, 15);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE;
    }

    public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
        if (!pOldState.is(pState.getBlock())) {
            if (pLevel.hasNeighborSignal(pPos)) {
                pLevel.removeBlock(pPos, false);
            }

        }
    }

    public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
        if (pLevel.hasNeighborSignal(pPos)) {
            pLevel.removeBlock(pPos, false);
        }
    }


    public void playerWillDestroy(Level pLevel, BlockPos pPos, BlockState pState, Player pPlayer) {
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    public static void explode(Level pLevel, BlockPos pPos) {
        explode(pLevel, pPos, (LivingEntity)null);
    }

    public static void explode(Level pLevel, BlockPos pPos, @Nullable LivingEntity pEntity) {
        if (!pLevel.isClientSide) {
            pLevel.explode(pEntity, pPos.getX(), pPos.getY(), pPos.getZ(), 4.0F, Level.ExplosionInteraction.BLOCK);
        }
    }

    /*public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        ItemStack itemstack = pPlayer.getItemInHand(pHand);
        if (!itemstack.is(ModItems.C4_DETONATOR.get())) {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        } else {
            explode(pLevel, pPos, pPlayer);
            pLevel.setBlock(pPos, Blocks.AIR.defaultBlockState(), 11);
            Item item = itemstack.getItem();
            //if (!pPlayer.isCreative()) {
            //    if (itemstack.is(ModItems.C4_DETONATOR.get())) {
            //        itemstack.hurtAndBreak(1, pPlayer, (p_57425_) -> {
            //            p_57425_.broadcastBreakEvent(pHand);
            //        });
            //    } else {
            //        itemstack.shrink(1);
            //    }
            //}

            pPlayer.awardStat(Stats.ITEM_USED.get(item));
            return InteractionResult.sidedSuccess(pLevel.isClientSide);
        }
    }*/

    public boolean dropFromExplosion(Explosion pExplosion) {
        return true;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(UNSTABLE);
    }
}
