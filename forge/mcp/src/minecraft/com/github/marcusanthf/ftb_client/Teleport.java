package com.github.marcusanthf.ftb_client;

import net.minecraft.network.packet.Packet11PlayerPosition;
import net.minecraft.network.packet.Packet13PlayerLookMove;

public class Teleport extends Base {

	public Teleport(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void commandToggle(String par1Str){
		   if(par1Str.equals(".crash"))
		   {
   		    for(int x = 0; x < 1000; x++)
   		    {
   		    	simplePos(mc.thePlayer.posX, mc.thePlayer.posY + 8, mc.thePlayer.posZ);
   		    }
   		    for(int x = 0; x < 1000; x++)
   		    {
   		    	simplePos(mc.thePlayer.posX, mc.thePlayer.posY, mc.thePlayer.posZ +8);
   		    }
   		    for(int x = 0; x < 1000; x++)
   		    {
   		    	simplePos(mc.thePlayer.posX + 8, mc.thePlayer.posY, mc.thePlayer.posZ);
   		    }
		   }
		   
		   if(par1Str.startsWith(".tp "))
           {
               String as19[] = par1Str.split(" ");
               try
               {
                   double d1 = new Double(as19[1]);
                   double d2 = new Double(as19[2]);
                   double d3 = new Double(as19[3]);
                   tp(d1, d2, d3);
               }
               catch(Exception exception30)
               {
                   mc.thePlayer.addChatMessage("\247cSyntax error! \247bUsage: \247f.tp \2470[\2476x y z\2470]");
               }
           }
	}
	
	public void simplePos(double d, double d1, double d2) {
    	mc.thePlayer.setPosition(d, d1, d2);
    	mc.getSendQueue().addToSendQueue(new Packet11PlayerPosition(mc.thePlayer.posX, mc.thePlayer.boundingBox.minY, mc.thePlayer.posY, mc.thePlayer.posZ, mc.thePlayer.onGround));
    }
	
	public void tp(double d1, double d2, double d3){
        double xdiff = mc.thePlayer.posX - d1;
        double ydiff = mc.thePlayer.posY - d2;
        double zdiff = mc.thePlayer.posZ - d3;
		    simplePos(mc.thePlayer.posX, 260D, mc.thePlayer.posZ);
	    do
	    {
	    	if(zdiff >= 0){
		    	simplePos(mc.thePlayer.posX, 260D, mc.thePlayer.posZ-8);
	    	}else{
	    		simplePos(mc.thePlayer.posX, 260D, mc.thePlayer.posZ+8);
	    	}
	    }while(!(mc.thePlayer.posZ>=(d3-8)) || !(mc.thePlayer.posZ <=(d3+8)));
	    do
	    {
	    	if(xdiff >= 0){
		    	simplePos(mc.thePlayer.posX-8, 260D, mc.thePlayer.posZ);
	    	}else{
	    		simplePos(mc.thePlayer.posX+8, 260D, mc.thePlayer.posZ);
	    	}
	    }while(!(mc.thePlayer.posX>=(d1-8)) || !(mc.thePlayer.posX<=(d1+8)));
	    move(d1, d2, d3);
        mc.thePlayer.addChatMessage((new StringBuilder()).append("\2472Teleported to: ").append(d1).append(" ").append(d2).append(" ").append(d3).append(" ").toString());
        mc.thePlayer.addChatMessage((new StringBuilder()).append("\2472Current position ").append(mc.thePlayer.posX).append(" ").append(mc.thePlayer.posY).append(" ").append(mc.thePlayer.posZ).append(" ").toString());
    }
	
	private void move(double d, double d1, double d2){
        double d3 = mc.thePlayer.posX;
        double d4 = mc.thePlayer.posY;
        double d5 = mc.thePlayer.posZ;
        double d6 = d - d3;
        double d7 = d1 - d4;
        double d8 = d2 - d5;
        double d9 = Math.sqrt(d6 * d6 + d7 * d7 + d8 * d8);
        if(d9 < 6D)
        {
            sendPos(d, d1, d2);
            return;
        }
        d9 /= 8D;
        d6 /= d9;
        d7 /= d9;
        d8 /= d9;
        int i = (int)Math.ceil(d9);
        for(int j = 0; j < i; j++)
        {
            d3 += d6;
            d4 += d7;
            d5 += d8;
            sendPos(d3, d4, d5);
        }
 
        sendPos(d, d1, d2);
    	mc.getSendQueue().addToSendQueue(new Packet11PlayerPosition(mc.thePlayer.posX, mc.thePlayer.boundingBox.minY, mc.thePlayer.posY, mc.thePlayer.posZ, mc.thePlayer.onGround));
	}
	
	private void sendPos(double d, double d1, double d2){
        for(int i = 0; i < 2; i++)
        {
            mc.thePlayer.setPosition(d, d1, d2);
            mc.getSendQueue().addToSendQueue(new Packet13PlayerLookMove(mc.thePlayer.posX, mc.thePlayer.boundingBox.minY, mc.thePlayer.posY, mc.thePlayer.posZ, mc.thePlayer.rotationYaw, mc.thePlayer.rotationPitch, true));
        }
 
        try
        {
            Thread.sleep(3L);
        }
        catch(Exception exception) { }
	}

}
