package com.github.marcusanthf.ftb_client;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;

public class Freecam extends Base {
	private boolean prevfly;
    double oldposx,oldposy,oldposz;
    float oldpitch,oldyaw;
    public boolean inprogress;
	
	public Freecam(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void onEnable(){
		this.inprogress = true;
		this.oldposx = mc.thePlayer.posX;
        this.oldposy = mc.thePlayer.posY;
        this.oldposz = mc.thePlayer.posZ;
        this.oldpitch = mc.thePlayer.rotationPitch;
        this.oldyaw = mc.thePlayer.rotationYaw;
        this.prevfly = Base.fly.hackToggle;
        Base.fly.hackToggle = true;
        mc.thePlayer.noClip = true;
	}
	
	@Override
	public void onDisable(){
		mc.thePlayer.setPositionAndRotation(this.oldposx, this.oldposy, this.oldposz, this.oldyaw, this.oldpitch);
		mc.thePlayer.noClip = false;
		Base.fly.hackToggle = this.prevfly;
		this.inprogress = false;
	}
	
}
