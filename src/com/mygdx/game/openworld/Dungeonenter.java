package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Dungeonenter {

    private Body body;

    public Dungeonenter(World world, float Enemy_x, float Enemy_y){
       createDungeonE(world,Enemy_x,Enemy_y);
    }
    private void createDungeonE(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(18 , 40);
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
