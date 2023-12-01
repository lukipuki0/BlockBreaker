package com.mygdx.game.ModifiersList;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.BlockBreakerGame;
import com.mygdx.game.Modificadores;
import com.mygdx.game.Paddle;

public class IncreasePad extends Modificadores {
    public IncreasePad(BlockBreakerGame game, int x, int y) {
        super(game,x, y);
    }
    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.PURPLE);
        shape.circle(x, y, width/2);
    }
    @Override
    public void apply() {
        Paddle paddle = game.getPad();
        paddle.setWidth((paddle.getWidth() + 10));
    }
}
