package com.github.marcusanthf.ftb_client;

import java.util.Iterator;

public class Help extends Base {
	public Help(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.equalsIgnoreCase(".help")){
			mc.thePlayer.addChatMessage("\247b\247l---------------------------------------------");
			mc.thePlayer.addChatMessage("\247b.help keys" + "\247r\247f - " + "\247b\247oLists the current keybinds");
			mc.thePlayer.addChatMessage("\247b.help cmd" + "\247r\247f - " + "\247b\247oLists commands for hacks");
			mc.thePlayer.addChatMessage("\247b\247l---------------------------------------------");
		}
		if(par1Str.equalsIgnoreCase(".help keys")){
			//TODO create method to parse key int to an actual key and print it
		}
		if(par1Str.equalsIgnoreCase(".help cmd")){
			mc.thePlayer.addChatMessage("\247b\247l---------------------------------------------");
			Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
			while(hacks.hasNext()){ //When there is a hack
				Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
				if(nexthack.getCommand() != null && nexthack.getName() != null)
					mc.thePlayer.addChatMessage("\247b" + nexthack.getName() + "\247f - " + "\247b\247o." + nexthack.getCommand());
			}
			mc.thePlayer.addChatMessage("\247b\247l---------------------------------------------");
		}
	}
}
