package name.modid;

import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Block CONDENSED_DIRT = register(
            "condensed_dirt",
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.STONE_GRAY)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresTool()
                    .strength(1.5F, 6.0F)
    );

    public static Block register(String path, AbstractBlock.Settings settings) {
        Identifier id = Identifier.of("polycraft", path);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);

        settings.registryKey(key);
        Block block = new Block(settings);
        Registry.register(Registries.BLOCK, key, block);
        BLOCKS.add(block);

        // Register the block item
        BlockItem blockItem = new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, id)));
        Registry.register(Registries.ITEM, id, blockItem);

        return block;
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            for(Block block : BLOCKS) {
                entries.add(block);
            }
        });
    }
}