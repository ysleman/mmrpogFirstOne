package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

public class Archers{
        private static final int BOX_SIZE = 32;
        private static final float ENEMY_DENSITY = 1.0f;
        public static final float JUMP_FORCE = 250f;
        public static final float RUN_FORCE = 5f;
        public static final float enemyx = 45;
        public static final float enemyy = 17;
        private Body body;
        private int helath=2;
        private int damdge=10;
        private Body archer2;
    private Body arrow;

    public Archers(World world){
            createArchers1(world,enemyx,enemyy);
            createArchers2(world,enemyx,enemyy);
        }



        private void createArchers1(World world, float x, float y) {
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
            body.createFixture(fixtureDef).setUserData("archer1");

        }
         private void createArchers2(World world,float x,float y){
             BodyDef bdef = new BodyDef();
             bdef.fixedRotation = true;
             bdef.type = BodyDef.BodyType.DynamicBody;
             bdef.position.set(x, 12);
             PolygonShape shape = new PolygonShape();
             shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
             FixtureDef fixtureDef = new FixtureDef();
             fixtureDef.shape = shape;
             fixtureDef.density = ENEMY_DENSITY;
             archer2 = world.createBody(bdef);
             archer2.createFixture(fixtureDef).setUserData("archer2");
         }

        public Body getBody() {
            return body;
        }
        public Body getArcher2(){
            return archer2;
        }

    public Body createArrow(World world, float x, float y, float angularVelocity) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE / Playscreen.PIXEL_PER_METER / 2, BOX_SIZE / Playscreen.PIXEL_PER_METER / 2);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        fixtureDef.density = ENEMY_DENSITY;
        arrow = world.createBody(bdef);
        arrow.createFixture(fixtureDef).setUserData("arrow");
        arrow.setGravityScale(0);
        arrow.setLinearVelocity(new Vector2(-10,0));
        return arrow;
    }
}
