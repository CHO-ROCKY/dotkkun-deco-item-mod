package com.dotkkun.blocks;

import com.dotkkun.main.DotkkunDecoItemMod;
import com.dotkkun.util.IHasModel;
import net.minecraft.item.Item;

public abstract class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(DotkkunDecoItemMod.hogeolGoTab);
    }
}
