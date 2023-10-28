package com.mygdx.game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Modificadores {
    protected int x, y, width, height;  // Posición del modificador en pantalla y Dimensiones del modificador.
    protected int speedY; // Velocidad vertical del modificador (caída).
    protected BlockBreakerGame game;
    protected boolean isBuff;
    public Modificadores(BlockBreakerGame game,int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = 20;
        this.height = 20;
        this.speedY = 5;// Velocidad de caída.
        this.isBuff = true;

    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getWidth() {
    	return this.width;
    }
    public int getHeight() {
    	return this.height;
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
        return x < paddle.getX() + paddle.getWidth() &&
                x + width > paddle.getX() &&
                y < paddle.getY() + paddle.getHeight() &&
                y + height > paddle.getY();
    }

}
