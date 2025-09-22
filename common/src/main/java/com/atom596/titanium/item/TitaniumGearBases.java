package com.atom596.titanium.item;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.item.dyntools.BaseMaterial;
import com.atom596.titanium.item.dyntools.BaseMaterialRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;

public class TitaniumGearBases {
    public static final Holder<BaseMaterial> IRON_GEAR_BASE = Registry.registerForHolder(BaseMaterialRegistry.BASE_MATERIAL, ResourceLocation.withDefaultNamespace("iron"),
            new BaseMaterial(1));
    public static final Holder<BaseMaterial> NETHERITE_GEAR_BASE = Registry.registerForHolder(BaseMaterialRegistry.BASE_MATERIAL, ResourceLocation.withDefaultNamespace("iron"),
            new BaseMaterial(2));
    public static final Holder<BaseMaterial> TITANIUM_GEAR_BASE = Registry.registerForHolder(BaseMaterialRegistry.BASE_MATERIAL, ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "titanium"),
            new BaseMaterial(3));

    public static Holder<BaseMaterial> bootstrap(Registry<BaseMaterial> registry) {
        BaseMaterialRegistry.BASE_MATERIAL.freeze();
        return IRON_GEAR_BASE;
    }
}
