package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.Iterator;

public class Render {

    /*
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private BitmapFont font;
    private ShapeRenderer shape;

    private Juego juego;

    public void create (Juego juego) {

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(3, 2);
        juego = new Juego();


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
        if (ball.estaQuieto()) {
            ball.setXY(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11);
            if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) ball.setEstaQuieto(false);
        }else ball.update();
        //verificar si se fue la bola x abajo
        if (ball.getY()<0) {
            vidas--;
            //nivel = 1;
            ball = new PingBall(pad.getX()+pad.getWidth()/2-5, pad.getY()+pad.getHeight()+11, 10, 5, 7, true);
        }
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
        for (Block b : blocks) {
            b.draw(shape);
            ball.checkCollision(b);
        }
        // actualizar estado de los bloques
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.destroyed) {

                Modificadores modifier = b.dropModifier();
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
            if (modifier.collidesWith(pad)) {
                modifier.apply();
                iterator.remove(); // Eliminar el modificador después de aplicarlo.
            }

            modifier.draw(shape);
        }

        ball.checkCollision(pad);
        ball.draw(shape);

        shape.end();
        dibujaTextos();
    }

     */
}
