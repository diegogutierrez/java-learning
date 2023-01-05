package com.learning.textblock;

public class TextBlockMain {

  public static void main(String[] args) {
//    indent();
//    stripIndent();
//    escape();
//    blank();
    formatted();
  }

  private static void formatted() {
    System.out.println("text: %s %d %f %n".formatted("asd", 1, 1.2));
    var pi = 3.14159265359;
    System.out.println("[%f]".formatted(pi));
    System.out.println("[%12.8f]".formatted(pi));
    System.out.println("[%12.2f]".formatted(pi));
    System.out.println("[%012.2f]".formatted(pi));
  }

  private static void blank() {
    System.out.println("".isEmpty());
    System.out.println(" ".isEmpty());
    System.out.println("".isBlank());
    System.out.println("     ".isBlank());
  }

  private static void escape() {
    var str = "\\ta";
    System.out.println(str);
    System.out.println(str.translateEscapes());
  }

  private static void stripIndent() {
    String block2 = """
         a
           b
        c""";
    String concatenation = "  a        \n" +
        " b  \n" +
        "c  ";
    System.out.println("===============");
    System.out.println(concatenation.stripIndent());
    System.out.println("===============");
  }

  private static void indent() {
    String block = """
        a
         b
        
        c""";
    System.out.println("===============");
    System.out.println(block);
    System.out.println("===============");
    System.out.println(block.indent(1));
    System.out.println("===============");
    System.out.println(block.indent(-1));
    System.out.println("===============");
  }

}
