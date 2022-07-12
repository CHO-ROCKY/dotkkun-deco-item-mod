package com.dotkkun.hogeolgomod.blocks;

import com.dotkkun.hogeolgomod.init.ModBlocks;
import com.dotkkun.hogeolgomod.init.ModItems;
import com.dotkkun.hogeolgomod.main.HogeolGoMod;
import com.dotkkun.hogeolgomod.util.IHasModel;
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
        setCreativeTab(HogeolGoMod.hogeolGoTab);

        ModBlocks.BLOCKS.add(this);
        ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels(){
        HogeolGoMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }

}
