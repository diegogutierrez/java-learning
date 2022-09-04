package com.learning.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreams {

  public static void main(String[] args) throws InterruptedException, IOException {
    PipedOutputStream outputStream = new PipedOutputStream();
    Thread writerThread = new Thread(() -> {
      try {
        outputStream.write("abc".getBytes());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, "writerThread");


    InputStream inputStream = new PipedInputStream(outputStream);
    Thread readThread = new Thread(() -> {
      try {
        System.out.println("->>" + inputStream.read());
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }, "readerThread");

    writerThread.start();
    readThread.start();
    writerThread.join();
    readThread.join();
    System.out.println("done");
  }
}
