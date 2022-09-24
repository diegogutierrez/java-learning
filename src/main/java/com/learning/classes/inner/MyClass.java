package com.learning.classes.inner;

public class MyClass {
  int anInt;

  public void methodA() {
    MyInnerClass aClass = new MyInnerClass();
    aClass.b = 1;
    aClass.methodB();
  }

  public class MyInnerClass {
    private int b;

    private void methodB() {
    }
  }

  public static void main(String[] args) {
    MyClass aClass = new MyClass();
    aClass.methodA();
    System.out.println("a");
  }
}
