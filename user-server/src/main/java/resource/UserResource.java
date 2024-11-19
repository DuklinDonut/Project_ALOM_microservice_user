package resource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import model.User;
import service.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    private final UserService userService = new UserService();

    @POST
    @Path("/add")
    public Response addUser(@QueryParam("username") String username, @QueryParam("password") String password) {
        try {
            User user = userService.addUser(username, password);
            return Response.ok(user).build();
        } catch (IllegalArgumentException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET
    @Path("/recent")
    public Response getRecentUsers(@QueryParam("after") String after) {
        try {
            LocalDateTime date = LocalDateTime.parse(after, DateTimeFormatter.ISO_DATE_TIME);
            List<User> recentUsers = userService.getUsersCreatedAfter(date);
            return Response.ok(recentUsers).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid date format. Use ISO_DATE_TIME.").build();
        }
    }
}
