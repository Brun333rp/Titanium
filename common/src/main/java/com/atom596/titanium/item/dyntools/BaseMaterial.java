package com.atom596.titanium.item.dyntools;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.component.TooltipProvider;

import java.util.List;
import java.util.function.Consumer;

public record BaseMaterial(int flightDuration) implements TooltipProvider {
    public static final Codec<net.minecraft.world.item.component.Fireworks> CODEC = RecordCodecBuilder.create(($$0) -> {
        return $$0.group(ExtraCodecs.UNSIGNED_BYTE.optionalFieldOf("flight_duration", 0).forGetter(net.minecraft.world.item.component.Fireworks::flightDuration), FireworkExplosion.CODEC.sizeLimitedListOf(256).optionalFieldOf("explosions", List.of()).forGetter(net.minecraft.world.item.component.Fireworks::explosions)).apply($$0, net.minecraft.world.item.component.Fireworks::new);
    });
    public static final StreamCodec<ByteBuf, net.minecraft.world.item.component.Fireworks> STREAM_CODEC;

    public BaseMaterial(int flightDuration) {
        this.flightDuration = flightDuration;
    }

    public Component getBaseName() {
        return Component.translatable("item.titanium.dynamic_gear.material.iron")
                .withStyle(ChatFormatting.WHITE);
    }

    public void addToTooltip(Item.TooltipContext context, Consumer<Component> components, TooltipFlag flag) {
        components.accept(Component.translatable("item.titanium.dynamic_gear.base", getBaseName())
                .withStyle(ChatFormatting.GRAY));
        if (!Screen.hasShiftDown()) {
            components.accept(Component.translatable("item.titanium.dynamic_gear.hold_shift",
                            Minecraft.getInstance().options.keyShift.getTranslatedKeyMessage().copy().withStyle(ChatFormatting.GRAY))
                    .withStyle(ChatFormatting.DARK_GRAY));
        } else {
            components.accept(Component.translatable("item.titanium.dynamic_gear.hold_shift",
                            Minecraft.getInstance().options.keyShift.getTranslatedKeyMessage().copy().withStyle(ChatFormatting.WHITE))
                    .withStyle(ChatFormatting.DARK_GRAY));
            components.accept(Component.empty());

            components.accept(Component.translatable("item.titanium.dynamic_gear.perks_from", getBaseName())
                    .withStyle(ChatFormatting.GRAY));

            if (false) { // If the base provides any benefits

            } else {
                components.accept(CommonComponents.SPACE.copy()
                        .append(Component.translatable("item.titanium.dynamic_gear.no_change"))
                        .withStyle(ChatFormatting.DARK_GREEN));
            }
        }
    }

    public int flightDuration() {
        return this.flightDuration;
    }

    static {
        STREAM_CODEC = StreamCodec.composite(ByteBufCodecs.VAR_INT, net.minecraft.world.item.component.Fireworks::flightDuration, FireworkExplosion.STREAM_CODEC.apply(ByteBufCodecs.list(256)), net.minecraft.world.item.component.Fireworks::explosions, net.minecraft.world.item.component.Fireworks::new);
    }
}
