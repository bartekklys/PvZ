package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BasicPlant extends Rectangle implements com.mygdx.game.plants.Plant {

    private static int HP = 100;
    Texture texture;
    List<Bullet> bullets;

    public BasicPlant(Texture texture, int row) {
        this.texture = texture;
        this.bullets = new ArrayList<Bullet>();
        this.x = 20;
        this.y = 40;
    }

    @Override
    public void draw(SpriteBatch batch) {
        batch.draw(texture, x, y);
    }

}
