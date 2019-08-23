package com.bubbet.projectbsr.network.guis.module.inhand;

import com.bubbet.projectbsr.gui.modules.GuiApiaristSink;
import com.bubbet.projectbsr.modules.ModuleApiaristSink;
import com.bubbet.projectbsr.proxy.SimpleServiceLocator;
import logisticspipes.modules.abstractmodules.LogisticsModule;
import logisticspipes.network.abstractguis.GuiProvider;
import logisticspipes.network.abstractguis.ModuleInHandGuiProvider;
import logisticspipes.utils.gui.DummyContainer;
import logisticspipes.utils.gui.DummyModuleContainer;
import net.minecraft.entity.player.EntityPlayer;

public class ApiaristSinkInHand extends ModuleInHandGuiProvider {

    public ApiaristSinkInHand(int id) {
        super(id);
    }

    @Override
    public Object getClientGui(EntityPlayer player) {
        LogisticsModule module = getLogisticsModule(player);
        if (!(module instanceof ModuleApiaristSink)) {
            return null;
        }

        return new GuiApiaristSink(player.inventory, (ModuleApiaristSink) module, false);
    }

    @Override
    public DummyContainer getContainer(EntityPlayer player) {
        SimpleServiceLocator.forestryProxy.syncTracker(player.getEntityWorld(), player);
        DummyModuleContainer dummy = new DummyModuleContainer(player, getInvSlot());
        if (!(dummy.getModule() instanceof ModuleApiaristSink)) {
            return null;
        }
        return dummy;
    }

    @Override
    public GuiProvider template() {
        return new ApiaristSinkInHand(getId());
    }
}

