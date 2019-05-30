package com.mygdx.game.Dugeon;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Golem {
    private static final int BOX_SIZE = 13;
    private Body body;
    public Golem(World world, float enemy_x, float enemy_y){
        createBoxBody(world,enemy_x,enemy_y);
    }


    private void createBoxBody(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE , BOX_SIZE );
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body = world.createBody(bdef);
        body.setGravityScale(0);
        body.createFixture(fixtureDef);
    }

    public Body getBody() {
        return body;
    }
}
