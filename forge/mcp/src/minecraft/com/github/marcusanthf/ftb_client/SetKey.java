package com.github.marcusanthf.ftb_client;

import org.lwjgl.input.Keyboard;

public class SetKey extends Base {
	private int newKey;

	public SetKey(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}

	public void setKey(String setkey){
		if(setkey.equalsIgnoreCase("`") || setkey.equalsIgnoreCase("~")){
			newKey = Keyboard.KEY_GRAVE;
		}
		if(setkey.equalsIgnoreCase("1")){
			newKey = Keyboard.KEY_1;
		}
		if(setkey.equalsIgnoreCase("2")){
			newKey = Keyboard.KEY_2;
		}
		if(setkey.equalsIgnoreCase("3")){
			newKey = Keyboard.KEY_3;
		}
		if(setkey.equalsIgnoreCase("4")){
			newKey = Keyboard.KEY_4;
		}
		if(setkey.equalsIgnoreCase("5")){
			newKey = Keyboard.KEY_5;
		}
		if(setkey.equalsIgnoreCase("6")){
			newKey = Keyboard.KEY_6;
		}
		if(setkey.equalsIgnoreCase("7")){
			newKey = Keyboard.KEY_7;
		}
		if(setkey.equalsIgnoreCase("8")){
			newKey = Keyboard.KEY_8;
		}
		if(setkey.equalsIgnoreCase("9")){
			newKey = Keyboard.KEY_9;
		}
		if(setkey.equalsIgnoreCase("0")){
			newKey = Keyboard.KEY_0;
		}
		if(setkey.equalsIgnoreCase("q")){
			newKey = Keyboard.KEY_Q;
		}
		if(setkey.equalsIgnoreCase("w")){
			newKey = Keyboard.KEY_W;
		}
		if(setkey.equalsIgnoreCase("e")){
			newKey = Keyboard.KEY_E;
		}
		if(setkey.equalsIgnoreCase("r")){
			newKey = Keyboard.KEY_R;
		}
		if(setkey.equalsIgnoreCase("t")){
			newKey = Keyboard.KEY_T;
		}
		if(setkey.equalsIgnoreCase("y")){
			newKey = Keyboard.KEY_Y;
		}
		if(setkey.equalsIgnoreCase("u")){
			newKey = Keyboard.KEY_U;
		}
		if(setkey.equalsIgnoreCase("i")){
			newKey = Keyboard.KEY_I;
		}
		if(setkey.equalsIgnoreCase("O")){
			newKey = Keyboard.KEY_O;
		}
		if(setkey.equalsIgnoreCase("p")){
			newKey = Keyboard.KEY_P;
		}
		if(setkey.equalsIgnoreCase("[") || setkey.equalsIgnoreCase("{")){
			newKey = Keyboard.KEY_LBRACKET;
		}
		if(setkey.equalsIgnoreCase("]") || setkey.equalsIgnoreCase("}")){
			newKey = Keyboard.KEY_RBRACKET;
		}
		if(setkey.equalsIgnoreCase("a")){
			newKey = Keyboard.KEY_A;
		}
		if(setkey.equalsIgnoreCase("s")){
			newKey = Keyboard.KEY_S;
		}
		if(setkey.equalsIgnoreCase("d")){
			newKey = Keyboard.KEY_D;
		}
		if(setkey.equalsIgnoreCase("f")){
			newKey = Keyboard.KEY_F;
		}
		if(setkey.equalsIgnoreCase("g")){
			newKey = Keyboard.KEY_G;
		}
		if(setkey.equalsIgnoreCase("h")){
			newKey = Keyboard.KEY_H;
		}
		if(setkey.equalsIgnoreCase("j")){
			newKey = Keyboard.KEY_J;
		}
		if(setkey.equalsIgnoreCase("k")){
			newKey = Keyboard.KEY_K;
		}
		if(setkey.equalsIgnoreCase("l")){
			newKey = Keyboard.KEY_L;
		}
		if(setkey.equalsIgnoreCase(";") || setkey.equalsIgnoreCase(":")){
			newKey = Keyboard.KEY_SEMICOLON;
		}
		if(setkey.equalsIgnoreCase("'") || setkey.equalsIgnoreCase("\"")){
			newKey = Keyboard.KEY_APOSTROPHE;
		}
		if(setkey.equalsIgnoreCase("z")){
			newKey = Keyboard.KEY_Z;
		}
		if(setkey.equalsIgnoreCase("x")){
			newKey = Keyboard.KEY_X;
		}
		if(setkey.equalsIgnoreCase("c")){
			newKey = Keyboard.KEY_C;
		}
		if(setkey.equalsIgnoreCase("v")){
			newKey = Keyboard.KEY_V;
		}
		if(setkey.equalsIgnoreCase("b")){
			newKey = Keyboard.KEY_B;
		}
		if(setkey.equalsIgnoreCase("n")){
			newKey = Keyboard.KEY_N;
		}
		if(setkey.equalsIgnoreCase("m")){
			newKey = Keyboard.KEY_M;
		}
		if(setkey.equalsIgnoreCase(",") || setkey.equalsIgnoreCase("<")){
			newKey = Keyboard.KEY_COMMA;
		}
		if(setkey.equalsIgnoreCase(".") || setkey.equalsIgnoreCase(">")){
			newKey = Keyboard.KEY_PERIOD;
		}
		if(setkey.equalsIgnoreCase("/") || setkey.equalsIgnoreCase("?")){
			newKey = Keyboard.KEY_SLASH;
		}
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
					}
				}
				}else if(as1[1].equalsIgnoreCase("del") || as1[1].equalsIgnoreCase("rm") || as1[1].equalsIgnoreCase("delete")){
					for (int i=0; i< hackArray.size(); i++) {
						Base hack1 = hackArray.get(i);
						if(hack1.getName().equalsIgnoreCase(as1[2]) && newKey > -1){
							hack1.key = 0;
						}
				}
				}else if(as1[1].equalsIgnoreCase("help") || as1[1].equalsIgnoreCase(null)){
					mc.thePlayer.addChatMessage("\247bUsage: \247f.key \2470[\247aadd/del\2470] \247ahackname key");
					mc.thePlayer.addChatMessage("\247bExample: \247f.key \247aadd \247afly v");
				}
			}catch(Exception e){
				mc.thePlayer.addChatMessage("\2474\247lError!");
			}
		}
	}
	
}
