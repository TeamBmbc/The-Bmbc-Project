package net.matty.bmbc.mixin;

import net.minecraft.world.entity.ai.attributes.Attributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Attributes.class)
public class AttributesMixin {

    @ModifyConstant(method = "<clinit>")
    private static double modifyMaxAttributeLength(double constant) {
        return constant == 1024 ? Double.MAX_VALUE : constant;
    }
}
