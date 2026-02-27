package dev.nuclr.plugin.mount;

import java.io.IOException;
import java.nio.file.Path;

import dev.nuclr.plugin.panel.Capabilities;

public interface ArchiveMountProvider {

	boolean canHandle(Path file);

	Path mountAndGetRoot(Path file) throws IOException;

	Capabilities capabilities();

	default int priority() {
		return 100;
	}
}
