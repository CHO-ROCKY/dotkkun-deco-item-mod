package com.dotkkun.hogeolgomod.main;

import com.dotkkun.hogeolgomod.proxy.CommonProxy;
import com.dotkkun.hogeolgomod.tabs.HogeolGoTab;
import com.dotkkun.hogeolgomod.util.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class HogeolGoMod {
    private static Logger logger;

    public static final CreativeTabs hogeolGoTab = new HogeolGoTab("hogeol-go");

    @Mod.Instance
    public static HogeolGoMod instance;

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    }
}
