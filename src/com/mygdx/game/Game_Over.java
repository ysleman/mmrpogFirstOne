package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.logging.FileHandler;

public class Game_Over implements Screen {
    private FileHandle fileHandler;
    private  int h;
    private  int w;
    private  BitmapFont font5,font6;
    private  FreeTypeFontGenerator.FreeTypeFontParameter FontParameter;
    private FreeTypeFontGenerator FontGenerator;
    private  SpriteBatch batch;
    MyGdxGame game;
    private float w_Text4;
    private ArrayList<Integer> i;
    int im=-1;
    private ArrayList<String> numCreated,numPointsUsed;
    private ArrayList<String> numTime,numLvl;
    private int currnetnumCreated,currnetnumPointsUsed,currnetnumTime,currnetnumLvl;

    public Game_Over(MyGdxGame game, float currnetnumLvl1, float currnetnumTime1, int currnetnumPointsUsed1, int currnetnumCreated1){
        this.game=game;
        this.currnetnumCreated=currnetnumCreated1;
        this.currnetnumLvl= (int) currnetnumLvl1;
        this.currnetnumPointsUsed=currnetnumPointsUsed1;
        this.currnetnumTime= (int) currnetnumTime1;
        batch=new SpriteBatch();
        i=new ArrayList<Integer>();
        numLvl=new ArrayList<String>();
        numTime=new ArrayList<String>();
        numPointsUsed=new ArrayList<String>();
        numCreated=new ArrayList<String>();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("stocky.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=50;
        FontParameter.characters="_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font5 = FontGenerator.generateFont(FontParameter);
        font5.setColor(Color.WHITE);
        FontGenerator.dispose();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=25;
        FontParameter.characters="_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font6 = FontGenerator.generateFont(FontParameter);
        font6.setColor(Color.WHITE);
        FontGenerator.dispose();
        h=Gdx.graphics.getHeight();
        w=Gdx.graphics.getWidth();
        SaveFile();
        loadFile();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        String Item="Game Over";
        GlyphLayout glyphLayout=new GlyphLayout();
        glyphLayout.setText(font5,Item);
        float w_Text=glyphLayout.width;

        batch.begin();
        //do a big font5 Game over under it in startGame The highscores
        font5.draw(batch,"Game Over",(w-w_Text)/2,h);
        font6.draw(batch,"Name",50,h-50);
        font6.draw(batch,"ItemsN",150,h-50);
        font6.draw(batch,"Points",250,h-50);
        font6.draw(batch,"Time",350,h-50);
        font6.draw(batch,"Lvl",450,h-50);
        loadText();
        font5.draw(batch,"Back",(w-w_Text)/2+100,h-400);
        batch.end();
        handleClick();
    }

    private void loadText() {
        for(int m=0;m<i.size();m++){
            font6.draw(batch,(i.get(m)+1)+".",50,h-50-(m+1)*30);
            font6.draw(batch,""+numCreated.get(m),150,h-50-(m+1)*30);
            font6.draw(batch,""+numPointsUsed.get(m),250,h-50-(m+1)*30);
            font6.draw(batch,""+numTime.get(m),350,h-50-(m+1)*30);
            font6.draw(batch,""+numLvl.get(m),450,h-50-(m+1)*30);
        }
    }

    private void SaveFile(){
        try {
            FileHandle file = Gdx.files.local("data/myfile.txt");
            PrintWriter writer = new PrintWriter(new FileOutputStream(file.path(), true));
            writer.println("Player");
            writer.println("{"+currnetnumCreated+"}");
            writer.println("!"+currnetnumPointsUsed+"!");
            writer.println("/"+currnetnumTime+"/");
            writer.println("|"+currnetnumLvl+"|");
            writer.close( );
        }catch (FileNotFoundException e) {
            e.printStackTrace( );
        }
    }
    private void loadFile(){
        FileHandle file=Gdx.files.local("data/myfile.txt");
        String hi=file.readString();
        String[] wordsArray = hi.split("\\r?\\n");
        for(int m=0;m<wordsArray.length;m++){
            if(wordsArray[m].endsWith("r")){
                im++;
                i.add(im);
            }
            if(wordsArray[m].endsWith("}"))numCreated.add(wordsArray[m].replaceAll("[^-?0-9]+", " "));
            if(wordsArray[m].endsWith("!"))numPointsUsed.add(wordsArray[m].replaceAll("[^-?0-9]+", " "));
            if(wordsArray[m].endsWith("/"))numTime.add(wordsArray[m].replaceAll("[^-?0-9]+", " "));
            if(wordsArray[m].endsWith("|"))numLvl.add(wordsArray[m].replaceAll("[^-?0-9]+", " "));
        }
        System.out.println(im);
    }
    private void handleClick() {
        if(Gdx.input.justTouched()&&Gdx.input.getY()>=h-(h-400)&&Gdx.input.getY()<=h-(0)){
             game.setScreen(new StartGame(game));
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
