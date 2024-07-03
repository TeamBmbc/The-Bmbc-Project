package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.element.Element;
import net.matty.bmbc.element.ElementRegister;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ElementItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // https://www.angelo.edu/faculty/kboudrea/periodic/physical_states.html
    public static final Element HYDROGEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "hydrogen"), "H", 1), -259.14, -252.87);
    public static final Element HELIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "helium"), "He", 2), -272.2, -268.934);
    public static final Element LITHIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "lithium"), "Li", 3), 180.54, 1347);
    public static final Element BERYLLIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "beryllium"), "Be", 4), 1278, 2970);
    public static final Element BORON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "boron"), "B", 5), 2300, 3658);
    public static final Element CARBON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "carbon"), "C", 6), 3527, 4827);
    public static final Element NITROGEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "nitrogen"), "N", 7), -209.86, -195.8);
    public static final Element OXYGEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "oxygen"), "O", 8), -218.4, -182.96);
    public static final Element FLUORINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "fluorine"), "F", 9), -219.62, -118.14);
    public static final Element NEON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "neon"), "Ne", 10), -248.67, -246.05);
    public static final Element SODIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "sodium"), "Na", 11), 97.81, 882.9);
    public static final Element MAGNESIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "magnesium"), "Mg", 12), 648.8, 1090);
    public static final Element ALUMINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "aluminium"), "Al", 13), 660.37, 2467);
    public static final Element SILICON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "silicon"), "Si", 14), 1410, 2355);
    public static final Element PHOSPHORUS = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "phosphorus"), "P", 15), 44.1, 280);
    public static final Element SULFUR = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "sulfur"), "S", 16), 130, 444.67);
    public static final Element CHLORINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "chlorine"), "Cl", 17), -100.98, -33.97);
    public static final Element ARGON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "argon"), "Ar", 18), -189.37, -185.86);
    public static final Element POTASSIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "potassium"), "K", 19), 63.65, 774);
    public static final Element CALCIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "calcium"), "Ca", 20), 839, 1484);
    public static final Element SCANDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "scandium"), "Sc", 21), 1541, 2831);
    public static final Element TITANIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "titanium"), "Ti", 22), 1660, 3287);
    public static final Element VANADIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "vanadium"), "V", 23), 1887, 3377);
    public static final Element CHROMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "chromium"), "Cr", 24), 1857, 2672);
    public static final Element MANGANESE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "manganese"), "Mn", 25), 1244, 1962);
    public static final Element IRON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "iron"), "Fe", 26), 1535, 2750); // apart from the element...
    public static final Element COBALT = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "cobalt"), "Co", 27), 1495, 2870);
    public static final Element NICKEL = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "nickel"), "Ni", 28), 1453, 2732);
    public static final Element COPPER = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "copper"), "Cu", 29), 1083.4, 2567);
    public static final Element ZINC = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "zinc"), "Zn", 30), 419.58, 907);
    public static final Element GALLIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "gallium"), "Ga", 31), 29.78, 2403);
    public static final Element GERMANIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "germanium"), "Ge", 32), 937.4, 2830);
    public static final Element ARSENIC = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "arsenic"), "As", 33), 817, 817.0000001);
    public static final Element SELENIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "selenium"), "Se", 34), 217, 684.9);
    public static final Element BROMINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bromine"), "Br", 35), -7.3, 58.78);
    public static final Element KRYPTON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "krypton"), "Kr", 36), -156.6, -152.3);
    public static final Element RUBIDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "rubidium"), "Rb", 37), 39, 688);
    public static final Element STRONTIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "strontium"), "Sr", 38), 769, 1384);
    public static final Element YTTRIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "yttrium"), "Y", 39), 1522, 3338);
    public static final Element ZIRCONIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "zirconium"), "Zr", 40), 1852, 4377);
    public static final Element NIOBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "niobium"), "Nb", 41), 2468, 4742);
    public static final Element MOLYBDENUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "molybdenum"), "Mo", 42), 2617, 4612);
    public static final Element TECHNETIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "technetium"), "Tc", 43), 2172, 4877);
    public static final Element RUTHENIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "ruthenium"), "Ru", 44), 2310, 3900);
    public static final Element RHODIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "rhodium"), "Rh", 45), 1966, 3727);
    public static final Element PALLADIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "palladium"), "Pd", 46), 1552, 3140);
    public static final Element SILVER = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "silver"), "Ag", 47), 961.93, 2212);
    public static final Element CADMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "cadmium"), "Cd", 48), 320.9, 765);
    public static final Element INDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "indium"), "In", 49), 156.17, 2080);
    public static final Element TIN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "tin"), "Sn", 50), 231.97, 2270);
    public static final Element ANTIMONY = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "antimony"), "Sb", 51), 640.74, 1635);
    public static final Element TELLURIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "tellurium"), "Te", 52), 449.5, 989.8);
    public static final Element IODINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "iodine"), "I", 53), 113.5, 184.35);
    public static final Element XENON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "xenon"), "Xe", 54), -111.9, -107.1);
    public static final Element CESIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "cesium"), "Cs", 55), 28.4, 678.4);
    public static final Element BARIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "barium"), "Ba", 56), 729, 1637);
    public static final Element LANTHANUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "lanthanum"), "La", 57), 921, 3457);
    public static final Element CERIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "cerium"), "Ce", 58), 799, 3426);
    public static final Element PRASEODYMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "praseodymium"), "Pr", 59), 931, 3512);
    public static final Element NEODYMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "neodymium"), "Nd", 60), 1021, 3068);
    public static final Element PROMETHIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "promethium"), "Pm", 61), 1168, 2727);
    public static final Element SAMARIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "samarium"), "Sm", 62), 1077, 1791);
    public static final Element EUROPIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "europium"), "Eu", 63), 882, 1597);
    public static final Element GADOLINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "gadolinium"), "Gd", 64), 1313, 3266);
    public static final Element TERBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "terbium"), "Tb", 65), 1356, 3123);
    public static final Element DYSPROSIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "dysprosium"), "Dy", 66), 1412, 2563);
    public static final Element HOLMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "holmium"), "Ho", 67), 1474, 2695);
    public static final Element ERBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "erbium"), "Er", 68), 1529, 2863);
    public static final Element THULIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "thulium"), "Tm", 69), 1545, 1947);
    public static final Element YTTERBIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "ytterbium"), "Yb", 70), 824, 1193);
    public static final Element LUTETIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "lutetium"), "Lu", 71), 1663, 3395);
    public static final Element HAFNIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "hafnium"), "Hf", 72), 2230, 5197);
    public static final Element TANTALUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "tantalum"), "Ta", 73), 2996, 5425);
    public static final Element TUNGSTEN = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "tungsten"), "W", 74), 3407, 5657);
    public static final Element RHENIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "rhenium"), "Re", 75), 3180, 5627);
    public static final Element OSMIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "osmium"), "Os", 76), 3054, 5027);
    public static final Element IRIDIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "iridium"), "Ir", 77), 2410, 4130);
    public static final Element PLATINUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "platinum"), "Pt", 78), 1772, 3827);
    public static final Element GOLD = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "gold"), "Au", 79), 1064.43, 2807);
    public static final Element MERCURY = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "mercury"), "Hg", 80), -38.87, 356.58);
    public static final Element THALLIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "thallium"), "Tl", 81), 303.5, 1457);
    public static final Element LEAD = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "lead"), "Pb", 82), 327.5, 1740);
    public static final Element BISMUTH = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "bismuth"), "Bi", 83), 271.3, 1610);
    public static final Element POLONIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "polonium"), "Po", 84), 254, 962);
    public static final Element ASTATINE = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "astatine"), "At", 85), 302, 337);
    public static final Element RADON = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "radon"), "Rn", 86), -71, -61.8);
    public static final Element FRANCIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "francium"), "Fr", 87), 27, 677);
    public static final Element RADIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "radium"), "Ra", 88), 700, 1140);
    public static final Element ACTINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "actinium"), "Ac", 89), 1047, 3197);
    public static final Element THORIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "thorium"), "Th", 90), 1750, 4787);
    public static final Element PROTACTINIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "protactinium"), "Pa", 91), 1840, 4027);
    public static final Element URANIUM = ElementRegister.registerElement(new Element.Data(new ResourceLocation(BetterMineBetterCraft.MOD_ID, "uranium"), "U", 92), 1132.3, 3745);


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
