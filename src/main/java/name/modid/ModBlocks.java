package name.modid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;



public class ModBlocks {
    // This is a class that contains all of our items
    private ModBlocks() {
    }

    // list to keep track of our items
    public static final List<Block> BLOCKS = new ArrayList<>();

    // create items
    public static final Block CONDENSED_DIRT = register(
        "condensed_dirt",
        settings -> new Block(settings.sounds(BlockSoundGroup.GRASS)),
        AbstractBlock.Settings.create()
);

    public static Block register(String path, Function<Block.Settings, Block> factory, Block.Settings settings) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("polycraft", path));

        Block block = Blocks.register(registryKey, factory, settings);
        BLOCKS.add(block);
        
        return block;
    }

    public static void initialize() {
        // This is where you would normally initialize your items
        // but we will do that in the register method
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            for (Block block : BLOCKS) {
                entries.add(ModBlocks.CONDENSED_DIRT.asItem());
            }
        });
    }
}