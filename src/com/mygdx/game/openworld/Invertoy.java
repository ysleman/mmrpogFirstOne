package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Playscreen;

public class Invertoy {
    public static final int BOX_SIZE_hight = 25*25;
    public static final int BOX_SIZE_width = 200*25;

    public static final int BOX_SIZE_hight_part = BOX_SIZE_hight;
    public static final int BOX_SIZE_width_part = BOX_SIZE_width/8;
    public static final float FInal_diffrent=BOX_SIZE_width_part/Playscreen.PIXEL_PER_METER;

    private Body body;
    private Body part1;
    private Body part2;
    private Body part3;
    private Body part4;
    private Body part5;
    private Body part6;
    private Body part7;
    private Body part8;
    private Body bag;

    public Invertoy(World world,float Enemy_x,float Enemy_y){
        startbuilidng(world,Enemy_x,Enemy_y);
    }
    public void startbuilidng(World world,float xof_start,float yof_start){
        createpart1(world,xof_start,yof_start);
        createpart2(world,part1.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createpart3(world,part2.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createpart4(world,part3.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createpart5(world,part4.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createpart6(world,part5.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createpart7(world,part6.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createpart8(world,part7.getPosition().x+FInal_diffrent,part1.getPosition().y);
        createbag(world,part8.getPosition().x+FInal_diffrent,part1.getPosition().y);
    }

    private void createBoxBody(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef).setUserData("invertoy");

    }

    private void createpart1(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor=true;
        fixtureDef.shape = shape;
        part1 = world.createBody(bdef);
        part1.createFixture(fixtureDef).setUserData("part1");

    }
    private void createpart2(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor=true;
        fixtureDef.shape = shape;
        part2 = world.createBody(bdef);
        part2.createFixture(fixtureDef).setUserData("part2");

    }
    private void createpart3(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.isSensor=true;
        fixtureDef.shape = shape;
        part3 = world.createBody(bdef);
        part3.createFixture(fixtureDef).setUserData("part3");

    }
    private void createpart4(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        part4 = world.createBody(bdef);
        part4.createFixture(fixtureDef).setUserData("part4");

    }
    private void createpart5(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        part5 = world.createBody(bdef);
        part5.createFixture(fixtureDef).setUserData("part5");

    }
    private void createpart6(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        part6 = world.createBody(bdef);
        part6.createFixture(fixtureDef).setUserData("part6");

    }
    private void createpart7(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        part7 = world.createBody(bdef);
        part7.createFixture(fixtureDef).setUserData("part7");

    }
    private void createpart8(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        part8 = world.createBody(bdef);
        part8.createFixture(fixtureDef).setUserData("part8");

    }
    private void createbag(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        bag = world.createBody(bdef);
        bag.createFixture(fixtureDef).setUserData("bag");

    }

    public Body getBody() {
        return body;
    }
    public Body getPart1() {
        return part1;
    }

    public Body getPart2() {
        return part2;
    }

    public Body getPart3() {
        return part3;
    }

    public Body getPart4() {
        return part4;
    }

    public Body getPart5() {
        return part5;
    }

    public Body getPart6() {
        return part6;
    }

    public Body getPart7() {
        return part7;
    }

    public Body getPart8() {
        return part8;
    }

    public Body getBag() {
        return bag;
    }

}
