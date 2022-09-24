package com.learning.lambda.methodReference;

interface MyFunc {
  int run(int i);
}
public class StaticMethodReference {

  public static int staticMeth(int i) {
    return i;
  }

  public static void exec(MyFunc myFunc, int i) {
    myFunc.run(i);
  }

  public static void main(String[] args) {
    exec(StaticMethodReference::staticMeth, 1);
  }
}
