package com.mygdx.game.openworld;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Playscreen;

public class Throw_items {
    private static final int BOX_SIZE = 3;
    private Body rat_throw;
    private Body sheep_throw;
    private final float health=2f;
    private Body stone_throw;
    private Body wood_throw;
    private Body goblin_throw;

    public Throw_items(World world, float Enemy_x, float Enemy_y, int i){
        if(i==0)createratthrow(world,Enemy_x,Enemy_y);
        if(i==1)createsheepthrow(world,Enemy_x,Enemy_y);
        if(i==2)creategoblinthrow(world,Enemy_x,Enemy_y);
        if(i==4)createstonethrow(world,Enemy_x,Enemy_y);
        if(i==3)createwoodthrow(world,Enemy_x,Enemy_y);
    }

    private void createsheepthrow(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE , BOX_SIZE);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        sheep_throw = world.createBody(bdef);
        sheep_throw.createFixture(fixtureDef).setUserData("sheep_throw");
    }
    private void creategoblinthrow(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE, BOX_SIZE );
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        goblin_throw = world.createBody(bdef);
        goblin_throw.createFixture(fixtureDef).setUserData("goblin_throw");
    }
    private void createstonethrow(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE , BOX_SIZE);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        stone_throw = world.createBody(bdef);
        stone_throw.createFixture(fixtureDef).setUserData("stone_throw");
    }

    private void createratthrow(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE , BOX_SIZE );
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        rat_throw = world.createBody(bdef);
        rat_throw.createFixture(fixtureDef).setUserData("rat_throw");
    }
    private void createwoodthrow(World world, float x, float y) {
        BodyDef bdef = new BodyDef();
        bdef.fixedRotation = true;
        bdef.type = BodyDef.BodyType.KinematicBody;
        bdef.position.set(x, y);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(BOX_SIZE , BOX_SIZE);
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.isSensor=true;
        wood_throw = world.createBody(bdef);
        wood_throw.createFixture(fixtureDef).setUserData("wood_throw");
    }
    public Body getRat_throw() {
        return rat_throw;
    }
    public Body getSheep_throw(){
        return sheep_throw;
    }
    public Body getStone_throw() {
        return stone_throw;
    }
    public Body getWood_throw() {
        return wood_throw;
    }
    public Body getGoblin_throw() {
        return goblin_throw;
    }
}
