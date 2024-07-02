package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game {

    public SpriteBatch batch;
    public BitmapFont font;
    public static final int PPM = 100;


    private int fontsize = 1;
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(fontsize);
        font.setColor(1,0,0,1);
        this.setScreen(new MainMenu(this));
    }

    public void render() {
        super.render(); // important!
    }

    public void dispose() {
        batch.dispose();
        font.dispose();
    }

    public int getFontsize() {
        return fontsize;
    }
    public void setFontsize(int fontsize) {
        this.fontsize = fontsize;
    }
}
