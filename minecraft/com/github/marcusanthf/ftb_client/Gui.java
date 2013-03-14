package com.github.marcusanthf.ftb_client;

import org.darkstorm.minecraft.gui.GuiManager;
import org.darkstorm.minecraft.gui.GuiManagerImpl;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;
import org.darkstorm.minecraft.gui.util.GuiControls;
import org.lwjgl.input.Keyboard;

public class Gui extends Base {
	
	private GuiManager manager;

	public Gui(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
		manager = new GuiManagerImpl();
		
		manager.setTheme(new SimpleTheme());
		manager.setup();
	}
	
	@Override
	public void toggleHack(){
			mc.displayGuiScreen(new GuiControls(manager));
	}

}
