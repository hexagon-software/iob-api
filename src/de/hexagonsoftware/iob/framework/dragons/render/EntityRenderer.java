package de.hexagonsoftware.iob.framework.dragons.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

// These are the brutal Machinations of the Angry German!
// DONT TOUCH MY RENDERER

/**
 * This class should be used for Entities that were created using the
 * Dragons Framework, for compabilitie's sake.
 * Can be used like a normal MobRenderer.
 * 
 * @author Felix Eckert
 * */
public class EntityRenderer extends MobRenderer {
	private ResourceLocation entityTexture;
	
	/**
	 * @param entityTexture Texture of the entity.
	 * 
	 * @author Felix Eckert
	 * */
	public EntityRenderer(ResourceLocation entityTexture, EntityRendererManager p_i50961_1_, EntityModel p_i50961_2_, float p_i50961_3_) {
		super(p_i50961_1_, p_i50961_2_, p_i50961_3_);
		this.entityTexture = entityTexture;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity arg0) {
		return this.entityTexture;
	}

}
