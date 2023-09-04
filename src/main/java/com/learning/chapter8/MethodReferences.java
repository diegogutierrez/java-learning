package com.learning.chapter8;

public class MethodReferences {

  @FunctionalInterface
  public interface StringCreator {
    String create(String value);
  }

  public static String create(String value) {
    return "asd";
  }

  public class StringCreatorClass {

    public String create(String value) {
      return "asd";
    }
  }

  public static void main(String[] args) {
    //reference to
    StringCreator sc1 = (value) -> value;// lambda
    StringCreator sc2 = MethodReferences::create;//static method
    StringCreatorClass instance = new MethodReferences().new StringCreatorClass();
    StringCreator sc3 = instance::create;//instance method
    StringCreator sc4 = String::strip;//parameter method
    StringCreator sc5 = String::new;//constructor method
  }
}
