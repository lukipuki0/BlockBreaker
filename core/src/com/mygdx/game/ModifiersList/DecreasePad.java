package com.mygdx.game.ModifiersList;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.BlockBreakerGame;
import com.mygdx.game.Modificadores;
import com.mygdx.game.Paddle;

public class DecreasePad extends Modificadores {
    public DecreasePad(BlockBreakerGame game, int x, int y) {
        super(game,x, y);
        this.isBuff = false;
    }
    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.GRAY);
        shape.circle(x, y, width/2);
    }
    @Override
    public void apply() {
        Paddle paddle = game.getPad();  // Suponiendo que tienes un método para obtener el Paddle.
        paddle.setWidth((paddle.getWidth() - 10));  // Cambia el tamaño del Paddle.
    }
}
