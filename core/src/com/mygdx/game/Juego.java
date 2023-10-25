package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Juego {

   /* private PingBall ball;
    private Paddle pad;
    private ArrayList<Block> blocks = new ArrayList<>();
    private int vidas;
    private int puntaje;
    private int nivel;
    private ArrayList<Modificadores> modifiers = new ArrayList<>();
    private ArrayList<PingBall> ballList = new ArrayList<>();

    public juego() {

    }
    @Override
    public void create () {

        nivel = 1;
        crearBloques(2+nivel);

        ball = new PingBall(Gdx.graphics.getWidth()/2-10, 41, 10, 5, 7, true);
        pad = new Paddle(Gdx.graphics.getWidth()/2-50,40,100,10);
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
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    */
}
