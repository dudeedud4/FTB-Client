package com.github.marcusanthf.ftb_client;

public class Blank extends Base {

	public Blank(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.equalsIgnoreCase(".blank")){
			mc.thePlayer.sendChatMessage("");
		}
	}

}
