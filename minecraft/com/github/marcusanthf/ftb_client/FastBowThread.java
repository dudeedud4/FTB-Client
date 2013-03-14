package com.github.marcusanthf.ftb_client;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemBow;
import net.minecraft.network.packet.Packet12PlayerLook;
import net.minecraft.network.packet.Packet14BlockDig;
import net.minecraft.network.packet.Packet15Place;

public class FastBowThread implements Runnable{
	
	protected static Minecraft mc = Base.getMinecraft();
	
	public FastBow fastbow;
	
    public FastBowThread(FastBow var1)
    {
        this.fastbow = var1;
    }
	
	public void run(){
		this.fastbow();
			try{
				Thread.sleep(57L);
			}catch (InterruptedException var2){
				var2.printStackTrace();
			}
	   }
	 
	 public void fastbow(){
			if (mc.thePlayer.isUsingItem())
			{
				if (mc.thePlayer.inventory.getCurrentItem().getItem() instanceof ItemBow)
				{
					if (mc.thePlayer.onGround)
					{
						try
						{
							mc.getSendQueue().addToSendQueue(new Packet15Place(-1, -1, -1, 255, mc.thePlayer.inventory.getCurrentItem(),1 , 1, 1));
							Thread.sleep(15L);
							for (int i = 0; i < 25; i++)
							{
								Thread.sleep(5L);
								mc.getSendQueue().addToSendQueue(new Packet12PlayerLook(mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch, mc.thePlayer.onGround));
							}
							mc.getSendQueue().addToSendQueue(new Packet14BlockDig(5, 0, 0, 0, 255));
						}
						catch (Exception exception) { }
					}
				}
			}
	 }
}
