package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;

public class MoveSpeed extends Base {
	private float speed = 1.0f;
	
	public MoveSpeed(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onUpdate(EntityPlayer player){
		if(!Base.fly.getEnabled())
		{
			player.landMovementFactor = this.speed;
			player.jumpMovementFactor = this.speed;
		}
	}
	
	@Override
	public void commandToggle(String par1Str)
	{
		if(par1Str.startsWith(".move")){
			try{
				String as1[] = par1Str.split(" ");
				if(as1[1] != null){
				this.speed = Float.parseFloat(as1[1]);
				mc.thePlayer.addChatMessage("\247bMoveSpeed set. Make sure to toggle with .move");
				}else{
					this.toggleHack();
					mc.thePlayer.addChatMessage("\247bMoveSpeed toggled. Change height with .move [speed].");
				}
			}catch(Exception stepException){
				toggleHack();
				mc.thePlayer.addChatMessage("\247bMoveSpeed toggled. Change height with .move [speed].");
			}
		}
	}
}
