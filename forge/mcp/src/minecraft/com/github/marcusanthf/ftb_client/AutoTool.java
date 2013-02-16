package com.github.marcusanthf.ftb_client;

import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.item.ItemStack;

public class AutoTool extends Base {

	public AutoTool(String hackName, String hackCommand, int hackKey) {
		super(hackName, hackCommand, hackKey);
	}

	@Override
	public void clickBlock(int var1, int var2, int var3){
		this.autoTool(var1, var2, var3);
	}
	
	private void autoTool(int var1, int var2, int var3) {
        int var4 = mc.theWorld.getBlockId(var1, var2, var3);
        int var5 = 0;
        float var6 = 0.1F;

        for (int var7 = 36; var7 < 45; ++var7)
        {
            try
            {
                ItemStack var8 = mc.thePlayer.inventoryContainer.getSlot(var7).getStack();

                if (var8.getStrVsBlock(Block.blocksList[var4]) > var6)
                {
                    var5 = var7 - 36;
                    var6 = var8.getStrVsBlock(Block.blocksList[var4]);
                }
            }
            catch (Exception var9)
            {
                ;
            }
            mc.thePlayer.inventory.currentItem = var5;
        }
	}
}
