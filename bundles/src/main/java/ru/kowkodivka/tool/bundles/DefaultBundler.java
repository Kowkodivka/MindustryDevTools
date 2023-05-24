package ru.kowkodivka.tool.bundles;

import arc.util.Nullable;
import arc.util.Strings;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DefaultBundler implements BundleProvider {
    private final Locale defaultLocale = Locale.of("en");

    @Override
    public @Nullable String get(String key, Object... objects) {
        return get(defaultLocale, key, objects);
    }

    @Override
    public @Nullable String get(String locale, String key, Object... objects) {
        return get(Locale.of(locale), key, objects);
    }

    @Override
    public @Nullable String get(Locale locale, String key, Object... objects) {
        try {
            return Strings.format(ResourceBundle.getBundle("bundle", defaultLocale).getString(key), objects);
        } catch (MissingResourceException exception) {
            return null;
        }
    }
}
