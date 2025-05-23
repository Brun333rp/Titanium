package com.atom596.titanium.item.dyntools;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

import java.util.List;
import java.util.function.Consumer;

public class DynamicSwordItem extends SwordItem {
    private ResourceLocation base = ResourceLocation.withDefaultNamespace("iron");

    public DynamicSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    private void addDetailedComponents(Item.TooltipContext context, Consumer<Component> components, TooltipFlag flag) { // Move to BaseMaterial::addToTooltip()
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> components, TooltipFlag flag) {
        BaseMaterialRegistry.BASE_MATERIAL.get(base).addToTooltip(context, components::add, flag);
    }
}
