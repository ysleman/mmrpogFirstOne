package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

public class Playscreen implements Screen {
    private final Myinputproccer myinputproccer;
    private  Bignner_Boss Boss;
    private  Contantlistenre Checksides;
    private Body archer1,archer2,BossBody;

    private  Archers spawnarchers;
    private  PolygonShape polygonShape;
    private  FixtureDef fixtureDef;
    private  BodyDef bdef;
    private static final  float momvent=230;

    public MyGdxGame game;
    private static final float SCALE = 2.0f;
    public static final float PIXEL_PER_METER = 32f;
    private static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 6;
    private static final int POSITION_ITERATIONS = 2;
    Body player1,enemy;
    Goblinwalk box;
    int i;

    SpriteBatch batch;
    private Box2DDebugRenderer box2DDebugRenderer;
    private World world;
    private Player player;
    private static final float VELOCITY_Y = -9.8f;
    Texture Healthbar;
    TiledMap tiledMap;
    OrthographicCamera camera;
    TiledMapRenderer tiledMapRenderer;
    private static final float VELOCITY_X = 0f;
    private double dx,dy,length;
    private float timeSeconds=0;
    private float killtimeseconds=0;

    private float period=10f;
    Array<Body> kill=new Array<Body>();
    private int x;
    private float period2=5f;
    private boolean firsttimearrow;
    private boolean firsttimemoved=true;
    private float periodfireball=5f;
    private float periodremovefireball=3f;
    private boolean firsttimefirball=true;
    private float my,mx;
    private double space;
    private int timehit=0;
    private float mx1,my1,mx2,my2;
    private double space1,space2;

    //switchscreen code
   /// this.game.somethinghappen=true;
            //this.game.create();


