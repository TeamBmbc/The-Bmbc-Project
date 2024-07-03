package net.matty.bmbc.block.entity;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, BetterMineBetterCraft.MOD_ID);

    public static final RegistryObject<BlockEntityType<AlloyFurnaceBlockEntity>> ALLOY_FURNACE =
            BLOCK_ENTITIES.register("alloy_furnace", () ->
                    BlockEntityType.Builder.of(AlloyFurnaceBlockEntity::new,
                            ModBlocks.ALLOY_FURNACE.get()).build(null));

    public static final RegistryObject<BlockEntityType<BiomassGeneratorBlockEntity>> BIOMASS_GENERATOR =
            BLOCK_ENTITIES.register("biomass_generator", () ->
                    BlockEntityType.Builder.of(BiomassGeneratorBlockEntity::new,
                            ModBlocks.BIOMASS_GENERATOR.get()).build(null));

    public static final RegistryObject<BlockEntityType<ExtruderBlockEntity>> EXTRUDER =
            BLOCK_ENTITIES.register("extruder", () ->
                    BlockEntityType.Builder.of(ExtruderBlockEntity::new,
                            ModBlocks.EXTRUDER.get()).build(null));

    public static final RegistryObject<BlockEntityType<HydroelectricBlockEntity>> HYDROELECTRIC_PLANT =
            BLOCK_ENTITIES.register("hydroelectric_plant", () ->
                    BlockEntityType.Builder.of(HydroelectricBlockEntity::new,
                            ModBlocks.HYDROELECTRIC_PLANT.get()).build(null));

    //public static final RegistryObject<BlockEntityType<ErlenmeyerFlaskBlockEntity>> ERLENMEYER_FLASK =
    //        BLOCK_ENTITIES.register("erlenmeyer_flask", () ->
    //                BlockEntityType.Builder.of(ErlenmeyerFlaskBlockEntity::new,
    //                        ModBlocks.ERLENMEYER_FLASK.get()).build(null));

    public static final RegistryObject<BlockEntityType<MaceratorBlockEntity>> MACERATOR =
            BLOCK_ENTITIES.register("macerator", () ->
                    BlockEntityType.Builder.of(MaceratorBlockEntity::new,
                            ModBlocks.MACERATOR.get()).build(null));

    //public static final RegistryObject<BlockEntityType<NuclearBombBlockEntity>> NUCLEAR_BOMB =
    //        BLOCK_ENTITIES.register("nuclear_bomb", () ->
    //                BlockEntityType.Builder.of(NuclearBombBlockEntity::new,
    //                        ModBlocks.NUCLEAR_BOMB.get()).build(null));

    public static final RegistryObject<BlockEntityType<PressureVesselBlockEntity>> PRESSURE_VESSEL =
            BLOCK_ENTITIES.register("pressure_vessel", () ->
                    BlockEntityType.Builder.of(PressureVesselBlockEntity::new,
                            ModBlocks.PRESSURE_VESSEL.get()).build(null));

    public static final RegistryObject<BlockEntityType<ThreeDPrinterBlockEntity>> THREE_D_PRINTER =
            BLOCK_ENTITIES.register("three_d_printer", () ->
                    BlockEntityType.Builder.of(ThreeDPrinterBlockEntity::new,
                            ModBlocks.THREE_D_PRINTER.get()).build(null));

    //public static final RegistryObject<BlockEntityType<RechargerBlockEntity>> RECHARGER = TODO: Change to battery once its fixed
    //        BLOCK_ENTITIES.register("recharger", () ->
    //                BlockEntityType.Builder.of(RechargerBlockEntity::new,
    //                        ModBlocks.RECHARGER.get()).build(null));



    //public static final RegistryObject<BlockEntityType<ItemTransportPipeBlockEntity>> ITEM_TRANSPORT_PIPE =
    //        BLOCK_ENTITIES.register("item_transport_pipe",
    //        () -> BlockEntityType.Builder.of(ItemTransportPipeBlockEntity::new,
    //                ModBlocks.ITEM_TRANSPORT_PIPE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }

}
