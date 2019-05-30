package com.mygdx.game.extars;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Worldbegginerplace;

public class Stats_Change implements Screen {
    private Texture Background;
    private  int Main_reduce;
    private int howmanytimes_lefttoadd;
    private int level_Main;//last time_Stats u changed it
    int level;
    MyGdxGame game;
    private  Texture meat;
    private  Texture Speed;
    private  Texture addRestunce;
    private  Texture AttackDamdge;
    private  BitmapFont font2;
    private  Texture outmark;
    private  Texture inmark;
    private  Texture QuestionM;
    private  Texture decres;
    private  Texture Add;
    private  Texture heart;
    private  SpriteBatch batch;
    private  FreeTypeFontGenerator.FreeTypeFontParameter FontParameter;
    private  FreeTypeFontGenerator FontGenerator;
    private int Main_hunger=1,Main_health=1,Main_agilty=1,Main_attack=1,Main_Immunity=1;
    private int addHunger =Main_hunger;
    private int addHelath =Main_health;
    private int addattack=Main_attack;
    private int addImmunity=Main_Immunity;
    private int addagility=Main_agilty;
    private int up_Stats=40;
    private int Width_Stats=-Gdx.graphics.getWidth()/2/10;
    private String which_writing="";
    private float time_Stats =0;

