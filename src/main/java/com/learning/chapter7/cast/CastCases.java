package com.learning.chapter7.cast;

public class CastCases {

  public static class ClassA {
  }

  public static class ClassB extends ClassA {
  }

  public static class ClassC extends ClassB {
  }

  public static class ClassD extends ClassC {
  }

  public static class ClassE extends ClassD {
  }

  public static class OtherClass {
  }

  public static interface InterfaceA {
  }

  public static void main(String[] args) {
    ClassA classA = new ClassE();
    ClassC classC = (ClassC) classA;//explicit cast
    ClassA classA1 = classC;//implicit cast
    //OtherClass otherClass = classA; disallowed case on "classes"
    InterfaceA interfaceA = (InterfaceA) classA;//cast on "interfaces" allowed, at compile time. Fails at runtime
    ClassE classE = (ClassE) interfaceA;
  }
}
