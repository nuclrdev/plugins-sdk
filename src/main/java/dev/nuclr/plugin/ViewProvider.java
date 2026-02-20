package dev.nuclr.plugin;

import javax.swing.JComponent;

public interface ViewProvider {

	/** Unique plugin class name, used for lookup. */
	String getPluginClass();

	/** Fast check; avoid heavy IO here. */
	boolean matches(QuickViewItem item);

	/** UI component for this provider instance. */
	JComponent getPanel();

	/** Open/refresh view for the item (do heavy work async, update UI on EDT). */
	boolean open(QuickViewItem item);

	/** Close current item/session (stop playback, cancel background tasks). */
	void close();

	/** Plugin unload: release global resources. Provider will not be used again. */
	void unload();
	
	int priority(); // lower priority providers are preferred when multiple match the same item

}
