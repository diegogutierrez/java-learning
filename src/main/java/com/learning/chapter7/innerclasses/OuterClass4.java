package com.learning.chapter7.innerclasses;

//anonymous class
public class OuterClass4 {
  private String field;
  private String method() {
    return "asd";
  }
  interface TheInterface {
    int add();
  }
  abstract class TheAbstractClass {
    abstract int add2();
  }
  public void m() {
    TheInterface theInterface = new TheInterface() {
      @Override
      public int add() {
        System.out.println(field);
        System.out.println(method());
        return 0;
      }
    };
    TheAbstractClass theAbstractClass = new TheAbstractClass() {
      @Override
      int add2() {
        System.out.println(field);
        System.out.println(method());
        return 0;
      }
    };
  }
}
