package dev.nuclr.plugin.event;

import dev.nuclr.plugin.PanelProviderPlugin;

public class PluginClosePanelEvent extends PluginEvent {

	private final PanelProviderPlugin sourceProvider;
	private boolean handled;

	public PluginClosePanelEvent(PanelProviderPlugin sourceProvider) {
		this.sourceProvider = sourceProvider;
	}

	public PanelProviderPlugin getSourceProvider() {
		return sourceProvider;
	}

	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}
}
