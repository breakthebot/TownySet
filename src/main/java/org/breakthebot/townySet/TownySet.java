package org.breakthebot.townySet;

import com.palmergames.bukkit.towny.TownyCommandAddonAPI;
import com.palmergames.bukkit.towny.object.AddonCommand;
import org.breakthebot.townySet.commands.nationDiscord;
import org.breakthebot.townySet.commands.residentWiki;
import org.breakthebot.townySet.commands.townDiscord;
import org.breakthebot.townySet.utils.NationStatusScreenListener;
import org.breakthebot.townySet.utils.ResidentStatusScreenListener;
import org.breakthebot.townySet.utils.TownStatusScreenListener;
import org.breakthebot.townySet.utils.config;
import org.bukkit.plugin.java.JavaPlugin;


public final class TownySet extends JavaPlugin {
    private static TownySet instance;
    private config conf;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        conf = new config(this);
        AddonCommand resSetWiki = new AddonCommand(TownyCommandAddonAPI.CommandType.RESIDENT_SET, "wiki", new residentWiki());
        TownyCommandAddonAPI.addSubCommand(resSetWiki);

        AddonCommand townSetDiscord = new AddonCommand(TownyCommandAddonAPI.CommandType.TOWN_SET, "discord", new townDiscord());
        TownyCommandAddonAPI.addSubCommand(townSetDiscord);

        AddonCommand nationSetDiscord = new AddonCommand(TownyCommandAddonAPI.CommandType.NATION_SET, "discord", new nationDiscord());
        TownyCommandAddonAPI.addSubCommand(nationSetDiscord);

        getLogger().info("TownySet has been enabled!");

        getServer().getPluginManager().registerEvents(new ResidentStatusScreenListener(), this);
        getServer().getPluginManager().registerEvents(new TownStatusScreenListener(), this);
        getServer().getPluginManager().registerEvents(new NationStatusScreenListener(), this);
    }

    @Override
    public void onDisable() {
        getLogger().info("TownySet has been disabled!");
        instance = null;
    }

    public config getConf() { return this.conf; }

    public static TownySet getInstance() {
        return instance;
    }
}
