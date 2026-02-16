package dev.nuclr.plugin;

public interface QuickViewItem {
	
	String name();

	long sizeBytes();

	String extension();

	String mimeType();                  // optional, can be null

	java.io.InputStream openStream() throws Exception;
}