    public Playscreen(MyGdxGame game){
        this.game=game;
        batch=new SpriteBatch();
        world = new World(new Vector2(VELOCITY_X, VELOCITY_Y), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
         bdef=new BodyDef();
        polygonShape=new PolygonShape();
        fixtureDef =new FixtureDef();
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        Healthbar=new Texture("blank.png");
        camera.setToOrtho(false,w/2/PIXEL_PER_METER,h/2/PIXEL_PER_METER);
        camera.update();
        tiledMap = new TmxMapLoader().load("map/tutrioal.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap,4/PIXEL_PER_METER);
                player = new Player(world);
                box=new Goblinwalk(world);
               spawnarchers=new Archers(world);
                enemy=box.getBody();
              player1 = player.getBody();
              Boss=new Bignner_Boss(world);
              BossBody=Boss.getBody();
        archer1=spawnarchers.getBody();
        archer2=spawnarchers.getArcher2();
              //making no gravity
        enemy.setGravityScale(0);
              player1.setGravityScale(0);
              archer1.setGravityScale(0);
              archer2.setGravityScale(0);
              BossBody.setGravityScale(0);
    TiledObjectlayer.parseTiledObjectLayer(world,tiledMap.getLayers().get(5).getObjects());
    myinputproccer=new Myinputproccer(player1,tiledMap,PIXEL_PER_METER,momvent);
    Gdx.input.setInputProcessor(myinputproccer);
    Checksides=new Contantlistenre(archer1,archer2);
        world.setContactListener(Checksides);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.position.set(player1.getPosition().x, player1.getPosition().y,0);
        camera.update();
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        box2DDebugRenderer.SHAPE_STATIC.set(1,0,0,0);
        box2DDebugRenderer.render(world,camera.combined);
        update();
        //for objects
Followplayer();
timearrow();
movearchers();
magicballs();
check_spacearcher1();
check_spacearcher2();
check_spaceBoss();
batch.begin();
batch.draw(Healthbar,player1.getPosition().x-10,player1.getPosition().y-10,Gdx.graphics.getWidth()*Checksides.Health,10);
batch.end();
    }

    private void check_spacearcher2() {
        mx1=player1.getPosition().x-archer2.getPosition().x;
        my1=player1.getPosition().y-archer2.getPosition().y;
        if(mx1 >-camera.position.x){
            space1=Math.sqrt(mx1*mx1+my1*my1);
            if(space1>0&&space1<=3&&myinputproccer.isHitenable()) {
                timehit++;
                System.out.println("hit");
                if (timehit == 2) {
                    kill.add(archer2);
                    archer2.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                    archer2.setLinearVelocity(0, 0);
                    timehit=0;
                }

            }
        }
    }

    private void check_spaceBoss() {
        mx2=player1.getPosition().x-BossBody.getPosition().x;
        my2=player1.getPosition().y-BossBody.getPosition().y;
        if(mx2 >-camera.position.x){
            space2=Math.sqrt(mx2*mx2+my2*my2);
            if(space2>0&&space2<=3&&myinputproccer.isHitenable()) {
                timehit++;
                System.out.println("hit");
                if (timehit == 3) {
                    kill.add(BossBody);
                    BossBody.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                    BossBody.setLinearVelocity(0, 0);
                    timehit=0;
                }

            }
        }
    }


    private void magicballs() {
        //magicballssummon
        if (mx2 > -camera.position.x) {
            killtimeseconds += Gdx.graphics.getRawDeltaTime();
            if (killtimeseconds > periodfireball) {
                killtimeseconds -= periodfireball;
                kill.add(Boss.createfireball1lvl(world, player1.getPosition().x, player1.getPosition().y));
                firsttimefirball = true;
            }
            if (killtimeseconds > periodremovefireball && firsttimefirball) {
                killtimeseconds -= periodremovefireball;
                for (int x = 0; x < kill.size; x++) {
                    kill.get(x).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                    kill.get(x).setLinearVelocity(0, 0);
                }
                firsttimefirball = false;
            }
        }
    }


    private void movearchers() {
        if (firsttimemoved) {
            archer1.setLinearVelocity(new Vector2(0,10));
            archer2.setLinearVelocity(new Vector2(0,-10));
            firsttimemoved=false;
        }
    }
    public void check_spacearcher1(){
        mx=player1.getPosition().x-archer1.getPosition().x;
        my=player1.getPosition().y-archer1.getPosition().y;
        if(mx >-camera.position.x){
            space=Math.sqrt(mx*mx+my*my);
            if(space>0&&space<=3&&myinputproccer.isHitenable()) {
             timehit++;
             System.out.println("hit");
                if (timehit == 2) {
                    kill.add(archer1);
                    archer1.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                    archer1.setLinearVelocity(0, 0);
                    timehit=0;
                }

            }
        }
    }

    public void Followplayer(){
     dx = player1.getPosition().x - enemy.getPosition().x;
     dy = player1.getPosition().y - enemy.getPosition().y;
     double x,y;
     x=dx;
     y=dy;
     if (dx > -camera.position.x) {//<-for space active
         length = Math.sqrt(x * x + y * y);
         x /= length;
         y /= length; // normalize (make it 1 unit length)
         x *= 7;
         y *= 7; // scale to our desired speed
         if(length>0&&length<=3&&myinputproccer.isHitenable()){
             System.out.println("alive");
             //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
             kill.add(enemy);
             enemy.setTransform(camera.position.x*233,camera.position.y*233,0);
             enemy.setLinearVelocity(0,0);
         }
         if(length>1.5)
             enemy.setLinearVelocity(new Vector2((float) x, (float) y));
         else {
             System.out.println("dead");//to stop the body that follow
             enemy.setLinearVelocity(new Vector2(0,0));
         }
     }
 }

private void timearrow(){
        if(mx1>-camera.position.x) {
            timeSeconds += Gdx.graphics.getRawDeltaTime();
            if (timeSeconds > period) {
                timeSeconds -= period;
                kill.add(spawnarchers.createArrow(world, archer1.getPosition().x, archer1.getPosition().y, player1.getAngularVelocity()));
                kill.add(spawnarchers.createArrow(world, archer2.getPosition().x, archer2.getPosition().y, player1.getAngularVelocity()));
                firsttimearrow = true;
            }
            if (timeSeconds > period2 && firsttimearrow) {
                timeSeconds -= period2;
                for (int x = 0; x < kill.size; x++) {
                    kill.get(x).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                    kill.get(x).setLinearVelocity(0, 0);
                }
                firsttimearrow = false;
            }
        }
      }
    private void update() {
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }
    private void cameraUpdate() {
        Vector3 position = camera.position;
        position.x = player1.getPosition().x * PIXEL_PER_METER;
        position.y = player1.getPosition().y * PIXEL_PER_METER;
        camera.position.set(position);
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
    public void resize(int width, int height) {
    }



    @Override
    public void dispose() {
        box2DDebugRenderer.dispose();
        world.dispose();
    }

}
