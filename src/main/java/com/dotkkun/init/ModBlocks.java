package com.dotkkun.init;

import com.dotkkun.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
    public static final List<Block> BLOCKS = new ArrayList<>();
    public static final Block BEVERAGE_REFRIGERATOR_1 = new BeverageRefrigerator1("beverage_refrigerator_1", Material.IRON);
    public static final Block BEVERAGE_REFRIGERATOR_2 = new BeverageRefrigerator2("beverage_refrigerator_2", Material.IRON);
    public static final Block BEVERAGE_REFRIGERATOR_3 = new BeverageRefrigerator3("beverage_refrigerator_3", Material.IRON);
    public static final Block VEGE_REFRESHER_1 = new VegeRefresher1("vege_refresher_1", Material.IRON);
    public static final Block VEGE_REFRESHER_2 = new VegeRefresher2("vege_refresher_2", Material.IRON);
    public static final Block VEGE_REFRESHER_3 = new VegeRefresher3("vege_refresher_3", Material.IRON);
    public static final Block VEGE_REFRESHER_4 = new VegeRefresher4("vege_refresher_4", Material.IRON);
    public static final Block WINDOW_MUNTIN = new WindowMuntin("muntin", Material.IRON);

}
