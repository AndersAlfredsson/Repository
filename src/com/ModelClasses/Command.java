package com.ModelClasses;

/**
 * Created by Anders on 12/19/2015.
 */

/**
 * A command consists of: What player it was sent by, what type of command it is (move, attack, teleport, wait)
 * and an action(direction if move or attack, and safe or not safe if it is teleport. null if type is wait.)
 */
public class Command {
    private int playerNr;
    private String commandType;
    private String action;

    public Command(int pNr, String cType, String act)
    {
        playerNr = pNr;
        commandType = cType;
        action  = act;
    }

    @Override
    public String toString() {
        return (playerNr + commandType + action);
    }

    public int getPlayerNr(){return playerNr;}
    public String getCommandType(){return commandType;}
    public String getAction(){return action;}
}
