package com.learning.otherpackages;

import java.text.NumberFormat;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.Formatter;
import java.util.GregorianCalendar;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

  public static void main(String[] args) {
//    testBitSet();
//    testOptional();
//    testTimer();
//    testCurrency();
//    testFormatter();
//    testFormatterNumber();
//    testFormatterDate();
//    testScanner();
    testResourceBundle();
  }

  private static void testResourceBundle() {
    //doesn't work
    ResourceBundle resourceBundle = ResourceBundle.getBundle("SampleDB");
    System.out.println(resourceBundle.getString("title"));

    resourceBundle = ResourceBundle.getBundle("SampleDB_de");
    System.out.println(resourceBundle.getString("title"));
  }

  public static class SampleDB extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
      Object[][] objects = new Object[1][1];
      objects[0][0] = "title";
      objects[0][1] = "main program";
      return objects;
    }
  }

  public static class SampleDB_de extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
      Object[][] objects = new Object[1][1];
      objects[0][0] = "title";
      objects[0][1] = "mein programm";
      return objects;
    }
  }

  private static void testFormatterNumber() {
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    System.out.println(numberFormat.format(5));
  }

  private static void testScanner() {
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNext()) {
      System.out.println(scanner.next());
    }
  }

  private static void testFormatterDate() {
    Formatter f = new Formatter();
    Calendar calendar = new GregorianCalendar();
    f.format("%tr", calendar);
    f.format("%n%tc", calendar);
    f.format("%n%tB %td", calendar, calendar);
    f.format("%n|%d|", 1);
    f.format("%n|%5d|", 1);//min width
    f.format("%n|%05d|", 1);//min width with padding

    f.format("%n%4d%4d%4d", 1,2,3);//creating tables
    f.format("%n%4d%4d%4d", 1,2,3);

    f.format("%n%5.1f", 1.23456789);//set precision

    f.format("%n|%10.2f|", 123.123);//right justification
    f.format("%n|%-10.2f|", 123.123);//left justification

    f.format("%n|%,d|", 123456789);//display number with commas, makes it easier to read

    f.format("%n|%S|", "asd");//upper case string

    f.format("%n|%2$s %1$s %1$s|", "one", "two");//argument index

    System.out.println(f);
  }

  private static void testFormatter() {
    Formatter f = new Formatter();
    f.format("hello %s, %d", "asd", 10);
    System.out.println(f);
  }

  private static void testCurrency() {
    System.out.println(Currency.getAvailableCurrencies());
    System.out.println(Currency.getInstance(Locale.FRANCE).getSymbol());
  }

  private static void testTimer() {
    Timer timer = new Timer();
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        System.out.println("running task "  + Thread.currentThread());
      }
    }, 3000, 1000);
  }

  private static void testOptional() {
    Optional<String> a = Optional.of("asd");
    System.out.println(a.map(Main::upperCase));
    System.out.println(a.map(Main::transform));
    System.out.println(a.flatMap(Main::transform));
  }

  private static String upperCase(String a) {
    return a.toUpperCase();
  }

  private static Optional<String> transform(String a) {
    return Optional.of(a.toUpperCase());
  }

  public static void testBitSet() {
    long[] a = {1,2};
    BitSet bitSet = new BitSet(2);
    bitSet.set(0);
    bitSet.set(6);
    System.out.println(new String(bitSet.toByteArray()));
    System.out.println(bitSet.cardinality());
  }
}
