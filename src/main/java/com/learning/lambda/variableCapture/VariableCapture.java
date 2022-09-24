package com.learning.lambda.variableCapture;


public class VariableCapture {

  private static String name;

  public static void main(String[] args) {
    int num = 10;
    MyFunc myFunc = n -> {
      int a = num + 1;
      name = "";// can update static and instance variables from the enclosing class
      return 10;
    };
//    num = 9; ->> makes the num variable to lose its effective final status

    myFunc.func(1);
  }

}

interface MyFunc {
  int func(int n);

}
