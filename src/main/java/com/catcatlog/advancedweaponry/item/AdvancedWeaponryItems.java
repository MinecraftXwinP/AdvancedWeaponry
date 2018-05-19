package com.catcatlog.advancedweaponry.item;

import com.catcatlog.advancedweaponry.AdvancedWeaponry;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;

public class AdvancedWeaponryItems
{
	public final static ItemBlock PROPEL_MINE = new PropelMine();

	public static void initModels()
	{
		ModelLoader.setCustomModelResourceLocation(PROPEL_MINE,0,new ModelResourceLocation(AdvancedWeaponry.MODID + ":propel_mine", "inventory"));
	}
}
