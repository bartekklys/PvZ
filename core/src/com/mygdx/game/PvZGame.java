package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.screen.MainMenuScreen;
import com.mygdx.tools.Path;

import java.util.ArrayList;
import java.util.List;

public class PvZGame extends Game {

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

    private float timeHelper;

    private OrthographicCamera gameCamera;

    @Override
    public void create() {
        batch = new SpriteBatch();

        this.setScreen(new MainMenuScreen(this));

        gameCamera = new OrthographicCamera(976, 814);

        gardenTexture = new Texture(Path.GARDEN_TEXTURE);
        plantTexture = new Texture(Path.PLANT_TEXTURE);
        bulletTexture = new Texture(Path.BULLET_TEXTURE);
        zombieTexture = new Texture(Path.ZOMBIE_TEXTURE);

        themeMusic = Gdx.audio.newMusic(Gdx.files.internal(Path.MAIN_THEME_MUSIC));
        // themeMusic.play();

        zombie = new Zombie(zombieTexture, 0);
        zombie.height = 128;
        zombie.width = 128;

        plant = new BasicPlant(plantTexture, bulletTexture, 0);
        plant.height = 128;
        plant.width = 90;

        bullets = new ArrayList<Bullet>();


    }

    @Override
    public void render() {
        super.render();
        update();

//		Gdx.gl.glClearColor(1, 0, 0, 1);
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
        }

        for (Bullet b :
                bullets) {

        }*/

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
    public void dispose() {
//        batch.dispose();
//        gardenTexture.dispose();
    }
}
