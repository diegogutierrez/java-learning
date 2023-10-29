package com.learning.chapter9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Arrays.asList("", "").add("");
    List.of("", "").add("");
    List.copyOf(List.of(""));
  }
}
