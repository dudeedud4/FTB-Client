package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet0KeepAlive;

public class FlyBypass extends Base {
	double savedposx, savedposy, savedposz;

	public FlyBypass(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		if(fly.getEnabled() && !freecam.getEnabled()){
			double d = player.posX - savedposx;
	  	    double d2 = player.posY - savedposy;
	  	    double d4 = player.posZ - savedposz;
	  	    double d6 = d * d + d2 * d2 + d4 * d4;
	  	    if(d6 <= 80D)
	  	    {
	  	  	    mc.getSendQueue().addToSendQueue(new Packet0KeepAlive());
	  	    return;
	  	    }
	  	    savedposx = player.posX;
	  	    savedposy = player.posY;
	  	    savedposz = player.posZ;
	  	  }
	}

}
