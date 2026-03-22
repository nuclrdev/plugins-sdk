package dev.nuclr.plugin.event;

import lombok.Data;

@Data
public abstract class PluginEvent {

	private boolean handled;
	
}
