package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Plant extends Rectangle {

    private Sound shot;
    Texture texture, bulletTexture;

    public Plant(Texture texture, Texture bulletTexture, int row) {
        this.texture = texture;
        this.bulletTexture = bulletTexture;
        shot = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\shot.ogg"));
        this.x = 4;
        this.y = 3;
    }

    public Texture getTexture() {
        return texture;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void setBulletTexture(Texture bulletTexture) {
        this.bulletTexture = bulletTexture;
    }

    public void shot(SpriteBatch batch) {
        batch.draw(bulletTexture, x, y);
    }

    public void playSound() {
        shot.play();
    }

}
