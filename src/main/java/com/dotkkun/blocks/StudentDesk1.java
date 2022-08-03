package com.dotkkun.blocks;

import com.dotkkun.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class StudentDesk1 extends BlockBase {
    public static final AxisAlignedBB STUDENT_DESK_WEST_AABB = new AxisAlignedBB(0,0,0.6D,1,1,1);
    public static final AxisAlignedBB STUDENT_DESK_EAST_AABB = new AxisAlignedBB(0,0,0,1,1,0.4D);
    public static final AxisAlignedBB STUDENT_DESK_NORTH_AABB = new AxisAlignedBB(0,0,0,0.4D,1,1);
    public static final AxisAlignedBB STUDENT_DESK_SOUTH_AABB = new AxisAlignedBB(0.6D,0,0,1,1,1);


    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public StudentDesk1(String name, Material material) {
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
                return STUDENT_DESK_WEST_AABB;
            case EAST:
                return STUDENT_DESK_EAST_AABB;
            case NORTH:
                return STUDENT_DESK_NORTH_AABB;
            case SOUTH:
            default:
                return STUDENT_DESK_SOUTH_AABB;
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
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack){
        BlockPos pos1;
        BlockPos pos2;
        switch(state.getValue(FACING)){
            case WEST:
                pos1 = pos.south();
                pos2 = pos1.south();
                break;
            case SOUTH:
                pos1 = pos.east();
                pos2 = pos1.east();
                break;
            case EAST:
                pos1 = pos.north();
                pos2 = pos1.north();
                break;
            case NORTH:
            default:
                pos1 = pos.west();
                pos2 = pos1.west();
                break;
        }
        if(placer instanceof EntityPlayer){
            worldIn.setBlockState(pos1, ModBlocks.STUDENT_DESK_2.getDefaultState().withProperty(FACING, placer.getAdjustedHorizontalFacing().getOpposite()));
            worldIn.setBlockState(pos2, ModBlocks.STUDENT_DESK_3.getDefaultState().withProperty(FACING, placer.getAdjustedHorizontalFacing().getOpposite()));
        }
    }

    @Override
    public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest){
        BlockPos pos1;
        BlockPos pos2;
        switch(state.getValue(FACING)){
            case WEST:
                pos1 = pos.south();
                pos2 = pos1.south();
                break;
            case SOUTH:
                pos1 = pos.east();
                pos2 = pos1.east();
                break;
            case EAST:
                pos1 = pos.north();
                pos2 = pos1.north();
                break;
            case NORTH:
            default:
                pos1 = pos.west();
                pos2 = pos1.west();
                break;
        }
        world.setBlockState(pos1, net.minecraft.init.Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
        world.setBlockState(pos2, net.minecraft.init.Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
        return world.setBlockState(pos, net.minecraft.init.Blocks.AIR.getDefaultState(), world.isRemote ? 11 : 3);
    }
}
