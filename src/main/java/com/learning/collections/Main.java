package com.learning.collections;

import java.util.EnumSet;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class Main {

  public enum Type {
    A, B, C;
  }
  public static void main(String[] args) {
    //to array
    List<Integer> x = List.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3));
    Integer[] y = x.toArray(Integer[]::new);
    int a = 0;

    //collections using enums
    EnumSet<Type> types = EnumSet.noneOf(Type.class);
    System.out.println(types);
    EnumSet<Type> types2 = EnumSet.allOf(Type.class);
    System.out.println(types2);

    //Violations of the Liskov substitution principle:
    Vector<String> v = new Stack<>();
    v.add("a");
    v.add(0, "b");//why I can insert elements in any place???
    System.out.println(v);
  }
}
