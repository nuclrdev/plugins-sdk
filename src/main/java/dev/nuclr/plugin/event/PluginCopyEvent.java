package dev.nuclr.plugin.event;

import java.util.List;

import dev.nuclr.plugin.PluginPathResource;

public class PluginCopyEvent extends PluginEvent {

	public static enum CopyMode {
		Overwrite, Append,
	}

	private List<PluginPathResource> sources;

	private CopyMode copyMode;

}
