package alom.server.resource;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/user")
public class UserResource {

    @GET
    @Path("/test")
    public String testEndpoint() {
        return "User server is running!";
    }
}
