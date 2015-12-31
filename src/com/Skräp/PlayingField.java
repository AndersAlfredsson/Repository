package com.Skräp;

import com.ModelClasses.EmptySpace;
import com.ModelClasses.GameObject;
import com.ModelClasses.Player;
import com.ModelClasses.Position;

/**
 * Created by Anders on 12/22/2015.
 */
public class PlayingField {
    private GameObject[][] field;
    private int width;
    private int height;

    public PlayingField(int width, int height)
    {
        this.width = width;
        this.height = height;
        field = new GameObject[width][height];
    }

    public void resetField()
    {
        //Initiate all the spaces on the playing field to contain empty spaces.
        for (int i = 0; i < width; i++)
            for (int j = 0; j < height; j++)
                field[i][j] = new EmptySpace();
    }

    /**
     * @param from The position to move from.
     * @param to The position to move to.
     */
    public void moveObject(Position from, Position to)
    {
        GameObject obj = field[from.getX()][from.getY()];
        field[from.getX()][from.getY()] = new EmptySpace();
        field[to.getX()][to.getY()] = obj;
        System.out.println("Moved player " + ((Player)obj).getPlayerNumber());
    }

    public void spawnObject(Position pos, GameObject obj)
    {
        field[pos.getX()][pos.getY()] = obj;
        System.out.println("Spawning " + obj.getClass() + " at: " + pos.getX() + "," + pos.getY());
    }
}
