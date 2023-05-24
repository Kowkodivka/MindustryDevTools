package ru.kowkodivka.tool.bundles;

import java.util.Locale;

public interface BundleProvider {
    String get(String key, Object... args);

    String get(String locale, String key, Object... objects);

    String get(Locale locale, String key, Object... objects);
}
