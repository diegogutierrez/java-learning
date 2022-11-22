package com.learning.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Dishes {

  private static final Logger log = LoggerFactory.getLogger(Dishes.class);

  public static void main(String[] args) {
//    flatMap();
    Scanner scanner = new Scanner(System.in);
    int op = -1;
    do {
      op = scanner.nextInt();
      if (op == 1) {
        create();
        System.out.println("created");
      } else {
        System.out.println("invalid operation");
      }
    } while (op != 0);
  }

  private static Dish create() {
    return new Dish("asd", false, 111, Dish.Type.FISH);
  }

  private static void flatMap() {
    List<List<String>> l = List.of(
        List.of("a", "b", "c"),
        List.of("d", "e", "f")
    );

    List<String> result = l.stream()
        .flatMap(strings -> strings.stream())
        .collect(Collectors.toList());
    log.info("all letters: {}", result);

    //produce pairs
    List<String> a = List.of("1", "2", "3");
    List<String> b = List.of("5", "6");

    List<String> result2 = a.stream()
        .flatMap(s -> b.stream()
            .map(s1 -> s + s1))
        .collect(Collectors.toList());
    log.info("pairs: {}", result2);

  }

  private static final List<Dish> menu = Arrays.asList(
      new Dish("pork", false, 800, Dish.Type.MEAT),
      new Dish("beef", false, 700, Dish.Type.MEAT),
      new Dish("chicken", false, 400, Dish.Type.MEAT),
      new Dish("french fries", true, 530, Dish.Type.OTHER),
      new Dish("rice", true, 350, Dish.Type.OTHER),
      new Dish("season fruit", true, 120, Dish.Type.OTHER),
      new Dish("pizza", true, 550, Dish.Type.OTHER),
      new Dish("prawns", false, 300, Dish.Type.FISH),
      new Dish("salmon", false, 450, Dish.Type.FISH) );

  public static class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;
    public Dish(String name, boolean vegetarian, int calories, Type type) {
      this.name = name;
      this.vegetarian = vegetarian;
      this.calories = calories;
      this.type = type;
    }
    public String getName() {
      return name;
    }
    public boolean isVegetarian() {
      return vegetarian;
    }
    public int getCalories() {
      return calories;
    }
    public Type getType() {
      return type;
    }
    @Override
    public String toString() {
      return name;
    }
    public enum Type { MEAT, FISH, OTHER }
  }
}
