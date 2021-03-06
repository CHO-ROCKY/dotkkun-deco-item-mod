package com.dotkkun.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class LectureDesk3 extends MultiBlockBase{
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public static final AxisAlignedBB LECTURE_DESK_WEST_AABB = new AxisAlignedBB(0,0,0,1,1,0.4D);
    public static final AxisAlignedBB LECTURE_DESK_EAST_AABB = new AxisAlignedBB(0,0,0.6D,1,1,1);
    public static final AxisAlignedBB LECTURE_DESK_NORTH_AABB = new AxisAlignedBB(0.6D,0,0,1,1,1);
    public static final AxisAlignedBB LECTURE_DESK_SOUTH_AABB = new AxisAlignedBB(0,0,0,0.4D,1,1);

    public LectureDesk3(String name, Material material) {
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
                return LECTURE_DESK_EAST_AABB;
            case EAST:
                return LECTURE_DESK_WEST_AABB;
            case NORTH:
                return LECTURE_DESK_SOUTH_AABB;
            case SOUTH:
            default:
                return LECTURE_DESK_NORTH_AABB;
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

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest){
        BlockPos pos1;
        BlockPos pos2;
        switch(state.getValue(FACING)){
            case SOUTH:
                pos1 = pos.east();
                pos2 = pos1.east();
                break;
            case WEST:
                pos1 = pos.south();
                pos2 = pos1.south();
                break;
            case NORTH:
                pos1 = pos.west();
                pos2 = pos1.west();
                break;
            case EAST:
            default:
                pos1 = pos.north();
                pos2 = pos1.north();
                break;
        }

        world.setBlockState(pos1, net.minecraft.init.Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
        world.setBlockState(pos2, net.minecraft.init.Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
        return world.setBlockState(pos, net.minecraft.init.Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
    }

}
