package net.matty.bmbc.item.client;

import net.matty.bmbc.item.custom.NBCHazmatArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class NBCHazmatArmorRenderer extends GeoArmorRenderer<NBCHazmatArmorItem> {
    public NBCHazmatArmorRenderer() {
        super(new NBCHazmatArmorModel());
    }
}
