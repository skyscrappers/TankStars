package com.mygdx.game;

import com.Sprites.Tankss;
import com.Sprites.Tankss1;
import com.Sprites.bomb;
import com.Sprites.bomb1;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.MyGdxGame;

//public class GameScreen implements Screen {
//
//    final MyGdxGame game;
//    private Texture backgroundImage;
//    public Texture tt1;
//    public Texture tt2;
//    private TextureRegion backgroundTexture;
//    OrthographicCamera camera;
//    Rectangle tn1;
//    Rectangle tn2;
//    int x1 = 367, x2 = 431, y1 = 10, y2 = 83;
//    int tank1, tank2,health1 = 100,health2 = 100;
//    String tank1img, tank2img;
////    public TmxMapLoader maploader;
////    public TiledMap map;
////    public OrthogonalTiledMapRenderer renderer;
//
//    public GameScreen(final MyGdxGame game, int tank1, int tank2) {
//        this.tank1 = tank1;
//        this.tank2 = tank2;
//
//        if(tank1 == 1){
//            this.tank1img = "t66.png";
//        }
//        else if(tank1 == 2){
//            this.tank1img = "bucket.png";
//        }
//        else if(tank1 == 3){
//            this.tank1img = "t13.png";
//        }
//        else if(tank1 == 4){
//            this.tank1img = "t7.png";
//        }
//        if(tank2 == 1){
//            this.tank2img = "t5.png";
//        }
//        else if(tank2 == 2){
//            this.tank2img = "bucket1.png";
//        }
//        else if(tank2 == 3){
//            this.tank2img = "t9.png";
//        }
//        else if(tank2 == 4){
//            this.tank2img = "t6.png";
//        }
//        this.game = game;
//        backgroundImage = new Texture(Gdx.files.internal("hill.jpg"));
//        tt1 = new Texture(Gdx.files.internal(tank1img));
//        tt2 = new Texture(Gdx.files.internal(tank2img));
//        backgroundTexture = new TextureRegion(backgroundImage, 0, 0, 1920, 1080);
//        camera = new OrthographicCamera();
//        camera.setToOrtho(false, 800, 480);
////        maploader = new TmxMapLoader();
////        map = maploader.load("tiledtry.tmx");
////        renderer = new OrthogonalTiledMapRenderer(map, 1);
//        tn1 = new Rectangle();
//        tn1.x = 30;
//        tn1.y = 215;
//        tn1.width = 64;
//        tn1.height = 64;
//        tn2 = new Rectangle();
//        tn2.x = 710;
//        tn2.y = 172;
//        tn2.width = 64;
//        tn2.height = 64;
//    }
//
//    @Override
//    public void show() {
//
//    }
//
//    @Override
//    public void render(float delta) {
//        ScreenUtils.clear(0, 0, 0, 0);
////        renderer.render();
//        camera.update();
//        game.batch.setProjectionMatrix(camera.combined);
//
//        game.batch.begin();
//        game.batch.draw(backgroundTexture, 0,0, 800, 480);
//        game.font.draw(game.batch, "Health P1: "+health1, 0, 480);
//        game.font.draw(game.batch, "Health P2: "+health2, 705, 480);
//        game.batch.draw(tt1, tn1.x, tn1.y, tn1.width, tn1.height);
//        game.batch.draw(tt2, tn2.x, tn2.y, tn2.width, tn2.height);
//        game.batch.end();
//
//        if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y1 && Gdx.input.getY()<=y2 &&Gdx.input.justTouched()) {
//            game.setScreen(new pausegame(game,tank1,tank2,health1,health2));
//            dispose();
//        }
//        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
//                game.setScreen(new quitscreen(game));
//        }
//
//
//    }
//
//    @Override
//    public void resize(int width, int height) {
//
//    }
//
//    @Override
//    public void pause() {
//
//    }
//
//    @Override
//    public void resume() {
//
//    }
//
//    @Override
//    public void hide() {
//
//    }
//
//    @Override
//    public void dispose() {
//        tt1.dispose();
//        tt2.dispose();
//    }
//
//}



public class GameScreen implements Screen {

