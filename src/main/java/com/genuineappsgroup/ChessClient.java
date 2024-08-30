package com.genuineappsgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChessClient {
    private Socket socket;
    private BufferedReader input;
    private PrintWriter output;
    private String playerName;

    public ChessClient(String serverAddress, int port) {
        try {
            socket = new Socket(serverAddress, port);
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);
            
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your name: ");
            playerName = scanner.nextLine();
            output.println(playerName);
            
            // Start a new thread to listen to the server
            new Thread(new ServerListener()).start();

            // Handle user input and send moves to the server
            while (true) {
                System.out.println("Enter the piece you want to move:");
                String piece = scanner.nextLine();
                output.println(piece);

                System.out.println("Enter the move (e.g., e2 to e4):");
                String move = scanner.nextLine();
                output.println(move);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ServerListener implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    String serverMessage = input.readLine();
                    if (serverMessage == null) break;
                    System.out.println("Server: " + serverMessage);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ChessClient <server_address> <port>");
            return;
        }

        String serverAddress = args[0];
        int port = Integer.parseInt(args[1]);
        new ChessClient(serverAddress, port);
    }
}
