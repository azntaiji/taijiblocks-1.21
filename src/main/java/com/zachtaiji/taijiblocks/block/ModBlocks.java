package com.zachtaiji.taijiblocks.block;

// Import libraries and classes
import com.zachtaiji.taijiblocks.TaijiBlocks;
import com.zachtaiji.taijiblocks.item.ModItems;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // TODO: ADD BLOCKS HERE

    // --- Plushie Flamingo Block
    public static final FacingBlock PLUSHIE_FLAMINGO_BLOCK = (FacingBlock) registerBlock("plushie_flamingo_block",
            new FacingBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOL)
                    .nonOpaque()
            )
    ); 

    // --- Plushie Kirby Block  
    public static final FacingBlock PLUSHIE_KIRBY_BLOCK = (FacingBlock) registerBlock("plushie_kirby_block",
            new FacingBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOL)
                    .nonOpaque()
            )
    ); 

    // --- Gray Siding Block
    public static final FacingBlock GRAY_SIDING_BLOCK = (FacingBlock) registerBlock("gray_siding_block",
            new FacingBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
            )
    ); 

    // --- Plushie Jigglypuff Block
    public static final FacingBlock PLUSHIE_JIGGLYPUFF_BLOCK = (FacingBlock) registerBlock("plushie_jigglypuff_block",
            new FacingBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOL)
                    .nonOpaque()
            )
    ); 

    // --- Four Way Street Sign Block
    public static final TallBlock STREET_SIGN_FOUR_WAY_BLOCK = (TallBlock) registerBlock("street_sign_four_way_block",
            new TallBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
            )
    ); 

    // --- North South Street Sign Block
    public static final TallBlock STREET_SIGN_NORTH_SOUTH_BLOCK = (TallBlock) registerBlock("street_sign_north_south_block",
            new TallBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
            )
    ); 

    // --- East West Street Sign Block
    public static final TallBlock STREET_SIGN_EAST_WEST_BLOCK = (TallBlock) registerBlock("street_sign_east_west_block",
            new TallBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
            )
    ); 

    // --- Stop Sign Block
    public static final TallFacingBlock STREET_SIGN_STOP_BLOCK = (TallFacingBlock) registerBlock("street_sign_stop_block",
    new TallFacingBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.METAL)
                    .nonOpaque()
            )
    ); 

    // --- Mirror Block
    public static final ThinFacingBlock MIRROR_BLOCK = (ThinFacingBlock) registerBlock("mirror_block",
    new ThinFacingBlock(Block.Settings.create()
                    // This is where you add block properties via methods! Use autocomplete to learn more.
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.WOOD)
                    .nonOpaque()
            )
    ); 

    public static final RegistryKey<ItemGroup> TAIJIBLOCKS_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(TaijiBlocks.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BABY_BOTTLE))
            .displayName(Text.translatable("itemGroup.taiji_blocks_group"))
            .build();

    // Method to initialize block registration
    public static void registerModBlocks () {

        TaijiBlocks.LOGGER.info("Registering mod blocks for " + TaijiBlocks.MOD_ID);

        // Add blocks to building blocks creative mode tab
        ItemGroupEvents.modifyEntriesEvent(TAIJIBLOCKS_GROUP).register(entries -> {
            // TODO: ADD BLOCKS HERE
            entries.add(ModBlocks.PLUSHIE_FLAMINGO_BLOCK);
            entries.add(ModBlocks.PLUSHIE_KIRBY_BLOCK);
            entries.add(ModBlocks.GRAY_SIDING_BLOCK);
            entries.add(ModBlocks.PLUSHIE_JIGGLYPUFF_BLOCK);
            entries.add(ModBlocks.STREET_SIGN_FOUR_WAY_BLOCK);
            entries.add(ModBlocks.STREET_SIGN_NORTH_SOUTH_BLOCK);
            entries.add(ModBlocks.STREET_SIGN_EAST_WEST_BLOCK);
            entries.add(ModBlocks.STREET_SIGN_STOP_BLOCK);
            entries.add(ModBlocks.MIRROR_BLOCK);
        });

    }

    // Method to register block items
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TaijiBlocks.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // Method to register blocks
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TaijiBlocks.MOD_ID, name), block);
    }
}