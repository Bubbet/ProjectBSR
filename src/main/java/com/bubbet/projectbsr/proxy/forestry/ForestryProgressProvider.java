package com.bubbet.projectbsr.proxy.forestry;

import forestry.core.tiles.TilePowered;
import logisticspipes.proxy.interfaces.IGenericProgressProvider;
import net.minecraft.tileentity.TileEntity;

import java.lang.reflect.Field;

public class ForestryProgressProvider implements IGenericProgressProvider {

	private Field workCounter;

	public ForestryProgressProvider() throws NoSuchFieldException, SecurityException {
		workCounter = TilePowered.class.getDeclaredField("workCounter");
		workCounter.setAccessible(true);
	}

	@Override
	public boolean isType(TileEntity tile) {
		return tile instanceof TilePowered;
	}

	@Override
	public byte getProgress(TileEntity tile) {
		try {
			return (byte) Math.max(0, Math.min(((Integer) workCounter.get(tile)).intValue() * 4, 100));
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
}
