package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Player{
    private static final int BOX_SIZE = 30*10;
    private static final float PLAYER_DENSITY = 1.0f;
    public static final float JUMP_FORCE = 250f;
    public static final float RUN_FORCE = 5f;
    public static final String PLAYER_IMG_PATH = "badlogic.png";
    public static final float PLAYER_START_X = 8.989581f;
    public static final float PLAYER_START_Y = 14.348975f;
    private Body body;

    public Player(World world) {
        // createGround(world,PLAYER_START_X,PLAYER_START_Y-3);
        createBoxBody(world, PLAYER_START_X, PLAYER_START_Y);
    }

    public Player(World world, int i, int i1) {


        createBoxBody(world,i,i1);

    }

    public void createGround(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(100, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = PLAYER_DENSITY;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef);
    }
    private void createBoxBody(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.setGravityScale(0);
        body.createFixture(fixtureDef).setUserData("player");
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER /4, BOX_SIZE/ Playscreen.PIXEL_PER_METER/2,new Vector2(25*18/Playscreen.PIXEL_PER_METER,0),0 );
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        body.setGravityScale(0);
        body.createFixture(fixtureDef).setUserData("knife");
    }

    public Body getBody() {
        return body;
    }


}
