package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Bignner_Boss {
    private static final int BOX_SIZE = 40;
    private static final float ENEMY_DENSITY = 1.0f;
    public static final float JUMP_FORCE = 250f;
    public static final float RUN_FORCE = 5f;
    public static final float enemyx = 61;
    public static final float enemyy = 14;
    private int helath=3;
    private int damdge=15;
    private Body boss;
    private Body fireball;
    public static  final int Fireball_SIZE=20;


    public Bignner_Boss(World world){
        createBoss(world,enemyx,enemyy);
    }



    private void createBoss(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE  / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = ENEMY_DENSITY;
        boss = world.createBody(bdef);
        boss.createFixture(fixtureDef).setUserData("Boss");

    }

    public Body getBody() {
        return boss;
    }

    public Body createfireball1lvl(World world,float x,float y){
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y+5);
        PolygonShape shape = new PolygonShape();
            shape.setAsBox(Fireball_SIZE / Playscreen.PIXEL_PER_METER / 2, Fireball_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        fixtureDef.density = ENEMY_DENSITY;
        fireball = world.createBody(bdef);
        fireball.createFixture(fixtureDef).setUserData("fireball");
        return fireball;
    }
}
