package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Zombie extends Rectangle {

    private Sound yell;
    private Texture texture;
    private boolean isMoving;

    public Zombie(Texture texture, int row) {
        this.texture = texture;
        yell = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\zombieyell.ogg"));
        this.x = 976;
        this.y = row * 158;
        isMoving = true;
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void playSound() {
        yell.play();
    }

}
