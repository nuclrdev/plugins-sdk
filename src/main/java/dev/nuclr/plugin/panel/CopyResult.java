package dev.nuclr.plugin.panel;

import java.util.List;

public record CopyResult(
        CopyStatus status,
        int copiedItems,
        List<String> errors,
        String userMessage) {

    public static CopyResult success(int copiedItems) {
        return new CopyResult(CopyStatus.SUCCESS, copiedItems, List.of(), null);
    }

    public static CopyResult partial(int copiedItems, List<String> errors) {
        return new CopyResult(CopyStatus.PARTIAL_SUCCESS, copiedItems, List.copyOf(errors), null);
    }

    public static CopyResult cancelled(int copiedItems, List<String> errors) {
        return new CopyResult(CopyStatus.CANCELLED, copiedItems, List.copyOf(errors), "Copy cancelled.");
    }

    public static CopyResult failed(String userMessage, List<String> errors) {
        return new CopyResult(CopyStatus.FAILED, 0, List.copyOf(errors), userMessage);
    }

    public static CopyResult notSupported(String userMessage) {
        return new CopyResult(CopyStatus.NOT_SUPPORTED, 0, List.of(), userMessage);
    }
}
