package serverclient;

import services.Server;

import java.util.Scanner;
public class MainServer {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("============SERVER INITIALIZING...============");

        IO.println("Choose a server port: ");
        int port = sc.nextInt();

        Server server = new Server(port);

    }
}
