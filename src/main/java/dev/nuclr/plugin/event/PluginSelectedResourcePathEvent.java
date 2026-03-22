package dev.nuclr.plugin.event;

import dev.nuclr.plugin.PluginPathResource;

public class PluginSelectedResourcePathEvent extends PluginEvent {

	private final PluginPathResource source;

	public PluginSelectedResourcePathEvent(PluginPathResource source) {
		this.source = source;
	}

	public PluginPathResource getSource() {
		return source;
	}
}
