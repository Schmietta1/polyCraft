package name.modid;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Path;

public class PolyCraftLanguageGenerator extends FabricLanguageProvider {
    PolyCraftLanguageGenerator(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        // Specifying en_us is optional, by default it is en_us.
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
            Path existingFilePath = dataOutput.getModContainer().findPath("assets/polycraft/lang/en_us.existing.json").get();
            translationBuilder.add(existingFilePath);
        } catch (Exception e) {
            throw new RuntimeException("Failed to add existing language file!", e);
        }
    }
}
