package com.github.marcusanthf.ftb_client;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.Vec3;

import org.darkstorm.minecraft.gui.GuiManager;
import org.darkstorm.minecraft.gui.GuiManagerImpl;
import org.darkstorm.minecraft.gui.component.basic.BasicCheckButton;
import org.lwjgl.input.Keyboard;

public abstract class Base {
	
	public static ArrayList<Base> hackArray = new ArrayList<Base>(); //Creating an array list for hacks
	public boolean hackToggle; //Tells if the hack is on or off
	private String name; //Hack name
	private String command; //Command to activate hack
	protected int key; //Key to activate hack
	public static int color = 1; //color cuz 'murrika
	public BasicCheckButton button;
	
	Iterator hacks = hackArray.iterator();
	
	private static Minecraft minecraft;
	protected static Minecraft mc = getMinecraft();
	
	/*
	 * Name is just a string that consists of the hack name. Ex: "freecam"
	 * Command is the command that should activate the hack from the console. Ex. "fcam"
	 * Key is the keybind used to activate the command. I'm going to try avoiding the use of this due to keybinds that mods use. Ex: Keyboard.KEY_GRAVE Ex2: Keyboard.KEY_N
	 * 
	 * Ex. public static Freecam freecam = new Hacks("FreeCam", ".fc", Keyboard.KEY_N)
	 */

	public static Gui gui = new Gui("Gui", "gui", Keyboard.KEY_GRAVE);
	public static ReverseNuke reversenuke = new ReverseNuke("ReverseNuke", "blockspam", -1);
	public static Sprint sprint = new Sprint("Sprint", "sprint", -1);
	public static Blank blank = new Blank("Blank", null, -1);
	public static Insult insult = new Insult("Insult", null, -1);
	public static ColorSet colorset = new ColorSet("ColorSet", null, -1);
	public static FastBow fastbow = new FastBow("Fastbow", "fastbow", -1);
	public static Autoblock autoblock = new Autoblock("AutoBlock", "autoblock", -1);
	public static NikoFag nikofag = new NikoFag("Nikolas is a faggot", "nikofag", -1);
	public static NoCactus nocactus = new NoCactus("NoCactus", "nocactus", -1);
	public static AutoSign autosign = new AutoSign("AutoSign", "autosign", -1);
	public static Crits crits = new Crits("Crits", "crits", -1);
	public static Nametags nametags = new Nametags("Nametags", "nametags", -1);
	public static AutoFish autofish = new AutoFish("AutoFish", "autofish", -1);
	public static Sneak sneak = new Sneak("Sneak", "sneak", -1);
	public static Chams chams = new Chams("Chams", "chams", -1);
	public static NoSwing noswing = new NoSwing("NoSwing", "noswing", -1);
	public static FastPlace fastplace = new FastPlace("Fastplace", "fastplace", -1);
	public static Freecam freecam = new Freecam("Freecam", "fc", -1);
	public static Derp derp = new Derp("Derp", null, -1);
	public static Emo emo = new Emo("Emo", "emo", -1);
	public static MoveSpeed movespeed = new MoveSpeed("MoveSpeed", null, -1);
	public static Step step = new Step("Step", null, -1);
	public static OpAbuse opabuse = new OpAbuse("OpAbuse", null, -1);
	public static Tracers tracers = new Tracers("Tracers", "tracers", -1);
	public static KillAura killaura = new KillAura("Killaura", "killaura", -1);
	public static Jesus jesus = new Jesus("Jesus", "jesus", -1);
	public static FlyBypass flybypass = new FlyBypass("FlyBypass", "flybypass", -1);
	public static Xray xray = new Xray("Xray", "xray", Keyboard.KEY_N);
	public static Fullbright fullbright = new Fullbright("Fullbright", "fb", -1);
	public static Help help = new Help("Help", null, -1);
	public static Reach reach = new Reach("Reach", "reach", -1);
	public static BowAimbot bowaimbot = new BowAimbot("BowAimbot", "bowaim", -1);
	public static Nuker nuker = new Nuker("Nuker", null, -1);
	public static GetBlockName getblockname = new GetBlockName("Boloque", null, -1);
	public static AutoTool autotool = new AutoTool("AutoTool", "autotool", -1); 
	public static SpeedMine speedmine = new SpeedMine("Speedmine", "speedmine", -1); 
	public static GodMode godmode = new GodMode("GodMode", "safe", -1); 
	public static Teleport teleport = new Teleport("Teleport", null, -1); 
	public static NoFall nofall = new NoFall("Nofall", "nofall", -1); 
	public static Fly fly = new Fly("Fly", "fly", Keyboard.KEY_V); //Define fly and set its variables
	public static SetKey setkey = new SetKey("SetKey", null, -1);
	
	public Base(String hackName, String hackCommand, int hackKey)
	{
		//Used to add hacks to the arraylist "Hacks" which will contain all of the hack variables and information
		this.name = hackName; //Name will be set to the hackName string
		this.command = hackCommand; //Command will be set to the command String
		this.key = hackKey; //Key will be set to the hackKey string
		hackArray.add(this);  //Arguments will be added to the Array
		this.button = new BasicCheckButton(this.name){
			@Override
			public boolean isSelected() {
				return hackToggle;
			}
			@Override
			public void press() {
				toggleHack();
				super.press();
			}
		};
	}
	
	public boolean getEnabled() //Check the status of the hack
	{
		return hackToggle;
	}
	
	public String getName() //Check the name of the hack
	{
		return name;
	}
	
	public String getCommand() //Check the command to toggle the hack
	{
		return command;
	}
	
	public int getKey() //Check the key to toggle the hack
	{
		return key;
	}
	
	public void onUpdate(EntityPlayer player){} //Used if a hack needs to perform an action on tick
	
	public void afterUpdate(EntityPlayer player){}
	
	public void onEnable(){
		System.out.println("[INFO] " + name + " enabled."); //Print when a hack is enabled
	} //Actions to perform when hack is enabled
	
	public void onDisable(){
		System.out.println("[INFO] " + name + " disabled."); //Print when a hack is disabled
	} //Actions to perform when hack is disabled
	
	public void toggleHack() //Toggle the hack on or off
	{
		//If the hack is on, turn it off and vice versa
		if(hackToggle)
		{
			hackToggle = false;
			onDisable(); //Do anything that we want to do when the hack is disabled
		}else{
			hackToggle = true;
			onEnable(); //Do anything that we want to do when the hack is enabled
		}
	}
	
	public void onKeyPressed(int key) { //TODO add custom key bind control in separate class
		if (key == this.key) {
			toggleHack();
		}
	}
	
	public void commandToggle(String par1Str){
		if(par1Str.equals("." + getCommand())){
			toggleHack();
		}
	}
	
	public static Minecraft getMinecraft() {
		if (minecraft == null)
			minecraft = Minecraft.getMinecraft();

		return minecraft;
	}

	public void clickBlock(int var1, int var2, int var3) {
	}

	public void renderEntities(Vec3 par1Vec3, ICamera par2iCamera, float par3) {}

	public void motionUpdate(EntityClientPlayerMP playermp) {
		// TODO Auto-generated method stub
		
	}
	
	public void renderInGame(){}
}