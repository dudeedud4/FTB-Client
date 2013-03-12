/*
 * Copyright (c) 2013, DarkStorm (darkstorm@evilminecraft.net)
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met: 
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer. 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution. 
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
 * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

/*
 * Yes, I know I could use for loops with the hack array and
 * add a field for hackType, but I would like to keep it this way
 * for now to make it easier to add a hack under multiple
 * GUIs
 */

package org.darkstorm.minecraft.gui;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import java.awt.*;

import net.minecraft.client.Minecraft;

import org.darkstorm.minecraft.gui.component.*;
import org.darkstorm.minecraft.gui.component.Button;
import org.darkstorm.minecraft.gui.component.Component;
import org.darkstorm.minecraft.gui.component.Frame;
import org.darkstorm.minecraft.gui.component.basic.*;
import org.darkstorm.minecraft.gui.listener.*;
import org.darkstorm.minecraft.gui.theme.Theme;
import org.darkstorm.minecraft.gui.theme.simple.SimpleTheme;

import com.github.marcusanthf.ftb_client.Base;

/**
 * Minecraft GUI API
 * 
 * @author DarkStorm (darkstorm@evilminecraft.net)
 */
public class GuiManagerImpl implements GuiManager {
	private class ModuleFrame extends BasicFrame {
		private ModuleFrame() {
		}

		private ModuleFrame(String title) {
			super(title);
		}
	}
	
	private final List<Frame> frames;

	private Theme theme;
	private boolean setup = false;

	public GuiManagerImpl() {
		frames = new CopyOnWriteArrayList<Frame>();
	}

	@Override
	public void setup() {
		if(setup)
			return;
		setup = true;

		createTestFrame();

		/* Sample module frame setup

		final Map<ModuleCategory, ModuleFrame> categoryFrames = new HashMap<ModuleCategory, ModuleFrame>();
		for(Module module : ClientNameHere.getClientInstance().getModuleManager().getModules()) {
			if(!module.isToggleable())
				continue;
			ModuleFrame frame = categoryFrames.get(module.getCategory());
			if(frame == null) {
				String name = module.getCategory().name().toLowerCase();
				name = Character.toUpperCase(name.charAt(0))
						+ name.substring(1);
				frame = new ModuleFrame(name);
				frame.setTheme(theme);
				frame.setLayoutManager(new GridLayoutManager(2, 0));
				frame.setVisible(true);
				frame.setClosable(false);
				frame.setMinimized(true);
				addFrame(frame);
				categoryFrames.put(module.getCategory(), frame);
			}
			frame.add(new BasicLabel(module.getName()));
			final Module updateModule = module;
			Button button = new BasicButton(module.isEnabled() ? "Disable"
					: "Enable") {
				@Override
				public void update() {
					setText(updateModule.isEnabled() ? "Disable" : "Enable");
				}
			};
			button.addButtonListener(new ButtonListener() {
				@Override
				public void onButtonPress(Button button) {
					updateModule.toggle();
					button.setText(updateModule.isEnabled() ? "Disable"
							: "Enable");
				}
			});
			frame.add(button, HorizontalGridConstraint.RIGHT);
		}
		*/

		// Optional equal sizing and auto-positioning
		resizeComponents();
		Minecraft minecraft = Minecraft.getMinecraft();
		Dimension maxSize = recalculateSizes();
		int offsetX = 5, offsetY = 5;
		int scale = minecraft.gameSettings.guiScale;
		if(scale == 0)
			scale = 1000;
		int scaleFactor = 0;
		while(scaleFactor < scale
				&& minecraft.displayWidth / (scaleFactor + 1) >= 320
				&& minecraft.displayHeight / (scaleFactor + 1) >= 240)
			scaleFactor++;
		for(Frame frame : frames) {
			frame.setX(offsetX);
			frame.setY(offsetY);
			offsetX += maxSize.width + 5;
			if(offsetX + maxSize.width + 5 > minecraft.displayWidth
					/ scaleFactor) {
				offsetX = 5;
				offsetY += maxSize.height + 5;
			}
		}
	}
	
