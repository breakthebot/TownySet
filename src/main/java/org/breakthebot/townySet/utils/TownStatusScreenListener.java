package org.breakthebot.townySet.utils;

import com.palmergames.adventure.text.Component;
import com.palmergames.adventure.text.event.ClickEvent;
import com.palmergames.adventure.text.format.NamedTextColor;
import com.palmergames.bukkit.towny.event.statusscreen.TownStatusScreenEvent;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownStatusScreenListener implements Listener {

    @EventHandler
    public void onTownStatusScreen(TownStatusScreenEvent event) {
        Town town = event.getTown();
        if (!MetaData.townHasDiscord(town))
            return;

        String discordURL = MetaData.getTownDiscord(town);

        Component component = Component.empty()
                .append(Component.text("[", NamedTextColor.GRAY))
                .append(Component.text("Discord", NamedTextColor.GREEN)
                        .hoverEvent(Component.text(discordURL, NamedTextColor.DARK_GREEN))
                        .clickEvent(ClickEvent.openUrl(discordURL)))
                .append(Component.text("]", NamedTextColor.GRAY));

        event.getStatusScreen().addComponentOf("discord", component);
    }
}