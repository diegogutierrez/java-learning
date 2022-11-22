package com.learning.stream;

import java.util.stream.Stream;

public class ParallelMain {

  public static void main(String[] args) {
    parallelSum(10);
  }

  private static void parallelSum(int top) {
    int sum = Stream.iterate(0, integer -> integer + 1)
        .limit(top)
        .parallel()
        .reduce(0, Integer::sum);
    System.out.println(sum);
  }
}
