package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;

public class Step extends Base {

	private float height = 1f;

	public Step(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		mc.thePlayer.stepHeight = this.height;
	}
	
	@Override
	public void onDisable(){
		mc.thePlayer.stepHeight = 0.5f;
	}
	
	@Override
	public void commandToggle(String par1Str)
	{
		if(par1Str.startsWith(".step")){
			try{
				String as1[] = par1Str.split(" ");
				if(as1[1] != null){
				height = Float.parseFloat(as1[1]);
				mc.thePlayer.addChatMessage("\247bStep height set. Make sure to toggle with .step");
				}else{
					this.toggleHack();
					mc.thePlayer.addChatMessage("\247bStep toggled. Change height with .step [height].");
				}
			}catch(Exception stepException){
				toggleHack();
				mc.thePlayer.addChatMessage("\247bStep toggled. Change height with .step [height].");
			}
		}
	}

}
