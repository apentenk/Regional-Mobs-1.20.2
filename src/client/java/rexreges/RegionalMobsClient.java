package rexreges;

import net.fabricmc.api.ClientModInitializer;
import rexreges.render.entity.RegionalEntityRenderers;

public class RegionalMobsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		RegionalItemGroups.addRegionalItemGroups();
		RegionalModelPredicates.registerModelPredicates();
		RegionalEntityRenderers.registerEntityRenderers();
	}
}