package com.learning.practice;

public class TextBlocksMain {

  public static void main(String[] args) {
    String a = """
           "a \"
           """.indent(1);
    System.out.println("============");
    System.out.println(a);
    System.out.println("============");
  }
}
