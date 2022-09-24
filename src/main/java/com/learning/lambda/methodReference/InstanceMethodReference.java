package com.learning.lambda.methodReference;

interface MyFunction<T> {
  boolean func(T v1, T v2);
}

interface MyFunction2<T> {
  int func(T v1);
}

interface MyFunction3 {
  String func(String i);
}

class HighTemp {
  private int temp;

  public HighTemp(int temp) {
    this.temp = temp;
  }

  boolean sameTemp(HighTemp t2) {
    return temp == t2.temp;
  }

  int get() {
    return temp;
  }
}


class StringOps {

  public String run(String a) {
    return a;
  }
}

public class InstanceMethodReference {

  static <T> int count(T[] vals, MyFunction<T> f, T v) {
    int count = 0;
    for (int i = 0; i < vals.length; i++) {
      if (f.func(vals[i], v)) {
        count++;
      }
    }
    return count;
  }

  static <T> int[] get(T[] vals, MyFunction2<T> f) {
    int[] res = new int[vals.length];
    for (int i = 0; i < vals.length; i++) {
      res[i] = f.func(vals[i]);
    }
    return res;
  }

  static String getValue(MyFunction3 f, String s) {
    return f.func(s);
  }

  public static void main(String[] args) {
    StringOps stringOps = new StringOps();
    getValue(stringOps::run, "asd");

    HighTemp[] vals = {new HighTemp(1), new HighTemp(2), new HighTemp(3)};
    int count = count(vals, HighTemp::sameTemp, new HighTemp(10));
    System.out.println(count);

    int[] internalValues = get(vals, HighTemp::get);
    System.out.println(internalValues.length);
  }
}
