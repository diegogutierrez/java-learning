package com.learning.concurrent;

import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Phaser;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  private String name;

  public static void main(String[] args) throws InterruptedException {
//    semaphore();
//    countDownLatch();
//    cyclicBarrier();
//    exchanger();
//    phaser();
  }

  private static void phaser() throws InterruptedException {
    Phaser phaser = new Phaser();
    ExecutorService service = Executors.newFixedThreadPool(3);
    service.execute(new PhaserThread(phaser, 5000));
    service.execute(new PhaserThread(phaser, 10000));
    service.execute(new PhaserThread(phaser, 15000));
    service.shutdown();
    service.awaitTermination(60, TimeUnit.SECONDS);
    log("done");
  }

  private static class PhaserThread implements Runnable {
    private final Phaser phaser;
    private final int taskTime;

    private PhaserThread(Phaser phaser, int taskTime) {
      this.phaser = phaser;
      this.taskTime = taskTime;
      phaser.register();
    }

    @Override
    public void run() {
      log("running task1...");
      try {
        Thread.sleep(taskTime);
        log("task1 completed");
        phaser.arriveAndAwaitAdvance();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      log("running task2...");
      try {
        Thread.sleep(taskTime);
        log("task2 completed");
        phaser.arriveAndAwaitAdvance();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static void exchanger() throws InterruptedException {
    Exchanger<String> exchanger = new Exchanger<>();
    ExecutorService service = Executors.newFixedThreadPool(2);
    service.submit(() -> {
      try {
        log("producing data...");
        Thread.sleep(5000);
        String res = exchanger.exchange("the data");
        log("data emitted, res=" + res);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    service.submit(() -> {
      try {
        log("waiting for data...");
        Thread.sleep(1000);
        String res = exchanger.exchange("asd");
        log("data consumed, res=" + res);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    service.shutdown();
    service.awaitTermination(20, TimeUnit.SECONDS);
    log("done");
  }

  private static void cyclicBarrier() throws InterruptedException {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> log("barrier reached"));
    ExecutorService service = Executors.newFixedThreadPool(10);
    service.submit(new CBThread(cyclicBarrier, "A", 1000));
    service.submit(new CBThread(cyclicBarrier, "B", 2000));
    service.submit(new CBThread(cyclicBarrier, "C", 3000));
    service.shutdown();
    service.awaitTermination(60, TimeUnit.SECONDS);
    log("done");
  }

  private static class CBThread implements Runnable {

    private final CyclicBarrier cyclicBarrier;
    private final String message;
    private final int sleep;

    public CBThread(CyclicBarrier cyclicBarrier, String message, int sleep) {
      this.cyclicBarrier = cyclicBarrier;
      this.message = message;
      this.sleep = sleep;
    }

    @Override
    public void run() {
      for (int i = 0; i < 5; i++) {
        try {
          Thread.sleep(sleep);
          log("task done: "  + message);
          cyclicBarrier.await();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
          throw new RuntimeException(e);
        }
      }
    }
  }

  private static void countDownLatch() {
    CountDownLatch countDownLatch = new CountDownLatch(5);
    ExecutorService service = Executors.newFixedThreadPool(5);
    IntStream.range(0, 5).forEach(value -> service.submit(() -> {
      log("running");
      countDownLatch.countDown();
      log("done");
    }));

    try {
      countDownLatch.await(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log("final count: " + countDownLatch.getCount());
  }

  private static void semaphore() throws InterruptedException {
    MyCounter myCounter = new MyCounter();
    Semaphore semaphore = new Semaphore(1);
    ExecutorService service = Executors.newFixedThreadPool(10);
    IntStream.range(0,10).forEach(value -> service.submit(new SemaphoreThread(semaphore, myCounter)));
    service.shutdown();
    service.awaitTermination(10, TimeUnit.SECONDS);
    log("final counter: " + myCounter.getCounter());
  }

  private static class MyCounter {
    private int counter = 0;

    public int getCounter() {
      log("returning counter");
      return counter;
    }

    public void setCounter(int counter) {
      this.counter = counter;
      log("counter updated");
    }
  }

  private static class SemaphoreThread implements Runnable {

    private final Semaphore semaphore;
    private final MyCounter myCounter;

    public SemaphoreThread(Semaphore semaphore, MyCounter myCounter) {
      this.semaphore = semaphore;
      this.myCounter = myCounter;
    }

    @Override
    public void run() {
      try {
        log("waiting for semaphore acquire");
        semaphore.acquire();
        log("semaphore acquired");
        int curr = myCounter.getCounter();
        myCounter.setCounter(++curr);
        log("updated counter");
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        e.printStackTrace();
      } finally {
        log("releasing semaphore");
        semaphore.release();
      }
    }
  }

  private static void log(String message) {
    System.out.println(Thread.currentThread().getName()  + " - " +  message);
  }
}
