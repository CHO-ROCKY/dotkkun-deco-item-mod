package com.dotkkun.hogeolgomod.blocks;

import com.dotkkun.hogeolgomod.init.ModBlocks;
import com.dotkkun.hogeolgomod.main.HogeolGoMod;
import com.dotkkun.hogeolgomod.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public abstract class MultiBlockBase extends Block implements IHasModel {
    public MultiBlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(5.0F);
        setCreativeTab(HogeolGoMod.hogeolGoTab);

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels(){
        HogeolGoMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}