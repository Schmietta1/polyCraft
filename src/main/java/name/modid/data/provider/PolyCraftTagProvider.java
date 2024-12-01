package name.modid.data.provider;

import name.modid.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public  class PolyCraftTagProvider extends FabricTagProvider.ItemTagProvider {
    public PolyCraftTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    private static final TagKey<Item> LA_CHIMIE = TagKey.of(RegistryKeys.ITEM, Identifier.of("polycraft", "la_chimie"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(LA_CHIMIE)
                .add(ModItems.EOLIENNE)
                .add(ModItems.CUSTOM_ITEM)
                .addOptionalTag(ItemTags.DIRT);
    }
}