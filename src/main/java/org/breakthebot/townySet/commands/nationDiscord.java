package org.breakthebot.townySet.commands;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.TownyMessaging;
import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import org.breakthebot.townySet.TownySet;
import org.breakthebot.townySet.utils.MetaData;
import org.breakthebot.townySet.utils.config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class nationDiscord implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            TownyMessaging.sendErrorMsg(sender, "Only players may use this command.");
            return false;
        }

        if (!player.hasPermission("towny.command.nation.set.discord")) {
            TownyMessaging.sendMsg(player, "You do not have permission to perform this command.");
        }

        TownyAPI API = TownyAPI.getInstance();
        Resident res = API.getResident(player);
        assert res != null;
        if (!res.hasNation()) {
            TownyMessaging.sendErrorMsg(player, "You must be part of a nation.");
            return false;
        }
        Nation nation = res.getNationOrNull();
        assert nation != null;
        config settings = TownySet.getInstance().getConf();

        if (args.length == 0) {
            if (!MetaData.nationHasDiscord(nation)) {
                TownyMessaging.sendErrorMsg(player, "You haven't linked a discord.");
                return false;
            }
            TownyMessaging.sendMsg(player, "Discord unlinked.");
            MetaData.nationRemoveDiscord(nation);
            return true;
        }

        String discordURL = args[0];
        if (!discordURL.startsWith(settings.discordURL)) {
            TownyMessaging.sendErrorMsg(player, "Invalid discord invite");
            return false;
        }

        MetaData.setNationDiscord(nation, discordURL);
        TownyMessaging.sendMsg(player, "Discord linked!");
        return true;
    }
}
