package dev.nuclr.plugin;

public interface EditorViewProvider extends ViewProvider {

	/** True if the content has unsaved modifications. */
	boolean isDirty();

	/** Persist changes. The item passed to open() must be an EditableItem. */
	void save() throws Exception;

}
