package com.dotkkun.blocks;

import com.dotkkun.init.ModBlocks;
import com.dotkkun.init.ModItems;
import com.dotkkun.main.DotkkunDecoItemMod;
import com.dotkkun.util.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public abstract class BlockBase extends Block implements IHasModel {
    public BlockBase(String name, Material material){
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);
        setHardness(5.0F);
        setCreativeTab(DotkkunDecoItemMod.hogeolGoTab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels(){
        DotkkunDecoItemMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
