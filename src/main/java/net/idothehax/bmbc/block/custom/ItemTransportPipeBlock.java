package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;


public class ItemTransportPipeBlock extends Block {
    public ItemTransportPipeBlock(Properties properties) {
        super(properties);
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // Determines the block state to use when the block is placed
        return defaultBlockState();
    }
}