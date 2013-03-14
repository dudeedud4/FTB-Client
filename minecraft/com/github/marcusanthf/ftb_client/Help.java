package com.github.marcusanthf.ftb_client;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

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
			Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
			while(hacks.hasNext()){ //When there is a hack
				Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
				if(nexthack.getKey() != -1 && nexthack.getName() != null)
				mc.thePlayer.addChatMessage("\247b" + nexthack.getName() + "\247f - " + "\247b\247o" + Keyboard.getKeyName(nexthack.getKey()));
			}
		}
		if(par1Str.equalsIgnoreCase(".help cmd")){
			mc.thePlayer.addChatMessage("\247b\247l---------------------------------------------");
			Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
			while(hacks.hasNext()){ //When there is a hack
				Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
				if(nexthack.getCommand() != null && nexthack.getName() != null)
					mc.thePlayer.addChatMessage("\247b" + nexthack.getName() + "\247f - " + "\247b\247o." + nexthack.getCommand());
					mc.thePlayer.addChatMessage("\247b.move \247f toggles move, &247b.move &247l[speed] &247r&247fchanges the move speed");
					mc.thePlayer.addChatMessage("\247b.step \247f toggles step, &247b.step &247l[height] &247r&247fchanges the step height");
					mc.thePlayer.addChatMessage("\247b.insult");
					mc.thePlayer.addChatMessage("\247b.tp [x] [y] [z]");
					mc.thePlayer.addChatMessage("\247b.say message - Ex. .say .help");
					mc.thePlayer.addChatMessage("\247b.snuke - survival nuker, nukes the block you click");
					mc.thePlayer.addChatMessage("\247b.cnuke - nukes every nearby block");
					mc.thePlayer.addChatMessage("\247b.anni - breaks one-hit blocks");
					mc.thePlayer.addChatMessage("\247b.derp toggles derp");
					mc.thePlayer.addChatMessage("\247b.key set [hackname] [key]");
					
			}
			mc.thePlayer.addChatMessage("\247b\247l---------------------------------------------");
		}
	}
}
