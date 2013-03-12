package com.github.marcusanthf.ftb_client;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class KillAura extends Base{
	
	int jumpdelay;
	int delay = 1;
	private boolean crits = true;
	private boolean face;
	private boolean swing;

	public KillAura(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		boolean move = mc.gameSettings.keyBindForward.pressed || mc.gameSettings.keyBindLeft.pressed || mc.gameSettings.keyBindRight.pressed || mc.gameSettings.keyBindBack.pressed;
			if(!mc.thePlayer.isDead)
			{
				if(move && !mc.thePlayer.isInWater() && this.crits)
				{
							mc.thePlayer.setSprinting(true);
				}
			
			for(Object o : mc.theWorld.loadedEntityList) {
				if(o instanceof Entity) {
					Entity e = (Entity) o;
					delay++;
					jumpdelay++;
					if(jumpdelay > 6.0 && mc.thePlayer.onGround && mc.thePlayer.getDistanceToEntity(e) < 6.0D)
					{
					if(this.crits){
						mc.thePlayer.jump();
						jumpdelay = 0;
						}
					}
					try{
					boolean checks = !(e instanceof EntityPlayerSP) && (e instanceof EntityLiving) && mc.thePlayer.getDistanceToEntity(e) <= 6.0F && !e.isDead;
					
					
					if(checks) {
						if(delay > 5)
						{
							if(this.face){
								mc.thePlayer.faceEntity(e, 100F, 100F);
							}
							if(this.swing){
								mc.thePlayer.swingItem();
							}
						mc.playerController.attackEntity(mc.thePlayer, e);
						break;
					}
					}
						
				}
					catch(Exception ex){}
			}
		}
			}
	}
	

}
