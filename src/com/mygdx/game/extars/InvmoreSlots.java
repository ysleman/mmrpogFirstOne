package com.mygdx.game.extars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Worldbegginerplace;

import static com.mygdx.game.Worldbegginerplace.POSITION_ITERATIONS;
import static com.mygdx.game.Worldbegginerplace.TIME_STEP;
import static com.mygdx.game.Worldbegginerplace.VELOCITY_ITERATIONS;


public class InvmoreSlots implements Screen {
    private  int[] Equip_Slot_X_Down,Equip_Slot_Y_Down;
    private  int[] Equip_Slot_X,Equip_Slot_Y;
    private  Texture Slot_Space;
    private  int[] SlotSpace_X,SlotSpace_Y;
    public static final float VELOCITY_X = 0f;
    public static final float VELOCITY_Y = -9.8f;
    private  int w;
    private  int h;
    private  Texture Left_Inv;
    private  Texture Right_Inv;
    private  SpriteBatch batch;
    MyGdxGame game;
    public InvmoreSlots(MyGdxGame game){
        this.game=game;
        batch=new SpriteBatch();
        w=Gdx.graphics.getWidth();
        h=Gdx.graphics.getHeight();
        SlotSpace_X=new int[6];
        SlotSpace_Y=new int[6];
        Equip_Slot_X=new int[2];
        Equip_Slot_Y=new int[5];
        Equip_Slot_X_Down=new int[4];
        Equip_Slot_Y_Down=new int[1];
        for(int i=0;i<6;i++) {
             SlotSpace_X[i] = 360+40*i;
        }
        for(int j=0;j<5;j++){
            SlotSpace_Y[j]=(h-170)-53*j;
        }
        Equip_Slot_X[0]=40;
        Equip_Slot_X[1]=240;
        Equip_Slot_X_Down[0]=50;
        Equip_Slot_X_Down[1]=50+40;
        Equip_Slot_X_Down[2]=190;
        Equip_Slot_X_Down[3]=190+40;
        Equip_Slot_Y_Down[0]=h-460;
        for(int j=0;j<Equip_Slot_Y.length;j++){
            Equip_Slot_Y[j]=(h-200)-52*j;
        }
        Left_Inv=new Texture("Left_INv.jpg");
        Slot_Space=new Texture("Slot_PIc.png");
        Right_Inv=new Texture("Right_INv.jpg");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if(Gdx.input.justTouched())System.out.println(Gdx.input.getY());
        //Left side
        batch.draw(Left_Inv,0,0, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        for(int j=0;j<Equip_Slot_Y.length;j++)for(int i=0;i<Equip_Slot_X.length;i++)
            batch.draw(Slot_Space,Equip_Slot_X[i],Equip_Slot_Y[j],40,50);
        for(int j=0;j<Equip_Slot_Y_Down.length;j++)for(int i=0;i<Equip_Slot_X_Down.length;i++)
            batch.draw(Slot_Space,Equip_Slot_X_Down[i],Equip_Slot_Y_Down[j],40,50);
        //Right Side
        batch.draw(Right_Inv,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
        for(int j=0;j<5;j++)
            for(int i=0;i<6;i++)
                batch.draw(Slot_Space,SlotSpace_X[i],SlotSpace_Y[j],40,50);
        if(Gdx.input.justTouched())handleclicks();
        batch.end();
        //Todo:Make the slots items(movinvertoy) and do the transfer button to another
    }

    private void handleclicks() {
        for(int j=0;j<SlotSpace_Y.length;j++)
        for(int i=0;i<SlotSpace_X.length;i++) {
            if (Gdx.input.getX( ) >= SlotSpace_X[i] && Gdx.input.getX( ) <= SlotSpace_X[i] + 40&&Gdx.input.getY()>=(h-SlotSpace_Y[j]-50)&&Gdx.input.getY()<=(h-SlotSpace_Y[j])) {
                System.out.println("True   "+i+"  "+j+"  ");
            }
        }
        for(int j=0;j<Equip_Slot_Y.length;j++)
            for(int i=0;i<Equip_Slot_X.length;i++){
            if(Gdx.input.getX()>=Equip_Slot_X[i]&&Gdx.input.getX()<=(Equip_Slot_X[i]+40)&&Gdx.input.getY()>=(h-Equip_Slot_Y[j]-50)&&Gdx.input.getY()<=(h-Equip_Slot_Y[j])){
                System.out.println("True   "+i+"  "+j+"  ");
            }
        }
        for(int j=0;j<Equip_Slot_Y_Down.length;j++)
            for(int i=0;i<Equip_Slot_X_Down.length;i++){
            if(Gdx.input.getX()>=Equip_Slot_X_Down[i]&&Gdx.input.getX()<=(Equip_Slot_X_Down[i]+40)&&Gdx.input.getY()>=(h-Equip_Slot_Y_Down[j]-50)&&Gdx.input.getY()<=(h-Equip_Slot_Y_Down[j])){
                System.out.println("True   "+i+"  "+j+"  ");
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
