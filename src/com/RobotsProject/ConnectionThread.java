package com.RobotsProject;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Anders on 12/19/2015.
 */
public class ConnectionThread extends Thread {
    static final int PORTNR = 2000;

    public ConnectionThread() {
        start();
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORTNR);
            while (true) {
                //Waits for new connection.
                Socket socket = serverSocket.accept();
                ClientComThread ccThread = new ClientComThread(socket);
                System.out.println("New Connection, " + socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}