package com.github.marcusanthf.ftb_client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BowAimbot extends Base {

	public BowAimbot(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onUpdate(EntityPlayer player){
		if(mc.thePlayer.getCurrentEquippedItem().getItem() != null){
			Item currenti = mc.thePlayer.getCurrentEquippedItem().getItem();
			if(mc.thePlayer.getItemInUseDuration() > 0 && currenti instanceof net.minecraft.item.ItemBow){
				this.aim();
			}
		}
	}
	
	public void aim()
	{
        if (mc.theWorld.loadedEntityList != null)
        {
            for (int var2 = 0; var2 < mc.theWorld.loadedEntityList.size(); ++var2)
            {
                Entity var3 = (Entity)mc.theWorld.loadedEntityList.get(var2);
                    if (var3 instanceof EntityPlayer)
                    {
                            this.aimBow(var3);
                }
            }
        }
    }
	
	public void aimBow(Entity entity)
    {
        double var2 = 0.0D;
        double var4 = entity.posX - mc.thePlayer.posX;
        double var6 = entity.posZ - mc.thePlayer.posZ;
        double var8 = entity.posY - mc.thePlayer.posY + 1.2D;

        if (var6 > 0.0D && var4 > 0.0D)
        {
            var2 = Math.toDegrees(-Math.atan(var4 / var6));
        }
        else if (var6 > 0.0D && var4 < 0.0D)
        {
            var2 = Math.toDegrees(-Math.atan(var4 / var6));
        }
        else if (var6 < 0.0D && var4 > 0.0D)
        {
            var2 = -90.0D + Math.toDegrees(Math.atan(var6 / var4));
        }
        else if (var6 < 0.0D && var4 < 0.0D)
        {
            var2 = 90.0D + Math.toDegrees(Math.atan(var6 / var4));
        }

        float var10 = (float)Math.sqrt(var6 * var6 + var4 * var4);
        float var11 = (float)(-Math.toDegrees(Math.atan(var8 / (double)var10)));
        mc.thePlayer.rotationPitch = var11 - 3.0F;
        mc.thePlayer.rotationYaw = (float)var2;
    }


}
