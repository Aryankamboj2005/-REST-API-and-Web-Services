package com.Aryan.demoRest;

import java.util.List;

import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
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
    @Path("update") // No ID or Name in the URL
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON}) // use to get the data from the 
                                                                          // postman (API)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public alien updateAlien(alien a1) { // It gets everything from the Body here
        
        // 1. Check if the alien in the Body already exists
        alien a = repo.getAlien(a1.getMobile());
        
        if (a.getMobile() == 0) {
            // 2. Add if new
            repo.create(a1);
        } else {
            // 3. Update if exists
            repo.update(a1);
        }
        return a1;
    }
    
    @DELETE
    @Path("delete") // No ID or Name in the URL
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
                                                                          // postman (API)
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public alien DeleteAlien(alien a1) { // It gets everything from the Body here
        
        // 1. Check if the alien in the Body already exists
        alien a = repo.getAlien(a1.getMobile());
        
        if (a.getMobile() == 0) {
            // 2. returning the null data 
            return a1;
        } else {
            // 3. deleting the data if exist
            repo.delete(a1);
        }
        return a1;
    }

    
	// New method for DELETING data directly through the URL
	@DELETE
	@Path("deleteAlien/{id}") 
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public alien deleteAlienURL(@PathParam("id") int id) {
		
		alien a = repo.getAlien(id);
		
		if (a.getMobile() != 0) {
			repo.delete(a);
		}
		
		return a;
	}

	}
