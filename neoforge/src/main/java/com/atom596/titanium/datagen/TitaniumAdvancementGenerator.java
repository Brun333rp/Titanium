package com.atom596.titanium.datagen;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.item.TitaniumItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.function.Consumer;

public class TitaniumAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
    @Override
    public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer, ExistingFileHelper existingFileHelper) {
        AdvancementHolder getTitaniumAdvancement = Advancement.Builder.advancement()
                .display(
                        new ItemStack(TitaniumItems.TITANIUM_INGOT.get()),
                        Component.translatable("advancements.titanium.get_titanium.title"),
                        Component.translatable("advancements.titanium.get_titanium.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .parent(new AdvancementHolder(
                        ResourceLocation.fromNamespaceAndPath("minecraft", "story/iron_tools"), null
                ))
                .addCriterion("got_titanium",
                        InventoryChangeTrigger.TriggerInstance.hasItems(TitaniumItems.TITANIUM_INGOT.get())
                )
                .requirements(AdvancementRequirements.allOf(List.of("got_titanium")))
                .save(consumer,
                        ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "get_titanium"), existingFileHelper
                );

        AdvancementHolder titaniumToolsAdvancement = Advancement.Builder.advancement()
                .display(
                        new ItemStack(TitaniumItems.TITANIUM_PICKAXE.get()),
                        Component.translatable("advancements.titanium.titanium_tools.title"),
                        Component.translatable("advancements.titanium.titanium_tools.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .parent(getTitaniumAdvancement)
                .addCriterion("get_titanium_pickaxe",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_PICKAXE.get()
                        )
                )
                .addCriterion("get_titanium_shovel",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_SHOVEL.get()
                        )
                )
                .addCriterion("get_titanium_axe",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_AXE.get()
                        )
                )
                .addCriterion("get_titanium_hoe",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_HOE.get()
                        )
                )
                .requirements(AdvancementRequirements.allOf(List.of(
                        "get_titanium_pickaxe",
                        "get_titanium_shovel",
                        "get_titanium_axe",
                        "get_titanium_hoe"
                )))
                .save(consumer,
                        ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "titanium_tools"), existingFileHelper
                );

        AdvancementHolder titaniumArmorAdvancement = Advancement.Builder.advancement()
                .display(
                        new ItemStack(TitaniumItems.TITANIUM_CHESTPLATE.get()),
                        Component.translatable("advancements.titanium.titanium_armor.title"),
                        Component.translatable("advancements.titanium.titanium_armor.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .parent(getTitaniumAdvancement)
                .addCriterion("get_titanium_helmet",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_HELMET.get()
                        )
                )
                .addCriterion("get_titanium_chestplate",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_CHESTPLATE.get()
                        )
                )
                .addCriterion("get_titanium_leggings",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_LEGGINGS.get()
                        )
                )
                .addCriterion("get_titanium_boots",
                        InventoryChangeTrigger.TriggerInstance.hasItems(
                                TitaniumItems.TITANIUM_BOOTS.get()
                        )
                )
                .requirements(AdvancementRequirements.allOf(List.of(
                        "get_titanium_helmet",
                        "get_titanium_chestplate",
                        "get_titanium_leggings",
                        "get_titanium_boots"
                )))
                .save(consumer,
                        ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "titanium_armor"), existingFileHelper
                );

        AdvancementHolder flightChargeAdvancement = Advancement.Builder.advancement()
                .display(
                        new ItemStack(TitaniumItems.FLIGHT_CHARGE.get()),
                        Component.translatable("advancements.titanium.flight_charge.title"),
                        Component.translatable("advancements.titanium.flight_charge.description"),
                        null,
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .parent(new AdvancementHolder(
                        ResourceLocation.withDefaultNamespace("adventure/who_needs_rockets"), null
                ))
                .addCriterion("get_flight_charge",
                        InventoryChangeTrigger.TriggerInstance.hasItems(TitaniumItems.FLIGHT_CHARGE.get())
                )
                .requirements(AdvancementRequirements.allOf(List.of("get_flight_charge")))
                .save(consumer,
                        ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "flight_charge"), existingFileHelper
                );
    }
}
