package dev.nuclr.plugin;

/**
 * Plugins that take full screen - for example, a text editor, a hex editor, etc
 */
public interface ScreenProviderPlugin extends BasePlugin {

	/** Fast check; avoid heavy IO here. */
	boolean supports(PluginPathResource resource);
	
}
