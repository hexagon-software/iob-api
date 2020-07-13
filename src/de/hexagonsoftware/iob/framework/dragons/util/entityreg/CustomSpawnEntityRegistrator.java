package de.hexagonsoftware.iob.framework.dragons.util.entityreg;

import java.util.List;
import java.util.Objects;

import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.Heightmap;

/**
 * Used to register Entities with Spawn Biomes.
 * 
 * @author Felix Eckert
 * */
public class CustomSpawnEntityRegistrator {
    @SuppressWarnings("unchecked")
	public static <T extends MobEntity> void registerCustomSpawnEntry(EntityType<T> entity, List<Biome> biomes, int frequency, int minAmount, int maxAmount, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, @SuppressWarnings("rawtypes") EntitySpawnPlacementRegistry.IPlacementPredicate canSpawnHere) {
        registerBiomeSpawnEntry(entity, frequency, minAmount, maxAmount, biomes);
        EntitySpawnPlacementRegistry.register(entity, placementType, heightMapType, canSpawnHere);
    }
    
    private static void registerBiomeSpawnEntry(EntityType<?> entity, int frequency, int minAmount, int maxAmount, List<Biome> biomes) {
        biomes.stream().filter(Objects::nonNull).forEach(biome -> biome.getSpawns(entity.getClassification()).add(new Biome.SpawnListEntry(entity, frequency, minAmount, maxAmount)));
    }
}
