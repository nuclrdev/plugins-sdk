package dev.nuclr.plugin;

import java.awt.Color;
import java.awt.Font;
import java.util.Map;

/**
 * Immutable theme snapshot passed from the host application to plugins.
 *
 * <p>Values in {@code uiDefaults} use Swing {@code UIManager} keys and hex
 * color strings (for example {@code "#102a43"}).
 */
public record PluginTheme(
		String name,
		Map<String, String> uiDefaults,
		String fontFamily,
		int fontSize) {

	public PluginTheme {
		name = name != null && !name.isBlank() ? name : "Default";
		uiDefaults = uiDefaults != null ? Map.copyOf(uiDefaults) : Map.of();
		fontFamily = fontFamily != null && !fontFamily.isBlank() ? fontFamily : Font.MONOSPACED;
		fontSize = fontSize > 0 ? fontSize : 12;
	}

	public Color color(String key, Color fallback) {
		String value = uiDefaults.get(key);
		if (value == null || value.isBlank()) {
			return fallback;
		}

		try {
			return Color.decode(value);
		} catch (RuntimeException ex) {
			return fallback;
		}
	}

	public Font font(int style, int size) {
		return new Font(fontFamily, style, size > 0 ? size : fontSize);
	}

	public Font defaultFont() {
		return font(Font.PLAIN, fontSize);
	}
}
