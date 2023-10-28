package com.mygdx.game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Modificadores {
    protected int x, y, width, height;  // Posición del modificador en pantalla y Dimensiones del modificador.
    protected int speedY; // Velocidad vertical del modificador (caída).
    protected BlockBreakerGame game;
    public Modificadores(BlockBreakerGame game,int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.speedY = 5;// Velocidad de caída.

    }

    // Método para actualizar la posición del modificador mientras cae.
    public void update() {
        y -= speedY;
    }

    // Método para dibujar el modificador en pantalla.
    public abstract void draw(ShapeRenderer shape);

    // Método abstracto para aplicar el efecto del modificador.
    public abstract void apply();


    // Método para detectar colisiones con el padd.
    public boolean collidesWith(Paddle paddle) {
        if(x > paddle.getX() && x < paddle.getX() + paddle.getWidth() &&
                y > paddle.getY() && y < paddle.getY() + paddle.getHeight()) {
            return true;
        }
        return false;
    }
}
