package com.learning.datetime;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;

public class DatetimeMain {

  public static void main(String[] args) {
//    createDates();
//    manipulateDates();
//    period();
//    duration();
    daylightSavings();
  }

  private static void daylightSavings() {
    //spring forward
    var date = LocalDate.of(2022, Month.MARCH, 13);
    var time = LocalTime.of(1, 30);
    var dateTime = LocalDateTime.of(date, time);
    var zoned = ZonedDateTime.of(date, time, ZoneId.of("US/Eastern"));

    System.out.println(dateTime);
    System.out.println(dateTime.plusHours(1));
    System.out.println(zoned);
    System.out.println(zoned.plusHours(1));

    //fall back
    date = LocalDate.of(2022, Month.NOVEMBER, 6);
    time = LocalTime.of(1, 30);
    zoned = ZonedDateTime.of(date, time, ZoneId.of("US/Eastern"));

    System.out.println(zoned);
    System.out.println(zoned.plusHours(1));
  }

  private static void duration() {
    Duration d1 = Duration.ofDays(1);
    Duration d2 = Duration.ofHours(1);
    Duration d3 = Duration.ofMinutes(1);
    Duration d4 = Duration.ofSeconds(1);
    Duration d5 = Duration.ofMillis(1);
    Duration d6 = Duration.ofNanos(1);
    Duration d7 = Duration.of(1, ChronoUnit.MONTHS);

    var one = LocalTime.of(1, 2);
    var two = LocalTime.of(2, 3);
    var date = LocalDate.of(2, 3, 4);
    ChronoUnit.DAYS.between(one, date);
  }

  private static void period() {
    Period p1 = Period.ofYears(1);
    Period p2 = Period.ofMonths(1);
    Period p3 = Period.ofDays(1);
    LocalDate plus = LocalDate.now().plus(p1).plus(p2).plus(p3);

    //wrong
    Period.ofDays(1)
        .plusMonths(1)
        .plusYears(1);//static methods. only the last one is returned.

    System.out.println(Period.ofDays(1));
    System.out.println(Period.ofMonths(1));
    System.out.println(Period.ofYears(1));
    System.out.println(Period.of(1,2,3));
  }

  private static void manipulateDates() {
    LocalDate date = LocalDate.now();
    date.plusDays(1).plusMonths(1);
    LocalTime localTime = LocalTime.now();
    localTime.plusHours(1);
  }

  private static void createDates() {
    LocalDate date = LocalDate.of(2022, Month.JANUARY, 1);
    LocalTime time = LocalTime.of(10, 12, 13, 14);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    ZoneId zoneId = ZoneId.of("US/Eastern");
    ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, zoneId);
  }
}
