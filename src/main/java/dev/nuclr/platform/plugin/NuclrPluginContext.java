package dev.nuclr.platform.plugin;

import dev.nuclr.platform.Settings;
import dev.nuclr.platform.ThemeScheme;
import dev.nuclr.platform.events.NuclrEventBus;

public interface NuclrPluginContext {

	NuclrEventBus getEventBus();

	ThemeScheme getTheme();

	Settings getSettings();

}
