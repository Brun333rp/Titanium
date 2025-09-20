package com.atom596.titanium.mixin;

import com.atom596.titanium.item.dyntools.BaseMaterialRegistry;
import net.fabricmc.fabric.api.event.registry.FabricRegistryBuilder;
import net.fabricmc.fabric.api.event.registry.RegistryAttribute;
import net.minecraft.server.Bootstrap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bootstrap.class)
public class BaseMaterialRegistryMixinFabric {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/FireBlock;bootStrap()V"), method = "bootStrap")
    private static void createRegistry(CallbackInfo ci) {
        BaseMaterialRegistry.BASE_MATERIAL =
                FabricRegistryBuilder.createSimple(BaseMaterialRegistry.BASE_MATERIAL_KEY).attribute(RegistryAttribute.SYNCED).buildAndRegister();
    }
}
