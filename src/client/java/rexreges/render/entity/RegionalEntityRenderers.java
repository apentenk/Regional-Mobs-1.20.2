package rexreges.render.entity;

import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import rexreges.Weapons.RegionalTridentEntityTypes;
import rexreges.Weapons.RegionalWeapons;

public class RegionalEntityRenderers {
    public static void registerEntityRenderers(){
        EntityRendererRegistry.register(RegionalTridentEntityTypes.PrismarineTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.PRISMARINE_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.IronTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.IRON_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.AmberIronTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.AMBER_IRON_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.GhostCopperTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.GHOST_COPPER_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.RoseGoldTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.ROSE_GOLD_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.DiamondTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.DIAMOND_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.NetheriteTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.NETHERITE_TRIDENT.getTexture()));

        EntityRendererRegistry.register(RegionalTridentEntityTypes.FreezingNetheriteTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.FREEZING_NETHERITE_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.ScorchingNetheriteTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.SCORCHING_NETHERITE_TRIDENT.getTexture()));
        EntityRendererRegistry.register(RegionalTridentEntityTypes.BloomingNetheriteTridentEntityType,
                (context) -> new RegionalTridentEntityRenderer(context,
                        RegionalWeapons.BLOOMING_NETHERITE_TRIDENT.getTexture()));

        /*
        EntityRendererRegistry.register(RegionalHostileMobs.ARCTIC_SPIDER_ENTITY,
                (context) -> new RegionalSpiderEntityRenderer(context, ArcticSpiderEntity.TEXTURE, ArcticSpiderEntity.EYE_TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.DESERT_SPIDER_ENTITY,
                (context) -> new RegionalSpiderEntityRenderer(context, DesertSpiderEntity.TEXTURE,DesertSpiderEntity.EYE_TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.LUSH_SPIDER_ENTITY,
                (context) -> new RegionalSpiderEntityRenderer(context, LushSpiderEntity.TEXTURE, LushSpiderEntity.EYE_TEXTURE));

        EntityRendererRegistry.register(RegionalHostileMobs.LURKER_ENTITY,
                (context) -> new RegionalCreeperEntityRenderer(context, LurkerEntity.TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.STALKER_ENTITY,
                (context) -> new RegionalCreeperEntityRenderer(context, StalkerEntity.TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.HUNTER_ENTITY,
                (context) -> new RegionalCreeperEntityRenderer(context, HunterEntity.TEXTURE));

        EntityRendererRegistry.register(RegionalHostileMobs.CHILLAGER_ENTITY,
                (context) -> new RegionalPillagerEntityRenderer(context, ChillagerEntity.TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.GRILLAGER_ENTITY,
                (context) -> new RegionalPillagerEntityRenderer(context, GrillagerEntity.TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.TILLAGER_ENTITY,
                (context) -> new RegionalPillagerEntityRenderer(context, TillagerEntity.TEXTURE));

        EntityRendererRegistry.register(RegionalHostileMobs.WIGHT_ENTITY,
                (context) -> new RegionalZombieEntityRenderer(context, WightEntity.TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.HUSK_ENTITY,
                (context) -> new RegionalZombieEntityRenderer(context, HuskEntity.TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.GHOUL_ENTITY,
                (context) -> new RegionalZombieEntityRenderer(context, GhoulEntity.TEXTURE));

        EntityRendererRegistry.register(RegionalHostileMobs.STRAY_ENTITY,
                (context) -> new RegionalSkeletonEntityRenderer(context, StrayEntity.TEXTURE, StrayEntity.OVERLAY_TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.VAGRANT_ENTITY,
                (context) -> new RegionalSkeletonEntityRenderer(context, VagrantEntity.TEXTURE, VagrantEntity.OVERLAY_TEXTURE));
        EntityRendererRegistry.register(RegionalHostileMobs.OUTCAST_ENTITY,
                (context) -> new RegionalSkeletonEntityRenderer(context, OutcastEntity.TEXTURE, OutcastEntity.OVERLAY_TEXTURE));

        EntityRendererRegistry.register(RegionalPassiveMobs.POLAR_BEAR, (context) -> new RegionalBearEntityRenderer(context, RegionalBearEntity.POLAR_TEXTURE));
        EntityRendererRegistry.register(RegionalPassiveMobs.GRIZZLY_BEAR, (context) -> new RegionalBearEntityRenderer(context, RegionalBearEntity.GRIZZLY_TEXTURE));
        EntityRendererRegistry.register(RegionalPassiveMobs.CAMEL_ENTITY, (context) -> new RegionalCamelEntityRenderer(context, EntityModelLayers.CAMEL));
        EntityRendererRegistry.register(RegionalPassiveMobs.KELPIE_ENTITY, context -> new KelpieEntityRenderer(context, EntityModelLayers.ZOMBIE_HORSE));
        EntityRendererRegistry.register(RegionalPassiveMobs.HUFFER_ENTITY, (context) -> new SnifferEntityRenderer(context));

        EntityRendererRegistry.register(RegionalBossMobs.ARCTIC_DEVASTATOR, (context) -> new DevastatorEntityRenderer(context, ArcticDevastator.TEXTURE));
        EntityRendererRegistry.register(RegionalBossMobs.DESERT_DEVASTATOR, (context) -> new DevastatorEntityRenderer(context, DesertDevastator.TEXTURE));
        EntityRendererRegistry.register(RegionalBossMobs.VERDANT_DEVASTATOR, (context) -> new DevastatorEntityRenderer(context, VerdantDevastator.TEXTURE));
        EntityRendererRegistry.register(RegionalBossMobs.DEVASTATOR_JOCKEY, (context) -> new DevastatorJockeyRenderer<DevastatorJockey>(context));
        EntityRendererRegistry.register(RegionalBossMobs.REGIONAL_VEX, (context) -> new VexEntityRenderer(context));
        */
    }
}
