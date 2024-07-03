package net.matty.bmbc.block.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.SandBlock;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SilicaSand extends SandBlock {
    public SilicaSand(int pDustColor, Properties pProperties) {
        super(pDustColor, pProperties);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable BlockGetter pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
        pTooltip.add(Component.literal("Its like sand but mostly consisting of silica").withStyle(ChatFormatting.AQUA));
        super.appendHoverText(pStack, pLevel, pTooltip, pFlag);
    }
}
