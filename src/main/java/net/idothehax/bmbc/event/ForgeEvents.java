package net.matty.bmbc.event;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.custom.RadioactiveBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END || event.player == null) {
            return;
        }

        Player player = event.player;
        Level level = player.level;

        if (!level.isClientSide) {
            BlockPos playerPos = player.blockPosition();
            BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

            // Check the player's proximity to the radioactive block.
            for (int x = -RadioactiveBlock.radiationRange; x <= RadioactiveBlock.radiationRange; x++) {
                for (int y = -RadioactiveBlock.radiationRange; y <= RadioactiveBlock.radiationRange; y++) {
                    for (int z = -RadioactiveBlock.radiationRange; z <= RadioactiveBlock.radiationRange; z++) {
                        mutablePos.set(playerPos).move(x, y, z);
                        if (level.getBlockState(mutablePos).getBlock() instanceof RadioactiveBlock) {
                            // The player is near the radioactive block.
                            // Apply damage here using the same method as in onDestroyedByPlayer.

                            RadioactiveBlock.applyRadiationDamage(player, level);
                            break; // No need to check further if we found a radioactive block.
                        }
                    }
                    if (RadioactiveBlock.hasHazmatSuit(player)) {
                        break;
                    }
                }
                if (RadioactiveBlock.hasHazmatSuit(player)) {
                    break;
                }
            }
        }
    }
}
