package name.modid;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import java.util.function.Function;
import java.util.List;
import java.util.ArrayList;

public class ModItems {
    private ModItems() {
    }
    public static final List<Item> ITEMS = new ArrayList<>();

    public static final Item CUSTOM_ITEM = register("suspicious_substance", Item::new, new Item.Settings());
    public static final Item EOLIENNE = register("eolienne", Item::new, new Item.Settings());
 
    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("polycraft", path));
        
        Item item = Items.register(registryKey, factory, settings);
        ITEMS.add(item);
        
        return item;
      }

    public static void initialize() {
        // This is where you would normally initialize your items
        // but we will do that in the register method
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            for (Item item : ITEMS) {
                entries.add(item);
            }
        });
    }
}