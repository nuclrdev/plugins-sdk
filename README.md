# Nuclr Commander Platform SDK 🔌

Java SDK for building plugins for [Nuclr Commander](https://github.com/nuclrdev/commander), a cross-platform dual-pane file manager. 🗂️

This repository publishes the `dev.nuclr:platform-sdk` artifact used by Nuclr Commander plugins and is available from Maven Central.

## Requirements ✅

- Java 21+
- Maven 3.9+

## Maven Dependency 📦

Add the SDK to your plugin project:

```xml
<dependency>
    <groupId>dev.nuclr</groupId>
    <artifactId>platform-sdk</artifactId>
    <version>3.0.0</version>
</dependency>
```

Find the latest version here:

https://central.sonatype.com/artifact/dev.nuclr/platform-sdk

## What The SDK Provides 🚀

- `BasePlugin` for shared plugin metadata and lifecycle
- `QuickViewNuclrPlugin` for quick-view providers
- `FilePanelNuclrPlugin` for file panel providers
- `NuclrPluginContext` for access to the event bus, theme, and settings
- `NuclrResourcePath` and `NuclrMenuResource` as common plugin model types
- `NuclrEventBus` for cross-plugin and platform event messaging

## Plugin Types 🧩

The SDK currently exposes two plugin shapes:

- `QuickViewNuclrPlugin`
  - Returns a Swing `JComponent` from `panel()`
  - Uses `supports(...)` to declare whether it can preview a resource
  - Uses `priority()` to break ties when multiple viewers match
  - Uses `openResource(...)` to load or refresh the preview
- `FilePanelNuclrPlugin`
  - Exposes roots through `getPluginRoots()`
  - Declares whether it is a `Viewer` or `Editor` through `role()`
  - Uses `openResource(...)` to open or refresh the active location
  - Can contribute resource-specific menu items through `menuItems(...)`

Both plugin types extend `BasePlugin`, which provides:

- identity and metadata such as `id()`, `name()`, `version()`, `author()`, `website()`, `pageUrl()`, and `docUrl()`
- lifecycle hooks such as `preinit(...)`, `init()`, `updateTheme(...)`, and `unload()`
- focus callbacks through `onFocusGained()` and `onFocusLost()`
- instance control through `singleton()` and `uuid()`

## Core Model Types 🧱

- `NuclrResourcePath`
  - Wraps a `java.nio.file.Path`
  - Carries metadata such as `name`, `extension`, `sizeBytes`, `mimeType`, `uuid`, and custom `metadata`
- `NuclrMenuResource`
  - Describes menu contributions for file panels
- `NuclrPluginContext`
  - Provides `getEventBus()`, `getTheme()`, and `getSettings()`

## Minimal Quick View Example 💡

```java
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JComponent;
import javax.swing.JPanel;

import dev.nuclr.platform.NuclrThemeScheme;
import dev.nuclr.platform.plugin.BasePlugin;
import dev.nuclr.platform.plugin.NuclrPluginContext;
import dev.nuclr.platform.plugin.NuclrResourcePath;
import dev.nuclr.platform.plugin.QuickViewNuclrPlugin;

public final class MyQuickViewPlugin implements QuickViewNuclrPlugin {

    private final JPanel panel = new JPanel();
    private boolean focused;
    private NuclrResourcePath currentResource;
    private String uuid = java.util.UUID.randomUUID().toString();

    @Override
    public String id() { return "my-quick-view"; }

    @Override
    public String name() { return "My Quick View"; }

    @Override
    public String version() { return "1.0.0"; }

    @Override
    public String description() { return "Example quick view plugin."; }

    @Override
    public String author() { return "Your Name"; }

    @Override
    public String license() { return "Apache-2.0"; }

    @Override
    public String website() { return "https://example.com"; }

    @Override
    public String pageUrl() { return "https://example.com/plugins/my-quick-view"; }

    @Override
    public String docUrl() { return "https://example.com/plugins/my-quick-view/docs"; }

    @Override
    public BasePlugin.Developer type() { return BasePlugin.Developer.Community; }

    @Override
    public boolean onFocusGained() {
        focused = true;
        return true;
    }

    @Override
    public void onFocusLost() {
        focused = false;
    }

    @Override
    public boolean isFocused() { return focused; }

    @Override
    public void preinit(NuclrPluginContext context) {
    }

    @Override
    public void init() {
    }

    @Override
    public void updateTheme(NuclrThemeScheme themeScheme) {
    }

    @Override
    public JComponent panel() { return panel; }

    @Override
    public boolean supports(NuclrResourcePath resource) {
        return "txt".equalsIgnoreCase(resource.getExtension());
    }

    @Override
    public int priority() { return 100; }

    @Override
    public boolean openResource(NuclrResourcePath resource, AtomicBoolean cancelled) {
        currentResource = resource;
        return true;
    }

    @Override
    public NuclrResourcePath getCurrentResource() { return currentResource; }

    @Override
    public String uuid() { return uuid; }

    @Override
    public void unload() {
    }
}
```

## Packaging 📦

Commander discovers plugins from your packaged metadata and classes. In practice, a plugin distribution should include:

- your compiled plugin classes
- a `plugin.json` manifest
- any runtime dependencies or assets the plugin needs

## License 📄

Apache-2.0
