package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Playscreen;

public class Stone_brick {
    private static final int BOX_SIZE = 40*10;
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

    private final float Enemy_x=15f*8;
    private final float Enemy_y=2.7f*8;
    private final float Enemy_x1=13*8;
    private final float Enemy_y1=4.8f*8;

    private final float health=2f;
    public Stone_brick(World world) {
        createStone1(world,Enemy_x,Enemy_y);
        createStone2(world,Enemy_x1,Enemy_y);
        createStone3(world,Enemy_x,Enemy_y1);
        createStone4(world,Enemy_x1,Enemy_y1);
    }
    public  Stone_brick(World world,int i)
    {
        createStone1(world,Enemy_x,Enemy_y);
    }
    public  Stone_brick(World world,String string)
    {

        createStone2(world,Enemy_x1,Enemy_y);
    }
    public  Stone_brick(World world,boolean boo)
    {
        createStone3(world,Enemy_x,Enemy_y1);
    }
    public  Stone_brick(World world,int i,boolean boo)
    {
        createStone4(world,Enemy_x1,Enemy_y1);
    }

    public Stone_brick(World world,float x,float y) {
        createStoneB(world,x,y);
    }
    private void createStone1(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef).setUserData("Stone");
    }
    private void createStone2(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body2 = world.createBody(bdef);
        body2.createFixture(fixtureDef).setUserData("Stone");
    }private void createStone3(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body3 = world.createBody(bdef);
        body3.createFixture(fixtureDef).setUserData("Stone");
    }
    private void createStone4(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body4 = world.createBody(bdef);
        body4.createFixture(fixtureDef).setUserData("Stone");
    }
    private void createStoneB(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.StaticBody;
        //there the sides check
        bdef.position.set(x+1, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        bodyB = world.createBody(bdef);
        bodyB.createFixture(fixtureDef).setUserData("Stone_Build");
    }
    public Body getBody() {
        return body;
    }
}
