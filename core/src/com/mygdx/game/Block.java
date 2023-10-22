package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;

public class Block extends objectos {
    Color cc;
    boolean destroyed;
    public Block(int x, int y, int width, int height) {
        super(x, y, width, height);
        destroyed = false;
        Random r = new Random(x+y);

        cc = new Color(0.1f+r.nextFloat(), r.nextFloat(), r.nextFloat(), 10);
    }

    public void draw(ShapeRenderer shape){
    	shape.setColor(cc);
        shape.rect(getX(), getY(), getWidth(), getHeight());
    }
}
