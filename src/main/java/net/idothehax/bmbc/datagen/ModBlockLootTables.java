package net.matty.bmbc.datagen;

import net.matty.bmbc.block.ModBlocks;
import net.matty.bmbc.item.ModFoodItems;
import net.matty.bmbc.item.ModItems;
import net.matty.bmbc.item.ModMineralItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.SILVER_BLOCK.get());

        dropSelf(ModBlocks.ALLOY_FURNACE.get());
        dropSelf(ModBlocks.C4.get());
        dropSelf(ModBlocks.BIOMASS_GENERATOR.get());
        dropSelf(ModBlocks.EXTRUDER.get());
        dropSelf(ModBlocks.HYDROELECTRIC_PLANT.get());
        dropSelf(ModBlocks.PRESSURE_VESSEL.get());
        dropSelf(ModBlocks.RECHARGER.get());
        dropSelf(ModBlocks.THREE_D_PRINTER.get());
        dropSelf(ModBlocks.MACERATOR.get());
        dropSelf(ModBlocks.MECHANICAL_ROLLER.get());
        dropSelf(ModBlocks.VENDOR_OFFICE.get());

        dropSelf(ModBlocks.SILVER_LAMP.get());
        add(ModBlocks.GARBAGE_BLOCK.get(),
                (block -> createOreDrop(ModBlocks.GARBAGE_BLOCK.get(), ModItems.GARBAGE.get())));

        LootItemCondition.Builder coffeeLootItemCondition = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.COFFEE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(CropBlock.AGE, 7));

        add(ModBlocks.COFFEE_CROP.get(),
                (block -> createCropDrops(ModBlocks.COFFEE_CROP.get(), ModFoodItems.COFFEE_CHERRY.get(), ModFoodItems.COFFEE_BEANS.get(), coffeeLootItemCondition)));

        add(ModBlocks.BAUXITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.BAUXITE_ORE.get(), ModMineralItems.BAUXITE.get())));

        add(ModBlocks.CARNALLITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.CARNALLITE_ORE.get(), ModMineralItems.CARNALLITE.get())));

        add(ModBlocks.DOLOMITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.DOLOMITE_ORE.get(), ModMineralItems.DOLOMITE.get())));

        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                (block -> createOreDrop(ModBlocks.DEEPSLATE_SILVER_ORE.get(), ModMineralItems.RAW_SILVER.get())));

        add(ModBlocks.EVAPORITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.EVAPORITE_ORE.get(), ModMineralItems.EVAPORITE.get())));

        add(ModBlocks.MAGNESITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.MAGNESITE_ORE.get(), ModMineralItems.MAGNESITE.get())));

        add(ModBlocks.PEGMATITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.PEGMATITE_ORE.get(), ModMineralItems.PEGMATITE.get())));

        add(ModBlocks.PHOSPHORITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.PHOSPHORITE_ORE.get(), ModMineralItems.PHOSPHORITE.get())));

        add(ModBlocks.URANITE_ORE.get(),
                (block -> createOreDrop(ModBlocks.URANITE_ORE.get(), ModMineralItems.MAGNESITE.get())));

        add(ModBlocks.SILVER_ORE.get(),
                (block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModMineralItems.RAW_SILVER.get())));
        
        // Trees
        dropSelf(ModBlocks.MAPLE_LOG.get());
        dropSelf(ModBlocks.MAPLE_WOOD.get());
        dropSelf(ModBlocks.MAPLE_PLANKS.get());
        dropSelf(ModBlocks.STRIPPED_MAPLE_WOOD.get());
        dropSelf(ModBlocks.STRIPPED_MAPLE_LOG.get());
        dropSelf(ModBlocks.MAPLE_SAPLING.get());


        // Misc
        dropSelf(ModBlocks.SILICA_SAND.get());

        // Radioactive
        dropSelf(ModBlocks.URANIUM_BLOCK.get());

        this.add(ModBlocks.MAPLE_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.MAPLE_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
