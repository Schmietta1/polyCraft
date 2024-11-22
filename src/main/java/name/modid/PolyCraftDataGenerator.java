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
import java.util.concurrent.CompletableFuture;

public class PolyCraftDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator generator) {
        FabricDataGenerator.Pack pack = generator.createPack();

        // Adding a provider example:
        //
        // pack.addProvider(AdvancementsProvider::new);

    }

    private static class MyTagGenerator extends FabricTagProvider.ItemTagProvider {
        public MyTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }

        private static final TagKey<Item> LA_CHIMIE = TagKey.of(RegistryKeys.ITEM, Identifier.of("polycraft:la_chimie"));

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            getOrCreateTagBuilder(LA_CHIMIE)
                    .add(ModItems.EOLIENNE)
                    .add(ModItems.CUSTOM_FOOD_ITEM);
        }
    }

}


