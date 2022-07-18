package com.dotkkun.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.util.EnumFacing;

public class WindowMuntin extends BlockBase {
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

    public WindowMuntin(String name, Material material) {
        super(name, material);
        setHardness(2.0f);
        setHarvestLevel("axe", -1);
        setResistance(18.0f);
        setSoundType(SoundType.STONE);
        setDefaultState(this.getBlockState().getBaseState().withProperty(FACING, EnumFacing.SOUTH));
    }
}
