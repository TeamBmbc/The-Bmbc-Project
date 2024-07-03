package net.matty.bmbc.item.custom;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RecruiterItem extends Item {
    public RecruiterItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            // Get the player's position and direction
            Vec3 pos = player.getEyePosition(1.0F);
            Vec3 dir = player.getViewVector(1.0F);

            // Calculate the position to spawn the entity
            double x = pos.x + dir.x * 2.0D;
            double y = pos.y + dir.y * 2.0D;
            double z = pos.z + dir.z * 2.0D;

            // Create a new instance of your custom entity
            //CustomWanderingTrader trader = new CustomWanderingTrader(EntityType.WANDERING_TRADER, level);
            //trader.setPos(x, y, z);

            // Spawn the entity in the world
            //level.addFreshEntity(trader);

            // Consume one item from the player's hand
            ItemStack itemstack = player.getItemInHand(hand);
            itemstack.shrink(1);

            // Return a successful result
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemstack);

            // player.getCooldowns().addCooldown(this, 200); // See if this needs to be there later
        }

        return super.use(level, player, hand);
    }
}
