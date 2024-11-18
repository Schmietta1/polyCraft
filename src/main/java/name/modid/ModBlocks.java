package name.modid;

import java.util.ArrayList;
import java.util.List;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.block.AbstractBlock.Settings;
import static net.minecraft.block.AbstractBlock.Settings.*;

public class ModBlocks {
    // This is a class that contains all of our items
    private ModBlocks() {
    }

    // list to keep track of our blocks
    public static final List<Block> BLOCKS = new ArrayList<>();

    // create blocks
    public static final Block CUSTOM_BLOCK = register(
            "stone",
            new Block(Settings.create().mapColor(MapColor.STONE_GRAY).strength(1.5F, 6.0F))
    );

    public static Block register(String path, Block block) {
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of("polycraft", path));

        Block block2 = Registry.register(Registries.BLOCK, registryKey.getValue(), block);
        BLOCKS.add(block2);

        return block2;
    }

    public static void initialize() {
        // This is where you would normally initialize your items
        // but we will do that in the register method
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            for (Block block : BLOCKS) {
                entries.add(block.asItem());
            }
        });
    }
}