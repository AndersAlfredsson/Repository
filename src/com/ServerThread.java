package com;

import com.ModelClasses.Command;
import com.ModelClasses.Game;
import com.ModelClasses.Player;


/**
 * Created by Anders on 12/19/2015.
 * Handles all the game logic, reads from the command queue to move players. Calculating robot behaviour.
 */
public class ServerThread extends Thread {

    private Game theGame;
    private int turnCounter;

    public ServerThread()
    {
        turnCounter = 0;
        theGame = new Game(20, 10);
    }

    @Override
    public void run() {

        //startGame();

        while(true)
        {
            //Check if there still players who havent moved.
            //If there are no players left, move robots.
            if(turnCounter < ClientComThread.numberOfPlayers) {
                System.out.println("Player turn");
                playerTurn();
            }
            else
            {
                System.out.println("Robots turn");
                robotTurn();
            }

            //After move; send new position to all clients.
        }

    }

    private void robotTurn()
    {
        turnCounter = 0;
    }

    private void broadcastToAllClients(String s)
    {
        for (ClientComThread client : ClientComThread.AllPlayers) {
            client.messageClient(s);
        }
    }


    private void playerTurn() {
        Command com;
        //Send who's turn it is and new position of last moved player to clients.
        broadcastToAllClients("Player: " + turnCounter + " turn");

        try {
            sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //If the poll returns null the queue is empty and the client has failed to send input during its turn.
        //Default command is to Wait.
        if ((com = MainController.commandQueue.poll()) == null) {
            executeCommand(new Command(turnCounter, "move", "wait"));
        } else if (com.getPlayerNr() == turnCounter) {
            executeCommand(com);
        }

        turnCounter++;
    }

    public void startGame()
    {
        while (theGame.getPlayerList().size() < theGame.getMinPlayers())
        {

        }
        //Spawn players
        //Spawn robots
        //Spawn rubble
        //Send game state to all clients
        start();
        //broadcastToAllClients("Game Started!");
    }

    private void executeCommand(Command com) {
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
