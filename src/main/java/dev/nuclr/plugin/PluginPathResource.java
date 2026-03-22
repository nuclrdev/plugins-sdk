package dev.nuclr.plugin;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import lombok.Data;

@Data
public class PluginPathResource {

	protected Map<String, String> metadata = new HashMap<>();

	protected String uuid;

	protected String name;

	protected long sizeBytes;

	protected String extension;

	protected String mimeType; // optional, can be null

	protected Path path; // optional

	public String getExtension() {
		return extension != null ? extension : path != null ? extensionFromPath() : "";
	}

	private String extensionFromPath() {
		return path.getFileName().toString().contains(".")
				? path.getFileName().toString().substring(path.getFileName().toString().lastIndexOf('.') + 1)
				: "";
	}

	public InputStream openStream() throws Exception {
		if (path != null) {
			return java.nio.file.Files.newInputStream(path);
		} else {
			throw new UnsupportedOperationException("Cannot open stream for PluginPathResource without a path");
		}
	}

}