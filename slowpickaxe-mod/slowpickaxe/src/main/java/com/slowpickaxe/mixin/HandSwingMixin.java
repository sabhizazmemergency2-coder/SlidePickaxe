package com.slowpickaxe.mixin;

import com.slowpickaxe.config.SlowPickaxeConfig;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ClientPlayerEntity.class)
public class HandSwingMixin {

    /**
     * On intercepte la durée du swing de la main.
     * La valeur par défaut dans Minecraft est 6 ticks.
     * On la multiplie par le multiplicateur configuré.
     */
    @ModifyVariable(
        method = "tickNewCurrentHand",
        at = @At("STORE"),
        ordinal = 0
    )
    private int slowDownPickaxeSwing(int swingDuration) {
        ClientPlayerEntity player = (ClientPlayerEntity) (Object) this;
        ItemStack heldItem = player.getMainHandStack();

        // On applique le ralentissement seulement si c'est une pioche
        if (heldItem.getItem() instanceof PickaxeItem) {
            int multiplier = SlowPickaxeConfig.get().swingSpeedMultiplier;
            return swingDuration * multiplier;
        }

        return swingDuration;
    }
}
