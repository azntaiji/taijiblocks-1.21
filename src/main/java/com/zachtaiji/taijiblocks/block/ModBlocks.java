package com.zachtaiji.taijiblocks.block;

// Import libraries and classes
import com.zachtaiji.taijiblocks.TaijiBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // TODO: =====ADD BLOCKS HERE=====
    // --- Pink Garnet Block
    public static final Block PINK_GARNET_BLOCK = registerBlock("pink_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more, or hit shift twice then type in blocks to look at the blocks class.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            )
    );

    // Create a method to "call" this class in TaijiBlocks so that everything gets intialized...
    public static void registerModBlocks () {
        TaijiBlocks.LOGGER.info("Registering mod blocks for " + TaijiBlocks.MOD_ID);

        // Add blocks to building blocks creative mode tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            // TODO: =====ADD BLOCKS HERE=====
            entries.add(ModBlocks.PINK_GARNET_BLOCK);
        });
    }

    // Create a helper method to register block items
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TaijiBlocks.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // Create a helper method to register blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TaijiBlocks.MOD_ID, name), block);
    }
}