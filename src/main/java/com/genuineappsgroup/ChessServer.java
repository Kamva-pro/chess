package com.genuineappsgroup;

import java.io.*;
import java.net.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.genuineappsgroup.ClientHandler;
public class ChessServer {

    private static final int PORT = 6000;
    private static Socket player1Socket;
    private static Socket player2Socket;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Chess server started on port " + PORT);

            while (true) {
                if (player1Socket == null) {
                    player1Socket = serverSocket.accept();
                    executor.execute(new ClientHandler(player1Socket, "White"));
                } else if (player2Socket == null) {
                    player2Socket = serverSocket.accept();
                    executor.execute(new ClientHandler(player2Socket, "Black"));
                } else {
                    System.out.println("Both players have joined, starting the game...");
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}

