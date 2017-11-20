package com.mygdx.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.BasicPlant;
import com.mygdx.game.Bullet;
import com.mygdx.game.PvZGame;
import com.mygdx.game.Zombie;
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
    Music dayStageMusic;

    Zombie zombie;
    BasicPlant plant;
    Bullet bullet;

    List<Bullet> bullets;

    PvZGame game;

    private float timeHelper;

    public MainGameScreen(PvZGame game) {
        this.game = game;

        gardenTexture = new Texture(Path.GARDEN_TEXTURE);
        plantTexture = new Texture(Path.PLANT_TEXTURE);
        bulletTexture = new Texture(Path.BULLET_TEXTURE);
        zombieTexture = new Texture(Path.ZOMBIE_TEXTURE);

        dayStageMusic = Gdx.audio.newMusic(Gdx.files.internal(Path.DAY_STAGE_MUSIC));
        dayStageMusic.play();

        zombie = new Zombie(zombieTexture, 0);
        zombie.height = 128;
        zombie.width = 128;

        plant = new BasicPlant(plantTexture, bulletTexture, 0);
        plant.height = 128;
        plant.width = 90;

        bullets = new ArrayList<Bullet>();
    }

    private void update() {
        long start = System.currentTimeMillis();
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(gardenTexture, 0, 0);

        plant.draw(batch);
        zombie.draw(batch);

        if (zombie.x % 200 == 150) {
            //zombie.playSound();
        }

        /*if (timeHelper > 1) {
            Bullet b = new Bullet(bulletTexture, plant);
            b.draw(batch);;
            timeHelper = 0;
        }*/

        for (Bullet b :
                bullets) {

        }

        // update bullets
        List<Bullet> bulletsToRemove = new ArrayList<Bullet>();
        for (Bullet b :
                bullets) {
            b.update();
            /*if (bullet.remove) {
                bulletsToRemove.add(b);
            }*/
        }
        bullets.removeAll(bulletsToRemove);

        for (Bullet b :
                bullets) {
            b.render(batch);
        }
        if (timeHelper > 1) {
            Bullet bullet = new Bullet(plant.y);
            bullet.height = 100;
            bullet.width = 100;
            bullets.add(bullet);
            timeHelper = 0;
        }


        batch.end();
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

    }
}