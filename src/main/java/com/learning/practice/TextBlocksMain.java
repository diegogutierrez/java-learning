package com.learning.practice;

public class TextBlocksMain {

  long aLong;
  {
    System.out.println("initializer");
  }

  static {
    System.out.println("static initializer");
  }
  public static void main(String[] args) {
    System.out.println("starting");
//    String a = """
//           "a \
//           """.indent(1);
//    System.out.println("============");
//    System.out.println(a);
//    System.out.println("============");
    TextBlocksMain textBlocksMain = new TextBlocksMain();
    TextBlocksMain textBlocksMain2 = new TextBlocksMain();
    System.out.println("done");
  }
}
