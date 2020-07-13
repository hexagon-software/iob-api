package de.hexagonsoftware.iob.framework.dragons.entity.bases;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class BaseDragon extends BaseEntity {
	private boolean tameable;
	
	public BaseDragon(EntityType<? extends MonsterEntity> p_i48553_1_, World p_i48553_2_) {
		super(p_i48553_1_, p_i48553_2_);
	}
	
	public boolean isTameable() { return tameable; }
	
	public void tame() {}
}
