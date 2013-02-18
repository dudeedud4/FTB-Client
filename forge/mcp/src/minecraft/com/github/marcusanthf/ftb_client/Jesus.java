package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;

public class Jesus extends Base {

	public Jesus(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override 
	public void onUpdate(EntityPlayer player){
		if(mc.thePlayer.handleWaterMovement())
		{
			mc.thePlayer.jump();
		}
	}

}
