package com.mygdx.game.Dugeon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Myinputproccer;
import com.mygdx.game.Player;
import com.mygdx.game.Playscreen;
import com.mygdx.game.TiledObjectlayer;
import com.mygdx.game.Worldbegginerplace;
import com.mygdx.game.openworld.Bodysforcontrollers;
import com.mygdx.game.openworld.Dungeonenter;
import com.mygdx.game.openworld.Invertoy;
import com.mygdx.game.openworld.Stone_brick;
import com.mygdx.game.openworld.Throw_items;
import com.mygdx.game.openworld.Tree_Brick;

import java.util.ArrayList;

public class Dungeon_2 implements Screen {
    private static final float SkeletonSize = 30;
    private static final float SkeletonSpeed = 30;
    private static final float GolemSize = 30;
    private static final float GolemSpeed = 20;
    private static final float GhostSize = 30;
    private Random_mobs random_mobs;
    private int dungeon=2;
    private TiledMap map1;
    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private TiledMapTileLayer mapLayer;
    private Player player;
    private Body player1;
    private final Box2DDebugRenderer box2DDebugRenderer;
    private final World world;
    private TextureAtlas atlasright,atlasghost_died,atlasghost_attack;
    private TextureAtlas atlasdown;
    private TextureAtlas atlasup;
    private TextureAtlas atlasleft;
    private TextureAtlas atlasgolem_attack_up,atlasgolem_attack_down,atlasgolem_attack_right,atlasgolem_attack_left;
    private TextureAtlas atlasgolemMove_up,atlasgolemMove_down,atlasgolemMove_right,atlasgolemMove_left;
    private TextureAtlas atlasgolem_died;
    private TextureAtlas atlasskeleton_up,atlasskeleton_down,atlasskeleton_right,atlasskeleton_left;
    private int[] ItemsCollect;
    private Texture invertoy_backgroundT;
    private Cell cell;
    private int i=0;
    MyGdxGame game;
    private TiledMap map;
    private TiledMapRenderer renderer;
    private OrthographicCamera camera,camera1;
    private AssetManager assetManager;
    private Texture tiles;
    private Texture texture;
    private BitmapFont font;
    private SpriteBatch batch;
    private ArrayList<Integer> x_list;
    private ArrayList<Integer> y_list;
    private Myinputproccer myinputproccer;
    private Animation animationright;
    private Animation animationleft;
    private Animation aniamtionup;
    private Animation animationdown;
    private Texture Healthbar;
    private Texture Emptybar;
    private float Level=0;
    private int numL=1;
    private Texture Levelbar;
    private float timeloop4;
    private float Health=1f;
    private Body[] Invertoyparts;
    private Body invertoybuild;
    private boolean first=true;
    private Array<Texture> ISlots;
    private int FloorNUM=1;
    private Body hole1,hole2,hole3,hole4,hole5;
    private Body Stair_Down, Stair_up;
    private Texture holeT;
    private Texture StairU,StairD;
    private boolean onhole1=false,onhole5=false,onhole4=false,onhole3=false,onhole2=false;
    private float dx,dy,dx2,dy2,dx3,dy3,dx4,dy4,dx5,dy5,dx6,dy6,dx7,dy7;
    private double length,length2,length3,length4,length5,length6,length7;
    ArrayList<Integer> Dungeon_list;
    private Texture rat_meat;
    private Texture sheep_meat;
    private Texture FishT;
    private Texture rockT;
    private Texture woodT;
    private Animation ghostA_attack_Right,ghostA_died;
    private Animation Golem_attack_Right,Golem_died,Golem_attack_up, Golem_attack_left, Golem_attack_down;
    private Animation Golem_walk_Right,Golem_walk_up, Golem_walk_left, Golem_walk_down;
    private Animation skeleton_walk_Right,skeleton_walk_up, skeleton_walk_left, skeleton_walk_down;
    private Array<Body> GhostBody,GolemBody,SkeletonBody;
    private Array<Float> timeloop;
    private float periodloop=3f;
    private Array<Boolean> moveleft_skeleton;
    private Array<Boolean> moveright_skeleton;
    private Array<Boolean> enableanimatonSkeleton;
    private Array<Boolean> movesides_skeleton;
    private float Skeleton_Width;
    private float Skeleton_Height;
    private int i3;
    private Array<Float> timeloop2;
    private Array<Boolean> moveright_Golem;
    private Array<Boolean> enableanimatonGolem;
    private Array<Boolean> movesides_Golem;
    private Array<Boolean> moveleft_Golem;
    private int i4;
    private Array<Float> timeloop_S;
    private Array<Float> dx_S,dy_S;
    private Array<Double> length_S;
    private Array<Boolean> hitforSkeletonEnable;
    private Array<Boolean> activefollowsystem_S;
    private Array<Float> timehit_S;
    private Array<Boolean> hit_S;
    private float Skeleton_DOWN_X,Skeleton_DOWN_Y,Skeleton_UP_Y,Skeleton_UP_X;
    private Array<Float> timeloop_Golem;
    private Array<Float> dx_Golem,dy_Golem;
    private Array<Double> length_Golem;
    private Array<Boolean> hitforGolemEnable;
    private Array<Boolean> activefollowsystem_Golem;
    private Array<Float> timehit_Golem;
    private Array<Boolean> hit_Golem;
    private float Golem_DOWN_X,Golem_DOWN_Y,Golem_UP_Y,Golem_UP_X;
    private Texture Ghost_Standing;
    private Array<Float> timeloop_Ghost;
    private Array<Float> dx_Ghost,dy_Ghost;
    private Array<Double> length_Ghost;
    private Array<Boolean> hitforGhostEnable;
    private Array<Boolean> activefollowsystem_Ghost;
    private Array<Float> timehit_Ghost;
    private Array<Boolean> hit_Ghost;
    private int i5;
    private float Ghost_Width,Ghost_Height;
    private float Ghost_Width_Died,Ghost_Height_Died;
    private Array<Float> timeloopA_Ghost_Right;
    private Array<Float> timeloopA_Golem;
    private float Golem_AttackDOWN_X;
    private float Golem_AttackDOWN_Y;
    private float Golem_Height_Attack,Golem_AttackUp_X,Golem_AttackUp_Y,Golem_Width_Attack;
    private TextureAtlas Ghost_attack_left;
    private Animation ghost_attack_left;
    private Array<Boolean> Up_animaton_golem,Down_animaton_golem;
    private Array<Boolean> left_animaton_golem,Right_animaton_golem;
    private float Golem_Width;
    private float Golem_Height;
    private float Stair_up_x,Stair_Down_x,Stair_up_y,Stair_Down_y;
    private Array<Boolean> whileattacking;
    private float Golem_Height_Died,Golem_Width_died;
    private Array<Boolean> DeadGolem;
    private Texture Fireballattack_Left, Fireballattack_Right;
    private Array<Body> Fireball_left,Fireball_right;
    private Array<Float> timefireball;
    private Array<Boolean> Start_attackGhoul;
    private float Fireball_width, Fireball_Height;
    private Array<Boolean> rightattack;
    private Array<Boolean> leftattack;
    private Array<Float> timeloopA_Ghost_left;
    private Array<Boolean> Died_Ghost;
    private Array<Float> Health_Skeleton,Health_Ghost,Health_Golem;
    private float Time_Spent=0;
    private int level_Main;
    private float UP_control_x,UP_control_y,Down_control_y,Down_control_x,Right_control_x,Right_control_y,left_control_x,left_control_y,BAG_HEIGHT;
    private float BAG_WIDTH;
    private Body Right_control,left_control,up_control,down_control;
    private int getrat_items,getsheep_meat,getwood_items1,getstone_items1,getfish_items,getIron_items,getGold_items,Helemt_gold_item,chest_gold_item,leg_gold_item,foot_gold_item,Helemt_metal_item,chest_metal_item,leg_metal_item,foot_metal_item;
    private Array<Boolean> ontimerooten;
    private Texture Slot_Space;
    public static final float PIXEL_PER_METER = 32f;
    private static final float RatSize = 20;
    private static final float SheepSize = 25;
    private static final float GoblinSize = 20;
    public static final int PlayerSize=25;
    private static final float Rat_Height =PIXEL_PER_METER*2;
    private static final float Rat_Width= PIXEL_PER_METER*2;
    private static final float Rat_Speed = 30;
    private static final float Goblin_Speed = 35;
    private static final float Sheep_Speed = 35;
    private static final int Hunger_still = 1200;
    private static final float ArrowSize = 30;
    int dwidth=800;
    int dheight=450;
    int ascept_width,ascept_height;
    private  float oldmomevent;
    public FitViewport viewport;
    private Body FishPool;

    private static final float Goblin_Width_left =PIXEL_PER_METER;
    private static final float Goblin_Width_right = PIXEL_PER_METER ;
    private static final float Goblin_Height=PIXEL_PER_METER/2;
    private static final float Sheep_Height = PIXEL_PER_METER/4;
    private static final float Sheep_Width= PIXEL_PER_METER/2;
    public static final float PlayerSpace_Y=PIXEL_PER_METER;
    public static final float PlayerSpace_x=PIXEL_PER_METER;

    private static final float Rat_UP_X = PIXEL_PER_METER/5;
    private static final float Rat_DOWN_X= PIXEL_PER_METER/5;
    private static final float Rat_DOWN_Y= PIXEL_PER_METER/3;
    private static final float Rat_UP_Y= PIXEL_PER_METER/6;
    private static final float Sheep_Up_X =PIXEL_PER_METER;
    private static final float Sheep_Up_Y =PIXEL_PER_METER/5;
    private static final float Sheep_Down_X=PIXEL_PER_METER;
    private static final float Sheep_Down_Y=PIXEL_PER_METER/5;
    private static final float Goblin_Down_X = PIXEL_PER_METER;
    private static final float Goblin_Down_Y = PIXEL_PER_METER/4;
    private static final float Goblin_Up_X = PIXEL_PER_METER;
    private static final float Goblin_Up_Y = PIXEL_PER_METER/4;



    private Stage stage;
    private  Array<Float> array_xsheep_respawn,array_ysheep_respawn;

    public static final  float momvent=200;
    public static final float VELOCITY_X = 0f;
    public static final float VELOCITY_Y = -9.8f;
    private Body ratbody;
    private Body sheepBody;
    private Body goblinbody;
    private Body Stone_Brickbody1,Stone_Brickbody2,Stone_Brickbody3,Stone_Brickbody4;
    private Body Stone_Brickbody1_respawn,Stone_Brickbody2_respawn,Stone_Brickbody3_respawn,Stone_Brickbody4_respawn;
    private Body tree_brickbody,tree_brickbody2;
    private Body tree_brickbody_respawn,tree_brickbody2_respawn;
    private  Texture texturewood;
    int roll;

    private Tree_Brick tree_brick;
    private Stone_brick stone_brick;
    private static final float SCALE = 2.0f;
    public static final float TIME_STEP = 1 / 60f;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;
    private boolean moveleft=false,moveright=true;
    private float x,y;
    private boolean activefollowsystem=false;
    private boolean hitrat=false;
    int i2=0;
    private boolean hitforratenable=false;
    private boolean moverightgoblin =true,moverightsheep=true,moveleftsheep=false, moveleftgoblin =false;
    private float periodloopsheep=4f;
    private float periodloopreacon=3.5f;
    private float timeloop3=0;
    private float dx1,dy1,x1,y1;
    private float timelooprat,timeloopsheep,timeloopreacon;
    private boolean hitsheep;
    private double lengthsheep;
    private boolean activefollowsystem1=false;
    private boolean hitforsheepenable=false;
    private boolean hitreacon=false,hitforreaconenable=false;
    private float x2,y2;
    private double lengthreacon;
    private boolean activefollowsystem2=false;
    private float timehit;

    private double lengthBrick,lengthBrick2,lengthBrick3,lengthBrick4;
    private int timehit2=0,timehit3=0,timehit4=0;
    public int stone=0;
    private Body bodybeforestone;
    private float dx8,dy8;
    private double lengthTree2,lengthTree;
    private int timehit6,timehit5,i6;
    private int tree=0;
    private Body bodybeforetree;
    private float stateTime;
    private Texture textureStone;
    private TextureAtlas atlasright_rat,atlasleft_rat,atlasup_rat,atlasdown_rat,atlasright_sheep,atlasleft_sheep,atlasup_sheep,atlasdown_sheep,atlasright_goblin,atlasleft_goblin,atlasup_goblin,atlasdown_goblin;
    private Animation aniamtionup_rat,animationleft_rat,animationright_rat,animationdown_rat,animationright_sheep,animationleft_sheep,aniamtionup_sheep,animationdown_sheep,animationright_goblin,animationleft_goblin,aniamtionup_goblin,animationdown_goblin;
    private boolean enableanimatonrat =false,enableanimatonreacon=false,enableanimatonsheep=false;
    private boolean movesides=true, movesidesgoblin =true,movesidessheep=true;
    private int placetree, placestone;
    private Body[] blockstone;
    private Body[] blocktree;
    private boolean respawntime_rat=false;
    private float timerespawn_rat=0,timerespawn_sheep=0,timerespawn_goblin=0;
    private boolean respawntime_sheep,respawntime_goblin;
    private float timeloop2_sheep;
    private boolean moveleftsheep_respawn,moverightsheep_respawn,movesidessheep_respawn;
    private Body sheepBody_respawn;
    private float timehit_respawn,timeloopsheep_respawn;
    private boolean activefollowsystemsheep_respawn,hitforsheepenable_respawn;
    private float dx1_respawn,dy1_respawn,x1_respawn,y1_respawn;
    private boolean hitsheep_respawn;
    private double lengthsheep_respawn;
    private boolean enableanimatonsheep_respawn;
    private float timeloop_respawn;
    private boolean moveright_respawn=true,moveleft_respawn=false,movesides_respawn=true;
    private Body ratbody_respawn;
    private boolean activefollowsystem_respawn,enableanimatonrat_respawn,hitforratenable_respawn,hitrat_respawn;
    private float timelooprat_respawn;
    private float dx_respawn,dy_respawn,x_respawn,y_respawn;
    private double length_respawn;
    private float timeloop3_respawn;
    private Body goblinbody_respawn;
    private boolean moveleftgoblin_respawn,moverightgoblin_respawn,movesidesgoblin_respawn;
    private boolean hitreacon_respawn,hitforreaconenable_respawn, activefollowsystemgoblin_respawn, enableanimatongoblin_respawn;
    private float dx2_respawn,dy2_respawn,x2_respawn,y2_respawn,timeloopreacon_respawn;
    private double lengthreacon_respawn;

    private int whichone;
    private Throw_items throw_rat,throw_stone,throw_sheep,throw_goblin,throw_wood,throw_stone2,throw_stone3,throw_stone4,throw_wood2;
    private int[] whichstone,whichtree;
    private int whichone_respawn;
    private Throw_items throw_rat_respawn,throw_sheep_respawn,throw_goblin_respawn,throw_stone_respawn,throw_stone2_respawn,throw_stone3_respawn,throw_stone4_respawn,throw_wood_respawn,throw_wood2_respawn;
    private int[] whichstone_respawn,whichtree_respawn;
    private float dx8_respawn,dx7_respawn,dx6_respawn,dx3_respawn,dx4_respawn,dx5_respawn;
    private float dy8_respawn,dy7_respawn,dy6_respawn,dy3_respawn,dy4_respawn,dy5_respawn;
    private double lengthTree2_respawn;
    private int timehit6_respawn;
    private int i6_respawn,i5_respawn,i4_respawn,i3_respawn;
    private int i2_respawn,i_respawn;
    private double lengthTree_respawn;
    private double lengthBrick2_respawn,lengthBrick3_respawn,lengthBrick4_respawn,lengthBrick_respawn;
    private int timehit5_respawn;
    private int timehit1_respawn;
    private int timehit2_respawn;
    private int timehit3_respawn;
    private int timehit4_respawn;
    private float timerespawn_wood=5f,timerespawn_stone=5f;
    private boolean respawntime_wood,respawntime_wood2,respawntime_stone3,respawntime_stone4,respawntime_stone,respawntime_stone2;
    private Body rat_items,sheep_items,goblin_items,stone_items,wood_items;
    private Body wood_items2,stone_items2,stone_items3,stone_items4;
    private Array<Body> wood_items_respawn,wood_items2_respawn;
    private Texture texturewood_items,textureStone_items;
    private Animation animationleft_rat_respawn,animationright_rat_respawn;
    private Animation animationdown_rat_respawn;
    private Animation aniamtionup_rat_respawn;
    private boolean respawnreload=false;
    private Animation animationright_goblin_respawn,animationleft_goblin_respawn;
    private Animation animationdown_goblin_respawn,aniamtionup_goblin_respawn;
    private boolean respawnreload_goblin;
    private Animation animationright_sheep_respawn,animationleft_sheep_respawn;
    private Animation aniamtionup_sheep_respawn,animationdown_sheep_respawn;
    private boolean respawnreload_sheep;
    private boolean respawnreload_stone4,respawnreload_stone2,respawnreload_stone3,respawnreload_stone;
    private boolean respawnreload_wood,respawnreload_wood2;
    private Texture sheep_wall;
    private Array<Float> array_xrat_respawn;
    private Array<Float> array_yrat_respawn;
    private int x_i_respawn =0, y_i_respawn;
    private boolean dropitemsnonumber=true;

    private boolean onetime_rat =true;
    private boolean onetime_sheep;
    private int x_sheep_respawn,y_sheep_respawn;
    private double lengthsheepitems_respawn;
    private float ysheepitems_respawn,xsheepitems_respawn;
    private float dysheepitems_respawn,dxsheepitems_respawn;
    private double lengthsheepitems;
    private float ysheepitems,xsheepitems;
    private float dysheepitems,dxsheepitems;
    private double lengthratitems;
    private float dxratitems,dyratitems;
    private float xratitems,yratitems;
    private boolean onetime_stone,onetime_stone2,onetime_stone3,onetime_stone4;
    private Array<Float> array_ystone1_respawn,array_xstone1_respawn,array_xstone4_respawn,array_ystone4_respawn,array_xstone3_respawn,array_xstone2_respawn,array_ystone3_respawn,array_ystone2_respawn;
    private int x_stone1_respawn,x_stone2_respawn,x_stone3_respawn,x_stone4_respawn;
    private int y_stone2_respawn,y_stone1_respawn,y_stone3_respawn,y_stone4_respawn;
    private float dxStoneitems1_respawn,dyStoneitems1_respawn;
    private float xStoneitems1_respawn,yStoneitems1_respawn;
    private double lengthStoneitems1_respawn;
    private float dxStoneitems2_respawn,dyStoneitems2_respawn;
    private float xStoneitems2_respawn,yStoneitems2_respawn;
    private double lengthStoneitems2_respawn;
    private float dxStoneitems3_respawn,dyStoneitems3_respawn;
    private float xStoneitems3_respawn,yStoneitems3_respawn;
    private double lengthStoneitems3_respawn;
    private float dxStoneitems4_respawn,dyStoneitems4_respawn;
    private float xStoneitems4_respawn,yStoneitems4_respawn;
    private double lengthStoneitems4_respawn;
    private float dyStoneitems,dxStoneitems,xStoneitems,yStoneitems;
    private double lengthStoneitems;
    private float dyStoneitems2,dxStoneitems2,xStoneitems2,yStoneitems2;
    private double lengthStoneitems2;
    private float dyStoneitems3,dxStoneitems3,xStoneitems3,yStoneitems3;
    private double lengthStoneitems3;
    private float dyStoneitems4,dxStoneitems4,xStoneitems4,yStoneitems4;
    private double lengthStoneitems4;


    private Array<Texture> extraISlots;
    private int ISlotsN=-1;
    private int IBefore;
    private boolean IChange=true;
    private int ix=0;
    private boolean ICollect=false;
    private float dxwood2items,dywood2items,dywood1items,dxwood1items;
    private float xwood1items,ywood1items,xwood2items,ywood2items;
    private double lengthwood1items,lengthwood2items;
    private FreeTypeFontGenerator FontGenerator,FontGenerator1;
    private FreeTypeFontGenerator.FreeTypeFontParameter FontParameter,FontParameter1;
    private BitmapFont font1,font3;
    private Label label2;
    private static final Float Stone_X = PIXEL_PER_METER*2;
    private static final Float Stone_Y = PIXEL_PER_METER*3/2;
    private boolean moveup_goblin=true,movedown_goblin=true;
    private com.mygdx.game.openworld.Fish Fish;

    private Body DEnter;
    private float dx_d;
    private float dy_D;
    private double length_D;
    private double length_touch;
    private float dx_touch,dy_touch;
    private float timeloop_rooten_rat =0,timeloop_rooten_sheep=0,timeloop_rooten_fish=0;
    private float timeloop_hunger_rat =0;
    private int hunger=1200;
    private Texture HungerBar;
    private float timeloop_hunger_Sheep=0;
    private float timeloop_hunger_Fish=0;
    private boolean workhunger_rat=false,workhunger_sheep=false,workhunger_fish=false;
    private float hunger_reduce=1;
    private Texture RightArrow,leftArrow,UpArrow,DownArrow;

    private int MODE_RIGHTNOW;
    private Texture Background;
    private  int Main_reduce;
    private int howmanytimes_lefttoadd;
    int level;
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
    private int Main_hunger=0,Main_health=0,Main_attack=0,Main_Immunity=0;
    private int addHunger =Main_hunger;
    private int addHelath =Main_health;
    private int addattack=Main_attack;
    private int addImmunity=Main_Immunity;
    private int up_Stats=40;
    private int Width_Stats=-Gdx.graphics.getWidth()/2/10;
    private String which_writing="";
    private float time_Stats =0;
    private boolean onetime_Work=true;
    private float timeloop_recover;
    private boolean Start_Recov=false;
    private boolean recover_Health;
    private int hunger_check;
    private int hited_rat=0;
    private int hited_reacon=0;
    private int hited_sheep=0;
    private int hited_rat_respawn=0, hited_goblin_respawn =0,hited_sheep_respawn=0;
    private boolean control_left,control_Right,control_up,control_down;
    private  int[] Equip_Slot_X_Down,Equip_Slot_Y_Down;
    private  int[] Equip_Slot_X,Equip_Slot_Y;
    private  int[] SlotSpace_X,SlotSpace_Y;
    private  int w;
    private  int h;
    private  Texture Left_Inv;
    private  Texture Right_Inv;
    private Texture[] Move_Texture;
    private Array<Integer> Old_Extrainvertoy_X,Old_Extrainvertoy_Y;
    private int[] New_Extrainvertoy_X,New_Extrainvertoy_Y;
    private boolean Equip =false, UnEquip =false;
    private boolean[] changing_placeT;
    private boolean slected_Equip;
    private boolean[] slected_UnEquip_X,slected_UnEquip_Y;
    private int[] slected_X,slected_Y;
    private boolean Change_T;
    private boolean Helemt_Texture_gold =false;
    private boolean Chest_Texture_gold =false;
    private Texture BagPic;

    private  BitmapFont font4;
    private  Texture Build_info;
    private  int[] SlotBuildSpace_Y;
    private  int[] SlotBuildSpace_X;
    private int[] WhichInfo;
    private Texture Info_texture;
    private Array<Texture> BuildISlots;
    private Texture Iron_ingot,Gold_ingot;
    private Texture metal_armor_leg;
    private Texture metal_armor_chest,metal_armor_feet,metal_armor_helemt;
    private Texture golden_armor_foot,golden_armour,golden_armour_chest,golden_armour_leg;

