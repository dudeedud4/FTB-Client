package com.github.marcusanthf.ftb_client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Xray extends Base{
	
	public static CopyOnWriteArrayList<Integer> xrayBlocks = new CopyOnWriteArrayList<Integer>();
	public Iterator xray = xrayBlocks.iterator();

	public Xray(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.toLowerCase().startsWith(".xadd")){
			try{
			String as1[] = par1Str.split(" ");
			int xblock = Integer.parseInt(as1[1]);
			xrayBlocks.add(xblock);
			if(getEnabled()){
				mc.renderGlobal.loadRenderers();
			}
			}catch(Exception e){
				mc.thePlayer.addChatMessage("\2474\247lError! \247r\2474Invalid input.");
			}
		}
		if(par1Str.toLowerCase().startsWith(".xclear")){
			try{
			if(xrayBlocks.size() > 0){
				xrayBlocks.clear();
				if(getEnabled()){
					mc.renderGlobal.loadRenderers();
				}
			}else{
				mc.thePlayer.addChatMessage("\2474\247lError! \247r\2474Xray is empty.");
			}
			}catch(Exception e){
				mc.thePlayer.addChatMessage("\2474\247lError! \247r\2474Invalid input.");
		}
		}
		if(par1Str.toLowerCase().startsWith(".xdel")){
			try{
			String as1[] = par1Str.split(" ");
			if(!xrayBlocks.isEmpty()){
				int xblock = Integer.parseInt(as1[1]);
				for (int i=0; i< xrayBlocks.size(); i++) {
					int val1 = xrayBlocks.get(i); 
					if (val1 == xblock) {
					   xrayBlocks.remove(i);
					   if(getEnabled()){
							mc.renderGlobal.loadRenderers();
					   }
					   break;
					 }
				}
			}else{
				mc.thePlayer.addChatMessage("\2474\247lError! \247r\2474Xray is empty.");
			}
			}catch(Exception e){
				mc.thePlayer.addChatMessage("\2474\247lError! \247r\2474Invalid input.");
			}
		}
	}
	
	@Override
	public void onEnable(){
		mc.gameSettings.gammaSetting = 100F;
		mc.renderGlobal.loadRenderers();
	}
	
	@Override
	public void onDisable(){
		if(!Base.fullbright.getEnabled()){
		mc.gameSettings.gammaSetting = 1F;
		}
		mc.renderGlobal.loadRenderers();
	}

}
