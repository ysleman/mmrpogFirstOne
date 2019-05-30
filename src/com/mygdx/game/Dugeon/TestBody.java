package com.mygdx.game.Dugeon;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class TestBody {
    private static final int BOX_SIZE_x = 15;
    private static final int BOX_SIZE_y = 5;
    private Body body;

    public TestBody(World world,int x, int y,int Size,int Size_y){
        createBoxBody(world,x,y,Size,Size_y);
    }
    public TestBody(World world,int x, int y){
        createBoxBody(world,x,y);
    }
    private void createBoxBody(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_x , BOX_SIZE_y );
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef).setUserData("bodyofFish");
    }
    private void createBoxBody(World world, float x, float y,int Size_x,int Size_y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Size_x , Size_y);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef).setUserData("bodyofFish");
    }
}
