package com.ModelClasses;

/**
 * Created by Anders on 12/22/2015.
 */
public class Player extends GameObject {
    private String name;
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
            case "west":
                position.setX(position.getX() - 1);
                break;
            case "north":
                position.setY(position.getY() - 1);
                break;
            case "south":
                position.setY(position.getY() + 1);
                break;
            case "northwest":
                position.setX(position.getX() - 1);
                position.setY(position.getY() - 1);
                break;
            case "northeast":
                position.setX(position.getX() + 1);
                position.setY(position.getY() - 1);
                break;
            case "southeast":
                position.setX(position.getX() + 1);
                position.setY(position.getY() + 1);
                break;
            case "southwest":
                position.setX(position.getX() - 1);
                position.setY(position.getY() + 1);
                break;
            case "wait":
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
