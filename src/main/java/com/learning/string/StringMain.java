package com.learning.string;

import java.util.Locale;
import java.util.stream.Collectors;

public class StringMain {

  public static void main(String[] args) {
//    String a = "abc";
//    System.out.println(a.codePoints().boxed().collect(Collectors.toList()));

//    System.out.println(String.format(Locale.CHINESE, "%d", 10));
//    Integer a = 1;
//    System.out.println(Integer.valueOf("FFFF", 16));
//    System.out.println(Integer.toBinaryString(65535));
//

//    System.out.println(Character.valueOf('a').toString().codePointAt(0));
//    System.out.println(Character.forDigit(1, 10));
    System.out.println(Character.codePointAt("a", 0));
  }
}
