package net.matty.bmbc.item.custom;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.block.custom.C4Block;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class C4Detonator extends Item {

    public static int RADIUS = 15;

    public C4Detonator(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            // Set a Cooldown
            //player.getCooldowns().addCooldown(this, 200);
            BlockPos pos = player.blockPosition();
            BetterMineBetterCraft.LOGGER.debug("Testing for c4");
            for (int x = pos.getX()-RADIUS; x<pos.getX()+RADIUS; x++) {
                for (int y = pos.getY()-RADIUS; y<pos.getY()+RADIUS; y++) {
                    for (int z = pos.getZ()-RADIUS; z< pos.getZ()+RADIUS; z++) {
                        if(player.getServer().overworld().getBlockState(new BlockPos(x, y, z)).getBlock() == ModBlocks.C4.get()){
                            BetterMineBetterCraft.LOGGER.debug("Detonating C4 at "+x+" "+y+" "+z);
                            C4Block.explode(player.getServer().overworld(), new BlockPos(x,y,z), player);
                        }
                    }
                }
            }
        }

        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
        if(Screen.hasShiftDown()){
            components.add(Component.literal("Right Click detonate nearby C4's").withStyle(ChatFormatting.YELLOW));
        } else {
            components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.AQUA));
        }

        super.appendHoverText(stack, level, components, flag);
    }
}
