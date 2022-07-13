package com.dotkkun.tabs;

import com.dotkkun.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class DotkkunDecoItemTab extends CreativeTabs {
    public DotkkunDecoItemTab(String label) { super(label); }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.BEVERAGE_REFRIGERATOR_1));
    }
}
