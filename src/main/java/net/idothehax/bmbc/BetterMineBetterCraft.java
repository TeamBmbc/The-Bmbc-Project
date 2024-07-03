package net.matty.bmbc;

import com.mojang.logging.LogUtils;
import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.block.ModFluidBlocks;
import net.matty.bmbc.block.entity.ModBlockEntities;
import net.matty.bmbc.creativemode_tab.*;
import net.matty.bmbc.fluid.ModFluidTypes;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.*;
import net.matty.bmbc.loot.ModLootModifiers;
import net.matty.bmbc.networking.ModNetworkingPackets;
import net.matty.bmbc.recipe.ModRecipes;
import net.matty.bmbc.screen.*;
import net.matty.bmbc.sound.ModSounds;
import net.matty.bmbc.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BetterMineBetterCraft.MOD_ID)
public class BetterMineBetterCraft {
    public static final String MOD_ID = "bmbc";
    public static final Logger LOGGER = LogUtils.getLogger();

    public BetterMineBetterCraft()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModAlloyItems.register(modEventBus);
        ModArmorItems.register(modEventBus);
        ModItems.register(modEventBus);
        ModMineralItems.register(modEventBus);
        ModFoodItems.register(modEventBus);
        ModChemicalCompounds.register(modEventBus);
        ModMachineComponents.register(modEventBus);

        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);

        CompoundItems.register(modEventBus);
        ElementItems.register(modEventBus);

        GasStorageItems.register(modEventBus);
        FluidStorageItems.register(modEventBus);
        ModFluids.register(modEventBus);
        ModFluidBlocks.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModSounds.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModResourcesCreativeModeTab.BMBC_RESOURCES) {

            event.accept(ModMineralItems.BAUXITE);
            event.accept(ModMineralItems.MAGNETIC_IRON_INGOT);
            event.accept(ModMineralItems.HYDROGEN_INGOT);
            event.accept(ModMineralItems.HELIUM_INGOT);
            event.accept(ModMineralItems.LITHIUM_INGOT);
            event.accept(ModMineralItems.BERYLLIUM_INGOT);
            event.accept(ModMineralItems.BORON_INGOT);
            event.accept(ModMineralItems.CARBON_INGOT);
            event.accept(ModMineralItems.NITROGEN_INGOT);
            event.accept(ModMineralItems.OXYGEN_INGOT);
            event.accept(ModMineralItems.FLUORINE_INGOT);
            event.accept(ModMineralItems.NEON_INGOT);
            event.accept(ModMineralItems.SODIUM_INGOT);
            event.accept(ModMineralItems.MAGNESIUM_INGOT);
            event.accept(ModMineralItems.ALUMINIUM_INGOT);
            event.accept(ModMineralItems.SILICON_CRYSTAL);
            event.accept(ModMineralItems.WHITE_PHOSPHORUS);
            event.accept(ModMineralItems.RED_PHOSPHORUS);
            event.accept(ModMineralItems.BLACK_PHOSPHORUS);
            event.accept(ModMineralItems.SULFUR_CRYSTAL);
            event.accept(ModMineralItems.CHLORINE_INGOT);
            event.accept(ModMineralItems.ARGON_INGOT);
            event.accept(ModMineralItems.POTASSIUM_INGOT);
            event.accept(ModMineralItems.CALCIUM_ROCK);
            event.accept(ModMineralItems.SCANDIUM_INGOT);
            event.accept(ModMineralItems.TITANIUM_INGOT);
            event.accept(ModMineralItems.VANADIUM_INGOT);
            event.accept(ModMineralItems.CHROMIUM_CRYSTAL);
            event.accept(ModMineralItems.MANGANESE_INGOT);
            //event.accept(ModMineralItems.IRON_INGOT);
            event.accept(ModMineralItems.COBALT_INGOT);
            event.accept(ModMineralItems.NICKEL_INGOT);
            //event.accept(ModMineralItems.COPPER_INGOT);
            event.accept(ModMineralItems.ZINC_INGOT);
            event.accept(ModMineralItems.GALLIUM_INGOT);
            event.accept(ModMineralItems.GERMANIUM_INGOT);
            event.accept(ModMineralItems.ARSENIC_INGOT);
            event.accept(ModMineralItems.SELENIUM_INGOT);
            event.accept(ModMineralItems.BROMINE_INGOT);
            event.accept(ModMineralItems.KRYPTON_INGOT);
            event.accept(ModMineralItems.RUBIDIUM_INGOT);
            event.accept(ModMineralItems.STRONTIUM_INGOT);
            event.accept(ModMineralItems.YTTRIUM_INGOT);
            event.accept(ModMineralItems.ZIRCONIUM_INGOT);
            event.accept(ModMineralItems.NIOBIUM_INGOT);
            event.accept(ModMineralItems.MOLYBDENUM_INGOT);
            event.accept(ModMineralItems.TECHNETIUM_INGOT);
            event.accept(ModMineralItems.RUTHENIUM_INGOT);
            event.accept(ModMineralItems.RHODIUM_INGOT);
            event.accept(ModMineralItems.PALLADIUM_INGOT);
            event.accept(ModMineralItems.SILVER_INGOT);
            event.accept(ModMineralItems.CADMIUM_INGOT);
            event.accept(ModMineralItems.INDIUM_INGOT);
            event.accept(ModMineralItems.TIN_INGOT);
            event.accept(ModMineralItems.ANTIMONY_INGOT);
            event.accept(ModMineralItems.TELLURIUM_INGOT);
            event.accept(ModMineralItems.IODINE_INGOT);
            event.accept(ModMineralItems.XENON_INGOT);
            event.accept(ModMineralItems.CESIUM_INGOT);
            event.accept(ModMineralItems.BARIUM_INGOT);
            event.accept(ModMineralItems.LANTHANUM_INGOT);
            event.accept(ModMineralItems.CERIUM_INGOT);
            event.accept(ModMineralItems.PRASEODYMIUM_INGOT);
            event.accept(ModMineralItems.NEODYMIUM_INGOT);
            event.accept(ModMineralItems.PROMETHIUM_INGOT);
            event.accept(ModMineralItems.SAMARIUM_INGOT);
            event.accept(ModMineralItems.EUROPIUM_INGOT);
            event.accept(ModMineralItems.GADOLINIUM_INGOT);
            event.accept(ModMineralItems.TERBIUM_INGOT);
            event.accept(ModMineralItems.DYSPROSIUM_INGOT);
            event.accept(ModMineralItems.HOLMIUM_INGOT);
            event.accept(ModMineralItems.ERBIUM_INGOT);
            event.accept(ModMineralItems.THULIUM_INGOT);
            event.accept(ModMineralItems.YTTERBIUM_INGOT);
            event.accept(ModMineralItems.LUTETIUM_INGOT);
            event.accept(ModMineralItems.HAFNIUM_INGOT);
            event.accept(ModMineralItems.TANTALUM_INGOT);
            event.accept(ModMineralItems.TUNGSTEN_INGOT);
            event.accept(ModMineralItems.RHENIUM_INGOT);
            event.accept(ModMineralItems.OSMIUM_INGOT);
            event.accept(ModMineralItems.IRIDIUM_INGOT);
            event.accept(ModMineralItems.PLATINUM_INGOT);
            //event.accept(ModMineralItems.GOLD_INGOT);
            event.accept(ModMineralItems.MERCURY_INGOT);
            event.accept(ModMineralItems.THALLIUM_INGOT);
            event.accept(ModMineralItems.LEAD_INGOT);
            event.accept(ModMineralItems.BISMUTH_INGOT);
            event.accept(ModMineralItems.POLONIUM_INGOT);
            event.accept(ModMineralItems.ASTATINE_INGOT);
            event.accept(ModMineralItems.RADON_INGOT);
            event.accept(ModMineralItems.FRANCIUM_INGOT);
            event.accept(ModMineralItems.RADIUM_INGOT);
            event.accept(ModMineralItems.ACTINIUM_INGOT);
            event.accept(ModMineralItems.THORIUM_INGOT);
            event.accept(ModMineralItems.PROTACTINIUM_INGOT);
            event.accept(ModMineralItems.URANIUM_INGOT);

        }

        if (event.getTab() == AlloysCreativeModeTab.BMBC_ALLOYS) {
            event.accept(ModAlloyItems.BRASS);
        }

        if (event.getTab() == ModBlocksCreativeModeTab.BMBC_BLOCKS) {
            event.accept(ModBlocks.SILVER_BLOCK);
            event.accept(ModBlocks.SILVER_LAMP);
            event.accept(ModBlocks.GARBAGE_BLOCK);
            event.accept(ModBlocks.URANIUM_BLOCK);

            // Ores
            event.accept(ModBlocks.BAUXITE_ORE);
            event.accept(ModBlocks.CARNALLITE_ORE);
            event.accept(ModBlocks.DOLOMITE_ORE);
            event.accept(ModBlocks.EVAPORITE_ORE);
            event.accept(ModBlocks.MAGNESITE_ORE);
            event.accept(ModBlocks.PEGMATITE_ORE);
            event.accept(ModBlocks.PHOSPHORITE_ORE);
            event.accept(ModBlocks.SILVER_ORE);
            event.accept(ModBlocks.DEEPSLATE_SILVER_ORE);

            // Wood and Trees
            event.accept(ModBlocks.MAPLE_LEAVES);
            event.accept(ModBlocks.MAPLE_LOG);
            event.accept(ModBlocks.MAPLE_PLANKS);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModBlocks.MAPLE_WOOD);
            event.accept(ModBlocks.STRIPPED_MAPLE_LOG);
            event.accept(ModBlocks.STRIPPED_MAPLE_WOOD);

            // Nature
            event.accept(ModBlocks.SILICA_SAND);

        }
        if (event.getTab() == ModMachinesCreativeModeTab.BMBC_MACHINES) {
            //event.accept(ModBlocks.BIOMASS_GENERATOR);
            event.accept(ModBlocks.ALLOY_FURNACE);
            event.accept(ModBlocks.EXTRUDER);
            event.accept(ModBlocks.HYDROELECTRIC_PLANT);
            event.accept(ModBlocks.MACERATOR);
            event.accept(ModBlocks.PRESSURE_VESSEL);
            event.accept(ModBlocks.THREE_D_PRINTER);
        }
        if (event.getTab() == ModChemicalCompoundsCreativeModeTab.CHEMICAL_COMPOUNDS) {
            event.accept(ModChemicalCompounds.ALUMINA);
            event.accept(ModChemicalCompounds.SILICA);
        }
        if (event.getTab() == ModDefaultCreativeModeTab.BMBC) {
            //event.accept(ModItems.BATTERY); TODO: Change to battery once its fixed
            event.accept(ModItems.BLUE_PRINTER_FILAMENT);
            event.accept(ModBlocks.C4);
            event.accept(ModItems.C4_DETONATOR);
            event.accept(ModItems.CABLE_ROLL);
            //event.accept(ModItems.COMPRESSED_CONTAINER);
            event.accept(ModItems.EIGHT_BALL);
            event.accept(ModItems.GREEN_PRINTER_FILAMENT);
            event.accept(ModItems.RED_PRINTER_FILAMENT);
            event.accept(ModItems.BLUE_PLASTIC_SCREW);
            event.accept(ModItems.GREEN_PLASTIC_SCREW);
            event.accept(ModItems.RED_PLASTIC_SCREW);
            event.accept(ModItems.ROD_TEMPLATE);
            event.accept(ModItems.SCREW_TEMPLATE);
            event.accept(ModItems.WIRE_TEMPLATE);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModItems.GARBAGE);

            event.accept(ModItems.PC_PLASTIC);
            event.accept(ModItems.PET_PLASTIC);
            event.accept(ModItems.PP_PLASTIC);
            event.accept(ModItems.PS_PLASTIC);
            event.accept(ModItems.PVC_PLASTIC);
            event.accept(ModItems.HDPE_PLASTIC);
            event.accept(ModItems.LDPE_PLASTIC);

            event.accept(ModItems.NBC_FABRIC);
            event.accept(ModArmorItems.NBC_HAZMAT_MASK);
            event.accept(ModArmorItems.NBC_HAZMAT_CHESTPLATE);
            event.accept(ModArmorItems.NBC_HAZMAT_LEGGINGS);
            event.accept(ModArmorItems.NBC_HAZMAT_BOOTS);

            // TODO: Potentially add Machine Component to its own creative mode tab
            event.accept(ModMachineComponents.COPPER_COIL);
            event.accept(ModMachineComponents.COPPER_FOIL);
            event.accept(ModMachineComponents.COPPER_WIRE);
            event.accept(ModMachineComponents.ELECTRIC_MOTOR);
            event.accept(ModMachineComponents.IRON_ROD);
            event.accept(ModMineralItems.MAGNETIC_IRON_INGOT);
            event.accept(ModMachineComponents.MAGNETIC_IRON_ROD);
            event.accept(ModItems.PCB_HIGH_GRADE_BLANK);
            event.accept(ModItems.PCB_LOW_GRADE_BLANK);

        }
        if (event.getTab() == ModFoodCreativeModTab.FOOD) {
            event.accept(ModFoodItems.COFFEE_CHERRY);
            event.accept(ModFoodItems.COFFEE_BEANS);
        }
        if (event.getTab() == ModFluidsCreativeModeTab.BMBC_FLUIDS) {
            event.accept(ModItems.ACETONE_BUCKET);
            event.accept(ModItems.BISPHENOL_BUCKET);
            event.accept(ModItems.CHLORINE_BUCKET);
            event.accept(ModItems.EPOXY_RESIN_FLUID);
            event.accept(ModItems.HYDROCHLORIC_ACID_BUCKET);
            event.accept(ModItems.LIQUID_HELIUM_BUCKET);
            event.accept(ModItems.LIQUID_NITROGEN_BUCKET);
            event.accept(ModItems.LIQUID_OXYGEN_BUCKET);
            event.accept(ModItems.PHENOL_BUCKET);
            event.accept(ModItems.PROPANE_BUCKET);
            event.accept(ModItems.SEWAGE_WATER_BUCKET);
            event.accept(ModItems.SODIUM_HYDROXIDE_BUCKET);

        }

        if (event.getTab() == ModGasCreativeModeTab.BMBC_GASSES) {
            event.accept(GasStorageItems.COMPRESSED_HYDROGEN);
            event.accept(GasStorageItems.COMPRESSED_HELIUM);
            event.accept(GasStorageItems.COMPRESSED_LITHIUM);
            event.accept(GasStorageItems.COMPRESSED_BERYLLIUM);
            event.accept(GasStorageItems.COMPRESSED_BORON);
            event.accept(GasStorageItems.COMPRESSED_CARBON);
            event.accept(GasStorageItems.COMPRESSED_NITROGEN);
            event.accept(GasStorageItems.COMPRESSED_OXYGEN);
            event.accept(GasStorageItems.COMPRESSED_FLUORINE);
            event.accept(GasStorageItems.COMPRESSED_NEON);
            event.accept(GasStorageItems.COMPRESSED_SODIUM);
            event.accept(GasStorageItems.COMPRESSED_MAGNESIUM);
            event.accept(GasStorageItems.COMPRESSED_ALUMINIUM);
            event.accept(GasStorageItems.COMPRESSED_SILICON);
            event.accept(GasStorageItems.COMPRESSED_PHOSPHORUS);
            event.accept(GasStorageItems.COMPRESSED_SULFUR);
            event.accept(GasStorageItems.COMPRESSED_CHLORINE);
            event.accept(GasStorageItems.COMPRESSED_ARGON);
            event.accept(GasStorageItems.COMPRESSED_POTASSIUM);
            event.accept(GasStorageItems.COMPRESSED_CALCIUM);
            event.accept(GasStorageItems.COMPRESSED_SCANDIUM);
            event.accept(GasStorageItems.COMPRESSED_TITANIUM);
            event.accept(GasStorageItems.COMPRESSED_VANADIUM);
            event.accept(GasStorageItems.COMPRESSED_CHROMIUM);
            event.accept(GasStorageItems.COMPRESSED_MANGANESE);
            event.accept(GasStorageItems.COMPRESSED_IRON);
            event.accept(GasStorageItems.COMPRESSED_COBALT);
            event.accept(GasStorageItems.COMPRESSED_NICKEL);
            event.accept(GasStorageItems.COMPRESSED_COPPER);
            event.accept(GasStorageItems.COMPRESSED_ZINC);
            event.accept(GasStorageItems.COMPRESSED_GALLIUM);
            event.accept(GasStorageItems.COMPRESSED_GERMANIUM);
            event.accept(GasStorageItems.COMPRESSED_ARSENIC);
            event.accept(GasStorageItems.COMPRESSED_SELENIUM);
            event.accept(GasStorageItems.COMPRESSED_BROMINE);
            event.accept(GasStorageItems.COMPRESSED_KRYPTON);
            event.accept(GasStorageItems.COMPRESSED_RUBIDIUM);
            event.accept(GasStorageItems.COMPRESSED_STRONTIUM);
            event.accept(GasStorageItems.COMPRESSED_YTTRIUM);
            event.accept(GasStorageItems.COMPRESSED_ZIRCONIUM);
            event.accept(GasStorageItems.COMPRESSED_NIOBIUM);
            event.accept(GasStorageItems.COMPRESSED_MOLYBDENUM);
            event.accept(GasStorageItems.COMPRESSED_TECHNETIUM);
            event.accept(GasStorageItems.COMPRESSED_RUTHENIUM);
            event.accept(GasStorageItems.COMPRESSED_RHODIUM);
            event.accept(GasStorageItems.COMPRESSED_PALLADIUM);
            event.accept(GasStorageItems.COMPRESSED_SILVER);
            event.accept(GasStorageItems.COMPRESSED_CADMIUM);
            event.accept(GasStorageItems.COMPRESSED_INDIUM);
            event.accept(GasStorageItems.COMPRESSED_TIN);
            event.accept(GasStorageItems.COMPRESSED_ANTIMONY);
            event.accept(GasStorageItems.COMPRESSED_TELLURIUM);
            event.accept(GasStorageItems.COMPRESSED_IODINE);
            event.accept(GasStorageItems.COMPRESSED_XENON);
            event.accept(GasStorageItems.COMPRESSED_CESIUM);
            event.accept(GasStorageItems.COMPRESSED_BARIUM);
            event.accept(GasStorageItems.COMPRESSED_LANTHANUM);
            event.accept(GasStorageItems.COMPRESSED_CERIUM);
            event.accept(GasStorageItems.COMPRESSED_PRASEODYMIUM);
            event.accept(GasStorageItems.COMPRESSED_NEODYMIUM);
            event.accept(GasStorageItems.COMPRESSED_PROMETHIUM);
            event.accept(GasStorageItems.COMPRESSED_SAMARIUM);
            event.accept(GasStorageItems.COMPRESSED_EUROPIUM);
            event.accept(GasStorageItems.COMPRESSED_GADOLINIUM);
            event.accept(GasStorageItems.COMPRESSED_TERBIUM);
            event.accept(GasStorageItems.COMPRESSED_DYSPROSIUM);
            event.accept(GasStorageItems.COMPRESSED_HOLMIUM);
            event.accept(GasStorageItems.COMPRESSED_ERBIUM);
            event.accept(GasStorageItems.COMPRESSED_THULIUM);
            event.accept(GasStorageItems.COMPRESSED_YTTERBIUM);
            event.accept(GasStorageItems.COMPRESSED_LUTETIUM);
            event.accept(GasStorageItems.COMPRESSED_HAFNIUM);
            event.accept(GasStorageItems.COMPRESSED_TANTALUM);
            event.accept(GasStorageItems.COMPRESSED_TUNGSTEN);
            event.accept(GasStorageItems.COMPRESSED_RHENIUM);
            event.accept(GasStorageItems.COMPRESSED_OSMIUM);
            event.accept(GasStorageItems.COMPRESSED_IRIDIUM);
            event.accept(GasStorageItems.COMPRESSED_PLATINUM);
            event.accept(GasStorageItems.COMPRESSED_GOLD);
            event.accept(GasStorageItems.COMPRESSED_MERCURY);
            event.accept(GasStorageItems.COMPRESSED_THALLIUM);
            event.accept(GasStorageItems.COMPRESSED_LEAD);
            event.accept(GasStorageItems.COMPRESSED_BISMUTH);
            event.accept(GasStorageItems.COMPRESSED_POLONIUM);
            event.accept(GasStorageItems.COMPRESSED_ASTATINE);
            event.accept(GasStorageItems.COMPRESSED_RADON);
            event.accept(GasStorageItems.COMPRESSED_FRANCIUM);
            event.accept(GasStorageItems.COMPRESSED_RADIUM);
            event.accept(GasStorageItems.COMPRESSED_ACTINIUM);
            event.accept(GasStorageItems.COMPRESSED_THORIUM);
            event.accept(GasStorageItems.COMPRESSED_PROTACTINIUM);
            event.accept(GasStorageItems.COMPRESSED_URANIUM);
        }

        //if (event.getTab() == ExplosivesCreativeModeTab.BMBC_EXPLOSIVES) {
        //  //event.accept(GasStorageItems.ModBlocks.C4);
        //  //event.accept(ModItems.C4_DETONATOR);
        //}

        if (event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.MAPLE_LEAVES);
            event.accept(ModBlocks.MAPLE_LOG);
            event.accept(ModBlocks.MAPLE_SAPLING);
            event.accept(ModBlocks.SILICA_SAND);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        //ModVillagers.registerPOIs();
        event.enqueueWork(ModNetworkingPackets::register);
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SEWAGE_WATER.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SEWAGE_WATER.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SODIUM_HYDROXIDE.get(), RenderType.solid());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SODIUM_HYDROXIDE.get(), RenderType.solid());

            MenuScreens.register(ModMenuTypes.ALLOY_FURNACE_MENU.get(), AlloyFurnaceScreen::new);
            MenuScreens.register(ModMenuTypes.BIOMASS_GENERATOR_MENU.get(), BiomassGeneratorScreen::new);
            MenuScreens.register(ModMenuTypes.EXTRUDER_MENU.get(), ExtruderScreen::new);
            MenuScreens.register(ModMenuTypes.HYDROELECTRIC_PLANT_MENU.get(), HydroelectricPlantScreen::new);
            MenuScreens.register(ModMenuTypes.MACERATOR_MENU.get(), MaceratorScreen::new);
            MenuScreens.register(ModMenuTypes.PRESSURE_VESSEL_MENU.get(), PressureVesselScreen::new);
            MenuScreens.register(ModMenuTypes.THREE_D_PRINTER_MENU.get(), ThreeDPrinterScreen::new);

        }
    }
}
