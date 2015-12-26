package com.RobotsProject;

import com.RobotsProject.ModelClasses.Command;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static public ConcurrentLinkedQueue<Command> commandQueue = new ConcurrentLinkedQueue<Command>();

    public static void main(String[] args) {
	    ConnectionThread cThread = new ConnectionThread();
        ServerThread sThread = new ServerThread();


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
            try {
                String s = br.readLine();
                if (s.equals("s"))
                    sThread.startGame();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
