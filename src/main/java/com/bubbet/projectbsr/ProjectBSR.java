package com.bubbet.projectbsr;

import com.bubbet.projectbsr.proxy.Common;
import com.bubbet.projectbsr.proxy.ProxyManager;
import logisticspipes.network.NewGuiHandler;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = PBSRConstants.MOD_ID,
        name = "ProjectBSR",
        version = "1.0",
        dependencies = "required-after:logisticspipes;" +
                "after:forestry;"
)
public class ProjectBSR {

    @Mod.Instance("ProjectBSR")
    public static ProjectBSR instance;

    @SidedProxy(clientSide = "com.bubbet.projectbsr.proxy.Client",serverSide = "com.bubbet.projectbsr.proxy.Server")
    public static Common proxy;

    public static <T extends Item> T setName(T item, String name) {
        item.setRegistryName(PBSRConstants.MOD_ID, name);
        item.setUnlocalizedName(String.format("%s.%s", PBSRConstants.MOD_ID, name));
        return item;
    }


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {

        ProxyManager.load();
        NewGuiHandler.initialize();


    }

}
