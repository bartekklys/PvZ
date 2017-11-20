package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;

public class PvZGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
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

        gameCamera = new OrthographicCamera(976, 814);

        img = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\images\\garden.jpg");
        plantTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\images\\plant.png");
        bulletTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\images\\bullet.png");
        zombieTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\images\\zombie.png");

        themeMusic = Gdx.audio.newMusic(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\sounds\\theme\\music.mp3"));
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
        update();
        batch.begin();

//		Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.draw(img, 0, 0);

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
        batch.dispose();
        img.dispose();
    }
}
