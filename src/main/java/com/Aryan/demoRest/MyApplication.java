package com.Aryan.demoRest;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("/webapi")
public class MyApplication extends ResourceConfig {
	public MyApplication() {
		// Scan the package for resource classes
		packages("com.Aryan.demoRest");
	}
}
