package com.learning.records;

import java.io.IOException;

public record AnotherClass(String name, int age) {

    public AnotherClass {
        if (name.isEmpty()) {//validate input params
            throw new IllegalArgumentException("empty name");
        }

        if ( age < 1) {//transform input params
            age = -1;
        }
    }

    public AnotherClass(String firstName, String lastName) {
        this(firstName + " " + lastName, 0);
    }

    public String name(String prefix) {
        return prefix + " : " + this.name;
    }

    public String instanceMethod() {
        return "HI " + this.name;
    }

    @Override
    public String name() {
        return "this is my name: " + name;
    }

    private class InnerClass {

    }

    public interface MyInterface {

    }

    public record InnerRecord(String a) {}
}
