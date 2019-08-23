package com.bubbet.projectbsr.proxy;

import com.bubbet.projectbsr.proxy.interfaces.IForestryProxy;

public final class SimpleServiceLocator {

    private SimpleServiceLocator() {};

    public static IForestryProxy forestryProxy;

    public static void setForestryProxy(final IForestryProxy fProxy) {
        SimpleServiceLocator.forestryProxy = fProxy;
    }

}
