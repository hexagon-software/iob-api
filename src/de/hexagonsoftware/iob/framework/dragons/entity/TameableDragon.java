package de.hexagonsoftware.iob.framework.dragons.entity;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.world.World;

public class TameableDragon extends TameableEntity {

	protected TameableDragon(EntityType<? extends TameableEntity> p_i48574_1_, World p_i48574_2_) {
		super(p_i48574_1_, p_i48574_2_);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AgeableEntity createChild(AgeableEntity arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