	public void createNukerFrame(){
		Frame nukerFrame = new BasicFrame("Nuker");
		nukerFrame.setTheme(theme);
		nukerFrame.add(new BasicLabel("Automatically break blocks"));
		
		nukerFrame.add(new BasicCheckButton("SNuke"){
			@Override
			public void press() {
				Base.nuker.toggleHack();
				if(Base.nuker.mode != 1 || Base.nuker.modename != "survival"){
				Base.nuker.modename = "survival";
				Base.nuker.mode = 1;
				}
				Base.nuker.nuke.clear();
				super.press();
			}
			@Override
			public boolean isSelected() {
				return Base.nuker.getEnabled() && Base.nuker.mode == 1 && Base.nuker.modename == "survival";
			}
		});
		
		nukerFrame.add(new BasicCheckButton("CNuke"){
			@Override
			public void press() {
				Base.nuker.toggleHack();
				if(Base.nuker.mode != 0 || Base.nuker.modename != "creative"){
				Base.nuker.modename = "creative";
				Base.nuker.mode = 0;
				}
				Base.nuker.nuke.clear();
				super.press();
			}
			@Override
			public boolean isSelected() {
				return Base.nuker.getEnabled() && Base.nuker.mode == 0 && Base.nuker.modename == "creative";
			}
		});
		
		nukerFrame.add(new BasicCheckButton("Anni"){
			@Override
			public void press() {
				Base.nuker.toggleHack();
				if(Base.nuker.mode != 1 || Base.nuker.modename != "anni"){
				Base.nuker.modename = "anni";
				Base.nuker.mode = 1;
				Base.nuker.nuke.clear();
				Base.nuker.nuke.add(6);
				Base.nuker.nuke.add(31);
				Base.nuker.nuke.add(32);
				Base.nuker.nuke.add(37);
				Base.nuker.nuke.add(38);
				Base.nuker.nuke.add(40);
				Base.nuker.nuke.add(46);
				Base.nuker.nuke.add(50);
				Base.nuker.nuke.add(51);
				Base.nuker.nuke.add(59);
				Base.nuker.nuke.add(75);
				Base.nuker.nuke.add(76);
				Base.nuker.nuke.add(55);
				Base.nuker.nuke.add(83);
				Base.nuker.nuke.add(115);
				Base.nuker.nuke.add(132);
				Base.nuker.nuke.add(141);
				Base.nuker.nuke.add(142);
				Base.nuker.nuke.add(214);
				Base.nuker.nuke.add(626);
				Base.nuker.nuke.add(1307);
				}else{
				Base.nuker.nuke.clear();
				}
				super.press();
			}
			@Override
			public boolean isSelected() {
				return Base.nuker.getEnabled() && Base.nuker.mode == 1 && Base.nuker.modename == "anni";
			}
		});
		
		nukerFrame.setX(60);
		nukerFrame.setY(50);
		Dimension defaultDimension = theme.getUIForComponent(nukerFrame)
				.getDefaultSize(nukerFrame);
		nukerFrame.setWidth(defaultDimension.width);
		nukerFrame.setHeight(defaultDimension.height);
		nukerFrame.layoutChildren();
		nukerFrame.setVisible(true);
		nukerFrame.setMinimized(true);
		addFrame(nukerFrame);
	}
	
	public void createPlayerFrame(){
		Frame playerFrame = new BasicFrame("Player");
		playerFrame.setTheme(theme);
		playerFrame.add(new BasicLabel("Hacks that control the current player"));
		playerFrame.add(Base.fly.button);
		playerFrame.add(Base.flybypass.button);
		playerFrame.add(Base.autofish.button);
		playerFrame.add(Base.fastplace.button);
		playerFrame.add(Base.nocactus.button);
		playerFrame.add(Base.noswing.button);
		playerFrame.add(Base.derp.button);
		playerFrame.add(Base.jesus.button);
		playerFrame.add(Base.reach.button);
		playerFrame.add(Base.sneak.button);
		playerFrame.add(Base.sprint.button);
		playerFrame.add(Base.autotool.button);
		playerFrame.add(Base.speedmine.button);
		playerFrame.add(Base.nofall.button);
		playerFrame.add(Base.movespeed.button);
		playerFrame.add(Base.step.button);
		
		playerFrame.setX(60);
		playerFrame.setY(50);
		Dimension defaultDimension = theme.getUIForComponent(playerFrame)
				.getDefaultSize(playerFrame);
		playerFrame.setWidth(defaultDimension.width);
		playerFrame.setHeight(defaultDimension.height);
		playerFrame.layoutChildren();
		playerFrame.setVisible(true);
		playerFrame.setMinimized(true);
		addFrame(playerFrame);
	}
	
	public void createPVPFrame(){
		Frame PVPFrame = new BasicFrame("PVP");
		PVPFrame.setTheme(theme);
		PVPFrame.add(new BasicLabel("PVP-related hacks"));
		PVPFrame.add(Base.fastbow.button);
		PVPFrame.add(Base.bowaimbot.button);
		PVPFrame.add(Base.tracers.button);
		PVPFrame.add(Base.nikofag.button);
		PVPFrame.add(Base.nametags.button);
		PVPFrame.add(Base.chams.button);
		PVPFrame.add(Base.autoblock.button);
		PVPFrame.add(Base.killaura.button);
		
		PVPFrame.setX(60);
		PVPFrame.setY(50);
		Dimension defaultDimension = theme.getUIForComponent(PVPFrame)
				.getDefaultSize(PVPFrame);
		PVPFrame.setWidth(defaultDimension.width);
		PVPFrame.setHeight(defaultDimension.height);
		PVPFrame.layoutChildren();
		PVPFrame.setVisible(true);
		PVPFrame.setMinimized(true);
		addFrame(PVPFrame);
	}
	
