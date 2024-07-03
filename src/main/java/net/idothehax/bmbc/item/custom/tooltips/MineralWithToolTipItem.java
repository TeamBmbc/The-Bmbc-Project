package net.matty.bmbc.item.custom.tooltips;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MineralWithToolTipItem extends Item {
    private final String tooltip;
    private final String tooltipFront;
    public MineralWithToolTipItem(Properties pProperties, String tooltipFront, String tooltip) {
        super(pProperties);
        this.tooltip = tooltip;
        this.tooltipFront = tooltipFront;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        pTooltipComponents.add(Component.literal(this.tooltipFront).withStyle(ChatFormatting.RED)
                .append(Component.literal(this.tooltip).withStyle(ChatFormatting.BLUE)));
        super.appendHoverText(stack, level, pTooltipComponents, tooltipFlag);
    }
}
