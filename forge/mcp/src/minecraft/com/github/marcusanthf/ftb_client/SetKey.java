package com.github.marcusanthf.ftb_client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

import org.lwjgl.input.Keyboard;

public class SetKey extends Base {
	private int newKey;
	
	File keys = new File(getWorkingDirectory(), "yoloKeys.txt");

	public SetKey(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
		if(getWorkingDirectory().exists()){
			if(!keys.exists()){
				try {
					keys.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					mc.thePlayer.addChatMessage("\2474\247lFailed to create yolokeys.txt");
					System.out.println("[ERROR] Failed to create yolokeys.txt");
				}
			}
			if(keys.exists()){
				this.loadKeys();
			}
		}
	}
	
	private void loadKeys(){
        try {
		if(!keys.exists()){
			return;
		}
			BufferedReader var1 = new BufferedReader(new FileReader(this.keys));
			String var2 = "";
			try {
				while ((var2 = var1.readLine()) != null && var1.readLine() != "" && var1.readLine() != "\n")
				{
					try
					{
						String[] var3 = var2.split(":");
						newKey =  Keyboard.getKeyIndex(var3[1].toUpperCase());
						String hackName = var3[0];
						System.out.println(hackName + ":" + newKey);
						for (int i=0; i< hackArray.size(); i++) {
							Base hack1 = hackArray.get(i);
							if(hack1.getName().equalsIgnoreCase(hackName) && newKey > -1){
								hack1.key = newKey;
							}
						}
						
					}catch(Error e){
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private int getPlatform() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.contains("linux"))
			return 1;
		if (osName.contains("unix"))
			return 1;
		if (osName.contains("solaris"))
			return 2;
		if (osName.contains("sunos"))
			return 2;
		if (osName.contains("win"))
			return 3;
		if (osName.contains("mac"))
			return 4;
		return 5;
	}
	
	private File getWorkingDirectory() {
		String userHome = System.getProperty("user.home", ".");
		File workingDirectory;
		switch (getPlatform()) {
		case 1:
		case 2:
			workingDirectory = new File(userHome, ".minecraft/");
			break;
		case 3:
			String applicationData = System.getenv("APPDATA");
			if (applicationData != null)
				workingDirectory = new File(applicationData, ".minecraft/");
			else
				workingDirectory = new File(userHome, ".minecraft/");
			break;
		case 4:
			workingDirectory = new File(userHome,
					"Library/Application Support/minecraft");
			break;
		default:
			workingDirectory = new File(userHome, ".minecraft/");
		}
		return workingDirectory;
	}

	public void setKey(String setkey){
		newKey = Keyboard.getKeyIndex(setkey.toUpperCase());
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.toLowerCase().startsWith(".key")){
			try{
				String as1[] = par1Str.split(" ");
				if(as1[1].equalsIgnoreCase("add") || as1[1].equalsIgnoreCase("set")){
				setKey(as1[3]);
				for (int i=0; i< hackArray.size(); i++) {
					Base hack1 = hackArray.get(i);
					if(hack1.getName().equalsIgnoreCase(as1[2]) && newKey > -1){
						hack1.key = newKey;
						OutputStreamWriter writer = new OutputStreamWriter( new FileOutputStream(this.keys, true), "UTF-8");
						BufferedWriter bufferedWriter = new BufferedWriter(writer);
						bufferedWriter.write(hack1.getName() + ":" + as1[3]);
						bufferedWriter.newLine();
						bufferedWriter.close();
					}
				}
				}else if(as1[1].equalsIgnoreCase("del") || as1[1].equalsIgnoreCase("rm") || as1[1].equalsIgnoreCase("delete")){
					for (int i=0; i< hackArray.size(); i++) {
						Base hack1 = hackArray.get(i);
						if(hack1.getName().equalsIgnoreCase(as1[2]) && newKey > -1){
							hack1.key = -1;
						}
						try {
							if(!keys.exists()){
								return;
							}
								BufferedReader var1 = new BufferedReader(new FileReader(this.keys));
								String var2 = "";
								try {
									while ((var2 = var1.readLine()) != null)
									{
										try
										{
											String[] var3 = var2.split(":");
											newKey =  Keyboard.getKeyIndex(var3[1].toUpperCase());
											String hackName = var3[0];
											System.out.println(hackName + ":" + newKey);
											for (int i1=0; i1< hackArray.size(); i1++) {
												Base hack11 = hackArray.get(i1);
												if(hack11.getName().equalsIgnoreCase(hackName)){
													if((hack11.getName().equalsIgnoreCase(as1[2]) || hack11.getCommand().equalsIgnoreCase(as1[2]))){
														FileWriter fileWriter = new FileWriter(this.keys);
														BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
														bufferedWriter.write(hack11.getName() + ":" + "-1");
														bufferedWriter.newLine();
														bufferedWriter.close();
														hack1.key = -1;
														hack11.key = -1;
													}
												}
											}
											
										}catch(Error e){
											e.printStackTrace();
										}
									}
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
								
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
				}
				}else if(as1[1].equalsIgnoreCase("help") || as1[1].equalsIgnoreCase(null)){
					mc.thePlayer.addChatMessage("\247bUsage: \247f.key \2470[\247aadd/del\2470] \247ahackname key");
					mc.thePlayer.addChatMessage("\247bExample: \247f.key \247aadd \247afly v");
				}
			}catch(Exception e){
			}
		}
	}
	
}