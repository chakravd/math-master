package org.jveda.apps.mathmaster;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jveda.apps.mathmaster.model.Fact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;

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
}
