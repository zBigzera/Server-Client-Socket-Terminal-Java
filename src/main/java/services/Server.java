package services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {
    int port;
    ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
        start();
    }

    private void start() {
        try {
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + serverSocket.getLocalPort());

            while (true) {
                System.out.println("waiting for connection...");

                Socket socket = this.serverSocket.accept();

                // Receber dados
                BufferedReader in = new BufferedReader( // Caracteres puros
                        new InputStreamReader(  // Converte byte em caractere
                                socket.getInputStream() // Recebe os bytes da rede
                        )
                );

                String user = in.readLine();

                System.out.println("New user connected: " + user
                        + " in " +
                        socket.getInetAddress().getHostName() + ":" +
                        socket.getLocalPort());

                while (true) {
                    String message = in.readLine();

                    if (message == null) {
                        break;
                    }

                    System.out.println("@" + user + ": " + message);
                }

                System.out.println("User " + user + " disconnected.");
                socket.close();
            }

        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
