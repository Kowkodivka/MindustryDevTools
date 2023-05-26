package ru.kowkodivka.tool.bundles;

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

