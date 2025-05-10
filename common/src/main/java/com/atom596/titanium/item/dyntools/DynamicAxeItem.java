package com.atom596.titanium.item.dyntools;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class DynamicAxeItem extends AxeItem {
    public DynamicAxeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("item.titanium.dynamic_gear.base")
                .append(CommonComponents.SPACE)
                .append(Component.translatable("item.titanium.dynamic_gear.material.iron"))
                .withStyle(ChatFormatting.GRAY));
    }
}
