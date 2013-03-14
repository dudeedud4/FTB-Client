package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet18Animation;
import net.minecraft.network.packet.Packet7UseEntity;

public class Emo extends Base {

	public Emo(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		mc.getSendQueue().addToSendQueue(new Packet18Animation(mc.thePlayer, 1));
		mc.getSendQueue().addToSendQueue(new Packet7UseEntity(mc.thePlayer.entityId, mc.thePlayer.entityId, 1));
		mc.playerController.attackEntity(mc.thePlayer, mc.thePlayer);
	}

}
