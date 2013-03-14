package com.github.marcusanthf.ftb_client;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet10Flying;

public class NoFall extends Base {
	public boolean oldGround;
	
	public NoFall(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void motionUpdate(EntityClientPlayerMP playermp){
		this.oldGround = playermp.onGround;
		playermp.onGround = false;
		playermp.isJumping = true;
	}
	
}
