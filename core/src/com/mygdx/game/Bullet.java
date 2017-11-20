package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Bullet extends Rectangle {

    public static final int SPEED = 1;
    public static final int DEFAULT_X = 100;
    public boolean remove;
    private Sound shot;

    Texture bulletTexture;
    Plant plant;

    float x, y;


    public Bullet(float y) {
        this.x = DEFAULT_X;
        this.y = y + 80;
        this.remove = false;
        shot = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\shot.ogg"));

        if (bulletTexture == null) {
            bulletTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\bullet.png");
        }
    }

    /**
     * Update pozycji i kasuje jesli wyjdzie poza ekran
     * @param deltaTime
     */
    public void update() {
        x += SPEED;
        if (x > Gdx.graphics.getWidth()) {
            remove = true;
        }
    }

    public void render(SpriteBatch batch) {
        if (remove) return;
        batch.draw(bulletTexture, x, y);
    }

    public void playSound() {
        shot.play();
    }
}