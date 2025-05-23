package com.atom596.titanium.item;

import com.atom596.titanium.item.dyntools.BaseMaterial;
import com.atom596.titanium.item.dyntools.BaseMaterialRegistry;
import net.minecraft.core.Registry;

public class TitaniumGearBases {

    public static final BaseMaterial IRON_GEAR_BASE = Registry.register(BaseMaterialRegistry.BASE_MATERIAL, "iron",
            new BaseMaterial(1));
    public static final BaseMaterial NETHERITE_GEAR_BASE = Registry.register(BaseMaterialRegistry.BASE_MATERIAL, "netherite",
            new BaseMaterial(2));
    public static final BaseMaterial TITANIUM_GEAR_BASE = Registry.register(BaseMaterialRegistry.BASE_MATERIAL, "titanium",
            new BaseMaterial(3));

    public static void init() {}
}
