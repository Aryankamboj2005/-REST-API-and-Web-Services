
package com.Aryan.demoRest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/** 
 * Example resource class hosted at the URI path "/myresource"
 */
@Path("myresource")
public class MyResource {
    
    /** 
     * Method processing HTTP GET requests, producing "text/plain" MIME media type.
     * @return String that will be sent back as a response of type "text/plain".
     */
    @GET 
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Hi there! The Jersey resource is working correctly.";
    }
}
