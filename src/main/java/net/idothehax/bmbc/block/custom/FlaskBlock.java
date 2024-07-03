//package net.matty.bmbc.block.custom;
//
//import net.matty.bmbc.block.entity.ExtruderBlockEntity;
//import net.matty.bmbc.block.entity.ErlenmeyerFlaskBlockEntity;
//import net.matty.bmbc.block.entity.ModBlockEntities;
//import net.minecraft.core.BlockPos;
//import net.minecraft.core.Direction;
//import net.minecraft.server.level.ServerPlayer;
//import net.minecraft.world.InteractionHand;
//import net.minecraft.world.InteractionResult;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.item.context.BlockPlaceContext;
//import net.minecraft.world.level.BlockGetter;
//import net.minecraft.world.level.Level;
//import net.minecraft.world.level.block.*;
//import net.minecraft.world.level.block.entity.BlockEntity;
//import net.minecraft.world.level.block.entity.BlockEntityTicker;
//import net.minecraft.world.level.block.entity.BlockEntityType;
//import net.minecraft.world.level.block.state.BlockState;
//import net.minecraft.world.level.block.state.StateDefinition;
//import net.minecraft.world.level.block.state.properties.BlockStateProperties;
//import net.minecraft.world.level.block.state.properties.BooleanProperty;
//import net.minecraft.world.level.block.state.properties.DirectionProperty;
//import net.minecraft.world.phys.BlockHitResult;
//import net.minecraft.world.phys.shapes.CollisionContext;
//import net.minecraft.world.phys.shapes.VoxelShape;
//import net.minecraftforge.network.NetworkHooks;
//import org.jetbrains.annotations.Nullable;
//
//public class FlaskBlock extends BaseEntityBlock {
//    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
//    public static final BooleanProperty ACTIVE = BooleanProperty.create("active");
//
//    public FlaskBlock(Properties properties) {
//        super(properties);
//        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(ACTIVE, Boolean.valueOf(false)));
//    }
//
//    private static final VoxelShape SHAPE =
//            Block.box(2, 0, 2, 12, 12, 12);
//
//    @Override
//    public VoxelShape getShape(BlockState p_60555_, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
//        return SHAPE;
//    }
//
//    @Override
//    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
//        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
//    }
//
//    @Override
//    public BlockState rotate(BlockState pState, Rotation pRotation) {
//        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
//    }
//
//    @Override
//    public BlockState mirror(BlockState pState, Mirror pMirror) {
//        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
//    }
//
//    @Override
//    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
//        builder.add(FACING);
//        builder.add(ACTIVE);
//    }
//
//    /* BLOCK ENTITY */
//
//    @Override
//    public RenderShape getRenderShape(BlockState p_49232_) {
//        return RenderShape.MODEL;
//    }
//
//    @Override
//    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
//        if (pState.getBlock() != pNewState.getBlock()) {
//            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
//            if (blockEntity instanceof ExtruderBlockEntity) {
//                ((ExtruderBlockEntity) blockEntity).drops();
//            }
//        }
//        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
//    }
//
//    @Override
//    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
//                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
//        if (!pLevel.isClientSide()) {
//            BlockEntity entity = pLevel.getBlockEntity(pPos);
//            if(entity instanceof ExtruderBlockEntity) {
//                NetworkHooks.openScreen(((ServerPlayer)pPlayer), (ExtruderBlockEntity)entity, pPos);
//            } else {
//                throw new IllegalStateException("Our Container provider is missing!");
//            }
//        }
//
//        return InteractionResult.sidedSuccess(pLevel.isClientSide());
//    }
//
//    @Nullable
//    @Override
//    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return new ExtruderBlockEntity(pos, state);
//    }
//
//    @Nullable
//    @Override
//    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
//
//
//        return createTickerHelper(type, ModBlockEntities.ERLENMEYER_FLASK.get(),
//                ErlenmeyerFlaskBlockEntity::tick);
//    }
//}
