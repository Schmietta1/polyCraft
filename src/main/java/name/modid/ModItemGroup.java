package name.modid;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroup.DisplayContext;
import net.minecraft.item.ItemGroup.Entries;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    // Define the registry key for the custom item group
    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(RegistryKeys.ITEM_GROUP,
            Identifier.of("polycraft", "custom_group"));

    // Define the custom item group
    public static final ItemGroup CUSTOM_ITEM_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            CUSTOM_ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                    .displayName(Text.translatable("polycraft"))
                    .icon(() -> new ItemStack(ModItems.CUSTOM_ITEM))
                    .entries(ModItemGroup::addItemsToGroup)
                    .build());

    // Method to add items to the custom group
    public static void addItemsToGroup(DisplayContext context, Entries entries) {
        for (Item item : ModItems.ITEMS) {
            entries.add(item);
        }
    }

    public static void initialize() {
        System.out.println("Custom item group initialized");
    }
}
