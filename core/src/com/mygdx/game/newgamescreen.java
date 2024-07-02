package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

public class newgamescreen implements Screen {

    final MyGdxGame game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    int NewX1 = 271, NewX2 = 544, NewY1 = 154, NewY2 = 221, ResX1 = 266, ResX2 = 541, ResY1 = 246, ResY2 = 311, ExitX1 = 266, ExitX2 = 541, ExitY1 = 333, ExitY2 = 395;


    public newgamescreen(final MyGdxGame game) {
        ScreenUtils.clear(0, 0, 0, 0);
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("New game.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 0);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(backgroundTexture, 0,0, 800, 480);
        game.batch.end();


        if(Gdx.input.getX()>=NewX1 && Gdx.input.getX()<=NewX2 && Gdx.input.getY()>=NewY1 && Gdx.input.getY()<=NewY2 && Gdx.input.justTouched()){
            game.setScreen(new P1Tank(game));
            dispose();
        }
        else if(Gdx.input.getX()>=ResX1 && Gdx.input.getX()<=ResX2 && Gdx.input.getY()>=ResY1 && Gdx.input.getY()<=ResY2 && Gdx.input.justTouched()){
            game.setScreen(new resumebutton(game));
            dispose();
        }
        else if(Gdx.input.getX()>=ExitX1 && Gdx.input.getX()<=ExitX2 && Gdx.input.getY()>=ExitY1 && Gdx.input.getY()<=ExitY2 && Gdx.input.justTouched()){
            game.setScreen(new quitscreen(game));
            dispose();
        }
//        if (Gdx.input.isKeyPressed(Input.Keys.P) || Gdx.input.justTouched()) {
//            if (Gdx.input.isKeyPressed(Input.Keys.Q)){
//                game.setScreen(new GameScreen(game));
//                dispose();
//            }
//            else{
//                System.out.println(Gdx.input.getX() + " " + Gdx.input.getY());
//            }
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
