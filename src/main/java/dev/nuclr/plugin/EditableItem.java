package dev.nuclr.plugin;

import java.io.OutputStream;

public interface EditableItem extends QuickViewItem {

	boolean isReadOnly();

	OutputStream openOutputStream() throws Exception;

}
