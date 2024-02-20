package rexreges.Mobs.Hostile;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.StrayEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rexreges.RegionalMobs;

public class RegionalHostileMobs {
        public static final EntityType<StrayEntity> STRAY_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "stray"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StrayEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.99f)).trackRangeBlocks(8).build());
        public static final EntityType<VagrantEntity> VAGRANT_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "vagrant"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, VagrantEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.99f)).trackRangeBlocks(8).build());
        public static final EntityType<OutcastEntity> OUTCAST_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "outcast"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, OutcastEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.99f)).trackRangeBlocks(8).build());

        public static final EntityType<GhoulEntity> GHOUL_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "ghoul"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GhoulEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).trackRangeBlocks(8).build());
        public static final EntityType<WightEntity> WIGHT_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "wight"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, WightEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).trackRangeBlocks(8).build());
        public static final EntityType<HuskEntity> HUSK_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "husk"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HuskEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).trackRangeBlocks(8).build());


        public static final EntityType<StalkerEntity> STALKER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "stalker"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, StalkerEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.7f)).trackRangeBlocks(8).build());
        public static final EntityType<LurkerEntity> LURKER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "lurker"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LurkerEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.7f)).trackRangeBlocks(8).build());
        public static final EntityType<HunterEntity> HUNTER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "hunter"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HunterEntity::new)
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.7f)).trackRangeBlocks(8).build());


        public static final EntityType<ArcticSpiderEntity> ARCTIC_SPIDER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "arctic_spider"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ArcticSpiderEntity::new)
                                        .dimensions(EntityDimensions.fixed(1.4f, 0.9f)).trackRangeBlocks(8).build());
        public static final EntityType<DesertSpiderEntity> DESERT_SPIDER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "desert_spider"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, DesertSpiderEntity::new)
                                        .dimensions(EntityDimensions.fixed(1.4f, 0.9f)).trackRangeBlocks(8).build());
        public static final EntityType<LushSpiderEntity> LUSH_SPIDER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "lush_spider"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, LushSpiderEntity::new)
                                        .dimensions(EntityDimensions.fixed(1.4f, 0.9f)).trackRangeBlocks(8).build());

        public static final EntityType<GrillagerEntity> GRILLAGER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "grillager"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GrillagerEntity::new)
                                        .spawnableFarFromPlayer()
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).trackRangeBlocks(8).build());
        public static final EntityType<ChillagerEntity> CHILLAGER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "chillager"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, ChillagerEntity::new)
                                        .spawnableFarFromPlayer()
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).trackRangeBlocks(8).build());
        public static final EntityType<TillagerEntity> TILLAGER_ENTITY = Registry.register(Registries.ENTITY_TYPE,
                        new Identifier(RegionalMobs.MOD_ID, "tillager"),
                        FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, TillagerEntity::new)
                                        .spawnableFarFromPlayer()
                                        .dimensions(EntityDimensions.fixed(0.6f, 1.95f)).trackRangeBlocks(8).build());

        public static void registerHostileMobs() {
                FabricDefaultAttributeRegistry.register(STRAY_ENTITY, RegionalSkeletonEntity.createAbstractSkeletonAttributes());
                FabricDefaultAttributeRegistry.register(VAGRANT_ENTITY, RegionalSkeletonEntity.createAbstractSkeletonAttributes());
                FabricDefaultAttributeRegistry.register(OUTCAST_ENTITY, RegionalSkeletonEntity.createAbstractSkeletonAttributes());

                FabricDefaultAttributeRegistry.register(HUSK_ENTITY, RegionalZombieEntity.createZombieAttributes());
                FabricDefaultAttributeRegistry.register(WIGHT_ENTITY, RegionalZombieEntity.createZombieAttributes());
                FabricDefaultAttributeRegistry.register(GHOUL_ENTITY, RegionalZombieEntity.createZombieAttributes());

                FabricDefaultAttributeRegistry.register(STALKER_ENTITY, CreeperEntity.createCreeperAttributes());
                FabricDefaultAttributeRegistry.register(LURKER_ENTITY, CreeperEntity.createCreeperAttributes());
                FabricDefaultAttributeRegistry.register(HUNTER_ENTITY, CreeperEntity.createCreeperAttributes());

                FabricDefaultAttributeRegistry.register(ARCTIC_SPIDER_ENTITY, ArcticSpiderEntity.createSpiderAttributes());
                FabricDefaultAttributeRegistry.register(DESERT_SPIDER_ENTITY, DesertSpiderEntity.createSpiderAttributes());
                FabricDefaultAttributeRegistry.register(LUSH_SPIDER_ENTITY, LushSpiderEntity.createSpiderAttributes());

                FabricDefaultAttributeRegistry.register(GRILLAGER_ENTITY, RegionalPillagerEntity.createPillagerAttributes());
                FabricDefaultAttributeRegistry.register(CHILLAGER_ENTITY, RegionalPillagerEntity.createPillagerAttributes());
                FabricDefaultAttributeRegistry.register(TILLAGER_ENTITY, RegionalPillagerEntity.createPillagerAttributes());
        }
}
