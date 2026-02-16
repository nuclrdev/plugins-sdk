package dev.nuclr.plugin;

import lombok.Data;

@Data
public final class PluginInfo {

	private String description;

	private String author;

	private String license;

	private String website;

	private String pageUrl;

	private String documentationUrl;

	private PluginType type;

}
