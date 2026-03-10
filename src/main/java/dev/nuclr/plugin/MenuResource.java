package dev.nuclr.plugin;

import dev.nuclr.plugin.event.PluginEvent;
import lombok.Data;

@Data
public abstract class MenuResource {

	private String name;

	private String keyStroke;

	public abstract PluginEvent getEvent();
}