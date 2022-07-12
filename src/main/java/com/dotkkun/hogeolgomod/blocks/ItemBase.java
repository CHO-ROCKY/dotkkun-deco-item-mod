package com.dotkkun.hogeolgomod.blocks;

import com.dotkkun.hogeolgomod.main.HogeolGoMod;
import com.dotkkun.hogeolgomod.util.IHasModel;
import net.minecraft.item.Item;

public abstract class ItemBase extends Item implements IHasModel {
    public ItemBase(String name){
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(HogeolGoMod.hogeolGoTab);
    }
}
