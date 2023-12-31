package com.mygdx.game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class ObjetosJuego {
    protected   int x, y, width, height;

    public ObjetosJuego(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    public abstract void draw(ShapeRenderer shape);

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

    public void setWidth(int width){
        this.width = width;
    }
    public void setHeight(int height){
        this.height = height;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
    	this.y = y;
    }
}
