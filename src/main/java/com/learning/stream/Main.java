package com.learning.stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {

  private static final Logger log = LoggerFactory.getLogger(Main.class);

  public static void main(String[] args) {
//    reduce();
//    collect();
//    parallelStream();
  }

  private static void parallelStream() {
    List<Integer> l = List.of(1, 2, 3, 4);
//    List<Integer> result = l.parallelStream()
//        .map(integer -> {
//          log.info("transforming {}", integer);
//          return integer + 1;
//        })
//        .collect(Collectors.toList());
//    log.info("list: {}", result);

    l.spliterator().forEachRemaining(integer -> {
      log.info("processing {}", integer);
    });
  }

  private static void collect() {
    List<Integer> l = List.of(1, 2, 3, 4);
    List<Integer> result = l.stream()
        .collect(() -> new ArrayList<Integer>(),
            (objects, integer) -> objects.add(integer),
            (integers, integers2) -> integers.addAll(integers2));

    System.out.println(result);
  }

  private static void reduce() {
    List<Integer> l = List.of(1, 2, 3);
//    Integer result = l.stream()
//        .reduce(0, (integer, integer2) -> integer + integer2);
//    System.out.println(result);

    //reduce with an accumulator and combiner
    Integer result2 = l.stream()
        .reduce(0,
            (accumulatedValue, currentValue) -> accumulatedValue + currentValue,
            (accumulatedValue, currentValue) -> accumulatedValue + currentValue);
    System.out.println(result2);

  }
}
