package com.learning.lambda.targetTypeContext;

public class Main {

  public interface MyNumber {
    double get();
  }

  public interface MyNumberGen<T> {
    T get();
  }

  public static void staticMethod(MyNumber myNumber) {
    myNumber.get();
  }

  public static void main(String[] args) {
    //initialization
    MyNumber myNumber = () -> 1.0;
    myNumber.get();

    //assignment
    MyNumberGen<String> myNumberGen;
    myNumberGen = () -> "asd";
    myNumberGen.get();

    //argument passing
    staticMethod(() -> 1.0);

    //cast

    //? operator
    myNumber = 1 > 0 ? () -> 1.0 : () ->2.0;

    //return

    //LE
  }
}
