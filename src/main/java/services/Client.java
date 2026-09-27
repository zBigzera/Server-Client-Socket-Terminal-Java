package services;

import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        start();
    }

    private void start() {
        Scanner sc = new Scanner(System.in);
        String name;
        do {
            System.out.println("Enter your name: ");
            name = sc.nextLine().trim();
        } while (name.isEmpty());

        System.out.println("Hi " + name + ", please still waiting to connect you to the server + " + ip + ":" + port + "...");

        try {
            Socket socket = new Socket(ip, port);
            System.out.println("Connected to " + ip + ":" + port);
            System.out.println("Type \"exit\" to close the communication.");

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(name);

            while (!socket.isClosed()) {
                System.out.println("Type your message: ");
                String message = sc.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    socket.close();
                }

                out.println(message);
            }

            socket.close();
        }
        catch (SocketException e) {
            System.out.println("Connection closed.");
        }
        catch (Exception e) {
            System.err.println("Could not connect to " + ip + ":" + port);
        }
    }
}
