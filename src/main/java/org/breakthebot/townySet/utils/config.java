package org.breakthebot.townySet.utils;

import org.breakthebot.townySet.TownySet;
import org.bukkit.configuration.file.FileConfiguration;

public class config {
    public final String wikiURL;
    public final String discordURL = "https://discord";


    public config(TownySet plugin) {
        FileConfiguration cfg = plugin.getConfig();
        this.wikiURL = cfg.getString("wikiURL", "https://wiki.earthmc.net/");
    }
}
