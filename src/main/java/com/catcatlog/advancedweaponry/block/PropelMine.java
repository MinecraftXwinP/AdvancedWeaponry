package com.catcatlog.advancedweaponry.block;

import com.catcatlog.advancedweaponry.AdvancedWeaponry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class PropelMine extends Block
{
	public static final double RADIUS = 4;
	public static final double PROPEL_FORCE = 16;
	public PropelMine()
	{
		super(Material.ANVIL);
		setUnlocalizedName(AdvancedWeaponry.MODID +".propel_mine");
		setRegistryName(AdvancedWeaponry.MODID,"propel_mine");
		translucent = true;

	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Nullable
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return super.getCollisionBoundingBox(blockState, worldIn, pos);
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		super.onEntityWalk(worldIn, pos, entityIn);
		propel(worldIn,pos);
	}

	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		propel(worldIn,pos);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return new AxisAlignedBB(0,0,0,1,0.3,1);
	}

	@Override
	public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
	{
		return true;
	}

	private void propel(World world, BlockPos pos)
	{
		Explosion explosion = world.createExplosion(null,pos.getX(),pos.getY(),pos.getZ(),10,false);
		onBlockExploded(world,pos,explosion);
		for(Entity e : world.loadedEntityList)
		{
			final Vec3d entityPos = e.getPositionVector();
			final Vec3d minePos = new Vec3d(pos.getX(),pos.getY(),pos.getZ());
			final double distance = minePos.distanceTo(entityPos);
			if (distance < RADIUS) {
				final Vec3d motion = minePos.subtract(entityPos).normalize().rotatePitch(45);
				e.motionX = motion.x * PROPEL_FORCE;
				e.motionY = motion.y * PROPEL_FORCE;
				e.motionZ = motion.z * PROPEL_FORCE;
			}
		}
	}

	@Override
	public boolean isCollidable()
	{
		return super.isCollidable();
	}
}
