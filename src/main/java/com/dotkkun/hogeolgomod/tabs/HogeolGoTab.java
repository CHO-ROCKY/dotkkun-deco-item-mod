package com.dotkkun.hogeolgomod.tabs;

import com.dotkkun.hogeolgomod.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HogeolGoTab extends CreativeTabs {
    public HogeolGoTab(String label) { super(label); }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.BEVERAGE_REFRIGERATOR_1));
    }
}
