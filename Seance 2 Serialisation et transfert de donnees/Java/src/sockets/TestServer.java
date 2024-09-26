package sockets;

import java.io.IOException;

public class TestServer {

  public static void main(String[] args) {
    EchoServer server = new EchoServer();
    try {
      server.start(6666);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}