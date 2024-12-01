package name.modid.data.provider;

import name.modid.ModBlocks;
import name.modid.ModItems;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;


public class PolyCraftModelProvider extends FabricModelProvider {
    public PolyCraftModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generator.register(ModItems.CUSTOM_ITEM, Models.GENERATED);
        generator.register(ModItems.CUSTOM_FOOD_ITEM, Models.GENERATED);
        generator.register(ModItems.EOLIENNE, Models.GENERATED);


    }
}
