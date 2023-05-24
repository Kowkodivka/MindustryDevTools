package ru.kowkodivka.tool.security;

import arc.Events;
import arc.func.Cons2;
import arc.struct.Seq;
import arc.util.Http;
import arc.util.serialization.Jval;
import mindustry.Vars;
import mindustry.game.EventType;
import mindustry.gen.Call;
import mindustry.gen.Player;


/**
 * Includes features to protect the server from threats
 */
public class Security {
    private static final String githubMeta = "https://api.github.com/meta";

    /**
     * Provides ip of GitHub actions that can be used to harm the server.
     *
     * @param ipv6 Whether to include IP type v6
     */
    public static Seq<String> getActionsIps(boolean ipv6) {
        Seq<String> actions = new Seq<>();
        Http.get(githubMeta, json -> Jval
                .read(json.getResultAsString())
                .get("actions")
                .asArray()
                .filter(ip -> ipv6 && ip.asString().charAt(4) == ':')
                .forEach(ip -> actions.add(ip.asString()))
        );

        return actions;
    }

    /**
     * Blocks ips of GitHub actions that can be used to harm the server.
     *
     * @param ipv6 Whether to include IP type v6
     */
    public static void blacklistActions(boolean ipv6) {
        Vars.netServer.admins.dosBlacklist.addAll(getActionsIps(ipv6));
    }

    /**
     * Provides the ability to track players with mod that can harm the server or give advantages to players (cheats) "Scheme size".
     *
     * @param runnable Action to take after a player is detected
     */
    public static void blacklistSchemeSize(Cons2<Player, String> runnable) {
        Events.on(EventType.PlayerJoin.class, event -> Call.clientPacketReliable(event.player.con, "SendMeSubtitle", null));
        Vars.netServer.addPacketHandler("MySubtitle", runnable);
    }
}
