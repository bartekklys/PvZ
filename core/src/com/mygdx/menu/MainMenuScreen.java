package com.mygdx.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.PvZGame;
import com.mygdx.tools.Path;

public class MainMenuScreen implements Screen {

    private static final int PLAY_BUTTON_HEIGHT = 50;
    private static final int PLAY_BUTTON_WIDTH = 100;
    private static final int EXIT_BUTTON_HEIGHT = 50;
    private static final int EXIT_BUTTON_WIDTH = 100;
    public static final int PLAY_BUTTON_Y = 300;
    public static final int EXIT_BUTTON_Y = 200;

    PvZGame game;

    Texture backgroundTheme;

    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture playButtonActive;
    Texture playButtonInactive;

    public MainMenuScreen(PvZGame game) {
        this.game = game;
        backgroundTheme = new Texture(Path.MENU_BACKGROUND_THEME);
        exitButtonActive = new Texture(Path.EXIT_BUTTON_ACTIVE);
        exitButtonInactive = new Texture(Path.EXIT_BUTTON_INACTIVE);
        playButtonActive = new Texture(Path.PLAY_BUTTON_ACTIVE);
        playButtonInactive = new Texture(Path.PLAY_BUTTON_INACTIVE);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 1, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.begin();

        int playButtonX = PvZGame.WIDTH / 2 - PLAY_BUTTON_WIDTH / 2;
        if (Gdx.input.getX() < playButtonX + PLAY_BUTTON_WIDTH && Gdx.input.getX() > playButtonX
                && PvZGame.HEIGHT - Gdx.input.getY() < PLAY_BUTTON_Y + PLAY_BUTTON_HEIGHT && PvZGame.HEIGHT - Gdx.input.getY() > PLAY_BUTTON_Y) {
            game.batch.draw(playButtonActive, playButtonX, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        } else {
            game.batch.draw(playButtonInactive, playButtonX, PLAY_BUTTON_Y, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT);
        }

        int exitButtonX = PvZGame.WIDTH / 2 - EXIT_BUTTON_WIDTH / 2;
        if (Gdx.input.getX() < exitButtonX + EXIT_BUTTON_WIDTH && Gdx.input.getX() > exitButtonX
                && PvZGame.HEIGHT - Gdx.input.getY() < EXIT_BUTTON_Y + EXIT_BUTTON_HEIGHT && PvZGame.HEIGHT - Gdx.input.getY() > EXIT_BUTTON_Y) {
            game.batch.draw(exitButtonActive, exitButtonX, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        } else {
            game.batch.draw(exitButtonInactive, exitButtonX, EXIT_BUTTON_Y, EXIT_BUTTON_WIDTH, EXIT_BUTTON_HEIGHT);
        }


        game.batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
