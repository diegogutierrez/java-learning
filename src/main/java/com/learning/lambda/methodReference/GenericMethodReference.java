package com.learning.lambda.methodReference;

interface MyOperation<T> {
  void func(T value);
}
class Ops {

  static <T> void execute(T value) {
  }
}
public class GenericMethodReference {

  public static void main(String[] args) {
    run(Ops::execute, 1);
  }

  private static <T> void run(MyOperation<T> f, T value) {
    f.func(value);
  }
}
