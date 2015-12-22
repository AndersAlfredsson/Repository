package com.RobotsProject;

import com.RobotsProject.ModelClasses.*;

import java.util.ArrayList;


/**
 * Created by Anders on 12/19/2015.
 * Handles all the game logic, reads from the command queue to move players. Calculating robot behaviour.
 */
public class ServerThread extends Thread {

    private Game theGame;

    public ServerThread()
    {
        theGame = new Game(20, 10);
        start();
    }

    @Override
    public void run() {
        while(true)
        {
            Command com = Main.commandQueue.poll();
            if (com != null)
            {
                System.out.println(com.toString());
                if (com.getCommandType().equals("move"))
                {
                    switch (com.getAction()){
                        case "right":
                            theGame.movePlayer(com.getPlayerNr(), "east");
                            break;
                    }
                }
                //Add a connected player to the game and player list.
                else if (com.getCommandType() == "create player")
                    theGame.addPlayer(new Player(com.getPlayerNr()));
            }
        }

    }
}
