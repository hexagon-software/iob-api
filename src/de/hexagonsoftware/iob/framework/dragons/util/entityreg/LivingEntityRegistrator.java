package de.hexagonsoftware.iob.framework.dragons.util.entityreg;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

/**
 * Cotains Methods for registering LivingEntities
 * 
 * @author Felix Eckert
 * */
public class LivingEntityRegistrator {
	private static String MODID;
	
	public LivingEntityRegistrator(String MODID) {
		this.MODID = MODID;
	}
	
	/**
	 * @author Ghanou Craft, Felix Eckert
	 * */
  	public static <T extends LivingEntity> EntityType<T> createLivingEntity(EntityType.IFactory<T> factory, EntityClassification entityClassification, String name, float width, float height) {
  		ResourceLocation location = new ResourceLocation(MODID, name);
  		EntityType<T> entity = EntityType.Builder.create(factory, entityClassification)
  			.size(width, height)
  			.setTrackingRange(64)
  			.setShouldReceiveVelocityUpdates(true)
  			.setUpdateInterval(3)
  			.build(location.toString()
  		);
  		return entity;
  	}
}
