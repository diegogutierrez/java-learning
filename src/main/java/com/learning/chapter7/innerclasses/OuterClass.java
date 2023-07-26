package com.learning.chapter7.innerclasses;

//Inner class example
public class OuterClass {

  private int x;

  public/private/protected abstract/final class InnerClass1  extends SomeClass implements SomeInterface{
    public void method() {
      System.out.println(OuterClass.this.x);
    }
  }

  public static void main(String[] args) {
    OuterClass.InnerClass1 obj = new OuterClass().new InnerClass1();
    obj.method();
  }
}
