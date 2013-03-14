package com.github.marcusanthf.ftb_client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;

public class FastBow extends Base {

	public FastBow(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
        Thread fastbowthread = new Thread(new FastBowThread(this), "FastBow Thread");
        fastbowthread.start();
	}

}
