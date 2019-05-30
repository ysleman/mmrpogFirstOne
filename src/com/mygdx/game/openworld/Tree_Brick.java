package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Playscreen;

public class Tree_Brick {
    private static final int BOX_SIZE = 50*10;
    private static final int BOX_length =160*10 ;
    private Body body;
    private Body body2;
    private Body body3;

    public Body getBodyB() {
        return bodyB;
    }

    private Body bodyB;

    public Body getBody2() {
        return body2;
    }

    public Body getBody3() {
        return body3;
    }
    private Body body4;
    public Body getBody4() {
        return body4;
    }

    private final float Enemy_x=46.8f*8;
    private final float Enemy_y=47f*8;
    private final float Enemy_x1=36.8f*8;
    private final float Enemy_y1=37f*8;


    private final float health=2f;
    public Tree_Brick(World world) {
        createTree1(world,Enemy_x,Enemy_y);
        createTree2(world,Enemy_x1,Enemy_y1);
    }
    public Tree_Brick(World world,int i){
        createTree1(world,Enemy_x,Enemy_y);

    }
    public Tree_Brick(World world,int i,String a){
        createTree2(world,Enemy_x1,Enemy_y1);
    }
    public Tree_Brick(World world,float x,float y) {
        createTreeB(world,x,y);
    }
    private void createTree1(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_length / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE/ Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef).setUserData("Stone");
    }
    private void createTree2(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_length / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body2 = world.createBody(bdef);
        body2.createFixture(fixtureDef).setUserData("Tree");
    }
    private void createTreeB(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        //there the sides check
        bdef.position.set(x+1, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        bodyB = world.createBody(bdef);
        bodyB.createFixture(fixtureDef).setUserData("Tree_Build");
    }
    public Body getBody() {
        return body;
    }
}
