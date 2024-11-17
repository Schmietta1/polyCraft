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
import net.minecraft.util.Identifier;

public class ModItems {
    // This is a class that contains all of our items
    private ModItems() {
    }

    // list to keep track of our items
    public static final List<Item> ITEMS = new ArrayList<>();

    // create items
    public static final Item CUSTOM_ITEM = register("suspicious_substance", Item::new, new Item.Settings());
    public static final Item EOLIENNE = register("eolienne", Item::new, new Item.Settings());
    public static final FoodComponent CUSTOM_FOOD = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f).build();
    public static final Item CUSTOM_FOOD_ITEM = register("custom_food", Item::new, new Item.Settings().food(CUSTOM_FOOD));

    public static Item register(String path, Function<Item.Settings, Item> factory, Item.Settings settings) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of("polycraft", path));

        Item item = Items.register(registryKey, factory, settings);
        ITEMS.add(item);
        
        return item;
    }

    public static void initialize() {
        // This is where you would normally initialize your items
        // but we will do that in the register method
        ItemGroupEvents.modifyEntriesEvent(ModItemGroup.CUSTOM_ITEM_GROUP_KEY).register(entries -> {
            for (Item item : ITEMS) {
                entries.add(item);
            }
        });
    }
}