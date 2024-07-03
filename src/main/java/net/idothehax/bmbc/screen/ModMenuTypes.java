package net.matty.bmbc.screen;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(ForgeRegistries.MENU_TYPES, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<MenuType<AlloyFurnaceMenu>> ALLOY_FURNACE_MENU =
            registerMenuType(AlloyFurnaceMenu::new, "alloy_furnace_menu");

    public static final RegistryObject<MenuType<BiomassGeneratorMenu>> BIOMASS_GENERATOR_MENU =
            registerMenuType(BiomassGeneratorMenu::new, "biomass_generator_menu");

    public static final RegistryObject<MenuType<ExtruderMenu>> EXTRUDER_MENU =
            registerMenuType(ExtruderMenu::new, "extruder_menu");

    public static final RegistryObject<MenuType<HydroelectricPlantMenu>> HYDROELECTRIC_PLANT_MENU =
            registerMenuType(HydroelectricPlantMenu::new, "hydroelectric_plant_menu");

    public static final RegistryObject<MenuType<MaceratorMenu>> MACERATOR_MENU =
            registerMenuType(MaceratorMenu::new, "macerator_menu");

    //public static final RegistryObject<MenuType<NuclearBombMenu>> NUCLEAR_BOMB_MENU =
    //        registerMenuType(NuclearBombMenu::new, "nuclear_bomb_menu");

    public static final RegistryObject<MenuType<PressureVesselMenu>> PRESSURE_VESSEL_MENU =
            registerMenuType(PressureVesselMenu::new, "pressure_vessel_menu");

    public static final RegistryObject<MenuType<ThreeDPrinterMenu>> THREE_D_PRINTER_MENU =
            registerMenuType(ThreeDPrinterMenu::new, "three_d_printer_menu");


    private static <T extends AbstractContainerMenu> RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return MENUS.register(name, () -> IForgeMenuType.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
