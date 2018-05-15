package com.catcatlog.advancedweaponry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=AdvancedWeaponry.MODID,name=AdvancedWeaponry.NAME,version = AdvancedWeaponry.VERSION)
public class AdvancedWeaponry
{
	public final static String MODID = "advancedweaponry";
	public final static String NAME = "Advanced Weaponry";
	public final static String VERSION = "0.0.0";

	@SidedProxy(serverSide = "com.catcatlog.advancedweaponry.CommonProxy",clientSide = "com.catcatlog.advancedweaponry.client.ClientProxy")
	public static CommonProxy proxy;


	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(proxy);
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{

	}
}
