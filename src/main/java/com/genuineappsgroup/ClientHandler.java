package com.genuineappsgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {

    private Socket socket;
    private String playerColor;
    private BufferedReader input;
    private PrintWriter output;

    public ClientHandler(Socket socket, String playerColor) {
        this.socket = socket;
        this.playerColor = playerColor;
    }

    @Override
    public void run() {
        try {
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Welcome to Chess! You are playing as " + playerColor);
            output.println("Enter your name: ");
            String name = input.readLine();

            output.println("Hello " + name + ", waiting for your opponent...");

            // Handle game logic and communication here

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
