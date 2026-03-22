package dev.nuclr.plugin.event;

import dev.nuclr.plugin.PanelProviderPlugin;
import dev.nuclr.plugin.PluginPathResource;

public class PluginOpenItemEvent extends PluginEvent {

	private final PanelProviderPlugin sourceProvider;
	private final PluginPathResource resource;
	private boolean handled;

	public PluginOpenItemEvent(PanelProviderPlugin sourceProvider, PluginPathResource resource) {
		this.sourceProvider = sourceProvider;
		this.resource = resource;
	}

	public PanelProviderPlugin getSourceProvider() {
		return sourceProvider;
	}

	public PluginPathResource getResource() {
		return resource;
	}

	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}
}
