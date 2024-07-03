package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CompoundItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // All Generic Compounds
    // Solid
    public static final Compound HYDROGEN_COMPOUND = new Compound(ElementItems.HYDROGEN);
    public static final Compound HELIUM_COMPOUND = new Compound(ElementItems.HELIUM);
    public static final Compound LITHIUM_COMPOUND = new Compound(ElementItems.LITHIUM);
    public static final Compound BERYLLIUM_COMPOUND = new Compound(ElementItems.BERYLLIUM);
    public static final Compound BORON_COMPOUND = new Compound(ElementItems.BORON);
    public static final Compound CARBON_COMPOUND = new Compound(ElementItems.CARBON);
    public static final Compound NITROGEN_COMPOUND = new Compound(ElementItems.NITROGEN);
    public static final Compound OXYGEN_COMPOUND = new Compound(ElementItems.OXYGEN);
    public static final Compound FLUORINE_COMPOUND = new Compound(ElementItems.FLUORINE);
    public static final Compound NEON_COMPOUND = new Compound(ElementItems.NEON);
    public static final Compound SODIUM_COMPOUND = new Compound(ElementItems.SODIUM);
    public static final Compound MAGNESIUM_COMPOUND = new Compound(ElementItems.MAGNESIUM);
    public static final Compound ALUMINIUM_COMPOUND = new Compound(ElementItems.ALUMINIUM);
    public static final Compound SILICON_COMPOUND = new Compound(ElementItems.SILICON);
    public static final Compound PHOSPHORUS_COMPOUND = new Compound(ElementItems.PHOSPHORUS);
    public static final Compound SULFUR_COMPOUND = new Compound(ElementItems.SULFUR);
    public static final Compound CHLORINE_COMPOUND = new Compound(ElementItems.CHLORINE);
    public static final Compound ARGON_COMPOUND = new Compound(ElementItems.ARGON);
    public static final Compound POTASSIUM_COMPOUND = new Compound(ElementItems.POTASSIUM);
    public static final Compound CALCIUM_COMPOUND = new Compound(ElementItems.CALCIUM);
    public static final Compound SCANDIUM_COMPOUND = new Compound(ElementItems.SCANDIUM);
    public static final Compound TITANIUM_COMPOUND = new Compound(ElementItems.TITANIUM);
    public static final Compound VANADIUM_COMPOUND = new Compound(ElementItems.VANADIUM);
    public static final Compound CHROMIUM_COMPOUND = new Compound(ElementItems.CHROMIUM);
    public static final Compound MANGANESE_COMPOUND = new Compound(ElementItems.MANGANESE);
    public static final Compound IRON_COMPOUND = new Compound(ElementItems.IRON);
    public static final Compound COBALT_COMPOUND = new Compound(ElementItems.COBALT);
    public static final Compound NICKEL_COMPOUND = new Compound(ElementItems.NICKEL);
    public static final Compound COPPER_COMPOUND = new Compound(ElementItems.COPPER);
    public static final Compound ZINC_COMPOUND = new Compound(ElementItems.ZINC);
    public static final Compound GALLIUM_COMPOUND = new Compound(ElementItems.GALLIUM);
    public static final Compound GERMANIUM_COMPOUND = new Compound(ElementItems.GERMANIUM);
    public static final Compound ARSENIC_COMPOUND = new Compound(ElementItems.ARSENIC);
    public static final Compound SELENIUM_COMPOUND = new Compound(ElementItems.SELENIUM);
    public static final Compound BROMINE_COMPOUND = new Compound(ElementItems.BROMINE);
    public static final Compound KRYPTON_COMPOUND = new Compound(ElementItems.KRYPTON);
    public static final Compound RUBIDIUM_COMPOUND = new Compound(ElementItems.RUBIDIUM);
    public static final Compound STRONTIUM_COMPOUND = new Compound(ElementItems.STRONTIUM);
    public static final Compound YTTRIUM_COMPOUND = new Compound(ElementItems.YTTRIUM);
    public static final Compound ZIRCONIUM_COMPOUND = new Compound(ElementItems.ZIRCONIUM);
    public static final Compound NIOBIUM_COMPOUND = new Compound(ElementItems.NIOBIUM);
    public static final Compound MOLYBDENUM_COMPOUND = new Compound(ElementItems.MOLYBDENUM);
    public static final Compound TECHNETIUM_COMPOUND = new Compound(ElementItems.TECHNETIUM);
    public static final Compound RUTHENIUM_COMPOUND = new Compound(ElementItems.RUTHENIUM);
    public static final Compound RHODIUM_COMPOUND = new Compound(ElementItems.RHODIUM);
    public static final Compound PALLADIUM_COMPOUND = new Compound(ElementItems.PALLADIUM);
    public static final Compound SILVER_COMPOUND = new Compound(ElementItems.SILVER);
    public static final Compound CADMIUM_COMPOUND = new Compound(ElementItems.CADMIUM);
    public static final Compound INDIUM_COMPOUND = new Compound(ElementItems.INDIUM);
    public static final Compound TIN_COMPOUND = new Compound(ElementItems.TIN);
    public static final Compound ANTIMONY_COMPOUND = new Compound(ElementItems.ANTIMONY);
    public static final Compound TELLURIUM_COMPOUND = new Compound(ElementItems.TELLURIUM);
    public static final Compound IODINE_COMPOUND = new Compound(ElementItems.IODINE);
    public static final Compound XENON_COMPOUND = new Compound(ElementItems.XENON);
    public static final Compound CESIUM_COMPOUND = new Compound(ElementItems.CESIUM);
    public static final Compound BARIUM_COMPOUND = new Compound(ElementItems.BARIUM);
    public static final Compound LANTHANUM_COMPOUND = new Compound(ElementItems.LANTHANUM);
    public static final Compound CERIUM_COMPOUND = new Compound(ElementItems.CERIUM);
    public static final Compound PRASEODYMIUM_COMPOUND = new Compound(ElementItems.PRASEODYMIUM);
    public static final Compound NEODYMIUM_COMPOUND = new Compound(ElementItems.NEODYMIUM);
    public static final Compound PROMETHIUM_COMPOUND = new Compound(ElementItems.PROMETHIUM);
    public static final Compound SAMARIUM_COMPOUND = new Compound(ElementItems.SAMARIUM);
    public static final Compound EUROPIUM_COMPOUND = new Compound(ElementItems.EUROPIUM);
    public static final Compound GADOLINIUM_COMPOUND = new Compound(ElementItems.GADOLINIUM);
    public static final Compound TERBIUM_COMPOUND = new Compound(ElementItems.TERBIUM);
    public static final Compound DYSPROSIUM_COMPOUND = new Compound(ElementItems.DYSPROSIUM);
    public static final Compound HOLMIUM_COMPOUND = new Compound(ElementItems.HOLMIUM);
    public static final Compound ERBIUM_COMPOUND = new Compound(ElementItems.ERBIUM);
    public static final Compound THULIUM_COMPOUND = new Compound(ElementItems.THULIUM);
    public static final Compound YTTERBIUM_COMPOUND = new Compound(ElementItems.YTTERBIUM);
    public static final Compound LUTETIUM_COMPOUND = new Compound(ElementItems.LUTETIUM);
    public static final Compound HAFNIUM_COMPOUND = new Compound(ElementItems.HAFNIUM);
    public static final Compound TANTALUM_COMPOUND = new Compound(ElementItems.TANTALUM);
    public static final Compound TUNGSTEN_COMPOUND = new Compound(ElementItems.TUNGSTEN);
    public static final Compound RHENIUM_COMPOUND = new Compound(ElementItems.RHENIUM);
    public static final Compound OSMIUM_COMPOUND = new Compound(ElementItems.OSMIUM);
    public static final Compound IRIDIUM_COMPOUND = new Compound(ElementItems.IRIDIUM);
    public static final Compound PLATINUM_COMPOUND = new Compound(ElementItems.PLATINUM);
    public static final Compound GOLD_COMPOUND = new Compound(ElementItems.GOLD);
    public static final Compound MERCURY_COMPOUND = new Compound(ElementItems.MERCURY);
    public static final Compound THALLIUM_COMPOUND = new Compound(ElementItems.THALLIUM);
    public static final Compound LEAD_COMPOUND = new Compound(ElementItems.LEAD);
    public static final Compound BISMUTH_COMPOUND = new Compound(ElementItems.BISMUTH);
    public static final Compound POLONIUM_COMPOUND = new Compound(ElementItems.POLONIUM);
    public static final Compound ASTATINE_COMPOUND = new Compound(ElementItems.ASTATINE);
    public static final Compound RADON_COMPOUND = new Compound(ElementItems.RADON);
    public static final Compound FRANCIUM_COMPOUND = new Compound(ElementItems.FRANCIUM);
    public static final Compound RADIUM_COMPOUND = new Compound(ElementItems.RADIUM);
    public static final Compound ACTINIUM_COMPOUND = new Compound(ElementItems.ACTINIUM);
    public static final Compound THORIUM_COMPOUND = new Compound(ElementItems.THORIUM);
    public static final Compound PROTACTINIUM_COMPOUND = new Compound(ElementItems.PROTACTINIUM);
    public static final Compound URANIUM_COMPOUND = new Compound(ElementItems.URANIUM);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