    private OrthographicCamera gamecam;
    private Viewport gamePort;
    final MyGdxGame game;
    private TmxMapLoader maploader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer renderer;
    private World world;
    private Box2DDebugRenderer b2dr;
    int tank1,tank2;
    String tank1img, tank2img;
    private Tankss tank11;
    private Tankss1 tank12;
    private bomb b1;
    private bomb1 b11;
    private Texture trex;
    private Texture trex1;
    int x1 = 367, x2 = 431, y1 = 10, y2 = 83;
    float fuel = 1;
    float fuel1 = 1;
    float health = 1;
    float health1 = 1;
    Texture fbar;
    Texture fbar1;
    Texture hbar;
    Texture hbar1;

    private Body b2;

    float an1 = 100, p1 = 300, an2 = 100, p2 = -300;

    public GameScreen(final MyGdxGame game, int tank1, int tank2) {

        this.tank1 = tank1;
        this.tank2 = tank2;

        if(tank1 == 1){
            this.tank1img = "t66.png";
        }
        else if(tank1 == 2){
            this.tank1img = "bucket.png";
        }
        else if(tank1 == 3){
            this.tank1img = "t13.png";
        }
        else if(tank1 == 4){
            this.tank1img = "t7.png";
        }
        if(tank2 == 1){
            this.tank2img = "t5.png";
        }
        else if(tank2 == 2){
            this.tank2img = "bucket1.png";
        }
        else if(tank2 == 3){
            this.tank2img = "t9.png";
        }
        else if(tank2 == 4){
            this.tank2img = "t6.png";
        }
        fbar = new Texture(Gdx.files.internal("health.png"));
        fbar1 = new Texture(Gdx.files.internal("health.png"));
        hbar = new Texture(Gdx.files.internal("health.png"));
        hbar1 = new Texture(Gdx.files.internal("health.png"));

        this.game = game;
        gamecam = new OrthographicCamera();
        gamePort = new FitViewport(1900, 1080, gamecam);

        maploader = new TmxMapLoader();
        map = maploader.load("tiledtry.tmx");
        renderer = new OrthogonalTiledMapRenderer(map, 1);
        world = new World(new Vector2(0,-10), true);
        b2dr = new Box2DDebugRenderer();
        gamecam.position.set(gamePort.getWorldWidth() / 2, gamePort.getWorldHeight() / 2, 0);
        tank11 = new Tankss(world,new Texture(tank1img));
        tank12 = new Tankss1(world,new Texture(tank2img));
//        b1 = new bomb(world, new Texture("bomb.png"));
//        trex = new Texture("bucket.png");
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        for (MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set(rect.getX() + rect.getWidth() / 2, rect.getY() + rect.getHeight() / 2);
            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2, rect.getHeight() / 2);
            fdef.shape = shape;
            body.createFixture(fdef);
        }


    }


    @Override
    public void show() {


    }

    public void update(float dt) {
        handleInput(dt);
        tank11.update(dt);
        tank12.update(dt);
        world.step(1/60f,6,2);
        gamecam.update();
        renderer.setView(gamecam);

    }
//    public void createBomb(Tankss t1){
//        BodyDef bd = new BodyDef();
//        bd.position.set(t1.b2body.getPosition().x,t1.b2body.getPosition().y);
//        bd.type = BodyDef.BodyType.DynamicBody;
//        b2 = world.createBody(bd);
//
//        FixtureDef fd = new FixtureDef();
//        CircleShape shape = new CircleShape();
//        shape.setRadius(10);
//        fd.shape = shape;
//        t1.b2body.createFixture(fd);
//    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.render();
        b2dr.render(world, gamecam.combined);

        game.batch.setProjectionMatrix(gamecam.combined);
        game.batch.begin();
        tank11.draw(game.batch);
        tank12.draw(game.batch);


