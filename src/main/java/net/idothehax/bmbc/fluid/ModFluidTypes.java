package net.matty.bmbc.fluid;


import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.SoundAction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.joml.Vector3f;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation HELIUM_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_helium");
    public static final ResourceLocation NITROGEN_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_nitrogen");
    public static final ResourceLocation OXYGEN_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_oxygen");
    public static final ResourceLocation SEWAGE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_sewage_water");
    public static final ResourceLocation SODIUM_HYDROXIDE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_sodium_hydroxide");
    public static final ResourceLocation ACETONE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_acetone");
    public static final ResourceLocation BISPHENOL_A_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_bisphenol");
    public static final ResourceLocation PHENOL_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_hydrochloric_acid");
    public static final ResourceLocation HYDROCHLORIC_ACID_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_phenol");
    public static final ResourceLocation CHLORINE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_chlorine");
    public static final ResourceLocation PROPANE_OVERLAY_RL = new ResourceLocation(BetterMineBetterCraft.MOD_ID, "misc/in_propane");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<FluidType> HELIUM_GAS_TYPE = register("helium_fluid",
            FluidType.Properties.create().lightLevel(2).density(-999999999).viscosity(5).temperature(-999999999).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, HELIUM_OVERLAY_RL,
            0xA1EAE5D8, new Vector3f(234f / 255f, 229f / 255f, 216f / 255f));

    public static final RegistryObject<FluidType> NITROGEN_FLUID_TYPE = register("nitrogen_fluid",
            FluidType.Properties.create().lightLevel(2).density(806).viscosity(1).temperature(-195).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, NITROGEN_OVERLAY_RL,
            0xA1D0D1F1, new Vector3f(208f / 255f, 209f / 255f, 241f / 255f));

    public static final RegistryObject<FluidType> OXYGEN_FLUID_TYPE = register("oxygen_fluid",
            FluidType.Properties.create().lightLevel(2).density(1141).viscosity(1).temperature(-297).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, OXYGEN_OVERLAY_RL,
            0xA1528BC5, new Vector3f(82f / 255f, 139f / 255f, 197f / 255f));

    public static final RegistryObject<FluidType> SEWAGE_WATER_FLUID_TYPE = register("sewage_water_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, SEWAGE_OVERLAY_RL,
            0xA1E038D0, new Vector3f(224f / 255f, 56f / 255f, 208f / 255f));

    public static final RegistryObject<FluidType> SODIUM_HYDROXIDE_FLUID_TYPE = register("sodium_hydroxide_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, SODIUM_HYDROXIDE_OVERLAY_RL,
            0xA1CACCCE, new Vector3f(69f / 255f, 69f / 255f, 69f / 255f));

    public static final RegistryObject<FluidType> ACETONE_FLUID_TYPE = register("acetone_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, ACETONE_OVERLAY_RL,
            0xA1B7B5AF, new Vector3f(71f / 255f, 71f / 255f, 68f / 255f));

    public static final RegistryObject<FluidType> BISPHENOL_FLUID_TYPE = register("bisphenol_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, BISPHENOL_A_OVERLAY_RL,
            0xA1B5890C, new Vector3f(71f / 255f, 53f / 255f, 4f / 255f));

    public static final RegistryObject<FluidType> CHLORINE_GAS_TYPE = register("chlorine_gas",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, CHLORINE_OVERLAY_RL,
            0xA1277059, new Vector3f(15f / 255f, 43f / 255f, 34f / 255f));

    public static final RegistryObject<FluidType> PHENOL_FLUID_TYPE = register("phenol_fluid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, PHENOL_OVERLAY_RL,
            0xA16F4A31, new Vector3f(43f / 255f, 29f / 255f, 19f / 255f));

    public static final RegistryObject<FluidType> PROPANE_GAS_TYPE = register("propane_gas",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, PROPANE_OVERLAY_RL,
            0xA1F1BF5A, new Vector3f(94f / 255f, 74f / 255f, 35f / 255f));

    public static final RegistryObject<FluidType> HYDROCHLORIC_ACID_TYPE = register("hydrochloric_acid",
            FluidType.Properties.create().lightLevel(2).density(15).viscosity(5).sound(SoundAction.get("drink"),
                    SoundEvents.GENERIC_DRINK), WATER_STILL_RL, WATER_FLOWING_RL, HYDROCHLORIC_ACID_OVERLAY_RL,
            0xA1C9C6C0, new Vector3f(78f / 255f, 77f / 255f, 75f / 255f));

    private static RegistryObject<FluidType> register(String name, FluidType.Properties properties,
                                                      ResourceLocation still, ResourceLocation flowing,
                                                      ResourceLocation overlay, int color, Vector3f particleColor) {
        return FLUID_TYPES.register(name, () -> new BaseFluidType(still, flowing, overlay, color, particleColor, properties));
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
