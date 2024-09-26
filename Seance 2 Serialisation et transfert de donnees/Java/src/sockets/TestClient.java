package sockets;

import entity2dTd2.*;
import java.io.IOException;
import java.net.Socket;

public class TestClient {

  public static void main(String[] args) {
    EchoClient client = new EchoClient();
    String ip = "127.0.0.1";
    int port = 6666;
    try {
      client.startConnection(ip, port);
      String response = client.sendMessage("Hello Server!");
      System.out.println("Response from server: " + response);

      Entity2D ent_2 = client.getEntity2DFromServer();

      System.out.println("ID: " + ent_2.getId());
      System.out.println("Name: " + ent_2.getName());
      System.out.println("X: " + ent_2.getX());
      System.out.println("Y: " + ent_2.getY());
      System.out.println("Items: " + ent_2.getItems());

      client.stopConnection();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}