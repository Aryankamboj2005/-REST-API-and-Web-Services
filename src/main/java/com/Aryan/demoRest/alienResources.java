package com.Aryan.demoRest;

import java.util.Arrays;
import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("alien")
public class alienResources {

	@GET
	@Produces(MediaType.APPLICATION_XHTML_XML)
	public  List<alien> getAlien() {
		alien a1 = new alien();
		a1.setMobile(90);
		a1.setName("Aryan");
		alien a2 = new alien();
		a2.setMobile(21);
		a2.setName("Kamboj");
		
		
		List<alien> aliens = Arrays.asList(a1,a2);
		return aliens;
				
		
	}

}
