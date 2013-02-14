package com.github.marcusanthf.ftb_client;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class Fly extends Base{

	//When fly is called, set the name, command, and keybind to the ones defined
	public Fly(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		mc.thePlayer.capabilities.isFlying = false;
		//Set the player's motion to 0
		player.motionX = 0;
		player.motionY = 0;
		player.motionZ = 0;
		//Bump up the movement factor
		//TODO add custom movement factor
		player.jumpMovementFactor = 1.0f;
		player.landMovementFactor = 1.0f;
		//Make the player stop sprinting
		player.setSprinting(false);
		//Set the player off of ground
		mc.thePlayer.onGround = false;
		if (mc.inGameHasFocus) {
			//When the space key is pressed
			if (Keyboard.isKeyDown(mc.gameSettings.keyBindJump.keyCode))
				//Add the the motion upward
				player.motionY++;
			if (Keyboard.isKeyDown(mc.gameSettings.keyBindSneak.keyCode))
				//Add the the motion downward
				player.motionY--;
		}
	}

}
