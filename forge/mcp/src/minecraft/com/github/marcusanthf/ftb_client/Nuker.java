package com.github.marcusanthf.ftb_client;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;

public class Nuker extends Base {
    public Nuker(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}

    public int clicknukeid = 1;
	public int mode = 1;
	public String modename = "survival";
    public ArrayList nuke = new ArrayList();
    
    @Override
    public void clickBlock(int var1, int var2, int var3){
        if(mode == 1 && modename == "survival"){
    	this.nuke.clear();
    	clicknukeid = mc.thePlayer.worldObj.getBlockId(var1, var2, var3);
    	if(clicknukeid == 3){
    		nuke.clear();
    		nuke.add(2);
    	}else{
    		if(clicknukeid == 2){
    			nuke.clear();
    			nuke.add(3);
    		}
    	}
    	nuke.add(clicknukeid);
    	mc.thePlayer.addChatMessage("Nuker set to: " + Integer.toString(clicknukeid) + " (" + GetBlockName.blockIDToName(clicknukeid) + ")");
        }
    }
    
    @Override
    public void onUpdate(EntityPlayer player){
        Thread var21 = new Thread(new NukerThread(this), "Nuker Thread");
        var21.start();
    }
    
    @Override
    public void commandToggle(String par1Str){
    	if(par1Str.toLowerCase().endsWith("nuke") || par1Str.toLowerCase().endsWith("nuker") || par1Str.equalsIgnoreCase(".anni")){
    		toggleHack();
    		String as1[] = par1Str.split(" ");
    		if(par1Str.toLowerCase().startsWith(".s")){
    			nuke.clear();
    			modename = "survival";
    			mode = 1;
    		} else if(par1Str.toLowerCase().startsWith(".c")){
    			nuke.clear();
    			modename = "creative";
    			mode = 0;
    		} else if(par1Str.equalsIgnoreCase(".nuke") || par1Str.equals(".nuker")){
    			mc.thePlayer.addChatMessage("\247bPlease type .snuke or .cnuke");
    		} else if(par1Str.equalsIgnoreCase(".anni")){
    			nuke.clear();
    			modename = "anni";
    			mode = 1;
    			nuke.add(6);
    			nuke.add(31);
    			nuke.add(32);
    			nuke.add(37);
    			nuke.add(38);
    			nuke.add(40);
    			nuke.add(46);
    			nuke.add(50);
    			nuke.add(51);
    			nuke.add(59);
    			nuke.add(75);
    			nuke.add(76);
    			nuke.add(55);
    			nuke.add(83);
    			nuke.add(115);
    			nuke.add(132);
    			nuke.add(141);
    			nuke.add(142);
    			nuke.add(214);
    			nuke.add(626);
    			nuke.add(1307);
    		}
    	}
    }
}
