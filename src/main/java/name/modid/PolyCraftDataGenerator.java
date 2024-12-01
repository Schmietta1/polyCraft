package name.modid;

import name.modid.data.provider.PolyCraftBlockLootTableProvider;
import name.modid.data.provider.PolyCraftLanguageProvider;
import name.modid.data.provider.PolyCraftModelProvider;
import name.modid.data.provider.PolyCraftTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;


public class PolyCraftDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();
        pack.addProvider(PolyCraftTagProvider::new);
        pack.addProvider(PolyCraftModelProvider::new);
        pack.addProvider(PolyCraftLanguageProvider::new);
        pack.addProvider(PolyCraftBlockLootTableProvider::new);
    }

}
