package com.learning.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {

  public static void main(String[] args) throws IOException {
    readWithByteChannel();
//    readWithFileChannel();
//    readWithMap();
  }

  private static void readWithByteChannel() throws IOException {
    ByteChannel channel = Files.newByteChannel(Paths.get("/home/diego/Desktop/todo.txt"), StandardOpenOption.READ);
    ByteBuffer  buffer = ByteBuffer.allocate(2);
    channel.read(buffer);

    buffer.rewind();
    printBuffer(buffer, buffer.array().length);
  }

  private static void readWithFileChannel() throws IOException {
    FileChannel channel = FileChannel.open(Paths.get("/home/diego/Desktop/todo.txt"), StandardOpenOption.READ);
    ByteBuffer buffer = ByteBuffer.allocate(4096);
    channel.read(buffer);
    buffer.rewind();
    printBuffer(buffer, buffer.array().length);
  }

  private static void readWithMap() throws IOException {
    FileChannel channel = (FileChannel) Files.newByteChannel(Paths.get("/home/diego/Desktop/todo.txt"), StandardOpenOption.READ);
    long size = channel.size();
    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0, size);
    printBuffer(map, size);
  }

  private static void printBuffer(ByteBuffer buffer, long top) {
    for (int i = 0; i < top; i++) {
      System.out.println(buffer.get());
    }
  }

}
