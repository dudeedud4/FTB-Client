package com.github.marcusanthf.ftb_client;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import org.lwjgl.input.Keyboard;

public abstract class Base {
	
	public static ArrayList<Base> hackArray = new ArrayList<Base>(); //Creating an array list for hacks
	public boolean hackToggle; //Tells if the hack is on or off
	private String name; //Hack name
	private String command; //Command to activate hack
	private int key; //Key to activate hack
	
	Iterator hacks = hackArray.iterator();
	
	protected static Base base;
	private static Minecraft minecraft;
	protected static Minecraft mc = getMinecraft();
	
	/*
	 * Name is just a string that consists of the hack name. Ex: "freecam"
	 * Command is the command that should activate the hack from the console. Ex. "fcam"
	 * Key is the keybind used to activate the command. I'm going to try avoiding the use of this due to keybinds that mods use. Ex: Keyboard.KEY_GRAVE Ex2: Keyboard.KEY_N
	 * 
	 * Ex. public static Freecam freecam = new Hacks("FreeCam", ".fc", Keyboard.KEY_N)
	 */
	
	public Base(String hackName, String hackCommand, int hackKey)
	{
		//Used to add hacks to the arraylist "Hacks" which will contain all of the hack variables and information
		this.name = hackName; //Name will be set to the hackName string
		this.command = hackCommand; //Command will be set to the command String
		this.key = hackKey; //Key will be set to the hackKey string
		hackArray.add(this);  //Arguments will be added to the Array
	}
	
	public boolean getEnabled() //Check the status of the hack
	{
		return hackToggle;
	}
	
	public String getName() //Check the name of the hack
	{
		return name;
	}
	
	public String getCommand() //Check the command to toggle the hack
	{
		return command;
	}
	
	public int getKey() //Check the key to toggle the hack
	{
		return key;
	}
	
	public void onUpdate(EntityPlayer player){} //Used if a hack needs to perform an action on tick
	
	public void onEnable(){
		System.out.println("[INFO] " + name + " enabled."); //Print when a hack is enabled
	} //Actions to perform when hack is enabled
	
	public void onDisable(){
		System.out.println("[INFO] " + name + " disabled."); //Print when a hack is disabled
	} //Actions to perform when hack is disabled
	
	public void toggleHack() //Toggle the hack on or off
	{
		//If the hack is on, turn it off and vice versa
		if(hackToggle)
		{
			hackToggle = false;
			onDisable(); //Do anything that we want to do when the hack is disabled
		}else{
			hackToggle = true;
			onEnable(); //Do anything that we want to do when the hack is enabled
		}
	}
	
	public void onKeyPressed(int key) { //TODO add custom key bind control in separate class
		if (key == this.key) {
			toggleHack();
		}
	}
	
	public static Minecraft getMinecraft() {
		if (minecraft == null)
			minecraft = Minecraft.getMinecraft();

		return minecraft;
	}
}