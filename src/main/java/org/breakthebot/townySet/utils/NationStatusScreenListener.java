package org.breakthebot.townySet.utils;

import com.palmergames.adventure.text.Component;
import com.palmergames.adventure.text.event.ClickEvent;
import com.palmergames.adventure.text.format.NamedTextColor;
import com.palmergames.bukkit.towny.event.statusscreen.NationStatusScreenEvent;
import com.palmergames.bukkit.towny.object.Nation;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class NationStatusScreenListener implements Listener {

    @EventHandler
    public void onTownStatusScreen(NationStatusScreenEvent event) {
        Nation nation = event.getNation();
        if (!MetaData.nationHasDiscord(nation))
            return;

        String discordURL = MetaData.getNationDiscord(nation);

        Component component = Component.empty()
                .append(Component.text("[", NamedTextColor.GRAY))
                .append(Component.text("Discord", NamedTextColor.GREEN)
                        .hoverEvent(Component.text(discordURL, NamedTextColor.DARK_GREEN))
                        .clickEvent(ClickEvent.openUrl(discordURL)))
                .append(Component.text("]", NamedTextColor.GRAY));

        event.getStatusScreen().addComponentOf("discord", component);
    }
}
