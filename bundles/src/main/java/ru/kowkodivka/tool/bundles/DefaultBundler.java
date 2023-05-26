package ru.kowkodivka.tool.bundles;

import arc.util.Strings;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * DefaultBundler is an implementation of the BundleProvider interface that provides
 * localized resource bundles for a given key. It uses a default locale (English) if
 * the requested locale or resource bundle is not available.
 */
public class DefaultBundler implements BundleProvider {
    private final Locale defaultLocale = Locale.of("en");
    private final ResourceBundle defaultBundle = ResourceBundle.getBundle("bundle", defaultLocale);

    /**
     * Retrieves the localized string for the given key using the default locale.
     *
     * @param key     the key to retrieve the localized string for
     * @param objects optional objects to be formatted into the localized string
     * @return the localized string if found, otherwise a default "Missing resource" string
     */
    @Override
    public String get(String key, Object... objects) {
        return get(defaultLocale, key, objects);
    }

    /**
     * Retrieves the localized string for the given key and locale.
     *
     * @param locale  the locale to retrieve the localized string for
     * @param key     the key to retrieve the localized string for
     * @param objects optional objects to be formatted into the localized string
     * @return the localized string if found, otherwise a default "Missing resource" string
     */
    @Override
    public String get(String locale, String key, Object... objects) {
        return get(Locale.of(locale), key, objects);
    }

    /**
     * Retrieves the localized string for the given key and locale.
     *
     * @param locale  the locale to retrieve the localized string for
     * @param key     the key to retrieve the localized string for
     * @param objects optional objects to be formatted into the localized string
     * @return the localized string if found, otherwise a default "Missing resource" string
     */
    @Override
    public String get(Locale locale, String key, Object... objects) {
        ResourceBundle bundle = getResourceBundle(locale);
        try {
            return Strings.format(bundle.getString(key), objects);
        } catch (MissingResourceException exception) {
            return Strings.format(defaultBundle.getString(key), objects);
        }
    }

    /**
     * Retrieves the resource bundle for the given locale. If the requested resource bundle
     * is not available, it returns the default resource bundle.
     *
     * @param locale the locale to retrieve the resource bundle for
     * @return the resource bundle for the given locale, or the default resource bundle
     */
    private ResourceBundle getResourceBundle(Locale locale) {
        try {
            return ResourceBundle.getBundle("bundle", locale);
        } catch (MissingResourceException e) {
            return defaultBundle;
        }
    }
}


