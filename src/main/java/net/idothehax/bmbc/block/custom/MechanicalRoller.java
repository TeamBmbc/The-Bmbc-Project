package net.matty.bmbc.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class MechanicalRoller extends BaseEntityBlock {

    public MechanicalRoller(Properties pProperties) {
        super(pProperties);
    }

    //TODO implement BlockEntity and functionality and all other elements of the block
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return null;
    }
}
