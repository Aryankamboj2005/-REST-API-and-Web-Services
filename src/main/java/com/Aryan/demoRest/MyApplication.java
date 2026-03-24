package com.Aryan.demoRest;

import org.glassfish.jersey.server.ResourceConfig;


public class MyApplication extends ResourceConfig {
	public MyApplication() {
		// Scan the package for resource classes
		packages("com.Aryan.demoRest");
		register(alienResources.class);
		register(MyResource.class);
	}
}
