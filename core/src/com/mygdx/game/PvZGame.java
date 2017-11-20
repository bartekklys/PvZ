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
    Plant plant;
    Bullet bullet;

    List<Bullet> bullets;

    private float timeHelper;

    private OrthographicCamera gameCamera;

    @Override
    public void create() {
        batch = new SpriteBatch();

        gameCamera = new OrthographicCamera(976, 814);

        img = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\garden.jpg");
        plantTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\plant.png");
        bulletTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\bullet.png");
        zombieTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\zombie.png");

        themeMusic = Gdx.audio.newMusic(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\music.mp3"));
        themeMusic.play();

        zombie = new Zombie(zombieTexture, 0);
        zombie.height = 158;
        zombie.width = 158;

        plant = new Plant(plantTexture, bulletTexture, 0);
        plant.height = 158;
        plant.width = 158;

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
            zombie.playSound();
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
            bullets.add(bullet);
            bullet.playSound();
            timeHelper = 0;
        }


        batch.end();

    }

    private void update() {
        gameCamera.update();
        batch.setProjectionMatrix(gameCamera.combined);
        gameCamera.position.set(976 / 2, 814 / 2, 0);
        zombie.x -= 1;
        if (bullet != null) {
            bullet.x += 1;
        }



        timeHelper += Gdx.graphics.getDeltaTime();

    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
