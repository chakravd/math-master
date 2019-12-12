package org.jveda.apps.mathmaster;

import org.jveda.apps.mathmaster.model.Fact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Path("/subtract")
public class SubtractionResource {
  private static Map<Integer, List<Fact>> DIFFS_MAP = new HashMap<>();
  private static Map<Integer, Integer> DIFFS_COUNTRER_MAP = new HashMap<>();

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

  @GET
  @Path("/{number}")
  @Produces("application/json")
  public Response randomSum(@PathParam("number") Integer number) {
    loadDiffsMap(number);
    Integer noOfFacts = DIFFS_MAP.get(number).size();
    Integer counter = DIFFS_COUNTRER_MAP.get(number) == null ? 0 : DIFFS_COUNTRER_MAP.get(number);
    if (counter == noOfFacts) {
      DIFFS_COUNTRER_MAP.put(number, 0);
      counter = 0;
    }
    DIFFS_COUNTRER_MAP.put(number, counter + 1);
    List<Fact> facts = DIFFS_MAP.get(number);
    Fact fact = facts.get(counter);
    fact.setHelp(Util.buildHelp(fact).toString());
    return Response.ok(fact).build();
  }

  private void loadDiffsMap(Integer diff) {
    if (DIFFS_MAP.get(diff) == null) {
      List<Fact> facts = new ArrayList<>();
      for (int i = diff; i < 0; i--) {
        if(i < diff) {
          break;
        }
        Fact fact = new Fact();
        fact.setFirst(i);
        fact.setSecond(i - diff);
        fact.setResult(diff);
        facts.add(fact);
        Collections.shuffle(facts);
        DIFFS_MAP.put(diff, facts);
      }
    }
  }
}
