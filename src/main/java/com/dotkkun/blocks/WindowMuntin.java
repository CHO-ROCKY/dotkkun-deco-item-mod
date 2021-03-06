package com.dotkkun.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class WindowMuntin extends BlockBase {
    public static final AxisAlignedBB WINDOW_MUNTIN_WEST_AABB = new AxisAlignedBB(0,0,0,0.1D,1,1);
    public static final AxisAlignedBB WINDOW_MUNTIN_EAST_AABB = new AxisAlignedBB(0.9D,0,0,1,1,1);
    public static final AxisAlignedBB WINDOW_MUNTIN_NORTH_AABB = new AxisAlignedBB(0,0,0,1,1,0.1D);
    public static final AxisAlignedBB WINDOW_MUNTIN_SOUTH_AABB = new AxisAlignedBB(0,0,0.9D,1,1,1);
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public WindowMuntin(String name, Material material) {
        super(name, material);
        setHardness(2.0f);
        setHarvestLevel("axe", -1);
        setResistance(18.0f);
        setSoundType(SoundType.STONE);
        setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.SOUTH));
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos){
        switch(state.getValue(FACING)){
            case WEST:
                return WINDOW_MUNTIN_WEST_AABB;
            case EAST:
                return WINDOW_MUNTIN_EAST_AABB;
            case NORTH:
                return WINDOW_MUNTIN_NORTH_AABB;
            case SOUTH:
            default:
                return WINDOW_MUNTIN_SOUTH_AABB;
        }

    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        IBlockState iblockstate = this.getDefaultState();

        switch (meta)
        {
            case 1:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.EAST);
                break;
            case 2:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.WEST);
                break;
            case 3:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.SOUTH);
                break;
            case 4:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
                break;
            default:
                iblockstate = iblockstate.withProperty(FACING, EnumFacing.NORTH);
        }

        return iblockstate;
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        int i = 0;

        switch ((EnumFacing)state.getValue(FACING))
        {
            case EAST:
                i = i | 1;
                break;
            case WEST:
                i = i | 2;
                break;
            case SOUTH:
                i = i | 3;
                break;
            case NORTH:
                i = i | 4;
                break;
            default:
                i = i | 4;
        }

        return i;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @Override
    public boolean isFullCube(IBlockState state){
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state){
        return false;
    }

    @Override
    public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
        return this.getDefaultState().withProperty(FACING, placer.getAdjustedHorizontalFacing().getOpposite());
    }
}

