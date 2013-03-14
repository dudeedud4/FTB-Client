package com.github.marcusanthf.ftb_client;

public class GodMode extends Base {

	public GodMode(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}

	@Override
    public void onEnable()
    {
		mc.thePlayer.isDead = true;
    }
	
	@Override
	public void onDisable(){
		mc.thePlayer.isDead = false;
	}

}
