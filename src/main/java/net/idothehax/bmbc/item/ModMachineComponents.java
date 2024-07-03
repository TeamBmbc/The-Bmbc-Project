package net.matty.bmbc.item;

import net.matty.bmbc.BetterMineBetterCraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMachineComponents {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<Item> COPPER_COIL = ITEMS.register("copper_coil",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_FOIL = ITEMS.register("copper_foil",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COPPER_WIRE = ITEMS.register("copper_wire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ELECTRIC_MOTOR = ITEMS.register("electric_motor",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> EPOXY_CIRCUIT_BOARD = ITEMS.register("epoxy_circuit_board",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MAGNETIC_IRON_ROD = ITEMS.register("magnetic_iron_rod",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

/*
{
                @Override
                public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> components, TooltipFlag flag) {
                    if(Screen.hasShiftDown()){
                        components.add(Component.literal("Used to make cables,").withStyle(ChatFormatting.AQUA));
                    } else {
                        components.add(Component.literal("Press SHIFT for more info").withStyle(ChatFormatting.YELLOW));
                    }

                    super.appendHoverText(stack, level, components, flag);
                }
            });
 */