package org.jveda.apps.mathmaster;

import org.jveda.apps.mathmaster.model.Fact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.Random;

@Path("/subtract")
public class SubtractionResource {
  @GET
  @Path("/random/10")
  @Produces("application/json")
  public Response randomNumberByTen() {
    Random random = new Random();
    Integer randomInt = random.nextInt((100 - 10) + 1) + 10;
    Fact fact = new Fact();
    fact.setFirst(randomInt);
    fact.setSecond(10);
    fact.setResult(randomInt - 10);
    return Response.ok(fact).build();
  }
}
