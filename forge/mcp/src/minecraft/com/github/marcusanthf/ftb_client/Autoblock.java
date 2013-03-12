package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;

public class Autoblock extends Base{

	public Autoblock(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		if(mc.thePlayer.inventory.getCurrentItem() != null){
		if(mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemSword){
			for(Object enemy : mc.theWorld.playerEntities){
				
				EntityPlayer enemyplayer = (EntityPlayer)enemy;
				
				if(mc.thePlayer.getDistanceToEntity(enemyplayer) <= 5 && !enemyplayer.isDead && enemyplayer.isSwingInProgress && enemyplayer != mc.thePlayer){
					mc.clickMouse(1);
				}
			}
		}
		}
	}

}
