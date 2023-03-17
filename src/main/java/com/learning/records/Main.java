package com.learning.records;

public class Main {

    public static void main(String[] args) {
//        User user1 = new User("a", 1);
//        user1.age();
//        user1.name();
//
//        User user2 = new User("a", 2);
//        user2.age();
//        user2.name();
//
//        System.out.println(user1.equals(user2));
//        System.out.println(user1);
//        System.out.println(user2);

//        AnotherClass ac1 = new AnotherClass("", 1);
//        AnotherClass ac2 = new AnotherClass("asd", -100);
//        System.out.println(ac2);
        AnotherClass ac3 = new AnotherClass("aaa", "bbb");//invoke overloaded constructor
        System.out.println(ac3);
        System.out.println(ac3.name("Hello!!!"));
        System.out.println(ac3.instanceMethod());
        System.out.println(ac3.name());
        System.out.println(new AnotherClass.InnerRecord("asd"));
    }
}
