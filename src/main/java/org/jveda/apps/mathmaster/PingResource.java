package org.jveda.apps.mathmaster;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingResource {
  @GET
  @Produces("text/plain")
  public Response doGet() {
    return Response.ok("Welocme to Math Master!").build();
  }
}
