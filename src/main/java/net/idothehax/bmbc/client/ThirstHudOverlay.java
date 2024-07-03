package net.matty.bmbc.client;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ThirstHudOverlay {

    private static final ResourceLocation FILLED_THIRST = new ResourceLocation(BetterMineBetterCraft.MOD_ID,
            "textures/thirst/filled_thirst.png");
    private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(BetterMineBetterCraft.MOD_ID,
            "textures/thirst/empty_thirst.png");

    public static final IGuiOverlay HUD_THIRST = ((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        //RenderSystem.setShader(GameRenderer::getPositionTexShader);
        //RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        //RenderSystem.setShaderTexture(0, EMPTY_THIRST);
        //for(int i = 0; i < 10; i++) {
        //    GuiComponent.blit(poseStack,x - 96 + (i * 9), y - 54,0,0,12,12,
        //            12,12);
        //}
//
        //RenderSystem.setShaderTexture(0, FILLED_THIRST);
        //for(int i = 0; i < 10; i++) {
        //    if(ClientThirstData.getPlayerThirst() > i) {
        //        GuiComponent.blit(poseStack,x - 96 + (i * 9),y - 54,0,0,12,12,
        //                12,12);
        //    } else {
        //        break;
        //    }
        //}
    });//
}