    private boolean legs_Texture_gold=false,foot_Texture_gold=false,Helemt_Texture_metal=false,Chest_Texture_metal=false,legs_Texture_metal=false
            ,foot_Texture_metal=false;
    //metal
    private TextureAtlas atlasUp_allMetal,atlasLeft_allMetal,atlasRight_allMetal,atlasDown_allMetal;
    private TextureAtlas atlasUp_Chest_foot_metal,atlasLeft_Chest_foot_metal,atlasRight_Chest_foot_metal,atlasDown_Chest_foot_metal;
    private TextureAtlas atlasUp_Chest_legs_metal,atlasLeft_Chest_legs_metal,atlasDown_Chest_legs_metal,atlasRight_Chest_legs_metal;
    private TextureAtlas atlasUp_Chest_metal_down,atlasLeft_Chest_metal_down,atlasRight_Chest_metal_down,atlasDown_Chest_metal_down;
    private TextureAtlas atlasUp_Foot_metal,atlasLeft_Foot_metal,atlasRight_Foot_metal,atlasDown_Foot_metal;
    private TextureAtlas atlasUp_Helemt_chest_metal,atlasLeft_Helemt_chest_metal,atlasRight_Helemt_chest_metal,atlasDown_Helemt_chest_metal;
    private TextureAtlas atlasUp_Helemt_foot_metal,atlasLeft_Helemt_foot_metal,atlasRight_Helemt_foot_metal,atlasDown_Helemt_foot_metal;
    private TextureAtlas atlasUp_Helemt_Legs_metal,atlasLeft_Helemt_Legs_metal,atlasRight_Helemt_Legs_metal,atlasDown_Helemt_Legs_metal;
    private TextureAtlas atlasUp_Helemt_metal,atlasLeft_Helemt_metal,atlasRight_Helemt_metal,atlasDown_Helemt_metal;
    private TextureAtlas atlasUp_Legs_foot_metal,atlasLeft_Legs_foot_metal,atlasRight_Legs_foot_metal,atlasDown_Legs_foot_metal;
    private TextureAtlas atlasUp_Legs_metal,atlasLeft_Legs_metal,atlasRight_Legs_metal,atlasDown_Legs_metal;
    private Animation animationUp_allMetal, animationLeft_allMetal, animationRight_allMetal, animationDown_allMetal,animationUp_Chest_foot_metal,animationLeft_Chest_foot_metal,animationDown_Chest_foot_metal,animationRight_Chest_foot_metal;
    private Animation animationUp_Chest_legs_metal,animationLeft_Chest_legs_metal,animationRight_Chest_legs_metal,animationDown_Chest_legs_metal;
    private Animation animationUp_Chest_metal_down,animationLeft_Chest_metal_down,animationRight_Chest_metal_down,animationDown_Chest_metal_down;
    private Animation animationUp_Foot_metal,animationLeft_Foot_metal,animationRight_Foot_metal,animationDown_Foot_metal;
    private Animation animationUp_Helemt_chest_metal,animationLeft_Helemt_chest_metal,animationRight_Helemt_chest_metal,animationDown_Helemt_chest_metal;
    private Animation animationUp_Helemt_foot_metal,animationLeft_Helemt_foot_metal,animationRight_Helemt_foot_metal,animationDown_Helemt_foot_metal;
    private Animation animationUp_Helemt_Legs_metal,animationLeft_Helemt_Legs_metal,animationRight_Helemt_Legs_metal,animationDown_Helemt_Legs_metal;
    private Animation animationUp_Helemt_metal,animationLeft_Helemt_metal,animationRight_Helemt_metal,animationDown_Helemt_metal;
    private Animation animationUp_Legs_foot_metal,animationLeft_Legs_foot_metal,animationRight_Legs_foot_metal,animationDown_Legs_foot_metal;
    private Animation animationUp_Legs_metal,animationLeft_Legs_metal,animationRight_Legs_metal,animationDown_Legs_metal;
    //gold
    private TextureAtlas atlasUp_allgold,atlasLeft_allgold,atlasRight_allgold,atlasDown_allgold;
    private TextureAtlas atlasUp_Chest_foot_gold,atlasLeft_Chest_foot_gold,atlasRight_Chest_foot_gold,atlasDown_Chest_foot_gold;
    private TextureAtlas atlasUp_Chest_legs_gold,atlasLeft_Chest_legs_gold,atlasDown_Chest_legs_gold,atlasRight_Chest_legs_gold;
    private TextureAtlas atlasUp_Chest_gold_down,atlasLeft_Chest_gold_down,atlasRight_Chest_gold_down,atlasDown_Chest_gold_down;
    private TextureAtlas atlasUp_Foot_gold,atlasLeft_Foot_gold,atlasRight_Foot_gold,atlasDown_Foot_gold;
    private TextureAtlas atlasUp_Helemt_chest_gold,atlasLeft_Helemt_chest_gold,atlasRight_Helemt_chest_gold,atlasDown_Helemt_chest_gold;
    private TextureAtlas atlasUp_Helemt_foot_gold,atlasLeft_Helemt_foot_gold,atlasRight_Helemt_foot_gold,atlasDown_Helemt_foot_gold;
    private TextureAtlas atlasUp_Helemt_Legs_gold,atlasLeft_Helemt_Legs_gold,atlasRight_Helemt_Legs_gold,atlasDown_Helemt_Legs_gold;
    private TextureAtlas atlasUp_Helemt_gold,atlasLeft_Helemt_gold,atlasRight_Helemt_gold,atlasDown_Helemt_gold;
    private TextureAtlas atlasUp_Legs_foot_gold,atlasLeft_Legs_foot_gold,atlasRight_Legs_foot_gold,atlasDown_Legs_foot_gold;
    private TextureAtlas atlasUp_Legs_gold,atlasLeft_Legs_gold,atlasRight_Legs_gold,atlasDown_Legs_gold;
    private Animation animationUp_allgold, animationLeft_allgold, animationRight_allgold, animationDown_allgold,animationUp_Chest_foot_gold,animationLeft_Chest_foot_gold,animationDown_Chest_foot_gold,animationRight_Chest_foot_gold;
    private Animation animationUp_Chest_legs_gold,animationLeft_Chest_legs_gold,animationRight_Chest_legs_gold,animationDown_Chest_legs_gold;
    private Animation animationUp_Chest_gold_down,animationLeft_Chest_gold_down,animationRight_Chest_gold_down,animationDown_Chest_gold_down;
    private Animation animationUp_Foot_gold,animationLeft_Foot_gold,animationRight_Foot_gold,animationDown_Foot_gold;
    private Animation animationUp_Helemt_chest_gold,animationLeft_Helemt_chest_gold,animationRight_Helemt_chest_gold,animationDown_Helemt_chest_gold;
    private Animation animationUp_Helemt_foot_gold,animationLeft_Helemt_foot_gold,animationRight_Helemt_foot_gold,animationDown_Helemt_foot_gold;
    private Animation animationUp_Helemt_Legs_gold,animationLeft_Helemt_Legs_gold,animationRight_Helemt_Legs_gold,animationDown_Helemt_Legs_gold;
    private Animation animationUp_Helemt_gold,animationLeft_Helemt_gold,animationRight_Helemt_gold,animationDown_Helemt_gold;
    private Animation animationUp_Legs_foot_gold,animationLeft_Legs_foot_gold,animationRight_Legs_foot_gold,animationDown_Legs_foot_gold;
    private Animation animationUp_Legs_gold,animationLeft_Legs_gold,animationRight_Legs_gold,animationDown_Legs_gold;
    //lolll
    private TextureAtlas atlasUp_Chest_legs_foot_metal,atlasLeft_Chest_legs_foot_metal,atlasRight_Chest_legs_foot_metal,atlasDown_Chest_legs_foot_metal;
    private TextureAtlas atlasUp_Helemt_Chest_foot_metal,atlasLeft_Helemt_Chest_foot_metal,atlasRight_Helemt_Chest_foot_metal,atlasDown_Helemt_Chest_foot_metal;
    private  TextureAtlas atlasUp_Helemt_Chest_legs_metal,atlasLeft_Helemt_Chest_legs_metal,atlasRight_Helemt_Chest_legs_metal,atlasDown_Helemt_Chest_legs_metal;
    private  TextureAtlas atlasUp_Helemt_Legs_foot_metal,atlasLeft_Helemt_Legs_foot_metal,atlasRight_Helemt_Legs_foot_metal,atlasDown_Helemt_Legs_foot_metal;
    private Animation animationUp_Chest_legs_foot_metal,animationLeft_Chest_legs_foot_metal,animationRight_Chest_legs_foot_metal,animationDown_Chest_legs_foot_metal;
    private Animation animationUp_Helemt_Chest_foot_metal,animationLeft_Helemt_Chest_foot_metal,animationRight_Helemt_Chest_foot_metal,animationDown_Helemt_Chest_foot_metal;
    private Animation animationUp_Helemt_Chest_legs_metal,animationLeft_Helemt_Chest_legs_metal,animationRight_Helemt_Chest_legs_metal,animationDown_Helemt_Chest_legs_metal;
    private Animation animationUp_Helemt_Legs_foot_metal,animationLeft_Helemt_Legs_foot_metal,animationRight_Helemt_Legs_foot_metal,animationDown_Helemt_Legs_foot_metal;

    private TextureAtlas atlasUp_Chest_legs_foot_gold,atlasLeft_Chest_legs_foot_gold,atlasRight_Chest_legs_foot_gold,atlasDown_Chest_legs_foot_gold;
    private TextureAtlas atlasUp_Helemt_Chest_foot_gold,atlasLeft_Helemt_Chest_foot_gold,atlasRight_Helemt_Chest_foot_gold,atlasDown_Helemt_Chest_foot_gold;
    private  TextureAtlas atlasUp_Helemt_Chest_legs_gold,atlasLeft_Helemt_Chest_legs_gold,atlasRight_Helemt_Chest_legs_gold,atlasDown_Helemt_Chest_legs_gold;
    private  TextureAtlas atlasUp_Helemt_Legs_foot_gold,atlasLeft_Helemt_Legs_foot_gold,atlasRight_Helemt_Legs_foot_gold,atlasDown_Helemt_Legs_foot_gold;
    private Animation animationUp_Chest_legs_foot_gold,animationLeft_Chest_legs_foot_gold,animationRight_Chest_legs_foot_gold,animationDown_Chest_legs_foot_gold;
    private Animation animationUp_Helemt_Chest_foot_gold,animationLeft_Helemt_Chest_foot_gold,animationRight_Helemt_Chest_foot_gold,animationDown_Helemt_Chest_foot_gold;
    private Animation animationUp_Helemt_Chest_legs_gold,animationLeft_Helemt_Chest_legs_gold,animationRight_Helemt_Chest_legs_gold,animationDown_Helemt_Chest_legs_gold;
    private Animation animationUp_Helemt_Legs_foot_gold,animationLeft_Helemt_Legs_foot_gold,animationRight_Helemt_Legs_foot_gold,animationDown_Helemt_Legs_foot_gold;
    private int[] Stats;
    private float[] Hunger;
    private float k,m;

    public Dungeon_2(MyGdxGame game, Array<Texture> ISlots, int floor, ArrayList<Integer> Dungeon_list, float health, float level, int[] itemsCollect, boolean first1, float[] hungers, int[] stats){
        this.game=game;
        this.ISlots=ISlots;
        this.Health=health;
        this.Level=level;
        this.Dungeon_list=Dungeon_list;
        this.FloorNUM=floor;
        this.ItemsCollect=itemsCollect;
        this.first=first1;
        this.hunger_reduce=hungers[0];
        this.Main_hunger= (int) hungers[1];
        level_Main=stats[0];
        Main_hunger=stats[1];
        Main_Immunity=stats[2];
        Main_attack=stats[3];
        Main_health= stats[4];
        howmanytimes_lefttoadd=stats[5];
        Main_reduce=stats[6];
        Hunger=new float[4];
        Stats=new int[10];
        getrat_items=itemsCollect[0];
        getsheep_meat=itemsCollect[1];
        getwood_items1=itemsCollect[2]*4;
        getstone_items1= itemsCollect[3]*4;
        getfish_items=itemsCollect[4];
        getIron_items=itemsCollect[5];
        getGold_items=itemsCollect[6];
        Helemt_gold_item= itemsCollect[7];
        chest_gold_item= itemsCollect[8];
        leg_gold_item=itemsCollect[9];
        foot_gold_item=itemsCollect[10];
        Helemt_metal_item =itemsCollect[11];
        chest_metal_item=itemsCollect[12];
        leg_metal_item= itemsCollect[13];
        foot_metal_item= itemsCollect[14];
        this.ItemsCollect=itemsCollect;
        world = new World(new Vector2(Worldbegginerplace.VELOCITY_X, Worldbegginerplace.VELOCITY_Y), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, w/2, h/2);
        camera.update();
        font = new BitmapFont();
        batch = new SpriteBatch();
            worldcheck();
        animationsiter();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=15;
        FontParameter.characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font= FontGenerator.generateFont(FontParameter);
        font.setColor(Color.BLACK);
        FontGenerator.dispose();

        FontGenerator1 =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter1 =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter1.size=10;
        FontParameter1.characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font1= FontGenerator1.generateFont(FontParameter1);
        font1.setColor(Color.WHITE);
        FontGenerator1.dispose();

        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=23;
        FontParameter.characters="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font3= FontGenerator.generateFont(FontParameter);
        font3.setColor(Color.BLACK);
        font4 = FontGenerator.generateFont(FontParameter);
        font4.setColor(Color.BLACK);
        FontGenerator.dispose();

        System.out.println(w+"  "+h);
        oldmomevent=myinputproccer.momvent;

    }

    private  void animationsiter() {
        atlasright=new TextureAtlas("sprite_Sheets/right.atlas");
        animationright=new Animation(1/3f,atlasright.getRegions());

        atlasleft=new TextureAtlas("sprite_Sheets/left.atlas");
        animationleft=new Animation(1/3f,atlasleft.getRegions());

        atlasup=new TextureAtlas("sprite_Sheets/up.atlas");
        aniamtionup=new Animation(1/3f,atlasup.getRegions());

        atlasdown=new TextureAtlas("sprite_Sheets/down.atlas");
        animationdown=new Animation(1/3f,atlasdown.getRegions());

        texturewood=new Texture("sprite_Sheets/wood_block.jpg");
        textureStone=new Texture("sprite_Sheets/stone_block.jpg");
        texturewood_items=new Texture("items/wood_type.jpg");
        textureStone_items=new Texture("items/rock.png");

        //rat

        atlasright_rat=new TextureAtlas("sprite_Sheets/right-rat.atlas");
        animationright_rat=new Animation(1/3f,atlasright_rat.getRegions());

        atlasleft_rat=new TextureAtlas("sprite_Sheets/left-rat.atlas");
        animationleft_rat=new Animation(1/3f,atlasleft_rat.getRegions());

        atlasup_rat=new TextureAtlas("sprite_Sheets/up-rat.atlas");
        aniamtionup_rat=new Animation(1/3f,atlasup_rat.getRegions());

        atlasdown_rat=new TextureAtlas("sprite_Sheets/down-rat.atlas");
        animationdown_rat=new Animation(1/3f,atlasdown_rat.getRegions());
        rat_meat=new Texture("items/rat_meat.png");

        //sheep
        atlasright_sheep=new TextureAtlas("sprite_Sheets/right-sheep.atlas");
        animationright_sheep=new Animation(1/3f,atlasright_sheep.getRegions());

        atlasleft_sheep=new TextureAtlas("sprite_Sheets/left-sheep.atlas");
        animationleft_sheep=new Animation(1/3f,atlasleft_sheep.getRegions());

        atlasup_sheep=new TextureAtlas("sprite_Sheets/up-sheep.atlas");
        aniamtionup_sheep=new Animation(1/3f,atlasup_sheep.getRegions());

        atlasdown_sheep=new TextureAtlas("sprite_Sheets/down-sheep.atlas");
        animationdown_sheep=new Animation(1/3f,atlasdown_sheep.getRegions());
        sheep_meat=new Texture("items/sheep_drop.jpg");

        //goblin
        atlasright_goblin=new TextureAtlas("sprite_Sheets/right-goblin.atlas");
        animationright_goblin=new Animation(1/3f,atlasright_goblin.getRegions());

        atlasleft_goblin=new TextureAtlas("sprite_Sheets/left-goblin.atlas");
        animationleft_goblin=new Animation(1/3f,atlasleft_goblin.getRegions());

        atlasup_goblin=new TextureAtlas("sprite_Sheets/up-goblin.atlas");
        aniamtionup_goblin=new Animation(1/3f,atlasup_goblin.getRegions());

        atlasdown_goblin=new TextureAtlas("sprite_Sheets/down-goblin.atlas");
        animationdown_goblin=new Animation(1/3f,atlasdown_goblin.getRegions());

        //fish
        FishT=new Texture("items/fishfirst.png");

        //Player Metal&Gold
        PlayerMetalSet();
        PlayerGoldSet();
    }
    private void PlayerMetalSet() {
        //Player all metal
        atlasUp_allMetal=new TextureAtlas("sprite_Sheets/metal_armour_moving/All_metal_up.atlas");
        animationUp_allMetal=new Animation(1/3f,atlasUp_allMetal.getRegions());

        atlasLeft_allMetal=new TextureAtlas("sprite_Sheets/metal_armour_moving/All_metal_left.atlas");
        animationLeft_allMetal=new Animation(1/3f,atlasLeft_allMetal.getRegions());

        atlasRight_allMetal=new TextureAtlas("sprite_Sheets/metal_armour_moving/All_metal_right.atlas");
        animationRight_allMetal=new Animation(1/3f,atlasRight_allMetal.getRegions());

        atlasDown_allMetal=new TextureAtlas("sprite_Sheets/metal_armour_moving/All_metal_down.atlas");
        animationDown_allMetal=new Animation(1/3f,atlasDown_allMetal.getRegions());

        //Player Chest_foot_metal
        atlasUp_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+foot_metal_up.atlas");
        animationUp_Chest_foot_metal=new Animation(1/3f,atlasUp_Chest_foot_metal.getRegions());

        atlasLeft_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+foot_metal_left.atlas");
        animationLeft_Chest_foot_metal=new Animation(1/3f,atlasLeft_Chest_foot_metal.getRegions());

        atlasRight_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+foot_metal_right.atlas");
        animationRight_Chest_foot_metal=new Animation(1/3f,atlasRight_Chest_foot_metal.getRegions());

        atlasDown_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+foot_metal_down.atlas");
        animationDown_Chest_foot_metal=new Animation(1/3f,atlasDown_Chest_foot_metal.getRegions());

        //Player Chest_legs_metal
        atlasUp_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs_metal_up.atlas");
        animationUp_Chest_legs_metal=new Animation(1/3f,atlasUp_Chest_legs_metal.getRegions());

        atlasLeft_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs_metal_left.atlas");
        animationLeft_Chest_legs_metal=new Animation(1/3f,atlasLeft_Chest_legs_metal.getRegions());

        atlasRight_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs_metal_right.atlas");
        animationRight_Chest_legs_metal=new Animation(1/3f,atlasRight_Chest_legs_metal.getRegions());

        atlasDown_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs_metal_down.atlas");
        animationDown_Chest_legs_metal=new Animation(1/3f,atlasDown_Chest_legs_metal.getRegions());

        //Player Chest_metal_down
        atlasUp_Chest_metal_down=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest_metal_up.atlas");
        animationUp_Chest_metal_down=new Animation(1/3f,atlasUp_Chest_metal_down.getRegions());

        atlasLeft_Chest_metal_down=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest_metal_left.atlas");
        animationLeft_Chest_metal_down=new Animation(1/3f,atlasLeft_Chest_metal_down.getRegions());

        atlasRight_Chest_metal_down=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest_metal_right.atlas");
        animationRight_Chest_metal_down=new Animation(1/3f,atlasRight_Chest_metal_down.getRegions());

        atlasDown_Chest_metal_down=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest_metal_down.atlas");
        animationDown_Chest_metal_down=new Animation(1/3f,atlasDown_Chest_metal_down.getRegions());

        //Player Foot_metal
        atlasUp_Foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Foot_metal_up.atlas");
        animationUp_Foot_metal=new Animation(1/3f,atlasUp_Foot_metal.getRegions());

        atlasLeft_Foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Foot_metal_left.atlas");
        animationLeft_Foot_metal=new Animation(1/3f,atlasLeft_Foot_metal.getRegions());

        atlasRight_Foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Foot_metal_right.atlas");
        animationRight_Foot_metal=new Animation(1/3f,atlasRight_Foot_metal.getRegions());

        atlasDown_Foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Foot_metal_down.atlas");
        animationDown_Foot_metal=new Animation(1/3f,atlasDown_Foot_metal.getRegions());

        //Player Helemt_chest_metal
        atlasUp_Helemt_chest_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+chest_metal_up.atlas");
        animationUp_Helemt_chest_metal=new Animation(1/3f,atlasUp_Helemt_chest_metal.getRegions());

        atlasLeft_Helemt_chest_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+chest_metal_left.atlas");
        animationLeft_Helemt_chest_metal=new Animation(1/3f,atlasLeft_Helemt_chest_metal.getRegions());

        atlasRight_Helemt_chest_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+chest_metal_right.atlas");
        animationRight_Helemt_chest_metal=new Animation(1/3f,atlasRight_Helemt_chest_metal.getRegions());

        atlasDown_Helemt_chest_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+chest_metal_down.atlas");
        animationDown_Helemt_chest_metal=new Animation(1/3f,atlasDown_Helemt_chest_metal.getRegions());

        //Player Helemt_foot_metal
        atlasUp_Helemt_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+foot_metal_up.atlas");
        animationUp_Helemt_foot_metal=new Animation(1/3f,atlasUp_Helemt_foot_metal.getRegions());

        atlasLeft_Helemt_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+foot_metal_left.atlas");
        animationLeft_Helemt_foot_metal=new Animation(1/3f,atlasLeft_Helemt_foot_metal.getRegions());

        atlasRight_Helemt_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+foot_metal_right.atlas");
        animationRight_Helemt_foot_metal=new Animation(1/3f,atlasRight_Helemt_foot_metal.getRegions());

        atlasDown_Helemt_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+foot_metal_down.atlas");
        animationDown_Helemt_foot_metal=new Animation(1/3f,atlasDown_Helemt_foot_metal.getRegions());

        //Player Helemt_Legs_metal
        atlasUp_Helemt_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs_metal_up.atlas");
        animationUp_Helemt_Legs_metal=new Animation(1/3f,atlasUp_Helemt_Legs_metal.getRegions());

        atlasLeft_Helemt_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs_metal_left.atlas");
        animationLeft_Helemt_Legs_metal=new Animation(1/3f,atlasLeft_Helemt_Legs_metal.getRegions());

        atlasRight_Helemt_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs_metal_right.atlas");
        animationRight_Helemt_Legs_metal=new Animation(1/3f,atlasRight_Helemt_Legs_metal.getRegions());

        atlasDown_Helemt_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs_metal_down.atlas");
        animationDown_Helemt_Legs_metal=new Animation(1/3f,atlasDown_Helemt_Legs_metal.getRegions());

        //Player Helemt_metal
        atlasUp_Helemt_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt_metal_up.atlas");
        animationUp_Helemt_metal=new Animation(1/3f,atlasUp_Helemt_metal.getRegions());

        atlasLeft_Helemt_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt_metal_left.atlas");
        animationLeft_Helemt_metal=new Animation(1/3f,atlasLeft_Helemt_metal.getRegions());

        atlasRight_Helemt_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt_metal_right.atlas");
        animationRight_Helemt_metal=new Animation(1/3f,atlasRight_Helemt_metal.getRegions());

        atlasDown_Helemt_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt_metal_down.atlas");
        animationDown_Helemt_metal=new Animation(1/3f,atlasDown_Helemt_metal.getRegions());

        //Player Legs_foot_metal
        atlasUp_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs+foot_metal_up.atlas");
        animationUp_Legs_foot_metal=new Animation(1/3f,atlasUp_Legs_foot_metal.getRegions());

        atlasLeft_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs+foot_metal_left.atlas");
        animationLeft_Legs_foot_metal=new Animation(1/3f,atlasLeft_Legs_foot_metal.getRegions());

        atlasRight_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs+foot_metal_right.atlas");
        animationRight_Legs_foot_metal=new Animation(1/3f,atlasRight_Legs_foot_metal.getRegions());

        atlasDown_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs+foot_metal_down.atlas");
        animationDown_Legs_foot_metal=new Animation(1/3f,atlasDown_Legs_foot_metal.getRegions());

        //Player Legs_metal
        atlasUp_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs_metal_up.atlas");
        animationUp_Legs_metal=new Animation(1/3f,atlasUp_Legs_metal.getRegions());

        atlasLeft_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs_metal_left.atlas");
        animationLeft_Legs_metal=new Animation(1/3f,atlasLeft_Legs_metal.getRegions());

        atlasRight_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs_metal_right.atlas");
        animationRight_Legs_metal=new Animation(1/3f,atlasRight_Legs_metal.getRegions());

        atlasDown_Legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Legs_metal_down.atlas");
        animationDown_Legs_metal=new Animation(1/3f,atlasDown_Legs_metal.getRegions());

        //Player Chest_legs_foot_metal
        atlasUp_Chest_legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs+foot_metal_up.atlas");
        animationUp_Chest_legs_foot_metal=new Animation(1/3f,atlasUp_Chest_legs_foot_metal.getRegions());

        atlasLeft_Chest_legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs+foot_metal_left.atlas");
        animationLeft_Chest_legs_foot_metal=new Animation(1/3f,atlasLeft_Chest_legs_foot_metal.getRegions());

        atlasRight_Chest_legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs+foot_metal_right.atlas");
        animationRight_Chest_legs_foot_metal=new Animation(1/3f,atlasRight_Chest_legs_foot_metal.getRegions());

        atlasDown_Chest_legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Chest+legs+foot_metal_down.atlas");
        animationDown_Chest_legs_foot_metal=new Animation(1/3f,atlasDown_Chest_legs_foot_metal.getRegions());

        //Player Helemt_Chest_foot_metal
        atlasUp_Helemt_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+foot_metal_up.atlas");
        animationUp_Helemt_Chest_foot_metal=new Animation(1/3f,atlasUp_Helemt_Chest_foot_metal.getRegions());

        atlasLeft_Helemt_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+foot_metal_left.atlas");
        animationLeft_Helemt_Chest_foot_metal=new Animation(1/3f,atlasLeft_Helemt_Chest_foot_metal.getRegions());

        atlasRight_Helemt_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+foot_metal_right.atlas");
        animationRight_Helemt_Chest_foot_metal=new Animation(1/3f,atlasRight_Helemt_Chest_foot_metal.getRegions());

        atlasDown_Helemt_Chest_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+foot_metal_down.atlas");
        animationDown_Helemt_Chest_foot_metal=new Animation(1/3f,atlasDown_Helemt_Chest_foot_metal.getRegions());

        //Player Helemt_Chest_legs_metal
        atlasUp_Helemt_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+legs_metal_up.atlas");
        animationUp_Helemt_Chest_legs_metal=new Animation(1/3f,atlasUp_Helemt_Chest_legs_metal.getRegions());

        atlasLeft_Helemt_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+legs_metal_left.atlas");
        animationLeft_Helemt_Chest_legs_metal=new Animation(1/3f,atlasLeft_Helemt_Chest_legs_metal.getRegions());

        atlasRight_Helemt_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+legs_metal_right.atlas");
        animationRight_Helemt_Chest_legs_metal=new Animation(1/3f,atlasRight_Helemt_Chest_legs_metal.getRegions());

        atlasDown_Helemt_Chest_legs_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Chest+legs_metal_down.atlas");
        animationDown_Helemt_Chest_legs_metal=new Animation(1/3f,atlasDown_Helemt_Chest_legs_metal.getRegions());

        //Player Helemt_Legs_foot_metal
        atlasUp_Helemt_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs+foot_metal_up.atlas");
        animationUp_Helemt_Legs_foot_metal=new Animation(1/3f,atlasUp_Helemt_Legs_foot_metal.getRegions());

        atlasLeft_Helemt_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs+foot_metal_left.atlas");
        animationLeft_Helemt_Legs_foot_metal=new Animation(1/3f,atlasLeft_Helemt_Legs_foot_metal.getRegions());

        atlasRight_Helemt_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs+foot_metal_right.atlas");
        animationRight_Helemt_Legs_foot_metal=new Animation(1/3f,atlasRight_Helemt_Legs_foot_metal.getRegions());

        atlasDown_Helemt_Legs_foot_metal=new TextureAtlas("sprite_Sheets/metal_armour_moving/Helemt+Legs+foot_metal_down.atlas");
        animationDown_Helemt_Legs_foot_metal=new Animation(1/3f,atlasDown_Helemt_Legs_foot_metal.getRegions());
    }
    private void PlayerGoldSet() {
        //Player all gold
        atlasUp_allgold=new TextureAtlas("sprite_Sheets/gold_armour_moving/All_gold_up.atlas");
        animationUp_allgold=new Animation(1/3f,atlasUp_allgold.getRegions());

        atlasLeft_allgold=new TextureAtlas("sprite_Sheets/gold_armour_moving/All_gold_left.atlas");
        animationLeft_allgold=new Animation(1/3f,atlasLeft_allgold.getRegions());

        atlasRight_allgold=new TextureAtlas("sprite_Sheets/gold_armour_moving/All_gold_right.atlas");
        animationRight_allgold=new Animation(1/3f,atlasRight_allgold.getRegions());

        atlasDown_allgold=new TextureAtlas("sprite_Sheets/gold_armour_moving/All_gold_down.atlas");
        animationDown_allgold=new Animation(1/3f,atlasDown_allgold.getRegions());

        //Player Chest_foot_metal
        atlasUp_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+foot_gold_up.atlas");
        animationUp_Chest_foot_gold=new Animation(1/3f,atlasUp_Chest_foot_gold.getRegions());

        atlasLeft_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+foot_gold_left.atlas");
        animationLeft_Chest_foot_gold=new Animation(1/3f,atlasLeft_Chest_foot_gold.getRegions());

        atlasRight_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+foot_gold_right.atlas");
        animationRight_Chest_foot_gold=new Animation(1/3f,atlasRight_Chest_foot_gold.getRegions());

        atlasDown_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+foot_gold_down.atlas");
        animationDown_Chest_foot_gold=new Animation(1/3f,atlasDown_Chest_foot_gold.getRegions());

        //Player Chest_legs_gold
        atlasUp_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs_gold_up.atlas");
        animationUp_Chest_legs_gold=new Animation(1/3f,atlasUp_Chest_legs_gold.getRegions());

        atlasLeft_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs_gold_left.atlas");
        animationLeft_Chest_legs_gold=new Animation(1/3f,atlasLeft_Chest_legs_gold.getRegions());

        atlasRight_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs_gold_right.atlas");
        animationRight_Chest_legs_gold=new Animation(1/3f,atlasRight_Chest_legs_gold.getRegions());

        atlasDown_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs_gold_down.atlas");
        animationDown_Chest_legs_gold=new Animation(1/3f,atlasDown_Chest_legs_gold.getRegions());

        //Player Chest_metal_down
        atlasUp_Chest_gold_down=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest_gold_up.atlas");
        animationUp_Chest_gold_down=new Animation(1/3f,atlasUp_Chest_gold_down.getRegions());

        atlasLeft_Chest_gold_down=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest_gold_left.atlas");
        animationLeft_Chest_gold_down=new Animation(1/3f,atlasLeft_Chest_gold_down.getRegions());

        atlasRight_Chest_gold_down=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest_gold_right.atlas");
        animationRight_Chest_gold_down=new Animation(1/3f,atlasRight_Chest_gold_down.getRegions());

        atlasDown_Chest_gold_down=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest_gold_down.atlas");
        animationDown_Chest_gold_down=new Animation(1/3f,atlasDown_Chest_gold_down.getRegions());

        //Player Foot_metal
        atlasUp_Foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Foot_gold_up.atlas");
        animationUp_Foot_gold=new Animation(1/3f,atlasUp_Foot_gold.getRegions());

        atlasLeft_Foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Foot_gold_left.atlas");
        animationLeft_Foot_gold=new Animation(1/3f,atlasLeft_Foot_gold.getRegions());

        atlasRight_Foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Foot_gold_right.atlas");
        animationRight_Foot_gold=new Animation(1/3f,atlasRight_Foot_gold.getRegions());

        atlasDown_Foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Foot_gold_down.atlas");
        animationDown_Foot_gold=new Animation(1/3f,atlasDown_Foot_gold.getRegions());

        //Player Helemt_chest_metal
        atlasUp_Helemt_chest_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+chest_gold_up.atlas");
        animationUp_Helemt_chest_gold=new Animation(1/3f,atlasUp_Helemt_chest_gold.getRegions());

        atlasLeft_Helemt_chest_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+chest_gold_left.atlas");
        animationLeft_Helemt_chest_gold=new Animation(1/3f,atlasLeft_Helemt_chest_gold.getRegions());

        atlasRight_Helemt_chest_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+chest_gold_right.atlas");
        animationRight_Helemt_chest_gold=new Animation(1/3f,atlasRight_Helemt_chest_gold.getRegions());

        atlasDown_Helemt_chest_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+chest_gold_down.atlas");
        animationDown_Helemt_chest_gold=new Animation(1/3f,atlasDown_Helemt_chest_gold.getRegions());

        //Player Helemt_foot_metal
        atlasUp_Helemt_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+foot_gold_up.atlas");
        animationUp_Helemt_foot_gold=new Animation(1/3f,atlasUp_Helemt_foot_gold.getRegions());

        atlasLeft_Helemt_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+foot_gold_left.atlas");
        animationLeft_Helemt_foot_gold=new Animation(1/3f,atlasLeft_Helemt_foot_gold.getRegions());

        atlasRight_Helemt_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+foot_gold_right.atlas");
        animationRight_Helemt_foot_gold=new Animation(1/3f,atlasRight_Helemt_foot_gold.getRegions());

        atlasDown_Helemt_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+foot_gold_down.atlas");
        animationDown_Helemt_foot_gold=new Animation(1/3f,atlasDown_Helemt_foot_gold.getRegions());

        //Player Helemt_Legs_metal
        atlasUp_Helemt_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs_gold_up.atlas");
        animationUp_Helemt_Legs_gold=new Animation(1/3f,atlasUp_Helemt_Legs_gold.getRegions());

        atlasLeft_Helemt_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs_gold_left.atlas");
        animationLeft_Helemt_Legs_gold=new Animation(1/3f,atlasLeft_Helemt_Legs_gold.getRegions());

        atlasRight_Helemt_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs_gold_right.atlas");
        animationRight_Helemt_Legs_gold=new Animation(1/3f,atlasRight_Helemt_Legs_gold.getRegions());

        atlasDown_Helemt_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs_gold_down.atlas");
        animationDown_Helemt_Legs_gold=new Animation(1/3f,atlasDown_Helemt_Legs_gold.getRegions());

        //Player Helemt_metal
        atlasUp_Helemt_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt_gold_up.atlas");
        animationUp_Helemt_gold=new Animation(1/3f,atlasUp_Helemt_gold.getRegions());

        atlasLeft_Helemt_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt_gold_left.atlas");
        animationLeft_Helemt_gold=new Animation(1/3f,atlasLeft_Helemt_gold.getRegions());

        atlasRight_Helemt_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt_gold_right.atlas");
        animationRight_Helemt_gold=new Animation(1/3f,atlasRight_Helemt_gold.getRegions());

        atlasDown_Helemt_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt_gold_down.atlas");
        animationDown_Helemt_gold=new Animation(1/3f,atlasDown_Helemt_gold.getRegions());

        //Player Legs_foot_metal
        atlasUp_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs+foot_gold_up.atlas");
        animationUp_Legs_foot_gold=new Animation(1/3f,atlasUp_Legs_foot_gold.getRegions());

        atlasLeft_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs+foot_gold_left.atlas");
        animationLeft_Legs_foot_gold=new Animation(1/3f,atlasLeft_Legs_foot_gold.getRegions());

        atlasRight_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs+foot_gold_right.atlas");
        animationRight_Legs_foot_gold=new Animation(1/3f,atlasRight_Legs_foot_gold.getRegions());

        atlasDown_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs+foot_gold_down.atlas");
        animationDown_Legs_foot_gold=new Animation(1/3f,atlasDown_Legs_foot_gold.getRegions());

        //Player Legs_metal
        atlasUp_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs_gold_up.atlas");
        animationUp_Legs_gold=new Animation(1/3f,atlasUp_Legs_gold.getRegions());

        atlasLeft_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs_gold_left.atlas");
        animationLeft_Legs_gold=new Animation(1/3f,atlasLeft_Legs_gold.getRegions());

        atlasRight_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs_gold_right.atlas");
        animationRight_Legs_gold=new Animation(1/3f,atlasRight_Legs_gold.getRegions());

        atlasDown_Legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Legs_gold_down.atlas");
        animationDown_Legs_gold=new Animation(1/3f,atlasDown_Legs_gold.getRegions());

        //Player Chest_legs_foot_gold
        atlasUp_Chest_legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs+foot_gold_up.atlas");
        animationUp_Chest_legs_foot_gold=new Animation(1/3f,atlasUp_Chest_legs_foot_gold.getRegions());

        atlasLeft_Chest_legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs+foot_gold_left.atlas");
        animationLeft_Chest_legs_foot_gold=new Animation(1/3f,atlasLeft_Chest_legs_foot_gold.getRegions());

        atlasRight_Chest_legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs+foot_gold_right.atlas");
        animationRight_Chest_legs_foot_gold=new Animation(1/3f,atlasRight_Chest_legs_foot_gold.getRegions());

        atlasDown_Chest_legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Chest+legs+foot_gold_down.atlas");
        animationDown_Chest_legs_foot_gold=new Animation(1/3f,atlasDown_Chest_legs_foot_gold.getRegions());

        //Player Helemt_Chest_foot_metal
        atlasUp_Helemt_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+foot_gold_up.atlas");
        animationUp_Helemt_Chest_foot_gold=new Animation(1/3f,atlasUp_Helemt_Chest_foot_gold.getRegions());

        atlasLeft_Helemt_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+foot_gold_left.atlas");
        animationLeft_Helemt_Chest_foot_gold=new Animation(1/3f,atlasLeft_Helemt_Chest_foot_gold.getRegions());

        atlasRight_Helemt_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+foot_gold_right.atlas");
        animationRight_Helemt_Chest_foot_gold=new Animation(1/3f,atlasRight_Helemt_Chest_foot_gold.getRegions());

        atlasDown_Helemt_Chest_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+foot_gold_down.atlas");
        animationDown_Helemt_Chest_foot_gold=new Animation(1/3f,atlasDown_Helemt_Chest_foot_gold.getRegions());

        //Player Helemt_Chest_legs_metal
        atlasUp_Helemt_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+legs_gold_up.atlas");
        animationUp_Helemt_Chest_legs_gold=new Animation(1/3f,atlasUp_Helemt_Chest_legs_gold.getRegions());

        atlasLeft_Helemt_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+legs_gold_left.atlas");
        animationLeft_Helemt_Chest_legs_gold=new Animation(1/3f,atlasLeft_Helemt_Chest_legs_gold.getRegions());

        atlasRight_Helemt_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+legs_gold_right.atlas");
        animationRight_Helemt_Chest_legs_gold=new Animation(1/3f,atlasRight_Helemt_Chest_legs_gold.getRegions());

        atlasDown_Helemt_Chest_legs_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Chest+legs_gold_down.atlas");
        animationDown_Helemt_Chest_legs_gold=new Animation(1/3f,atlasDown_Helemt_Chest_legs_gold.getRegions());

        //Player Helemt_Legs_foot_metal
        atlasUp_Helemt_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs+foot_gold_up.atlas");
        animationUp_Helemt_Legs_foot_gold=new Animation(1/3f,atlasUp_Helemt_Legs_foot_gold.getRegions());

        atlasLeft_Helemt_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs+foot_gold_left.atlas");
        animationLeft_Helemt_Legs_foot_gold=new Animation(1/3f,atlasLeft_Helemt_Legs_foot_gold.getRegions());

        atlasRight_Helemt_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs+foot_gold_right.atlas");
        animationRight_Helemt_Legs_foot_gold=new Animation(1/3f,atlasRight_Helemt_Legs_foot_gold.getRegions());

        atlasDown_Helemt_Legs_foot_gold=new TextureAtlas("sprite_Sheets/gold_armour_moving/Helemt+Legs+foot_gold_down.atlas");
        animationDown_Helemt_Legs_foot_gold=new Animation(1/3f,atlasDown_Helemt_Legs_foot_gold.getRegions());
    }

