package com.atom596.titanium.mixin;

import com.atom596.titanium.item.dyntools.*;
import net.minecraft.world.item.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.world.item.Items.registerItem;

@Mixin(Items.class)
public class DiamondGearMixin {
    @Shadow @Final @Mutable
    public static Item DIAMOND_SHOVEL;

    @Shadow @Final @Mutable
    public static Item DIAMOND_SWORD;

    @Shadow @Final @Mutable
    public static Item DIAMOND_PICKAXE;

    @Shadow @Final @Mutable
    public static Item DIAMOND_AXE;

    @Shadow @Final @Mutable
    public static Item DIAMOND_HOE;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void replaceDiamondSword(CallbackInfo ci) {
        DIAMOND_SHOVEL = registerItem("diamond_shovel",
                new DynamicShovelItem(Tiers.DIAMOND, (new Item.Properties()).attributes(ShovelItem.createAttributes(Tiers.DIAMOND, 1.5F, -3.0F))));
        DIAMOND_SWORD = registerItem("diamond_sword",
                new DynamicSwordItem(Tiers.DIAMOND, (new Item.Properties()).attributes(SwordItem.createAttributes(Tiers.DIAMOND, 3, -2.4F))));
        DIAMOND_PICKAXE = registerItem("diamond_pickaxe",
                new DynamicPickaxeItem(Tiers.DIAMOND, (new Item.Properties()).attributes(PickaxeItem.createAttributes(Tiers.DIAMOND, 1.0F, -2.8F))));
        DIAMOND_AXE = registerItem("diamond_axe",
                new DynamicAxeItem(Tiers.DIAMOND, (new Item.Properties()).attributes(AxeItem.createAttributes(Tiers.DIAMOND, 5.0F, -3.0F))));
        DIAMOND_HOE = registerItem("diamond_hoe",
                new DynamicHoeItem(Tiers.DIAMOND, (new Item.Properties()).attributes(HoeItem.createAttributes(Tiers.DIAMOND, -3.0F, 0.0F))));
    }
}
