package com.github.marcusanthf.ftb_client;

public class ColorSet extends Base {

	public ColorSet(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}

	@Override
	public void commandToggle(String par1Str){
		if(par1Str.startsWith(".color")){
			String as1[] = par1Str.split(" ");
			if(as1[1].equalsIgnoreCase("blue") || par1Str.equalsIgnoreCase("cyan")){
				Base.color = 1;
			}else if(as1[1].equalsIgnoreCase("red")){
				Base.color = 2;
			}else if(as1[1].equalsIgnoreCase("purple")){
				Base.color = 3;
			}else if(as1[1].equalsIgnoreCase("yellow") || as1[1].equalsIgnoreCase("yellur")){
				Base.color = 4;
			}else if(as1[1].equalsIgnoreCase("white")){
				Base.color = 5;
			}else if (as1[1].equalsIgnoreCase("black")){
				Base.color = 6;
			}else if (as1[1].equalsIgnoreCase("pink")){
				Base.color = 7;
			}else{
				mc.thePlayer.addChatMessage("\2474\247lInvalid color!");
			}
		}
	}
}
