package com.atom596.titanium.mixin;

import com.atom596.titanium.item.dyntools.BaseMaterialRegistry;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(TieredItem.class)
public class DynamicGearMixin {
    @Unique
    private ResourceLocation baseMaterial = null;

    @Inject(at = @At("TAIL"), method = "<init>")
    public void checkDynamic(Tier tier, Item.Properties properties, CallbackInfo ci) {
        if (tier == Tiers.DIAMOND) { // Check if this item is dynamic (WRITE LATER)
            baseMaterial = ResourceLocation.withDefaultNamespace("iron");
        }
    }

    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, List<Component> components, TooltipFlag flag) {
        if (baseMaterial != null) {
            BaseMaterialRegistry.BASE_MATERIAL.get(baseMaterial).addToTooltip(context, components::add, flag);
        }
    }
}
