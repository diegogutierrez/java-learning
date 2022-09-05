package com.learning.generics.concept2;

public class Gen<T> {
  protected T obj;

  public Gen(T obj) {
    this.obj = obj;
  }

  public T getObj() {
    return obj;
  }
}
