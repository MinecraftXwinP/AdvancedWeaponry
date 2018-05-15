package com.catcatlog.advancedweaponry.item;

import com.catcatlog.advancedweaponry.AdvancedWeaponry;
import com.catcatlog.advancedweaponry.block.AdvancedWeaponryBlocks;
import net.minecraft.item.ItemBlock;

public class PropelMine extends ItemBlock
{
	PropelMine()
	{
		super(AdvancedWeaponryBlocks.PropelMine);
		setUnlocalizedName(AdvancedWeaponry.MODID + ".propel_mine");
		setRegistryName(AdvancedWeaponry.MODID,"propel_mine");
	}
}
