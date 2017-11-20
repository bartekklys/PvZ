package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Plant extends Rectangle {

    private Sound shot;
    Texture texture;
    List<Bullet> bullets;

    public Plant(Texture texture, Texture bulletTexture, int row) {
        this.texture = texture;
        shot = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\shot.ogg"));
        this.bullets = new ArrayList<Bullet>();
        this.x = 20;
        this.y = 40;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

}
