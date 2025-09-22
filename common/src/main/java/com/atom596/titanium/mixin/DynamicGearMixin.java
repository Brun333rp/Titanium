package com.atom596.titanium.mixin;

import com.atom596.titanium.item.TitaniumGearBases;
import com.atom596.titanium.item.dyntools.BaseMaterial;
import net.minecraft.network.chat.Component;
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
    private BaseMaterial titanium$baseMaterial = null;

    @Inject(at = @At("TAIL"), method = "<init>")
    public void checkDynamic(Tier tier, Item.Properties properties, CallbackInfo ci) {
        if (tier == Tiers.DIAMOND) { // Check if this item is dynamic (WRITE LATER)
            titanium$baseMaterial = TitaniumGearBases.IRON_GEAR_BASE.value();
        }
    }

    public void appendHoverText(ItemStack itemStack, Item.TooltipContext context, List<Component> components, TooltipFlag flag) {
        if (titanium$baseMaterial != null) {
            titanium$baseMaterial.addToTooltip(context, components::add, flag);
        }
    }
}
