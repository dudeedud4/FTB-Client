package com.github.marcusanthf.ftb_client;

public class Fullbright extends Base {

	public Fullbright(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable(){
		mc.gameSettings.gammaSetting = 100F;
		mc.renderGlobal.loadRenderers();
	}
	
	@Override
	public void onDisable(){
		mc.gameSettings.gammaSetting = 1F;
		mc.renderGlobal.loadRenderers();
	}

}
