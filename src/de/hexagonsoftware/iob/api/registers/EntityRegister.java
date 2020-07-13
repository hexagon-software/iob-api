package de.hexagonsoftware.iob.api.registers;

import java.util.HashMap;
import java.util.List;

import de.hexagonsoftware.iob.api.API;
import de.hexagonsoftware.iob.framework.dragons.entity.bases.BaseEntity;
import de.hexagonsoftware.iob.framework.dragons.util.entityreg.CustomSpawnEntityRegistrator;
import de.hexagonsoftware.iob.framework.dragons.util.entityreg.EntityCreator;
import de.hexagonsoftware.iob.framework.dragons.util.entityreg.LivingEntityRegistrator;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;

/**
 * This is a convenience class containing Tools for registering
 * an Entity. It will register the entity under the mod id of iob.
 * 
 * @author Felix Eckert
 * */
public class EntityRegister {
	private LivingEntityRegistrator leReg;
	private CustomSpawnEntityRegistrator cser;
	private EntityCreator entityCreator;
	
	private HashMap<String, RegistryObject<EntityType<BaseEntity>>> REGISTRY;
	
	public EntityRegister() {
		this.leReg = new LivingEntityRegistrator((new API()).getIOB().getModID());
		this.cser = new CustomSpawnEntityRegistrator();
		this.entityCreator = new EntityCreator();
	}
	
	public RegistryObject<EntityType<BaseEntity>> addToRegistry(String name, RegistryObject<EntityType<BaseEntity>> entity) {
		this.REGISTRY.put(name, entity);
		return entity;
	}
	
	public void registerEntityWorldSpawns(String name, List<Biome> biomes, int frequency, int minAmount, int maxAmount, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, @SuppressWarnings("rawtypes") EntitySpawnPlacementRegistry.IPlacementPredicate canSpawnHere) {
		cser.registerCustomSpawnEntry(REGISTRY.get(name).get(),
				biomes, frequency, minAmount, maxAmount, placementType, heightMapType, canSpawnHere);
	}
}
