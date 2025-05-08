package com.atom596.titanium.item.testingwand;

import com.atom596.titanium.Titanium;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

public class TestingWandItem extends Item {

    public TestingWandItem() {
        super(new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
        
        blocks.add(ResourceLocation.withDefaultNamespace("iron_ore"));
        blocks.add(ResourceLocation.withDefaultNamespace("deepslate_iron_ore"));
        blocks.add(ResourceLocation.withDefaultNamespace("diamond_ore"));
        blocks.add(ResourceLocation.withDefaultNamespace("deepslate_diamond_ore"));
        blocks.add(ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "titanium_ore"));
        blocks.add(ResourceLocation.fromNamespaceAndPath(Titanium.MOD_ID, "deepslate_titanium_ore"));
    }

    private final String descriptionId = "testing_wand.desc";
    public List<ResourceLocation> blocks = new ArrayList<>();

    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, List<Component> components, TooltipFlag flag) {
        components.add(Component.translatable("item.titanium.testing_wand.desc"));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player user, InteractionHand hand) {
        ItemStack itemStack = user.getItemInHand(hand);
        if (!level.isClientSide) {
            if (user.isCreative()) {
                user.getCooldowns().addCooldown(this, 10);
                if (user.isCrouching() || blocks.isEmpty()) {
                    user.openItemGui(this.getDefaultInstance(), hand);
                } else {
                    List<Integer> count = new ArrayList<>();
                    for (int i = 0; i < blocks.size(); i++) {
                        count.add(0);
                    }
                    ChunkPos pos = new ChunkPos(user.blockPosition());
                    for (int x = 16*pos.x; x < 16*(pos.x + 1); x++) {
                        for (int y = level.getMaxBuildHeight() - 1; y >= level.getMinBuildHeight(); y--) {
                            for (int z = 16*pos.z; z < 16*(pos.z + 1); z++) {
                                ResourceLocation block = BuiltInRegistries.BLOCK.getKey(level.getBlockState(new BlockPos(x, y, z)).getBlock());
                                if (!blocks.contains(block)) {
                                    level.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 255);
                                } else {
                                    count.set(blocks.indexOf(block),
                                            count.get(blocks.indexOf(block)) + 1);
                                }
                            }
                        }
                    }
                    user.sendSystemMessage(Component.literal("Summary of Blocks:"));
                    for (int i = 0; i < blocks.size(); i++) {
                        user.sendSystemMessage(Component.literal(count.get(i) + " blocks of " + blocks.get(i)));
                    }
                    user.sendSystemMessage(Component.literal(""));
                }
                return InteractionResultHolder.success(itemStack);
            }
            return InteractionResultHolder.pass(itemStack);
        }
        return InteractionResultHolder.pass(itemStack);
    }
}
