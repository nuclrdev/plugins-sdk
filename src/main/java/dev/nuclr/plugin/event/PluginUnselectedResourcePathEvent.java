package dev.nuclr.plugin.event;

import dev.nuclr.plugin.PluginPathResource;

public class PluginUnselectedResourcePathEvent extends PluginEvent {

	private final PluginPathResource source;

	public PluginUnselectedResourcePathEvent(PluginPathResource source) {
		this.source = source;
	}

	public PluginPathResource getSource() {
		return source;
	}
}
