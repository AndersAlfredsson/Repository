package com.RobotsProject.ModelClasses;

/**
 * Created by Anders on 12/22/2015.
 */
public class Player extends GameObject {


    private int playerNumber;
    private boolean alive;


    public Player(int playerNr){
        playerNumber = playerNr;
        alive = true;
        position = new Position(2,2);
    }

    public void move(String direction)
    {
        System.out.print("Moved player " + playerNumber + "from: " + position.getX() + ", " + position.getY());
        switch (direction)
        {
            case "east":
                position.setX(position.getX() + 1);
                break;
            default:
                break;
        }
        System.out.println("to: " + position.getX() + ", " + position.getY());
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
