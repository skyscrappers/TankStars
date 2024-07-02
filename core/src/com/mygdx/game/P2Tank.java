package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.MyGdxGame;

public class P2Tank implements Screen {

    final MyGdxGame game;
    private Texture backgroundImage;
    private TextureRegion backgroundTexture;
    OrthographicCamera camera;
    int p1tankchoice;
    int p2tankchoice = 0;

    int x1 = 5, x2 = 384, y1 = 92, y2 = 272;
    int x3 = 796, y3 = 91, y4 = 272;
    int y5 = 473;
    int y6 = 471;
    public P2Tank(final MyGdxGame game, int p1tankchoice) {
        this.game = game;
        backgroundImage = new Texture(Gdx.files.internal("player2.jpg"));
        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800, 480);
        this.p1tankchoice = p1tankchoice;
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

        if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y1 && Gdx.input.getY()<=y2 &&Gdx.input.justTouched()) {
            p2tankchoice = 1;
            game.setScreen(new GameScreen(game, p1tankchoice, p2tankchoice));
            dispose();
//            System.out.println("correct");
        }

        else if (Gdx.input.getX()>=x2 && Gdx.input.getX()<=x3 && Gdx.input.getY()>=y3 && Gdx.input.getY()<=y4 &&Gdx.input.justTouched()) {
            p2tankchoice = 2;
            game.setScreen(new GameScreen(game, p1tankchoice, p2tankchoice));
            dispose();
//            System.out.println("correct");
        }

        else if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y2 && Gdx.input.getY()<=y5 &&Gdx.input.justTouched()) {
            p2tankchoice = 3;
            game.setScreen(new GameScreen(game, p1tankchoice, p2tankchoice));
            dispose();
//            System.out.println("correct");
        }

        else if (Gdx.input.getX()>=x2 && Gdx.input.getX()<=x3 && Gdx.input.getY()>=y4 && Gdx.input.getY()<=y6 &&Gdx.input.justTouched()) {
            p2tankchoice = 4;
            game.setScreen(new GameScreen(game, p1tankchoice, p2tankchoice));
            dispose();
//            System.out.println("correct");
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
