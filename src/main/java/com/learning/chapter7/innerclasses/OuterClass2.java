package com.learning.chapter7.innerclasses;

//static inner class example
public class OuterClass2 {

  private String outerField;

  private void outerMethod() {
    OuterClass2.InnerClass aClass = new InnerClass();//namespaced with the outer class if outside the outer class.
    System.out.println(aClass.innerField);
    aClass.innerMethod();
  }

  /*public/protect/private*/ /*abstract/final*/ static class InnerClass extends Object implements Cloneable {
    private String innerField;

    private void innerMethod() {

    }
  }
}
