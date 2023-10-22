package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends objectos {
    public Paddle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }


    @Override
	public void draw(ShapeRenderer shape){
        shape.setColor(Color.BLUE);
        int x2 = x; //= Gdx.input.getX();
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) x2 =x-15;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) x2=x+15;
       // y = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (x2 > 0 && x2+width < Gdx.graphics.getWidth()) {
            x = x2;
        }
        shape.rect(getX(), getY(), getWidth(), getHeight());
    }


}
