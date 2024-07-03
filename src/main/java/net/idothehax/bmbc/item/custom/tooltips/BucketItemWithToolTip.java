package net.matty.bmbc.item.custom.tooltips;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluid;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class BucketItemWithToolTip extends BucketItem {
    private final String tooltip;
    private final String tooltipFront;

    public BucketItemWithToolTip(Supplier<? extends Fluid> supplier, Properties builder, String tooltipFront, String tooltip) {
        super(supplier, builder);
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
