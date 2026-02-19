package dev.nuclr.plugin;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of = "id")
public final class NuclrPlugin {

	private PluginInfo info;

	private final List<ViewProvider> viewProviders = new ArrayList<>();

	public void unload() {
		viewProviders.forEach(ViewProvider::unload);
	}

}
