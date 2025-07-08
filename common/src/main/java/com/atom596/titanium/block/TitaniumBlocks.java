package com.atom596.titanium.block;

import com.atom596.titanium.Titanium;
import com.atom596.titanium.regutils.RegistrationProvider;
import com.atom596.titanium.regutils.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class TitaniumBlocks {
    public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(BuiltInRegistries.BLOCK, Titanium.MOD_ID);

    public static final RegistryObject<Block, Block> TITANIUM_ORE = BLOCKS.register("titanium_ore", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, Block> DEEPSLATE_TITANIUM_ORE = BLOCKS.register("deepslate_titanium_ore", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, Block> END_TITANIUM_ORE = BLOCKS.register("end_titanium_ore", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, Block> RAW_TITANIUM_BLOCK = BLOCKS.register("raw_titanium_block", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, Block> TITANIUM_BLOCK = BLOCKS.register("titanium_block", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, TitaniumLanternBlock> TITANIUM_LANTERN = BLOCKS.register("titanium_lantern", TitaniumLanternBlock::new);
    public static final RegistryObject<Block, Block> TITANIUM_BRICKS = BLOCKS.register("titanium_bricks", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, SlabBlock> TITANIUM_BRICK_SLAB = BLOCKS.register("titanium_brick_slab", () -> new SlabBlock(Properties.of().strength(4.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, StairBlock> TITANIUM_BRICK_STAIRS = BLOCKS.register("titanium_brick_stairs", () -> new StairBlockHelper(TITANIUM_BRICKS.get().defaultBlockState(), Properties.of().strength(4.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, WallBlock> TITANIUM_BRICK_WALL = BLOCKS.register("titanium_brick_wall", () -> new WallBlock(Properties.of().strength(4.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block, Block> CHISELED_TITANIUM_BRICKS = BLOCKS.register("chiseled_titanium_bricks", () -> new Block(Properties.of().strength(4.0F).sound(SoundType.METAL).requiresCorrectToolForDrops()));

    public static void init() {}
}
