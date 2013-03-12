package com.github.marcusanthf.ftb_client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.client.gui.GuiMainMenu;

public class Insult extends Base {
	
    private static final Random rand = new Random();
	
	private String insult = "Swag";

	public Insult(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.equalsIgnoreCase(".insult")){
	        BufferedReader var1 = null;

	        try
	        {
	            ArrayList var2 = new ArrayList();
	            var1 = new BufferedReader(new InputStreamReader(GuiMainMenu.class.getResourceAsStream("/insults.txt"), Charset.forName("UTF-8")));
	            String var3;

	            while ((var3 = var1.readLine()) != null)
	            {
	                var3 = var3.trim();

	                if (var3.length() > 0)
	                {
	                    var2.add(var3);
	                }
	            }

	            do
	            {
	                this.insult = (String)var2.get(rand.nextInt(var2.size()));
	            }
	            while (this.insult.hashCode() == 125780783);
	        }
	        catch (IOException var12)
	        {
	            ;
	        }
	        finally
	        {
	            if (var1 != null)
	            {
	                try
	                {
	                    var1.close();
	                }
	                catch (IOException var11)
	                {
	                    ;
	                }
	            }
	        }
			mc.thePlayer.sendChatMessage(insult);
		}
	}

}
