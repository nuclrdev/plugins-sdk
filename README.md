# Nuclr Commander Platform SDK

Java SDK for building plugins for [Nuclr Commander](https://github.com/nuclrdev/nuclr-commander), a cross-platform dual-pane file manager.

This repository publishes the `dev.nuclr:platform-sdk` artifact used by Nuclr Commander plugins and is available from Maven Central.

## Requirements

- Java 21+
- Maven 3.9+

## Build

For a normal local build:

```bash
mvn -DskipTests compile
```

For a packaged build without GPG signing:

```bash
mvn -DskipTests -Dgpg.skip=true package
```

Publishing builds use GPG signing and the Sonatype Central publishing plugin configured in [pom.xml](/C:/nuclr/sources/platform-sdk/pom.xml).

## Maven Dependency

Add the SDK to your plugin project:

```xml
<dependency>
    <groupId>dev.nuclr</groupId>
    <artifactId>platform-sdk</artifactId>
    <version>2.0.1</version>
</dependency>
```

## What The SDK Provides

- `@NuclrPlugin` to mark plugin entry points
- `ResourceContentPlugin` for content viewers and editors
- `NuclrPluginContext` for access to the event bus, settings, theme data, config, and Jackson `ObjectMapper`
- `PluginPathResource` and `MenuResource` model types used by plugins

## Plugin Shape

Typical plugins implement `dev.nuclr.plugin.ResourceContentPlugin`, expose a Swing `JComponent` via `panel()`, and handle file/resource lifecycle through:

- `load(...)`
- `openResource(...)`
- `closeResource()`
- `unload()`

Plugins can also contribute resource-specific menu items and custom resources for drive or provider views.

## Minimal Example

```java
@NuclrPlugin
public final class MyPlugin implements ResourceContentPlugin {

    // Implement panel(), supports(...), load(...), openResource(...),
    // closeResource(), unload(), and priority().
}
```

Commander discovers plugin metadata from `plugin.json`. Package that manifest together with your plugin classes and any runtime dependencies required by the plugin.

## License

Apache-2.0
