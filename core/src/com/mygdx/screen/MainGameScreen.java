package com.mygdx.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.BasicPlant;
import com.mygdx.game.Bullet;
import com.mygdx.game.PvZGame;
import com.mygdx.game.Zombie;
import com.mygdx.screen.MainMenuScreen;
import com.mygdx.tools.Path;

import java.util.ArrayList;
import java.util.List;

public class MainGameScreen implements Screen {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 800;

    public SpriteBatch batch;
    Texture gardenTexture;
    Texture plantTexture, bulletTexture;
    Texture zombieTexture;
    Music themeMusic;

    Zombie zombie;
    BasicPlant plant;
    Bullet bullet;

    List<Bullet> bullets;

    PvZGame game;

    private float timeHelper;

    private OrthographicCamera gameCamera;

    public MainGameScreen(PvZGame game) {
        this.game = game;
    }

    private void update() {
        long start = System.currentTimeMillis();
        gameCamera.update();
        batch.setProjectionMatrix(gameCamera.combined);
        gameCamera.position.set(976 / 2, 814 / 2, 0);

        // sprawdzanie czy zombiak natrafił na rośline - jesli tak to niech ją zjada
        if (zombie.intersects(plant)) {
            //zombie.setMoving(false);
        }

        // ruch zombiaka
        if (zombie.isMoving()) {
            zombie.x -= 1;
        }

        timeHelper += Gdx.graphics.getDeltaTime();

        // sprawdzanie czy zombiak został trafiony - jeśli tak to usuń kulke i odejmij HP
        /*for (Bullet b :
                bullets) {
            if (b.intersects(zombie)) {
                System.out.println("DUPA");
                b.remove = true;
            }
        }*/
        long stop = System.currentTimeMillis();
//        System.out.println(stop-start);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
//        batch.dispose();
//        gardenTexture.dispose();
    }
}
