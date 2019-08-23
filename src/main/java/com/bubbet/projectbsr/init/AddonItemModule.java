package com.bubbet.projectbsr.init;

import com.bubbet.projectbsr.PBSRConstants;
import com.bubbet.projectbsr.modules.ModuleApiaristSink;
import logisticspipes.items.LogisticsItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import static logisticspipes.items.ItemModule.registerModule;

public class AddonItemModule extends LogisticsItem {
    //public static final List<Item> ITEMS = new ArrayList<>();

    public static void loadModules(IForgeRegistry<Item> registry) {
        registerModule(registry, "apiarist_sink", ModuleApiaristSink::new, PBSRConstants.MOD_ID);
    }

}
