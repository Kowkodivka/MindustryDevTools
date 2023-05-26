package ru.kowkodivka.tool.menu;

import arc.util.Nullable;
import mindustry.gen.Call;
import mindustry.gen.Player;
import ru.kowkodivka.tool.bundles.BundleProvider;

// TODO

public record Menu(@Nullable BundleProvider provider,
                   int id,
                   String internal,
                   String title,
                   String content
) {
    public void show(Player player) {
        Call.menu(player.con, id, title, content, null);
    }
}
