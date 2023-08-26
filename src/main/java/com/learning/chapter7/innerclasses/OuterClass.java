package com.learning.chapter7.innerclasses;

//Inner class example
public class OuterClass {

  private int x;

  public class InnerClass1  extends Object implements Cloneable {
    private void method() {
      System.out.println(OuterClass.this.x);
    }
  }

  public static void main(String[] args) {
    OuterClass.InnerClass1 obj = new OuterClass().new InnerClass1();
    obj.method();
  }
}
