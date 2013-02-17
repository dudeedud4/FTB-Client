package com.github.marcusanthf.ftb_client.gui;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;

import com.github.marcusanthf.ftb_client.Base;

public class EnabledList extends Base{
	public EnabledList(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}

	private static ArrayList array;
	private Base base;
	private static Minecraft mc = Base.getMinecraft();
	private static ScaledResolution res = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	
	public static void renderGameOverlay(){
		drawEnabled();
	}
	
	public static void drawEnabled(){
			Iterator hacks = Base.hackArray.iterator(); //Pull in the list of hacks
			int y1 = 2; //start at 2 to leave a gap
			while(hacks.hasNext()){ //When there is a hack
				Base nexthack = (Base)hacks.next(); //Set the hack to nexthack
				if(nexthack.getEnabled()){ //If it is enabled
					int y2 = y1 + 10; //y2 will add the string height to y1
					String name = nexthack.getName(); //name = name of hack
					int width = (mc.fontRenderer.getStringWidth(name)+4); //width will be the length of the hack name + 4
					GuiMethods.drawBorderedRect(0, y1, width, y2+1, 2, 0x804e5453, 0x80000000); //drawn a rectangle around the name
					mc.fontRenderer.drawString(name, 2, y1+2, 0xFFFFFF);
		    		y1 += 12;
				}
			}
	}
}
