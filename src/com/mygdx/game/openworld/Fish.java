package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Playscreen;

public class Fish {
    private static final int BOX_SIZE_x = 15;
    private static final int BOX_SIZE_y = 5;
    private Body body;
    private final float Enemy_x=925;
    private final float Enemy_y=358;
    private Body body1;

    public Fish(World world){
        createBoxBody(world,Enemy_x,Enemy_y);
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
    public void createGiftItem(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(16 , 16 );
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        body1 = world.createBody(bdef);
        body1.createFixture(fixtureDef).setUserData("Fish");
    }

    public Body getBody() {
        return body;
    }

    public Body getBody1() {
        return body1;
    }
}
