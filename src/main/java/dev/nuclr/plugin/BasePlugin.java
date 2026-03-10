package dev.nuclr.plugin;

import java.util.List;

import javax.swing.JComponent;

public interface BasePlugin {

	PluginInfo getPluginInfo();

	JComponent getPanel();
	
	/** Return menu items for the given resource, or null/empty if none. */
	List<MenuResource> getMenuItems(PluginPathResource source);
	
	void load(ApplicationPluginContext context);
	
	/** Plugin unload: release global resources. Provider will not be used again. */
	void unload();
	
}
