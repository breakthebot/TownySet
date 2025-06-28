package org.breakthebot.townySet.utils;

import com.palmergames.bukkit.towny.object.Nation;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import com.palmergames.bukkit.towny.object.metadata.CustomDataField;
import com.palmergames.bukkit.towny.object.metadata.StringDataField;
import org.jetbrains.annotations.NotNull;


public class MetaData {
    private static final String residentWiki_KEY = "wiki_url";
    private static final String townDiscord_KEY = "discord_url";
    private static final String nationDiscord_KEY = "discord_url";

    public static void setNationDiscord(@NotNull Nation nation, String url) {
        if (nation.hasMeta(nationDiscord_KEY)) {
            nation.removeMetaData(nationDiscord_KEY);
        }
        StringDataField field = new StringDataField(nationDiscord_KEY, url);
        nation.addMetaData(field);
        nation.save();
    }

    public static String getNationDiscord(@NotNull Nation nation) {
        if (!nation.hasMeta(nationDiscord_KEY)) {
            return "";
        }

        CustomDataField<?> field = nation.getMetadata(nationDiscord_KEY);
        if (field instanceof StringDataField s) {
            return s.getValue();
        }
        return "";
    }

    public static boolean nationHasDiscord(@NotNull Nation nation) {
        return nation.hasMeta(nationDiscord_KEY);
    }

    public static boolean nationRemoveDiscord(@NotNull Nation nation) {
        if (!nation.hasMeta(nationDiscord_KEY)) {
            return false;
        }
        nation.removeMetaData(nationDiscord_KEY);
        nation.save();
        return true;
    }


    public static void setTownDiscord(@NotNull Town town, String url) {
        if (town.hasMeta(townDiscord_KEY)) {
            town.removeMetaData(townDiscord_KEY);
        }
        StringDataField field = new StringDataField(townDiscord_KEY, url);
        town.addMetaData(field);
        town.save();
    }

    public static String getTownDiscord(@NotNull Town town) {
        if (!town.hasMeta(townDiscord_KEY)) {
            return "";
        }

        CustomDataField<?> field = town.getMetadata(townDiscord_KEY);
        if (field instanceof StringDataField s) {
            return s.getValue();
        }
        return "";
    }

    public static boolean townHasDiscord(@NotNull Town town) {
        return town.hasMeta(townDiscord_KEY);
    }

    public static boolean townRemoveDiscord(@NotNull Town town) {
        if (!town.hasMeta(townDiscord_KEY)) {
            return false;
        }
        town.removeMetaData(townDiscord_KEY);
        town.save();
        return true;
    }



    public static void setResidentWiki(@NotNull Resident res, String url) {
        if (res.hasMeta(residentWiki_KEY)) {
            res.removeMetaData(residentWiki_KEY);
        }
        StringDataField field = new StringDataField(residentWiki_KEY, url);
        res.addMetaData(field);
        res.save();
    }

    public static String getResidentWiki(@NotNull Resident res) {
        if (!res.hasMeta(residentWiki_KEY)) {
            return "";
        }

        CustomDataField<?> field = res.getMetadata(residentWiki_KEY);
        if (field instanceof StringDataField s) {
            return s.getValue();
        }
        return "";
    }

    public static boolean residentHasWiki(@NotNull Resident res) {
        return res.hasMeta(residentWiki_KEY);
    }

    public static boolean residentRemoveWiki(@NotNull Resident res) {
        if (!res.hasMeta(residentWiki_KEY)) {
            return false;
        }
        res.removeMetaData(residentWiki_KEY);
        res.save();
        return true;
    }
}
