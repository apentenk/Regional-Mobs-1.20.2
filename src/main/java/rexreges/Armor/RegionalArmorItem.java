package rexreges.Armor;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.recipe.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RegionalArmorItem extends ArmorItem {
    private final int amplifier;
    private final StatusEffect setBonusOne;
    private final StatusEffect setBonusTwo;
    private final Ingredient repair;
    private final Item base;

    public RegionalArmorItem(ArmorMaterial material, Type type, Item base, boolean upgrade, StatusEffect bonusOne, StatusEffect bonusTwo,
            Settings settings) {
        super(material, type, settings);
        if(upgrade){
            this.repair = material.getRepairIngredient();
            this.amplifier = 4;
        }
        else{
            this.repair = Ingredient.ofItems(base);
            this.amplifier = 2;
        }
        this.base = base;
        this.setBonusOne = bonusOne;
        this.setBonusTwo = bonusTwo;
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return this.repair.test(ingredient);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient()) {
            if (entity instanceof LivingEntity) {
                LivingEntity livingEntity = (LivingEntity) entity;
                if (isWearingMatchingSet(livingEntity)) {
                    if (!livingEntity.hasStatusEffect(setBonusOne)
                            || livingEntity.getStatusEffect(setBonusOne).isDurationBelow(220)) {
                        livingEntity.addStatusEffect(new StatusEffectInstance(setBonusOne, 260, amplifier, false, false, true));
                        livingEntity.addStatusEffect(new StatusEffectInstance(setBonusTwo, 260, amplifier, false, false, true));
                    }
                    if (!livingEntity.hasStatusEffect(setBonusTwo)
                            || livingEntity.getStatusEffect(setBonusTwo).isDurationBelow(220)) {
                        livingEntity.addStatusEffect(new StatusEffectInstance(setBonusOne, 260, amplifier, false, false, true));
                        livingEntity.addStatusEffect(new StatusEffectInstance(setBonusTwo, 260, amplifier, false, false, true));
                    }
                }
            }
        }
    }

    private boolean isWearingMatchingSet(LivingEntity entity) {
        for (ItemStack stack : entity.getArmorItems()) {
            if (stack.isEmpty()) {
                return false;
            }

            ArmorItem armor = ((ArmorItem) stack.getItem());
            ArmorMaterial armorMaterial = armor.getMaterial();

            if (armorMaterial instanceof ElytraArmorMaterial) {
                if (((ElytraArmorMaterial)armorMaterial).getBase() != (this.base)) {
                    return false;
                }
            } else if (!armor.getMaterial().equals(this.material)) {
                return false;
            }
        }
        return true;
    }

}
