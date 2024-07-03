package net.matty.bmbc.block.custom;

import net.matty.bmbc.sound.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class GarbageBlock extends Block {
    public GarbageBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos blockPos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        level.playSound(player, blockPos, ModSounds.PLASTIC_CRUSH.get(), SoundSource.BLOCKS, 1f, 1f);
        return super.use(blockState, level, blockPos, player, hand, hitResult);
    }
}
