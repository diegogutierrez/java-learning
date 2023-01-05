package com.learning.practice;

import java.time.DayOfWeek;

public class PatternMatching {

  public static void main(String[] args) {
    ifExample();
//    instanceOf();
  }

  private static void ifExample() {
    Number n = 1;
    if (n instanceof Integer a) {
      System.out.println("integer " + a);
    } else {
      System.out.println("unknown " + n);
    }

    if (n instanceof Integer a && a > 10) {
      System.out.println("integer > 10 " + n);
    } else if (n instanceof Integer a && a < 10) {
      System.out.println("integer < 10 " + n);
    } else {
      System.out.printf("unknown " + n);
    }

    if (! (n instanceof Integer data)) {
      System.out.println("not integer " + n);
      return;
    }

    Object o = "asd";
    if (o instanceof String s && s.isEmpty()) {
      System.out.println("empty string");
    } else {
      System.out.println("not string");
    }
  }

  private static void instanceOf() {
    Number n = 3;
    if (n instanceof Integer data && data > 1) {
      System.out.println("integer found");
    } else {
      System.out.println("nothing found");
    }
  }
}
