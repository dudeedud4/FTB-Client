package com.github.marcusanthf.ftb_client;

import net.minecraft.network.packet.Packet19EntityAction;

public class Sneak extends Base {

	public Sneak(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable(){
		this.sneak();
	}
	
	public void sneak(){
		mc.getSendQueue().addToSendQueue(new Packet19EntityAction(mc.thePlayer, 1));
	}

}
