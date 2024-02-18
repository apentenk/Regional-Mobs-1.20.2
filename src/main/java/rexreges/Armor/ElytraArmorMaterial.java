package rexreges.Armor;

import net.minecraft.item.ArmorItem.Type;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import rexreges.Items.RegionalItems;

public class ElytraArmorMaterial implements ArmorMaterial{
    public static final ElytraArmorMaterial FREEZING_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "freezing_netherite_elytra", RegionalItems.FREEZING_TOTEM);
    public static final ElytraArmorMaterial SCORCHING_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "scorching_netherite_elytra", RegionalItems.SCHORCHING_TOTEM);
    public static final ElytraArmorMaterial BLOOMING_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "blooming_netherite_elytra", RegionalItems.BLOOMING_TOTEM);

    public static final ElytraArmorMaterial ROSE_GOLD_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "rose_gold_elytra", RegionalItems.ROSE_GOLD_INGOT);
    public static final ElytraArmorMaterial AMBER_IRON_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "amber_iron_elytra", RegionalItems.AMBER_IRON_INGOT);
    public static final ElytraArmorMaterial GHOST_COPPER_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "ghost_copper_elytra", RegionalItems.GHOST_COPPER_INGOT);

    public static final ElytraArmorMaterial LEATHER_ELYTRA_ARMOR_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.LEATHER, "leather_elytra", Items.LEATHER);
    public static final ElytraArmorMaterial IRON_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.IRON,"iron_elytra", Items.IRON_INGOT);
    public static final ElytraArmorMaterial DIAMOND_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.DIAMOND, "diamond_elytra", Items.DIAMOND);
    public static final ElytraArmorMaterial NETHERITE_ELYTRA_MATERIAL = new ElytraArmorMaterial(ArmorMaterials.NETHERITE, "netherite_elytra", Items.NETHERITE_INGOT);

    private final ArmorMaterial material;
    private final Item base;
    private final Ingredient repair;
    private final String name;

    public ElytraArmorMaterial (ArmorMaterial material, String name, Item base){
        this.material = material;
        this.repair = material.getRepairIngredient();
        this.base = base;
        this.name = name;
    }

    public ElytraArmorMaterial (ArmorMaterial material, Ingredient repair, String name, Item base){
        this.material = material;
        this.repair = repair;
        this.base = base;
        this.name = name;
    }

    public Item getBase(){
        return this.base;
    }

    @Override
    public int getDurability(Type var1) {
        return this.material.getDurability(var1);
    }

    @Override
    public int getProtection(Type var1) {
        switch (var1) {
            case HELMET:
                return this.material.getProtection(var1);
            default:
                return (this.material.getProtection(var1) - 1);
        }
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
        return material.getKnockbackResistance()/2;
    }
    
}
