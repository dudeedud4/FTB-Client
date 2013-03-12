package com.github.marcusanthf.ftb_client;

import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

public class Tracers extends Base {

	public Tracers(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void renderInGame()
	{
		this.drawTracers();
	}
	
	public static void Tracer(Entity var1)
	{
		GL11.glPushMatrix();
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDepthMask(false);
        EntityLiving var2 = (EntityLiving)var1;
        double var3 = var2.posX;
        double var5 = var2.posY;
        double var7 = var2.posZ;
        double var9 = RenderManager.instance.viewerPosX;
        double var11 = RenderManager.instance.viewerPosY;
        double var13 = RenderManager.instance.viewerPosZ;
        double var15 = var9 - var3;
        double var17 = var11 - var5;
        double var19 = var13 - var7;
        boolean var21 = true;

        if (!(var2 instanceof EntityPlayer))
        {
            var21 = false;

            if (mc.thePlayer.getDistanceToEntity(var2) <= 30.0F)
            {
                var21 = true;
            }
        }

        if (var21)
        {
        	if(Base.color == 1){ //blue
				GL11.glColor3f(0.27F, 0.70F, 0.92F);
			}else if(Base.color == 2){ //red
				GL11.glColor3f(1.0f, 0.0f, 0.0f);
			}else if(Base.color == 3){ //purple
				GL11.glColor3f(0.5f, 0.0f, 1.0f);
			}else if(Base.color == 4){ //yellur
				GL11.glColor3f(1.0f, 1.0f,  0.0f);
			}else if(Base.color == 5){
				GL11.glColor3f(1.0f, 1.0f, 1.0f);
			}else if(Base.color == 6){
				GL11.glColor3f(0f, 0f, 0f);
			}else if(Base.color == 7){
				GL11.glColor3f(1f, 0.5f, 1f);
			}else{
				GL11.glColor3f(0.27F, 0.70F, 0.92F);
			}
            GL11.glLineWidth(2.0f);
            GL11.glBegin(GL11.GL_LINES);
            GL11.glVertex3d(-var15 * 10.0D, -var17 * 10.0D, -var19 * 10.0D);
            GL11.glVertex2d(0.0D, 0.0D);
            GL11.glEnd();
        }

        GL11.glScalef(0.1F, 0.1F, 0.1F);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
	}
	
	public boolean shouldTrace(EntityLiving var1)
    {
        if (var1.entityId == mc.thePlayer.entityId)
        {
            return false;
        }
        else if(var1 instanceof EntityPlayer)
        {
            return true;
        }else{
        	return false;
        }
    }

	public void drawTracers(){
		mc.entityRenderer.disableLightmap(0.0D);

        for (int var1 = 0; var1 < mc.theWorld.loadedEntityList.size(); ++var1)
        {
            Entity var2 = (Entity)mc.theWorld.loadedEntityList.get(var1);

            if (var2 instanceof EntityLiving && var2 != mc.thePlayer && this.shouldTrace((EntityLiving)var2))
            {
                EntityLiving var3 = (EntityLiving)var2;
                double var4 = var3.posX;
                double var6 = var3.posY;
                double var8 = var3.posZ;
                double var10 = RenderManager.instance.viewerPosX;
                double var12 = RenderManager.instance.viewerPosY;
                double var14 = RenderManager.instance.viewerPosZ;
                double var16 = var10 - var4;
                double var18 = var12 - var6;
                double var20 = var14 - var8;
                this.Tracer(var3);
            }
	}
	}

}