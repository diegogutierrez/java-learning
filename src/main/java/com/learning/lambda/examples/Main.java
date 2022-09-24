package com.learning.lambda.examples;

import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Apple> apples = List.of(new Apple(1), new Apple(2));

    /*
    T  -> Apple
    U -> integer
     */
    apples.sort(Comparator.comparing(Apple::getWeight));
  }
}