    public Stats_Change(MyGdxGame game,int Level,int Level_Main){
        howmanytimes_lefttoadd =level- level_Main;
        Main_reduce=level- level_Main;
        this.game=game;
         batch=new SpriteBatch();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=20;
        FontParameter.characters="_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font2 = FontGenerator.generateFont(FontParameter);
        font2.setColor(Color.WHITE);
        FontGenerator.dispose();
        Background=new Texture("Background1.PNG");
        heart=new Texture("heart.png");
        Add=new Texture("add.png");
        decres=new Texture("decrse.png");
        QuestionM=new Texture("QuestionM.png");
        inmark=new Texture("inmark.png");
        outmark=new Texture("outmark.png");
        AttackDamdge=new Texture("sword_small.png");
        addRestunce=new Texture("a_shield_round.png");
        Speed=new Texture("foot.png");
        meat=new Texture("items/rat_meat.png");
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(Background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        //Health regnant  every 5 times by speed regeant = 0.1 * how many times  /5
        font2.draw(batch,"Health:",Gdx.graphics.getWidth()/2-50+Width_Stats,Gdx.graphics.getHeight()/2+115+up_Stats);
        batch.draw(heart,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,60,60);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50,50);
        batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30,30);
        font2.draw(batch,""+addHelath,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2+115+up_Stats);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50,50);
        batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30,30);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50,50);
        batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30,30);
        //attack reduce time_Stats every 4 is old time_Stats/1/4 * by how many times is 4 just 4
        font2.draw(batch,"Attack:",Gdx.graphics.getWidth()/2-50+Width_Stats,Gdx.graphics.getHeight()/2+65+up_Stats);
        batch.draw(AttackDamdge,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,60,60);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50,50);
        batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30,30);
        font2.draw(batch,""+addattack,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2+65+up_Stats);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50,50);
        batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30,30);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50,50);
        batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30,30);
        //redcue damdge every 6 times old damdge /1/4
        font2.draw(batch,"Immunity :",Gdx.graphics.getWidth()/2-70+Width_Stats,Gdx.graphics.getHeight()/2+15+up_Stats);
        batch.draw(addRestunce,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,60,60);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50,50);
        batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30,30);
        font2.draw(batch,""+addImmunity,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2+15+up_Stats);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50,50);
        batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30,30);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50,50);
        batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30,30);
        //agility =movement is add speed every 5 old speed*1/5
        font2.draw(batch,"Agility:",Gdx.graphics.getWidth()/2-70+Width_Stats,Gdx.graphics.getHeight()/2-45+up_Stats);
        batch.draw(Speed,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,60,60);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
        batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
        font2.draw(batch,""+addagility,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2-45+up_Stats);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
        batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
        batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
        //Hunger reduce =hunger time_Stats+(hungertime*0.2)
        font2.draw(batch,"Hunger:",Gdx.graphics.getWidth()/2-50+Width_Stats,Gdx.graphics.getHeight()/2-105+up_Stats);
        batch.draw(meat,Gdx.graphics.getWidth()/2-130+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,60,60);
        batch.draw(addRestunce,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,60,60);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,50,50);
        batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-125+up_Stats,30,30);
        font2.draw(batch,""+addHunger,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2-105+up_Stats);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,50,50);
        batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-125+up_Stats,30,30);
        batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,50,50);
        batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-125+up_Stats,30,30);
        //Done
        batch.draw(inmark,Gdx.graphics.getWidth()/2+Width_Stats,Gdx.graphics.getHeight()/2-195+up_Stats,50,50);
        font2.draw(batch,"Done",Gdx.graphics.getWidth()/2+Width_Stats,Gdx.graphics.getHeight()/2-165+up_Stats);
        //The writing place
        if(which_writing!=""){
            time_Stats +=Gdx.graphics.getRawDeltaTime();
            if(time_Stats <1f) font2.draw(batch, which_writing, Gdx.graphics.getWidth( ) / 2 - 100 + Width_Stats, Gdx.graphics.getHeight( ) / 2 - 215 + up_Stats);
            if(time_Stats >1f){
                time_Stats =0;
                which_writing="";
            }
        }
        Handle_Stats();
        batch.end();
    }

    private void Handle_Stats() {
        if(Gdx.input.justTouched()) {
            System.out.println(Gdx.input.getX( ) + "    " + Gdx.input.getY( ));
            //add
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 40 +Width_Stats&& Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 90 +Width_Stats&& Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 135 +-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 - 85+-up_Stats) {
                System.out.println("Health +");
                if (howmanytimes_lefttoadd > 0) {
                    addHelath += 1;
                    howmanytimes_lefttoadd -= 1;
                }
                else which_writing="Cant add anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50,50);
                batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30,30);
            }
            //reduce
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 135+-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 - 85+-up_Stats) {
                System.out.println("health -");
                batch.draw(outmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50,50);
                batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30,30);
                if (howmanytimes_lefttoadd < Main_reduce&&addHelath>Main_health) {
                    addHelath -= 1;
                    howmanytimes_lefttoadd += 1;
                }
                else which_writing="Cant reduce anymore";
            }
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 140 +Width_Stats&& Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 200+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 135+-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 - 85+-up_Stats)
            {
                batch.draw(outmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50,50);
                batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30,30);
                System.out.println("health ?");
                which_writing="getting your health back";
            }

            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 40 +Width_Stats&& Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 85+-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 - 35+-up_Stats) {
                System.out.println("attack +");
                if (howmanytimes_lefttoadd > 0) {
                    addattack += 1;
                    howmanytimes_lefttoadd -= 1;
                }
                else which_writing="Cant add anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50,50);
                batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30,30);
            }
            //reduce
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 140 +Width_Stats&& Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 85+-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 - 35+-up_Stats) {
                System.out.println("attack -");
                if (howmanytimes_lefttoadd < Main_reduce&&addattack>Main_attack) {
                    addattack -= 1;
                    howmanytimes_lefttoadd += 1;
                }
                else which_writing="Cant reduce anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50,50);
                batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30,30);
            }
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 200+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 85+-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 - 35+-up_Stats)
            {
                System.out.println("attack ?");
                which_writing="attack power more Stronger";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50,50);
                batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30,30);
            }

            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 40 +Width_Stats&& Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 35 +-up_Stats&& Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 25+-up_Stats) {
                System.out.println("Immunity +");
                if (howmanytimes_lefttoadd > 0) {
                    addImmunity += 1;
                    howmanytimes_lefttoadd -= 1;
                }
                else which_writing="Cant add anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50,50);
                batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30,30);
            }
            //reduce
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 35-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 25+-up_Stats){
                System.out.println("Immunity -");
                if (howmanytimes_lefttoadd < Main_reduce&&addImmunity>Main_Immunity) {
                    addImmunity -= 1;
                    howmanytimes_lefttoadd += 1;
                }
                else which_writing="Cant reduce anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50,50);
                batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30,30);
            }
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 140 +Width_Stats&& Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 200+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 - 35-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 25-up_Stats)
            {
                System.out.println("Immunity ?");
                which_writing="reduce damdge u taken";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50,50);
                batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30,30);
            }

            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 40+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 + 25 -up_Stats&& Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 75-up_Stats) {
                System.out.println("Agility +");
                if (howmanytimes_lefttoadd > 0) {
                    addagility += 1;
                    howmanytimes_lefttoadd -= 1;
                }
                else which_writing="Cant add anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
                batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
            }
            //reduce
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 + 25-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 75+-up_Stats){
                System.out.println("Agility -");
                if (howmanytimes_lefttoadd < Main_reduce&&addagility>Main_agilty) {
                    addagility -= 1;
                    howmanytimes_lefttoadd += 1;
                }
                else which_writing="Cant reduce anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
                batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
            }
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 200+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 + 25 -up_Stats&& Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 75-up_Stats)
            {
                System.out.println("Agility ?");
                which_writing="your speed";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
                batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);

            }

            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 40+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 + 85-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 135-up_Stats){
                System.out.println("Hunger +");
                batch.draw(outmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,50,50);
                batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-125+up_Stats,30,30);
                if (howmanytimes_lefttoadd > 0) {
                    addHunger += 1;
                    howmanytimes_lefttoadd -= 1;
                }
                else which_writing="Cant add anymore";
            }
            //reduce
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats&&Gdx.input.getY()>=Gdx.graphics.getHeight()/2+85-up_Stats&&Gdx.input.getY()<=Gdx.graphics.getHeight()/2+135-up_Stats)
            {
                batch.draw(outmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,50,50);
                batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-125+up_Stats,30,30);
                System.out.println("Hunger -");
                if (howmanytimes_lefttoadd < Main_reduce&&addHunger>Main_hunger) {
                    addHunger -= 1;
                    howmanytimes_lefttoadd += 1;
                }
                else which_writing="Cant reduce anymore";
            }

            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 200+Width_Stats&&Gdx.input.getY()>=Gdx.graphics.getHeight()/2+85-up_Stats&&Gdx.input.getY()<=Gdx.graphics.getHeight()/2+135-up_Stats)
            {
                batch.draw(outmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-135+up_Stats,50,50);
                batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-125+up_Stats,30,30);
                System.out.println("Hunger ?");
                which_writing="hunger time_Stats reduce";
            }
            if(Gdx.input.getX()>=Gdx.graphics.getWidth()/2+Width_Stats&&Gdx.input.getX()<=Gdx.graphics.getWidth()/2+Width_Stats+50&&Gdx.input.getY()>=Gdx.graphics.getHeight()/2+145-up_Stats&&Gdx.input.getY()<=Gdx.graphics.getHeight()/2+195-up_Stats)
            {
                level_Main=level;
                Main_hunger=addHunger;
                Main_agilty=addagility;
                Main_Immunity=addImmunity;
                Main_attack=addattack;
                Main_health=addHelath;
                howmanytimes_lefttoadd =level- level_Main;
                Main_reduce=level- level_Main;
                batch.draw(outmark,Gdx.graphics.getWidth()/2+Width_Stats,Gdx.graphics.getHeight()/2-195+up_Stats,50,50);
                System.out.println("Exit");
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
