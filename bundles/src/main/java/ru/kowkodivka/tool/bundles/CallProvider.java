package ru.kowkodivka.tool.bundles;

import arc.func.Boolf;
import mindustry.gen.Groups;
import mindustry.gen.Player;

/**
 * Provides methods for calling actions related to players.
 */
public interface CallProvider {
    /**
     * Sends a message to a specific player.
     *
     * @param player the target player
     * @param key    the key used to identify the message
     * @param args   optional arguments to be formatted into the message
     */
    void send(Player player, String key, Object... args);

    /**
     * Sends an informational message to a specific player.
     *
     * @param player the target player
     * @param key    the key used to identify the message
     * @param args   optional arguments to be formatted into the message
     */
    void infoMessage(Player player, String key, Object... args);

    /**
     * Sets the HUD message for a specific player.
     *
     * @param player the target player
     * @param key    the key used to identify the HUD message
     * @param args   optional arguments to be formatted into the HUD message
     */
    void setHud(Player player, String key, Object... args);

    /**
     * Announces a message to a specific player.
     *
     * @param player the target player
     * @param key    the key used to identify the announcement
     * @param args   optional arguments to be formatted into the announcement
     */
    void announce(Player player, String key, Object... args);

    /**
     * Shows a toast message to a specific player.
     *
     * @param player the target player
     * @param icon   the icon ID for the toast message
     * @param key    the key used to identify the toast message
     * @param args   optional arguments to be formatted into the toast message
     */
    void toast(Player player, int icon, String key, Object... args);

    /**
     * Adds a floating label to a specific player's screen.
     *
     * @param player   the target player
     * @param duration the duration in seconds for which the label is displayed
     * @param x        the x-coordinate of the label's position
     * @param y        the y-coordinate of the label's position
     * @param key      the key used to identify the label text
     * @param args     optional arguments to be formatted into the label text
     */
    void label(Player player, float duration, float x, float y, String key, Object... args);

    /**
     * Shows a popup dialog to a specific player.
     *
     * @param player   the target player
     * @param duration the duration in seconds for which the popup is displayed
     * @param align    the alignment of the popup (0 = top, 1 = center, 2 = bottom)
     * @param top      the top position of the popup
     * @param left     the left position of the popup
     * @param bottom   the bottom position of the popup
     * @param right    the right position of the popup
     * @param key      the key used to identify the popup text
     * @param args     optional arguments to be formatted into the popup text
     */
    void popup(Player player, float duration, int align, int top, int left, int bottom, int right, String key, Object... args);

    /**
     * Sends a message to all players.
     *
     * @param key  the key used to identify the message
     * @param args optional arguments to be formatted into the message
     */
    default void sendForAll(String key, Object... args) {
        Groups.player.each(player -> send(player, key, args));
    }

    /**
     * Sends a message to players matching the specified filter.
     *
     * @param filter the filter to match players
     * @param key    the key used to identify the message
     * @param args   optional arguments to be formatted into the message
     */
    default void sendForAll(Boolf<Player> filter, String key, Object... args) {
        Groups.player.each(filter, player -> send(player, key, args));
    }

    /**
     * Sends an informational message to all players.
     *
     * @param key  the key used to identify the message
     * @param args optional arguments to be formatted into the message
     */
    default void infoMessageForAll(String key, Object... args) {
        Groups.player.each(player -> infoMessage(player, key, args));
    }

    /**
     * Sends an informational message to players matching the specified filter.
     *
     * @param filter the filter to match players
     * @param key    the key used to identify the message
     * @param args   optional arguments to be formatted into the message
     */
    default void infoMessageForAll(Boolf<Player> filter, String key, Object... args) {
        Groups.player.each(filter, player -> infoMessage(player, key, args));
    }

    /**
     * Sets the HUD message for all players.
     *
     * @param key  the key used to identify the HUD message
     * @param args optional arguments to be formatted into the HUD message
     */
    default void setHudForAll(String key, Object... args) {
        Groups.player.each(player -> setHud(player, key, args));
    }

