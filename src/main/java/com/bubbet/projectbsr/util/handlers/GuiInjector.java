package com.bubbet.projectbsr.util.handlers;

import logisticspipes.network.NewGuiHandler;
import logisticspipes.network.abstractguis.GuiProvider;

public class GuiInjector {

    public void GuiInjector(Class<? extends GuiProvider> cls){
        Integer currentId = 0;
        try { // integrate this into my own method for injecting guis to that list for use when game running
            final GuiProvider instance = (GuiProvider) cls.getConstructors()[0].newInstance(currentId);
            NewGuiHandler.guilist.add(instance);
            NewGuiHandler.guimap.put(cls, instance);
            currentId++;
        } catch (Throwable ignoredButPrinted) {
            ignoredButPrinted.printStackTrace();
        }
    }

}
