package com.genuineappsgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import org.json.JSONArray;
import org.json.JSONObject;

public class ChessServer implements Runnable {
    private String clientMachine;
    private BufferedReader in;
    private PrintStream out;
    

    public void SimpleServer(Socket socket) throws IOException {
        clientMachine = socket.getInetAddress().getHostName();
        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try{

         while(true){
            String messageFromClient;
            while((messageFromClient = in.readLine()) != null)
            {
                JSOb

            }
        }
    }catch(IOException exception)
    {

    }
    }

}