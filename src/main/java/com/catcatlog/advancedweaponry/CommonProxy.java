package com.catcatlog.advancedweaponry;

import com.catcatlog.advancedweaponry.block.AdvancedWeaponryBlocks;
import com.catcatlog.advancedweaponry.item.AdvancedWeaponryItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CommonProxy
{
	public void preInit(FMLPreInitializationEvent event) {}
	public void init(FMLInitializationEvent event) {}
	@SubscribeEvent
	public void registerBlocks(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().register(AdvancedWeaponryBlocks.PropelMine);
	}

	@SubscribeEvent
	public void registerItems(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(AdvancedWeaponryItems.PROPEL_MINE);
	}
}
