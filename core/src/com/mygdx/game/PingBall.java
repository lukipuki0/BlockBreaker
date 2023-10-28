package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PingBall extends ObjetosJuego implements Movimiento {

	    private int xSpeed, ySpeed, size;
	    private Color color = Color.WHITE;
	    private boolean estaQuieto;
	    
	    public PingBall(int x, int y, int size, int xSpeed, int ySpeed, boolean iniciaQuieto) {
	        super(x, y, size, size);
			this.size = size;
	        this.xSpeed = xSpeed;
	        this.ySpeed = ySpeed;
	        estaQuieto = iniciaQuieto;
	    }
		@Override
		public void mover() {
			// Aquí, añade la lógica para mover el PingBall.
			// Como un ejemplo básico:
			this.x += this.xSpeed;
			this.y += this.ySpeed;
		}
	    public boolean estaQuieto() {
	    	return estaQuieto;
	    }
	    public void setEstaQuieto(boolean bb) {
	    	estaQuieto=bb;
	    }
	    public void setXY(int x, int y) {
	    	this.x = x;
	        this.y = y;
	    }
	    public int getY() {return y;}
		public int getX() {return x;}
		public int getSize() {return size;}

		public int getXSpeed() {return xSpeed;}
		public int getYSpeed() {return ySpeed;}
	    public void draw(ShapeRenderer shape){
	        shape.setColor(color);
	        shape.circle(x, y,width);
	    }
	    public void update() {
	    	if (estaQuieto) return;
	        x += xSpeed;
	        y += ySpeed;
	        if (x-width < 0 || x+width > Gdx.graphics.getWidth()) {
	            xSpeed = -xSpeed;
	        }
	        if (y+width > Gdx.graphics.getHeight()) {
	            ySpeed = -ySpeed;
	        }
	    }


	    public void checkCollision(Paddle paddle) {
	        if(collidesWith(paddle)){
	            color = Color.GREEN;
	            ySpeed = -ySpeed;
	        }else{
				color = Color.WHITE;
			}

	    }
	    private boolean collidesWith(Paddle pp) {

	    	boolean intersectaX = (pp.getX() + pp.getWidth() >= x-width) && (pp.getX() <= x+width);
	        boolean intersectaY = (pp.getY() + pp.getHeight() >= y-width) && (pp.getY() <= y+width);
	    	return intersectaX && intersectaY;
	    }
	    public void checkCollision(Block block) {
	        if(collidesWith(block)){

				color = Color.RED;
	            ySpeed = - ySpeed;
	            block.destroyed = true;
	        }else{
				color = Color.WHITE;
			}
	    }
	    private boolean collidesWith(Block bb) {

	    	boolean intersectaX = (bb.x + bb.width >= x-width) && (bb.x <= x+width);
	        boolean intersectaY = (bb.y + bb.height >= y-width) && (bb.y <= y+width);
	    	return intersectaX && intersectaY;
	    }


}
