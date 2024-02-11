package rexreges.Tools;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import rexreges.Items.RegionalItems;

public class RegionalToolMaterial implements ToolMaterial {
    public static final RegionalToolMaterial CRYSTAL_TOOL_MATERIAL = new RegionalToolMaterial(
            1.1f, Ingredient.ofItems(Items.AMETHYST_SHARD), 0.6f);
    public static final RegionalToolMaterial ROSE_GOLD_TOOL_MATERIAL = new RegionalToolMaterial(
            1.1f, Ingredient.ofItems(RegionalItems.ROSE_GOLD_INGOT));

    private final float durabilityModifier;
    private final Ingredient repair;
    private final float attackModifier;

    private RegionalToolMaterial(float durabilityModifier, Ingredient repair) {
        this(durabilityModifier, repair, 0);
    }

    private RegionalToolMaterial(float durabilityModifier, Ingredient repair, float attackModifier) {
        this.durabilityModifier = durabilityModifier;
        this.attackModifier = attackModifier;
        this.repair = repair;
    }

    @Override
    public int getDurability() {
        return (int) (ToolMaterials.IRON.getDurability() / this.durabilityModifier);
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return ToolMaterials.IRON.getMiningSpeedMultiplier();
    }

    @Override
    public float getAttackDamage() {
        return ToolMaterials.IRON.getAttackDamage() + this.attackModifier;
    }

    @Override
    public int getMiningLevel() {
        return ToolMaterials.IRON.getMiningLevel();
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repair;
    }

}