package com.atom596.titanium.mixin;

import com.atom596.titanium.item.dyntools.BaseMaterialRegistry;
import net.minecraft.server.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class BaseMaterialRegistryMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/core/registries/BuiltInRegistries;bootStrap()V", shift = At.Shift.AFTER), method = "bootStrap")
    private static void freezeRegistry(CallbackInfo ci) {
        BaseMaterialRegistry.BASE_MATERIAL.freeze();
    }
}
