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
    out.println("Le message envoyé par le client est '" + text + "'");
    System.out.println("Received: " + text);

    // send Entity2D to client in a file "donnees_serveur.ser"
    Entity2D entity = new Entity2D("Entité très sympa", 1.0f, 2.0f);
    entity.putItem(40000021);
    entity.putItem(700);
    entity.putItem(-1);

    try (
      DataOutputStream data = new DataOutputStream(clientSocket.getOutputStream())
    ) {
      entity.toBytes(data);
    } catch (IOException e) {
      e.printStackTrace();
    }

    stop();
  }

  public void stop() throws IOException{
    in.close();
    out.close();
    clientSocket.close();
    serverSocket.close();
  }
}