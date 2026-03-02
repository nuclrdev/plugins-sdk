package dev.nuclr.plugin.panel;

public record CopyOptions(
        CollisionAction collisionAction,
        boolean recursive,
        String targetNameOverride) {
}
