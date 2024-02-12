package rexreges.Enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import rexreges.RegionalMobs;

public class RegionalEnchantments {
    public static final Enchantment WEIGHT = new WeightEnchantment();
    public static final Enchantment THRUST = new ThrustEnchantment();

    public static void registerEnchantments() {
        Registry.register(Registries.ENCHANTMENT, new Identifier(RegionalMobs.MOD_ID, "weight"), WEIGHT);
        Registry.register(Registries.ENCHANTMENT, new Identifier(RegionalMobs.MOD_ID, "thrust"), THRUST);
    }
}