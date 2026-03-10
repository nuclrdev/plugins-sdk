package dev.nuclr.plugin;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public abstract class PluginPathResource {

	private Map<String, String> metadata = new HashMap<>();

	private String uuid;

	private String name;

	private long sizeBytes;

	private String extension;

	private String mimeType; // optional, can be null

	public abstract InputStream openStream() throws Exception;

	private Path path; // optional, can be null
}