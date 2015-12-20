package com.RobotsProject.ModelClasses;

/**
 * Created by Anders on 12/20/2015.
 * Super class for player, robot and rubble.
 */
public class GameObject{
    private Position position;

    public GameObject(int x, int y)
    {
        position = new Position(x,y);
    }
}
