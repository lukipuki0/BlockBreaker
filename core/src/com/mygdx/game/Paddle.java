package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle extends ObjetosJuego implements Movimiento {
    private int xSpeed;

    public Paddle(int x, int y, int width, int height, int xSpeed) {
        super(x, y, width, height);
        this.xSpeed = xSpeed;
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.BLUE);
        shape.rect(getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void mover() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            x -= xSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            x += xSpeed;
        }

        // Asegurarse de que el paddle no salga de la pantalla
        if (x < 0) {
            x = 0;
        } else if (x + width > Gdx.graphics.getWidth()) {
            x = Gdx.graphics.getWidth() - width;
        }
    }
}
