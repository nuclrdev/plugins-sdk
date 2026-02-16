# Nuclr Commander — Plugin SDK

Plugin development SDK for [Nuclr Commander](https://github.com/nicholasgasior/nuclr-commander), a cross-platform dual-pane file manager.

> **Note:** This project is under active development. APIs may change without notice.

## Requirements

- Java 21+
- Maven 3.9+

## Build

```bash
mvn clean install
```

This installs the SDK to your local Maven repository so plugins can depend on it.

## Usage

Implement `QuickViewProvider` (or `EditorViewProvider`) to add file preview / editing support for new formats. Package your plugin as a signed ZIP with a `plugin.json` manifest — see the core plugins for a working example.

## License

Apache-2.0