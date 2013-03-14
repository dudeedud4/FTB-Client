package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet15Place;

import org.lwjgl.input.Mouse;

public class ReverseNuke extends Base {

	public ReverseNuke(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	private boolean mouseDown = false;
	
	public void onUpdate(EntityPlayer player)
	{
		if (Mouse.isButtonDown(1))
    	{
    		if (mouseDown)
    			return;
    		mouseDown = true;
    	}
    	else if (!Mouse.isButtonDown(1))
    	{
    		mouseDown = false;
    		return;
    	}
    	
    	ItemStack handID = mc.thePlayer.inventory.getCurrentItem();
    	if (handID == null)
    		return;
    	int r = 6;
    	int pX = (int)mc.thePlayer.posX;
    	int pY = (int)mc.thePlayer.posY-1;
    	int pZ = (int)mc.thePlayer.posZ;
    	for (int x = -r; x <=r; x++)
		{
    		for (int y = -r; y <=r; y++)
    		{
    			for (int z = -r; z <=r; z++)
    			{
    				int bID = getMinecraft().theWorld.getBlockId(pX + x, pY + y, pZ + z);
    				if (bID != 0)
    				{
    					int bx = pX + x;
    					int by = pY + y;
    					int bz = pZ + z;
    					if (getMinecraft().theWorld.getBlockId(bx, by+1, bz) == 0)
    			    	{
    						mc.thePlayer.sendQueue.addToSendQueue(
    								new Packet15Place(
    										bx,
    										by,
    										bz,
    										1,
    										mc.thePlayer.inventory.getCurrentItem(),
    										0,
    										0,
    										0));
    			    	}
    					
    					
    				}
    			}
    		}
		}
	}

}
