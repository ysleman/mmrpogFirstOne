package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class Contantlistenre implements ContactListener {
    Body archer1,archer2,ground;
    public float Health=1f;

   public boolean oppsitesideground=false,oppsitesidearcher=false;

    public Contantlistenre(Body archer1, Body archer2) {
        this.archer1=archer1;
        this.archer2=archer2;
    }

    public Contantlistenre() {
   ///not for use
    }
    @Override
    public void beginContact(Contact contact) {
         System.out.println("a="+contact.getFixtureA().getUserData()+"b="+contact.getFixtureB().getUserData());
        if(contact.getFixtureA().getUserData().equals("ground"))
            if(contact.getFixtureB().getUserData().equals("archer1")) {
                oppsitesideground=true;
            archer1.setLinearVelocity(new Vector2(0,-10));
                archer2.setLinearVelocity(new Vector2(0,10));
            }
        if(contact.getFixtureB().getUserData().equals("ground")){
            if(contact.getFixtureA().getUserData().equals("archer2"))
                oppsitesideground=true;
            archer1.setLinearVelocity(new Vector2(0,-10));
            archer2.setLinearVelocity(new Vector2(0,10));
        }
        if(contact.getFixtureA().getUserData().equals("archer1"))
            if(contact.getFixtureB().getUserData().equals("archer2")){
                archer1.setLinearVelocity(new Vector2(0,10));
                archer2.setLinearVelocity(new Vector2(0,-10));
            oppsitesidearcher=true;
        }
        if(contact.getFixtureA().getUserData().equals("player"))
            if(contact.getFixtureB().getUserData().equals("arrow"))
                Health=-0.1f;
        if(contact.getFixtureA().getUserData().equals("arrow"))
            if(contact.getFixtureB().getUserData().equals("player"))
                Health-=0.1f;
        if(contact.getFixtureA().getUserData().equals("player"))
            if(contact.getFixtureB().getUserData().equals("archer1")){
                Health-=0.08f;
                contact.getFixtureB().getBody().setLinearVelocity(0,0);
            }
        if(contact.getFixtureA().getUserData().equals("player"))
            if(contact.getFixtureB().getUserData().equals("archer2")){
                Health-=0.08f;
                contact.getFixtureB().getBody().setLinearVelocity(0,0);

            }
        if(contact.getFixtureA().getUserData().equals("archer1"))
            if(contact.getFixtureB().getUserData().equals("player"))
                Health-=0.08f;
        if(contact.getFixtureA().getUserData().equals("archer2"))
            if(contact.getFixtureB().getUserData().equals("player"))
                Health-=0.08f;
        if(contact.getFixtureA().getUserData().equals("player"))
            if(contact.getFixtureB().getUserData().equals("Boss")) {
                contact.getFixtureB().getBody().setLinearVelocity(0,0);
                Health -= 0.08f;
            }

        if(contact.getFixtureA().getUserData().equals("Boss"))
            if(contact.getFixtureB().getUserData().equals("player"))
                Health-=0.08f;
        if(contact.getFixtureA().getUserData().equals("fireball"))
            if(contact.getFixtureB().getUserData().equals("player"))
                Health-=0.15f;
        if(contact.getFixtureA().getUserData().equals("player"))
            if(contact.getFixtureB().getUserData().equals("fireball"))
                Health-=0.15f;
        if(contact.getFixtureA().getUserData().equals("knife"))if(contact.getFixtureB().getUserData().equals("Boss")){

        }
        System.out.println("Health="+Health);
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
