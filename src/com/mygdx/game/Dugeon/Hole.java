package com.mygdx.game.Dugeon;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Hole {
    private static final int BOX_SIZE_x = 10;
    private static final int BOX_SIZE_y = 10;
    private Body body;

    public Hole(World world,int x, int y){
        createBoxBody(world,x,y);
    }
    private void createBoxBody(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE_x , BOX_SIZE_y );
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        body = world.createBody(bdef);
        body.createFixture(fixtureDef);
    }

    public Body getBody() {
        return body;
    }
}
