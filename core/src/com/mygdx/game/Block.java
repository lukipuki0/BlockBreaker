package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.ModifiersList.ExtraBall;
import com.mygdx.game.ModifiersList.ExtraLife;

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

    public Modificadores dropModifier() {
        // Usamos una probabilidad del 10% de soltar un modificador.
        if (Math.random() < 1) {
            switch ((int) (Math.random() * 2)) {
                case 0:
                    return new ExtraLife(x + width / 2, y);  // Soltar desde el centro del bloque.
                case 1:
                    return new ExtraBall(x + width / 2, y);  // Soltar desde el centro del bloque.
            }

        }
        return null; // No soltar ningún modificador.
    }
}
