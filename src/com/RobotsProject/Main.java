package com.RobotsProject;

import com.RobotsProject.ModelClasses.Command;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Main {
    static public ConcurrentLinkedQueue<Command> commandQueue = new ConcurrentLinkedQueue<Command>();

    public static void main(String[] args) {
	    ConnectionThread server = new ConnectionThread();

        Command c;
        String s;
        while(true)
        {
            if (commandQueue.size() > 0) {
                s = commandQueue.poll().toString();
                System.out.println(s);
            }
        }
    }
}
