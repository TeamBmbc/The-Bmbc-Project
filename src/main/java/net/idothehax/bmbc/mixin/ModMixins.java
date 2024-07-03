package net.matty.bmbc.mixin;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class ModMixins {

    private Player self() {
        return (Player) (Object) this;
    }

    /**
     * @author IDoTheHax
     * @reason Kaupitencraft Said don't ask
     */
    @Inject(method = "touch", at = @At("HEAD"))
    private void touch(Entity entity, CallbackInfo ci) {
        self().displayClientMessage(Component.literal("Touch!").withStyle(ChatFormatting.BLUE), true);
    }
}
