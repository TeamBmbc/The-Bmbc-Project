package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.item.custom.tooltips.MineralWithToolTipItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMineralItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    
    // Magnetic Iron
    public static final RegistryObject<Item> MAGNETIC_IRON_INGOT = ITEMS.register("magnetic_iron_ingot",
            () -> new MineralWithToolTipItem(new Item.Properties()
                    ,"Chem. Formula: ", "Fe"));
    // Solid
    public static final RegistryObject<Item> HYDROGEN_INGOT = ITEMS.register("hydrogen_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.HYDROGEN_COMPOUND));
    public static final RegistryObject<Item> HELIUM_INGOT = ITEMS.register("helium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.HELIUM_COMPOUND));
    public static final RegistryObject<Item> LITHIUM_INGOT = ITEMS.register("lithium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.LITHIUM_COMPOUND));
    public static final RegistryObject<Item> BERYLLIUM_INGOT = ITEMS.register("beryllium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.BERYLLIUM_COMPOUND));
    public static final RegistryObject<Item> BORON_INGOT = ITEMS.register("boron_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.BORON_COMPOUND));
    public static final RegistryObject<Item> CARBON_INGOT = ITEMS.register("carbon_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.CARBON_COMPOUND));
    public static final RegistryObject<Item> NITROGEN_INGOT = ITEMS.register("nitrogen_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.NITROGEN_COMPOUND));
    public static final RegistryObject<Item> OXYGEN_INGOT = ITEMS.register("oxygen_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.OXYGEN_COMPOUND));
    public static final RegistryObject<Item> FLUORINE_INGOT = ITEMS.register("fluorine_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.FLUORINE_COMPOUND));
    public static final RegistryObject<Item> NEON_INGOT = ITEMS.register("neon_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.NEON_COMPOUND));
    public static final RegistryObject<Item> SODIUM_INGOT = ITEMS.register("sodium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.SODIUM_COMPOUND));
    public static final RegistryObject<Item> MAGNESIUM_INGOT = ITEMS.register("magnesium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.MAGNESIUM_COMPOUND));
    public static final RegistryObject<Item> ALUMINIUM_INGOT = ITEMS.register("aluminium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ALUMINIUM_COMPOUND));
    public static final RegistryObject<Item> SILICON_CRYSTAL = ITEMS.register("silicon_crystal", () -> new CompoundItem(new Item.Properties(), CompoundItems.SILICON_COMPOUND));
    public static final RegistryObject<Item> WHITE_PHOSPHORUS = ITEMS.register("white_phosphorus", () -> new CompoundItem(new Item.Properties(), CompoundItems.PHOSPHORUS_COMPOUND));
    public static final RegistryObject<Item> RED_PHOSPHORUS = ITEMS.register("red_phosphorus", () -> new CompoundItem(new Item.Properties(), CompoundItems.PHOSPHORUS_COMPOUND));
    public static final RegistryObject<Item> BLACK_PHOSPHORUS = ITEMS.register("black_phosphorus", () -> new CompoundItem(new Item.Properties(), CompoundItems.PHOSPHORUS_COMPOUND));
    public static final RegistryObject<Item> SULFUR_CRYSTAL = ITEMS.register("sulfur_crystal", () -> new CompoundItem(new Item.Properties(), CompoundItems.SULFUR_COMPOUND));
    public static final RegistryObject<Item> CHLORINE_INGOT = ITEMS.register("chlorine_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.CHLORINE_COMPOUND));
    public static final RegistryObject<Item> ARGON_INGOT = ITEMS.register("argon_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ARGON_COMPOUND));
    public static final RegistryObject<Item> POTASSIUM_INGOT = ITEMS.register("potassium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.POTASSIUM_COMPOUND));
    public static final RegistryObject<Item> CALCIUM_ROCK = ITEMS.register("calcium_rock", () -> new CompoundItem(new Item.Properties(), CompoundItems.CALCIUM_COMPOUND));
    public static final RegistryObject<Item> SCANDIUM_INGOT = ITEMS.register("scandium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.SCANDIUM_COMPOUND));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TITANIUM_COMPOUND));
    public static final RegistryObject<Item> VANADIUM_INGOT = ITEMS.register("vanadium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.VANADIUM_COMPOUND));
    public static final RegistryObject<Item> CHROMIUM_CRYSTAL = ITEMS.register("chromium_crystal", () -> new CompoundItem(new Item.Properties(), CompoundItems.CHROMIUM_COMPOUND));
    public static final RegistryObject<Item> MANGANESE_INGOT = ITEMS.register("manganese_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.MANGANESE_COMPOUND));
    //public static final RegistryObject<Item> IRON_INGOT = ITEMS.register("iron_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.IRON_COMPOUND));
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.COBALT_COMPOUND));
    public static final RegistryObject<Item> NICKEL_INGOT = ITEMS.register("nickel_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.NICKEL_COMPOUND));
    //public static final RegistryObject<Item> COPPER_INGOT = ITEMS.register("copper_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.COPPER_COMPOUND));
    public static final RegistryObject<Item> ZINC_INGOT = ITEMS.register("zinc_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ZINC_COMPOUND));
    public static final RegistryObject<Item> GALLIUM_INGOT = ITEMS.register("gallium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.GALLIUM_COMPOUND));
    public static final RegistryObject<Item> GERMANIUM_INGOT = ITEMS.register("germanium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.GERMANIUM_COMPOUND));
    public static final RegistryObject<Item> ARSENIC_INGOT = ITEMS.register("arsenic_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ARSENIC_COMPOUND));
    public static final RegistryObject<Item> SELENIUM_INGOT = ITEMS.register("selenium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.SELENIUM_COMPOUND));
    public static final RegistryObject<Item> BROMINE_INGOT = ITEMS.register("bromine_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.BROMINE_COMPOUND));
    public static final RegistryObject<Item> KRYPTON_INGOT = ITEMS.register("krypton_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.KRYPTON_COMPOUND));
    public static final RegistryObject<Item> RUBIDIUM_INGOT = ITEMS.register("rubidium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.RUBIDIUM_COMPOUND));
    public static final RegistryObject<Item> STRONTIUM_INGOT = ITEMS.register("strontium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.STRONTIUM_COMPOUND));
    public static final RegistryObject<Item> YTTRIUM_INGOT = ITEMS.register("yttrium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.YTTRIUM_COMPOUND));
    public static final RegistryObject<Item> ZIRCONIUM_INGOT = ITEMS.register("zirconium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ZIRCONIUM_COMPOUND));
    public static final RegistryObject<Item> NIOBIUM_INGOT = ITEMS.register("niobium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.NIOBIUM_COMPOUND));
    public static final RegistryObject<Item> MOLYBDENUM_INGOT = ITEMS.register("molybdenum_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.MOLYBDENUM_COMPOUND));
    public static final RegistryObject<Item> TECHNETIUM_INGOT = ITEMS.register("technetium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TECHNETIUM_COMPOUND));
    public static final RegistryObject<Item> RUTHENIUM_INGOT = ITEMS.register("ruthenium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.RUTHENIUM_COMPOUND));
    public static final RegistryObject<Item> RHODIUM_INGOT = ITEMS.register("rhodium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.RHODIUM_COMPOUND));
    public static final RegistryObject<Item> PALLADIUM_INGOT = ITEMS.register("palladium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.PALLADIUM_COMPOUND));
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.SILVER_COMPOUND));
    public static final RegistryObject<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.CADMIUM_COMPOUND));
    public static final RegistryObject<Item> INDIUM_INGOT = ITEMS.register("indium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.INDIUM_COMPOUND));
    public static final RegistryObject<Item> TIN_INGOT = ITEMS.register("tin_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TIN_COMPOUND));
    public static final RegistryObject<Item> ANTIMONY_INGOT = ITEMS.register("antimony_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ANTIMONY_COMPOUND));
    public static final RegistryObject<Item> TELLURIUM_INGOT = ITEMS.register("tellurium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TELLURIUM_COMPOUND));
    public static final RegistryObject<Item> IODINE_INGOT = ITEMS.register("iodine_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.IODINE_COMPOUND));
    public static final RegistryObject<Item> XENON_INGOT = ITEMS.register("xenon_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.XENON_COMPOUND));
    public static final RegistryObject<Item> CESIUM_INGOT = ITEMS.register("cesium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.CESIUM_COMPOUND));
    public static final RegistryObject<Item> BARIUM_INGOT = ITEMS.register("barium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.BARIUM_COMPOUND));
    public static final RegistryObject<Item> LANTHANUM_INGOT = ITEMS.register("lanthanum_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.LANTHANUM_COMPOUND));
    public static final RegistryObject<Item> CERIUM_INGOT = ITEMS.register("cerium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.CERIUM_COMPOUND));
    public static final RegistryObject<Item> PRASEODYMIUM_INGOT = ITEMS.register("praseodymium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.PRASEODYMIUM_COMPOUND));
    public static final RegistryObject<Item> NEODYMIUM_INGOT = ITEMS.register("neodymium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.NEODYMIUM_COMPOUND));
    public static final RegistryObject<Item> PROMETHIUM_INGOT = ITEMS.register("promethium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.PROMETHIUM_COMPOUND));
    public static final RegistryObject<Item> SAMARIUM_INGOT = ITEMS.register("samarium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.SAMARIUM_COMPOUND));
    public static final RegistryObject<Item> EUROPIUM_INGOT = ITEMS.register("europium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.EUROPIUM_COMPOUND));
    public static final RegistryObject<Item> GADOLINIUM_INGOT = ITEMS.register("gadolinium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.GADOLINIUM_COMPOUND));
    public static final RegistryObject<Item> TERBIUM_INGOT = ITEMS.register("terbium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TERBIUM_COMPOUND));
    public static final RegistryObject<Item> DYSPROSIUM_INGOT = ITEMS.register("dysprosium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.DYSPROSIUM_COMPOUND));
    public static final RegistryObject<Item> HOLMIUM_INGOT = ITEMS.register("holmium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.HOLMIUM_COMPOUND));
    public static final RegistryObject<Item> ERBIUM_INGOT = ITEMS.register("erbium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ERBIUM_COMPOUND));
    public static final RegistryObject<Item> THULIUM_INGOT = ITEMS.register("thulium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.THULIUM_COMPOUND));
    public static final RegistryObject<Item> YTTERBIUM_INGOT = ITEMS.register("ytterbium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.YTTERBIUM_COMPOUND));
    public static final RegistryObject<Item> LUTETIUM_INGOT = ITEMS.register("lutetium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.LUTETIUM_COMPOUND));
    public static final RegistryObject<Item> HAFNIUM_INGOT = ITEMS.register("hafnium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.HAFNIUM_COMPOUND));
    public static final RegistryObject<Item> TANTALUM_INGOT = ITEMS.register("tantalum_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TANTALUM_COMPOUND));
    public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.TUNGSTEN_COMPOUND));
    public static final RegistryObject<Item> RHENIUM_INGOT = ITEMS.register("rhenium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.RHENIUM_COMPOUND));
    public static final RegistryObject<Item> OSMIUM_INGOT = ITEMS.register("osmium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.OSMIUM_COMPOUND));
    public static final RegistryObject<Item> IRIDIUM_INGOT = ITEMS.register("iridium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.IRIDIUM_COMPOUND));
    public static final RegistryObject<Item> PLATINUM_INGOT = ITEMS.register("platinum_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.PLATINUM_COMPOUND));
    //public static final RegistryObject<Item> GOLD_INGOT = ITEMS.register("gold_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.GOLD_COMPOUND));
    public static final RegistryObject<Item> MERCURY_INGOT = ITEMS.register("mercury_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.MERCURY_COMPOUND));
    public static final RegistryObject<Item> THALLIUM_INGOT = ITEMS.register("thallium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.THALLIUM_COMPOUND));
    public static final RegistryObject<Item> LEAD_INGOT = ITEMS.register("lead_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.LEAD_COMPOUND));
    public static final RegistryObject<Item> BISMUTH_INGOT = ITEMS.register("bismuth_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.BISMUTH_COMPOUND));
    public static final RegistryObject<Item> POLONIUM_INGOT = ITEMS.register("polonium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.POLONIUM_COMPOUND));
    public static final RegistryObject<Item> ASTATINE_INGOT = ITEMS.register("astatine_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ASTATINE_COMPOUND));
    public static final RegistryObject<Item> RADON_INGOT = ITEMS.register("radon_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.RADON_COMPOUND));
    public static final RegistryObject<Item> FRANCIUM_INGOT = ITEMS.register("francium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.FRANCIUM_COMPOUND));
    public static final RegistryObject<Item> RADIUM_INGOT = ITEMS.register("radium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.RADIUM_COMPOUND));
    public static final RegistryObject<Item> ACTINIUM_INGOT = ITEMS.register("actinium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.ACTINIUM_COMPOUND));
    public static final RegistryObject<Item> THORIUM_INGOT = ITEMS.register("thorium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.THORIUM_COMPOUND));
    public static final RegistryObject<Item> PROTACTINIUM_INGOT = ITEMS.register("protactinium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.PROTACTINIUM_COMPOUND));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot", () -> new CompoundItem(new Item.Properties(), CompoundItems.URANIUM_COMPOUND));


    // Ores and Minerals
    public static final RegistryObject<Item> CARNALLITE = ITEMS.register("carnallite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "KMgCl₃·6(H₂O)"));
    public static final RegistryObject<Item> CRUSHED_BAUXITE = ITEMS.register("crushed_bauxite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "Al₂H₂O₄"));
    public static final RegistryObject<Item> DOLOMITE = ITEMS.register("dolomite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "CaMg(CO₃)₂"));
    public static final RegistryObject<Item> EVAPORITE = ITEMS.register("evaporite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "NaCl"));
    public static final RegistryObject<Item> MAGNESITE = ITEMS.register("magnesite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "MgCO₃"));
    public static final RegistryObject<Item> PEGMATITE = ITEMS.register("pegmatite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHOSPHORITE = ITEMS.register("phosphorite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "Ca₅(PO₄)F₃"));
    public static final RegistryObject<Item> BAUXITE = ITEMS.register("raw_bauxite", () -> new MineralWithToolTipItem(new Item.Properties(), "Chem. Formula: ", "Al₂H₂O₄"));
    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
