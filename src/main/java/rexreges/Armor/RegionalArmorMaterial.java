package rexreges.Armor;

import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import rexreges.Items.RegionalItems;

public class RegionalArmorMaterial implements ArmorMaterial {
    public static final RegionalArmorMaterial FREEZING_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE,
            "freezing_netherite_elytra", RegionalItems.FREEZING_TOTEM, true);
    public static final RegionalArmorMaterial SCORCHING_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE, "scorching_netherite_elytra", RegionalItems.SCHORCHING_TOTEM, true);
    public static final RegionalArmorMaterial BLOOMING_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE,
            "blooming_netherite_elytra", RegionalItems.BLOOMING_TOTEM, true);

    public static final RegionalArmorMaterial ROSE_GOLD_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            RegionalItems.ROSE_GOLD_INGOT, ArmorMaterials.DIAMOND,
            "rose_gold_elytra", true);
    public static final RegionalArmorMaterial AMBER_IRON_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            RegionalItems.AMBER_IRON_INGOT, ArmorMaterials.DIAMOND,
            "amber_iron_elytra", true);
    public static final RegionalArmorMaterial GHOST_COPPER_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            RegionalItems.GHOST_COPPER_INGOT,
            ArmorMaterials.DIAMOND, "ghost_copper_elytra", true);

    public static final RegionalArmorMaterial LEATHER_ELYTRA_ARMOR_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.LEATHER, "leather_elytra", Items.LEATHER, true);
    public static final RegionalArmorMaterial IRON_ELYTRA_MATERIAL = new RegionalArmorMaterial(ArmorMaterials.IRON,
            "iron_elytra", Items.IRON_INGOT, true);
    public static final RegionalArmorMaterial DIAMOND_ELYTRA_MATERIAL = new RegionalArmorMaterial(ArmorMaterials.DIAMOND,
            "diamond_elytra", Items.DIAMOND, true);
    public static final RegionalArmorMaterial NETHERITE_ELYTRA_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE, "netherite_elytra", Items.NETHERITE_INGOT, true);

    public static final RegionalArmorMaterial FREEZING_ARMOR_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE,
            "freezing_netherite_armor", RegionalItems.FREEZING_TOTEM);
    public static final RegionalArmorMaterial SCORCHING_ARMOR_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE, "scorching_netherite_armor", RegionalItems.SCHORCHING_TOTEM);
    public static final RegionalArmorMaterial BLOOMING_ARMOR_MATERIAL = new RegionalArmorMaterial(
            ArmorMaterials.NETHERITE,
            "blooming_netherite_armor", RegionalItems.BLOOMING_TOTEM);

    public static final RegionalArmorMaterial ROSE_GOLD_ARMOR_MATERIAL = new RegionalArmorMaterial(
            RegionalItems.ROSE_GOLD_INGOT, ArmorMaterials.DIAMOND,
            "rose_gold_armor");
    public static final RegionalArmorMaterial AMBER_IRON_ARMOR_MATERIAL = new RegionalArmorMaterial(
            RegionalItems.AMBER_IRON_INGOT, ArmorMaterials.DIAMOND,
            "amber_iron_armor");
    public static final RegionalArmorMaterial GHOST_COPPER_ARMOR_MATERIAL = new RegionalArmorMaterial(
            RegionalItems.GHOST_COPPER_INGOT,
            ArmorMaterials.DIAMOND, "ghost_copper_armor");

    private final ArmorMaterial material;
    private final Item base;
    private final Ingredient repair;
    private final String name;
    private boolean elytra = false;

    public RegionalArmorMaterial(ArmorMaterial material, String name, Item base) {
        this.material = material;
        this.repair = material.getRepairIngredient();
        this.base = base;
        this.name = name;
    }

    public RegionalArmorMaterial(Item base, ArmorMaterial material, String name) {
        this.material = material;
        this.repair = Ingredient.ofItems(base);
        this.base = base;
        this.name = name;
    }

    public RegionalArmorMaterial(ArmorMaterial material, String name, Item base, boolean elytra) {
        this.material = material;
        this.repair = material.getRepairIngredient();
        this.base = base;
        this.name = name;
        this.elytra = elytra;
    }

    public RegionalArmorMaterial(Item base, ArmorMaterial material, String name, boolean elytra) {
        this.material = material;
        this.repair = Ingredient.ofItems(base);
        this.base = base;
        this.name = name;
        this.elytra = elytra;
    }

    public Item getBase() {
        return this.base;
    }

    public boolean isElytra(){
        return this.elytra;
    }

    @Override
    public int getDurability(Type var1) {
        return this.material.getDurability(var1);
    }

    @Override
    public int getProtection(Type var1) {
        if (elytra) {
            return (this.material.getProtection(var1) - 1);
        }
        return this.material.getProtection(var1);
    }

    @Override
    public int getEnchantability() {
        return this.material.getEnchantability();
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.material.getEquipSound();
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repair;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return 0;
    }

    @Override
    public float getKnockbackResistance() {
        if (this.elytra) {
            return material.getKnockbackResistance() / 2;
        }
        return material.getKnockbackResistance();
    }

}
