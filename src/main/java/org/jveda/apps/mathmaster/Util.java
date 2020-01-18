package org.jveda.apps.mathmaster;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.jveda.apps.mathmaster.model.Arrange;
import org.jveda.apps.mathmaster.model.Fact;

public class Util {
  private Util() {
  }

  public static StringBuilder build100Table(Fact fact) {
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

  public static StringBuilder buildHelp(Fact fact) {
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

  public static Arrange buildArrange(List<Integer> numbers) {
    Arrange arrange = new Arrange();
    arrange.setUnsorted(numbers);
    Collections.sort(numbers);
    arrange.setSorted(numbers);
    return arrange;
  }
}