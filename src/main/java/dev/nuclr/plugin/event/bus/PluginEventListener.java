package dev.nuclr.plugin.event.bus;

import dev.nuclr.plugin.event.PluginEvent;

public interface PluginEventListener {

	/*
	 * Return "true" to stop propagating (if handled)
	 */
	void handleMessage(PluginEvent e);

	boolean isMessageSupported(PluginEvent msg);
}
