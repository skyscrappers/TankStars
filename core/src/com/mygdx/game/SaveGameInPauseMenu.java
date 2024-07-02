package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

import java.io.*;

public class SaveGameInPauseMenu implements Screen {

    final MyGdxGame game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    int a,b,h1,h2;

    //We will store these variables a,b,h1,h2 using serialization and deserialization later on when we make full game!
    public SaveGameInPauseMenu(final MyGdxGame game,int a, int b,int h1,int h2) throws IOException {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("gamesavedsuccessfully.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.a = a;
        this.b = b;
        this.h1 = h1;
        this.h2 = h2;

        FileOutputStream fos = new FileOutputStream("output.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);


        FileInputStream fis = new FileInputStream("output.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
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
        if(Gdx.input.isKeyPressed(Input.Keys.M) || Gdx.input.justTouched()){
            game.setScreen(new newgamescreen(game));
        }

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
