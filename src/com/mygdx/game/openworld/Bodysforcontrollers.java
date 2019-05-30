package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Bodysforcontrollers {
    private static final int BOX_Height = 15;
    private static final int BOX_Width = 20;

    private Body Down,left,up,right;
    public Bodysforcontrollers(World world, float enemy_x, float enemy_y){
        createBoxDown(world,enemy_x,enemy_y);
        createBoxLeft(world, enemy_x-BOX_Width*1.6f, enemy_y+BOX_Height*2.3f);
        createBoxUP(world, enemy_x, enemy_y+(BOX_Height+BOX_Width)*1.95f);
        createBoxRight(world, enemy_x+BOX_Width*1.6f, enemy_y+BOX_Height*2.3f);
    }


    private void createBoxDown(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_Width, BOX_Height);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        Down = world.createBody(bdef);
        Down.setGravityScale(0);
        Down.createFixture(fixtureDef);
    }
    private void createBoxLeft(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_Height, BOX_Width);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        left = world.createBody(bdef);
        left.setGravityScale(0);
        left.createFixture(fixtureDef);
    }
    private void createBoxUP(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_Width, BOX_Height);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        up = world.createBody(bdef);
        up.setGravityScale(0);
        up.createFixture(fixtureDef);
    }
    private void createBoxRight(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_Height, BOX_Width);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        right = world.createBody(bdef);
        right.setGravityScale(0);
        right.createFixture(fixtureDef);
    }
    public Body getDown() {
        return Down;
    }

    public Body getLeft() {
        return left;
    }

    public Body getRight() {
        return right;
    }

    public Body getUp() {
        return up;
    }
}
