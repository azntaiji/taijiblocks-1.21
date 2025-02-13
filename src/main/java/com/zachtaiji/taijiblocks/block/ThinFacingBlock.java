package com.zachtaiji.taijiblocks.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class ThinFacingBlock extends FacingBlock{
    private static final VoxelShape SHAPE = FacingBlock.createCuboidShape(0, 0, 0, 16, 16, 1);

    public ThinFacingBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
