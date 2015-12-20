package com.RobotsProject.ModelClasses;

/**
 * Created by Anders on 12/20/2015.
 */
public class Position {
    private int x;
    private int y;

    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //Getters and Setters.
    public int getX() { return x; }
    public void setX(int x) { this.x = x; }
    public int getY() { return y; }
    public void setY(int y) { this.y = y; }
}
