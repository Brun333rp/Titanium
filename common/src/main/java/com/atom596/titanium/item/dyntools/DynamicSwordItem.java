package com.atom596.titanium.item.dyntools;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;

import java.util.List;

public class DynamicSwordItem extends SwordItem {
    public DynamicSwordItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    private Component getBaseName() {
        return Component.translatable("item.titanium.dynamic_gear.material.iron")
                .withStyle(ChatFormatting.WHITE);
    }

    private void addDetailedComponents(List<Component> components) {
        components.add(Component.translatable("item.titanium.dynamic_gear.perks_from", getBaseName())
                .withStyle(ChatFormatting.GRAY));

        if (false) { // The base provides any benefits

        } else {
            components.add(CommonComponents.SPACE.copy()
                    .append(Component.translatable("item.titanium.dynamic_gear.no_change"))
                    .withStyle(ChatFormatting.DARK_GREEN));
        }
    }

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("item.titanium.dynamic_gear.base", getBaseName())
                .withStyle(ChatFormatting.GRAY));
        components.add(Component.empty());

        if (!Screen.hasShiftDown()) {
            components.add(Component.translatable("item.titanium.dynamic_gear.hold_shift",
                            Minecraft.getInstance().options.keyShift
                                    .getTranslatedKeyMessage().copy()
                                    .withStyle(ChatFormatting.GRAY))
                    .withStyle(ChatFormatting.DARK_GRAY));
        } else {
            addDetailedComponents(components);
        }
    }
}
