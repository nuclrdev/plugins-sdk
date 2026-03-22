package dev.nuclr.plugin.event.bus;

import dev.nuclr.plugin.event.PluginEvent;

public interface PluginEventBus {

	void emit(PluginEvent event);

	void subscribe(PluginEventListener listener);

	void unsubscribe(PluginEventListener listener);

}
