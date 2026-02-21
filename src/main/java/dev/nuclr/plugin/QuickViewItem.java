package dev.nuclr.plugin;

import java.nio.file.Path;

public interface QuickViewItem {
	
	String name();

	long sizeBytes();

	String extension();

	String mimeType();                  // optional, can be null

	java.io.InputStream openStream() throws Exception;
	
	Path path();                       // optional, can be null
}