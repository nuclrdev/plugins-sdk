package dev.nuclr.plugin;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public abstract class PluginPathResource {

	protected Map<String, String> metadata = new HashMap<>();

	protected String uuid;

	protected String name;

	protected long sizeBytes;

	protected String extension;

	protected String mimeType; // optional, can be null

	public abstract InputStream openStream() throws Exception;

}