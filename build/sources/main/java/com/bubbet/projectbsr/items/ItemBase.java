package com.bubbet.projectbsr.items;

import com.bubbet.projectbsr.ProjectBSR;
import com.bubbet.projectbsr.init.ModItems;
import com.bubbet.projectbsr.util.interfaces.LHasModel;
import net.minecraft.item.Item;

public class ItemBase extends Item implements LHasModel {

    public ItemBase(String name){

        setUnlocalizedName(name);
        setRegistryName(name);

        ModItems.ITEMS.add(this);

    }

    @Override
    public void registerModels(){
        ProjectBSR.proxy.registerItemRenderer( this, 0, "inventory");
    }

}
