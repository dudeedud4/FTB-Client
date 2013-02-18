package com.github.marcusanthf.ftb_client;

import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;

public class Tracers extends Base {

	public Tracers(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void renderEntities(Vec3 par1Vec3, ICamera par2ICamera, float par3)
	{
		this.Tracer(par3);
	}
	
	public static void Tracer(float f)
	{
		try{
		GL11.glPushMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDepthMask(false);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glLineWidth(1.8F);
    	int i = 0;
    	Entity e = (Entity) mc.theWorld.getLoadedEntityList().get(i);
        for (Object entities: mc.theWorld.loadedEntityList)
        {
            if (entities != mc.thePlayer && entities != null)
            {
                if (entities instanceof EntityPlayer)
                {
                    EntityPlayer entity = (EntityPlayer)entities;
                    float distance = mc.thePlayer.getDistanceToEntity(entity);
                    double posX = ((entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * (double)f) - RenderManager.instance.renderPosX);
                    double posY = ((entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * (double)f) - RenderManager.instance.renderPosY);
                    double posZ = ((entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * (double)f) - RenderManager.instance.renderPosZ);

                        if (distance <= 6F)
                        {
                            GL11.glColor3f(1.0F, 0.0F, 0.0F);
                        }
                        else if (distance <= 96F)
                        {
                            GL11.glColor3f(1.0F, (distance / 100F), 0.0F);
                        }
                        else if (distance > 96F)
                        {
                            GL11.glColor3f(0.0F, 0.9F, 0.0F);
                        }

                    GL11.glBegin(GL11.GL_LINE_LOOP);
                    //GL11.glVertex2d(0, 0);
                    GL11.glVertex3d(0, 0, 0);
                    GL11.glVertex3d(posX, posY, posZ);
                    GL11.glEnd();
                }
            }
        }
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glDepthMask(true);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}catch (Exception e) { }
	}

}
