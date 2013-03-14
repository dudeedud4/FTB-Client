package com.github.marcusanthf.ftb_client;

import java.util.Iterator;

import net.minecraft.client.gui.GuiPlayerInfo;
import net.minecraft.network.packet.Packet3Chat;
import net.minecraft.util.StringUtils;

public class OpAbuse extends Base {

	public OpAbuse(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void commandToggle(String par1Str)
	{
		if(par1Str.toLowerCase().equals(".gm"))
		{
			if(!mc.thePlayer.capabilities.isCreativeMode)
			{
				mc.getSendQueue().addToSendQueue(new Packet3Chat("/gamemode 1 " + mc.thePlayer.username));
			}else{
				mc.getSendQueue().addToSendQueue(new Packet3Chat("/gamemode 0 " + mc.thePlayer.username));
			}
		}
		if(par1Str.toLowerCase().equals(".chunk"))
		{
			mc.getSendQueue().addToSendQueue(new Packet3Chat("//chunk"));
			mc.getSendQueue().addToSendQueue(new Packet3Chat("//set 00"));
		}
		if(par1Str.toLowerCase().equals(".ugly"))
		{
			mc.getSendQueue().addToSendQueue(new Packet3Chat("//replace 19,87,29,11,101,49"));
		}
		if(par1Str.toLowerCase().equals(".tpall"))
		{
			Iterator var1 = mc.getSendQueue().playerInfoList.iterator();

	        while (var1.hasNext())
	        {
	            GuiPlayerInfo var2 = (GuiPlayerInfo)var1.next();
	            String var3 = StringUtils.stripControlCodes(var2.name);
	            if (!var3.equalsIgnoreCase(mc.thePlayer.username))
	            {
	    			mc.getSendQueue().addToSendQueue(new Packet3Chat("/tp " + var3 + " " + mc.thePlayer.username));
	            }
	        }
		}
		if(par1Str.toLowerCase().equals(".opall"))
		{
			Iterator var1 = mc.getSendQueue().playerInfoList.iterator();

	        while (var1.hasNext())
	        {
	            GuiPlayerInfo var2 = (GuiPlayerInfo)var1.next();
	            String var3 = StringUtils.stripControlCodes(var2.name);
	            if (!var3.equalsIgnoreCase(mc.thePlayer.username))
	            {
	    			mc.getSendQueue().addToSendQueue(new Packet3Chat("/op " + var3));
	            }
	        }
		}
		if(par1Str.toLowerCase().equals(".banall"))
		{
			Iterator var1 = mc.getSendQueue().playerInfoList.iterator();

	        while (var1.hasNext())
	        {
	            GuiPlayerInfo var2 = (GuiPlayerInfo)var1.next();
	            String var3 = StringUtils.stripControlCodes(var2.name);
	            if (!var3.equalsIgnoreCase(mc.thePlayer.username))
	            {
	    			mc.getSendQueue().addToSendQueue(new Packet3Chat("/ban " + var3));
	            }
	        }
		}
		if(par1Str.toLowerCase().equals(".kickall"))
		{
			Iterator var1 = mc.getSendQueue().playerInfoList.iterator();

	        while (var1.hasNext())
	        {
	            GuiPlayerInfo var2 = (GuiPlayerInfo)var1.next();
	            String var3 = StringUtils.stripControlCodes(var2.name);
	            if (!var3.equalsIgnoreCase(mc.thePlayer.username))
	            {
	    			mc.getSendQueue().addToSendQueue(new Packet3Chat("/home " + var3));
	            }
	        }
		}
		if(par1Str.toLowerCase().equals(".clearall"))
		{
			Iterator var1 = mc.getSendQueue().playerInfoList.iterator();

	        while (var1.hasNext())
	        {
	            GuiPlayerInfo var2 = (GuiPlayerInfo)var1.next();
	            String var3 = StringUtils.stripControlCodes(var2.name);
	            if (!var3.equalsIgnoreCase(mc.thePlayer.username))
	            {
	    			mc.getSendQueue().addToSendQueue(new Packet3Chat("/clear " + var3));
	            }
	        }
		}
	}

}
