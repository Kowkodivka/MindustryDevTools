package ru.kowkodivka.tool.bundles;

import mindustry.gen.Player;

import java.util.Locale;

/**
 * BundleProvider is an interface that provides methods for retrieving localized resource bundles.
 */
public interface BundleProvider {
    /**
     * Retrieves the localized string for the given key using the default locale.
     *
     * @param key  the key to retrieve the localized string for
     * @param args optional arguments to be formatted into the localized string
     * @return the localized string if found, otherwise a default "Missing resource" string
     */
    String get(String key, Object... args);

    /**
     * Retrieves a localized string based on the player's locale, using the specified key and optional arguments.
     *
     * @param player the player for whom the localized string is retrieved
     * @param key    the key used to identify the localized string
     * @param args   optional arguments to be formatted into the localized string
     * @return the localized string with the arguments formatted, or {@code null} if the string is not found
     */
    String get(Player player, String key, Object... args);

    /**
     * Retrieves the localized string for the given key and locale.
     *
     * @param locale the locale to retrieve the localized string for
     * @param key    the key to retrieve the localized string for
     * @param args   optional arguments to be formatted into the localized string
     * @return the localized string if found, otherwise a default "Missing resource" string
     */
    String get(String locale, String key, Object... args);

    /**
     * Retrieves the localized string for the given key and locale.
     *
     * @param locale the locale to retrieve the localized string for
     * @param key    the key to retrieve the localized string for
     * @param args   optional arguments to be formatted into the localized string
     * @return the localized string if found, otherwise a default "Missing resource" string
     */
    String get(Locale locale, String key, Object... args);
}

