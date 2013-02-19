package com.github.marcusanthf.ftb_client;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;
import cpw.mods.fml.common.FMLCommonHandler;

public class GameHooks {
    private static final GameHooks INSTANCE = new GameHooks();
    
	public static GameHooks instance() //Used to run in EntityPlayer
	{
	    return INSTANCE;
	}
	
	public void motionUpdate(){
		Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
		while(hacks.hasNext()){ //When there is a hack
			Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
			if(nexthack.getEnabled()){ //If it is enabled
				nexthack.motionUpdate(); //Run its onupdate
			}
		}
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
	
	public void clickBlock(int var1, int var2, int var3){ //Run these actions whenever the player clicks on a block
		Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
		while(hacks.hasNext()){ //When there is a hack
			Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
			if(nexthack.getEnabled()){ //If it is enabled
				nexthack.clickBlock(var1, var2, var3); //Run its onclick
			}
		}
	}
	
	public void renderEntities(Vec3 par1Vec3, ICamera par2ICamera, float par3){
		Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
		while(hacks.hasNext()){ //When there is a hack
			Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
			if(nexthack.getEnabled()){ //If it is enabled
				nexthack.renderEntities(par1Vec3, par2ICamera, par3); //Run its renderEntitities
			}
		}
	}

}
