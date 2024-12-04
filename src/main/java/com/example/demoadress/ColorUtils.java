package com.example.demoadress;

import javafx.scene.paint.Color;
import java.util.prefs.Preferences;

public class ColorUtils {

    private static final Preferences preferences = Preferences.userRoot().node(ColorUtils.class.getName());

    // Ключі для збереження значень кольорів
    private static final String BACKGROUND_COLOR_KEY = "backgroundColor";
    private static final String TEXT_COLOR_KEY = "textColor";

    // Зберігає кольори фону та тексту
    public static void saveColors(Color backgroundColor, Color textColor) {
        preferences.put(BACKGROUND_COLOR_KEY, toHexString(backgroundColor));
        preferences.put(TEXT_COLOR_KEY, toHexString(textColor));
    }

    // Завантажує кольори фону та тексту
    public static Color getBackgroundColor() {
        return toColor(preferences.get(BACKGROUND_COLOR_KEY, "#FFFFFF")); // Default white color
    }

    public static Color getTextColor() {
        return toColor(preferences.get(TEXT_COLOR_KEY, "#000000")); // Default black color
    }

    // Перетворення Color в строку
    private static String toHexString(Color color) {
        return String.format("#%02X%02X%02X", (int)(color.getRed() * 255), (int)(color.getGreen() * 255), (int)(color.getBlue() * 255));
    }

    // Перетворення строкового значення у Color
    private static Color toColor(String hex) {
        return Color.web(hex);
    }
}
