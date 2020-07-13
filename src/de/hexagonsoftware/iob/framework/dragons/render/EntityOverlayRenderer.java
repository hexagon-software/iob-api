package de.hexagonsoftware.iob.framework.dragons.render;

import com.gacm.isleofberk.entities.dragons.SpeedStingerTitanWingEntity;
import com.gacm.isleofberk.framework.dragons.entity.bases.BaseEntity;
import com.mojang.blaze3d.platform.GLX;
import com.mojang.blaze3d.platform.GlStateManager;

import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;

/**
 * Used in order to render Textures as overlays on dragons.
 * 
 * @version 1.0
 * @author Felix Eckert
 * */
public class EntityOverlayRenderer<E extends BaseEntity, M extends EntityModel<E>> extends LayerRenderer<E, M> {
	private ResourceLocation overlayTexture;
	private boolean hasLightning;
	private boolean shouldCombineTextures;
	
	/**
	 * Used to draw an Overlay texture on the entity.
	 * 
	 * @param entityRenderer instance of IEntityRenderer used by the Entity.
	 * @param overlayTexture Resource Location of the Overlay Texture
	 * @param hasLightning Sets if GlStateManager should enable or disable Lighting.
	 * 
	 * @author Felix Eckert
	 * */
	public EntityOverlayRenderer(IEntityRenderer<E, M> entityRenderer, ResourceLocation overlayTexture, boolean hasLighting) {
		super(entityRenderer);
		this.overlayTexture = overlayTexture;
		this.hasLightning = hasLightning;
		this.shouldCombineTextures = false;
	}

	@Override
	public void render(E arg0, float p_212842_2_, float p_212842_3_, float p_212842_4_, float p_212842_5_, float p_212842_6_, float p_212842_7_, float p_212842_8_) {
		this.bindTexture(this.getTexture(arg0));

		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, 240.0F, 240.0F);

		if (!this.getHasLightning())
			GlStateManager.disableLighting();

		this.getEntityModel().render(arg0, p_212842_2_, p_212842_3_, p_212842_5_, p_212842_6_, p_212842_7_, p_212842_8_);

		if (!this.getHasLightning())
			GlStateManager.enableLighting();

		int i = arg0.getBrightnessForRender();
		GLX.glMultiTexCoord2f(GLX.GL_TEXTURE1, i % 65536, i / 65536);
		this.func_215334_a(arg0);
	}

	@Override
	public boolean shouldCombineTextures() { return this.shouldCombineTextures; }
	public void setShouldCombineTextures(boolean b) { this.shouldCombineTextures = b; }
	
	public ResourceLocation getTexture(E entity) { return this.overlayTexture; }
	public boolean getHasLightning() { return this.hasLightning; }

}
