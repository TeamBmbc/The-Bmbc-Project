package net.matty.bmbc.item.client;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.custom.NBCHazmatArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class NBCHazmatArmorModel extends GeoModel<NBCHazmatArmorItem> {
    @Override
    public ResourceLocation getModelResource(NBCHazmatArmorItem animatable) {
        return new ResourceLocation(BetterMineBetterCraft.MOD_ID, "geo/hazmat_suit.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(NBCHazmatArmorItem animatable) {
        return new ResourceLocation(BetterMineBetterCraft.MOD_ID, "textures/armor/hazmat_suit.png");
    }

    @Override
    public ResourceLocation getAnimationResource(NBCHazmatArmorItem animatable) {
        return new ResourceLocation(BetterMineBetterCraft.MOD_ID, "animations/hazmat_suit.animation.json");
    }
}
