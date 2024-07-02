package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

import java.io.IOException;

public class pausegame implements Screen {

    final MyGdxGame game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;

    int x1 = 210, x2 = 555, y1 = 37, y2 = 130;
    int y3 = 168, y4 = 262;
    int y5 = 301, y6 = 399;
    int x3 = 637, x4 = 721, y7 = 372, y8 = 455;
    int a,b,h1,h2;


    public pausegame(final MyGdxGame game,int a, int b,int h1,int h2) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("pausemenu.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.a = a;
        this.b = b;
        this.h1 = h1;
        this.h2 = h2;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.end();
//        System.out.println(Gdx.input.getX()+" "+Gdx.input.getY());
//        if(Gdx.input.isKeyPressed(Input.Keys.M)){
//            game.setScreen(new GameScreen(game,a,b));
//        }
        if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y1 && Gdx.input.getY()<=y2 &&Gdx.input.justTouched()) {
//            //save game
            try {
                game.setScreen(new SaveGameInPauseMenu(game,a,b,h1,h2));
            } catch (Exception e) {
                System.out.println("Some Error Occurred.");
            }
        }
//
        else if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y3 && Gdx.input.getY()<=y4 &&Gdx.input.justTouched()) {
            game.setScreen(new GameScreen(game,a,b));
            dispose();
//            System.out.println("correct");
        }
//
        else if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y5 && Gdx.input.getY()<=y6 &&Gdx.input.justTouched()) {
            game.setScreen(new newgamescreen(game));
            dispose();
//            System.out.println("correct");
        }
//
        else if (Gdx.input.getX()>=x3 && Gdx.input.getX()<=x4 && Gdx.input.getY()>=y7 && Gdx.input.getY()<=y8 &&Gdx.input.justTouched()) {
            //settings
//            System.out.println("correct");
        }

//        else if(Gdx.input.justTouched()){
//            System.out.println("incorrect");
//        }
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
