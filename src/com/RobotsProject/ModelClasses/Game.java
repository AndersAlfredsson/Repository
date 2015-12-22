package com.RobotsProject.ModelClasses;

import java.util.ArrayList;

/**
 * Created by Anders on 12/20/2015.
 * Represents the game, playing field.
 */
public class Game {
    private ArrayList<Player> playerList;
    PlayingField playingField;
    private int width;
    private int height;


    public Game(int w, int h)
    {
        playerList = new ArrayList<>();
        playingField = new PlayingField(w,h);
    }

    public void movePlayer(int pNr, String direction)
    {
        Player p = playerList.get(pNr);
        switch (direction) {
            case "east":
                playingField.moveObject(playerList.get(pNr).position, new Position(playerList.get(pNr).position.getX() + 1, playerList.get(pNr).position.getY()));
                playerList.get(pNr).move("east");
                break;
            default:
                break;
        }
    }

    public void addPlayer(Player p)
    {
        playerList.add(p);
        playingField.spawnObject(new Position(2,2), p);
    }


}
