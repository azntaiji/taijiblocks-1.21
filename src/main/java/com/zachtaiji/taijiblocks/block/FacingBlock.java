package com.zachtaiji.taijiblocks.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.Direction;

// Ignore the following imports for now; they only apply to the getOutlineShape method.
// import net.minecraft.util.math.BlockPos;
// import net.minecraft.block.ShapeContext;
// import net.minecraft.util.shape.VoxelShape;
// import net.minecraft.util.shape.VoxelShapes;
// import net.minecraft.world.BlockView;

public class FacingBlock extends HorizontalFacingBlock{
	// the codec is required since 1.20.5 however not actually used in Minecraft yet.
	public static final MapCodec<FacingBlock> CODEC = Block.createCodec(FacingBlock::new);
 
	public FacingBlock(Settings settings) {
		super(settings);
		setDefaultState(getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
	}
 
	@Override
	protected MapCodec<? extends FacingBlock> getCodec() {
		return CODEC;
	}
 
	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		builder.add(Properties.HORIZONTAL_FACING);
	}
 
    // The following method is used to create a VoxelShape for the block. This is used to determine the shape of the block for collision detection. Include this method if you want to create a custom shape for your block, otherwise it is not necessary.
	// @Override
	// public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext ctx) {
	// 	Direction dir = state.get(FACING);
	// 	return switch (dir) {
	// 		case NORTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.5f);
	//		case SOUTH -> VoxelShapes.cuboid(0.0f, 0.0f, 0.5f, 1.0f, 1.0f, 1.0f);
	//		case EAST -> VoxelShapes.cuboid(0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f);
	//		case WEST -> VoxelShapes.cuboid(0.0f, 0.0f, 0.0f, 0.5f, 1.0f, 1.0f);
	//		default -> VoxelShapes.fullCube();
	//	};
	//}

        @Override
	public BlockState getPlacementState(ItemPlacementContext ctx) {
		return super.getPlacementState(ctx).with(Properties.HORIZONTAL_FACING, ctx.getHorizontalPlayerFacing().getOpposite());
	}
 
}