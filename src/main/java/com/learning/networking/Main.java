package com.learning.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) throws IOException {
//    inetAddress();
    urlConnection();
  }

  private static void urlConnection() throws IOException {
    URL url = new URL("https://google.com");
    URLConnection connection = url.openConnection();
    System.out.println(connection.getDate());
    System.out.println(connection.getHeaderFields());
  }

  private static void inetAddress() throws UnknownHostException {
    InetAddress a1 = InetAddress.getLocalHost();
    System.out.println(a1);

    InetAddress a2 = InetAddress.getByName("google.com");
    System.out.println(a2);
    System.out.println(a2.getAddress());
    System.out.println(a2.getHostAddress());
    System.out.println(a2.getHostName());

    System.out.println("==========");
    InetAddress[] a3 = InetAddress.getAllByName("google.com");
    Arrays.asList(a3).forEach(inetAddress -> System.out.println(inetAddress));
  }
}
