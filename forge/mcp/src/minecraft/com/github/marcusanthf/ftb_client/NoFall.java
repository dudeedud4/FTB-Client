package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet10Flying;

public class NoFall extends Base {
	public static boolean toggle;
	public NoFall(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void onEnable(){
		toggle = true;
	}
	
	@Override
	public void onDisable(){
		toggle = false;
	}
	
	//See: Packet10Flying
}
