//package net.matty.bmbc.item.custom;
//
//import net.matty.bmbc.energy.BmbcEnergyItemStorage;
//import net.matty.bmbc.util.BmbcEnergyStorage;
//import net.minecraft.ChatFormatting;
//import net.minecraft.network.chat.Component;
//import net.minecraft.world.item.Item.Properties;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.TooltipFlag;
//import net.minecraft.world.level.Level;
//import net.minecraftforge.energy.EnergyStorage;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.List;
//
//public class BatteryItem extends BmbcEnergyItemStorage {
//    public int capacity;
//    public int maxReceiveAmount;
//    public int maxExtractAmount;
//    public int energyStored;
//
//
//    public BatteryItem(Properties pProperties, int capacity, int maxReceiveAmount, int maxExtractAmount, int energyStored) {
//        super(pProperties, , energyStored);
//        this.capacity = capacity;
//        this.maxReceiveAmount = maxReceiveAmount;
//        this.maxExtractAmount = maxExtractAmount;
//        this.energyStored = energyStored;
//    }
//
//    private final EnergyStorage ENERGY_STORAGE = new BmbcEnergyStorage(this.capacity, this.maxReceiveAmount) {
//
//        @Override
//        public void onEnergyChanged() {
//
//        }
//    };
//
//    @Override
//    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
//        super.appendHoverText(stack, level, tooltip, flag);
//
//        //tooltip.add(Component.translatable("item.bmbc.battery").withStyle(ChatFormatting.DARK_RED, ChatFormatting.ITALIC));
//        tooltip.add(Component.literal("Energy: ").withStyle(ChatFormatting.DARK_PURPLE, ChatFormatting.ITALIC));
//        tooltip.add(Component.translatable("item.bmbc.tooltip.battery.energy", this.energyStored, this.capacity).withStyle(ChatFormatting.RED));
//    }
//}