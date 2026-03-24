package com.Aryan.demoRest;

import java.util.List;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("alien")
public class alienResources {
      
	public alienReporisatory repo = new alienReporisatory();
	
	@GET
	@Produces(MediaType.APPLICATION_XHTML_XML)
	public List<alien> getAlien() {
		return repo.getAliens();
	}

	@POST
	@Path("create") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.APPLICATION_XML) 
	public alien createAlien(alien a1) {
		repo.create(a1);
		return a1;
	}

}
