package com.atom596.titanium.item;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.item.dyntools.BaseMaterial;
import com.atom596.titanium.item.dyntools.BaseMaterialRegistry;
import com.atom596.titanium.regutils.RegistrationProvider;
import com.atom596.titanium.regutils.RegistryObject;

public class TitaniumGearBases {
    public static final RegistrationProvider<BaseMaterial> BASE_MATERIALS = RegistrationProvider.get(BaseMaterialRegistry.BASE_MATERIAL, Titanium.MOD_ID);

    public static final RegistryObject<BaseMaterial, BaseMaterial> IRON_GEAR_BASE = BASE_MATERIALS.register("iron",
            () -> new BaseMaterial(1));
    public static final RegistryObject<BaseMaterial, BaseMaterial> NETHERITE_GEAR_BASE = BASE_MATERIALS.register("netherite",
            () -> new BaseMaterial(2));
    public static final RegistryObject<BaseMaterial, BaseMaterial> TITANIUM_GEAR_BASE = BASE_MATERIALS.register("titanium",
            () -> new BaseMaterial(3));

    public static void init() {}
}
