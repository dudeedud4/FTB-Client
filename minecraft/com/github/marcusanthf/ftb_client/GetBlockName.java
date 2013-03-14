package com.github.marcusanthf.ftb_client;

import net.minecraft.block.Block;

public class GetBlockName extends Base {
	public GetBlockName(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void commandToggle(String par1Str){
		if(par1Str.toLowerCase().startsWith(".blockid ")){
			try{
   		    String as1[] = par1Str.toLowerCase().split(" ");
   		    String id = Integer.toString(blockNameToID(as1[1].toLowerCase()));;
   		    if(id == "-1"){
   		    	mc.thePlayer.addChatMessage("\2474\247lID not found!");
   		    }else{
   		    mc.thePlayer.addChatMessage("\247bID of \247l" + as1[1] + "\247r\247b is \247l" + id);
   		    }
			}catch(Exception e){
		    }
		}
		if(par1Str.toLowerCase().startsWith(".blockname ")){
   		    try{
			String as1[] = par1Str.toLowerCase().split(" ");
   		    int var1 = new Integer(as1[1]);
   		    if(blockIDToName(var1) == null){
   		    	mc.thePlayer.addChatMessage("\2474\247lBlock not found!");
   		    }else{
   		    mc.thePlayer.addChatMessage("\247bName of " + as1[1] + " is " + blockIDToName(var1));
   		    	mc.thePlayer.addChatMessage("Failed");
   		    }
   		    }catch(Exception e){
   		    }
		}
	}

	public static int blockNameToID(String var0)
    {
        var0 = var0.toLowerCase();
        Block[] var1 = Block.blocksList;
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            Block var4 = var1[var3];

            if (var4 != null)
            {
                String var5 = var4.getBlockName();

                if (var5 != null)
                {
                    var5 = var5.toLowerCase().replaceAll("tile.", "");

                    if (var5.contains("ore"))
                    {
                        var5 = var5.toLowerCase().replaceAll("ore", "");
                        var5 = var5 + "ore";
                    }

                    if (var5.contains("block"))
                    {
                        var5 = var5.toLowerCase().replaceAll("block", "");
                        var5 = var5 + "block";
                    }
                 
                    if (var5.equalsIgnoreCase(var0))
                    {
                        return var4.blockID;
                    }
                }
            }
        }

        return -1;
    }

    public static String blockIDToName(int var0)
    {
        Block[] var1 = Block.blocksList;
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3)
        {
            Block var4 = var1[var3];

            if (var4 != null)
            {
                String var5 = var4.getBlockName();

                if (var5 != null)
                {
                    var5 = var5.toLowerCase().replaceAll("tile.", "");

                    if (var5.contains("ore"))
                    {
                        var5 = var5.toLowerCase().replaceAll("ore", "");
                        var5 = var5 + "ore";
                    }

                    if (var5.contains("block"))
                    {
                        var5 = var5.toLowerCase().replaceAll("block", "");
                        var5 = var5 + "block";
                    }

                    if (var4.blockID == var0)
                    {
                        return var5;
                    }
                }
            }
        }

        return null;
    }
}
