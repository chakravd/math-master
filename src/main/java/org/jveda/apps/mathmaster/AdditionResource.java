package org.jveda.apps.mathmaster;

import org.jveda.apps.mathmaster.model.Fact;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/add")
public class AdditionResource {
  private static Map<Integer, List<Fact>> SUMS_MAP = new HashMap<>();
  private static Map<Integer, Integer> SUMS_COUNTRER_MAP = new HashMap<>();

  @GET
  @Path("/random/10")
  @Produces("application/json")
  public Response randomNumberByTen() {
    Random random = new Random();
    Integer randomInt = random.nextInt((90 - 0) + 1) + 0;
    Fact fact = new Fact();
    fact.setFirst(randomInt);
    fact.setSecond(10);
    fact.setResult(randomInt + 10);
    fact.setHelp(build100Table(fact).toString());
    return Response.ok(fact).build();
  }

  @GET
  @Path("/{number}")
  @Produces("application/json")
  public Response randomSum(@PathParam("number") Integer number) {
    loadSumsMap(number);
    Integer noOfFacts = SUMS_MAP.get(number).size();
    Integer counter = SUMS_COUNTRER_MAP.get(number) == null ? 0 : SUMS_COUNTRER_MAP.get(number);
    if (counter == noOfFacts) {
      SUMS_COUNTRER_MAP.put(number, 0);
      counter = 0;
    }
    SUMS_COUNTRER_MAP.put(number, counter + 1);
    List<Fact> facts = SUMS_MAP.get(number);
    Fact fact = facts.get(counter);
    fact.setHelp(buildHelp(fact).toString());
    return Response.ok(fact).build();
  }

  private void loadSumsMap(Integer sum) {
    if (SUMS_MAP.get(sum) == null) {
      List<Fact> facts = new ArrayList<>();
      for (int i = 0; i < sum; i++) {
        Fact fact = new Fact();
        fact.setFirst(i);
        fact.setSecond(sum - i);
        fact.setResult(sum);
        facts.add(fact);
        Collections.shuffle(facts);
        SUMS_MAP.put(sum, facts);
      }
    }
  }

  private StringBuilder buildHelp(Fact fact) {
    StringBuilder html = new StringBuilder();
    html.append("<table class=\"number\">");
    for (int i = 0; i < fact.getResult(); i++) {
      int counter = 0;
      if (i % 10 == 0) {
        html.append("<tr>");
        counter++;
      }
      html.append("<td ");
      if (i >= fact.getFirst()) {
        html.append("style=background-color:cyan;");
      } else {
        html.append("style=background-color:#daf7a6;");
      }
      html.append(">");
      html.append(i + 1);
      html.append("</td>");
      if (counter == 10) {
        counter = 0;
        html.append("</tr>");
      }
    }
    html.append("</table>");
    return html;
  }

  private StringBuilder build100Table(Fact fact) {
    StringBuilder html = new StringBuilder();
    html.append("<table class=\"number\">");
    for (int i = 0; i < 100; i++) {
      int counter = 0;
      if (i % 10 == 0) {
        html.append("<tr>");
        counter++;
      }
      html.append("<td ");
      if (i + 1 == fact.getFirst()) {
        html.append("style=background-color:#daf7a6;");
      } else if (i + 1 == fact.getResult()) {
        html.append("style=background-color:cyan;");
      }
      html.append(">");
      html.append(i + 1);
      html.append("</td>");
      if (counter == 10) {
        counter = 0;
        html.append("</tr>");
      }
    }
    html.append("</table>");
    return html;
  }
}
