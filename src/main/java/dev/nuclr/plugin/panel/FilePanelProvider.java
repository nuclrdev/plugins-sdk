package dev.nuclr.plugin.panel;

import java.util.List;

/**
 * Plugin interface for filesystem backend providers.
 *
 * <p>Implementations can be contributed by external plugins (SFTP, SMB, cloud storage, etc.)
 * or built into the commander (local filesystem, ZIP archives).
 *
 * <p>A provider supplies a list of {@link PanelRoot} entries that appear in the
 * drive-selector popup and serve as navigation entry points for the file panel.
 * Navigation itself is performed via standard NIO.2 {@link java.nio.file.Path} and
 * {@link java.nio.file.Files} APIs.
 *
 * <h3>Lifecycle</h3>
 * Built-in providers are Spring beans discovered at startup.
 * Plugin-contributed providers are instantiated by the plugin loader and
 * registered with {@code FilePanelProviderRegistry} at runtime.
 *
 * <h3>Example implementations</h3>
 * <ul>
 *   <li>Local filesystem — returns one {@link PanelRoot} per drive letter / mount point.
 *   <li>SFTP — establishes a connection and returns a root backed by an NIO.2 SFTP filesystem.
 *   <li>Cloud storage — maps a bucket as a root backed by a custom NIO.2 FileSystemProvider.
 * </ul>
 */
public interface FilePanelProvider {

    /**
     * Stable, unique identifier for this provider (e.g. {@code "local"}, {@code "sftp"},
     * {@code "s3"}).  Used internally for logging and deduplication.
     */
    String id();

    /** Human-readable name shown in the UI. */
    String displayName();

    /**
     * Returns all roots this provider currently makes available.
     *
     * <p>May return an empty list if the provider has no active connections or roots
     * (e.g. an SFTP plugin with no configured servers).
     */
    List<PanelRoot> roots();

    /**
     * Sort priority used when displaying roots from multiple providers.
     * Lower values appear first. Defaults to {@code 100}.
     */
    default int priority() {
        return 100;
    }
}
