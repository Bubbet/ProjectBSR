package com.bubbet.projectbsr.util.handlers;

import com.bubbet.projectbsr.init.ModBlocks;
import com.bubbet.projectbsr.init.AddonItemModule;
import com.bubbet.projectbsr.util.interfaces.LHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event){

        IForgeRegistry<Item> registry = event.getRegistry();

        AddonItemModule.loadModules(registry);

        //registry.registerAll(AddonItemModule.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event){
        event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event){
/*
        for(Item item : AddonItemModule.ITEMS){
            if(item instanceof LHasModel){
                ((LHasModel)item).registerModels();
            }
        }
*/
        for(Block block : ModBlocks.BLOCKS){
            if(block instanceof LHasModel){
                ((LHasModel)block).registerModels();
            }
        }

    }

}
