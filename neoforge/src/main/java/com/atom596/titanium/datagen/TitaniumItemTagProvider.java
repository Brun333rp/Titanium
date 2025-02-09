package com.atom596.titanium.datagen;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.item.TitaniumItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class TitaniumItemTagProvider extends ItemTagsProvider {
    public TitaniumItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> completableFuture, @Nullable ExistingFileHelper exFileHelper) {
        super(output, lookupProvider, completableFuture, Titanium.MOD_ID, exFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.AXES)
                .add(TitaniumItems.TITANIUM_AXE.get());

        this.tag(ItemTags.HOES)
                .add(TitaniumItems.TITANIUM_HOE.get());

        this.tag(ItemTags.PICKAXES)
                .add(TitaniumItems.TITANIUM_PICKAXE.get());

        this.tag(ItemTags.SHOVELS)
                .add(TitaniumItems.TITANIUM_SHOVEL.get());

        this.tag(ItemTags.SWORDS)
                .add(TitaniumItems.TITANIUM_SWORD.get());
    }
}
