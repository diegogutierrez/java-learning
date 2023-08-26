package com.learning.chapter7.innerclasses;

//Local class
public class OuterClass3 {

  private String field;

  private String outerMethod() {
    return "asd";
  }

  private int method() {
    final int var1 = 1;
    int var2 = 2;
    /*abstract/final*/ class LocalClass extends Object implements Cloneable {
      public void innerMethod() {
        System.out.println("outer field: " + field);
        System.out.println("final variable: " + var1);
        System.out.println("effective final variable: " + var2);
        System.out.println("outer method: " + outerMethod());
      }
    }

    LocalClass aClass = new LocalClass();
    return 0;
  }
}
