package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Bullet extends Rectangle {

    public static final int SPEED = 2;
    public static final int DEFAULT_X = 100;
    public boolean remove;
    private Sound shot;

    Texture bulletTexture;

    float x, y;


    public Bullet(float y) {
        this.x = DEFAULT_X;
        this.y = y + 80;
        this.remove = false;
        shot = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\sounds\\plant\\shot.ogg"));
        shot.play();
        if (bulletTexture == null) {
            bulletTexture = new Texture("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\images\\bullet.png");
        }
    }

    /**
     * Update pozycji i kasuje jesli wyjdzie poza ekran
     * @param
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