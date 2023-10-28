package com.mygdx.game;

import java.util.*;


import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.Color;


public class BlockBreakerGame extends ApplicationAdapter {
    private OrthographicCamera camera;
	private SpriteBatch batch;	   
	private BitmapFont font;
	private ShapeRenderer shape;
	private ObjetosJuego ball;
	private ObjetosJuego pad;
	private ArrayList<ObjetosJuego> blocks = new ArrayList<>();
	private int vidas;
	private int puntaje;
	private int nivel;
	private ArrayList<Modificadores> modifiers = new ArrayList<>();
	private ArrayList ballList = new ArrayList<>(1);
	public int getVidas() {return this.vidas;}
	public void setVidas(int vidas) {this.vidas = vidas;}

	public Paddle getPad() {return (Paddle) pad;}

	public ArrayList<PingBall> getBallList() {return ballList;}
	public void setBallList(ArrayList ballList) {this.ballList = ballList;}
    
		@Override
		public void create () {	
			camera = new OrthographicCamera();
		    camera.setToOrtho(false, 800, 480);
		    batch = new SpriteBatch();
		    font = new BitmapFont();
		    font.getData().setScale(3, 2);
		    nivel = 1;
		    crearBloques(2+nivel);
			
		    shape = new ShapeRenderer();
		    ball = new PingBall(Gdx.graphics.getWidth()/2-10, 41, 10, 5, 7, true);
		    pad = new Paddle(Gdx.graphics.getWidth()/2-50,40,100,10,10);
		    vidas = 3;
		    puntaje = 0;

		}
		public void crearBloques(int filas) {
			blocks.clear();
			int blockWidth = 70;
		    int blockHeight = 26;
		    int y = Gdx.graphics.getHeight();
		    for (int cont = 0; cont<filas; cont++ ) {
		    	y -= blockHeight+10;
		    	for (int x = 5; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
		            blocks.add(new Block(this,x, y, blockWidth, blockHeight));
		        }
		    }
		}
		public void dibujaTextos() {
			//actualizar matrices de la cámara
			camera.update();
			//actualizar 
			batch.setProjectionMatrix(camera.combined);
			batch.begin();
			//dibujar textos
			font.draw(batch, "Puntos: " + puntaje, 10, 25);
			font.draw(batch, "Vidas : " + vidas, Gdx.graphics.getWidth()-20, 25);
			batch.end();
		}	
		
		@Override
		public void render () {

			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); 		
	        shape.begin(ShapeRenderer.ShapeType.Filled);
	        pad.draw(shape);

	        // monitorear inicio del juego
	        if (((PingBall)ball).estaQuieto()) {
				((PingBall)ball).setXY(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11);
	        	if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) ((PingBall)ball).setEstaQuieto(false);
	        }else ((PingBall)ball).update();

	        //verificar si se fue la bola x abajo y no hay más en pantalla
	        if (ballList.size() <= 0 && ball.getY() < 0) {
	        	vidas--;
	        	//nivel = 1;
	        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);
	        }
			((Paddle)pad).mover();  // Asegúrate de llamar al método mover.
			pad.draw(shape);
	        // verificar game over
	        if (vidas<=0) {
	        	vidas = 3;
	        	nivel = 1;
	        	crearBloques(2+nivel);
	        	//ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);	        	
	        }
	        // verificar si el nivel se terminó
	        if (blocks.size()==0) {
	        	nivel++;
	        	crearBloques(2+nivel);
	        	ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);
	        }

	        //dibujar bloques
	        for (ObjetosJuego b : blocks) {
	            b.draw(shape);
				((PingBall)ball).checkCollision((Block)b);
	        }
	        // actualizar estado de los bloques 
	        for (int i = 0; i < blocks.size(); i++) {
	            ObjetosJuego b = blocks.get(i);
	            if (((Block)b).destroyed) {

					Modificadores modifier = ((Block)b).dropModifier();
					if (modifier != null) {
						modifiers.add(modifier);
					}
	            	puntaje++;
	                blocks.remove(b);
	                i--; //para no saltarse 1 tras eliminar del arraylist
	            }
	        }

			

			// Actualizar la posición de los modificadores y verificar colisiones con el padd.
			Iterator<Modificadores> iterator = modifiers.iterator();
			while (iterator.hasNext()) {
				Modificadores modifier = iterator.next();
				modifier.update();

				// Si colisiona con el padd
				if (modifier.collidesWith((Paddle)pad) && modifier.isBuff) {

					modifier.apply();
					iterator.remove(); // Eliminar el modificador después de aplicarlo.
				} else if (modifier.getY() < 0 && modifier.isBuff == false) {

					if(!modifier.collidesWith((Paddle)pad)){
						modifier.apply();
						iterator.remove(); // Eliminar el modificador después de aplicarlo.
					}

				}

				modifier.draw(shape);
			}

			((PingBall)ball).checkCollision((Paddle)pad);
	        ball.draw(shape);
	        
	        shape.end();
	        dibujaTextos();
		}


		@Override
		public void dispose () {

		}
	}
