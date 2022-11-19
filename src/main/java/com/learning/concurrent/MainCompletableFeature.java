package com.learning.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainCompletableFeature {

  private static final Logger log = LoggerFactory.getLogger(MainCompletableFeature.class);

  public static void main(String[] args) {
//    simple();
//    completableFutureChain();
    combine();
  }

  private static void combine() {
  }

  private static void simple() {
    CompletableFuture.supplyAsync(() -> {
      log.info("running");
      sleep(3);
      return "theResponse";
    }).join();

    log.info("done");
  }

  private static void completableFutureChain() {
    //best price finder app, from book: Java in action
    //uses different impls to get the prices from different shops
    log.info("triggering tasks");
    Instant start = Instant.now();
    List<CompletableFuture<String>> futures = IntStream.range(0, 10)
        .mapToObj(operand -> buildTaskChain("chain" + operand))
        .collect(Collectors.toList());

    log.info("tasks triggered");
    List<String> responses = futures.stream().map(stringCompletableFuture -> stringCompletableFuture.join()).collect(Collectors.toList());
    log.info("duration: {} secs", Duration.between(start, Instant.now()).getSeconds());
    log.info("response: " + responses);
  }

  private static CompletableFuture<String> buildTaskChain(String chainName) {
    return CompletableFuture.supplyAsync(() -> {//supplyAsync runs on the forkJoin pool
      log.info("chain={}, running task1", chainName);
      sleep(3);
      log.info("chain={}, task1 done", chainName);
      return "theResponse1";
    }).thenApply(s -> { // runs on the same thread as the previous CompletableFuture, this operation doesn't block
      log.info("chain={}, running task2", chainName);
      sleep(3);
      log.info("chain-{}, task2 done", chainName);
      return "chain={} theResponse2";
    }).thenCompose(s -> CompletableFuture.supplyAsync(() -> {//the new CompletableFuture could run on another thread
      log.info("chain={}, running task3", chainName);
      sleep(3);
      log.info("chain={}, task3 done", chainName);
      return "theResponse3";
    }));
  }

  private static void sleep(int secs) {
    try {
      TimeUnit.SECONDS.sleep(secs);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
