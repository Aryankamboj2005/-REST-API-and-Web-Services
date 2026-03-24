package com.Aryan.demoRest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("alien")
public class alienResources {

	@GET
	@Produces(MediaType.APPLICATION_XHTML_XML)
	public alien getAlien() {
		alien a1 = new alien();
		a1.setMobile(90);
		a1.setName("Aryan");
		return a1;
	}

}