	public void createDisplayFrame(){
		Frame displayFrame = new BasicFrame("Display");
		displayFrame.setTheme(theme);
		displayFrame.add(new BasicLabel("Client-sided display hacks"));
		displayFrame.add(Base.fullbright.button);
		displayFrame.add(Base.nikofag.button);
		displayFrame.add(Base.tracers.button);
		displayFrame.add(Base.nametags.button);
		displayFrame.add(Base.chams.button);
		
		displayFrame.setX(60);
		displayFrame.setY(50);
		Dimension defaultDimension = theme.getUIForComponent(displayFrame)
				.getDefaultSize(displayFrame);
		displayFrame.setWidth(defaultDimension.width);
		displayFrame.setHeight(defaultDimension.height);
		displayFrame.layoutChildren();
		displayFrame.setVisible(true);
		displayFrame.setMinimized(true);
		addFrame(displayFrame);
	}

	private void createTestFrame() {
		Frame testFrame = new BasicFrame("Main");
		testFrame.setTheme(theme);
		testFrame.setClosable(false);
		BasicButton playerButton = new BasicButton("Player Hacks");
		playerButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				createPlayerFrame();
			}
		});
		BasicButton displayButton = new BasicButton("Display Hacks");
		displayButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				createDisplayFrame();
			}
		});
		BasicButton pvpButton = new BasicButton("PVP Hacks");
		pvpButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				createPVPFrame();
			}
		});
		BasicButton nukerButton = new BasicButton("Nuker");
		nukerButton.addButtonListener(new ButtonListener() {

			@Override
			public void onButtonPress(Button button) {
				createNukerFrame();
			}
		});
		testFrame.add(playerButton);
		testFrame.add(displayButton);
		testFrame.add(pvpButton);
		testFrame.add(nukerButton);
		ComboBox comboBox = new BasicComboBox("Blue", "Red", "Purple", "Yellow", "White", "Black", "Pink");
		comboBox.addComboBoxListener(new ComboBoxListener() {

			@Override
			public void onComboBoxSelectionChanged(ComboBox comboBox) {
				switch(comboBox.getSelectedIndex()) {
				case 0:
					Base.color = 1;
					break;
				case 1:
					Base.color = 2;
					break;
				case 2:
					Base.color = 3;
					break;
				case 3:
					Base.color = 4;
					break;
				case 4:
					Base.color = 5;
					break;
				case 5:
					Base.color = 6;
					break;
				case 6:
					Base.color = 7;
					break;
				default:
					return;
				}
				setTheme(theme);
			}
		});
		testFrame.add(comboBox);
		testFrame.setX(50);
		testFrame.setY(50);
		Dimension defaultDimension = theme.getUIForComponent(testFrame)
				.getDefaultSize(testFrame);
		testFrame.setWidth(defaultDimension.width);
		testFrame.setHeight(defaultDimension.height);
		testFrame.layoutChildren();
		testFrame.setVisible(true);
		testFrame.setMinimized(true);
		addFrame(testFrame);
	}

	private Dimension recalculateSizes() {
		int maxWidth = 0, maxHeight = 0;
		for(Frame frame : frames) {
			Dimension defaultDimension = frame.getTheme()
					.getUIForComponent(frame).getDefaultSize(frame);
			maxWidth = Math.max(maxWidth, defaultDimension.width);
			frame.setHeight(defaultDimension.height);
			if(frame.isMinimized()) {
				for(Rectangle area : frame.getTheme().getUIForComponent(frame)
						.getInteractableRegions(frame))
					maxHeight = Math.max(maxHeight, area.height);
			} else
				maxHeight = Math.max(maxHeight, defaultDimension.height);
		}
		for(Frame frame : frames) {
			frame.setWidth(maxWidth);
			frame.layoutChildren();
		}
		return new Dimension(maxWidth, maxHeight);
	}

	private void resizeComponents() {
		Button enable = new BasicButton("Enable");
		Button disable = new BasicButton("Disable");
		Dimension enableSize = theme.getUIForComponent(enable).getDefaultSize(
				enable);
		Dimension disableSize = theme.getUIForComponent(disable)
				.getDefaultSize(disable);
		int buttonWidth = Math.max(enableSize.width, disableSize.width);
		int buttonHeight = Math.max(enableSize.height, disableSize.height);
		for(Frame frame : frames) {
			if(frame instanceof ModuleFrame) {
				for(Component component : frame.getChildren()) {
					if(component instanceof Button) {
						component.setWidth(buttonWidth);
						component.setHeight(buttonHeight);
					}
				}
			}
		}
	}

	@Override
	public void addFrame(Frame frame) {
		frame.setTheme(theme);
		frames.add(frame);
	}

	@Override
	public void removeFrame(Frame frame) {
		frames.remove(frame);
	}

	@Override
	public Frame[] getFrames() {
		return frames.toArray(new Frame[frames.size()]);
	}

	@Override
	public void bringForward(Frame frame) {
		if(frames.remove(frame))
			frames.add(0, frame);
	}

	@Override
	public Theme getTheme() {
		return theme;
	}

	@Override
	public void setTheme(Theme theme) {
		this.theme = theme;
		for(Frame frame : frames)
			frame.setTheme(theme);
		resizeComponents();
		recalculateSizes();
	}

	@Override
	public void render() {
		for(Frame frame : frames)
			frame.render();
	}
}
