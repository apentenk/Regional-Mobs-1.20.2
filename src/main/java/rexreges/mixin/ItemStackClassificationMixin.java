package rexreges.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rexreges.Armor.RegionalArmorMaterial;
import rexreges.Armor.RegionalShield;
import rexreges.Weapons.RegionalBow;
import rexreges.Weapons.RegionalCrossbow;
import rexreges.Weapons.RegionalTrident;

@Mixin(ItemStack.class)
public class ItemStackClassificationMixin {

    @Inject(method = "isOf", at = @At("RETURN"), cancellable = true)
    private void isOf(Item item, CallbackInfoReturnable<Boolean> cir) {
        Item thisItem = ((ItemStack) (Object) this).getItem();
        if (item == Items.ELYTRA && thisItem instanceof ArmorItem) {
            ArmorMaterial material = ((ArmorItem) thisItem).getMaterial();
            if (material instanceof RegionalArmorMaterial) {
                cir.setReturnValue(((RegionalArmorMaterial)material).isElytra());
            }

        } else if (item == Items.CROSSBOW && thisItem instanceof RegionalCrossbow) {
            cir.setReturnValue(true);
        } else if (item == Items.BOW && thisItem instanceof RegionalBow) {
            cir.setReturnValue(true);
        } else if (item == Items.TRIDENT && thisItem instanceof RegionalTrident) {
            cir.setReturnValue(true);
        } else if (item == Items.SHIELD && thisItem instanceof RegionalShield) {
            cir.setReturnValue(true);
        }
    }

    /*
    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void use(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        if (!world.getGameRules().getBoolean(RegionalMobs.USE_VANILLA_BOWS)){
            Item thisItem = ((ItemStack) (Object) this).getItem();
            boolean hasRegional = (thisItem instanceof BowItem && !(thisItem instanceof RegionalBow)) ||
                                    (thisItem instanceof CrossbowItem && !(thisItem instanceof RegionalCrossbow)) ||
                                    (thisItem instanceof TridentItem && !(thisItem instanceof RegionalTrident)) ||
                                    (thisItem instanceof ShieldItem && !(thisItem instanceof RegionalShield));
            if(hasRegional){
                cir.setReturnValue(TypedActionResult.fail(((ItemStack) (Object) this)));
            }
        }
    }
    */
}
