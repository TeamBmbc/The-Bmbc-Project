package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.fluid.ModFluids;
import net.matty.bmbc.item.custom.C4Detonator;
import net.matty.bmbc.item.custom.EightBallItem;
import net.matty.bmbc.item.custom.MetalDetectorItem;
import net.matty.bmbc.item.custom.NuclearBombDetonator;
import net.matty.bmbc.item.custom.tooltips.BucketItemWithToolTip;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    // Special or Custom Items
    //public static final RegistryObject<Item> BATTERY = ITEMS.register("battery",
    //        () -> new BatteryItem(new Item.Properties().stacksTo(1)))//, 6000, 64, 32, 6000)); // TODO:

    // C4_DETONATOR
    public static final RegistryObject<Item> C4_DETONATOR = ITEMS.register("c4_detonator", () -> new C4Detonator(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NUCLEAR_BOMB_DETONATOR = ITEMS.register("nuclear_bomb_detonator", () -> new NuclearBombDetonator(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball", () -> new EightBallItem(new Item.Properties()));
    public static final RegistryObject<Item> CABLE_ROLL = ITEMS.register("cable_roll", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RED_PRINTER_FILAMENT = ITEMS.register("red_printer_filament", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLUE_PRINTER_FILAMENT = ITEMS.register("blue_printer_filament", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> GREEN_PRINTER_FILAMENT = ITEMS.register("green_printer_filament", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BLUE_PLASTIC_SCREW = ITEMS.register("blue_plastic_screw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_PLASTIC_SCREW = ITEMS.register("green_plastic_screw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RED_PLASTIC_SCREW = ITEMS.register("red_plastic_screw", () -> new Item(new Item.Properties()));

    //public static final RegistryObject<Item> DUMMY_TEMPLATE = ITEMS.register("dummy_template",
    //        () -> new Item(new Item.Properties().stacksTo(1)));

    // Templates
    public static final RegistryObject<Item> ROD_TEMPLATE = ITEMS.register("rod_template", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SCREW_TEMPLATE = ITEMS.register("screw_template", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> WIRE_TEMPLATE = ITEMS.register("wire_template", () -> new Item(new Item.Properties().stacksTo(1)));


    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", () -> new MetalDetectorItem(new Item.Properties().stacksTo(1)));


    // Buckets
    public static final RegistryObject<Item> ACETONE_BUCKET = ITEMS.register("acetone_bucket",
            () -> new BucketItem(ModFluids.SOURCE_ACETONE,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> BISPHENOL_BUCKET = ITEMS.register("bisphenol_bucket",
            () -> new BucketItem(ModFluids.SOURCE_BISPHENOL,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> CHLORINE_BUCKET = ITEMS.register("chlorine_bucket",
            () -> new BucketItem(ModFluids.SOURCE_CHLORINE,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> HYDROCHLORIC_ACID_BUCKET = ITEMS.register("hydrochloric_acid_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HYDROCHLORIC_ACID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> LIQUID_HELIUM_BUCKET = ITEMS.register("helium_bucket",
            () -> new BucketItem(ModFluids.SOURCE_HELIUM,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> LIQUID_NITROGEN_BUCKET = ITEMS.register("nitrogen_bucket",
            () -> new BucketItemWithToolTip(ModFluids.SOURCE_NITROGEN_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    , "Chem. Formula: ", "LN₂"));

    public static final RegistryObject<Item> LIQUID_OXYGEN_BUCKET = ITEMS.register("oxygen_bucket",
            () -> new BucketItemWithToolTip(ModFluids.SOURCE_OXYGEN_FLUID,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)
                    , "Chem. Formula: ", "O₂"));

    public static final RegistryObject<Item> PHENOL_BUCKET = ITEMS.register("phenol_bucket",
            () -> new BucketItem(ModFluids.SOURCE_PHENOL,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> PROPANE_BUCKET = ITEMS.register("propane_bucket",
            () -> new BucketItem(ModFluids.SOURCE_PROPANE,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> SEWAGE_WATER_BUCKET = ITEMS.register("sewage_water_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SEWAGE_WATER,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    public static final RegistryObject<Item> SODIUM_HYDROXIDE_BUCKET = ITEMS.register("sodium_hydroxide_bucket",
            () -> new BucketItem(ModFluids.SOURCE_SODIUM_HYDROXIDE,
                    new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

    // Plastics
    public static final RegistryObject<Item> PET_PLASTIC = ITEMS.register("pet_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HDPE_PLASTIC = ITEMS.register("hdpe_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PVC_PLASTIC = ITEMS.register("pvc_plastic", () -> new Item(new Item.Properties()){@Override public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {components.add(Component.literal("Chem. Formula: ").withStyle(ChatFormatting.RED).append(Component.literal("(C2H3Cl)n").withStyle(ChatFormatting.BLUE)));super.appendHoverText(stack, level, components, flag);}});

    public static final RegistryObject<Item> LDPE_PLASTIC = ITEMS.register("ldpe_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PP_PLASTIC = ITEMS.register("pp_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PC_PLASTIC = ITEMS.register("pc_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PS_PLASTIC = ITEMS.register("ps_plastic",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EPOXY_RESIN_FLUID = ITEMS.register("epoxy_resin_fluid",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> FIBERGLASS = ITEMS.register("fiberglass",
            () -> new Item(new Item.Properties()));

    // Misc
    public static final RegistryObject<Item> GARBAGE = ITEMS.register("garbage",
            () -> new Item(new Item.Properties()));

    // Radiation
    public static final RegistryObject<Item> NBC_FABRIC = ITEMS.register("nbc_fabric",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PCB_LOW_GRADE_BLANK = ITEMS.register("pcb_low_grade_blank",
            () -> new Item(new Item.Properties().stacksTo(16)));

    public static final RegistryObject<Item> PCB_HIGH_GRADE_BLANK = ITEMS.register("pcb_high_grade_blank",
            () -> new Item(new Item.Properties().stacksTo(16)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
