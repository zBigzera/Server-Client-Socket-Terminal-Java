package serverclient;

import services.Client;

import java.util.Scanner;

public class MainClient {
    static void main() {
        Scanner sc = new Scanner(System.in);

        IO.println("============CLIENT INITIALIZING...============");

        IO.println("Choose a server port: ");
        int port = sc.nextInt();
        sc.nextLine();

        IO.println("Now, define the server IP Address");
        String ip = sc.nextLine();

        new Client(ip, port);
    }
}
