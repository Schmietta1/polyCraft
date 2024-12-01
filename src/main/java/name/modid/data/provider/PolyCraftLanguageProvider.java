package name.modid.data.provider;

import name.modid.ModBlocks;
import name.modid.ModItems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

public class PolyCraftLanguageProvider extends FabricLanguageProvider {


    public PolyCraftLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(ModItems.CUSTOM_ITEM, "Suspicious Substance");
        translationBuilder.add(ModItems.CUSTOM_FOOD_ITEM, "Custom Food");
        translationBuilder.add(ModItems.EOLIENNE, "Eolienne");
        translationBuilder.add(ModBlocks.CONDENSED_DIRT, "Condensed Dirt");
    }
}