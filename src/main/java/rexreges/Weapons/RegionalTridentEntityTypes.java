package rexreges.Weapons;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rexreges.RegionalMobs;

public class RegionalTridentEntityTypes {
    public static final EntityType<RegionalTridentEntity> PrismarineTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "prismarine_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> IronTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "iron_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> DiamondTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "diamond_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> NetheriteTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "netherite_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> RoseGoldTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "rose_gold_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> AmberIronTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "amber_iron_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> GhostCopperTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "ghost_copper_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> FreezingNetheriteTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "freezing_netherite_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> ScorchingNetheriteTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "scorching_netherite_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

    public static final EntityType<RegionalTridentEntity> BloomingNetheriteTridentEntityType = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(RegionalMobs.MOD_ID, "blooming_netherite_trident_entity"),
            FabricEntityTypeBuilder
                    .<RegionalTridentEntity>create(SpawnGroup.MISC, RegionalTridentEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                    .trackRangeBlocks(4).trackedUpdateRate(20)
                    .build());

}
