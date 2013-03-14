package com.github.marcusanthf.ftb_client;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.packet.Packet0KeepAlive;
import net.minecraft.network.packet.Packet10Flying;

public class FlyBypass extends Base {
	double savedposx, savedposy, savedposz;

	public FlyBypass(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}

}
