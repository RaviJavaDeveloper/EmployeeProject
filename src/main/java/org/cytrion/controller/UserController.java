
package org.cytrion.controller;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author Ravi Kumar
 */
@Path("/rest")
public class UserController{
    
    @GET @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello";
    }
}
