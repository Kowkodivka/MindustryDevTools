package ru.kowkodivka.tool.bundles;

import mindustry.gen.Call;
import mindustry.gen.Player;

public class DefaultCaller implements CallProvider {
    private final BundleProvider bundler;

    public DefaultCaller(BundleProvider bundler) {
        this.bundler = bundler;
    }

    @Override
    public void send(Player player, String key, Object... args) {
        player.sendMessage(bundler.get(player, key, args));
    }

    @Override
    public void infoMessage(Player player, String key, Object... args) {
        Call.infoMessage(player.con, bundler.get(player, key, args));
    }

    @Override
    public void setHud(Player player, String key, Object... args) {
        Call.setHudText(player.con, bundler.get(player, key, args));
    }

    @Override
    public void announce(Player player, String key, Object... args) {
        Call.announce(player.con, bundler.get(player, key, args));
    }

    @Override
    public void toast(Player player, int icon, String key, Object... args) {
        Call.warningToast(player.con, icon, bundler.get(player, key, args));
    }

    @Override
    public void label(Player player, float duration, float x, float y, String key, Object... args) {
        Call.label(player.con, bundler.get(player, key, args), duration, x, y);
    }

    @Override
    public void popup(Player player, float duration, int align, int top, int left, int bottom, int right, String key, Object... args) {
        Call.infoPopup(player.con, bundler.get(player, key, args), duration, align, top, left, bottom, right);
    }
}
