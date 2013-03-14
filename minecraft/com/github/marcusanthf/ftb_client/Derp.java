package com.github.marcusanthf.ftb_client;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet18Animation;

public class Derp extends Base {

	private int mode;

	public Derp(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.equalsIgnoreCase(".derp")){
			this.mode = 1;
			this.toggleHack();
		}else if(par1Str.toLowerCase().startsWith(".derp ")){
			try{
				String as1[] = par1Str.split(" ");
				if(as1[1].equalsIgnoreCase("nohead")){
					this.mode = 2;
					this.toggleHack();
				}else if(as1[1] == "eat"){
		            mc.getSendQueue().addToSendQueue(new Packet18Animation(mc.thePlayer, 5));
				}
			}catch(Exception herp){
				mc.thePlayer.addChatMessage("\2474\247lError!");
			}
		}
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		if(this.mode == 2){ //noHead
			mc.getSendQueue().addToSendQueue(new Packet12PlayerLook(mc.thePlayer.rotationYaw-180, -180, mc.thePlayer.onGround));
		}else if(this.mode == 1){
			mc.getSendQueue().addToSendQueue(new Packet12PlayerLook((new Random()).nextFloat() * 360.0F, (new Random()).nextFloat() * 360.0F, mc.thePlayer.onGround));
            mc.getSendQueue().addToSendQueue(new Packet18Animation(mc.thePlayer, 1));
		}
	}

}
