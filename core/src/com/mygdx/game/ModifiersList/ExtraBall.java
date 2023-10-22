package com.mygdx.game.ModifiersList;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;
import com.mygdx.game.Modificadores;

public class ExtraBall extends Modificadores {

    public ExtraBall(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(ShapeRenderer shape) {
        shape.setColor(Color.GOLD);  // Color específico para este modificador.
        shape.circle(x, y, width / 2);  // Representación visual como un círculo.
    }

    @Override
    public void apply() {
        /*
        PingBall currentBall = game.getBallList().get(0); // Tomar la primera bola como referencia
        // Crear una nueva bola en la misma posición y velocidad que una de las bolas existentes
        double angle = Math.toRadians(30 + Math.random() * 120); // Ángulo aleatorio entre 30º y 150º
        int xSpeed = (int)(currentBall.getXSpeed() * Math.cos(angle));
        int ySpeed = (int)(currentBall.getYSpeed() * Math.sin(angle));
        ySpeed = Math.abs(ySpeed);

        PingBall newBall = new PingBall((int)currentBall.getX(), currentBall.getY(), currentBall.getSize(), xSpeed, ySpeed, currentBall.estaQuieto());
        game.getBallList().add(newBall);
        */

    }
}
