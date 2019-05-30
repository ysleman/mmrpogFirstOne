package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class StartGame implements Screen {
    private  BitmapFont font5,font6;
    MyGdxGame game;
    SpriteBatch batch;
    private FreeTypeFontGenerator FontGenerator;
    private  FreeTypeFontGenerator.FreeTypeFontParameter FontParameter;
    private BitmapFont font;
    private int h,w;
    private float w_Text2,w_Text,w_Text1;
    private int Mode_Rightnow=0;
    private float w_Text3;
    private GlyphLayout glyphLayout4;
    private float w_Text4,w_Text5;
    private ArrayList<Integer> i;
    int im=-1;
    private ArrayList<String> numCreated,numPointsUsed;
    private ArrayList<String> numTime,numLvl;
    private float wait_time=0;
    int dwidth=800;
    int dheight=450;
    int ascept_width,ascept_height;
    private float h_text;

    public StartGame(MyGdxGame game){
        this.game=game;
        batch=new SpriteBatch();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=25;
        FontParameter.characters="_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font = FontGenerator.generateFont(FontParameter);
        font.setColor(Color.WHITE);
        FontGenerator.dispose();
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
        i=new ArrayList<Integer>();
        numLvl=new ArrayList<String>();
        numTime=new ArrayList<String>();
        numPointsUsed=new ArrayList<String>();
        numCreated=new ArrayList<String>();
        loadFile();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        GlyphLayout glyphLayout = new GlyphLayout();
        GlyphLayout glyphLayout1 = new GlyphLayout();
        GlyphLayout glyphLayout2 = new GlyphLayout();
        String item = "Play";
        glyphLayout.setText(font5,item);
        h_text=glyphLayout.height;
        item = "High Scores";
        glyphLayout1.setText(font5,item);
        item = "Quit";
        glyphLayout2.setText(font5,item);
        w_Text = glyphLayout.width;
        w_Text1=glyphLayout1.width;
        w_Text2=glyphLayout2.width;
        ascept_width=Gdx.graphics.getWidth()/dwidth;
        ascept_height=Gdx.graphics.getHeight()/dheight;
        batch.begin();
        if(Mode_Rightnow==0) {
            font5.draw(batch, "Play", (w - w_Text) / 2*ascept_width, (h / 2 - 20 + 150)*ascept_height);
            font5.draw(batch, "High Scores", (w - w_Text1) / 2*ascept_width, (h / 2 - 20 + 75)*ascept_height);
            font5.draw(batch, "Quit", (w - w_Text2) / 2*ascept_width, (h / 2 - 20)*ascept_height);
        }
        if(Mode_Rightnow==1){
            String Item="High Scores";
            glyphLayout=new GlyphLayout();
            glyphLayout.setText(font5,Item);
            float w_Text=glyphLayout.width;
            font5.draw(batch,"High Scores",(w-w_Text)/2,h);
            font6.draw(batch,"Name",50*ascept_width,(h-50)*ascept_height);
            font6.draw(batch,"ItemsN",150*ascept_width,(h-50)*ascept_height);
            font6.draw(batch,"Points",250*ascept_width,(h-50)*ascept_height);
            font6.draw(batch,"Time",350*ascept_width,(h-50)*ascept_height);
            font6.draw(batch,"Lvl",450*ascept_width,(h-50)*ascept_height);
            loadText();
            font5.draw(batch,"Back",((w-w_Text)/2+100)*ascept_width,(h-400)*ascept_height);
        }
        if(wait_time>0f){
            item = "Loading...";
            glyphLayout2.setText(font5,item);

            font5.draw(batch,"Loading...",w*ascept_width-glyphLayout2.width,100*ascept_height);
            wait_time+=Gdx.graphics.getRawDeltaTime();
            if(wait_time>5)game.Change_Screen12();
        }
        batch.end();
       if(Gdx.input.justTouched())Handle_Click();
    }
    private void loadText() {
        for(int m=0;m<i.size();m++){
            font6.draw(batch,(i.get(m)+1)+".",50*ascept_width,h-50-(m+1)*30*ascept_height);
            font6.draw(batch,""+numCreated.get(m),150*ascept_width,h-50-(m+1)*30*ascept_height);
            font6.draw(batch,""+numPointsUsed.get(m),250*ascept_width,h-50-(m+1)*30*ascept_height);
            font6.draw(batch,""+numTime.get(m),350*ascept_width,h-50-(m+1)*30*ascept_height);
            font6.draw(batch,""+numLvl.get(m),450*ascept_width,h-50-(m+1)*30*ascept_height);
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
    private void Handle_Click() {
        System.out.println(Gdx.input.getY()+"    "+Gdx.graphics.getWidth()+"   " + Gdx.input.getX() +"   "+ w_Text+"    "+h_text);
        //90
        if(Gdx.input.getX()>=(w-w_Text)/2*ascept_width&&Gdx.input.getX()<=((w-w_Text)/2+w_Text)*ascept_width&&Gdx.input.getY()>=h-(h/2-20+150)*ascept_height&&Gdx.input.getY()<=h-(h/2-20-h_text+150)*ascept_height){
            wait_time+=Gdx.graphics.getRawDeltaTime();
        }

        if(Gdx.input.getX()>=(w_Text1/2.3)*ascept_width&&Gdx.input.getX()<=(w_Text1)*1.5*ascept_width&&Gdx.input.getY()>=h-(h/2-20+75)*ascept_height&&Gdx.input.getY()<=h-(h/2-60+75)*ascept_height){
            Mode_Rightnow=1;
        }
        if(Gdx.input.getX()>=w/2-(w_Text2/2)*ascept_width&&Gdx.input.getX()<=w-(w_Text2*2)*ascept_width&&Gdx.input.getY()>=h-(h/2-20)*ascept_height&&Gdx.input.getY()<=h-(h/2-50)*ascept_height){
           Gdx.app.exit();
        }
        if (Mode_Rightnow==1){
            if(Gdx.input.justTouched()&&Gdx.input.getY()>=h-(h-400)&&Gdx.input.getY()<=h-(0)){
               Mode_Rightnow=0;
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
