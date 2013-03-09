package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;

public class Autoblock extends Base{

	public Autoblock(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		for(Object enemy : mc.theWorld.playerEntities){
			
			EntityPlayer enemyplayer = (EntityPlayer)enemy;
			
			if(mc.thePlayer.getDistanceToEntity(enemyplayer) <= 5 && !enemyplayer.isDead && enemyplayer.isSwingInProgress){
				mc.clickMouse(1);
			}
		}
	}

}
