package name.modid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();

    // Example block registrations
    public static final Block CONDENSED_DIRT = register(
            new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GRASS)),
            "condensed_dirt",
            true
    );


    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Create a valid identifier using Identifier.of
        Identifier id = Identifier.of("polycraft", name);

        // Register the block's item if needed
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        // Register the block and return it
        return Registry.register(Registries.BLOCK, id, block);
    }

    /**
     * Initializes the mod blocks and adds them to the custom item group.
     */
    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.CONDENSED_DIRT.asItem());
        });
    }
}
