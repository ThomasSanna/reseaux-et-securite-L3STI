package sockets;

import entity2dTd2.*;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestClient {

  public static void main(String[] args) {
    EchoClient client = new EchoClient();
    try {
      client.startConnection("127.0.0.1", 6666);
      String response = client.sendMessage("Hello Server!");
      System.out.println("Response from server: " + response);
      client.stopConnection();
    } catch (IOException e) {
      e.printStackTrace();
    }

    Entity2D ent_2 = new Entity2D();
    try (FileInputStream fis = new FileInputStream("donnees_serveur.ser");
        DataInputStream data = new DataInputStream(fis)) {
        ent_2 = Entity2D.fromBytes(data);
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("ID: " + ent_2.getId());
    System.out.println("Name: " + ent_2.getName());
    System.out.println("X: " + ent_2.getX());
    System.out.println("Y: " + ent_2.getY());
    System.out.println("Items: " + ent_2.getItems());

  }
}