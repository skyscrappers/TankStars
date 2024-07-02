package com.Sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.GameScreen;
import com.mygdx.game.MyGdxGame;

public class bomb extends Sprite {

    public World world;
    public static Body b2body;
    private GameScreen screen;
    private TextureRegion right;



    public bomb(World world, Texture texture){
        //initialize default values
//        this.screen = screen;
        super.setTexture(texture);
        this.world = world;
        defineTank();
        setBounds(0,0,110f,60f);
        setRegion(texture);
    }

    public void update(float dt){
        setPosition(b2body.getPosition().x - getWidth() / 2, b2body.getPosition().y - getHeight() / 2);

    }


    public void defineTank(){
        BodyDef bdef = new BodyDef();
        bdef.position.set(80 , 485 );
        bdef.type = BodyDef.BodyType.DynamicBody;
        b2body = world.createBody(bdef);

        FixtureDef fdef = new FixtureDef();
        CircleShape shape = new CircleShape();
        shape.setRadius(1);

        fdef.shape = shape;
        b2body.createFixture(fdef);
    }

}