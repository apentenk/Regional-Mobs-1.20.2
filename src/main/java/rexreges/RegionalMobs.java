package rexreges;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import rexreges.Armor.RegionalArmor;
import rexreges.Enchantments.RegionalEnchantments;
import rexreges.Items.RegionalItems;
import rexreges.StatusEffects.RegionalStatusEffects;
import rexreges.Tools.RegionalTools;
import rexreges.Weapons.RegionalWeapons;

import java.text.DecimalFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegionalMobs implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("regionalmobs");
	public static final String MOD_ID = "regionalmobs";
	public enum UPGRADE {
		FREEZING,
		SCORCHING,
		BLOOMING
	}
	
	public static void registerItem(String name, Item item) {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, name), item);
	}

	public static void addToItemGroup(RegistryKey<ItemGroup> group, Item tool, Item place) {
		try {
			ItemGroupEvents.modifyEntriesEvent(group).register(content -> {
				content.addAfter(place, tool);
			});
		} catch (IllegalStateException e) {
			LOGGER.warn(e.getMessage());
		}
	}

	public static void registerEffect(String name, StatusEffect effect) {
		Registry.register(Registries.STATUS_EFFECT, new Identifier(MOD_ID, name), effect);
	}

	public static void registerPotion(String name, Potion potion) {
		Registry.register(Registries.POTION, new Identifier(MOD_ID, name), potion);
	}

	public static String formatNumberToolTip(double number) {
		DecimalFormat f = new DecimalFormat("0.#");
		return (" " + f.format(number));
	}

	@Override
	public void onInitialize() {
		RegionalItems.registerItems();
		RegionalTools.registerTools();
		RegionalWeapons.registerRangedWeapons();
		RegionalArmor.registerArmor();
		RegionalEnchantments.registerEnchantments();
		RegionalStatusEffects.registerStatusEffectsAndPotions();
	}
}