package com.zachtaiji.taijiblocks.item;

// Reminders/Learnings:
// - classes like this file, are organized in folders, called "packages".
// - In Java, everything is organized using a file/folder system. When you need to reference or call packages or classes, you simply state the path but use periods (.) insted of slashes (/). The root folder is `java`, so you list the full path after that. For example calling the ModItems class would be com.zachtaiji.taijiblocks.item.ModItems
// - All class names must use CamelCase format. Packages use lowercase format. No underscores.
// - Item names must be registered in lowercase with underscores, just like modid/MOD_ID

// This is where you import classes and libraries
import com.zachtaiji.taijiblocks.TaijiBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

// Define the class:
public class ModItems {

    // TODO: =====ADD ITEMS HERE=====
    public static final Item PINK_GARNET = registerItem("pink_garnet", new Item(new Item.Settings()));
    public static final Item RAW_PINK_GARNET = registerItem("raw_pink_garnet", new Item(new Item.Settings()));

    // Create a method to "call" this class in TaijiBlocks so that everything gets intialized...
    public static void registerModItems () {
        TaijiBlocks.LOGGER.info("Registering Mod Items for " + TaijiBlocks.MOD_ID);

        // Add items to ingredients creative mode tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            // TODO: =====ADD ITEMS HERE=====
            entries.add(PINK_GARNET);
            entries.add(RAW_PINK_GARNET);
        });
    }

    // Create a helper method to register items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TaijiBlocks.MOD_ID, name), item);
    }
}
