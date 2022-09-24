package com.learning.lambda;

public class SAM {

  @FunctionalInterface
  interface MyI {
    int get();

    default int defaultGet() {
      return 1;
    }

    private int getPrivate() {
      return 2;
    }
  }

  public static int sum(MyI i) {
    return i.get();
  }

  public static void main(String[] args) {
    sum(() -> 1);
  }
}
