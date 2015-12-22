package com.RobotsProject;

import com.RobotsProject.ModelClasses.Command;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Anders on 12/19/2015.
 *Handles communication between server and client.
 */
public class ClientComThread extends Thread {
    private static int numberOfPlayers = 0;
    private static ArrayList<ClientComThread> AllPlayers = new ArrayList<ClientComThread>();
    private final int playerNumber = numberOfPlayers++;
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;

    /***
     * Sets the socket and initializes the Bufferedreader and Printwriter. Also sends a command to the command queue to
     * create a new player.
     * @param s
     * @throws IOException
     */
    public ClientComThread(Socket s) throws IOException
    {
        socket = s;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
        out.println("Connected to the server!");
        Main.commandQueue.add(new Command(playerNumber, "create player", ""));
        start();
    }

    /**
     * Reads commands from the client and adds that command to the commandQueue
     */
    @Override
    public void run() {
        String command;
        while (true) {
            try {
                if ((command = in.readLine()) != null) {
                    if (command.equals("exit"))
                    {
                        playerExit();
                        break;
                    }
                    else
                    {
                        buildCommand(command);
                        System.out.println("Command from Player " + playerNumber + " : " + command);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Interupts the thread and closes socket, Bufferedreader and PrintWriter.
     */
    private void playerExit()
    {
        try {
            socket.close();
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            this.interrupt();
        }

    }

    /**
     * Builds a command from a string and adds it to the command queue.
     * @param s = string to build from.
     */
    private void buildCommand(String s)
    {
        //Split the string using delimiter @.
        System.out.println(s);
        String[] comParts = s.split("@");
        int pNumber = playerNumber;
        String cType = comParts[0];
        String act = comParts[1];

        //Todo: Gör trådsäker.
        Main.commandQueue.add(new Command(pNumber, cType, act));
    }
}

//Todo:
