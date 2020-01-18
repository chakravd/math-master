package org.jveda.apps.mathmaster.model;

import java.util.ArrayList;
import java.util.List;

public class Arrange {
  List<Integer> sorted = new ArrayList<>();
  List<Integer> unsorted = new ArrayList<>();

  public List<Integer> getSorted() {
    return sorted;
  }

  public void setSorted(List<Integer> sorted) {
    this.sorted = sorted;
  }

  public List<Integer> getUnsorted() {
    return unsorted;
  }

  public void setUnsorted(List<Integer> unsorted) {
    this.unsorted = unsorted;
  }

}