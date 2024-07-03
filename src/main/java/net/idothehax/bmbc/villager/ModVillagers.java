package net.matty.bmbc.villager;

import com.google.common.collect.ImmutableSet;
import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, BetterMineBetterCraft.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<PoiType> SILVER_LAMP_POI = POI_TYPES.register("silver_lamp_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.SILVER_LAMP.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<PoiType> VENDOR_OFFICE_POI = POI_TYPES.register("vendor_office_poi",
            () -> new PoiType(ImmutableSet.copyOf(ModBlocks.VENDOR_OFFICE.get().getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> SILVERER = VILLAGER_PROFESSIONS.register("silverer",
            () -> new VillagerProfession("silverer", x -> x.get() == SILVER_LAMP_POI.get(),
                    x -> x.get() == SILVER_LAMP_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_FARMER));

    public static final RegistryObject<VillagerProfession> VENDOR = VILLAGER_PROFESSIONS.register("vendor",
            () -> new VillagerProfession("vendor", x -> x.get() == VENDOR_OFFICE_POI.get(),
                    x -> x.get() == VENDOR_OFFICE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_CARTOGRAPHER));


    /*public static final RegistryObject<CustomWanderingTrader> VENDOR = CustomWanderingTrader.register("vendor",
            () -> EntityType.Builder.create(CustomWanderingTrader::new, EntityClassification.CREATURE)
                    .setTrackingRange(64)
                    .setUpdateInterval(1)
                    .setShouldReceiveVelocityUpdates(true)
                    .size(0.6f, 1.95f)
                    .build("vendor"));*/

    public static void registerPOIs() {
        try {
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, SILVER_LAMP_POI.get());
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates", PoiType.class).invoke(null, VENDOR_OFFICE_POI.get());
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
        }
    }

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

}
