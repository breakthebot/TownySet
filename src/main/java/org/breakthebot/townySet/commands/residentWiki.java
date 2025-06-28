package org.breakthebot.townySet.commands;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.object.Resident;
import org.breakthebot.townySet.TownySet;
import org.breakthebot.townySet.utils.MetaData;
import org.breakthebot.townySet.utils.config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;


public class residentWiki implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            TownyMessaging.sendErrorMsg(sender, "Only players may use this command.");
            return false;
        }

        if (!player.hasPermission("towny.command.resident.set.wiki")) {
            TownyMessaging.sendMsg(player, "You do not have permission to perform this command.");
        }

        TownyAPI API = TownyAPI.getInstance();
        Resident res = API.getResident(player);
        config settings = TownySet.getInstance().getConf();
        assert res != null;

        if (args.length == 0) {
            if (!MetaData.residentHasWiki(res)) {
                TownyMessaging.sendErrorMsg(player, "You haven't linked a wiki page.");
                return false;
            }
            TownyMessaging.sendMsg(player, "Resident wiki page unlinked.");
            MetaData.residentRemoveWiki(res);
            return true;
        }

        String wikiURL = args[0];
        if (!(settings.wikiURL == null)) {
            if (!wikiURL.startsWith(settings.wikiURL)) {
                TownyMessaging.sendErrorMsg(player, "Invalid wiki page. You can only link pages from " + settings.wikiURL);
                return false;
            }
        }
        MetaData.setResidentWiki(res, wikiURL);
        TownyMessaging.sendMsg(player, "Wiki page linked!");
        return true;
    }
}