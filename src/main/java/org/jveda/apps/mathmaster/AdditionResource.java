package org.jveda.apps.mathmaster;


import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

@Path("/add")
public class AdditionResource {
    @GET
    @Path("/random/10")
    @Produces("text/plain")
    public Response randomNumberByTen() {
        Random random = new Random();
        Integer randomInt = random.nextInt((90 - 0) + 1) + 0;
        return Response.ok(randomInt + " + " + 10 + " =").build();
    }
}
