package net.matty.bmbc.block.custom;

import net.matty.bmbc.block.entity.HydroelectricBlockEntity;
import net.matty.bmbc.block.entity.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.network.NetworkHooks;
import org.jetbrains.annotations.Nullable;

public class HydroelectricPlantBlock extends BaseEntityBlock {
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");

    public HydroelectricPlantBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ACTIVE, Boolean.valueOf(false)));
    }

    //public void onPlace(BlockState pState, Level pLevel, BlockPos pPos, BlockState pOldState, boolean pIsMoving) {
    //    if (!pOldState.is(pState.getBlock())) {
    //        this.tryAbsorbWater(pLevel, pPos);
    //    }
    //}
//
    //public void neighborChanged(BlockState pState, Level pLevel, BlockPos pPos, Block pBlock, BlockPos pFromPos, boolean pIsMoving) {
    //    this.tryAbsorbWater(pLevel, pPos);
    //    super.neighborChanged(pState, pLevel, pPos, pBlock, pFromPos, pIsMoving);
    //}
//
    //protected void tryAbsorbWater(Level pLevel, BlockPos pPos) {
    //    if (this.removeWaterBreadthFirstSearch(pLevel, pPos)) {
    //        pLevel.setBlock(pPos, Blocks.WET_SPONGE.defaultBlockState(), 2);
    //        pLevel.levelEvent(2001, pPos, Block.getId(Blocks.WATER.defaultBlockState()));
    //    }
//
    //}
//
    //private boolean removeWaterBreadthFirstSearch(Level pLevel, BlockPos pPos) {
    //    Queue<Tuple<BlockPos, Integer>> queue = Lists.newLinkedList();
    //    queue.add(new Tuple<>(pPos, 0));
    //    int i = 0;
    //    BlockState state = pLevel.getBlockState(pPos);
//
    //    while(!queue.isEmpty()) {
    //        Tuple<BlockPos, Integer> tuple = queue.poll();
    //        BlockPos blockpos = tuple.getA();
    //        int j = tuple.getB();
//
    //        for(Direction direction : Direction.values()) {
    //            BlockPos blockpos1 = blockpos.relative(direction);
    //            BlockState blockstate = pLevel.getBlockState(blockpos1);
    //            FluidState fluidstate = pLevel.getFluidState(blockpos1);
    //            Material material = blockstate.getMaterial();
    //            if (state.canBeHydrated(pLevel, pPos, fluidstate, blockpos1)) {
    //                if (blockstate.getBlock() instanceof BucketPickup && !((BucketPickup)blockstate.getBlock()).pickupBlock(pLevel, blockpos1, blockstate).isEmpty()) {
    //                    ++i;
    //                    if (j < 6) {
    //                        queue.add(new Tuple<>(blockpos1, j + 1));
    //                    }
    //                } else if (blockstate.getBlock() instanceof LiquidBlock) {
    //                    pLevel.setBlock(blockpos1, Blocks.AIR.defaultBlockState(), 3);
    //                    ++i;
    //                    if (j < 6) {
    //                        queue.add(new Tuple<>(blockpos1, j + 1));
    //                    }
    //                } else if (material == Material.WATER_PLANT || material == Material.REPLACEABLE_WATER_PLANT) {
    //                    BlockEntity blockentity = blockstate.hasBlockEntity() ? pLevel.getBlockEntity(blockpos1) : null;
    //                    dropResources(blockstate, pLevel, blockpos1, blockentity);
    //                    pLevel.setBlock(blockpos1, Blocks.AIR.defaultBlockState(), 3);
    //                    ++i;
    //                    if (j < 6) {
    //                        queue.add(new Tuple<>(blockpos1, j + 1));
    //                    }
    //                }
    //            }
    //        }
//
    //        if (i > 64) {
    //            break;
    //        }
    //    }
//
    //    return i > 0;
    //}

    private static final VoxelShape SHAPE =
            Block.box(0, 0, 0, 16, 16, 16);

    @Override
    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return SHAPE;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(ACTIVE);
    }

    /* BLOCK ENTITY */

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof HydroelectricBlockEntity) {
                ((HydroelectricBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if(entity instanceof HydroelectricBlockEntity) {
                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (HydroelectricBlockEntity)entity, pPos);
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }

        return InteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new HydroelectricBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, ModBlockEntities.HYDROELECTRIC_PLANT.get(),
                HydroelectricBlockEntity::tick);
    }
}
