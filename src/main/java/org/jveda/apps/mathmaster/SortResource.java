package org.jveda.apps.mathmaster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/sort")
public class SortResource {
  private static final Integer NO_OF_RANDOM_NUMBERS = 6;
  private static final List<Integer> HUNDREDS_LIST = new ArrayList<>();
  static {
    for (int i = 0; i <= 100; i++) {
      HUNDREDS_LIST.add(i);
    }
  }

  @GET
  @Path("/ascend")
  @Produces("application/json")
  public Response ascendingOrder() {
    Collections.shuffle(HUNDREDS_LIST);
    List<Integer> randomNumbers = new ArrayList<>();
    for (int i = 0; i < NO_OF_RANDOM_NUMBERS; i++) {
      randomNumbers.add(HUNDREDS_LIST.get(i));
    }
    return Response.ok(Util.buildArrange(randomNumbers)).build();
  }

  @GET
  @Path("/descend")
  @Produces("application/json")
  public Response descendingOrder() {

    return Response.ok(null).build();
  }
}