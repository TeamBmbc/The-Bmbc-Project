package net.matty.bmbc.block.custom;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.ModArmorItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraftforge.fml.common.Mod;

import java.util.stream.StreamSupport;

@Mod.EventBusSubscriber(modid = BetterMineBetterCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RadioactiveBlock extends Block {
    private static final int COOLDOWN_MIN = 100; // 100 ticks = 5 seconds (20 ticks per second)
    private static final int COOLDOWN_MAX = 200; // 200 ticks = 10 seconds

    private static int currentCooldown = 0;
    public static int radiationRange;
    public static float radiationDamage;

    public RadioactiveBlock(Properties properties, int radiationRange, float radiationDamage) {
        super(properties);
        RadioactiveBlock.radiationRange = radiationRange;
        RadioactiveBlock.radiationDamage = radiationDamage;
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        if (player != null) {
            applyRadiationDamage(player, level);
        }

        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }


    public static boolean hasHazmatSuit(Player player) {
        // Check if the player is wearing a hazmat suit item
        // Return true if they are, false otherwise
        Item hazmatHelmet = ModArmorItems.NBC_HAZMAT_MASK.get();
        Item hazmatChestplate = ModArmorItems.NBC_HAZMAT_CHESTPLATE.get();
        Item hazmatLeggings = ModArmorItems.NBC_HAZMAT_LEGGINGS.get();
        Item hazmatBoots = ModArmorItems.NBC_HAZMAT_BOOTS.get();

        Iterable<ItemStack> armorSlots = player.getArmorSlots();
        return StreamSupport.stream(armorSlots.spliterator(), false)
                .allMatch(itemStack -> {
                    Item item = itemStack.getItem();
                    return item == hazmatHelmet || item == hazmatChestplate || item == hazmatLeggings || item == hazmatBoots;
                });
    }

    public static void applyRadiationDamage(Player player, Level level) {
        if (player != null) {
            if (!hasHazmatSuit(player)) {
                player.hurt(level.damageSources().generic(), radiationDamage);
            } else {
                // Decrease the armour durability
                // Increment the cooldown timer
                if (currentCooldown > 0) {
                    currentCooldown--;
                }

                // TODO: There is a bug that when taken out of the slot the durability resets
                if (RadioactiveBlock.hasHazmatSuit(player) && currentCooldown <= 0 && !player.isCreative()) {
                    // Decrease the durability of the custom armor items
                    decreaseDurability(player.getItemBySlot(EquipmentSlot.HEAD));
                    decreaseDurability(player.getItemBySlot(EquipmentSlot.CHEST));
                    decreaseDurability(player.getItemBySlot(EquipmentSlot.LEGS));
                    decreaseDurability(player.getItemBySlot(EquipmentSlot.FEET));

                    // Reset the cooldown
                    currentCooldown = player.level.random.nextInt(COOLDOWN_MAX - COOLDOWN_MIN + 1) + COOLDOWN_MIN;
                }
            }
        }
    }

    private static void decreaseDurability(ItemStack itemStack) {
        // Check if the itemStack is not empty and if it is armor with durability
        if (!itemStack.isEmpty() && itemStack.isDamageableItem()) {
            // Decrease the item's durability
            itemStack.setDamageValue(itemStack.getDamageValue() + 1);

            // If the durability reaches 0, the item will break, so you may want to handle that case
            if (itemStack.getDamageValue() >= itemStack.getMaxDamage()) {
                itemStack.shrink(1); // Remove the item from the player's inventory when it breaks
            }
        }
    }
}
