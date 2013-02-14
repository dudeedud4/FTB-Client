package com.github.marcusanthf.ftb_client;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.FMLCommonHandler;

public class TickHandler {
    private static final TickHandler INSTANCE = new TickHandler();
    
	public static TickHandler instance() //Used to run in EntityPlayer
	{
	    return INSTANCE;
	}
	
	public void onTick(EntityPlayer player){ //Run these actions every tick in EntityPlayer
		Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
		while(hacks.hasNext()){ //When there is a hack
			Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
			if(nexthack.getEnabled()){ //If it is enabled
				nexthack.onUpdate(player); //Run its onupdate
			}
		}
	}
	
	public void afterTick(EntityPlayer player){ //Run these actions at the end of every tick in EntityPlayer
		Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
		while(hacks.hasNext()){ //When there is a hack
			Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
			if(nexthack.getEnabled()){ //If it is enabled
				nexthack.afterUpdate(player); //Run its onupdate
			}
		}
	}

}
