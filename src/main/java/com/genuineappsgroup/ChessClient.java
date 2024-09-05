package com.genuineappsgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChessClient {
    private String host;
    private int port;
    private Socket socket;
    private BufferedReader input;

    public ChessClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void start() {
        try {
            socket = new Socket(host, port);
            System.out.println("Connected to the server at " + host + ":" + port);

            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start listening for server messages
            // new Thread(new ServerListener(input)).start();

            // Client interaction logic
            

        } catch (IOException e) {
            System.err.println("Failed to connect to the server: " + e.getMessage());
        }
    }

    private void handleClientInteraction() {
        // This is where you'll handle client interactions, like sending moves to the server
    }

    public static void main(String[] args) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Enter the port to connect to: ");
            int port = Integer.parseInt(consoleReader.readLine());

            ChessClient client = new ChessClient("127.0.0.1", port);
            client.start();

        } catch (IOException e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }
}
