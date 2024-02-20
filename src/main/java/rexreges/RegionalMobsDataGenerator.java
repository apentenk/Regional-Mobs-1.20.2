package rexreges;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import rexreges.Util.RegionalEnglishLangProvider;
import rexreges.Util.RegionalModelGenerator;

public class RegionalMobsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(RegionalModelGenerator::new);
		pack.addProvider(RegionalEnglishLangProvider::new);
	}

	public static Identifier getItemIdentifier(Item item) {
		return Registries.ITEM.getId(item);
	}

	public static Identifier getStatusIdentifier(StatusEffect effect) {
		return Registries.STATUS_EFFECT.getId(effect);
	}

	public static ArmorItem getRegistryArmor(Item armor) {
		return (ArmorItem) Registries.ITEM.getEntry(armor).value();
	}

	public static Item getRegistryItem(Item item) {
		return Registries.ITEM.getEntry(item).value();
	}
}
