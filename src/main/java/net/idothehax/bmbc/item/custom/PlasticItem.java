package net.matty.bmbc.item.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlasticItem extends Item {
    private final String tooltip;
    public PlasticItem(Properties pProperties, String tooltip) {
        super(pProperties);
        this.tooltip = tooltip;
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> pTooltipComponents, TooltipFlag tooltipFlag) {
        pTooltipComponents.add(Component.literal(this.tooltip).withStyle(ChatFormatting.AQUA));
        super.appendHoverText(stack, level, pTooltipComponents, tooltipFlag);
    }
}
