package com.learning.annotations;

@MyAnno(name = "name1", address = "address1")
public class RegularClass {

  @MyAnno(name = "name1", address = "address1")
  public RegularClass(String a) {
    this.a = a;
  }

  @MyAnno(name = "name1", address = "address1")
  private String a;

  @MyAnno(name = "name1", address = "address1")
  public void method() {

    @MyAnno(name = "name1", address = "address1")
    String a = "";
  }

}
