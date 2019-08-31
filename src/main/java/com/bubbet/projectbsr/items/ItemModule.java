package com.bubbet.projectbsr.items;

import com.bubbet.projectbsr.PBSRConstants;
import com.bubbet.projectbsr.modules.ModuleApiaristSink;
import logisticspipes.items.LogisticsItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import static logisticspipes.items.ItemModule.registerModule;

public class ItemModule extends LogisticsItem {

    public static void loadModules(IForgeRegistry<Item> registry) {
        registerModule(registry, "apiarist_sink", ModuleApiaristSink::new, PBSRConstants.MOD_ID);
    }

}