//        if(fuel > 0.6f){
//            game.batch.setColor(Color.GREEN);
//        }
//        else if(fuel <= 0.6f && fuel > 0.2f){
//            game.batch.setColor(Color.ORANGE);
//        }
//        else{
//            game.batch.setColor(Color.RED);
//        }
//
//        if(fuel1 > 0.6f){
//            game.batch.setColor(Color.GREEN);
//        }
//        else if(fuel1 <= 0.6f && fuel1 > 0.2f){
//            game.batch.setColor(Color.ORANGE);
//        }
//        else{
//            game.batch.setColor(Color.RED);
//        }
//        if(health > 0.6f){
//            game.batch.setColor(Color.GREEN);
//        }
//        else if(health <= 0.6f && health > 0.2f){
//            game.batch.setColor(Color.ORANGE);
//        }
//        else{
//            game.batch.setColor(Color.RED);
//        }
//
//        if(health1 > 0.6f){
//            game.batch.setColor(Color.GREEN);
//        }
//        else if(health1 <= 0.6f && health1 > 0.2f){
//            game.batch.setColor(Color.ORANGE);
//        }
//        else{
//            game.batch.setColor(Color.RED);
//        }
        game.batch.setColor(Color.GREEN);

        game.batch.draw(fbar,tank11.getX(),tank11.getY()+100,130*fuel,5);
        game.batch.draw(fbar1,tank12.getX(),tank12.getY()+100,130*fuel1,5);
        game.batch.draw(hbar,50,1000,300*health,25);
        game.batch.draw(hbar1,1550,1000,300*health1,25);

        game.batch.setColor(Color.WHITE);
//        game.batch.draw(trex, (float) (Tankss.b2body.getPosition().x - 0.8), (float) (Tankss.b2body.getPosition().y - 0.6), 0.5f, 0.6f);
        game.batch.end();

        if (Gdx.input.getX()>=x1 && Gdx.input.getX()<=x2 && Gdx.input.getY()>=y1 && Gdx.input.getY()<=y2 &&Gdx.input.justTouched()) {
            game.setScreen(new pausegame(game,tank1,tank2,100,100));
            dispose();
        }
        if(Gdx.input.isKeyPressed(Input.Keys.ESCAPE)){
            game.setScreen(new quitscreen(game));
        }

    }

    public void handleInput(float dt){
            if (Gdx.input.isKeyPressed(Input.Keys.D) && tank11.b2body.getLinearVelocity().x <= 2 && fuel > 0) {
                tank11.b2body.applyLinearImpulse(new Vector2(10.0f, 0.5f), tank11.b2body.getWorldCenter(), true);
                fuel -= 0.10f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.A) && tank11.b2body.getLinearVelocity().x >= -2 && fuel > 0){
                tank11.b2body.applyLinearImpulse(new Vector2(-10.0f, 0.5f), tank11.b2body.getWorldCenter(), true);
                fuel -= 0.10f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && tank12.b2body.getLinearVelocity().x <= 2 && fuel1 > 0){
                tank12.b2body.applyLinearImpulse(new Vector2(10.0f, 0.5f), tank12.b2body.getWorldCenter(), true);
                fuel1 -= 0.10f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.LEFT) && tank12.b2body.getLinearVelocity().x >= -2 && fuel1 > 0){
                tank12.b2body.applyLinearImpulse(new Vector2(-10.0f, 0.5f), tank12.b2body.getWorldCenter(), true);
                fuel1 -= 0.10f;
            }
            if (Gdx.input.isKeyPressed(Input.Keys.F) && tank11.b2body.getLinearVelocity().x >= -2){
                b1 = new bomb(world, new Texture("bomb.png"));
//                b1.draw(game.batch);
                b1.b2body.applyLinearImpulse(new Vector2(p1, an1), tank11.b2body.getWorldCenter(), true);
            }

            if (Gdx.input.isKeyPressed(Input.Keys.L) && tank12.b2body.getLinearVelocity().x >= -2){
                b11 = new bomb1(world, new Texture("bomb.png"));
    //                b1.draw(game.batch);
                b11.b2body.applyLinearImpulse(new Vector2(p2, an2), tank12.b2body.getWorldCenter(), true);
            }
            if(Gdx.input.isKeyPressed(Input.Keys.P)){
                p2 += 50;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.O)){
                p2 -= 50;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.I)){
                an2 += 50;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.U)){
                an2 -= 50;
            }

            if(Gdx.input.isKeyPressed(Input.Keys.Q)){
                p1 += 50;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.W)){
                p1 -= 50;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.E)){
                an1 += 50;
            }
            if(Gdx.input.isKeyPressed(Input.Keys.R)){
                an1 -= 50;
            }
    }


    @Override
    public void resize(int width, int height) {
        gamePort.update(width, height,true);

    }

    public TiledMap getMap() {
        return map;
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
        map.dispose();
        renderer.dispose();
    }
}


