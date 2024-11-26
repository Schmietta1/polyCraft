package name.modid;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

public class PolyCraftDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(MyTagGenerator::new);
        pack.addProvider(PolyCraftLanguageGenerator::new);
    }

    private static class PolyCraftLanguageGenerator extends FabricLanguageProvider {
        private PolyCraftLanguageGenerator(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataGenerator, "en_us", registryLookup);
        }

        @Override
        public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
            translationBuilder.add(ModItems.CUSTOM_ITEM, "Suspicious Substance");
            translationBuilder.add(ModItems.CUSTOM_FOOD_ITEM, "Custom Food");
            translationBuilder.add(ModItems.EOLIENNE, "Eolienne");
            translationBuilder.add(ModBlocks.CONDENSED_DIRT, "Condensed Dirt");

            // Load an existing language file.
            try {
                Path existingFilePath = dataOutput.getModContainer().findPath("assets/polycraft/lang/en_us.existing.json").orElseThrow(() -> new RuntimeException("Language file not found!"));
                if (Files.exists(existingFilePath)) {
                    translationBuilder.add(existingFilePath);
                } else {
                    throw new RuntimeException("Language file does not exist at path: " + existingFilePath);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to add existing language file!", e);
            }
        }
    }

    private static class MyTagGenerator extends FabricTagProvider.ItemTagProvider {
        public MyTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
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
}
