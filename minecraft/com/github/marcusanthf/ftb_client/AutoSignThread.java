package com.github.marcusanthf.ftb_client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.network.packet.Packet130UpdateSign;

public class AutoSignThread implements Runnable {
	
	Minecraft mc = Base.getMinecraft();
	
	int signDelay = 0;
	
	public AutoSign autosign;
	
	public AutoSignThread(AutoSign var1)
    {
        this.autosign = var1;
    }
	
	public void run(){
		this.autoSign();
			try{
				Thread.sleep(57L);
			}catch (InterruptedException var2){
				var2.printStackTrace();
			}
	   }
	
	public void autoSign(){
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
							mc.getSendQueue().addToSendQueue(new Packet130UpdateSign(k1, l1, i2, autosign.sign));
							signDelay = 0;
						}
					}
				}
			}
		}
	}

}
