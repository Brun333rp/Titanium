package com.atom596.titanium.mixin;

import com.atom596.titanium.util.GeodeConfigInterface;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.GeodeBlockSettings;
import net.minecraft.world.level.levelgen.GeodeCrackSettings;
import net.minecraft.world.level.levelgen.GeodeLayerSettings;
import net.minecraft.world.level.levelgen.feature.configurations.GeodeConfiguration;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(GeodeConfiguration.class)
public class GeodeConfigMixin implements GeodeConfigInterface {
    @Unique
    private ResourceLocation barrelLootTable = null;

    @Override
    public void setBarrelLootTable(ResourceLocation lootTable) {
        this.barrelLootTable = lootTable;
    }

    @Override
    public ResourceLocation getBarrelLootTable() {
        return this.barrelLootTable;
    }

    @Inject(method = "<init>", at = @At("RETURN"))
    private void onInit(
            GeodeBlockSettings blockSettings,
            GeodeLayerSettings layerSettings,
            GeodeCrackSettings crackSettings,
            double usePotentialPlacementsChance,
            double useAlternateLayer0Chance,
            boolean placementsRequireLayer0Alternate,
            IntProvider outerWallDistance,
            IntProvider distributionPoints,
            IntProvider pointOffset,
            int maxDistributionPoints,
            int minPointOffset,
            double noiseMultiplier,
            int maxGenOffset,
            CallbackInfo ci
    ) {
        this.barrelLootTable = null;
    }

    @Shadow
    @Final
    @Mutable
    private static Codec<GeodeConfiguration> CODEC;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void modifyCodec(CallbackInfo ci) {
        Codec<Optional<ResourceLocation>> identifierCodec = ResourceLocation.CODEC.optionalFieldOf("barrelLootTable").codec();

        GeodeConfigMixin.CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(
                    GeodeBlockSettings.CODEC.fieldOf("blocks").forGetter(c -> c.geodeBlockSettings),
                    GeodeLayerSettings.CODEC.fieldOf("layers").forGetter(c -> c.geodeLayerSettings),
                    GeodeCrackSettings.CODEC.fieldOf("crack").forGetter(c -> c.geodeCrackSettings),
                    Codec.doubleRange(0.0, 1.0).fieldOf("use_potential_placements_chance").orElse(0.35).forGetter(c -> c.usePotentialPlacementsChance),
                    Codec.doubleRange(0.0, 1.0).fieldOf("use_alternate_layer0_chance").orElse(0.0).forGetter(c -> c.useAlternateLayer0Chance),
                    Codec.BOOL.fieldOf("placements_require_layer0_alternate").orElse(true).forGetter(c -> c.placementsRequireLayer0Alternate),
                    IntProvider.codec(1, 20).fieldOf("outer_wall_distance").orElse(UniformInt.of(4, 5)).forGetter(c -> c.outerWallDistance),
                    IntProvider.codec(1, 20).fieldOf("distribution_points").orElse(UniformInt.of(3, 4)).forGetter(c -> c.distributionPoints),
                    IntProvider.codec(0, 10).fieldOf("point_offset").orElse(UniformInt.of(1, 2)).forGetter(c -> c.pointOffset),
                    Codec.INT.fieldOf("min_gen_offset").orElse(-16).forGetter(c -> c.minGenOffset),
                    Codec.INT.fieldOf("max_gen_offset").orElse(16).forGetter(c -> c.maxGenOffset),
                    Codec.doubleRange(0.0, 1.0).fieldOf("noise_multiplier").orElse(0.05).forGetter(c -> c.noiseMultiplier),
                    Codec.INT.fieldOf("invalid_blocks_threshold").forGetter(c -> c.invalidBlocksThreshold),
                    ResourceLocation.CODEC.optionalFieldOf("barrel_loot_table").forGetter(c -> {
                        if (c instanceof GeodeConfigInterface ext) {
                            return Optional.ofNullable(ext.getBarrelLootTable());
                        }
                        return Optional.empty();
                    })
            ).apply(instance, (layerConfig, layerThicknessConfig, crackConfig, usePotentialPlacementsChance, useAlternateLayer0Chance, placementsRequireLayer0Alternate, outerWallDistance, distributionPoints, pointOffset, minGenOffset, maxGenOffset, noiseMultiplier, invalidBlocksThreshold, maybeLootTable) -> {
                GeodeConfiguration config = new GeodeConfiguration(
                        layerConfig,
                        layerThicknessConfig,
                        crackConfig,
                        usePotentialPlacementsChance,
                        useAlternateLayer0Chance,
                        placementsRequireLayer0Alternate,
                        outerWallDistance,
                        distributionPoints,
                        pointOffset,
                        minGenOffset,
                        maxGenOffset,
                        noiseMultiplier,
                        invalidBlocksThreshold
                );

                maybeLootTable.ifPresent(loot -> {
                    if (config instanceof GeodeConfigInterface ext) {
                        ext.setBarrelLootTable(loot);
                    }
                });

                return config;
            });
        });
    }
}
