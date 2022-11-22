package com.learning.textformatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Main {
  public static void main(String[] args) {
    //get date/time
//    localTime();
//    localDate();
//    localDateTime();

    //format date/time
//    formatLocalDateTime();

    //parse date/time
//    parseLocalDateTime();
  }

  private static void parseLocalDateTime() {
    LocalDateTime dateTime = LocalDateTime.parse("June 21, 2017 11:10 AM", DateTimeFormatter.ofPattern("MMMM d',' yyyy hh':'mm a"));
    System.out.println(dateTime);
  }

  private static void formatLocalDateTime() {
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT)));
    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
    System.out.println(dateTime.format(DateTimeFormatter.ofPattern("YYYY_MM_dd HH_mm_ss")));
//    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG)));//exception
//    System.out.println(dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL)));//exception
  }

  private static void localDateTime() {
    LocalDateTime dateTime = LocalDateTime.now();
    System.out.println(dateTime);
    System.out.println(dateTime.format(DateTimeFormatter.ofPattern("YYYY MM")));
  }

  private static void localDate() {
    LocalDate date = LocalDate.now();
    System.out.println(date);
  }

  private static void localTime() {
    LocalTime localTime = LocalTime.now();
    System.out.println(localTime);
  }
}
