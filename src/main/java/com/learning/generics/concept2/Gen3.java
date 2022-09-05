package com.learning.generics.concept2;

public class Gen3<T extends String> extends Gen<T> {

  public Gen3(T obj) {
    super(obj);
  }
}
