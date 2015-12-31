package com.ModelClasses;

/**
 * Created by Anders on 12/20/2015.
 * Super class for player, robot and rubble. Can also be an empty position on the playing field.
 */
public class GameObject{
    protected Position position;

    public GameObject()
    {

    }

    public GameObject(int x, int y)
    {
        position = new Position(x,y);
    }
}
