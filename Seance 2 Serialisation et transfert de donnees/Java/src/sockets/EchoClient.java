package sockets;

import entity2dTd2.*;
import java.net.*;
import java.io.*;

public class EchoClient {

  private Socket clientSocket;
  private PrintWriter out;
  private BufferedReader in;

  public void startConnection(String ip, int port) throws UnknownHostException, IOException {
    clientSocket = new Socket(ip, port);
    out = new PrintWriter(clientSocket.getOutputStream(), true);
    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    System.out.println("Socket created! " + clientSocket);
  }

  public String sendMessage(String msg) throws IOException {
    out.println(msg);
    String resp = in.readLine();
    return resp;
  }

  public void stopConnection() throws IOException {
    in.close();
    out.close();
    clientSocket.close();
  }

}
