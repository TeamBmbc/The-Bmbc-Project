package net.matty.bmbc.fluid;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModFluidBlocks;
import net.matty.bmbc.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<FlowingFluid> SOURCE_HELIUM = FLUIDS.register("helium_gas",
            () -> new ForgeFlowingFluid.Source(ModFluids.HELIUM_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HELIUM = FLUIDS.register("flowing_helium",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HELIUM_GAS_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_NITROGEN_FLUID = FLUIDS.register("nitrogen_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.NITROGEN_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_NITROGEN_FLUID = FLUIDS.register("flowing_nitrogen",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.NITROGEN_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_OXYGEN_FLUID = FLUIDS.register("oxygen_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.OXYGEN_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_OXYGEN_FLUID = FLUIDS.register("flowing_oxygen",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.OXYGEN_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_SEWAGE_WATER = FLUIDS.register("sewage_water_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SEWAGE_WATER_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SEWAGE_WATER = FLUIDS.register("flowing_sewage_water",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SEWAGE_WATER_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_SODIUM_HYDROXIDE = FLUIDS.register("sodium_hydroxide_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.SODIUM_HYDROXIDE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_SODIUM_HYDROXIDE = FLUIDS.register("flowing_sodium_hydroxide",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.SODIUM_HYDROXIDE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_ACETONE = FLUIDS.register("acetone_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.ACETONE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_ACETONE = FLUIDS.register("flowing_acetone",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.ACETONE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_BISPHENOL = FLUIDS.register("bisphenol_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.BISPHENOL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_BISPHENOL = FLUIDS.register("flowing_bisphenol",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.BISPHENOL_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_CHLORINE = FLUIDS.register("chlorine_gas",
            () -> new ForgeFlowingFluid.Source(ModFluids.CHLORINE_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_CHLORINE = FLUIDS.register("flowing_chlorine",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.CHLORINE_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_HYDROCHLORIC_ACID = FLUIDS.register("hydrochloric_acid",
            () -> new ForgeFlowingFluid.Source(ModFluids.HYDROCHLORIC_ACID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_HYDROCHLORIC_ACID = FLUIDS.register("flowing_hydrochloric_acid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.HYDROCHLORIC_ACID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_PHENOL = FLUIDS.register("phenol_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.PHENOL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PHENOL = FLUIDS.register("flowing_phenol",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PHENOL_FLUID_PROPERTIES));

    public static final RegistryObject<FlowingFluid> SOURCE_PROPANE = FLUIDS.register("propane_gas",
            () -> new ForgeFlowingFluid.Source(ModFluids.PROPANE_GAS_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_PROPANE = FLUIDS.register("flowing_propane",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.PROPANE_GAS_PROPERTIES));

    public static final ForgeFlowingFluid.Properties HELIUM_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.HELIUM_GAS_TYPE, SOURCE_HELIUM, FLOWING_HELIUM)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.HELIUM_BLOCK)
            .bucket(ModItems.LIQUID_HELIUM_BUCKET);

    public static final ForgeFlowingFluid.Properties NITROGEN_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.NITROGEN_FLUID_TYPE, SOURCE_NITROGEN_FLUID, FLOWING_NITROGEN_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.NITROGEN_BLOCK)
            .bucket(ModItems.LIQUID_NITROGEN_BUCKET);

    public static final ForgeFlowingFluid.Properties OXYGEN_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.OXYGEN_FLUID_TYPE, SOURCE_OXYGEN_FLUID, FLOWING_OXYGEN_FLUID)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.OXYGEN_BLOCK)
            .bucket(ModItems.LIQUID_OXYGEN_BUCKET);

    public static final ForgeFlowingFluid.Properties SEWAGE_WATER_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SEWAGE_WATER_FLUID_TYPE, SOURCE_SEWAGE_WATER, FLOWING_SEWAGE_WATER)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.SEWAGE_WATER_BLOCK)
            .bucket(ModItems.SEWAGE_WATER_BUCKET);

    public static final ForgeFlowingFluid.Properties SODIUM_HYDROXIDE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.SODIUM_HYDROXIDE_FLUID_TYPE, SOURCE_SODIUM_HYDROXIDE, FLOWING_SODIUM_HYDROXIDE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.SODIUM_HYDROXIDE_BLOCK)
            .bucket(ModItems.SODIUM_HYDROXIDE_BUCKET);

    public static final ForgeFlowingFluid.Properties ACETONE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.ACETONE_FLUID_TYPE, SOURCE_ACETONE, FLOWING_ACETONE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.ACETONE_BLOCK)
            .bucket(ModItems.ACETONE_BUCKET);

    public static final ForgeFlowingFluid.Properties BISPHENOL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.BISPHENOL_FLUID_TYPE, SOURCE_BISPHENOL, FLOWING_BISPHENOL)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.BISPHENOL_BLOCK)
            .bucket(ModItems.BISPHENOL_BUCKET);

    public static final ForgeFlowingFluid.Properties CHLORINE_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.CHLORINE_GAS_TYPE, SOURCE_CHLORINE, FLOWING_CHLORINE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.CHLORINE_BLOCK)
            .bucket(ModItems.CHLORINE_BUCKET);

    public static final ForgeFlowingFluid.Properties HYDROCHLORIC_ACID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.HYDROCHLORIC_ACID_TYPE, SOURCE_HYDROCHLORIC_ACID, FLOWING_HYDROCHLORIC_ACID)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.HYDROCHLORIC_ACID_BLOCK)
            .bucket(ModItems.HYDROCHLORIC_ACID_BUCKET);

    public static final ForgeFlowingFluid.Properties PHENOL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.PHENOL_FLUID_TYPE, SOURCE_PHENOL, FLOWING_PHENOL)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.PHENOL_BLOCK)
            .bucket(ModItems.PHENOL_BUCKET);

    public static final ForgeFlowingFluid.Properties PROPANE_GAS_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.PROPANE_GAS_TYPE, SOURCE_PROPANE, FLOWING_PROPANE)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModFluidBlocks.PROPANE_BLOCK)
            .bucket(ModItems.PROPANE_BUCKET);


    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
