package com.zachtaiji.taijiblocks.item;

// This is where you import classes and libraries
import com.zachtaiji.taijiblocks.TaijiBlocks;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

// Define the class:
public class ModItems {

    // Create Custom Item Group
    public static final RegistryKey<ItemGroup> TAIJIBLOCKS_GROUP = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(TaijiBlocks.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.BABY_BOTTLE))
            .displayName(Text.translatable("itemGroup.taiji_blocks_group"))
            .build();

    // TODO: =====ADD ITEMS HERE=====
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));
    public static final Item BABY_BOTTLE = registerItem("baby_bottle", new Item(new Item.Settings().food(new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f).build())));

    // Create a method to "call" this class in TaijiBlocks so that everything gets intialized...
    public static void registerModItems () {
        
        // Register the custom group.
        Registry.register(Registries.ITEM_GROUP, TAIJIBLOCKS_GROUP, CUSTOM_ITEM_GROUP);

        TaijiBlocks.LOGGER.info("Registering Mod Items for " + TaijiBlocks.MOD_ID);

        // Add items to ingredients creative mode tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            // TODO: =====ADD ITEMS HERE=====
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });

        // Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(TAIJIBLOCKS_GROUP).register(itemGroup -> {
            // TODO: =====ADD ITEMS HERE=====
            itemGroup.add(ModItems.BABY_BOTTLE);
        });

    }

    // Create a helper method to register items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TaijiBlocks.MOD_ID, name), item);
    }
}
