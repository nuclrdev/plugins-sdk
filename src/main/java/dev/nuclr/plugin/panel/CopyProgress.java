package dev.nuclr.plugin.panel;

import java.nio.file.Path;

public interface CopyProgress {

    boolean isCancelled();

    default void onItemStarted(Path source, Path target) {
    }

    default void onItemCompleted(Path source, Path target) {
    }
}
