package com.atom596.titanium.item.dyntools;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.item.TitaniumGearBases;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class BaseMaterialRegistry {
    public static final ResourceKey<Registry<BaseMaterial>> BASE_MATERIAL_KEY =
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "base_material"));
    public static final Registry<BaseMaterial> BASE_MATERIAL = BuiltInRegistries.registerSimple(BaseMaterialRegistry.BASE_MATERIAL_KEY,
            TitaniumGearBases::bootstrap
    );
}
