package net.matty.bmbc.block;

import net.matty.bmbc.BetterMineBetterCraft;
import net.matty.bmbc.block.custom.*;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.custom.SilverLampBlock;
import net.matty.bmbc.sound.ModSounds;
import net.matty.bmbc.worldgen.tree.MapleTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;


public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, BetterMineBetterCraft.MOD_ID);

    // Bombs
    public static final RegistryObject<Block> C4 = registerBlock("c4",
            () -> new C4Block(BlockBehaviour.Properties.of(Material.EXPLOSIVE)
                    .strength(2.5f).instabreak().sound(SoundType.GRASS)));

    public static final RegistryObject<Block> NUCLEAR_BOMB = registerBlock("nuclear_bomb",
            () -> new NuclearBombBlock(BlockBehaviour.Properties.of(Material.EXPLOSIVE)
                    .strength(2.5f).instabreak().sound(SoundType.ANCIENT_DEBRIS)));

    public static final RegistryObject<Block> EXTRUDER = registerBlock("extruder",
            () -> new ExtruderBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()));

    //public static final RegistryObject<Block> TEST_MULTI_BLOCK = registerBlock("test_multi_block",
    //        TestMultiBlock::new
    //);

    //public static final RegistryObject<Block> FLASK = registerBlock("flask",
    //        () -> new FlaskBlock(BlockBehaviour.Properties.of(Material.GLASS)
    //                .strength(2f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> GARBAGE_BLOCK = registerBlock("garbage_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.LEAVES)
                    .strength(0.5f).explosionResistance(3f).sound(ModSounds.GARBAGE_BLOCK_SOUNDS).noOcclusion()));

    public static final RegistryObject<Block> MECHANICAL_ROLLER = registerBlock("mechanical_roller",
            () -> new MechanicalRoller(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5f).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> SILICA_SAND = registerBlock("silica_sand",
            () -> new SilicaSand(14406560, BlockBehaviour.Properties.of(Material.SAND).sound(SoundType.SAND)));

    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5f).requiresCorrectToolForDrops()));

    // Special Blocks
    public static final RegistryObject<Block> SILVER_LAMP = registerBlock("silver_lamp",
            () -> new SilverLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(SilverLampBlock.LIT) ? 15 : 0)));

    public static final RegistryObject<Block> VENDOR_OFFICE = registerBlock("vendor_office",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL) // This will later maybe be a BE
                    .strength(0.5f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> URANIUM_BLOCK = registerBlock("uranium_block",
            () -> new RadioactiveBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(1f).requiresCorrectToolForDrops().noOcclusion(), 5, 2.0f));

    // Crops
    public static final RegistryObject<Block> COFFEE_CROP = BLOCKS.register("coffee_crop",
            () -> new CoffeeCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

    public static final RegistryObject<Block> BIOMASS_GENERATOR = registerBlock("biomass_generator",
            () -> new BiomassGeneratorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().strength(0.5f).noOcclusion()));

    public static final RegistryObject<Block> HYDROELECTRIC_PLANT = registerBlock("hydroelectric_plant",
            () -> new HydroelectricPlantBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().strength(0.5f).noOcclusion()));

    public static final RegistryObject<Block> PRESSURE_VESSEL = registerBlock("pressure_vessel",
            () -> new PressureVesselBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5F).requiresCorrectToolForDrops().noOcclusion()));

    public static final RegistryObject<Block> RECHARGER = registerBlock("recharger",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL) // TODO: Change Block class to Recharger block after its fixed
                    .requiresCorrectToolForDrops().strength(0.5f).noOcclusion()));


    public static final RegistryObject<Block> THREE_D_PRINTER = registerBlock("three_d_printer",
            () -> new ThreeDPrinterBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().strength(0.5f).noOcclusion()));

    public static final RegistryObject<Block> MACERATOR = registerBlock("macerator",
            () -> new MaceratorBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .requiresCorrectToolForDrops().strength(0.5f).noOcclusion()));

    public static final RegistryObject<Block> ALLOY_FURNACE = registerBlock("alloy_furnace",
            () -> new AlloyFurnaceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(0.5F).requiresCorrectToolForDrops().noOcclusion()
                    .lightLevel(b -> b.getValue(AlloyFurnaceBlock.ACTIVE) ? 13:0)));

    // Pipes
    //public static final RegistryObject<Block> ITEM_TRANSPORT_PIPE = registerBlock("item_transport_pipe", TODO: Add Pipes
    //        () -> new ItemTransportPipeBlock(Block.Properties.of(Material.METAL)
    //                .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

    // Ores and its accomplices
    public static final RegistryObject<Block> BAUXITE_ORE = registerBlock("bauxite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.0f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> CARNALLITE_ORE = registerBlock("carnallite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.0F, 2.0F).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> DOLOMITE_ORE = registerBlock("dolomite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.7F, 2.8F).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> EVAPORITE_ORE = registerBlock("evaporite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4.4F, 2.2F).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> MAGNESITE_ORE = registerBlock("magnesite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.6F, 3.25F).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> PEGMATITE_ORE = registerBlock("pegmatite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5.5F, 2.75F).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> PHOSPHORITE_ORE = registerBlock("phosphorite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.6F, 3.25F).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.0f, 2.4f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> URANITE_ORE = registerBlock("uranite_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.0f, 2.4f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));
    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(6.0f).requiresCorrectToolForDrops(), UniformInt.of(1, 3)));


    // Woods
    public static final RegistryObject<Block> MAPLE_LOG = registerBlock(
            "maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAPLE_WOOD = registerBlock(
            "maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STRIPPED_MAPLE_LOG = registerBlock(
            "stripped_maple_log",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> STRIPPED_MAPLE_WOOD = registerBlock(
            "stripped_maple_wood",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                    .strength(2.0f)
                    .requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> MAPLE_PLANKS = registerBlock(
            "maple_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                    .strength(2.0f)){

                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 5;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 20;
                }

            });

    public static final RegistryObject<Block> MAPLE_LEAVES = registerBlock("maple_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)) {
                @Override
                public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 30;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
                    return 60;
                }
            });

    public static final RegistryObject<Block> MAPLE_SAPLING = registerBlock(
            "maple_sapling",
            () -> new SaplingBlock(new MapleTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
