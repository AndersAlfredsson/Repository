package com.ModelClasses;

import java.util.ArrayList;

/**
 * Created by Anders on 12/20/2015.
 * Represents the game, playing field.
 */
public class Game {


    private ArrayList<Player> playerList;
    //PlayingField playingField;
    private int width;
    private int height;
    private int turn = 0;
    private int wave = 0;
    private int minPlayers;


    public Game(int w, int h)
    {
        playerList = new ArrayList<>();
    }

    //Ändra så att ist för att skicka 2 positioner, skicka referens till spelare och förändring i x och y led som int parametrar?
    public void movePlayer(int pNr, String direction)
    {
        Player p = playerList.get(pNr);
        switch (direction) {
            case "east":
                //playingField.moveObject(playerList.get(pNr).position, new Position(playerList.get(pNr).position.getX() + 1, playerList.get(pNr).position.getY()));
                playerList.get(pNr).move("east");
                break;
            default:
                break;
        }
    }

    public void addPlayer(Player p)
    {
        playerList.add(p);
        //playingField.spawnObject(new Position(2,2), p);
    }

    public void spawnPlayer(Player player)
    {
        //Spawn the player, add to player list.
        //Not on another player.
        //Not on rubble.
    }

    public void spawnRobots(int n)
    {
        //Spawn n robots in locations not directly adjacent to a player.
        //Not on rubble
    }

    public void spawnRubble(int n)
    {
        //Spawn n rubble.
        //Not on a player
        //Not on a robot
        //Not on another rubble.
    }


    //Getters and setters.
    public int getMinPlayers() {
        return minPlayers;
    }

    public void setMinPlayers(int minPlayers) {
        this.minPlayers = minPlayers;
    }

    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<Player> playerList) {
        this.playerList = playerList;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


}
