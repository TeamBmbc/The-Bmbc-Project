package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;


public interface IMultiblock {

    boolean isComplete(BlockPos position);
    HashMap<Block, BlockPos> getBlocks();

    default BlockState checkNeighbour(BlockPos neighborPosition) {
        return null;
    }
}
