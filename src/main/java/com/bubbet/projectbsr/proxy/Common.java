package com.bubbet.projectbsr.proxy;

import com.bubbet.projectbsr.PBSRConstants;
import logisticspipes.interfaces.ILogisticsItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class Common {

    public void registerItemRenderer(Item item, int meta, String id) {

    }

    public void registerModels() {
        ForgeRegistries.ITEMS.getValuesCollection().stream()
                .filter(item -> item.getRegistryName().getResourceDomain().equals(PBSRConstants.MOD_ID))
                .filter(item -> item instanceof ILogisticsItem)
                .forEach(item -> registerModels((ILogisticsItem)item));
    }

    private void registerModels(ILogisticsItem item) {
        int mc = item.getModelCount();
        for (int i = 0; i < mc; i++) {
            String modelPath = item.getModelPath();
            if (mc > 1) {
                String resourcePath = item.getItem().getRegistryName().getResourcePath();
                if (modelPath.matches(String.format(".*%s/%s", resourcePath, resourcePath))) {
                    modelPath = String.format("%s/%d", modelPath.substring(0, modelPath.length() - resourcePath.length() - 1), i);
                } else {
                    modelPath = String.format("%s.%d", modelPath, i);
                }
            }
            ModelLoader.setCustomModelResourceLocation(item.getItem(), i, new ModelResourceLocation(new ResourceLocation(item.getItem().getRegistryName().getResourceDomain(), modelPath), "inventory"));
        }
    }
}
