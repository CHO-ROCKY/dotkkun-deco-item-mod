package com.dotkkun.blocks;

import com.dotkkun.init.ModBlocks;
import com.dotkkun.main.DotkkunDecoItemMod;
import com.dotkkun.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public abstract class MultiBlockBase extends Block implements IHasModel {
    public MultiBlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(5.0F);
        setCreativeTab(DotkkunDecoItemMod.hogeolGoTab);

        ModBlocks.BLOCKS.add(this);
    }

    @Override
    public void registerModels(){
        DotkkunDecoItemMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}