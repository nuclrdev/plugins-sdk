package dev.nuclr.plugin.panel;

import java.nio.file.Path;

/**
 * A navigable root location offered by a {@link FilePanelProvider}.
 *
 * @param displayName label shown in the drive-selector UI (e.g. "C:\", "sftp://server/")
 * @param path        NIO.2 {@link Path} to navigate to when this root is selected
 */
public record PanelRoot(String displayName, Path path) {}
