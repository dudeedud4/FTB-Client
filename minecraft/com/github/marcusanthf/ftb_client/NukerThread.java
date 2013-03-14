package com.github.marcusanthf.ftb_client;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.NetClientHandler;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.network.packet.Packet14BlockDig;

public class NukerThread implements Runnable
{
    public int range = 5;
    public Nuker nuker;

    public NukerThread(Nuker var1)
    {
        this.nuker = var1;
    }

    public void run()
    {
        this.nuke();

        try
        {
            Thread.sleep(57L);
        }
        catch (InterruptedException var2)
        {
            var2.printStackTrace();
        }
    }

    public void nuke()
    {
        EntityClientPlayerMP var1 = Base.mc.thePlayer;
        WorldClient var2 = Base.mc.theWorld;
        NetClientHandler var3 = Base.mc.getSendQueue();
        int var4 = (int)(var1.posX + (double)this.range);
        int var5 = (int)(var1.posX - (double)this.range);
        int var6 = (int)(var1.posY + (double)this.range);
        int var7 = (int)(var1.posY - (double)this.range);
        int var8 = (int)(var1.posZ + (double)this.range);
        int var9 = (int)(var1.posZ - (double)this.range);
        for (int var10 = var5; var10 < var4; ++var10)
        {
            for (int var11 = var7; var11 < var6; ++var11)
            {
                for (int var12 = var9; var12 < var8; ++var12)
                {
                    int var13 = var2.getBlockId(var10, var11, var12);
                    boolean var14 = this.nuker.mode == 0 ? !this.nuker.nuke.contains(Integer.valueOf(var13)) : this.nuker.nuke.contains(Integer.valueOf(var13));

                    if (var13 != 0 && var14)
                    {
                        Base.autotool.autoTool(var10, var11, var12);
                        var3.addToSendQueue(new Packet14BlockDig(0, var10, var11, var12, 1));
                        var3.addToSendQueue(new Packet14BlockDig(2, var10, var11, var12, 1));
                    }
                }
            }
        }
    }
}
