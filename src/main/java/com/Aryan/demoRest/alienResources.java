package com.Aryan.demoRest;

import java.util.List;

import jakarta.ws.rs.PathParam;
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
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<alien> getAliens() {
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
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("singleAlien/{id}")
	public alien getAlienById(@PathParam("id") int id){ //  means if the path have some id then the same 
		               // id is used in the all the id variablke 
		 return repo.getAlien(id);
	}

}
