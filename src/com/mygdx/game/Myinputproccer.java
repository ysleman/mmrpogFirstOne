package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.openworld.Stone_brick;

import static com.mygdx.game.Playscreen.PIXEL_PER_METER;

public class Myinputproccer implements InputProcessor {
    private final TiledMap tiledMap;
    private final Body player1;
    public float momvent;
    private final float PIXEL_PER_METER;



    private boolean testbuild;
    private boolean up;
    private boolean down;
    private boolean right;
    private boolean left;



    public boolean hitenable=false;
    private int i=0;
    private int z=-1;

    public Myinputproccer(Body player1, TiledMap tiledMap, float pixelPerMeter, float momvent){
        this.player1=player1;
        this.tiledMap=tiledMap;
        this.PIXEL_PER_METER=pixelPerMeter;
        this.momvent=momvent;
    }



    @Override
    public boolean keyDown(int keycode) {
        if(keycode == Input.Keys.LEFT) {
            player1.setLinearVelocity(-momvent, 0);
            left=true;
            right=false;
            up=false;
            down=false;
        }
        if(keycode == Input.Keys.RIGHT) {
            player1.setLinearVelocity(momvent, 0);
            left=false;
            right=true;
            up=false;
            down=false;
        }
        if(keycode == Input.Keys.DOWN) {
            player1.setLinearVelocity(0, -momvent);
            left=false;
            right=false;
            up=false;
            down=true;
        }
        if(keycode == Input.Keys.UP) {
            player1.setLinearVelocity(0, momvent);
            left=false;
            right=false;
            up=true;
            down=false;
        }
        if(keycode==Input.Keys.NUM_9)
            hitenable = true;
        if(keycode==Input.Keys.NUM_7)
            System.out.println("x :"+(int)player1.getPosition().x+"  y :"+(int)player1.getPosition().y);
        if (keycode==Input.Keys.B) {
            System.out.println("rip");
            testbuild = true;
        }



        /*
        if(keycode==Input.Keys.NUM_6)
            player1.setTransform(new Vector2(player1.getPosition().x+20, player1.getPosition().y), player1.getAngle());
        if(keycode==Input.Keys.NUM_4)
            player1.setTransform(new Vector2(player1.getPosition().x-20, player1.getPosition().y), player1.getAngle());
        if(keycode==Input.Keys.NUM_2)
            player1.setTransform(new Vector2(player1.getPosition().x, player1.getPosition().y-20), player1.getAngle());
        if(keycode==Input.Keys.NUM_8)
            player1.setTransform(new Vector2(player1.getPosition().x, player1.getPosition().y+20), player1.getAngle());
          */
        if(keycode==Input.Keys.NUM_6)
            player1.setLinearVelocity(200*10,0);
        if(keycode==Input.Keys.NUM_4)
            player1.setTransform(new Vector2((player1.getPosition().x)-200, player1.getPosition().y), player1.getAngle());
        if(keycode==Input.Keys.NUM_2)
            player1.setTransform(new Vector2(player1.getPosition().x, player1.getPosition().y-200), player1.getAngle());
        if(keycode==Input.Keys.NUM_8)
            player1.setTransform(new Vector2(player1.getPosition().x, player1.getPosition().y+200), player1.getAngle());
        i=1;
        return true;
    }
    public boolean isHitenable() {
        return hitenable;
    }

    public boolean isTestbuild() {
        return testbuild;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }
    @Override
    public boolean keyUp(int keycode) {
        if(i==1) {
            if (keycode == Input.Keys.LEFT) {
                player1.setLinearVelocity(0, 0);
                left=false;
                right=false;
                up=false;
                down=false;
            }
            if (keycode == Input.Keys.RIGHT) {
                left=false;
                right=false;
                up=false;
                down=false;
                player1.setLinearVelocity(0, 0);
            }
            if (keycode == Input.Keys.DOWN) {
                left=false;
                right=false;
                up=false;
                down=false;
                player1.setLinearVelocity(0, 0);
            }
            if (keycode == Input.Keys.UP) {
                left=false;
                right=false;
                up=false;
                down=false;
                player1.setLinearVelocity(0, 0);
            }
            if (keycode==Input.Keys.Z) {
                System.out.println("rip1");
                testbuild = false;
            }
            i=0;
        }
        return true;
    }
    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        System.out.println(screenX+"    "+screenY);//
        if(screenY>= (Gdx.graphics.getHeight()/4)*2&&screenY<=(Gdx.graphics.getHeight()/3)*2&&screenX<=(Gdx.graphics.getWidth()/3-Gdx.graphics.getWidth()/10)&&screenX>=Gdx.graphics.getWidth()/10){
            player1.setLinearVelocity(new Vector2(0,momvent));
            left=false;
            right=false;
            up=true;
            down=false;
        }
        hitenable=true;
        if(screenY>=(Gdx.graphics.getHeight()/6)*5&&screenX<=(Gdx.graphics.getWidth()/3-Gdx.graphics.getWidth()/10)&&screenX>=Gdx.graphics.getWidth()/10){
            player1.setLinearVelocity(new Vector2(0,-momvent));
            left=false;
            right=false;
            up=false;
            down=true;
        }
        if(screenX<=(Gdx.graphics.getWidth()/10)&&screenY>=Gdx.graphics.getHeight()/3*2&&screenY<=(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/6)){
            player1.setLinearVelocity(new Vector2(-momvent,0));
            System.out.println("Left   "+screenX+"    ");
            left=true;
            right=false;
            up=false;
            down=false;
        }
        if(screenX>=(Gdx.graphics.getWidth()/10)*2&&screenX<=(Gdx.graphics.getWidth()/9)*3&&screenY>=Gdx.graphics.getHeight()/3*2&&screenY<=(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/6)){
            player1.setLinearVelocity(new Vector2(momvent,0));
            System.out.println("Right  "+screenX+"    "+(Gdx.graphics.getWidth()/4)*3);
            left=false;
            right=true;
            up=false;
            down=false;
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(screenY>= (Gdx.graphics.getHeight()/4)*2&&screenY<=(Gdx.graphics.getHeight()/3)*2&&screenX<=(Gdx.graphics.getWidth()/3-Gdx.graphics.getWidth()/10)&&screenX>=Gdx.graphics.getWidth()/10){
            player1.setLinearVelocity(new Vector2(0,0));
            left=false;
            right=false;
            up=false;
            down=false;
        }
        hitenable=true;
        if(screenY>=(Gdx.graphics.getHeight()/6)*5&&screenX<=(Gdx.graphics.getWidth()/3-Gdx.graphics.getWidth()/10)&&screenX>=Gdx.graphics.getWidth()/10){
            player1.setLinearVelocity(new Vector2(0,0));
            left=false;
            right=false;
            up=false;
            down=false;
        }
        if(screenX<=(Gdx.graphics.getWidth()/10)&&screenY>=Gdx.graphics.getHeight()/3*2&&screenY<=(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/6)){
            player1.setLinearVelocity(new Vector2(0,0));
            left=false;
            right=false;
            up=false;
            down=false;
        }
        if(screenX>=(Gdx.graphics.getWidth()/10)*2&&screenX<=(Gdx.graphics.getWidth()/9)*3&&screenY>=Gdx.graphics.getHeight()/3*2&&screenY<=(Gdx.graphics.getHeight()-Gdx.graphics.getHeight()/6)){
            player1.setLinearVelocity(new Vector2(0,0));
            left=false;
            right=false;
            up=false;
            down=false;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


}
