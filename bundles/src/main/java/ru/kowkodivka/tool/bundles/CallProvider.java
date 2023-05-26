package ru.kowkodivka.tool.bundles;

import mindustry.gen.Player;

public interface CallProvider {
    void send(Player player, String key);
}
