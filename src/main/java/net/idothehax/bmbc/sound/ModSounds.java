package net.matty.bmbc.sound;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BetterMineBetterCraft.MOD_ID);

    public static final  RegistryObject<SoundEvent> PLASTIC_CRUSH = registerSoundEvent("plastic_crush");

    public static final ForgeSoundType GARBAGE_BLOCK_SOUNDS = new ForgeSoundType(1f, 1f,
            ModSounds.PLASTIC_CRUSH, ModSounds.PLASTIC_CRUSH, ModSounds.PLASTIC_CRUSH,
            ModSounds.PLASTIC_CRUSH, ModSounds.PLASTIC_CRUSH);

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = new ResourceLocation(BetterMineBetterCraft.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
