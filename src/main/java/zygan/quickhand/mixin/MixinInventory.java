package zygan.quickhand.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;

@Mixin(Inventory.class)
public abstract class MixinInventory {
   @Shadow
   public int selected;
   
   @Inject(method = "getSelected", at = @At("HEAD"), cancellable = true)
   public void onGetSelected(CallbackInfoReturnable<ItemStack> cir) {
      if (this.selected == -2) {
         cir.setReturnValue(ItemStack.EMPTY);
      }
   }
}
