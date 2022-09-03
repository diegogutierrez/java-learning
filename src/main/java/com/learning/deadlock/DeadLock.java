package com.learning.deadlock;

class A {
  synchronized void foo(B b) {
    String tName = Thread.currentThread().getName();
    System.out.println(tName + " entered A.foo");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("A got interrupted");
    }
    System.out.println(tName + " trying to call B.last()");
    b.last();
  }

  public synchronized void last() {
    System.out.println("inside A.last");
  }
}

class B {
  synchronized void bar(A a) {
    String tName = Thread.currentThread().getName();
    System.out.println(tName + " entered B.bar");
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("B got interrupted");
    }
    System.out.println(tName + " trying to call A.last()");
    a.last();
  }

  public synchronized void last() {
    System.out.println("inside A.last");
  }
}

public class DeadLock implements Runnable {
  A a = new A();
  B b = new B();
  Thread thread;

  public DeadLock() {
    Thread.currentThread().setName("MainThread");
    thread = new Thread(this, "racingThread");
  }

  public void deadlockStart() {
    thread.start();
    a.foo(b);
    System.out.println("back to main thread");
  }

  @Override
  public void run() {
    b.bar(a);
    System.out.println("back in other thread");
  }

  public static void main(String[] args) {
    DeadLock deadLock = new DeadLock();
    deadLock.deadlockStart();
  }
}
