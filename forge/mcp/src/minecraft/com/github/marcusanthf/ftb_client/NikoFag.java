package com.github.marcusanthf.ftb_client;

import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

import com.github.marcusanthf.ftb_client.gui.GuiMethods;

public class NikoFag extends Base {
	
	static Sphere sphere = new Sphere();

	public NikoFag(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		sphere.setDrawStyle(GLU.GLU_SILHOUETTE);
        sphere.setNormals(GLU.GLU_SMOOTH);
		// Nikolas fag
	}

/**
  double var3 = par1Entity.lastTickPosX + (par1Entity.posX - par1Entity.lastTickPosX) * (double)par2;
        double var5 = par1Entity.lastTickPosY + (par1Entity.posY - par1Entity.lastTickPosY) * (double)par2;
        double var7 = par1Entity.lastTickPosZ + (par1Entity.posZ - par1Entity.lastTickPosZ) * (double)par2;
 */
	@Override
	public void renderInGame() {		
		
		GL11.glLineWidth(0.75F);
	    for(int x=0; x < mc.theWorld.loadedEntityList.size(); x++)
	    {
	    	
			Entity e1 = (Entity)mc.theWorld.loadedEntityList.get(x);
	    	
			if(e1 == mc.thePlayer)
				continue;
			
			if(!(e1 instanceof EntityLiving))
				continue;
			
			boolean player = (e1 instanceof EntityPlayer && true);
			
			if(!player)
				continue;
				
	    	EntityLiving e = (EntityLiving)e1;
	    		    	
	    	GL11.glPushMatrix();

	    			double xx = e.lastTickPosX + (e.posX - e.lastTickPosX) - RenderManager.instance.renderPosX;
	    			double yy = e.lastTickPosY + (e.posY - e.lastTickPosY) - RenderManager.instance.renderPosY;
	    			double zz = e.lastTickPosZ + (e.posZ - e.lastTickPosZ) - RenderManager.instance.renderPosZ;
	    			
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
			         
			         if(e.hurtTime > 0)
			             GL11.glColor3f(1f, 0.5f, 0f);
			         
	    			
	    			GL11.glTranslated(xx , yy, zz);
	    			
	    			GL11.glRotatef(-e.rotationYaw, 0, 1f, 0);
	    			
	    				float w = 0.4f;
	    				if(true)
	    				{
	    				eLines(new AxisAlignedBB(-w, e.getEyeHeight(), -w, w, 0, w));

	    				GuiMethods.drawOutlinedBoundingBox(new AxisAlignedBB(-w, e.getEyeHeight(), -w, w, 0, w)); 
	    				}
	    				  
	   		        	drawSphere();
	    			
	    	GL11.glPopMatrix();
	    }
	    
	}
	
	   public static void draw(double d, double d1, double d2, EntityPlayer entity, String s){
			 //  Minecraft mc = Minecraft.theMinecraft;
		    	if(s.equalsIgnoreCase(mc.session.username))
		    		return;
		    	
		         GL11.glPushMatrix();
		     	 GL11.glEnable(3042 /*GL_BLEND*/);
		         GL11.glBlendFunc(770, 771);
		         GL11.glDisable(GL11.GL_TEXTURE_2D);  
		         GL11.glEnable(GL11.GL_LINE_SMOOTH);
		         GL11.glDisable(2896 /*GL_LIGHTING*/);
		         GL11.glDisable(2929 /*GL_DEPTH_TEST*/); 
		         GL11.glDepthMask(false);
		         GL11.glDisable(GL11.GL_FOG);
		         
		         //GL11.glColor3f((60-mc.thePlayer.getDistanceToEntity(entity))/60, (mc.thePlayer.getDistanceToEntity(entity))/60, 0f);
	            
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
		         
		         if(entity.hurtTime > 0)
		             GL11.glColor3f(1f, 0.5f, 0f);
		         
		         GL11.glTranslated(d, d1+1, d2);
		         
		         GL11.glRotatef(-entity.rotationYaw, 0, 1F, 0);
		         
		         GL11.glLineWidth(1F);
		         
		        	 drawSphere();
		         
		         // GL11.glEnable(GL11.GL_TEXTURE_2D);  
		         
		         //mc.fontRenderer.drawString(""+entity.hurtTime, 0, 0, 0xffffff);
		         GL11.glEnable(GL11.GL_TEXTURE_2D); 
		         GL11.glEnable(GL11.GL_LIGHTING);
		         if(!Base.chams.getEnabled())
		         {
		         GL11.glEnable(2929 /*GL_DEPTH_TEST*/);
		         GL11.glDepthMask(true);
		         }
		         GL11.glDisable(3042 /*GL_BLEND*/);
		         GL11.glPopMatrix();
		     }
	   
	   
	   	public static void drawSphere(){
	         GL11.glEnable(GL11.GL_DEPTH_TEST);
	   		 GL11.glRotatef(90, 1F, 0F, 0);
	         sphere.draw(2.4f, 25, 25);
	         GL11.glDisable(GL11.GL_DEPTH_TEST);

	   	}
	   
		   public static void eLines(AxisAlignedBB ax) {
		         GL11.glBegin(GL11.GL_LINES); 
		         GL11.glVertex3d(ax.maxX, ax.maxY, ax.maxZ); 
		         GL11.glVertex3d(ax.minX, ax.minY, ax.maxZ); 
		         GL11.glEnd();
		     }

}
