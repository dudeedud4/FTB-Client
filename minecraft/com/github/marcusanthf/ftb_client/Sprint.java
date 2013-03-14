package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;

public class Sprint extends Base {
	
	int sprintDelay = 0;

	public Sprint(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		sprintDelay++;
		
		if(sprintDelay >= 602)
			sprintDelay = 0;
		
		if(sprintDelay < 600 && mc.thePlayer.movementInput.moveForward != 0 & !mc.thePlayer.isUsingItem())
			mc.thePlayer.setSprinting(true);
	}

}
