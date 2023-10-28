package com.mygdx.game.ModifiersList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.BlockBreakerGame;
import com.mygdx.game.Modificadores;

public class ExtraLife extends Modificadores {


    public ExtraLife(BlockBreakerGame game, int x, int y) {
        super(game,x, y);
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.GREEN);
        shape.circle(x, y, width/2);
    }

    @Override
    public void apply() {
        game.setVidas(game.getVidas() + 1);
    }


}
