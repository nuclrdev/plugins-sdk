package dev.nuclr.plugin;

import java.util.Map;

import dev.nuclr.plugin.event.bus.PluginEventBus;

public interface ApplicationPluginContext {

	PluginEventBus getEventBus();
	
	Map<String, Object> getGlobalData();

}
