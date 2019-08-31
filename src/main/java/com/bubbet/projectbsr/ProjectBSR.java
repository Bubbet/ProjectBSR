package com.bubbet.projectbsr;

import com.bubbet.projectbsr.items.ItemModule;
import com.bubbet.projectbsr.proxy.Common;
import com.bubbet.projectbsr.proxy.ProxyManager;
import logisticspipes.network.NewGuiHandler;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(
        modid = PBSRConstants.MOD_ID,
        name = "ProjectBSR",
        version = "1.0",
        dependencies = "required-after:logisticspipes;" +
                "after:forestry;"
)

public class ProjectBSR {

    public ProjectBSR() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.Instance("ProjectBSR")
    public static ProjectBSR instance;

    @SidedProxy(clientSide = "com.bubbet.projectbsr.proxy.side.Client",serverSide = "com.bubbet.projectbsr.proxy.side.Server")
    public static Common proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {

        ProxyManager.load();
        NewGuiHandler.initialize();

    }

    @SubscribeEvent
    public void initItems(RegistryEvent.Register<Item> event) {
        IForgeRegistry<Item> registry = event.getRegistry();

        ItemModule.loadModules(registry);
    }

}
