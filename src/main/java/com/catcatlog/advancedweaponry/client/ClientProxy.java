package com.catcatlog.advancedweaponry.client;

import com.catcatlog.advancedweaponry.AdvancedWeaponry;
import com.catcatlog.advancedweaponry.CommonProxy;
import com.catcatlog.advancedweaponry.item.AdvancedWeaponryItems;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ClientProxy extends CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
		enableModelLoader();
	}

	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}

	public static void enableModelLoader()
	{
		OBJLoader.INSTANCE.addDomain(AdvancedWeaponry.MODID);
	}

	@SubscribeEvent
	public void registerModels(ModelRegistryEvent event)
	{
		AdvancedWeaponryItems.initModels();
	}
}