    private void worldcheck() {
        Dungeon_list.add(2);
        map1 = new TmxMapLoader( ).load("dungeons/dungeon_2.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map1, 2);
        mapLayer = (TiledMapTileLayer) map1.getLayers( ).get(1);
        TiledObjectlayer.parseTiledObjectLayer1(world, map1.getLayers( ).get(0).getObjects( ));
        TiledObjectlayer.parseTiledObjectLayer1(world, map1.getLayers( ).get(2).getObjects( ));
        TiledObjectlayer.parseTiledObjectLayer1(world, map1.getLayers( ).get(3).getObjects( ));
        cell = new Cell( );
        x_list = new ArrayList<Integer>( );
        y_list = new ArrayList<Integer>( );
        player = new Player(world, 89, 1048);
        player1 = player.getBody( );
        player1.setGravityScale(0);
        myinputproccer = new Myinputproccer(player1, map1, Worldbegginerplace.PIXEL_PER_METER, Worldbegginerplace.momvent);
        Gdx.input.setInputProcessor(myinputproccer);
        atlasright=new TextureAtlas("sprite_Sheets/right.atlas");
        animationright=new Animation(1/3f,atlasright.getRegions());

        atlasleft=new TextureAtlas("sprite_Sheets/left.atlas");
        animationleft=new Animation(1/3f,atlasleft.getRegions());

        atlasup=new TextureAtlas("sprite_Sheets/up.atlas");
        aniamtionup=new Animation(1/3f,atlasup.getRegions());

        atlasdown=new TextureAtlas("sprite_Sheets/down.atlas");
        animationdown=new Animation(1/3f,atlasdown.getRegions());

        Healthbar=new Texture("HealthBar.png");
        Emptybar=new Texture("EmptyBar.png");
        Levelbar=new Texture("LevelBar.png");
        holeT=new Texture("Spawn/hole.png");
        StairU=new Texture("Spawn/stairs_up.png");
        StairD=new Texture("Spawn/stairs_down.png");
        rat_meat=new Texture("items/rat_meat.png");
        sheep_meat=new Texture("items/sheep_drop.jpg");
        FishT=new Texture("items/fishfirst.png");
        rockT=new Texture("items/rock.png");
        woodT=new Texture("items/wood_type.jpg");
        //ghost
        atlasghost_attack=new TextureAtlas("sprite_Sheets/ghost-attack.atlas");
        ghostA_attack_Right =new Animation(0.2f,atlasghost_attack.getRegions());
        atlasghost_died=new TextureAtlas("sprite_Sheets/ghost-died.atlas");
        ghostA_died=new Animation(0.15f,atlasghost_died.getRegions());
        Ghost_Standing=new Texture("sprite_Sheets/ghost-standing.jpg");
        Ghost_attack_left=new TextureAtlas("sprite_Sheets/ghost-left-attack.atlas");
        ghost_attack_left =new Animation(0.15f,Ghost_attack_left.getRegions());
        Fireballattack_Left =new Texture("sprite_Sheets/Fireball_left.png");
        Fireballattack_Right =new Texture("sprite_Sheets/Fireball_right.png");
        //golem
        atlasgolem_attack_up=new TextureAtlas("sprite_Sheets/golem-attack.atlas");
        atlasgolem_attack_down=new TextureAtlas("sprite_Sheets/golem-attack-down.atlas");
        atlasgolem_attack_right=new TextureAtlas("sprite_Sheets/golem-attack-right.atlas");
        atlasgolem_attack_left=new TextureAtlas("sprite_Sheets/golem-attack-left.atlas");
        atlasgolem_died=new TextureAtlas("sprite_Sheets/golem-died.atlas");
        atlasgolemMove_up=new TextureAtlas("sprite_Sheets/golem-walk-up.atlas");
        atlasgolemMove_down=new TextureAtlas("sprite_Sheets/golem-walk-down.atlas");
        atlasgolemMove_right=new TextureAtlas("sprite_Sheets/golem-walk-right.atlas");
        atlasgolemMove_left=new TextureAtlas("sprite_Sheets/golem_left.atlas");
        Golem_attack_down=new Animation(0.15f,atlasgolem_attack_down.getRegions());
        Golem_attack_up=new Animation(0.15f,atlasgolem_attack_up.getRegions());
        Golem_attack_Right=new Animation(0.15f,atlasgolem_attack_right.getRegions());
        Golem_attack_left=new Animation(0.15f,atlasgolem_attack_left.getRegions());
        Golem_walk_down=new Animation(1/3f,atlasgolemMove_down.getRegions());
        Golem_walk_up=new Animation(1/3f,atlasgolemMove_up.getRegions());
        Golem_walk_Right=new Animation(1/3f,atlasgolemMove_right.getRegions());
        Golem_walk_left=new Animation(1/3f,atlasgolemMove_left.getRegions());
        Golem_died=new Animation(1/3f,atlasgolem_died.getRegions());
        //skeleton
        atlasskeleton_up=new TextureAtlas("sprite_Sheets/skelton-up.atlas");
        atlasskeleton_down=new TextureAtlas("sprite_Sheets/skeleton-down.atlas");
        atlasskeleton_right=new TextureAtlas("sprite_Sheets/skeleton-walk-right.atlas");
        atlasskeleton_left=new TextureAtlas("sprite_Sheets/skeleton-walk-left.atlas");
        skeleton_walk_down=new Animation(1/3f,atlasskeleton_down.getRegions());
        skeleton_walk_up=new Animation(1/3f,atlasskeleton_up.getRegions());
        skeleton_walk_Right=new Animation(1/3f,atlasskeleton_right.getRegions());
        skeleton_walk_left=new Animation(1/3f,atlasskeleton_left.getRegions());

        Invertoy invertoy=new Invertoy(world,player1.getPosition().x-50,player1.getPosition().y-Gdx.graphics.getHeight()/6);
        invertoybuild = invertoy.getBody();
        Invertoyparts=new Body[9];
        Invertoyparts[0]=invertoy.getPart1();
        Invertoyparts[1]=invertoy.getPart2();
        Invertoyparts[2]=invertoy.getPart3();
        Invertoyparts[3]=invertoy.getPart4();
        Invertoyparts[4]=invertoy.getPart5();
        Invertoyparts[5]=invertoy.getPart6();
        Invertoyparts[6]=invertoy.getPart7();
        Invertoyparts[7]=invertoy.getPart8();
        Invertoyparts[8]=invertoy.getBag();
        invertoy_backgroundT=new Texture("background_invertoy.jpg");
        check();
        int m=0;
        random_mobs=new Random_mobs(x_list,y_list,world,dungeon,player1);
        random_mobs.Random_enemys(dungeon,x_list,y_list,FloorNUM);
        Hole hole=new Hole(world,random_mobs.holes_x[m],random_mobs.holes_y[m]);
        hole1=hole.getBody();
        m++;
        hole=new Hole(world,random_mobs.holes_x[m],random_mobs.holes_y[m]);
        hole2=hole.getBody();
        m++;
        hole=new Hole(world,random_mobs.holes_x[m],random_mobs.holes_y[m]);
        hole3=hole.getBody();
        m++;
        hole=new Hole(world,random_mobs.holes_x[m],random_mobs.holes_y[m]);
        hole4=hole.getBody();
        m++;
        hole=new Hole(world,random_mobs.holes_x[m],random_mobs.holes_y[m]);
        hole5=hole.getBody();
        m++;
        Stair stair=new Stair(world,random_mobs.stair_down_x,random_mobs.stair_down_y);
        Stair_Down =stair.getBody();
        stair=new Stair(world,random_mobs.stair_up_x,random_mobs.stair_up_y);
        GhostBody=new Array<Body>();
        GolemBody=new Array<Body>();
        SkeletonBody=new Array<Body>();
        Stair_up=stair.getBody();

        for(int i2=0;i2<random_mobs.MOBS.size();i2++){
            if(random_mobs.MOBS.get(i2)==0){
                Ghost ghost=new Ghost(world,random_mobs.random_x_1.get(i2),random_mobs.random_y_1.get(i2));
                GhostBody.add(ghost.getBody());
            }
            if(random_mobs.MOBS.get(i2)==1){
                ///Skeleton
                Skeleton skeleton=new Skeleton(world,random_mobs.random_x_1.get(i2),random_mobs.random_y_1.get(i2));

                SkeletonBody.add(skeleton.getBody());
            }
            if(random_mobs.MOBS.get(i2)==2) {
                ///Golem
                Golem golem=new Golem(world,random_mobs.random_x_1.get(i2),random_mobs.random_y_1.get(i2));
                GolemBody.add(golem.getBody());
            }
        }
        moveright_skeleton= new Array<Boolean>();
        moveleft_skeleton=new Array<Boolean>();
        movesides_skeleton=new Array<Boolean>();
        enableanimatonSkeleton=new Array<Boolean>();
        timeloop=new Array<Float>();
        timeloop_S=new Array<Float>();
        dx_S= new Array<Float>();
        dy_S= new Array<Float>();
        length_S=new Array<Double>();
        hitforSkeletonEnable=new Array<Boolean>();
        activefollowsystem_S =new Array<Boolean>();
        timehit_S=new Array<Float>();
        hit_S=new Array<Boolean>();
        Health_Skeleton=new Array<Float>();
        for(i3=0;i3<SkeletonBody.size;i3++){
            moveright_skeleton.add(true);
            Health_Skeleton.add(1f);
            moveleft_skeleton.add(false);
            movesides_skeleton.add(true);
            enableanimatonSkeleton.add(false);
            timeloop.add(0f);
            timehit_S.add(0f);
            hitforSkeletonEnable.add(false);
            timeloop_S.add(0f);
            dx_S.add(0f);
            dy_S.add(0f);
            length_S.add(0.0);
            hit_S.add(false);
            activefollowsystem_S.add(false);

        }
        i3=0;
        moveright_Golem=new Array<Boolean>();
        moveleft_Golem=new Array<Boolean>();
        movesides_Golem=new Array<Boolean>();
        timeloop2=new Array<Float>();
        enableanimatonGolem=new Array<Boolean>();
        timeloop_Golem=new Array<Float>();
        dx_Golem= new Array<Float>();
        dy_Golem= new Array<Float>();
        length_Golem=new Array<Double>();
        hitforGolemEnable=new Array<Boolean>();
        activefollowsystem_Golem =new Array<Boolean>();
        timehit_Golem=new Array<Float>();
        hit_Golem=new Array<Boolean>();
        timeloopA_Golem=new Array<Float>();
        Up_animaton_golem=new Array<Boolean>();
        Down_animaton_golem=new Array<Boolean>();
        left_animaton_golem=new Array<Boolean>();
        Right_animaton_golem=new Array<Boolean>();
        whileattacking =new Array<Boolean>();
        DeadGolem =new Array<Boolean>();
        Health_Golem=new Array<Float>();
        for(i4=0;i4<GolemBody.size;i4++){
            moveright_Golem.add(true);
            DeadGolem.add(false);
            Health_Golem.add(1f);
            moveleft_Golem.add(false);
            movesides_Golem.add(true);
            Up_animaton_golem.add(true);
            left_animaton_golem.add(true);
            Right_animaton_golem.add(true);
            Down_animaton_golem.add(true);
            whileattacking.add(false);
            enableanimatonGolem.add(false);
            timeloop2.add(0f);
            timeloop_Golem.add(0f);
            timehit_Golem.add(0f);
            dx_Golem.add(0f);
            dy_Golem.add(0f);
            length_Golem.add(0.0);
            hit_Golem.add(false);
            timeloopA_Golem.add(0f);
            activefollowsystem_Golem.add(false);
            hitforGolemEnable.add(false);
        }
        i4=0;
        timeloop_Ghost=new Array<Float>();
        dx_Ghost= new Array<Float>();
        dy_Ghost= new Array<Float>();
        length_Ghost=new Array<Double>();
        hitforGhostEnable=new Array<Boolean>();
        activefollowsystem_Ghost =new Array<Boolean>();
        timehit_Ghost=new Array<Float>();
        hit_Ghost=new Array<Boolean>();
        timeloopA_Ghost_Right =new Array<Float>();
        Fireball_left=new Array<Body>();
        Fireball_right=new Array<Body>();
        timefireball=new Array<Float>();
        Start_attackGhoul=new Array<Boolean>();
        rightattack=new Array<Boolean>();
        leftattack=new Array<Boolean>();
        timeloopA_Ghost_left=new Array<Float>();
        Died_Ghost=new Array<Boolean>();
        Health_Ghost=new Array<Float>();
        for(i5=0;i5<GhostBody.size;i5++){
            timeloop_Ghost.add(0f);
            timehit_Ghost.add(0f);
            Died_Ghost.add(false);
            Health_Ghost.add(1f);
            timeloopA_Ghost_left.add(0f);
            leftattack.add(true);
            Start_attackGhoul.add(true);
            dx_Ghost.add(0f);
            dy_Ghost.add(0f);
            length_Ghost.add(0.0);
            hit_Ghost.add(false);
            rightattack.add(true);
            activefollowsystem_Ghost.add(false);
            hitforGhostEnable.add(false);
            timeloopA_Ghost_Right.add(0f);
            timefireball.add(0f);
            AttackGhost attackGhost=new AttackGhost(world,-255,-255);
            Fireball_left.add(attackGhost.getBody());
            AttackGhost attackGhost1=new AttackGhost(world,-255,-255);
            Fireball_right.add(attackGhost1.getBody());
        }
        i5=0;
        //new stuff
        ascept_width=w/dwidth;
        ascept_height=h/dheight;
        SlotBuildSpace_X =new int[6];
        SlotBuildSpace_Y =new int[6];
        Build_info=new Texture("for_item_build.jpg");
        WhichInfo=new int[20];
        BuildISlots =new Array<Texture>();
        //**which item to add BuildISlots.add(rat_meat);
        BagPic=new Texture("Backpack.png");
        extraISlots=new Array<Texture>();
        Move_Texture=new Texture[10];
        changing_placeT=new boolean[10];
        Old_Extrainvertoy_X=new Array<Integer>();
        Old_Extrainvertoy_Y=new Array<Integer>();
        New_Extrainvertoy_X=new int[10];
        New_Extrainvertoy_Y=new int[10];
        slected_X=new int[10];
        slected_Y=new int[10];
        slected_UnEquip_X=new boolean[10];
        slected_UnEquip_Y=new boolean[10];
        for(int mmm=0;mmm<New_Extrainvertoy_Y.length;mmm++){
            New_Extrainvertoy_Y[mmm]=-1;
            New_Extrainvertoy_X[mmm]=-1;
        }
        for(int mmm=0;mmm<changing_placeT.length;mmm++){
            changing_placeT[mmm]=false;
        }
        for(int mmm=0;mmm<slected_X.length;mmm++){
            slected_X[mmm]=-1;
            slected_Y[mmm]=-1;
        }
        for (int mmm=0;mmm<slected_UnEquip_Y.length;mmm++){
            slected_UnEquip_X[mmm]=false;
            slected_UnEquip_Y[mmm]=false;
        }
        w=Gdx.graphics.getWidth();
        h=Gdx.graphics.getHeight();
        MODE_RIGHTNOW=0;
        ontimerooten=new Array<Boolean>();
        invertoy_backgroundT=new Texture("background_invertoy.jpg");
        rockT=new Texture("items/rock.png");
        woodT=new Texture("items/wood_type.jpg");
        HungerBar=new Texture("ManaBar.png");
        whichone=-1;
        whichstone=new int[5];
        whichtree=new int[5];
        Bodysforcontrollers bodysforcontrollers=new Bodysforcontrollers(world,player1.getPosition().x-Gdx.graphics.getWidth()/6,player1.getPosition().y-Gdx.graphics.getHeight()/(10/2));
        Right_control=bodysforcontrollers.getRight();
        left_control=bodysforcontrollers.getLeft();
        up_control=bodysforcontrollers.getUp();
        down_control=bodysforcontrollers.getDown();
        UpArrow=new Texture("flatDark25.png");
        leftArrow=new Texture("flatDark23.png");
        RightArrow=new Texture("flatDark24.png");
        DownArrow=new Texture("flatDark26.png");
        check();
        System.out.println(x_list.get(0)+"   "+y_list.get(0));
        Dungeonenter D=new Dungeonenter(world,735,25);
        for(int i19=0;i19<3;i19++){
            ontimerooten.add(false);
        }
        howmanytimes_lefttoadd =level- level_Main;
        Main_reduce=level- level_Main;
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
        SlotSpace_X=new int[6];
        SlotSpace_Y=new int[6];
        Equip_Slot_X=new int[2];
        Equip_Slot_Y=new int[5];
        Equip_Slot_X_Down=new int[4];
        Equip_Slot_Y_Down=new int[1];
        Equip_Slot_X[0]= (int) (PIXEL_PER_METER*1.8f);
        Equip_Slot_X[1]= (int) (w/2-PIXEL_PER_METER*3);
        Equip_Slot_X_Down[0]= (int) (PIXEL_PER_METER*2);
        Equip_Slot_X_Down[1]= (int) (PIXEL_PER_METER*2+45);
        Equip_Slot_X_Down[2]= (int) (w/2-PIXEL_PER_METER*4);
        Equip_Slot_X_Down[3]= (int) (w/2-PIXEL_PER_METER*4+45);
        Equip_Slot_Y_Down[0]=h-460;
        ascept_height=h/dheight;
        ascept_width=w/dwidth;
        for(int j=0;j<Equip_Slot_Y.length;j++){
            Equip_Slot_Y[j]=((h-200)-52*j)*ascept_height;
        }
        Left_Inv=new Texture("Left_INv.jpg");
        Slot_Space=new Texture("Slot_PIc.png");
        Right_Inv=new Texture("Right_INv.jpg");
        Iron_ingot=new Texture("items/Iron_Item.png");
        Gold_ingot=new Texture("items/Gold_Item.png");
        metal_armor_leg=new Texture("items/metal_armor_leg.jpg");
        metal_armor_chest=new Texture("items/metal_armor_chest.png");
        metal_armor_feet=new Texture("items/metal_armor_feet.png");
        metal_armor_helemt=new Texture("items/metal_armor_helemt.jpg");
        golden_armor_foot=new Texture("items/golden_armor_foot.jpg");
        golden_armour=new Texture("items/golden_armour.jpg");
        golden_armour_chest=new Texture("items/golden_armour_chest.jpg");
        golden_armour_leg=new Texture("items/golden_armour_leg.png");

        BuildISlots.add(Iron_ingot);
        BuildISlots.add(Gold_ingot);
        BuildISlots.add(metal_armor_chest);
        BuildISlots.add(metal_armor_helemt);
        BuildISlots.add(metal_armor_leg);
        BuildISlots.add(metal_armor_feet);
        BuildISlots.add(golden_armor_foot);
        BuildISlots.add(golden_armour);
        BuildISlots.add(golden_armour_chest);
        BuildISlots.add(golden_armour_leg);
        for(int iw=0;iw<6;iw++) {
            SlotBuildSpace_X[iw] = ((w / 2) + 72 + (45 * iw)) * ascept_width;
        }
        for(int j=0;j<5;j++){
            SlotBuildSpace_Y[j]=((h-170)-53*j)*ascept_height;
        }
        for(int i=0;i<6;i++) {
            SlotSpace_X[i] = (w/2+72+45*i)*ascept_width;
        }
        for(int j=0;j<5;j++){
            SlotSpace_Y[j]=((h-170)-53*j)*ascept_height;
        }
        ISlots.add(golden_armour);
        ISlots.add(golden_armour_chest);
        ISlots.add(golden_armor_foot);
        ISlots.add(golden_armour_leg);
        ISlots.add(metal_armor_helemt);
        ISlots.add(metal_armor_chest);
        ISlots.add(metal_armor_leg);
        ISlots.add(metal_armor_feet);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if(MODE_RIGHTNOW==0) {
            Gdx.gl.glClearColor(0, 0, 0, 0);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            camera.position.set(player1.getPosition( ).x, player1.getPosition( ).y, 0);
            camera.update( );
            tiledMapRenderer.setView(camera);
            upadte( );
            tiledMapRenderer.render( );
            box2DDebugRenderer.SHAPE_STATIC.set(1, 0, 0, 0);
            box2DDebugRenderer.render(world, camera.combined);
            timeloop4 += delta;
            k = player1.getPosition( ).y;
            m = player1.getPosition( ).x;
            allChanged( );
            upadte( );
            moveinvertoy( );
            ChangeStats();
            if (ontimerooten.get(0)) timerooten_RAT( );
            if (ontimerooten.get(1)) timerooten_sheep( );
            if (ontimerooten.get(2)) timerooten_fish( );
            if (ontimerooten.get(0) || workhunger_rat) reduce_hunger_rat( );
            if (ontimerooten.get(1) || workhunger_sheep) reduce_hunger_Sheep( );
            if (ontimerooten.get(2) || workhunger_fish) reduce_hunger_Fish( );
            Checkholes( );
            checkstairs( );
            ChangeScreenHoles( );
            batch.begin( );
            batch.setProjectionMatrix(camera.combined);
            armour_checker();
            batch.draw(UpArrow, up_control.getPosition( ).x - UP_control_x, up_control.getPosition( ).y - UP_control_y, ArrowSize, ArrowSize);
            batch.draw(DownArrow, down_control.getPosition( ).x - Down_control_x, down_control.getPosition( ).y - Down_control_y, ArrowSize, ArrowSize);
            batch.draw(leftArrow, left_control.getPosition( ).x - left_control_x, left_control.getPosition( ).y - left_control_y, ArrowSize, ArrowSize);
            batch.draw(RightArrow, Right_control.getPosition( ).x - Right_control_x, Right_control.getPosition( ).y - Right_control_y, ArrowSize, ArrowSize);

            batch.draw(StairU, Stair_up.getPosition( ).x - Stair_up_x, Stair_up.getPosition( ).y - Stair_up_y);
            batch.draw(StairD, Stair_Down.getPosition( ).x - Stair_Down_x, Stair_Down.getPosition( ).y - Stair_Down_y);

            //health
            batch.draw(Healthbar, player1.getPosition( ).x - 20, player1.getPosition( ).y + 20, 50 * Health*ascept_width, 10*ascept_height);
            batch.draw(Emptybar, player1.getPosition( ).x - 20, player1.getPosition( ).y + 20, 50*ascept_width, 10*ascept_height);
            //level
            if (Level >= numL) {
                numL++;
                Level -= numL;
                if (Level < 0) Level *= -1;
                if(Main_hunger>0)hunger_reduce = (float) ((0.1 / numL) * 10/(Main_hunger+1));
                else hunger_reduce= (float) ((0.1 / numL) * 10);
                System.out.println("hunger reduce is now " + hunger_reduce);
                Hunger[0]=hunger_reduce;
                Hunger[1]=Main_hunger;
            }
            batch.draw(Levelbar, player1.getPosition( ).x - 20, player1.getPosition( ).y + 40, 50 * Level / numL*ascept_width, 10*ascept_height);
            batch.draw(Emptybar, player1.getPosition( ).x - 20, player1.getPosition( ).y + 40, 50*ascept_width, 10*ascept_height);
            font1.draw(batch, "Lvl." + numL, (player1.getPosition( ).x - 20), player1.getPosition( ).y + 80);
            font1.draw(batch, "" + Level / numL * 100, player1.getPosition( ).x - 20 + Level / numL * 25, player1.getPosition( ).y + 50);
            //hunger
            batch.draw(HungerBar, player1.getPosition( ).x - 20, player1.getPosition( ).y + 60, 50 * hunger / Hunger_still*ascept_width, 10*ascept_height);
            batch.draw(Emptybar, player1.getPosition( ).x - 20, player1.getPosition( ).y + 20, 50*ascept_width, 10*ascept_height);
            if (bodybeforestone != null)
                for (int checkplace2 = 0; checkplace2 < placestone; checkplace2++)
                    batch.draw(textureStone, blockstone[checkplace2].getPosition( ).x - 1, blockstone[checkplace2].getPosition( ).y - 1, 50 / PIXEL_PER_METER*ascept_width, 50 / PIXEL_PER_METER*ascept_height);
            if (bodybeforetree != null)
                for (int checkplace1 = 0; checkplace1 < placetree; checkplace1++)
                    batch.draw(texturewood, blocktree[checkplace1].getPosition( ).x, blocktree[checkplace1].getPosition( ).y, 50 / Playscreen.PIXEL_PER_METER*ascept_width, 50 / Playscreen.PIXEL_PER_METER*ascept_height);
            //Stats
            batch.draw(inmark,player1.getPosition().x+Gdx.graphics.getWidth()/6,player1.getPosition().y+Gdx.graphics.getHeight()/6,50*ascept_width,20*ascept_height);
            font.draw(batch,"Stats",player1.getPosition().x+2+Gdx.graphics.getWidth()/6,player1.getPosition().y+14+Gdx.graphics.getHeight()/6);
            //Build-items
            batch.draw(inmark,player1.getPosition().x+Gdx.graphics.getWidth()/6-60,player1.getPosition().y+Gdx.graphics.getHeight()/6,50*ascept_width,20*ascept_height);
            font.draw(batch,"Build",player1.getPosition().x+2+Gdx.graphics.getWidth()/6-60,player1.getPosition().y+14+Gdx.graphics.getHeight()/6);
            if(Gdx.input.justTouched())
                if(Gdx.input.getX()>=Gdx.graphics.getWidth()/6*5&&Gdx.input.getX()<=Gdx.graphics.getWidth()/6*5+100&&Gdx.input.getY()>=Gdx.graphics.getHeight()/6-40&&Gdx.input.getY()<=Gdx.graphics.getHeight()/6) {
                    batch.draw(outmark,player1.getPosition().x+Gdx.graphics.getWidth()/6,player1.getPosition().y+Gdx.graphics.getHeight()/6,50*ascept_width,20*ascept_height);
                    font.draw(batch,"Stats",player1.getPosition().x+2+Gdx.graphics.getWidth()/6,player1.getPosition().y+14+Gdx.graphics.getHeight()/6);
                    MODE_RIGHTNOW = 1;
                    onetime_Work = true;
                }

            if(Gdx.input.justTouched()) if(Gdx.input.getX()>=(590)&&Gdx.input.getX()<=(630)
                    &&Gdx.input.getY()>=h-(BAG_HEIGHT*3*3)&&Gdx.input.getY()<=h-(BAG_HEIGHT*3)){
                MODE_RIGHTNOW=2;
            }
            if(Gdx.input.justTouched())
                if(Gdx.input.getX()>=Gdx.graphics.getWidth()/6*5-120&&Gdx.input.getX()<=Gdx.graphics.getWidth()/6*5-20
                        &&Gdx.input.getY()>=Gdx.graphics.getHeight()/6-40&&Gdx.input.getY()<=Gdx.graphics.getHeight()/6){
                    batch.draw(outmark,player1.getPosition().x+Gdx.graphics.getWidth()/6-60,player1.getPosition().y+Gdx.graphics.getHeight()/6,50*ascept_width,20*ascept_height);
                    font.draw(batch,"Build",player1.getPosition().x+2+Gdx.graphics.getWidth()/6-60,player1.getPosition().y+14+Gdx.graphics.getHeight()/6);
                    MODE_RIGHTNOW=3;
                    onetime_Work=true;
                }
            font.draw(batch, "FLOOR: " + FloorNUM, player1.getPosition( ).x - 160, player1.getPosition( ).y - 105);
            //MOBS
            for (i3 = 0; i3 < SkeletonBody.size; i3++) {
                MoveSkeleton( );
                CheckSkeleton( );
                batch.draw(Healthbar, SkeletonBody.get(i3).getPosition( ).x - 20, SkeletonBody.get(i3).getPosition( ).y + 20, 50 * Health_Skeleton.get(i3), 10);
                batch.draw(Emptybar, SkeletonBody.get(i3).getPosition( ).x - 20, SkeletonBody.get(i3).getPosition( ).y + 20, 50, 10);
                if (moveleft_skeleton.get(i3) && movesides_skeleton.get(i3) && !enableanimatonSkeleton.get(i3))
                    batch.draw((TextureRegion) skeleton_walk_Right.getKeyFrame(timeloop4, true), SkeletonBody.get(i3).getPosition( ).x - Skeleton_Width, SkeletonBody.get(i3).getPosition( ).y - Skeleton_Height, SkeletonSize, SkeletonSize);
                if (moveright_skeleton.get(i3) && movesides_skeleton.get(i3) && !enableanimatonSkeleton.get(i3))
                    batch.draw((TextureRegion) skeleton_walk_left.getKeyFrame(timeloop4, true), SkeletonBody.get(i3).getPosition( ).x - Skeleton_Width, SkeletonBody.get(i3).getPosition( ).y - Skeleton_Height, SkeletonSize, SkeletonSize);
                if ((int) player1.getPosition( ).y / 10 < (int) SkeletonBody.get(i3).getPosition( ).y / 10 && enableanimatonSkeleton.get(i3)) {
                    movesides_skeleton.set(i3, false);
                    batch.draw((TextureRegion) skeleton_walk_down.getKeyFrame(timeloop4, true), SkeletonBody.get(i3).getPosition( ).x - atlasskeleton_down.getTextures( ).first( ).getHeight( ) / Skeleton_DOWN_X, SkeletonBody.get(i3).getPosition( ).y - atlasskeleton_down.getTextures( ).first( ).getHeight( ) / Skeleton_DOWN_Y, SkeletonSize, SkeletonSize);
                }
                if ((int) player1.getPosition( ).y / 10 > (int) SkeletonBody.get(i3).getPosition( ).y / 10 && enableanimatonSkeleton.get(i3)) {
                    movesides_skeleton.set(i3, false);
                    batch.draw((TextureRegion) skeleton_walk_up.getKeyFrame(timeloop4, true), SkeletonBody.get(i3).getPosition( ).x - atlasskeleton_up.getTextures( ).first( ).getHeight( ) / Skeleton_UP_X, SkeletonBody.get(i3).getPosition( ).y - atlasskeleton_up.getTextures( ).first( ).getHeight( ) / Skeleton_UP_Y, SkeletonSize, SkeletonSize);
                }
                if ((int) player1.getPosition( ).y / 10 == (int) SkeletonBody.get(i3).getPosition( ).y / 10) {
                    movesides_skeleton.set(i3, true);
                    if ((int) player1.getPosition( ).x < (int) SkeletonBody.get(i3).getPosition( ).x && enableanimatonSkeleton.get(i3))
                        batch.draw((TextureRegion) skeleton_walk_left.getKeyFrame(timeloop4, true), SkeletonBody.get(i3).getPosition( ).x - Skeleton_Width, SkeletonBody.get(i3).getPosition( ).y - Skeleton_Height, SkeletonSize, SkeletonSize);
                    if ((int) player1.getPosition( ).x > (int) SkeletonBody.get(i3).getPosition( ).x && enableanimatonSkeleton.get(i3))
                        batch.draw((TextureRegion) skeleton_walk_Right.getKeyFrame(timeloop4, true), SkeletonBody.get(i3).getPosition( ).x - Skeleton_Width, SkeletonBody.get(i3).getPosition( ).y - Skeleton_Height, SkeletonSize, SkeletonSize);
                }

            }
            for (i4 = 0; i4 < GolemBody.size; i4++) {
                MoveGolem( );
                CheckGolem( );
                if (timehit_Golem.get(i4) > 9f) {
                    DeadGolem.set(i4, true);
                    batch.draw((TextureRegion) Golem_died.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width_died, GolemBody.get(i4).getPosition( ).y - Golem_Height_Died, GolemSize, GolemSize);
                }
                batch.draw(Healthbar, GolemBody.get(i4).getPosition( ).x - 20, GolemBody.get(i4).getPosition( ).y + 20, 50 * Health_Golem.get(i4), 10);
                batch.draw(Emptybar, GolemBody.get(i4).getPosition( ).x - 20, GolemBody.get(i4).getPosition( ).y + 20, 50, 10);
                if (!DeadGolem.get(i4)) {
                    if (!(hit_Golem.get(i4) && (length_Golem.get(i4) >= 0) && (length_Golem.get(i4) <= 40) && hitforGolemEnable.get(i4)))
                        whileattacking.set(i4, false);
                    if (moveleft_Golem.get(i4) && movesides_Golem.get(i4) && !enableanimatonGolem.get(i4) && !whileattacking.get(i4))
                        batch.draw((TextureRegion) Golem_walk_Right.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width, GolemBody.get(i4).getPosition( ).y - Golem_Height, GolemSize, GolemSize);
                    if (moveright_Golem.get(i4) && movesides_Golem.get(i4) && !enableanimatonGolem.get(i4))
                        batch.draw((TextureRegion) Golem_walk_left.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width, GolemBody.get(i4).getPosition( ).y - Golem_Height, GolemSize, GolemSize);
                    //moving
                    if ((int) player1.getPosition( ).y / 10 < (int) GolemBody.get(i4).getPosition( ).y / 10 && enableanimatonGolem.get(i4) && !whileattacking.get(i4)) {
                        movesides_Golem.set(i4, false);
                        batch.draw((TextureRegion) Golem_walk_down.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - atlasgolemMove_down.getTextures( ).first( ).getWidth( ) / Golem_DOWN_X, GolemBody.get(i4).getPosition( ).y - atlasgolemMove_down.getTextures( ).first( ).getHeight( ) / Golem_DOWN_Y, GolemSize, GolemSize);
                    }
                    if ((int) player1.getPosition( ).y / 10 > (int) GolemBody.get(i4).getPosition( ).y / 10 && enableanimatonGolem.get(i4) && !whileattacking.get(i4)) {
                        movesides_Golem.set(i4, false);
                        batch.draw((TextureRegion) Golem_walk_up.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - atlasgolemMove_up.getTextures( ).first( ).getWidth( ) / Golem_UP_X, GolemBody.get(i4).getPosition( ).y - atlasgolemMove_up.getTextures( ).first( ).getHeight( ) / Golem_UP_Y, GolemSize, GolemSize);
                    }
                    if ((int) player1.getPosition( ).y / 10 == (int) GolemBody.get(i4).getPosition( ).y / 10 && !whileattacking.get(i4)) {
                        movesides_Golem.set(i4, true);
                        if ((int) player1.getPosition( ).x < (int) GolemBody.get(i4).getPosition( ).x && enableanimatonGolem.get(i4))
                            batch.draw((TextureRegion) Golem_walk_left.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width, GolemBody.get(i4).getPosition( ).y - Golem_Height, GolemSize, GolemSize);
                        if ((int) player1.getPosition( ).x > (int) GolemBody.get(i4).getPosition( ).x && enableanimatonGolem.get(i4))
                            batch.draw((TextureRegion) Golem_walk_Right.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width, GolemBody.get(i4).getPosition( ).y - Golem_Height, GolemSize, GolemSize);
                    }
                    //attack-down
                    if (hit_Golem.get(i4) && (length_Golem.get(i4) >= 0) && (length_Golem.get(i4) <= 40) && hitforGolemEnable.get(i4)
                            && (int) player1.getPosition( ).y / 10 < (int) GolemBody.get(i4).getPosition( ).y / 10 && Down_animaton_golem.get(i4)) {
                        timeloopA_Golem.set(i4, timeloopA_Golem.get(i4) + Gdx.graphics.getRawDeltaTime( ));
                        Up_animaton_golem.set(i4, false);
                        whileattacking.set(i4, true);
                        left_animaton_golem.set(i4, false);
                        Down_animaton_golem.set(i4, true);
                        Right_animaton_golem.set(i4, false);
                        batch.draw((TextureRegion) Golem_attack_down.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - atlasgolem_attack_down.getTextures( ).first( ).getWidth( ) / Golem_AttackDOWN_X, GolemBody.get(i4).getPosition( ).y - atlasgolem_attack_down.getTextures( ).first( ).getHeight( ) / Golem_AttackDOWN_Y, GolemSize, GolemSize);
                        if (timeloopA_Golem.get(i4) > 1f) {
                            Health -= 0.05;
                            System.out.println("Health" + Health);
                            hit_Golem.set(i4, false);
                            timeloopA_Golem.set(i4, 0f);
                            Up_animaton_golem.set(i4, true);
                            left_animaton_golem.set(i4, true);
                            Down_animaton_golem.set(i4, true);
                            Right_animaton_golem.set(i4, true);
                            whileattacking.set(i4, false);
                        }
                    }
                    if ((int) player1.getPosition( ).y / 10 > (int) GolemBody.get(i4).getPosition( ).y / 10 && hit_Golem.get(i4) && (length_Golem.get(i4) >= 0) &&
                            (length_Golem.get(i4) <= 40) && hitforGolemEnable.get(i4) && (Up_animaton_golem.get(i4))) {
                        timeloopA_Golem.set(i4, timeloopA_Golem.get(i4) + Gdx.graphics.getRawDeltaTime( ));
                        Up_animaton_golem.set(i4, true);
                        left_animaton_golem.set(i4, false);
                        Down_animaton_golem.set(i4, false);
                        Right_animaton_golem.set(i4, false);
                        whileattacking.set(i4, true);
                        batch.draw((TextureRegion) Golem_attack_up.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - atlasgolem_attack_up.getTextures( ).first( ).getWidth( ) / Golem_AttackUp_X, GolemBody.get(i4).getPosition( ).y - atlasgolem_attack_up.getTextures( ).first( ).getHeight( ) / Golem_AttackUp_Y, GolemSize, GolemSize);
                        if (timeloopA_Golem.get(i4) > 1f) {
                            Health -= 0.05;
                            System.out.println("Health" + Health);
                            hit_Golem.set(i4, false);
                            timeloopA_Golem.set(i4, 0f);
                            Up_animaton_golem.set(i4, true);
                            left_animaton_golem.set(i4, true);
                            Down_animaton_golem.set(i4, true);
                            Right_animaton_golem.set(i4, true);
                            whileattacking.set(i4, false);

                        }
                    }
                    if ((int) player1.getPosition( ).x < (int) GolemBody.get(i4).getPosition( ).x && enableanimatonGolem.get(i4) && hit_Golem.get(i4) && (length_Golem.get(i4) >= 0) && (length_Golem.get(i4) <= 40) && hitforGolemEnable.get(i4)
                            && left_animaton_golem.get(i4)) {
                        timeloopA_Golem.set(i4, timeloopA_Golem.get(i4) + Gdx.graphics.getRawDeltaTime( ));
                        Up_animaton_golem.set(i4, false);
                        left_animaton_golem.set(i4, true);
                        Down_animaton_golem.set(i4, false);
                        Right_animaton_golem.set(i4, false);
                        whileattacking.set(i4, true);
                        batch.draw((TextureRegion) Golem_attack_left.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width_Attack, GolemBody.get(i4).getPosition( ).y - Golem_Height_Attack, GolemSize, GolemSize);
                        if (timeloopA_Golem.get(i4) > 1f) {
                            Health -= 0.05;
                            Down_animaton_golem.set(i4, true);
                            Up_animaton_golem.set(i4, true);
                            System.out.println("Health" + Health);
                            hit_Golem.set(i4, false);
                            timeloopA_Golem.set(i4, 0f);
                            Up_animaton_golem.set(i4, true);
                            left_animaton_golem.set(i4, true);
                            Down_animaton_golem.set(i4, true);
                            Right_animaton_golem.set(i4, true);
                            whileattacking.set(i4, false);
                        }
                    }
                    if ((int) player1.getPosition( ).x > (int) GolemBody.get(i4).getPosition( ).x && enableanimatonGolem.get(i4) && hit_Golem.get(i4) && (length_Golem.get(i4) >= 0) && (length_Golem.get(i4) <= 40) && hitforGolemEnable.get(i4)
                            && Right_animaton_golem.get(i4)) {
                        Up_animaton_golem.set(i4, false);
                        left_animaton_golem.set(i4, false);
                        Down_animaton_golem.set(i4, false);
                        Right_animaton_golem.set(i4, true);
                        whileattacking.set(i4, true);
                        timeloopA_Golem.set(i4, timeloopA_Golem.get(i4) + Gdx.graphics.getRawDeltaTime( ));
                        batch.draw((TextureRegion) Golem_attack_Right.getKeyFrame(timeloop4, true), GolemBody.get(i4).getPosition( ).x - Golem_Width_Attack, GolemBody.get(i4).getPosition( ).y - Golem_Height_Attack, GolemSize, GolemSize);
                        if (timeloopA_Golem.get(i4) > 1f) {
                            Health -= 0.05;
                            System.out.println("Health" + Health);
                            hit_Golem.set(i4, false);
                            timeloopA_Golem.set(i4, 0f);
                            Up_animaton_golem.set(i4, true);
                            left_animaton_golem.set(i4, true);
                            Down_animaton_golem.set(i4, true);
                            Right_animaton_golem.set(i4, true);
                            whileattacking.set(i4, false);
                        }
                    }
                }
            }
            for (i5 = 0; i5 < GhostBody.size; i5++) {
                batch.draw(Ghost_Standing, GhostBody.get(i5).getPosition( ).x - Ghost_Width, GhostBody.get(i5).getPosition( ).y - Ghost_Height, GhostSize, GhostSize);
                CheckGhost( );
                if (timehit_Ghost.get(i5) > 9f) {
                    Died_Ghost.set(i5, true);
                    batch.draw((TextureRegion) ghostA_died.getKeyFrame(timeloop4, true), GhostBody.get(i5).getPosition( ).x - Ghost_Width_Died, GhostBody.get(i5).getPosition( ).y - Ghost_Height_Died, GhostSize, GhostSize);
                }
                batch.draw(Healthbar, GhostBody.get(i5).getPosition( ).x - 20, GhostBody.get(i5).getPosition( ).y + 20, 50 * Health_Ghost.get(i5), 10);
                batch.draw(Emptybar, GhostBody.get(i5).getPosition( ).x - 20, GhostBody.get(i5).getPosition( ).y + 20, 50, 10);
                if (!Died_Ghost.get(i5)) {
                    //right
                    if (hit_Ghost.get(i5) && (length_Ghost.get(i5) >= 0) && (length_Ghost.get(i5) <= 100) && hitforGhostEnable.get(i5) && player1.getPosition( ).x > GhostBody.get(i5).getPosition( ).x) {
                        timeloopA_Ghost_Right.set(i5, timeloopA_Ghost_Right.get(i5) + Gdx.graphics.getRawDeltaTime( ));
                        if (timeloopA_Ghost_Right.get(i5) < 1.7f)
                            batch.draw((TextureRegion) ghostA_attack_Right.getKeyFrame(timeloop4, true), GhostBody.get(i5).getPosition( ).x - Ghost_Width, GhostBody.get(i5).getPosition( ).y - Ghost_Height, GhostSize, GhostSize);
                        if (timeloopA_Ghost_Right.get(i5) > 1.7f) {
                            Health -= 0.05;
                            System.out.println("Health" + Health);
                            hit_Ghost.set(i5, false);
                            rightattack.set(i5, true);
                            leftattack.set(i5, false);
                        }
                    }
                    if (timeloopA_Ghost_Right.get(i5) > 1.7f && rightattack.get(i5)) {
                        if (Start_attackGhoul.get(i5))
                            Fireball_right.get(i5).setTransform(new Vector2(GhostBody.get(i5).getPosition( ).x, GhostBody.get(i5).getPosition( ).y), 0);
                        dx_Ghost.set(i5, (dx_Ghost.get(i5) * 80));
                        Start_attackGhoul.set(i5, false);
                        dy_Ghost.set(i5, (dy_Ghost.get(i5) * 80));
                        float dx_Speed = dx_Ghost.get(i5);
                        float dy_Speed = dy_Ghost.get(i5);
                        Fireball_right.get(i5).setLinearVelocity(new Vector2(dx_Speed, dy_Speed));
                        batch.draw(Fireballattack_Right, Fireball_right.get(i5).getPosition( ).x - Fireball_width, Fireball_right.get(i5).getPosition( ).y - Fireball_Height, 20, 20);
                        timefireball.set(i5, timefireball.get(i5) + Gdx.graphics.getRawDeltaTime( ));
                        if (timefireball.get(i5) > (length_Ghost.get(i5) / 100)) {
                            timeloopA_Ghost_Right.set(i5, 0f);
                            timefireball.set(i5, 0f);
                            Start_attackGhoul.set(i5, true);
                            Fireball_right.get(i5).setTransform(new Vector2(camera.position.x * 2000, camera.position.y * 200), 0);
                            rightattack.set(i5, false);
                            leftattack.set(i5, true);
                        }
                    }
                    //left

                    if (hit_Ghost.get(i5) && (length_Ghost.get(i5) >= 0) && (length_Ghost.get(i5) <= 100) && hitforGhostEnable.get(i5) && player1.getPosition( ).x < GhostBody.get(i5).getPosition( ).x) {
                        timeloopA_Ghost_left.set(i5, timeloopA_Ghost_left.get(i5) + Gdx.graphics.getRawDeltaTime( ));
                        if (timeloopA_Ghost_left.get(i5) < 0.5f)
                            batch.draw((TextureRegion) ghost_attack_left.getKeyFrame(timeloop4, true), GhostBody.get(i5).getPosition( ).x - Ghost_Width, GhostBody.get(i5).getPosition( ).y - Ghost_Height, GhostSize, GhostSize);
                        if (timeloopA_Ghost_left.get(i5) > 0.5f) {
                            Health -= 0.05;
                            System.out.println("Health" + Health);
                            hit_Ghost.set(i5, false);
                            leftattack.set(i5, true);
                            rightattack.set(i5, false);
                            Start_attackGhoul.set(i5, true);
                        }
                    }
                    if (timeloopA_Ghost_left.get(i5) > 0.5f && leftattack.get(i5)) {
                        if (Start_attackGhoul.get(i5))
                            Fireball_left.get(i5).setTransform(new Vector2(GhostBody.get(i5).getPosition( ).x, GhostBody.get(i5).getPosition( ).y), 0);
                        dx_Ghost.set(i5, (dx_Ghost.get(i5) * 80));
                        Start_attackGhoul.set(i5, false);
                        dy_Ghost.set(i5, (dy_Ghost.get(i5) * 80));
                        float dx_Speed = dx_Ghost.get(i5);
                        float dy_Speed = dy_Ghost.get(i5);
                        Fireball_left.get(i5).setLinearVelocity(new Vector2(dx_Speed, dy_Speed));
                        batch.draw(Fireballattack_Left, Fireball_left.get(i5).getPosition( ).x - Fireball_width, Fireball_left.get(i5).getPosition( ).y - Fireball_Height, 20, 20);
                        timefireball.set(i5, timefireball.get(i5) + Gdx.graphics.getRawDeltaTime( ));
                        if (timefireball.get(i5) > (length_Ghost.get(i5) / 100)) {
                            timeloopA_Ghost_left.set(i5, 0f);
                            timefireball.set(i5, 0f);
                            Start_attackGhoul.set(i5, true);
                            Fireball_left.get(i5).setTransform(new Vector2(camera.position.x * 2000, camera.position.y * 200), 0);
                            rightattack.set(i5, true);
                            leftattack.set(i5, true);
                        }
                    }
                }
            }
            batch.end( );
        }
        if(MODE_RIGHTNOW==1){
            if(onetime_Work){
                howmanytimes_lefttoadd =numL- level_Main;
                Main_reduce=numL- level_Main;
                onetime_Work=false;
            }
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            camera.update();
            tiledMapRenderer=new OrthogonalTiledMapRenderer(map1,0.7f*(ascept_width/ascept_height));
            tiledMapRenderer.setView(camera);
            tiledMapRenderer.render();
            batch.begin();
            batch.setProjectionMatrix(camera.combined);
            //Health regnant = 0.2 * how many times
            font2.draw(batch,"Health:",Gdx.graphics.getWidth()/2-50+Width_Stats,Gdx.graphics.getHeight()/2+115+up_Stats);
            batch.draw(heart,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,60*ascept_width,60*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30*ascept_width,30*ascept_height);
            font2.draw(batch,""+addHelath,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2+115+up_Stats);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30*ascept_width,30*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2+85+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2+95+up_Stats,30*ascept_width,30*ascept_height);
            //attack reduce time_Stats every 4 is old time_Stats/1/4 * by how many times is 4 just 4
            font2.draw(batch,"Attack:",Gdx.graphics.getWidth()/2-50+Width_Stats,Gdx.graphics.getHeight()/2+65+up_Stats);
            batch.draw(AttackDamdge,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,60*ascept_width,60*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30*ascept_width,30*ascept_height);
            font2.draw(batch,""+addattack,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2+65+up_Stats);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30*ascept_width,30*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2+35+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2+45+up_Stats,30*ascept_width,30*ascept_height);
            //redcue damdge=olddamdge/addImmunity/4
            font2.draw(batch,"Immunity :",Gdx.graphics.getWidth()/2-70+Width_Stats,Gdx.graphics.getHeight()/2+15+up_Stats);
            batch.draw(addRestunce,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,60*ascept_width,60*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30*ascept_width,30*ascept_height);
            font2.draw(batch,""+addImmunity,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2+15+up_Stats);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30*ascept_width,30*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-25+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-15+up_Stats,30*ascept_width,30*ascept_height);
            //Hunger reduce =hunger time_Stats+(hungertime*0.2)
            font2.draw(batch,"Hunger:",Gdx.graphics.getWidth()/2-70+Width_Stats,Gdx.graphics.getHeight()/2-45+up_Stats);
            batch.draw(meat,Gdx.graphics.getWidth()/2-130+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,60*ascept_width,60*ascept_height);
            batch.draw(addRestunce,Gdx.graphics.getWidth()/2-120+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,60*ascept_width,60*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30*ascept_width,30*ascept_height);
            font2.draw(batch,""+addHunger,Gdx.graphics.getWidth()/2+30+Width_Stats,Gdx.graphics.getHeight()/2-45+up_Stats);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30*ascept_width,30*ascept_height);
            batch.draw(inmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50*ascept_width,50*ascept_height);
            batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30*ascept_width,30*ascept_height);
            //Done
            batch.draw(inmark,Gdx.graphics.getWidth()/2+Width_Stats,Gdx.graphics.getHeight()/2-195+up_Stats,50*ascept_width,50*ascept_height);
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
        if(MODE_RIGHTNOW==2){
            Gdx.gl.glClearColor(0, 0, 0, 1);
            Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            camera.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
            camera.position.set(w/2,h/2,0);
            camera.update();
            batch.begin();
            batch.setProjectionMatrix(camera.combined);
            if(Gdx.input.justTouched())System.out.println(Gdx.input.getY());
            //Left side
            batch.draw(Left_Inv,0,0, Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight());
            for(int j=0;j<Equip_Slot_Y.length;j++)for(int i=0;i<Equip_Slot_X.length;i++)
                batch.draw(Slot_Space,Equip_Slot_X[i],Equip_Slot_Y[j],40,50);
            for(int j=0;j<Equip_Slot_Y_Down.length;j++)for(int i=0;i<Equip_Slot_X_Down.length;i++)
                batch.draw(Slot_Space,Equip_Slot_X_Down[i],Equip_Slot_Y_Down[j],40,50);
            //Right Side
            batch.draw(Right_Inv,Gdx.graphics.getWidth()/2,0,Gdx.graphics.getWidth()/2*ascept_width,Gdx.graphics.getHeight()*ascept_height);
            batch.draw(inmark,w/2+80,40,60*ascept_width,30*ascept_height);
            font.draw(batch,"Equip",w/2+85,60);
            batch.draw(inmark,w/2+140,40,60*ascept_width,30*ascept_height);
            font.draw(batch,"UNEquip",w/2+140,60);
            for(int j7=0;j7<5;j7++)
                for(int i7=0;i7<6;i7++)
                    batch.draw(Slot_Space,SlotSpace_X[i7],SlotSpace_Y[j7],40*ascept_width,50*ascept_height);
            if(Gdx.input.justTouched())
                handleclicks();
            extrainvertoychange();
            outsidetoclose();
            batch.end();
        }
        if(MODE_RIGHTNOW==3){
            if(onetime_Work){
                camera.setToOrtho(false,w,h);
                camera.update();
                onetime_Work=false;
            }
            Gdx.gl.glClearColor(1, 1, 1, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
            batch.begin();
            batch.setProjectionMatrix(camera.combined);
            batch.draw(Right_Inv,w/2,0,w/2*ascept_width,h*ascept_height);
            batch.draw(Build_info,0,0,w/2*ascept_width,h*ascept_height);
            for(int j7=0;j7<5;j7++)
                for(int i7=0;i7<6;i7++) {
                    System.out.println(SlotBuildSpace_X[i7]);
                    batch.draw(Slot_Space, SlotBuildSpace_X[i7], SlotBuildSpace_Y[j7], 45 * ascept_width, 50 * ascept_height);
                }
            batch.draw(inmark,w/2+100,380,80*ascept_width,30*ascept_height);
            font4.draw(batch,"Build",w/2+100+10,380+20);
            drawBuildItems();
            if(Gdx.input.justTouched()) ClickBuildButton();
            TheinfoButton();
            ExitWay();
            batch.end();
        }
    }

    private void ChangeStats() {
        RecoverHealth();
        Damdgerestense();
    }
    private void Damdgerestense() {
        //it change in health reduce
    }
    private void RecoverHealth() {
        if(Health<1&&Main_health>0)Start_Recov=true;
        if(Start_Recov) {
            timeloop_recover += Gdx.graphics.getRawDeltaTime( );
            if (timeloop_recover >3f && Health < 1&&Health>0&&recover_Health) {
                Health += Main_health * 0.1f;
                timeloop_recover=0;
            }
            if(!recover_Health&&hunger_check>=10){
                Health-=0.05;
                hunger_check=0;
            }
            if(Health<0){
                Health=0;
                recover_Health=false;
            }
            if (Health >= 1) {
                timeloop_recover=0;
                Health = 1;
                Start_Recov = false;
                recover_Health=true;
            }
        }
    }


    private void  ClickBuildButton(){
        if(Gdx.input.getX()>=w/2+100&&Gdx.input.getX()<=w/2+180&&Gdx.input.getY()>=h-(380+30)&&Gdx.input.getY()<=h-(380)){
            batch.draw(outmark,w/2+100,380,80,30);
            font4.draw(batch,"Build",w/2+100+10,380+20);
            if(WhichInfo[0]==1) if(getstone_items1>4){
                getstone_items1-=5;
                getIron_items++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(Iron_ingot);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(Iron_ingot).getHeight()
                                &&ISlots.get(mmm).getWidth()==(Iron_ingot).getWidth())  IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(Iron_ingot);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[1]==1)if(getstone_items1>9){
                getstone_items1-=10;
                getGold_items++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(Gold_ingot);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(Gold_ingot).getHeight()
                                &&ISlots.get(mmm).getWidth()==(Gold_ingot).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(Gold_ingot);
                        System.out.println("ssksks"+ix+"  "+ISlots.size);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[2]==1)if(getGold_items>4){
                getGold_items-=5;
                Helemt_gold_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(golden_armour);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(golden_armour).getHeight()&&
                                ISlots.get(mmm).getWidth()==(golden_armour).getWidth() ) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(golden_armour);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[3]==1)if(getGold_items>5){
                getGold_items-=6;
                chest_gold_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(golden_armour_chest);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(golden_armour_chest).getHeight()
                                &&ISlots.get(mmm).getWidth()==(golden_armour_chest).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(golden_armour_chest);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[4]==1) if(getGold_items>3){
                getGold_items-=4;
                leg_gold_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(golden_armour_leg);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(golden_armour_leg).getHeight()
                                &&ISlots.get(mmm).getWidth()==(golden_armour_leg).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(golden_armour_leg);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[5]==1)if(getGold_items>1){
                getGold_items-=2;
                foot_gold_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(golden_armor_foot);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(golden_armor_foot).getHeight()
                                &&ISlots.get(mmm).getWidth()==(golden_armor_foot).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(golden_armor_foot);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[6]==1)if(getIron_items>4){
                getIron_items-=5;
                Helemt_metal_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(metal_armor_helemt);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(metal_armor_helemt).getHeight()
                                &&ISlots.get(mmm).getWidth()==(metal_armor_helemt).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(metal_armor_helemt);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[7]==1)if(getIron_items>5){
                getIron_items-=6;
                chest_metal_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(metal_armor_chest);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(metal_armor_chest).getHeight()
                                &&ISlots.get(mmm).getWidth()==(metal_armor_chest).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(metal_armor_chest);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[8]==1)if(getIron_items>3){
                getIron_items-=4;
                leg_metal_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(metal_armor_leg);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(metal_armor_leg).getHeight()
                                &&ISlots.get(mmm).getWidth()==(metal_armor_leg).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(metal_armor_leg);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            if(WhichInfo[9]==1)if(getIron_items>1){
                getIron_items-=2;
                foot_metal_item++;
                ICollect=true;
                if(ICollect) {
                    if (first) {
                        ISlots.add(metal_armor_feet);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==(metal_armor_feet).getHeight()
                                &&ISlots.get(mmm).getWidth()==(metal_armor_feet).getWidth()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(ix);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(metal_armor_feet);
                        ix = 0;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
        }
        for(int mj = 0; mj< SlotBuildSpace_Y.length; mj++)
            for(int mi = 0; mi< SlotBuildSpace_X.length; mi++) {
                if (Gdx.input.getX( ) >= SlotBuildSpace_X[mi] && Gdx.input.getX( ) <= SlotBuildSpace_X[mi] + 40&&Gdx.input.getY()>=(h- SlotBuildSpace_Y[mj]-50)&&Gdx.input.getY()<=(h- SlotBuildSpace_Y[mj])) {
                    System.out.println("True   "+mi+"  "+mj+"  ");
                    if((mi+mj*6)<BuildISlots.size)if(BuildISlots.get(mi+mj*6)!=null) {
                        if(BuildISlots.get(mi+mj*6).getHeight()==Iron_ingot.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==Iron_ingot.getWidth())WhichInfo[0]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=Iron_ingot.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=Iron_ingot.getWidth())WhichInfo[0]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==Gold_ingot.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==Gold_ingot.getWidth())WhichInfo[1]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=Gold_ingot.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=Gold_ingot.getWidth())WhichInfo[1]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==golden_armour.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==golden_armour.getWidth())WhichInfo[2]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=golden_armour.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=golden_armour.getWidth())WhichInfo[2]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==golden_armour_chest.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==golden_armour_chest.getWidth())WhichInfo[3]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=golden_armour_chest.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=golden_armour_chest.getWidth())WhichInfo[3]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==golden_armour_leg.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==golden_armour_leg.getWidth())WhichInfo[4]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=golden_armour_leg.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=golden_armour_leg.getWidth())WhichInfo[4]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==golden_armor_foot.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==golden_armor_foot.getWidth())WhichInfo[5]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=golden_armor_foot.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=golden_armor_foot.getWidth())WhichInfo[5]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==metal_armor_helemt.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==metal_armor_helemt.getWidth())WhichInfo[6]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=metal_armor_helemt.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=metal_armor_helemt.getWidth())WhichInfo[6]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==metal_armor_chest.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==metal_armor_chest.getWidth())WhichInfo[7]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=metal_armor_chest.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=metal_armor_chest.getWidth())WhichInfo[7]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==metal_armor_leg.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==metal_armor_leg.getWidth())WhichInfo[8]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=metal_armor_leg.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=metal_armor_leg.getWidth())WhichInfo[8]=0;

                        if(BuildISlots.get(mi+mj*6).getHeight()==metal_armor_feet.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()==metal_armor_feet.getWidth())WhichInfo[9]=1;

                        if(BuildISlots.get(mi+mj*6).getHeight()!=metal_armor_feet.getHeight()
                                &&BuildISlots.get(mi+mj*6).getWidth()!=metal_armor_feet.getWidth())WhichInfo[9]=0;


                        Info_texture=BuildISlots.get(mi + mj * 6);
                    }
                }
            }
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
                System.out.println("Hunger +");
                if (howmanytimes_lefttoadd > 0) {
                    addHunger += 1;
                    howmanytimes_lefttoadd -= 1;
                }
                else which_writing="Cant add anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+40+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
                batch.draw(Add,Gdx.graphics.getWidth()/2+50+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
            }
            //reduce
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 90+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 + 25-up_Stats && Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 75+-up_Stats){
                System.out.println("Hunger -");
                if (howmanytimes_lefttoadd < Main_reduce&&addHunger>Main_hunger) {
                    addHunger -= 1;
                    howmanytimes_lefttoadd += 1;
                }
                else which_writing="Cant reduce anymore";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+90+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
                batch.draw(decres,Gdx.graphics.getWidth()/2+100+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);
            }
            if (Gdx.input.getX( ) >= Gdx.graphics.getWidth( ) / 2 + 140+Width_Stats && Gdx.input.getX( ) <= Gdx.graphics.getWidth( ) / 2 + 200+Width_Stats && Gdx.input.getY( ) >= Gdx.graphics.getHeight( ) / 2 + 25 -up_Stats&& Gdx.input.getY( ) <= Gdx.graphics.getHeight( ) / 2 + 75-up_Stats)
            {
                System.out.println("Hunger ?");
                which_writing="hunger time_Stats reduce";
                batch.draw(outmark,Gdx.graphics.getWidth()/2+140+Width_Stats,Gdx.graphics.getHeight()/2-75+up_Stats,50,50);
                batch.draw(QuestionM,Gdx.graphics.getWidth()/2+150+Width_Stats,Gdx.graphics.getHeight()/2-65+up_Stats,30,30);

            }
            if(Gdx.input.getX()>=Gdx.graphics.getWidth()/2+Width_Stats&&Gdx.input.getX()<=Gdx.graphics.getWidth()/2+Width_Stats+50&&Gdx.input.getY()>=Gdx.graphics.getHeight()/2+145-up_Stats&&Gdx.input.getY()<=Gdx.graphics.getHeight()/2+195-up_Stats)
            {

                level_Main=numL;
                Main_hunger=addHunger;
                Main_Immunity=addImmunity;
                Main_attack=addattack;
                Main_health=addHelath;
                howmanytimes_lefttoadd =numL- level_Main;
                Main_reduce=numL- level_Main;
                Stats[0]=level_Main;
                Stats[1]=Main_hunger;
                Stats[2]=Main_Immunity;
                Stats[3]=Main_attack;
                Stats[4]=Main_health;
                Stats[5]=howmanytimes_lefttoadd;
                Stats[6]=Main_reduce;
                camera.setToOrtho(false,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
                tiledMapRenderer=new OrthogonalTiledMapRenderer(map1,2);
                MODE_RIGHTNOW=0;
                batch.draw(outmark,Gdx.graphics.getWidth()/2+Width_Stats,Gdx.graphics.getHeight()/2-195+up_Stats,50,50);
                System.out.println("Exit");
            }
        }
    }
    private void handleclicks() {
        if(Gdx.input.getX()>=(w/2+80)&&Gdx.input.getX()<=(w/2+140)&&Gdx.input.getY()>=(h-70)&&Gdx.input.getY()<=(h-40)){
            System.out.println("Equip");
            batch.draw(outmark,w/2+80,40,60,30);
            font.draw(batch,"Equip",w/2+85,60);
            Equip=true;
            if(slected_Equip &&Equip)
                if(Move_Texture.length>0){
                    //which Texture
                    // 0 0
                    // 0 0
                    if(Helemt_Texture_gold&&!Helemt_Texture_metal) {//Helemt
                        New_Extrainvertoy_X[0]=Equip_Slot_X[0];
                        New_Extrainvertoy_Y[0]=Equip_Slot_Y[0];
                        slected_X[0]=0;
                        slected_Y[0]=0;
                        System.out.println("Helemt Click");
                        changing_placeT[0]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==golden_armour.getHeight()&&
                                    ISlots.get(mmm).getWidth()==golden_armour.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(Chest_Texture_gold&&!Chest_Texture_metal){
                        New_Extrainvertoy_X[1]=Equip_Slot_X[1];
                        New_Extrainvertoy_Y[1]=Equip_Slot_Y[0];
                        slected_X[1]=1;
                        slected_Y[1]=0;
                        System.out.println("Chest Click");
                        changing_placeT[1]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==golden_armour_chest.getHeight()&&
                                    ISlots.get(mmm).getWidth()==golden_armour_chest.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(legs_Texture_gold&&!legs_Texture_metal) {//Helemt
                        New_Extrainvertoy_X[2]=Equip_Slot_X[0];
                        New_Extrainvertoy_Y[2]=Equip_Slot_Y[1];
                        slected_X[2]=0;
                        slected_Y[2]=1;
                        System.out.println("legs click");
                        changing_placeT[2]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==golden_armour_leg.getHeight()&&
                                    ISlots.get(mmm).getWidth()==golden_armour_leg.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(foot_Texture_gold&&!foot_Texture_metal) {//Helemt
                        New_Extrainvertoy_X[3]=Equip_Slot_X[1];
                        New_Extrainvertoy_Y[3]=Equip_Slot_Y[1];
                        slected_X[3]=1;
                        slected_Y[3]=1;
                        System.out.println("foot Click");
                        changing_placeT[3]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==golden_armor_foot.getHeight()&&
                                    ISlots.get(mmm).getWidth()==golden_armor_foot.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(Helemt_Texture_metal&&!Helemt_Texture_gold) {//Helemt
                        New_Extrainvertoy_X[0]=Equip_Slot_X[0];
                        New_Extrainvertoy_Y[0]=Equip_Slot_Y[0];
                        slected_X[0]=0;
                        slected_Y[0]=0;
                        System.out.println("Helemt2 Click");
                        changing_placeT[4]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==metal_armor_helemt.getHeight()&&
                                    ISlots.get(mmm).getWidth()==metal_armor_helemt.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(Chest_Texture_metal&&!Chest_Texture_gold) {//Helemt
                        New_Extrainvertoy_X[1]=Equip_Slot_X[1];
                        New_Extrainvertoy_Y[1]=Equip_Slot_Y[0];
                        slected_X[1]=1;
                        slected_Y[1]=0;
                        System.out.println("chest2 Click");
                        changing_placeT[5]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==metal_armor_chest.getHeight()&&
                                    ISlots.get(mmm).getWidth()==metal_armor_chest.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(legs_Texture_metal&&!legs_Texture_gold) {//Helemt
                        New_Extrainvertoy_X[2]=Equip_Slot_X[0];
                        New_Extrainvertoy_Y[2]=Equip_Slot_Y[1];
                        slected_X[2]=0;
                        slected_Y[2]=1;
                        System.out.println("legs2 Click");
                        changing_placeT[6]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==metal_armor_leg.getHeight()&&
                                    ISlots.get(mmm).getWidth()==metal_armor_leg.getWidth())extraISlots.set(mmm,null);
                        }
                    }
                    if(foot_Texture_metal&&!foot_Texture_gold) {//Helemt
                        New_Extrainvertoy_X[3]=Equip_Slot_X[1];
                        New_Extrainvertoy_Y[3]=Equip_Slot_Y[1];
                        slected_X[3]=1;
                        slected_Y[3]=1;
                        System.out.println("foot2 Click");
                        changing_placeT[7]=true;
                        Change_T=true;
                        Equip=false;
                        slected_Equip =false;
                        for(int mmm=0;mmm<extraISlots.size;mmm++){
                            if(ISlots.get(mmm).getHeight()==metal_armor_feet.getHeight()&&
                                    ISlots.get(mmm).getWidth()==metal_armor_feet.getWidth())extraISlots.set(mmm,null);
                        }
                    }


                }
        }
        if(Gdx.input.getX()>=(w/2+140)&&Gdx.input.getX()<=(w/2+200)&&Gdx.input.getY()>=(h-70)&&Gdx.input.getY()<=(h-40)) {
            System.out.println("UnEquip  ");
            batch.draw(outmark,w/2+140,40,60,30);
            font.draw(batch,"UNEquip",w/2+140,60);
            UnEquip=true;
            // 0 0
            // 1 0
            // 0 1
            // 1 1
            if (UnEquip)
                for (int m2 = 0; m2 < New_Extrainvertoy_X.length; m2++) {
                    System.out.println(m2);
                    if (slected_X[0] != -1 && slected_UnEquip_X[0] && slected_UnEquip_Y[0]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[0]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[0]]) {
                            if (Move_Texture[0] != null)
                                if (Move_Texture[0].getHeight()==golden_armour.getHeight()&&
                                        Move_Texture[0].getWidth()==golden_armour.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[0] = null;
                                    changing_placeT[0] = false;
                                    slected_UnEquip_X[0] = false;
                                    slected_UnEquip_Y[0] = false;
                                    slected_X[0] = -1;
                                    slected_Y[0] = -1;
                                    Helemt_Texture_gold =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==golden_armour.getHeight()&&
                                                ISlots.get(mmm).getWidth()==golden_armour.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                    if (slected_X[1] != -1 && slected_UnEquip_X[1] && slected_UnEquip_Y[1]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[1]] &&
                                New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[1]])
                            if (Move_Texture[1] != null)
                                if (Move_Texture[1].getHeight()==golden_armour_chest.getHeight()&&
                                        Move_Texture[1].getWidth()==golden_armour_chest.getWidth()) {
                                    Move_Texture[1] = null;
                                    changing_placeT[1] = false;
                                    slected_UnEquip_X[1] = false;
                                    slected_UnEquip_Y[1] = false;
                                    slected_X[1] = -1;
                                    slected_Y[1] = -1;
                                    Chest_Texture_gold =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==golden_armour_chest.getHeight()&&
                                                ISlots.get(mmm).getWidth()==golden_armour_chest.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                    }
                    if (slected_X[2] != -1 && slected_UnEquip_X[2] && slected_UnEquip_Y[2]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[2]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[2]]) {
                            if (Move_Texture[2] != null)
                                if (Move_Texture[2].getHeight()==golden_armour_leg.getHeight()&&
                                        Move_Texture[2].getWidth()==golden_armour_leg.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[2] = null;
                                    changing_placeT[2] = false;
                                    slected_UnEquip_X[2] = false;
                                    slected_UnEquip_Y[2] = false;
                                    slected_X[2] = -1;
                                    slected_Y[2] = -1;
                                    legs_Texture_gold =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==golden_armour_leg.getHeight()&&
                                                ISlots.get(mmm).getWidth()==golden_armour_leg.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                    if (slected_X[3] != -1 && slected_UnEquip_X[3] && slected_UnEquip_Y[3]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[3]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[3]]) {
                            if (Move_Texture[3] != null)
                                if (Move_Texture[3].getHeight()==golden_armor_foot.getHeight()&&
                                        Move_Texture[3].getWidth()==golden_armor_foot.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[3] = null;
                                    changing_placeT[3] = false;
                                    slected_UnEquip_X[3] = false;
                                    slected_UnEquip_Y[3] = false;
                                    slected_X[3] = -1;
                                    slected_Y[3] = -1;
                                    foot_Texture_gold =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==golden_armor_foot.getHeight()&&
                                                ISlots.get(mmm).getWidth()==golden_armor_foot.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                    if (slected_X[0] != -1 && slected_UnEquip_X[0] && slected_UnEquip_Y[0]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[0]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[0]]) {
                            if (Move_Texture[4] != null)
                                if (Move_Texture[4].getHeight()==metal_armor_helemt.getHeight()&&
                                        Move_Texture[4].getWidth()==metal_armor_helemt.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[4] = null;
                                    changing_placeT[4] = false;
                                    slected_UnEquip_X[0] = false;
                                    slected_UnEquip_Y[0] = false;
                                    slected_X[0] = -1;
                                    slected_Y[0] = -1;
                                    Helemt_Texture_metal =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==metal_armor_helemt.getHeight()&&
                                                ISlots.get(mmm).getWidth()==metal_armor_helemt.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                    if (slected_X[1] != -1 && slected_UnEquip_X[1] && slected_UnEquip_Y[1]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[1]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[1]]) {
                            if (Move_Texture[5] != null)
                                if (Move_Texture[5].getHeight()==metal_armor_chest.getHeight()&&
                                        Move_Texture[5].getWidth()==metal_armor_chest.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[5] = null;
                                    changing_placeT[5] = false;
                                    slected_UnEquip_X[1] = false;
                                    slected_UnEquip_Y[1] = false;
                                    slected_X[1] = -1;
                                    slected_Y[1] = -1;
                                    Chest_Texture_metal =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==metal_armor_chest.getHeight()&&
                                                ISlots.get(mmm).getWidth()==metal_armor_chest.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                    if (slected_X[2] != -1 && slected_UnEquip_X[2] && slected_UnEquip_Y[2]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[2]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[2]]) {
                            if (Move_Texture[6] != null)
                                if (Move_Texture[6].getHeight()==metal_armor_leg.getHeight()&&
                                        Move_Texture[6].getWidth()==metal_armor_leg.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[6] = null;
                                    changing_placeT[6] = false;
                                    slected_UnEquip_X[2] = false;
                                    slected_UnEquip_Y[2] = false;
                                    slected_X[2] = -1;
                                    slected_Y[2] = -1;
                                    legs_Texture_metal =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==metal_armor_leg.getHeight()&&
                                                ISlots.get(mmm).getWidth()==metal_armor_leg.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                    if (slected_X[3] != -1 && slected_UnEquip_X[3] && slected_UnEquip_Y[3]) {
                        if (New_Extrainvertoy_X[m2] == Equip_Slot_X[slected_X[3]]
                                && New_Extrainvertoy_Y[m2] == Equip_Slot_Y[slected_Y[3]]) {
                            if (Move_Texture[7] != null)
                                if (Move_Texture[7].getHeight()==metal_armor_feet.getHeight()&&
                                        Move_Texture[7].getWidth()==metal_armor_feet.getWidth()) {
                                    System.out.println("mjdhfe");
                                    Move_Texture[7] = null;
                                    changing_placeT[7] = false;
                                    slected_UnEquip_X[3] = false;
                                    slected_UnEquip_Y[3] = false;
                                    slected_X[3] = -1;
                                    slected_Y[3] = -1;
                                    foot_Texture_metal =false;
                                    for(int mmm=0;mmm<ISlots.size;mmm++)
                                        if(extraISlots.get(mmm)==null&&ISlots.get(mmm).getHeight()==metal_armor_feet.getHeight()&&
                                                ISlots.get(mmm).getWidth()==metal_armor_feet.getWidth())extraISlots.set(mmm,ISlots.get(mmm));
                                }
                        }
                    }
                }
            UnEquip=false;
            slected_Equip =false;
        }
        for(int j=0;j<SlotSpace_Y.length;j++)
            for(int i=0;i<SlotSpace_X.length;i++) {
                if (Gdx.input.getX( ) >= SlotSpace_X[i] && Gdx.input.getX( ) <= SlotSpace_X[i] + 40 && Gdx.input.getY( ) >= (h - SlotSpace_Y[j] - 50) && Gdx.input.getY( ) <= (h - SlotSpace_Y[j])) {
                    System.out.println(i + "  " + j + "   " + (i + j * 6) + "    " + ISlots.size);
                    //Todo:make a Click Equip and it will Equip the item and if u click at that item it will unequip
                    if((i+j*6)<ISlots.size){
                        for(int mmm=0;mmm<Move_Texture.length;mmm++){
                            if(Move_Texture[mmm]!=null) {
                                if (Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==golden_armour.getHeight()&&
                                        ISlots.get(mmm).getWidth()==golden_armour.getWidth()) {//one item
                                    Change_T = false;
                                    System.out.println("Same Helemt");
                                    Helemt_Texture_gold = true;
                                }
                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==golden_armour_chest.getHeight()&&
                                        ISlots.get(mmm).getWidth()==golden_armour_chest.getWidth())){
                                    Chest_Texture_gold =true;
                                    Change_T = false;
                                    System.out.println("Same Chest");
                                }
                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==golden_armour_leg.getHeight()&&
                                        ISlots.get(mmm).getWidth()==golden_armour_leg.getWidth())){
                                    legs_Texture_gold =true;
                                    Change_T = false;
                                    System.out.println("Same legs");
                                }

                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==golden_armor_foot.getHeight()&&
                                        ISlots.get(mmm).getWidth()==golden_armor_foot.getWidth())){
                                    foot_Texture_gold =true;
                                    Change_T = false;
                                    System.out.println("Same feet");
                                }
                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==metal_armor_helemt.getHeight()&&
                                        ISlots.get(mmm).getWidth()==metal_armor_helemt.getWidth())){
                                    Helemt_Texture_metal =true;
                                    Change_T = false;
                                    System.out.println("Same Chest");
                                }
                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==metal_armor_chest.getHeight()&&
                                        ISlots.get(mmm).getWidth()==metal_armor_chest.getWidth())){
                                    Chest_Texture_metal =true;
                                    Change_T = false;
                                    System.out.println("Same Chest");
                                }
                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==metal_armor_leg.getHeight()&&
                                        ISlots.get(mmm).getWidth()==metal_armor_leg.getWidth())){
                                    legs_Texture_metal =true;
                                    Change_T = false;
                                    System.out.println("Same Chest");
                                }
                                if((Move_Texture[mmm].getHeight( ) == ISlots.get(i + j * 6).getHeight( ) &&ISlots.get(mmm).getHeight()==metal_armor_feet.getHeight()&&
                                        ISlots.get(mmm).getWidth()==metal_armor_feet.getWidth())){
                                    foot_Texture_metal =true;
                                    Change_T = false;
                                    System.out.println("Same Chest");
                                }

                            }
                        }

                        slected_Equip =true;
                        if(Old_Extrainvertoy_X.size==0) {
                            if(ISlots.get(i+j*6).getHeight()==golden_armour.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==golden_armour.getWidth()) {
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[0] = ISlots.get(i + j * 6);
                                System.out.println("add Helemt");
                            }
                            if(ISlots.get(i+j*6).getHeight()==golden_armour_chest.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==golden_armour_chest.getWidth()){
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[1] = ISlots.get(i + j * 6);
                                System.out.println("add chest");
                            }
                            if(ISlots.get(i+j*6).getHeight()==golden_armour_leg.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==golden_armour_leg.getWidth()){
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[2] = ISlots.get(i + j * 6);
                                System.out.println("add legs");
                            }

                            if(ISlots.get(i+j*6).getHeight()==golden_armor_foot.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==golden_armor_foot.getWidth()) {
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[3] = ISlots.get(i + j * 6);
                            }
                            if(ISlots.get(i+j*6).getHeight()==metal_armor_helemt.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==metal_armor_helemt.getWidth()) {
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[4] = ISlots.get(i + j * 6);
                                System.out.print("add helemt metal");
                            }
                            if(ISlots.get(i+j*6).getHeight()==metal_armor_chest.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==metal_armor_chest.getWidth()) {
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[5] = ISlots.get(i + j * 6);
                                System.out.print("add chest metal");
                            }
                            if(ISlots.get(i+j*6).getHeight()==metal_armor_leg.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==metal_armor_leg.getWidth()) {
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[6] = ISlots.get(i + j * 6);
                            }
                            if(ISlots.get(i+j*6).getHeight()==metal_armor_feet.getHeight()&&
                                    ISlots.get(i+j*6).getWidth()==metal_armor_feet.getWidth()) {
                                Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                Move_Texture[7] = ISlots.get(i + j * 6);
                            }

                            if(Move_Texture[0]!=null)if(Move_Texture[0].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[0].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                Helemt_Texture_gold = true;
                                Helemt_Texture_metal=false;
                                changing_placeT[0] = false;
                                System.out.println("Helemt2123132");
                            }
                            if(Move_Texture[1]!=null)if(Move_Texture[1].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[1].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                Chest_Texture_gold = true;
                                Chest_Texture_metal=false;
                                changing_placeT[1] = false;
                                System.out.println("Chest312321213321");
                            }
                            if(Move_Texture[2]!=null)if(Move_Texture[2].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[2].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                legs_Texture_gold = true;
                                changing_placeT[2] = false;
                                System.out.println("legs12123312321");
                            }

                            if(Move_Texture[3]!=null)if(Move_Texture[3].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[3].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                foot_Texture_gold = true;
                                changing_placeT[3] = false;
                            }
                            if(Move_Texture[4]!=null)if(Move_Texture[4].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[4].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                Helemt_Texture_metal = true;
                                changing_placeT[4] = false;
                                System.out.println("add helemt1 metal");
                            }
                            if(Move_Texture[5]!=null)if(Move_Texture[5].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[5].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                Chest_Texture_metal = true;
                                changing_placeT[5] = false;
                                System.out.println("chestmetal12123312321");
                            }
                            if(Move_Texture[6]!=null)if(Move_Texture[6].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[6].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                legs_Texture_metal = true;
                                changing_placeT[6] = false;
                            }
                            if(Move_Texture[7]!=null)if(Move_Texture[7].getHeight()==ISlots.get(i+j*6).getHeight()
                                    &&Move_Texture[7].getWidth()==ISlots.get(i+j*6).getWidth()) {
                                foot_Texture_metal = true;
                                changing_placeT[7] = false;
                            }

                        }

                        if(Old_Extrainvertoy_X.size>0)
                            for(int mmm=0;mmm<Old_Extrainvertoy_X.size;mmm++) {
                                if (Old_Extrainvertoy_X.get(mmm) == SlotSpace_X[i] && Old_Extrainvertoy_Y.get(mmm) == SlotSpace_Y[j]) {
                                    if (Move_Texture[0] == null && ISlots.get(i + j * 6).getHeight( ) == golden_armour.getHeight( ) &&
                                            ISlots.get(i + j * 6).getWidth( ) == golden_armour.getWidth( )) {
                                        Move_Texture[0] = ISlots.get(i + j * 6);
                                        Helemt_Texture_gold = true;
                                        slected_Equip = true;
                                        changing_placeT[0] = false;
                                        System.out.println("What");
                                    }
                                    if(Move_Texture[1]==null&&ISlots.get(i+j*6).getHeight()==golden_armour_chest.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==golden_armour_chest.getWidth()){
                                        Move_Texture[1]=ISlots.get(i+j*6);
                                        Chest_Texture_gold =true;
                                        slected_Equip =true;
                                        changing_placeT[1]=false;
                                    }
                                    if(Move_Texture[2]==null&&ISlots.get(i+j*6).getHeight()==golden_armour_leg.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==golden_armour_leg.getWidth()){
                                        Move_Texture[2]=ISlots.get(i+j*6);
                                        legs_Texture_gold =true;
                                        slected_Equip =true;
                                        changing_placeT[2]=false;
                                        System.out.println("legs");
                                    }

                                    if(Move_Texture[3]==null&&ISlots.get(i+j*6).getHeight()==golden_armor_foot.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==golden_armor_foot.getWidth()){
                                        Move_Texture[3]=ISlots.get(i+j*6);
                                        foot_Texture_gold =true;
                                        slected_Equip =true;
                                        changing_placeT[3]=false;
                                    }
                                    if(Move_Texture[4]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_helemt.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==metal_armor_helemt.getWidth()){
                                        Move_Texture[4]=ISlots.get(i+j*6);
                                        Helemt_Texture_metal =true;
                                        slected_Equip =true;
                                        changing_placeT[4]=false;
                                        System.out.print("add helemt2 metal");
                                    }
                                    if(Move_Texture[5]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_chest.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==metal_armor_chest.getWidth()){
                                        Move_Texture[5]=ISlots.get(i+j*6);
                                        Chest_Texture_metal =true;
                                        slected_Equip =true;
                                        changing_placeT[5]=false;
                                    }
                                    if(Move_Texture[6]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_leg.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==metal_armor_leg.getWidth()){
                                        Move_Texture[6]=ISlots.get(i+j*6);
                                        legs_Texture_metal =true;
                                        slected_Equip =true;
                                        changing_placeT[6]=false;
                                    }
                                    if(Move_Texture[7]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_feet.getHeight()&&
                                            ISlots.get(i+j*6).getWidth()==metal_armor_feet.getWidth()){
                                        Move_Texture[7]=ISlots.get(i+j*6);
                                        foot_Texture_metal =true;
                                        slected_Equip =true;
                                        changing_placeT[7]=false;
                                    }

                                }
                                if(Move_Texture[0]==null&&ISlots.get(i+j*6).getHeight()==golden_armour.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==golden_armour.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[0]=ISlots.get(i+j*6);
                                    Helemt_Texture_gold =true;
                                    slected_Equip =true;
                                    changing_placeT[0]=false;
                                    System.out.println("helemt");
                                }
                                if(Move_Texture[1]==null&&ISlots.get(i+j*6).getHeight()==golden_armour_chest.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==golden_armour_chest.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[1]=ISlots.get(i+j*6);
                                    Chest_Texture_gold =true;
                                    slected_Equip =true;
                                    changing_placeT[1]=false;
                                    System.out.println("chest");
                                }
                                if(Move_Texture[2]==null&&ISlots.get(i+j*6).getHeight()==golden_armour_leg.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==golden_armour_leg.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[2]=ISlots.get(i+j*6);
                                    legs_Texture_gold =true;
                                    slected_Equip =true;
                                    changing_placeT[2]=false;
                                    System.out.println("legs");
                                }

                                if(Move_Texture[3]==null&&ISlots.get(i+j*6).getHeight()==golden_armor_foot.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==golden_armor_foot.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[3]=ISlots.get(i+j*6);
                                    foot_Texture_gold =true;
                                    slected_Equip =true;
                                    changing_placeT[3]=false;
                                    System.out.println("NANI?");
                                }
                                if(Move_Texture[4]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_helemt.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==metal_armor_helemt.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[4]=ISlots.get(i+j*6);
                                    Helemt_Texture_metal =true;
                                    slected_Equip =true;
                                    changing_placeT[4]=false;
                                    System.out.println("add helemt3 metal");
                                }
                                if(Move_Texture[5]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_chest.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==metal_armor_chest.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[5]=ISlots.get(i+j*6);
                                    Chest_Texture_metal =true;
                                    slected_Equip =true;
                                    changing_placeT[5]=false;
                                    System.out.println("NANI?");
                                }
                                if(Move_Texture[6]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_leg.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==metal_armor_leg.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[6]=ISlots.get(i+j*6);
                                    legs_Texture_metal =true;
                                    slected_Equip =true;
                                    changing_placeT[6]=false;
                                    System.out.println("NANI?");
                                }
                                if(Move_Texture[7]==null&&ISlots.get(i+j*6).getHeight()==metal_armor_feet.getHeight()&&
                                        ISlots.get(i+j*6).getWidth()==metal_armor_feet.getWidth()){
                                    Old_Extrainvertoy_X.add(SlotSpace_X[i]);
                                    Old_Extrainvertoy_Y.add(SlotSpace_Y[j]);
                                    Move_Texture[7]=ISlots.get(i+j*6);
                                    foot_Texture_metal =true;
                                    slected_Equip =true;
                                    changing_placeT[7]=false;
                                    System.out.println("NANI?");
                                }

                            }
                        if(extraISlots.get(i+j*6)!=null) {
                            if (Move_Texture[7] != null && extraISlots.get(i+j*6).getHeight()==metal_armor_feet.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==metal_armor_feet.getWidth()) {
                                foot_Texture_metal = true;
                                slected_Equip = true;
                                changing_placeT[7] = false;
                                Change_T = false;
                            }
                            if (Move_Texture[6] != null && extraISlots.get(i+j*6).getHeight()==metal_armor_leg.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==metal_armor_leg.getWidth()) {
                                legs_Texture_metal = true;
                                slected_Equip = true;
                                changing_placeT[6] = false;
                                Change_T = false;
                            }
                            if (Move_Texture[5] != null && extraISlots.get(i+j*6).getHeight()==metal_armor_chest.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==metal_armor_chest.getWidth()) {
                                Chest_Texture_metal = true;
                                slected_Equip = true;
                                changing_placeT[5] = false;
                                Change_T = false;
                            }
                            if (Move_Texture[4] != null && extraISlots.get(i+j*6).getHeight()==metal_armor_helemt.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==metal_armor_helemt.getWidth()) {
                                Helemt_Texture_metal = true;
                                slected_Equip = true;
                                changing_placeT[4] = false;
                                Change_T = false;
                            }
                            if (Move_Texture[3] != null && extraISlots.get(i+j*6).getHeight()==golden_armor_foot.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==golden_armor_foot.getWidth()) {
                                foot_Texture_gold = true;
                                slected_Equip = true;
                                changing_placeT[3] = false;
                                Change_T = false;
                            }

                            if (Move_Texture[2] != null && extraISlots.get(i+j*6).getHeight()==golden_armour_leg.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==golden_armour_leg.getWidth()) {
                                legs_Texture_gold = true;
                                slected_Equip = true;
                                changing_placeT[2] = false;
                                Change_T = false;
                            }
                            if (Move_Texture[1] != null && extraISlots.get(i+j*6).getHeight()==golden_armour_chest.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==golden_armour_chest.getWidth()) {
                                Chest_Texture_gold = true;
                                slected_Equip = true;
                                changing_placeT[1] = false;
                                Change_T = false;

                            }
                            if (Move_Texture[0] != null && extraISlots.get(i+j*6).getHeight()==golden_armour.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()==golden_armour.getWidth()) {
                                Helemt_Texture_gold = true;
                                slected_Equip = true;
                                changing_placeT[0] = false;
                                Change_T = false;
                            } else if (!changing_placeT[0] && !changing_placeT[1] &&!changing_placeT[2]&&!changing_placeT[3]&&!changing_placeT[4]&&!changing_placeT[5]&&!changing_placeT[6]&&!changing_placeT[7]
                                    && (Move_Texture[0] != null || Move_Texture[1] != null|| Move_Texture[2] != null|| Move_Texture[3] != null
                                    || Move_Texture[3] != null|| Move_Texture[5] != null|| Move_Texture[6] != null|| Move_Texture[7] != null)
                                    && (extraISlots.get(i+j*6).getHeight()!=golden_armour.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=golden_armour.getWidth() && extraISlots.get(i+j*6).getHeight()!=golden_armour_chest.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=golden_armour_chest.getWidth()&& extraISlots.get(i+j*6).getHeight()!=golden_armour_leg.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=golden_armour_leg.getWidth()&& extraISlots.get(i+j*6).getHeight()!=golden_armor_foot.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=golden_armor_foot.getWidth()&& extraISlots.get(i+j*6).getHeight()!=metal_armor_helemt.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=metal_armor_helemt.getWidth()&& extraISlots.get(i+j*6).getHeight()!=metal_armor_chest.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=metal_armor_chest.getWidth()&& extraISlots.get(i+j*6).getHeight()!=metal_armor_leg.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=metal_armor_leg.getWidth()&& extraISlots.get(i+j*6).getHeight()!=metal_armor_feet.getHeight()&&
                                    extraISlots.get(i+j*6).getWidth()!=metal_armor_feet.getWidth())) {
                                Helemt_Texture_gold = false;
                                Chest_Texture_gold = false;
                                legs_Texture_gold=false;
                                foot_Texture_gold=false;
                                Helemt_Texture_metal=false;
                                Chest_Texture_metal=false;
                                legs_Texture_metal=false;
                                foot_Texture_metal=false;

                                System.out.println("Nah");
                            }
                        }
                        System.out.println("First Click"+Helemt_Texture_metal+Helemt_Texture_gold);
                    }
                }
            }

        for(int j=0;j<Equip_Slot_Y.length;j++)
            for(int i=0;i<Equip_Slot_X.length;i++){
                if(Gdx.input.getX()>=Equip_Slot_X[i]&&Gdx.input.getX()<=(Equip_Slot_X[i]+40)&&Gdx.input.getY()>=(h-Equip_Slot_Y[j]-50)&&Gdx.input.getY()<=(h-Equip_Slot_Y[j])){
                    System.out.println("True   "+i+"  "+j+"  ");
                    if (New_Extrainvertoy_X[0] == Equip_Slot_X[i] && New_Extrainvertoy_Y[0] == Equip_Slot_Y[j]) {
                        slected_UnEquip_X[0]=true;
                        slected_UnEquip_Y[0]=true;
                        slected_UnEquip_X[1]=false;
                        slected_UnEquip_Y[1]=false;
                        slected_UnEquip_X[2]=false;
                        slected_UnEquip_Y[2]=false;
                        slected_UnEquip_X[3]=false;
                        slected_UnEquip_Y[3]=false;
                        System.out.println(slected_UnEquip_X[0] + "  " +
                                slected_UnEquip_X[1] + " " +
                                slected_UnEquip_X[2] + "  " + slected_UnEquip_X[3]+ " "+slected_UnEquip_Y[0] + "  "+
                                slected_UnEquip_Y[1] + "  "+slected_UnEquip_Y[2] + "  "+slected_UnEquip_Y[3]);
                    }
                    if (New_Extrainvertoy_X[1] == Equip_Slot_X[i] && New_Extrainvertoy_Y[1] == Equip_Slot_Y[j]) {
                        slected_UnEquip_X[0]=false;
                        slected_UnEquip_Y[0]=false;
                        slected_UnEquip_X[1]=true;
                        slected_UnEquip_Y[1]=true;
                        slected_UnEquip_X[2]=false;
                        slected_UnEquip_Y[2]=false;
                        slected_UnEquip_X[3]=false;
                        slected_UnEquip_Y[3]=false;
                        System.out.println(slected_UnEquip_X[0] + "  " +
                                slected_UnEquip_X[1] + " " +
                                slected_UnEquip_X[2] + "  " + slected_UnEquip_X[3]+ " "+slected_UnEquip_Y[0] + "  "+
                                slected_UnEquip_Y[1] + "  "+slected_UnEquip_Y[2] + "  "+slected_UnEquip_Y[3]);
                    }
                    if (New_Extrainvertoy_X[2] == Equip_Slot_X[i] && New_Extrainvertoy_Y[2] == Equip_Slot_Y[j]) {
                        slected_UnEquip_X[0]=false;
                        slected_UnEquip_Y[0]=false;
                        slected_UnEquip_X[1]=false;
                        slected_UnEquip_Y[1]=false;
                        slected_UnEquip_X[2]=true;
                        slected_UnEquip_Y[2]=true;
                        slected_UnEquip_X[3]=false;
                        slected_UnEquip_Y[3]=false;
                        System.out.println(slected_UnEquip_X[0] + "  " +
                                slected_UnEquip_X[1] + " " +
                                slected_UnEquip_X[2] + "  " + slected_UnEquip_X[3]+ " "+slected_UnEquip_Y[0] + "  "+
                                slected_UnEquip_Y[1] + "  "+slected_UnEquip_Y[2] + "  "+slected_UnEquip_Y[3]);
                    }
                    if (New_Extrainvertoy_X[3] == Equip_Slot_X[i] && New_Extrainvertoy_Y[3] == Equip_Slot_Y[j]) {
                        slected_UnEquip_X[0]=false;
                        slected_UnEquip_Y[0]=false;
                        slected_UnEquip_X[1]=false;
                        slected_UnEquip_Y[1]=false;
                        slected_UnEquip_X[2]=false;
                        slected_UnEquip_Y[2]=false;
                        slected_UnEquip_X[3]=true;
                        slected_UnEquip_Y[3]=true;
                        System.out.println(slected_UnEquip_X[0] + "  " +
                                slected_UnEquip_X[1] + " " +
                                slected_UnEquip_X[2] + "  " + slected_UnEquip_X[3]+ " "+slected_UnEquip_Y[0] + "  "+
                                slected_UnEquip_Y[1] + "  "+slected_UnEquip_Y[2] + "  "+slected_UnEquip_Y[3]);
                    }
                }
            }

        for(int j=0;j<Equip_Slot_Y_Down.length;j++)
            for(int i=0;i<Equip_Slot_X_Down.length;i++){
                if(Gdx.input.getX()>=Equip_Slot_X_Down[i]&&Gdx.input.getX()<=(Equip_Slot_X_Down[i]+40)&&Gdx.input.getY()>=(h-Equip_Slot_Y_Down[j]-50)&&Gdx.input.getY()<=(h-Equip_Slot_Y_Down[j])){
                    System.out.println("True   "+i+"  "+j+"  ");
                }
            }
    }
    private void extrainvertoychange() {
        ItemsCollect[0] = getrat_items;
        ItemsCollect[1] = getsheep_meat;
        ItemsCollect[2] = getwood_items1 * 4;
        ItemsCollect[3] = getstone_items1 * 4;
        ItemsCollect[4] = getfish_items;
        if(onetime_Work){
            onetime_Work=false;
            for(int mmm=0;mmm<ISlots.size;mmm++){
                if(extraISlots.size<8)
                    extraISlots.add(ISlots.get(mmm));
            }
        }
        for(int m1=0;m1<Move_Texture.length;m1++)
            for (int mmm = 0; mmm < extraISlots.size; mmm++) {
                if(Move_Texture[m1]!=null&&extraISlots.get(mmm)!=null) {
                    if (Move_Texture[m1].getHeight()==golden_armour.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armour.getWidth()
                            && changing_placeT[0]
                            && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }
                    if (Move_Texture[m1].getHeight()==golden_armour_chest.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armour_chest.getWidth() && changing_placeT[1] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }
                    if (Move_Texture[m1].getHeight()==golden_armour_leg.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armour_leg.getWidth() && changing_placeT[2] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }

                    if (Move_Texture[m1].getHeight()==golden_armor_foot.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armor_foot.getWidth() && changing_placeT[3] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }
                    if (Move_Texture[m1].getHeight()==metal_armor_helemt.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_helemt.getWidth() && changing_placeT[4] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }
                    if (Move_Texture[m1].getHeight()==metal_armor_chest.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_chest.getWidth() && changing_placeT[5] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }
                    if (Move_Texture[m1].getHeight()==metal_armor_leg.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_leg.getWidth() && changing_placeT[6] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }
                    if (Move_Texture[m1].getHeight()==metal_armor_feet.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_feet.getWidth() && changing_placeT[7] && ISlots.get(mmm).getHeight( ) != Move_Texture[m1].getHeight( )) {
                        if (mmm <= 5)
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > 5 && mmm <= (11))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (11) && mmm <= (17))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (17) && mmm <= (23))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                        if (mmm > (23) && mmm <= (29))
                            batch.draw(extraISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    }

                }
                if(Move_Texture[m1]==null&&!changing_placeT[0]&&!changing_placeT[1]&&!changing_placeT[2]&&!changing_placeT[3]&&!changing_placeT[4]&&!changing_placeT[5]&&!changing_placeT[6]&&!changing_placeT[7]) {
                    if(mmm<6)
                        batch.draw(ISlots.get(mmm), SlotSpace_X[mmm] + 4, SlotSpace_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    if (mmm > 5 && mmm <= (11))
                        batch.draw(ISlots.get(mmm), SlotSpace_X[mmm - 6] + 4, SlotSpace_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    if (mmm > (11) && mmm <= (17))
                        batch.draw(ISlots.get(mmm), SlotSpace_X[mmm - 12] + 4, SlotSpace_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    if (mmm > (17) && mmm <= (23))
                        batch.draw(ISlots.get(mmm), SlotSpace_X[mmm - 18] + 4, SlotSpace_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                    if (mmm > (23) && mmm <= (29))
                        batch.draw(ISlots.get(mmm), SlotSpace_X[mmm - 24] + 4, SlotSpace_Y[4] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);
                }
            }
        for (int mmm = 0; mmm < extraISlots.size && !first; mmm++) {
            if (ItemsCollect[0] > 0 && ItemsCollect[0] < 10&&extraISlots.get(mmm)!=null) {
                if (extraISlots.get(mmm).getHeight() == (rat_meat).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm] + 24, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 6] + 24, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 12] + 24, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 18] + 24, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 24] + 24, SlotSpace_Y[4] + 35);
                }
            }
            if (ItemsCollect[0] >= 10&&extraISlots.get(mmm)!=null) {
                if (extraISlots.get(mmm).getHeight() == (rat_meat).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm] + 20, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 6] + 20, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 12] + 20, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 18] + 20, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[0], SlotSpace_X[mmm - 24] + 20, SlotSpace_Y[4] + 35);
                }
            }

            if (ItemsCollect[1] > 0 && ItemsCollect[1] < 10&&extraISlots.get(mmm)!=null) {
                if (extraISlots.get(mmm).getHeight() == (sheep_meat).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm] + 24, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 6] + 24, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 12] + 24, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 18] + 24, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 24] + 24, SlotSpace_Y[4] + 35);
                }
            }

            if (ItemsCollect[1] >= 10&&extraISlots.get(mmm)!=null) {
                if (extraISlots.get(mmm).getHeight() == (sheep_meat).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm] + 20, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 6] + 20, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 12] + 20, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 18] + 20, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[1], SlotSpace_X[mmm - 24] + 20, SlotSpace_Y[4] + 35);
                }
            }
            if (ItemsCollect[2] > 0 && ItemsCollect[2] < 10) {
                if (ISlots.get(mmm).getHeight() == (woodT).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm] + 24, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 6] + 24, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 12] + 24, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 18] + 24, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 24] + 24, SlotSpace_Y[4] + 35);
                }
            }
            if (ItemsCollect[2] >= 10) {
                if (ISlots.get(mmm).getHeight() == (woodT).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm] + 20, SlotSpace_Y[0] + 8);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 6] + 20, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 12] + 20, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 18] + 20, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[2], SlotSpace_X[mmm - 24] + 20, SlotSpace_Y[4] + 35);
                }
            }

            if (ItemsCollect[3] > 0 && ItemsCollect[3] < 10) {
                if (ISlots.get(mmm).getHeight() == (rockT).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm] + 24, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 6] + 24, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 12] + 24, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 18] + 24, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 24] + 24, SlotSpace_Y[4] + 35);
                }
            }
            if (ItemsCollect[3] >= 10) {
                if (ISlots.get(mmm).getHeight() == (rockT).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm] + 20, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 6] + 20, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 12] + 20, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 18] + 20, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[3], SlotSpace_X[mmm - 24] + 20, SlotSpace_Y[4] + 35);
                }
            }

            if (ItemsCollect[4] > 0 && ItemsCollect[4] < 10)
                if (ISlots.get(mmm).getHeight() == (FishT).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm] + 24, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 6] + 24, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 12] + 24, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 18] + 24, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 24] + 24, SlotSpace_Y[4] + 35);
                }
            if (ItemsCollect[4] >= 10)
                if (ISlots.get(mmm).getHeight() == (FishT).getHeight()) {
                    if (mmm <= 5)
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm] + 20, SlotSpace_Y[0] + 35);
                    if (mmm > 5 && mmm <= (11))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 6] + 20, SlotSpace_Y[1] + 35);
                    if (mmm > (11) && mmm <= (17))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 12] + 20, SlotSpace_Y[2] + 35);
                    if (mmm > (17) && mmm <= (23))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 18] + 20, SlotSpace_Y[3] + 35);
                    if (mmm > (23) && mmm <= (29))
                        font3.draw(batch, "" + ItemsCollect[4], SlotSpace_X[mmm - 24] + 20, SlotSpace_Y[4] + 35);
                }
            if (ISlots.size != 0 && !(mmm < 0))
                if (ISlots.get(mmm) != null)
                    if (ISlots.get(mmm).getHeight() == (rat_meat).getHeight())
                        if (ItemsCollect[0] <= 0) {
                            ISlots.removeIndex(mmm);
                            mmm -= 1;
                        }
            if (ISlots.size != 0 && !(mmm < 0))
                if (ISlots.get(mmm) != null)
                    if (ISlots.get(mmm).getHeight() == (FishT).getHeight())
                        if (ItemsCollect[4] <= 0) {
                            ISlots.removeIndex(mmm);
                            mmm -= 1;
                        }
            if (ISlots.size != 0 && !(mmm < 0))
                if (ISlots.get(mmm) != null)
                    if (ISlots.get(mmm).getHeight() == (sheep_meat).getHeight())
                        if (ItemsCollect[1] <= 0) {
                            ISlots.removeIndex(mmm);
                            mmm -= 1;
                        }
        }
        for (int m1 = 0; m1 < Move_Texture.length; m1++) {
            if(changing_placeT[m1]) {
                if (Move_Texture[m1] != null) {
                    if (Move_Texture[m1].getHeight()==golden_armour.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armour.getWidth() && Helemt_Texture_gold)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[0] + 4, New_Extrainvertoy_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                    if (Move_Texture[m1].getHeight()==golden_armour_chest.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armour_chest.getWidth() && Chest_Texture_gold)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[1] + 4, New_Extrainvertoy_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                    if (Move_Texture[m1].getHeight()==golden_armour_leg.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armour_leg.getWidth() && legs_Texture_gold)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[2] + 4, New_Extrainvertoy_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                    if (Move_Texture[m1].getHeight()==golden_armor_foot.getHeight()&&
                            Move_Texture[m1].getWidth()==golden_armor_foot.getWidth() && foot_Texture_gold)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[3] + 4, New_Extrainvertoy_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);


                    if (Move_Texture[m1].getHeight()==metal_armor_helemt.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_helemt.getWidth() && Helemt_Texture_metal)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[0] + 4, New_Extrainvertoy_Y[0] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                    if (Move_Texture[m1].getHeight()==metal_armor_chest.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_chest.getWidth() && Chest_Texture_metal)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[1] + 4, New_Extrainvertoy_Y[1] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                    if (Move_Texture[m1].getHeight()==metal_armor_leg.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_leg.getWidth() && legs_Texture_metal)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[2] + 4, New_Extrainvertoy_Y[2] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                    if (Move_Texture[m1].getHeight()==metal_armor_feet.getHeight()&&
                            Move_Texture[m1].getWidth()==metal_armor_feet.getWidth() && foot_Texture_metal)
                        batch.draw(Move_Texture[m1], New_Extrainvertoy_X[3] + 4, New_Extrainvertoy_Y[3] + 8, Invertoy.BOX_SIZE_width_part / 20, Invertoy.BOX_SIZE_hight_part / 20);

                }
            }
        }
    }
    private void outsidetoclose() {
        if(Gdx.input.getX()<=30||Gdx.input.getX()>=w-30||Gdx.input.getY()<30||Gdx.input.getY()>(h-30)) {
            MODE_RIGHTNOW = 0;
            camera.setToOrtho(false, w / 2, h / 2);
            camera.update( );
            onetime_Work=true;
        }
    }
    private void drawBuildItems() {
        batch.draw(BuildISlots.get(0),SlotBuildSpace_X[0]+5,SlotBuildSpace_Y[0]+10,30*ascept_width,30*ascept_height);
        batch.draw(BuildISlots.get(1),SlotBuildSpace_X[1]+5,SlotBuildSpace_Y[0]+10,30*ascept_width,30*ascept_height);
        batch.draw(BuildISlots.get(2),SlotBuildSpace_X[2]+5,SlotBuildSpace_Y[0]+10,30*ascept_width,30*ascept_height);
        batch.draw(BuildISlots.get(3),SlotBuildSpace_X[3]+5,SlotBuildSpace_Y[0]+10,30*ascept_width,30*ascept_height);
        batch.draw(BuildISlots.get(4),SlotBuildSpace_X[4]+5,SlotBuildSpace_Y[0]+10,30*ascept_width,30*ascept_height);
        batch.draw(BuildISlots.get(5),SlotBuildSpace_X[5]+5,SlotBuildSpace_Y[0]+10,30*ascept_width,30*ascept_height);
        batch.draw(BuildISlots.get(6), SlotBuildSpace_X[0]+5, SlotBuildSpace_Y[1] + 10, 30*ascept_width, 30*ascept_height);
        batch.draw(BuildISlots.get(7), SlotBuildSpace_X[1]+5, SlotBuildSpace_Y[1] + 10, 30*ascept_width, 30*ascept_height);
        batch.draw(BuildISlots.get(8), SlotBuildSpace_X[2]+5, SlotBuildSpace_Y[1] + 10, 30*ascept_width, 30*ascept_height);
        batch.draw(BuildISlots.get(9), SlotBuildSpace_X[3]+5, SlotBuildSpace_Y[1] + 10, 30*ascept_width, 30*ascept_height);
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
            batch.draw(rockT, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+5,125,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Stone", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[1]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(rockT, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+10,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Stone", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[2]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Gold_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+5,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Gold_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[3]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Gold_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+6,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Gold_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[4]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Gold_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+4,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Gold_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[5]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Gold_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+2,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Gold_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[6]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Iron_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+5,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Iron_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[7]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Iron_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+6,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Iron_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[8]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Iron_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+4,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Iron_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
        if(WhichInfo[9]==1){
            batch.draw(Slot_Space, 100, SlotBuildSpace_Y[0], 40, 50);
            batch.draw(Iron_ingot, 105, SlotBuildSpace_Y[0] + 10, 30, 30);
            font.draw(batch,""+2,120,SlotBuildSpace_Y[0]+40);
            font4.draw(batch, "Iron_ingot", 150, SlotBuildSpace_Y[0] + 25);
            Info_texture=null;
        }
    }
    private void ExitWay() {
        if(Gdx.input.getX()<30||Gdx.input.getX()>(w-30)||Gdx.input.getY()<30||Gdx.input.getY()>(h-30)){
            MODE_RIGHTNOW=0;
            onetime_Work=true;
            camera.setToOrtho(false,w/2,h/2);
            camera.update();
        }
    }
    private void armour_checker() {
        //Helemt
        //Chest
        //legs
        //foot
        batch.draw(inmark,player1.getPosition().x+Gdx.graphics.getWidth()/6-60,player1.getPosition().y+Gdx.graphics.getHeight()/6,50*ascept_width,20*ascept_height);
        if(!Helemt_Texture_metal&&!Chest_Texture_metal&&!foot_Texture_metal&&!legs_Texture_metal) {
            if (Helemt_Texture_gold && Chest_Texture_gold && legs_Texture_gold && foot_Texture_gold) {
                // all of gold
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_allgold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_allgold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_allgold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_allgold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_gold/Stopallgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
            if (Helemt_Texture_gold) {
                if (Chest_Texture_gold && legs_Texture_gold && !foot_Texture_gold) {
                    //helemt+chest+legs
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stophelemtchestlegsgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (Chest_Texture_gold && foot_Texture_gold && !legs_Texture_gold) {
                    //helemt+chest+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stophelemtchestfootgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (legs_Texture_gold && foot_Texture_gold && !Chest_Texture_gold) {
                    //helemt+legs+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stophelemtlegsfootgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (Chest_Texture_gold && !legs_Texture_gold && !foot_Texture_gold) {
                    //helemt+chest
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_chest_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_chest_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_chest_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_chest_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/Stophelemtchestgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                }
                if (legs_Texture_gold && !Chest_Texture_gold && !foot_Texture_gold) {
                    //helemt+legs
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/Stophelemtlegsgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                }
                if (foot_Texture_gold && !legs_Texture_gold && !Chest_Texture_gold) {
                    //helemt+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/Stophelemtfootgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                }
            }
            //Chest
            //legs
            //foot
            if (!Helemt_Texture_gold && Chest_Texture_gold) {
                if (legs_Texture_gold && foot_Texture_gold) {
                    //Chest+legs+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Chest_legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Chest_legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Chest_legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Chest_legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stopchestlegsfootgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (legs_Texture_gold && !foot_Texture_gold) {
                    //Chest+legs
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Chest_legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/Stopchestlegsgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                }
                if (foot_Texture_gold && !legs_Texture_gold) {
                    //Chest+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Chest_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/Stopchestfootgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
            }
            //legs
            //foot
            if (!Helemt_Texture_gold && !Chest_Texture_gold && legs_Texture_gold) {
                if (foot_Texture_gold) {
                    //legs+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Legs_foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/Stoplegsfootgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
            }
            //only one of them
            //Helemt
            //Chest
            //legs
            //foot
            if (Helemt_Texture_gold && !Chest_Texture_gold && !legs_Texture_gold && !foot_Texture_gold) {
                //helemt only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Helemt_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Helemt_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Helemt_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Helemt_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_gold/Stophelemtgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);


            }
            if (!Helemt_Texture_gold && Chest_Texture_gold && !legs_Texture_gold && !foot_Texture_gold) {
                //chest only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Chest_gold_down.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Chest_gold_down.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Chest_gold_down.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Chest_gold_down.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_gold/Stopchestgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);


            }
            if (!Helemt_Texture_gold && !Chest_Texture_gold && legs_Texture_gold && !foot_Texture_gold) {
                //legs only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Legs_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_gold/Stoplegsgold.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
            if (!Helemt_Texture_gold && !Chest_Texture_gold && !legs_Texture_gold && foot_Texture_gold) {
                //foot only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Foot_gold.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/stop.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
        }

        //metal only *****
        //Helemt
        //Chest
        //legs
        //foot
        if(!Helemt_Texture_gold&&!Chest_Texture_gold&&!foot_Texture_gold&&!legs_Texture_gold) {
            if (Helemt_Texture_metal && Chest_Texture_metal && legs_Texture_metal && foot_Texture_metal) {
                // all of metal
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_allMetal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_allMetal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_allMetal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_allMetal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_metal/Stopallmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
            if (Helemt_Texture_metal) {
                if (Chest_Texture_metal && legs_Texture_metal && !foot_Texture_metal) {
                    //helemt+chest+legs
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stophelemtchestlegsmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);


                }
                if (Chest_Texture_metal && foot_Texture_metal && !legs_Texture_metal) {
                    //helemt+chest+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stophelemtchestfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (legs_Texture_metal && foot_Texture_metal && !Chest_Texture_metal) {
                    //helemt+legs+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stophelemtlegsfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (Chest_Texture_metal && !legs_Texture_metal && !foot_Texture_metal) {
                    //helemt+chest
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_chest_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_chest_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_chest_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_chest_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_metal/Stophelemtchestmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (legs_Texture_metal && !Chest_Texture_metal && !foot_Texture_metal) {
                    //helemt+legs
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_metal/Stophelemtlegsmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (foot_Texture_metal && !legs_Texture_metal && !Chest_Texture_metal) {
                    //helemt+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Helemt_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Helemt_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Helemt_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Helemt_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_metal/Stophelemtfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
            }
            //Chest
            //legs
            //foot
            if (!Helemt_Texture_metal && Chest_Texture_metal) {
                if (legs_Texture_metal && foot_Texture_metal) {
                    //Chest+legs+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Chest_legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Chest_legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Chest_legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Chest_legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_gold/stopchestlegsfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (legs_Texture_metal && !foot_Texture_metal) {
                    //Chest+legs
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Chest_legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_metal/Stopchestlegsmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
                if (foot_Texture_metal && !legs_Texture_metal) {
                    //Chest+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Chest_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_metal/Stopchestfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
            }
            //legs
            //foot
            if (!Helemt_Texture_metal && !Chest_Texture_metal && legs_Texture_metal) {
                if (foot_Texture_metal) {
                    //legs+foot
                    if (myinputproccer.isRight( ))
                        batch.draw((TextureRegion) animationRight_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isLeft( ))
                        batch.draw((TextureRegion) animationLeft_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isUp( ))
                        batch.draw((TextureRegion) animationUp_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (myinputproccer.isDown( ))
                        batch.draw((TextureRegion) animationDown_Legs_foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                    if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                        batch.draw(new Texture("sprite_Sheets/Stop_metal/Stoplegsfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

                }
            }
            //only one of them
            //Helemt
            //Chest
            //legs
            //foot
            if (Helemt_Texture_metal && !Chest_Texture_metal && !legs_Texture_metal && !foot_Texture_metal) {
                //helemt only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Helemt_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Helemt_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Helemt_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Helemt_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_metal/Stophelemtmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
            if (!Helemt_Texture_metal && Chest_Texture_metal && !legs_Texture_metal && !foot_Texture_metal) {
                //chest only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Chest_metal_down.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Chest_metal_down.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Chest_metal_down.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Chest_metal_down.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_metal/Stopchestmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
            if (!Helemt_Texture_metal && !Chest_Texture_metal && legs_Texture_metal && !foot_Texture_metal) {
                //legs only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Legs_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_metal/Stoplegsmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
            if (!Helemt_Texture_metal && !Chest_Texture_metal && !legs_Texture_metal && foot_Texture_metal) {
                //foot only
                if (myinputproccer.isRight( ))
                    batch.draw((TextureRegion) animationRight_Foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isLeft( ))
                    batch.draw((TextureRegion) animationLeft_Foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isUp( ))
                    batch.draw((TextureRegion) animationUp_Foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (myinputproccer.isDown( ))
                    batch.draw((TextureRegion) animationDown_Foot_metal.getKeyFrame(timeloop4, true), m - atlasRight_allMetal.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
                if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                    batch.draw(new Texture("sprite_Sheets/Stop_metal/Stopfootmetal.png"), m - atlasRight_allgold.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasRight_allgold.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

            }
        }
        //nothing Here
        if(!Helemt_Texture_metal&&!Chest_Texture_metal&&!legs_Texture_metal&&!foot_Texture_metal&&
                !Helemt_Texture_gold&&!Chest_Texture_gold&&!legs_Texture_gold&&!foot_Texture_gold){
            if (myinputproccer.isRight( ))
                batch.draw((TextureRegion) animationright.getKeyFrame(timeloop4, true), m - atlasright.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasright.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
            if (myinputproccer.isLeft( ))
                batch.draw((TextureRegion) animationleft.getKeyFrame(timeloop4, true), m - atlasright.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasright.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
            if (myinputproccer.isUp( ))
                batch.draw((TextureRegion) aniamtionup.getKeyFrame(timeloop4, true), m - atlasright.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasright.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
            if (myinputproccer.isDown( ))
                batch.draw((TextureRegion) animationdown.getKeyFrame(timeloop4, true), m - atlasright.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasright.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);
            if (!myinputproccer.isDown( ) && !myinputproccer.isRight( ) && !myinputproccer.isUp( ) && !myinputproccer.isLeft( ))
                batch.draw(new Texture("sprite_Sheets/Stop_nothing.png"), m - atlasright.getTextures( ).first( ).getWidth( ) / PlayerSpace_x, k - atlasright.getTextures( ).first( ).getHeight( ) / PlayerSpace_Y, PlayerSize, PlayerSize);

        }
        //gold-metal(mix)
        //helemt
        //chest
        //legs
        //foot
        /* two part of mix
        helemt-foot
        helemt-legs
        helemt-chest
        chest-legs
        chest-foot
        legs-foot
         */
         /*three parts of mix
         helemt-chest-legs
         helemt-chest-foot
         helemt-legs-foot
         chest-legs-foot
          */
         /*four parts of mix some of them will have same armours
         helemt-foot(chest-legs)
        helemt-legs(chest-foot)
        helemt-chest(legs-foot)
        chest-legs(helemt-foot)
        chest-foot(helemt-legs)
        legs-foot(helemt-chest)
        helemt-chest-legs(foot)
         helemt-chest-foot(legs)
         helemt-legs-foot(chest)
         chest-legs-foot(helemt)
          */
    }
    private void reduce_hunger_rat() {
        hunger-=hunger_reduce;
        workhunger_rat=true;
        if(hunger<0)hunger=0;
        if (hunger==0){
            timeloop_hunger_rat+=Gdx.graphics.getRawDeltaTime();
            if(timeloop_hunger_rat>5)timeloop_hunger_rat=1;
            if(timeloop_hunger_rat/1==1) {
                Health -= 0.1;
                recover_Health=false;
                hunger_check+=1;
                timeloop_hunger_rat=0;
            }
            if(ItemsCollect[0]>1) {
                getrat_items -= 2;
                timeloop_hunger_rat=0;
                recover_Health=true;
                hunger=Hunger_still;
            }
        }
    }
    private void reduce_hunger_Sheep() {
        hunger-=hunger_reduce;
        workhunger_sheep=true;
        if(hunger<0)hunger=0;
        if (hunger==0){
            timeloop_hunger_Sheep+=Gdx.graphics.getRawDeltaTime();
            if(timeloop_hunger_Sheep>5)timeloop_hunger_Sheep=1;
            if(timeloop_hunger_Sheep/1==1) {
                Health -= 0.1;
                recover_Health=false;
                hunger_check+=1;
                timeloop_hunger_Sheep=0;
            }
            if(ItemsCollect[1]>0) {
                getsheep_meat -= 1;
                timeloop_hunger_Sheep=0;
                recover_Health=true;
                hunger=Hunger_still;
            }
        }
    }
    private void reduce_hunger_Fish() {
        hunger-=hunger_reduce;
        workhunger_fish=true;
        if(hunger<0){
            hunger=0;
        }
        if (hunger==0){
            timeloop_hunger_Fish+=Gdx.graphics.getRawDeltaTime();
            if(timeloop_hunger_Fish>5)timeloop_hunger_Fish=1;
            if(timeloop_hunger_Fish/1==1) {
                Health -= 0.1;
                recover_Health=false;
                hunger_check+=1;
                timeloop_hunger_Fish=0;
            }
            if(ItemsCollect[4]>3) {
                getfish_items -= 4;
                timeloop_hunger_Fish=0;
                recover_Health=true;
                hunger=Hunger_still;
            }
        }
    }
    private void timerooten_RAT() {
        timeloop_rooten_rat +=Gdx.graphics.getRawDeltaTime();
        if(timeloop_rooten_rat >60f) {
            timeloop_rooten_rat =0f;
            System.out.println("rooten_rat");
            if (ontimerooten.get(0)) getrat_items -= 1;
        }
    }
    private void timerooten_sheep() {
        timeloop_rooten_sheep+=Gdx.graphics.getRawDeltaTime();
        if(timeloop_rooten_sheep>60f) {
            timeloop_rooten_sheep=0f;
            System.out.println("rooten_sheep");
            if (ontimerooten.get(1)) getsheep_meat -= 1;
        }
    }
    private void timerooten_fish() {
        timeloop_rooten_fish+=Gdx.graphics.getRawDeltaTime();
        if(timeloop_rooten_fish>60f) {
            timeloop_rooten_fish=0f;
            System.out.println("rooten_fish");
            if (ontimerooten.get(2)) getfish_items -= 1;

        }
    }
    private void allChanged() {
        Skeleton_Height= PIXEL_PER_METER/2 ;
        Skeleton_Width=12;
        Skeleton_DOWN_X= PIXEL_PER_METER/8;
        Skeleton_DOWN_Y= PIXEL_PER_METER/10;
        Skeleton_UP_X= PIXEL_PER_METER/8;
        Skeleton_UP_Y= PIXEL_PER_METER/10;


        Golem_Width=12;
        Golem_Height= PIXEL_PER_METER/2;
        Golem_DOWN_X= PIXEL_PER_METER;
        Golem_DOWN_Y= PIXEL_PER_METER/3;
        Golem_UP_X= PIXEL_PER_METER;
        Golem_UP_Y= PIXEL_PER_METER/3;

        Golem_AttackDOWN_X= PIXEL_PER_METER;
        Golem_AttackDOWN_Y= PIXEL_PER_METER/3;
        Golem_AttackUp_X= PIXEL_PER_METER;
        Golem_AttackUp_Y= PIXEL_PER_METER/3;
        Golem_Width_Attack= PIXEL_PER_METER/4;
        Golem_Height_Attack= PIXEL_PER_METER/2;
        Golem_Width_died= PIXEL_PER_METER/2;
        Golem_Height_Died= PIXEL_PER_METER/2;



        Ghost_Height= PIXEL_PER_METER/3;
        Ghost_Width= PIXEL_PER_METER/3;
        Ghost_Height_Died= PIXEL_PER_METER/3;
        Ghost_Width_Died= PIXEL_PER_METER/3;
        Fireball_Height= PIXEL_PER_METER/3;
        Fireball_width= PIXEL_PER_METER/3;

        Stair_up_x=StairU.getWidth()/2;
        Stair_up_y=StairU.getHeight()/2;
        Stair_Down_x=StairD.getWidth()/2;
        Stair_Down_y=StairD.getHeight()/2;
        k = player1.getPosition( ).y;
        m = player1.getPosition( ).x;
        UP_control_x = PIXEL_PER_METER / 2;
        UP_control_y = PIXEL_PER_METER / 2;
        Down_control_y = PIXEL_PER_METER / 2;
        Down_control_x = PIXEL_PER_METER / 2;
        Right_control_x = PIXEL_PER_METER / 2;
        Right_control_y = PIXEL_PER_METER / 2;
        left_control_x = PIXEL_PER_METER / 2;
        left_control_y = PIXEL_PER_METER / 2;
        BAG_HEIGHT= PIXEL_PER_METER/3;
        BAG_WIDTH=PIXEL_PER_METER/4;
        up_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + ((15 + 20) * 1.95f)), 0);
        down_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2)), 0);
        left_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6 - 20 * 1.6f, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + 15 * 2.3f), 0);
        Right_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6 + 20 * 1.6f, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + 15 * 2.3f), 0);

    }

    private void ChangeScreenHoles() {
        dx = player1.getPosition().x - hole1.getPosition().x;
        dy = player1.getPosition().y - hole1.getPosition().y;
        length = Math.sqrt(dx * dx + dy * dy);
        if(length<0)length*=-1;

        dx2 = player1.getPosition().x - hole2.getPosition().x;
        dy2 = player1.getPosition().y - hole2.getPosition().y;
        length2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        if(length2<0)length2*=-1;

        dx3 = player1.getPosition().x - hole3.getPosition().x;
        dy3 = player1.getPosition().y - hole3.getPosition().y;
        length3 = Math.sqrt(dx3 * dx3 + dy3 * dy3);
        if(length3<0)length3*=-1;

        dx4 = player1.getPosition().x - hole4.getPosition().x;
        dy4 = player1.getPosition().y - hole4.getPosition().y;
        length4 = Math.sqrt(dx4 * dx4 + dy4 * dy4);
        if(length4<0)length4*=-1;

        dx5 = player1.getPosition().x - hole5.getPosition().x;
        dy5 = player1.getPosition().y - hole5.getPosition().y;
        length5 = Math.sqrt(dx5 * dx5 + dy5 * dy5);
        if(length5<0)length5*=-1;

        if(onhole1&&length>=0&&length<=10){
            random_mobs=new Random_mobs(FloorNUM+1);
            game.Dungeon_change(ISlots,random_mobs.Dungeon,FloorNUM+1,Dungeon_list,Health,Level,ItemsCollect,first, Hunger, ItemsCollect);
        }
        if(onhole2&&length2>=0&&length2<=10){
            random_mobs=new Random_mobs(FloorNUM+1);
            game.Dungeon_change(ISlots,random_mobs.Dungeon,FloorNUM+1,Dungeon_list,Health,Level,ItemsCollect,first, Hunger, ItemsCollect);
        }
        if(onhole3&&length3>=0&&length3<=10){
            random_mobs=new Random_mobs(FloorNUM+1);
            game.Dungeon_change(ISlots,random_mobs.Dungeon,FloorNUM+1,Dungeon_list,Health,Level,ItemsCollect,first, Hunger, ItemsCollect);
        }
        if(onhole4&&length4>=0&&length4<=10){
            random_mobs=new Random_mobs(FloorNUM+1);
            game.Dungeon_change(ISlots,random_mobs.Dungeon,FloorNUM+1,Dungeon_list,Health,Level,ItemsCollect,first, Hunger, ItemsCollect);
        }
        if(onhole5&&length5>=0&&length5<=10){
            random_mobs=new Random_mobs(FloorNUM+1);
            game.Dungeon_change(ISlots,random_mobs.Dungeon,FloorNUM+1,Dungeon_list,Health,Level,ItemsCollect,first, Hunger, ItemsCollect);
        }
    }

    private void checkstairs() {
        dx6 = player1.getPosition().x - Stair_Down.getPosition().x;
        dy6 = player1.getPosition().y - Stair_Down.getPosition().y;
        length6 = Math.sqrt(dx6 * dx6 + dy6 * dy6);
        if(length6<0)length6*=-1;

        dx7 = player1.getPosition().x - Stair_up.getPosition().x;
        dy7 = player1.getPosition().y - Stair_up.getPosition().y;
        length7 = Math.sqrt(dx7 * dx7 + dy7 * dy7);
        if(length7<0)length7*=-1;

        if(length6>=0&&length6<=25){
            //move to next floor
            random_mobs=new Random_mobs(FloorNUM+1);
            game.Dungeon_change(ISlots,random_mobs.Dungeon,FloorNUM+1,Dungeon_list,Health,Level,ItemsCollect,first, Hunger, ItemsCollect);
        }
        if(length7>=0&&length7<=25){
            game.setScreen(new Worldbegginerplace(ISlots, game, Health, Level, ItemsCollect, first, Hunger, Stats));
        }
    }

    private void Checkholes() {
        dx = player1.getPosition().x - hole1.getPosition().x;
        dy = player1.getPosition().y - hole1.getPosition().y;
        length = Math.sqrt(dx * dx + dy * dy);
        if(length<0)length*=-1;

        dx2 = player1.getPosition().x - hole2.getPosition().x;
        dy2 = player1.getPosition().y - hole2.getPosition().y;
        length2 = Math.sqrt(dx2 * dx2 + dy2 * dy2);
        if(length2<0)length2*=-1;

        dx3 = player1.getPosition().x - hole3.getPosition().x;
        dy3 = player1.getPosition().y - hole3.getPosition().y;
        length3 = Math.sqrt(dx3 * dx3 + dy3 * dy3);
        if(length3<0)length3*=-1;

        dx4 = player1.getPosition().x - hole4.getPosition().x;
        dy4 = player1.getPosition().y - hole4.getPosition().y;
        length4 = Math.sqrt(dx4 * dx4 + dy4 * dy4);
        if(length4<0)length4*=-1;

        dx5 = player1.getPosition().x - hole5.getPosition().x;
        dy5 = player1.getPosition().y - hole5.getPosition().y;
        length5 = Math.sqrt(dx5 * dx5 + dy5 * dy5);
        if(length5<0)length5*=-1;

        batch.begin();
        float Hole_y=holeT.getHeight()/2,Hole_X=holeT.getWidth()/2;
        if(length>=0&&length<=10&&myinputproccer.isHitenable()){
            onhole1=true;
            batch.draw(holeT,hole1.getPosition().x-Hole_X,hole1.getPosition().y-Hole_y);
        }
        if(onhole1)batch.draw(holeT,hole1.getPosition().x-Hole_X,hole1.getPosition().y-Hole_y);

        if(length2>=0&&length2<=10&&myinputproccer.isHitenable()){
            onhole2=true;
            batch.draw(holeT,hole2.getPosition().x-Hole_X,hole2.getPosition().y-Hole_y);
        }
        if(onhole2)batch.draw(holeT,hole2.getPosition().x-Hole_X,hole2.getPosition().y-Hole_y);

        if(length3>=0&&length3<=10&&myinputproccer.isHitenable()){
            onhole3=true;
            batch.draw(holeT,hole3.getPosition().x-Hole_X,hole3.getPosition().y-Hole_y);
        }
        if(onhole3)batch.draw(holeT,hole3.getPosition().x-Hole_X,hole3.getPosition().y-Hole_y);

        if(length4>=0&&length4<=10&&myinputproccer.isHitenable()){
            onhole4=true;
            batch.draw(holeT,hole4.getPosition().x-Hole_X,hole4.getPosition().y-Hole_y);
        }
        if(onhole4)batch.draw(holeT,hole4.getPosition().x-Hole_X,hole4.getPosition().y-Hole_y);

        if(length5>=0&&length5<=10&&myinputproccer.isHitenable()){
            onhole5=true;
            batch.draw(holeT,hole5.getPosition().x-Hole_X,hole5.getPosition().y-Hole_y);
        }
        if(onhole5)batch.draw(holeT,hole5.getPosition().x-Hole_X,hole5.getPosition().y-Hole_y);
        batch.end();
    }

    private void moveinvertoy() {
        ItemsCollect[0] = getrat_items;
        ItemsCollect[1] = getsheep_meat;
        ItemsCollect[2] = getwood_items1 * 4;
        ItemsCollect[3] = getstone_items1 * 4;
        ItemsCollect[4] = getfish_items;
        ItemsCollect[5]=getIron_items;
        ItemsCollect[6]=getGold_items;
        ItemsCollect[7]=Helemt_gold_item;
        ItemsCollect[8]=chest_gold_item;
        ItemsCollect[9]=leg_gold_item;
        ItemsCollect[10]=foot_gold_item;
        ItemsCollect[11]=Helemt_metal_item;
        ItemsCollect[12]=chest_metal_item;
        ItemsCollect[13]=leg_metal_item;
        ItemsCollect[14]=foot_metal_item;
        if(ItemsCollect[0]>0)ontimerooten.set(0,true);
        if(ItemsCollect[1]>0)ontimerooten.set(1,true);
        if(ItemsCollect[4]>0)ontimerooten.set(2,true);
        if(ItemsCollect[0]==0)ontimerooten.set(0,false);
        if(ItemsCollect[1]==0)ontimerooten.set(1,false);
        if(ItemsCollect[4]==0)ontimerooten.set(2,false);
        for(int meow=0;meow<8;meow++) {
            Invertoyparts[meow].setLinearVelocity(player1.getLinearVelocity( ).x, player1.getLinearVelocity( ).y);
            Invertoyparts[8].setLinearVelocity(player1.getLinearVelocity( ).x, player1.getLinearVelocity( ).y);
            batch.begin( );
            batch.draw(Slot_Space, Invertoyparts[meow].getPosition( ).x - Invertoy.BOX_SIZE_width_part / PIXEL_PER_METER / 2, Invertoyparts[meow].getPosition( ).y - Invertoy.BOX_SIZE_hight_part / PIXEL_PER_METER / 2, Invertoy.BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER, Invertoy.BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER);
            batch.draw(Slot_Space, Invertoyparts[8].getPosition( ).x - Invertoy.BOX_SIZE_width_part / PIXEL_PER_METER / 2, Invertoyparts[meow].getPosition( ).y - Invertoy.BOX_SIZE_hight_part / PIXEL_PER_METER / 2, Invertoy.BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER, Invertoy.BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER);
            batch.draw(BagPic,Invertoyparts[8].getPosition().x-BAG_WIDTH,Invertoyparts[8].getPosition().y-BAG_HEIGHT,Invertoy.BOX_SIZE_width_part / Playscreen.PIXEL_PER_METER, Invertoy.BOX_SIZE_hight_part / Playscreen.PIXEL_PER_METER);
            batch.end();
        }
        batch.begin();
        for(int mmm=0;mmm<ISlots.size&&!first;mmm++)
            if(mmm<9){
                batch.draw(ISlots.get(mmm), Invertoyparts[mmm].getPosition( ).x - Invertoy.BOX_SIZE_width_part / Worldbegginerplace.PIXEL_PER_METER / 2+2.2f, Invertoyparts[mmm].getPosition( ).y - Invertoy.BOX_SIZE_hight_part / Worldbegginerplace.PIXEL_PER_METER / 2+2, Invertoy.BOX_SIZE_width_part / 40, Invertoy.BOX_SIZE_hight_part / 40);
                if (ItemsCollect[0]>0&&ItemsCollect[0] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (rat_meat).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[0], Invertoyparts[mmm].getPosition( ).x + 3 -2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);

                }
                if (ItemsCollect[0] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (rat_meat).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[0], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);

                }

                if (ItemsCollect[1] >0&&ItemsCollect[1] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (sheep_meat).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[1], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[1] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (sheep_meat).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[1], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[2] >0&&ItemsCollect[2] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (woodT).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[2], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[2] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (woodT).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[2], Invertoyparts[mmm].getPosition( ).x - 8+2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[3] >0&&ItemsCollect[3] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (rockT).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[3], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[3] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (rockT).getHeight( ))
                        font.draw(batch, "" + ItemsCollect[3], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[4] >0&&ItemsCollect[4] <10)
                    if (ISlots.get(mmm).getHeight( ) == (FishT).getHeight( )) {
                        font.draw(batch, "" + ItemsCollect[4], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                    }
                if (ItemsCollect[4] >= 10)
                    if (ISlots.get(mmm).getHeight( ) == (FishT).getHeight( )) {
                        font.draw(batch, "" + ItemsCollect[4], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                    }

                if (ItemsCollect[5] >0&&ItemsCollect[5] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (Iron_ingot).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (Iron_ingot).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[5], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[5] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (Iron_ingot).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (Iron_ingot).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[5], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);

                }
                if (ItemsCollect[6] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (Gold_ingot).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (Gold_ingot).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[6], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);

                }
                if (ItemsCollect[6] >0&&ItemsCollect[6] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (Gold_ingot).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (Gold_ingot).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[6], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[7] >0&&ItemsCollect[7] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armour).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armour).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[7], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[7] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armour).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armour).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[7], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);

                }

                if (ItemsCollect[8] >0&&ItemsCollect[8] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armour_chest).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armour_chest).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[8], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[8] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armour_chest).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armour_chest).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[8], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[9] >0&&ItemsCollect[9] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armour_leg).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armour_leg).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[9], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if (ItemsCollect[9] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armour_leg).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armour_leg).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[9], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[10] >0&&ItemsCollect[10] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armor_foot).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armor_foot).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[10], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[10] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (golden_armor_foot).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (golden_armor_foot).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[10], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[11] >0&&ItemsCollect[11] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_helemt).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_helemt).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[11], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[11] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_helemt).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_helemt).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[11], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[12] >0&&ItemsCollect[12] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_chest).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_chest).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[12], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[12] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_chest).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_chest).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[12], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[13] >0&&ItemsCollect[13] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_leg).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_leg).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[13], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[13] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_leg).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_leg).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[13], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[14] >0&&ItemsCollect[14] <10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_feet).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_feet).getWidth( ))
                        font.draw(batch, "" + ItemsCollect[14], Invertoyparts[mmm].getPosition( ).x + 3-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }

                if (ItemsCollect[14] >= 10) {
                    if (ISlots.get(mmm).getHeight( ) == (metal_armor_feet).getHeight( )
                            &&ISlots.get(mmm).getWidth( ) == (metal_armor_feet).getWidth( ))
                        font4.draw(batch, "" + ItemsCollect[14], Invertoyparts[mmm].getPosition( ).x - 8-2.2f, Invertoyparts[mmm].getPosition( ).y + 8-2);
                }
                if(ISlots.size!=0&&!(mmm<0))
                    if (ISlots.get(mmm)!=null)
                        if (ISlots.get(mmm).getHeight( ) == (rat_meat).getHeight( )) if (ItemsCollect[0]<=0){
                            ISlots.removeIndex(mmm);
                            mmm-=1;
                        }
                if(ISlots.size!=0&&!(mmm<0))
                    if(ISlots.get(mmm)!=null)
                        if (ISlots.get(mmm).getHeight( ) == (FishT).getHeight( ))
                            if(ItemsCollect[4]<=0) {
                                ISlots.removeIndex(mmm);
                                mmm-=1;
                            }
                if(ISlots.size!=0&&!(mmm<0))
                    if (ISlots.get(mmm)!=null)
                        if (ISlots.get(mmm).getHeight( ) == (sheep_meat).getHeight( ))
                            if(ItemsCollect[1]<=0) {
                                ISlots.removeIndex(mmm);
                                mmm-=1;
                            }
                if(ISlots.size!=0&&!(mmm<0))
                    if (ISlots.get(mmm)!=null)
                        if (ISlots.get(mmm).getHeight( ) == (Iron_ingot).getHeight( )&&
                                ISlots.get(mmm).getWidth( ) == (Iron_ingot).getWidth( ))
                            if(ItemsCollect[5]<=0) {
                                ISlots.removeIndex(mmm);
                                mmm-=1;
                            }
                if(ISlots.size!=0&&!(mmm<0))
                    if (ISlots.get(mmm)!=null)
                        if (ISlots.get(mmm).getHeight( ) == (Gold_ingot).getHeight( )&&
                                ISlots.get(mmm).getWidth( ) == (Gold_ingot).getWidth( ))
                            if(ItemsCollect[6]<=0) {
                                ISlots.removeIndex(mmm);
                                mmm-=1;
                            }
            }
        batch.end();

    }

    private void upadte() {
        world.step(Worldbegginerplace.TIME_STEP, Worldbegginerplace.VELOCITY_ITERATIONS, Worldbegginerplace.POSITION_ITERATIONS);
    }


    private void CheckGolem() {
        timeloop_Golem.set(i4,timeloop_Golem.get(i4)+Gdx.graphics.getRawDeltaTime());
        dx_Golem.set(i4, player1.getPosition().x - GolemBody.get(i4).getPosition().x);
        dy_Golem.set(i4, player1.getPosition().y - GolemBody.get(i4).getPosition().y);
        length_Golem.set(i4,Math.sqrt(dx_Golem.get(i4) * dx_Golem.get(i4) + dy_Golem.get(i4) * dy_Golem.get(i4)));
        dx_Golem.set(i4, (float) (dx_Golem.get(i4)/length_Golem.get(i4)));;
        dy_Golem.set(i4, (float) (dy_Golem.get(i4)/length_Golem.get(i4))); // normalize (make it 1 unit length)
        dx_Golem.set(i4, (dx_Golem.get(i4)*GolemSpeed));
        dy_Golem.set(i4, (dy_Golem.get(i4)*GolemSpeed));
        float dx_Speed_Golem=dx_Golem.get(i4);
        float dy_Speed_Golem=dy_Golem.get(i4);
        if(length_Golem.get(i4)>0&&length_Golem.get(i4)<=100){
            activefollowsystem_Golem.set(i4,true);
            hitforGolemEnable.set(i4,true);
        }
        if(activefollowsystem_Golem.get(i4)) {
            enableanimatonGolem.set(i4,true);
            GolemBody.get(i4).setLinearVelocity(new Vector2(dx_Speed_Golem,dy_Speed_Golem));
        }
        //hit reload
        if(timeloop_Golem.get(i4)>5f){
            timeloop_Golem.set(i4,timeloop_Golem.get(i4)-5f);
            hit_Golem.set(i4,true);
        }
        if(length_Golem.get(i4)>=0&&length_Golem.get(i4)<=20&&myinputproccer.isHitenable()) {
            timehit_Golem.set(i4, timehit_Golem.get(i4)+Gdx.graphics.getRawDeltaTime());
            Health_Golem.set(i4, (float) (Health_Golem.get(i4)-0.0016));
            if (timehit_Golem.get(i4) >10f) {

                //Todo: repsawn when far away from that side and wait 10*20 sec then spawn
                GolemBody.get(i4).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                GolemBody.get(i4).setLinearVelocity(0, 0);
                activefollowsystem_Golem.set(i4,false);
                Level+=1;
                timehit_Golem.set(i4, 0f);
                //respawntime_S=true;
                //timerespawn_S=10*20f;
            }
        }
    }

    private void MoveGolem() {
        timeloop2.set(i4,timeloop2.get(i4)+Gdx.graphics.getRawDeltaTime( ));
        if (timeloop2.get(i4) > periodloop && moveright_Golem.get(i4) && !enableanimatonGolem.get(i4) && movesides_Golem.get(i4)) {
            timeloop2.set(i4, timeloop2.get(i4)- periodloop);
            GolemBody.get(i4).setLinearVelocity(new Vector2(GolemSpeed, 0));
            moveleft_Golem.set(i4,true);
            moveright_Golem.set(i4,false);
        }
        if (timeloop2.get(i4) > periodloop && moveleft_Golem.get(i4) && !enableanimatonGolem.get(i4) && movesides_Golem.get(i4)) {
            timeloop2.set(i4, timeloop2.get(i4)- periodloop);
            GolemBody.get(i4).setLinearVelocity(new Vector2(-GolemSpeed, 0));
            moveleft_Golem.set(i4,false);
            moveright_Golem.set(i4,true);
        }
    }

    private void CheckGhost() {
        timeloop_Ghost.set(i5,timeloop_Ghost.get(i5)+Gdx.graphics.getRawDeltaTime());
        dx_Ghost.set(i5, player1.getPosition().x - GhostBody.get(i5).getPosition().x);
        dy_Ghost.set(i5, player1.getPosition().y - GhostBody.get(i5).getPosition().y);
        length_Ghost.set(i5,Math.sqrt(dx_Ghost.get(i5) * dx_Ghost.get(i5) + dy_Ghost.get(i5) * dy_Ghost.get(i5)));
        dx_Ghost.set(i5, (float) (dx_Ghost.get(i5)/length_Ghost.get(i5)));;
        dy_Ghost.set(i5, (float) (dy_Ghost.get(i5)/length_Ghost.get(i5))); // normalize (make it 1 unit length)
        if(length_Ghost.get(i5)>0&&length_Ghost.get(i5)<=100){
            hitforGhostEnable.set(i5,true);
        }

        //hit reload
        if(timeloop_Ghost.get(i5)>5f){
            timeloop_Ghost.set(i5,timeloop_Ghost.get(i5)-5f);
            hit_Ghost.set(i5,true);
        }
        if(length_Ghost.get(i5)>=0&&length_Ghost.get(i5)<=30&&myinputproccer.isHitenable()) {
            timehit_Ghost.set(i5, timehit_Ghost.get(i5)+Gdx.graphics.getRawDeltaTime());
            Health_Ghost.set(i5, (float) (Health_Ghost.get(i5)-0.0016));
            if (timehit_Ghost.get(i5) >10f) {
                //Todo: just do the normal animaton the attack one and if attacked and die do die animaton also the golem also
                GhostBody.get(i5).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                GhostBody.get(i5).setLinearVelocity(0, 0);
                Level+=0.5;
                timehit_Ghost.set(i5, 0f);
                //respawntime_S=true;
                //timerespawn_S=10*20f;
            }
        }
    }

    private void MoveSkeleton() {
        timeloop.set(i3,timeloop.get(i3)+Gdx.graphics.getRawDeltaTime( ));
        if (timeloop.get(i3) > periodloop && moveright_skeleton.get(i3) && !enableanimatonSkeleton.get(i3) && movesides_skeleton.get(i3)) {
            timeloop.set(i3, timeloop.get(i3)- periodloop);
            SkeletonBody.get(i3).setLinearVelocity(new Vector2(SkeletonSpeed, 0));
            moveleft_skeleton.set(i3,true);
            moveright_skeleton.set(i3,false);
        }
        if (timeloop.get(i3) > periodloop && moveleft_skeleton.get(i3) && !enableanimatonSkeleton.get(i3) && movesides_skeleton.get(i3)) {
            timeloop.set(i3, timeloop.get(i3)- periodloop);
            SkeletonBody.get(i3).setLinearVelocity(new Vector2(-SkeletonSpeed, 0));
            moveleft_skeleton.set(i3,false);
            moveright_skeleton.set(i3,true);
        }
    }

    private void CheckSkeleton() {
        {
            timeloop_S.set(i3,timeloop_S.get(i3)+Gdx.graphics.getRawDeltaTime());
            dx_S.set(i3, player1.getPosition().x - SkeletonBody.get(i3).getPosition().x);
            dy_S.set(i3, player1.getPosition().y - SkeletonBody.get(i3).getPosition().y);
            length_S.set(i3,Math.sqrt(dx_S.get(i3) * dx_S.get(i3) + dy_S.get(i3) * dy_S.get(i3)));
            dx_S.set(i3, (float) (dx_S.get(i3)/length_S.get(i3)));;
            dy_S.set(i3, (float) (dy_S.get(i3)/length_S.get(i3))); // normalize (make it 1 unit length)
            dx_S.set(i3, (dx_S.get(i3)*SkeletonSpeed));
            dy_S.set(i3, (dy_S.get(i3)*SkeletonSpeed));
            float dx_Speed=dx_S.get(i3);
            float dy_Speed=dy_S.get(i3);
            if(length_S.get(i3)>0&&length_S.get(i3)<=100){
                activefollowsystem_S.set(i3,true);
                hitforSkeletonEnable.set(i3,true);
            }
            if(activefollowsystem_S.get(i3)) {
                enableanimatonSkeleton.set(i3,true);
                SkeletonBody.get(i3).setLinearVelocity(new Vector2(dx_Speed,dy_Speed));
            }
            //hit reload
            if(timeloop_S.get(i3)>5f){
                timeloop_S.set(i3,timeloop_S.get(i3)-5f);
                hit_S.set(i3,true);
            }
            if(hit_S.get(i3) && (length_S.get(i3) >= 0) && (length_S.get(i3) <= 20) && hitforSkeletonEnable.get(i3)){
                Health-=0.05;
                hit_S.set(i3,false);
                System.out.println("Health"+Health);
            }

            if(length_S.get(i3)>=0&&length_S.get(i3)<=20&&myinputproccer.isHitenable()) {
                timehit_S.set(i3, timehit_S.get(i3)+Gdx.graphics.getRawDeltaTime());
                Health_Skeleton.set(i3, (float) (Health_Skeleton.get(i3)-0.0016));
                if (timehit_S.get(i3) >10f) {
                    SkeletonBody.get(i3).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                    SkeletonBody.get(i3).setLinearVelocity(0, 0);
                    activefollowsystem_S.set(i3,false);
                    Level+=0.3;
                    timehit_S.set(i3, 0f);
                    //respawntime_S=true;
                    //timerespawn_S=10*20f;
                }
            }
        }
    }


    private void check() {
        for (int i=0;i<52;i++)for(int j=0;j<60;j++){
            cell = mapLayer.getCell(i, j);
            if (cell != null) {
                if (cell.getTile( ).getId( ) == 115) {
                    x_list.add(i);
                    y_list.add(j);
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
