package com.mygdx.game.ModifiersList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mygdx.game.BlockBreakerGame;
import com.mygdx.game.Modificadores;
import com.mygdx.game.PingBall;

public class IncreaseBallSpeed extends Modificadores {
    private double speedFactor;  // Factor por el cual se aumentará la velocidad de la pelota.

    public IncreaseBallSpeed(BlockBreakerGame game, int x, int y, double speedFactor) {
        super(game,x, y);
        this.speedFactor = speedFactor;
        this.isBuff = false;
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.BLUE);
        shape.circle(x, y, width / 2);
    }

    @Override
    public void apply() {
        PingBall ball = game.getBall();
        ball.setXSpeed(ball.getXSpeed() * speedFactor);
        ball.setYSpeed(ball.getYSpeed() * speedFactor);
    }
}
