package com.bubbet.projectbsr.proxy;

import com.bubbet.projectbsr.proxy.forestry.ForestryProxy;
import com.bubbet.projectbsr.proxy.interfaces.IForestryProxy;
import logisticspipes.asm.wrapper.LogisticsWrapperHandler;
import logisticspipes.recipes.CraftingParts;
import logisticspipes.utils.item.ItemIdentifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ProxyManager {

    public static <T> T getWrappedProxy(String modId, Class<T> interfaze, Class<? extends T> proxyClazz, T dummyProxy, Class<?>... wrapperInterfaces) {
        try {
            return LogisticsWrapperHandler.getWrappedProxy(modId, interfaze, proxyClazz, dummyProxy, wrapperInterfaces);
        } catch(Exception e) {
            if(e instanceof RuntimeException) {
                throw (RuntimeException) e;
            }
            throw new RuntimeException(e);
        }
    }

    public static void load() {
        SimpleServiceLocator.setForestryProxy(ProxyManager.getWrappedProxy("forestry", IForestryProxy.class, ForestryProxy.class, new IForestryProxy() {

            @Override
            public boolean isBee(ItemStack item) {
                return false;
            }

            @Override
            public boolean isBee(ItemIdentifier item) {
                return false;
            }

            @Override
            public boolean isAnalysedBee(ItemStack item) {
                return false;
            }

            @Override
            public boolean isAnalysedBee(ItemIdentifier item) {
                return false;
            }

            @Override
            public boolean isKnownAlleleId(String uid, World world) {
                return false;
            }

            @Override
            public String getAlleleName(String uid) {
                return null;
            }

            @Override
            public boolean isTileAnalyser(TileEntity tile) {
                return false;
            }

            @Override
            public String getFirstAlleleId(ItemStack bee) {
                return null;
            }

            @Override
            public String getSecondAlleleId(ItemStack bee) {
                return null;
            }

            @Override
            public String getNextAlleleId(String uid, World world) {
                return null;
            }

            @Override
            public String getPrevAlleleId(String uid, World world) {
                return null;
            }

            @Override
            public boolean isDrone(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isFlyer(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isPrincess(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isQueen(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isPurebred(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isNocturnal(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isPureNocturnal(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isPureFlyer(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isCave(ItemStack bee) {
                return false;
            }

            @Override
            public boolean isPureCave(ItemStack bee) {
                return false;
            }

            @Override
            public String getForestryTranslation(String input) {
                return null;
            }

            @Override
            public int getColorForAlleleId(String uid, int phase) {
                return 0;
            }

            @Override
            public int getRenderPassesForAlleleId(String uid) {
                return 0;
            }

            @Override
            public void addCraftingRecipes(CraftingParts parts) {

            }

            @Override
            public void syncTracker(World world, EntityPlayer player) {

            }
        }));
    }
}
