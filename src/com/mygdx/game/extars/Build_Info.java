package com.mygdx.game.extars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.openworld.Invertoy;

public class Build_Info implements Screen {
    private  Texture Gold_ingot;
    private  Texture Iron_ingot;
    private  Texture rat_meat;
    private  Texture outmark;
    private  FreeTypeFontGenerator FontGenerator;
    private  FreeTypeFontGenerator.FreeTypeFontParameter FontParameter;
    private  BitmapFont font4;
    private  Texture inmark;
    private  Texture Build_info;
    private  Texture Right_Inv;
    private  Texture Left_Inv;
    private  Texture Slot_Space;
    private  int[] SlotBuildSpace_Y;
    private  int[] SlotBuildSpace_X;
    private  int h;
    private  int w;
    MyGdxGame game;
    SpriteBatch batch;
    private int[] WhichInfo;
    private Texture Info_texture;
    private Array<Texture> BuildISlots;
    private OrthographicCamera Camera;

    public Build_Info(MyGdxGame game){
        this.game=game;
        rat_meat=new Texture("items/rat_meat.png");
        batch=new SpriteBatch();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=20;
        FontParameter.characters="_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font4 = FontGenerator.generateFont(FontParameter);
        font4.setColor(Color.BLACK);
        FontGenerator.dispose();
        w=Gdx.graphics.getWidth();
        h=Gdx.graphics.getHeight();
        SlotBuildSpace_X =new int[6];
        SlotBuildSpace_Y =new int[6];
        Camera=new OrthographicCamera();
        Camera.setToOrtho(false,w,h);
        Camera.update();
        for(int i=0;i<6;i++) {
            SlotBuildSpace_X[i] = 360+40*i;
        }
        for(int j=0;j<5;j++){
            SlotBuildSpace_Y[j]=(h-170)-53*j;
        }
        Left_Inv=new Texture("Left_INv.jpg");
        Slot_Space=new Texture("Slot_PIc.png");
        Right_Inv=new Texture("Right_INv.jpg");
        Build_info=new Texture("for_item_build.jpg");
        inmark=new Texture("inmark.png");
        outmark=new Texture("outmark.png");
        Iron_ingot=new Texture("items/Iron_Item.jpg");
        Gold_ingot=new Texture("items/Gold_Item.jpg");
        WhichInfo=new int[20];
        BuildISlots =new Array<Texture>();
        BuildISlots.add(Iron_ingot);
        BuildISlots.add(Gold_ingot);
        //**which item to add BuildISlots.add(rat_meat);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.setProjectionMatrix(Camera.combined);
        batch.draw(Right_Inv,w/2,0,w/2,h);
        batch.draw(Build_info,0,0,w/2,h);
        for(int j=0;j<5;j++)
            for(int i=0;i<6;i++)
                batch.draw(Slot_Space, SlotBuildSpace_X[i], SlotBuildSpace_Y[j],40,50);
        if(Gdx.input.justTouched()) handleBuild();
        drawBuildItems();
        TheinfoButton();
        ExitWay();
        batch.end();
    }

    private void ExitWay() {
        if(Gdx.input.getX()<30||Gdx.input.getX()>(w-30)||Gdx.input.getY()<30||Gdx.input.getY()>(h-30)){
            System.out.println("dsaih9hdsas");
        }
    }

    private void drawBuildItems() {
            for (int mmm = 0; mmm < BuildISlots.size ; mmm++) {
               if(mmm<=5)
                   batch.draw(BuildISlots.get(mmm), SlotBuildSpace_X[mmm] + 4, SlotBuildSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                if (mmm > 5 && mmm <= (11))
                    batch.draw(BuildISlots.get(mmm), SlotBuildSpace_X[mmm - 6] + 4, SlotBuildSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                if (mmm > (11) && mmm <= (17))
                    batch.draw(BuildISlots.get(mmm), SlotBuildSpace_X[mmm - 12] + 4, SlotBuildSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                if (mmm > (17) && mmm <= (23))
                    batch.draw(BuildISlots.get(mmm), SlotBuildSpace_X[mmm - 18] + 4, SlotBuildSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                if (mmm > (23) && mmm <= (29))
                    batch.draw(BuildISlots.get(mmm), SlotBuildSpace_X[mmm - 24] + 4, SlotBuildSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);            }
    }

    private void TheinfoButton() {
        /*
        batch.draw(Slot_Space,100, SlotBuildSpace_Y[0],40,50);
        batch.draw(rat_meat,105, SlotBuildSpace_Y[0]+10,30,30);
        font4.draw(batch,"Iron",150, SlotBuildSpace_Y[0]+25);
        batch.draw(Slot_Space,100, SlotBuildSpace_Y[1],40,50);
        batch.draw(rat_meat,105, SlotBuildSpace_Y[1]+10,30,30);
        font4.draw(batch,"Wood",150, SlotBuildSpace_Y[1]+25);
        */
        if(WhichInfo[0]==1) {
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(rat_meat, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font4.draw(batch, "Iron", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
    }

    private void handleBuild() {
        for(int j = 0; j< SlotBuildSpace_Y.length; j++)
            for(int i = 0; i< SlotBuildSpace_X.length; i++) {
                if (Gdx.input.getX( ) >= SlotBuildSpace_X[i] && Gdx.input.getX( ) <= SlotBuildSpace_X[i] + 40&&Gdx.input.getY()>=(h- SlotBuildSpace_Y[j]-50)&&Gdx.input.getY()<=(h- SlotBuildSpace_Y[j])) {
                    System.out.println("True   "+i+"  "+j+"  ");
                    if(i+j*6<BuildISlots.size)if(BuildISlots.get(i+j*6)!=null) {
                        if(BuildISlots.get(i+j*6).getHeight()==rat_meat.getHeight())WhichInfo[0]=1;
                        if(BuildISlots.get(i+j*6).getHeight()!=rat_meat.getHeight())WhichInfo[0]=0;
                        Info_texture=BuildISlots.get(i + j * 6);
                    }
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