    /**
     * Sets the HUD message for players matching the specified filter.
     *
     * @param filter the filter to match players
     * @param key    the key used to identify the HUD message
     * @param args   optional arguments to be formatted into the HUD message
     */
    default void setHudForAll(Boolf<Player> filter, String key, Object... args) {
        Groups.player.each(filter, player -> setHud(player, key, args));
    }

    /**
     * Announces a message to all players.
     *
     * @param key  the key used to identify the announcement
     * @param args optional arguments to be formatted into the announcement
     */
    default void announceForAll(String key, Object... args) {
        Groups.player.each(player -> announce(player, key, args));
    }

    /**
     * Announces a message to players matching the specified filter.
     *
     * @param filter the filter to match players
     * @param key    the key used to identify the announcement
     * @param args   optional arguments to be formatted into the announcement
     */
    default void announceForAll(Boolf<Player> filter, String key, Object... args) {
        Groups.player.each(filter, player -> announce(player, key, args));
    }

    /**
     * Shows a toast message to all players.
     *
     * @param icon the icon ID for the toast message
     * @param key  the key used to identify the toast message
     * @param args optional arguments to be formatted into the toast message
     */
    default void toastForAll(int icon, String key, Object... args) {
        Groups.player.each(player -> toast(player, icon, key, args));
    }

    /**
     * Shows a toast message to players matching the specified filter.
     *
     * @param filter the filter to match players
     * @param icon   the icon ID for the toast message
     * @param key    the key used to identify the toast message
     * @param args   optional arguments to be formatted into the toast message
     */
    default void toastForAll(Boolf<Player> filter, int icon, String key, Object... args) {
        Groups.player.each(filter, player -> toast(player, icon, key, args));
    }

    /**
     * Adds a floating label to all players' screens.
     *
     * @param duration the duration in seconds for which the label is displayed
     * @param x        the x-coordinate of the label's position
     * @param y        the y-coordinate of the label's position
     * @param key      the key used to identify the label text
     * @param args     optional arguments to be formatted into the label text
     */
    default void labelForAll(float duration, float x, float y, String key, Object... args) {
        Groups.player.each(player -> label(player, duration, x, y, key, args));
    }

    /**
     * Adds a floating label to players matching the specified filter.
     *
     * @param filter   the filter to match players
     * @param duration the duration in seconds for which the label is displayed
     * @param x        the x-coordinate of the label's position
     * @param y        the y-coordinate of the label's position
     * @param key      the key used to identify the label text
     * @param args     optional arguments to be formatted into the label text
     */
    default void labelForAll(Boolf<Player> filter, float duration, float x, float y, String key, Object... args) {
        Groups.player.each(filter, player -> label(player, duration, x, y, key, args));
    }

    /**
     * Shows a popup dialog to all players.
     *
     * @param duration the duration in seconds for which the popup is displayed
     * @param align    the alignment of the popup (0 = top, 1 = center, 2 = bottom)
     * @param top      the top position of the popup
     * @param left     the left position of the popup
     * @param bottom   the bottom position of the popup
     * @param right    the right position of the popup
     * @param key      the key used to identify the popup text
     * @param args     optional arguments to be formatted into the popup text
     */
    default void popupForAll(float duration, int align, int top, int left, int bottom, int right, String key, Object... args) {
        Groups.player.each(player -> popup(player, duration, align, top, left, bottom, right, key, args));
    }

    /**
     * Shows a popup dialog to players matching the specified filter.
     *
     * @param filter   the filter to match players
     * @param duration the duration in seconds for which the popup is displayed
     * @param align    the alignment of the popup (0 = top, 1 = center, 2 = bottom)
     * @param top      the top position of the popup
     * @param left     the left position of the popup
     * @param bottom   the bottom position of the popup
     * @param right    the right position of the popup
     * @param key      the key used to identify the popup text
     * @param args     optional arguments to be formatted into the popup text
     */
    default void popupForAll(Boolf<Player> filter, float duration, int align, int top, int left, int bottom, int right, String key, Object... args) {
        Groups.player.each(filter, player -> popup(player, duration, align, top, left, bottom, right, key, args));
    }
}

