package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.ModifiersList.*;

public class Block extends ObjetosJuego {
    Color cc;
    boolean destroyed;
    BlockBreakerGame game;
    public Block(BlockBreakerGame game,int x, int y, int width, int height) {
        super(x, y, width, height);
        destroyed = false;
        this.game = game;
        Random r = new Random(x+y);

        cc = new Color(0.1f+r.nextFloat(), r.nextFloat(), r.nextFloat(), 10);
    }

    public void draw(ShapeRenderer shape){
    	shape.setColor(cc);
        shape.rect(getX(), getY(), getWidth(), getHeight());
    }

    // Método que selecciona un modificador aleatorio y lo devuelve al romper el bloque.
    public Modificadores dropModifier() {
        // Usamos una probabilidad del X% de soltar un modificador.
        if (Math.random() < 0.5) {

            switch ((int) (Math.random() * 4)) {
                case 0:
                    return new ExtraLife(game,x + width / 2, y);
                case 1:
                    return new IncreaseBallSpeed(game,x + width / 2, y, 1.20);
                case 2:
                    if(game.getPad().getWidth()>50) {
                        return new DecreasePad(game, x + width / 2, y);
                    }
                case 3:
                    if(game.getPad().getWidth()<200) {
                        return new IncreasePad(game, x + width / 2, y);
                    }
            }
        }
        return null; // No soltar ningún modificador.
    }
}
