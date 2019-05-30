package com.mygdx.game;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Goblinwalk {
    private static final int BOX_SIZE = 32;
    private static final float ENEMY_DENSITY = 1.0f;
    public static final float JUMP_FORCE = 250f;
    public static final float RUN_FORCE = 5f;
    public static final float enemyx = 27;
    public static final float enemyy = 14;
    private Body body;
    public Goblinwalk(World world){
        createBoxBody(world,enemyx,enemyy);
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
        fixtureDef.density = ENEMY_DENSITY;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef).setUserData("goblin_knife");

    }

    public Body getBody() {
        return body;
    }

}
