package com.Aryan.demoRest;

import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("alien")
public class alienResources {
      
	public dataBaseAlienRepo repo = new dataBaseAlienRepo();
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<alien> getAliens() {
		return repo.getAliens();
	}

	// Method for POSTing data via Postman (supports both XML and JSON body)
	@POST
	@Path("create") 
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // Added JSON support for Postman
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) 
	public alien createAlien(alien a1) {
		repo.create(a1);
		return a1;
	}

	// Method for GETting data by ID (Receive Data)
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("singleAlien/{id}")
	public alien getAlienById(@PathParam("id") int id){ 
		 return repo.getAlien(id);
	}

	// Method for Sending data directly via the URL (e.g., in a browser)
	@GET
	@Path("addAlien/{id}/{name}") // Send data via URL: /addAlien/102/Rahul
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public alien addAlien(@PathParam("id") int id, @PathParam("name") String name) {
		alien a = new alien();
		a.setMobile(id);
		a.setName(name);
		repo.create(a);
		return a;
	}
	@PUT
	@Path("updateAlien/{id}/{name}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public alien updateAlien(@PathParam("id") int id, @PathParam("name") String name) {
		// 1. First, check if the alien already exists in the database
		alien a = repo.getAlien(id);
		
		if (a.getMobile() == 0) {
			// 2. If it DOES NOT exist, create a new one
			a.setMobile(id);
			a.setName(name);
			repo.create(a);
		} else {
			// 3. If it DOES exist, just update the name
			a.setName(name);
			repo.update(a);
		}
		return a;
	}
 }
