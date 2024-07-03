package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;

import java.util.HashMap;

public class TestMultiBlock extends Block implements IMultiblock {

    private final HashMap<Block, BlockPos> blocks = new HashMap<>();
    private static final int SIZE = 3;

    public TestMultiBlock() {
        super(Block.Properties.of(Material.STONE)); // You can customize the block properties here
    }

    @Override
    public boolean isComplete(BlockPos position) {
        // Check if the 3x3 multiblock is complete at the given position

        // Calculate the starting position of the 3x3 multiblock based on the center position
        int startX = position.getX() - SIZE / 2;
        int startZ = position.getZ() - SIZE / 2;

        for (int x = 0; x < SIZE; x++) {
            for (int z = 0; z < SIZE; z++) {
                BlockPos currentPos = new BlockPos(startX + x, position.getY(), startZ + z);
                BlockState blockState = checkNeighbour(currentPos);

                // Your specific conditions to check if the block at the current position
                // is part of the 3x3 multiblock.
                // Example: If the block is a specific type (e.g., CustomMultiblockBlock),
                // and it has specific properties set correctly, you can consider it part of the multiblock.
                // For demonstration purposes, we'll assume any block is valid.
                if (blockState != null) {
                    Block block = blockState.getBlock();
                    blocks.put(block, currentPos); // Store the block and its position in the HashMap
                } else {
                    return false; // If any block is missing, the multiblock is not complete
                }
            }
        }

        return blocks.size() == SIZE * SIZE; // All 9 blocks are present, multiblock complete
    }

    @Override
    public HashMap<Block, BlockPos> getBlocks() {
        return blocks;
    }

    @Override
    public BlockState checkNeighbour(BlockPos neighborPosition) {
        // Your implementation to check the neighbor block state.
        // You might access the world and retrieve the block state at the given position.
        // For demonstration purposes, we'll return a mock block state to represent a block being present.
        return defaultBlockState();
    }
}
