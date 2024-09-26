package sockets;

import entity2dTd2.*;
import java.io.*;
import java.net.*;

public class EchoServer {

  private ServerSocket serverSocket;
  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void start(int port) throws IOException {
    serverSocket = new ServerSocket(port);
    System.out.println("Server opened on port " + port + " waiting for a client...");
    // Will block until a client connects.
    clientSocket = serverSocket.accept();
    System.out.println("Client connected: " + clientSocket);
    System.out.println("InetAddress: " + clientSocket.getInetAddress() + "\nPort: " + clientSocket.getPort());
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    String text = in.readLine();
    out.println(text + " Bien reçu");
    System.out.println("Received: " + text);

    // Entity2D
    Entity2D entity = new Entity2D("Entity", 1.0f, 2.0f);
    entity.putItem(421);
    entity.putItem(700);
    entity.putItem(-1);

    try (
      FileOutputStream fos = new FileOutputStream("donnees_serveur.ser");
      DataOutputStream data = new DataOutputStream(fos)
    ) {
      entity.toBytes(data);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void stop() throws IOException{
    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();
  }
}
