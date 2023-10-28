package com.mygdx.game.ModifiersList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Modificadores;
import com.mygdx.game.BlockBreakerGame;
import com.mygdx.game.PingBall;

import java.util.ArrayList;
import java.util.Random;

public class ExtraBall extends Modificadores {

    public ExtraBall(BlockBreakerGame game, int x, int y) {
        super(game,x, y);
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.GOLD);
        shape.circle(x, y, width / 2);
    }

    @Override
    //aun no funciona
    public void apply() {
        ArrayList<PingBall> currentBalls = new ArrayList<>(game.getBallList());
        Random random = new Random();

        // Crear y añadir una nueva pelota por cada pelota existente
        for (PingBall ball : currentBalls) {
            // Añadir una variación aleatoria a la velocidad de la pelota
            int xSpeedVariation = random.nextInt(3) - 1; // -1, 0, o 1
            int ySpeedVariation = random.nextInt(3) - 1; // -1, 0, o 1

            PingBall newBall = new PingBall((int) ball.getX(), (int) ball.getY(),
                    ball.getSize(), ball.getXSpeed() + xSpeedVariation,
                    ball.getYSpeed() + ySpeedVariation, ball.estaQuieto());
            game.getBallList().add(newBall);
        }
    }
}
