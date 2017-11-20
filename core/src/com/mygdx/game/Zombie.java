package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;

public class Zombie extends Rectangle {

    private Sound yell, hit, munching;
    private Texture texture;
    private boolean isMoving;

    public Zombie(Texture texture, int row) {
        this.texture = texture;
        yell = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\sounds\\zombie\\zombieyell.ogg"));
        hit = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\sounds\\zombie\\slam.ogg"));
        munching = Gdx.audio.newSound(Gdx.files.internal("C:\\Users\\Bartosz_Klys\\IdeaProjects\\PvZ\\core\\assets\\sounds\\zombie\\munch.ogg"));
        this.x = 976;
        this.y = (row == 0) ? 50 :  row * 170;
        isMoving = true;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
        playEatingSound();
    }

    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

    public void playSound() {
        yell.play();
    }

    public void playHitSound() {
        hit.play();
    }

    private void playEatingSound() {
        munching.play();
    }
}
