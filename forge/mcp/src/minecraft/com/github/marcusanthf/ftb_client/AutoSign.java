package com.github.marcusanthf.ftb_client;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.packet.Packet130UpdateSign;

public class AutoSign extends Base {
	
	int signDelay = 0;
	
	public static String sign1 = "You just got";
	public static String sign2 = "fucked by";
	public static String sign3 = "Team YOLO";
	public static String sign4 = "<3 XOXOXO <3";
	
	public String[] sign = {sign1,sign2,sign3,sign4};

	public AutoSign(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void motionUpdate(){
		signDelay++;
		byte byte0 = 50;
		if(signDelay >= 15)
		{
			for(int k = byte0; k > -byte0; k--)
			{
				for(int i1 = byte0; i1 > -byte0; i1--)
				{
					for(int j1 = byte0; j1 > -byte0; j1--)
					{
						double d1 = mc.thePlayer.posX + (double)k;
						double d3 = mc.thePlayer.posY + (double)i1;
						double d5 = mc.thePlayer.posZ + (double)j1;
						int k1 = (int)d1;
						int l1 = (int)d3;
						int i2 = (int)d5;
						if(mc.theWorld.getBlockId(k1,  l1,  i2) == Block.signPost.blockID || mc.theWorld.getBlockId(k1,  l1,  i2) == Block.signWall.blockID)
						{
							mc.getSendQueue().addToSendQueue(new Packet130UpdateSign(k1, l1, i2, sign));
							signDelay = 0;
						}
					}
				}
			}
		}
	}
	
}
