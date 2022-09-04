package com.learning.annotations;

public class Main {
  public static void main(String[] args) {
    RegularClass regularClass = new RegularClass("");
    RegularClass regularClass2 = new RegularClass("");
    Class<?> aClass = regularClass.getClass();
    Class<?> aClass2 = regularClass2.getClass();
    System.out.println("done");
  }
}
