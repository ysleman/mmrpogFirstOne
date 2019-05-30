package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.openworld.Bodysforcontrollers;
import com.mygdx.game.openworld.Dungeonenter;
import com.mygdx.game.openworld.Fish;
import com.mygdx.game.openworld.Invertoy;
import com.mygdx.game.openworld.Rat;
import com.mygdx.game.openworld.Reacon;
import com.mygdx.game.openworld.Sheep;
import com.mygdx.game.openworld.Stone_brick;
import com.mygdx.game.openworld.Throw_items;
import com.mygdx.game.openworld.Tree_Brick;

import java.util.ArrayList;

public class Worldbegginerplace implements Screen{
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
    private  TiledMapTileLayer mapLayer;
    private Body FishPool;
    public static SpriteBatch batch;
    private final OrthographicCamera camera;
    private final TiledMap tiledMap;
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

    private OrthogonalTiledMapRenderer tiledMapRenderer;
    private final Myinputproccer myinputproccer;
    private final PolygonShape polygonShape;
    private final Box2DDebugRenderer box2DDebugRenderer;
    private final World world;
    private final BodyDef bdef;
    private final FixtureDef fixtureDef;
    private  Stage stage;
    private  Array<Float> array_xsheep_respawn,array_ysheep_respawn;
    private Player player;
    private Body player1;
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
   private  TextureAtlas atlasright,atlasleft,atlasup,atlasdown;
    private  Animation animationright,animationleft,aniamtionup,animationdown;
    private Tree_Brick tree_brick;
    private Stone_brick stone_brick;
    public MyGdxGame game;
    private static final float SCALE = 2.0f;
    public static final float TIME_STEP = 1 / 60f;
    public static final int VELOCITY_ITERATIONS = 6;
    public static final int POSITION_ITERATIONS = 2;
    private float timeloop=0,timeloop2=0;
    private float periodloop=3f;
    private boolean moveleft=false,moveright=true;
    private double length;
    private float dx,dy,x,y;
    private boolean activefollowsystem=false;
    private boolean hitrat=false;
    int i=0,i2=0,i3=0,i4=0;
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
    private float dx2,dy2,x2,y2;
    private double lengthreacon;
    private boolean activefollowsystem2=false;
    private float timehit;
    private Texture Healthbar;
    private float Health=1f;
    private float dy3,dx3;
    private double lengthBrick,lengthBrick2,lengthBrick3,lengthBrick4;
    private float dx5,dx4,dx6,dy4,dy5,dy6;
    private int timehit2=0,timehit3=0,timehit4=0;
    public int stone=0;
    private Body bodybeforestone;
    private float dy7,dx8,dy8,dx7;
    private double lengthTree2,lengthTree;
    private int timehit6,timehit5,i6,i5;
    private int tree=0;
    private Body bodybeforetree;
    private float timeloop4;
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
    private Body[] Invertoyparts;
    private Body invertoybuild;
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
    private Texture rat_meat,sheep_meat,sheep_wall;
    private Array<Float> array_xrat_respawn;
    private Array<Float> array_yrat_respawn;
    private int x_i_respawn =0, y_i_respawn;
    private boolean dropitemsnonumber=true;
    private Array<Body> rat_items_respawn,sheep_items_respawn,stone_items_respawn,stone_items2_respawn,stone_items3_respawn,stone_items4_respawn;
    private float dxratitems_respawn,dyratitems_respawn,xratitems_respawn,yratitems_respawn;
    private double lengthratitems_respawn;
    private int getrat_items =0;
    private boolean onetime_rat =true;
    private boolean onetime_sheep;
    private int x_sheep_respawn,y_sheep_respawn;
    private double lengthsheepitems_respawn;
    private float ysheepitems_respawn,xsheepitems_respawn;
    private float dysheepitems_respawn,dxsheepitems_respawn;
    private int getsheep_meat=0;
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
    private int getstone_items1;
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
    private Array<Float> array_xwood2_respawn,array_ywood2_respawn,array_ywood1_respawn,array_xwood1_respawn;
    private boolean onetime_wood,onetime_wood2;
    private int x_wood1_respawn,y_wood1_respawn,x_wood2_respawn,y_wood2_respawn;
    private float dxwood2items_respawn,dywood2items_respawn,xwood2items_respawn,ywood2items_respawn;
    private double lengthwood2items_respawn;
    private float dxwood1items_respawn,dywood1items_respawn,xwood1items_respawn,ywood1items_respawn;
    private double lengthwood1items_respawn;
    private int getwood_items1=0;
    private Texture invertoy_backgroundT;
    private Texture rockT,woodT;
    private Array<Texture> ISlots,extraISlots;
    private int[] ItemsCollect;//how many in each items
    private int ISlotsN=-1;
    private int IBefore;
    private boolean IChange=true;
    private boolean first;
    private int ix=0;
    private boolean ICollect=false;
    private float dxwood2items,dywood2items,dywood1items,dxwood1items;
    private float xwood1items,ywood1items,xwood2items,ywood2items;
    private double lengthwood1items,lengthwood2items;
    private FreeTypeFontGenerator FontGenerator,FontGenerator1;
    private FreeTypeFontGenerator.FreeTypeFontParameter FontParameter,FontParameter1;
    private BitmapFont font,font1,font3;
    private Label label2;
    private static final Float Stone_X = PIXEL_PER_METER*2;
    private static final Float Stone_Y = PIXEL_PER_METER*3/2;
    private boolean moveup_goblin=true,movedown_goblin=true;
    private Fish Fish;
    private Texture FishT;
    private int getfish_items;
    private Texture Emptybar;
    private Texture Levelbar;
    private float Level;
    private int numL=1;
    private TiledMapTileLayer.Cell cell;
    private ArrayList<Integer> x_list;
    private ArrayList<Integer> y_list;
    private Body DEnter;
    private float dx_d;
    private float dy_D;
    private double length_D;
    private double length_touch;
    private float dx_touch,dy_touch;
    private Array<Boolean> ontimerooten;
    private float timeloop_rooten_rat =0,timeloop_rooten_sheep=0,timeloop_rooten_fish=0;
    private float timeloop_hunger_rat =0;
    private int hunger=1200;
    private Texture HungerBar;
    private float timeloop_hunger_Sheep=0;
    private float timeloop_hunger_Fish=0;
    private boolean workhunger_rat=false,workhunger_sheep=false,workhunger_fish=false;
    private float hunger_reduce=1;
    private Body Right_control,left_control,up_control,down_control;
    private Texture RightArrow,leftArrow,UpArrow,DownArrow;
    private float UP_control_x,Right_control_x,UP_control_y,Right_control_y,Down_control_x,Down_control_y;
    private float left_control_y,left_control_x;
    private float m,k;
    private int MODE_RIGHTNOW;
    private Texture Background;
    private  int Main_reduce;
    private int howmanytimes_lefttoadd;
    private int level_Main;//last time_Stats u changed it
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
    private  Texture Slot_Space;
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
    private float BAG_WIDTH;
    private float BAG_HEIGHT;
    private  BitmapFont font4;
    private  Texture Build_info;
    private  int[] SlotBuildSpace_Y;
    private  int[] SlotBuildSpace_X;
    private int[] WhichInfo;
    private Texture Info_texture;
    private Array<Texture> BuildISlots;
    private float Time_Spent=0;
    private Texture Iron_ingot,Gold_ingot;
    private Texture metal_armor_leg;
    private Texture metal_armor_chest,metal_armor_feet,metal_armor_helemt;
    private Texture golden_armor_foot,golden_armour,golden_armour_chest,golden_armour_leg;
    private int getIron_items=0;
    private int getGold_items=0;
    private int Helemt_gold_item=0,chest_gold_item=0,foot_gold_item=0,leg_gold_item=0;
    private int Helemt_metal_item=0,chest_metal_item=0,foot_metal_item=0,leg_metal_item=0;
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
    private float[] hungers;
    private int[] stats;

    // 66-70
    public Worldbegginerplace(Array<Texture> ISlots, MyGdxGame game, float health, float level, int[] itemsCollect, boolean first1, float[] hungers, int[] stats) {
        this.Health=health;
        this.Level=level;
        this.ISlots=ISlots;
        this.first= first1;
        this.hunger_reduce= hungers[0];
        this.Main_hunger= (int) hungers[1];
        level_Main= stats[0];
        Main_hunger= stats[1];
        Main_Immunity= stats[2];
        Main_attack= stats[3];
        Main_health= stats[4];
        howmanytimes_lefttoadd= stats[5];
        Main_reduce= stats[6];
        this.hungers =new float[4];
        this.stats =new int[10];
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
        world = new World(new Vector2(VELOCITY_X, VELOCITY_Y), false);
        box2DDebugRenderer = new Box2DDebugRenderer();
        bdef=new BodyDef();
        batch = new SpriteBatch();
        Healthbar=new Texture("HealthBar.png");
        Emptybar=new Texture("EmptyBar.png");
        Levelbar=new Texture("LevelBar.png");
        polygonShape=new PolygonShape();
        fixtureDef =new FixtureDef();
        this.game=game;

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        ascept_width= (int) (w/dwidth);
                ascept_height= (int) (h/dheight);
                w*=ascept_width;
                h*=ascept_height;
        camera = new OrthographicCamera();
        camera.setToOrtho(false,w/2,h/2);
        camera.update();
        viewport=new FitViewport(w/2,h/2,camera);

        tiledMap = new TmxMapLoader().load("map/worldbegginer.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap,1f);
        mapLayer= (TiledMapTileLayer) tiledMap.getLayers().get(10);
        worldcheck();
        myinputproccer=new Myinputproccer(player1,tiledMap,PIXEL_PER_METER,momvent);
        Gdx.input.setInputProcessor(myinputproccer);
        TiledObjectlayer.parseTiledObjectLayer(world,tiledMap.getLayers().get(11).getObjects());
        TiledObjectlayer.parseTiledObjectLayer(world,tiledMap.getLayers().get(12).getObjects());
        TiledObjectlayer.parseTiledObjectLayer(world,tiledMap.getLayers().get(13).getObjects());
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
        FontGenerator.dispose();
        System.out.println(w+"  "+h);
        oldmomevent=myinputproccer.momvent;
        //  TODo:make an y with blocks u can build in so it build stright ,fix the way enemis move,try to fix the player move which stop suddenly
        //Todo: make a side which u can use to build invertoy anything
    }
    @Override
    public void show() {

    }
    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.9f, 0.5f, 0.8f);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(MODE_RIGHTNOW==0) {
            Time_Spent+=Gdx.graphics.getRawDeltaTime();
                camera.position.set(player1.getPosition( ).x, player1.getPosition( ).y, 0);
                camera.update();
            if(Health<=0){
                game.Game_Over(Level,Time_Spent,level_Main,0);
            }
            tiledMapRenderer.setView(camera);
            tiledMapRenderer.render();
            box2DDebugRenderer.SHAPE_STATIC.set(1, 0, 0, 0);
            box2DDebugRenderer.render(world, camera.combined);
            allchanged( );
            timeloop4 += delta;
            update( );
            if (respawntime_goblin || respawntime_rat || respawntime_sheep || respawntime_stone || respawntime_stone2 || respawntime_stone3 || respawntime_stone4 || respawntime_wood || respawntime_wood2)
                respawn();
            moveinvertoy( );
            ChangeStats();
            if (ontimerooten.get(0)) timerooten_RAT( );
            if (ontimerooten.get(1)) timerooten_sheep( );
            if (ontimerooten.get(2)) timerooten_fish( );
            if (ontimerooten.get(0) || workhunger_rat) reduce_hunger_rat( );
            if (ontimerooten.get(1) || workhunger_sheep) reduce_hunger_Sheep( );
            if (ontimerooten.get(2) || workhunger_fish) reduce_hunger_Fish( );
            dropitems( );
            dropitems_respawn( );

            batch.begin( );
            batch.setProjectionMatrix(camera.combined);
            armour_checker();

            batch.draw(UpArrow, up_control.getPosition( ).x - UP_control_x, up_control.getPosition( ).y - UP_control_y, ArrowSize, ArrowSize);
            batch.draw(DownArrow, down_control.getPosition( ).x - Down_control_x, down_control.getPosition( ).y - Down_control_y, ArrowSize, ArrowSize);
            batch.draw(leftArrow, left_control.getPosition( ).x - left_control_x, left_control.getPosition( ).y - left_control_y, ArrowSize, ArrowSize);
            batch.draw(RightArrow, Right_control.getPosition( ).x - Right_control_x, Right_control.getPosition( ).y - Right_control_y, ArrowSize, ArrowSize);

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

            if(Gdx.input.justTouched()) if(Gdx.input.getX()>=(w-(Invertoyparts[8].getPosition().x)*0.8)&&Gdx.input.getX()<=(w-(Invertoyparts[8].getPosition().x)*0.6)
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
            batch.end();
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
            tiledMapRenderer=new OrthogonalTiledMapRenderer(tiledMap,0.7f*(ascept_width/ascept_height));
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
            for(int j=0;j<5;j++)
                for(int i=0;i<6;i++)
                    batch.draw(Slot_Space,SlotSpace_X[i],SlotSpace_Y[j],40*ascept_width,50*ascept_height);
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
            for(int j=0;j<5;j++)
                for(int i=0;i<6;i++)
                    batch.draw(Slot_Space, SlotBuildSpace_X[i], SlotBuildSpace_Y[j],45*ascept_width,50*ascept_height);
            batch.draw(inmark,w/2+100,380,80*ascept_width,30*ascept_height);
            font4.draw(batch,"Build",w/2+100+10,380+20);
            drawBuildItems();
           if(Gdx.input.justTouched()) ClickBuildButton();
           TheinfoButton();
            ExitWay();
            batch.end();
        }
    }

    private void armour_checker() {
        //Helemt
        //Chest
        //legs
        //foot
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
    private void ExitWay() {
        if(Gdx.input.getX()<30||Gdx.input.getX()>(w-30)||Gdx.input.getY()<30||Gdx.input.getY()>(h-30)){
            MODE_RIGHTNOW=0;
            onetime_Work=true;
            camera.setToOrtho(false,w/2,h/2);
            camera.update();
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


    private void outsidetoclose() {
        if(Gdx.input.getX()<=30||Gdx.input.getX()>=w-30||Gdx.input.getY()<30||Gdx.input.getY()>(h-30)) {
            MODE_RIGHTNOW = 0;
            camera.setToOrtho(false, w / 2, h / 2);
            camera.update( );
            onetime_Work=true;
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

    private void cameramovemnt() {
        if (player1.getPosition( ).x > 860) {
            camera.position.set(860, player1.getPosition( ).y, 0);
            camera.update( );
        }
        if(player1.getPosition().x<=160){
            camera.position.set(160,player1.getPosition().y,0);
            camera.update();
        }
        if(player1.getPosition().y>680){
            camera.position.set(player1.getPosition().x,680,0);
            camera.update();
        }
        if(player1.getPosition().y<120){
            camera.position.set(player1.getPosition().x,120,0);
            camera.update();
        }
        if(player1.getPosition().x<=160&&player1.getPosition().y<120){
            camera.position.set(160,120,0);
            camera.update();
        }
        if(player1.getPosition().x<=160&&player1.getPosition().y>680){
            camera.position.set(160,680,0);
            camera.update();
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
                camera.setToOrtho(false,Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
                tiledMapRenderer=new OrthogonalTiledMapRenderer(tiledMap,1);
                MODE_RIGHTNOW=0;
                batch.draw(outmark,Gdx.graphics.getWidth()/2+Width_Stats,Gdx.graphics.getHeight()/2-195+up_Stats,50,50);
                System.out.println("Exit");
            }
        }
    }

    private void allchanged() {
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

//         if(player1.getPosition().x>860&&!control_up&&!control_left&&!control_down&&control_Right){
//            up_control.setTransform(new Vector2(up_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + ((15 + 20) * 1.95f)), 0);
//            down_control.setTransform(new Vector2(down_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2)), 0);
//            left_control.setTransform(new Vector2(left_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + 15 * 2.3f), 0);
//            Right_control.setTransform(new Vector2(Right_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + 15 * 2.3f), 0);
//        }
//        if(player1.getPosition().x<160&&!control_up&&control_left&&!control_down&&!control_Right){
//            up_control.setTransform(new Vector2(up_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + ((15 + 20) * 1.95f)), 0);
//            down_control.setTransform(new Vector2(down_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2)), 0);
//            left_control.setTransform(new Vector2(left_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + 15 * 2.3f), 0);
//            Right_control.setTransform(new Vector2(Right_control.getPosition().x, player1.getPosition( ).y - Gdx.graphics.getHeight( ) / (10 / 2) + 15 * 2.3f), 0);
//        }
//        if(player1.getPosition().y>680&&control_up&&!control_left&&!control_down&&!control_Right){
//            up_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6, up_control.getPosition().y), 0);
//            down_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6, down_control.getPosition().y), 0);
//            left_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6 - 20 * 1.6f, left_control.getPosition().y), 0);
//            Right_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6 + 20 * 1.6f, Right_control.getPosition().y), 0);
//        }
//        if(player1.getPosition().y<120&&!control_up&&!control_left&&control_down&&!control_Right){
//            up_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6, up_control.getPosition().y), 0);
//            down_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6, down_control.getPosition().y), 0);
//            left_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6 - 20 * 1.6f, left_control.getPosition().y), 0);
//            Right_control.setTransform(new Vector2(player1.getPosition( ).x - Gdx.graphics.getWidth( ) / 6 + 20 * 1.6f, Right_control.getPosition().y), 0);
//        }
//        if(player1.getPosition().x<160&&player1.getPosition().y<120&&!control_up&&control_left&&control_down&&!control_Right){
//            //down left
//            up_control.setTransform(new Vector2(up_control.getPosition().x, up_control.getPosition().y), 0);
//            down_control.setTransform(new Vector2(down_control.getPosition().x, down_control.getPosition().y), 0);
//            left_control.setTransform(new Vector2(left_control.getPosition().x, left_control.getPosition().y), 0);
//            Right_control.setTransform(new Vector2(Right_control.getPosition().x, Right_control.getPosition().y), 0);
//        }
//        if(player1.getPosition().x<160&&player1.getPosition().y>680&&control_up&&control_left&&!control_down&&!control_Right){
//            //up left
//            up_control.setTransform(new Vector2(up_control.getPosition().x, up_control.getPosition().y), 0);
//            down_control.setTransform(new Vector2(down_control.getPosition().x, down_control.getPosition().y), 0);
//            left_control.setTransform(new Vector2(left_control.getPosition().x, left_control.getPosition().y), 0);
//            Right_control.setTransform(new Vector2(Right_control.getPosition().x, Right_control.getPosition().y), 0);
//        }
//        //check all sides with boolean values
//        if(player1.getPosition().x<160)control_left=true;
//        if(player1.getPosition().x>860)control_Right=true;
//        if(player1.getPosition().y<120)control_down=true;
//        if(player1.getPosition().y>680)control_up=true;
//        //make it false
//        if(player1.getPosition().x>160)control_left=false;
//        if(player1.getPosition().x<860)control_Right=false;
//        if(player1.getPosition().y>120)control_down=false;
//        if(player1.getPosition().y<680)control_up=false;
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
    private void check() {
        for (int i=0;i<64;i++)for(int j=0;j<50;j++){
            cell = mapLayer.getCell(i, j);
            if (cell != null) {
                x_list.add(i);
                y_list.add(j);
            }
        }
    }
    private void dropitems() {
        //rat-0
        //sheep-1
        //goblin-2
        //stone-3
        //wood-4
        switch (whichone){
            case 0:{
                rat_items=throw_rat.getRat_throw();
                rat_items.setGravityScale(0);
                batch.begin();
                batch.draw(rat_meat,rat_items.getPosition().x-rat_meat.getWidth()/PIXEL_PER_METER*2,rat_items.getPosition().y-rat_meat.getHeight()/PIXEL_PER_METER,RatSize/2,RatSize/2);
                batch.end();
                collectitems();
            }
                break;
            case 1:
            {
                sheep_items=throw_sheep.getSheep_throw();
                sheep_items.setGravityScale(0);
                batch.begin();
                batch.draw(sheep_meat,sheep_items.getPosition().x-sheep_meat.getWidth()/PIXEL_PER_METER*2,sheep_items.getPosition().y-sheep_meat.getHeight()/PIXEL_PER_METER,10,10);
                batch.end();
                collectitems();
            }
                break;
            case 2: {

            }
                break;
            case 3:{
                if(whichtree[0]==1){
                    wood_items=throw_wood.getWood_throw();
                    wood_items.setGravityScale(0);
                    batch.begin();
                    batch.draw(texturewood_items,wood_items.getPosition().x-texturewood_items.getWidth()/PIXEL_PER_METER*2,wood_items.getPosition().y-texturewood_items.getHeight()/PIXEL_PER_METER,10,10);
                    batch.end();
                }
                if(whichtree[1]==2){
                    wood_items2=throw_wood2.getWood_throw();
                    wood_items2.setGravityScale(0);
                    batch.begin();
                    batch.draw(texturewood_items,wood_items2.getPosition().x-texturewood_items.getWidth()/PIXEL_PER_METER*2,wood_items2.getPosition().y-texturewood_items.getHeight()/PIXEL_PER_METER,10,10);
                    batch.end();
                }
                collectitems();
            }
                break;
            case 4:{
                if(whichstone[0]==1){
                    stone_items=throw_stone.getStone_throw();
                    stone_items.setGravityScale(0);
                    batch.begin();
                    batch.draw(textureStone_items,stone_items.getPosition().x-textureStone_items.getWidth()/Stone_X,stone_items.getPosition().y-textureStone_items.getHeight()/Stone_Y,10,10);
                    batch.end();
                }
                if(whichstone[1]==2){
                    stone_items2=throw_stone2.getStone_throw();
                    stone_items2.setGravityScale(0);
                    batch.begin();
                    batch.draw(textureStone_items,stone_items2.getPosition().x-textureStone_items.getWidth()/Stone_X,stone_items2.getPosition().y-textureStone_items.getHeight()/Stone_Y,10,10);
                    batch.end();
                }
                if(whichstone[2]==3){
                    stone_items3=throw_stone3.getStone_throw();
                    stone_items3.setGravityScale(0);
                    batch.begin();
                    batch.draw(textureStone_items,stone_items3.getPosition().x-textureStone_items.getWidth()/Stone_X,stone_items3.getPosition().y-textureStone_items.getHeight()/Stone_Y,10,10);
                    batch.end();
                }
                if(whichstone[3]==4){
                    stone_items4=throw_stone4.getStone_throw();
                    stone_items4.setGravityScale(0);
                    batch.begin();
                    batch.draw(textureStone_items,stone_items4.getPosition().x-textureStone_items.getWidth()/Stone_X,stone_items4.getPosition().y-textureStone_items.getHeight()/Stone_Y,10,10);
                    batch.end();
                }
                collectitems();
            }
                break;
                default:
                    break;
        }
     }

     private void dropitems_respawn(){
         switch (whichone_respawn){
             case 0:{
                 if(onetime_rat)rat_items_respawn.add(throw_rat_respawn.getRat_throw());
                 batch.begin();
                 for(x_i_respawn =0; x_i_respawn < array_xrat_respawn.size; x_i_respawn++) {
                     batch.draw(rat_meat, array_xrat_respawn.get(x_i_respawn)-rat_meat.getWidth()/PIXEL_PER_METER*2, array_yrat_respawn.get(x_i_respawn)-rat_meat.getHeight()/PIXEL_PER_METER, RatSize/2, 10);
                     collectitems_respawn();
                 }
                 batch.end();
                 onetime_rat =false;
             }
             break;
             case 1:
             {
                 if(onetime_sheep)sheep_items_respawn.add(throw_sheep_respawn.getSheep_throw());
                 batch.begin();
                 for(x_sheep_respawn =0; x_sheep_respawn < array_xsheep_respawn.size; x_sheep_respawn++) {
                     batch.draw(sheep_meat, array_xsheep_respawn.get(x_sheep_respawn)- rat_meat.getWidth()/PIXEL_PER_METER*2, array_ysheep_respawn.get(x_sheep_respawn)-rat_meat.getHeight()/PIXEL_PER_METER, 10, 10);
                     collectitems_respawn();
                 }
                 batch.end();
                 onetime_sheep=false;
             }
             break;
             case 2: {//goblin
             }
             break;
             case 3:{
                 if(whichtree_respawn[0]==1){
                     if(onetime_wood)wood_items_respawn.add(throw_wood_respawn.getWood_throw());
                     batch.begin();
                     for(x_wood1_respawn =0; x_wood1_respawn < array_xwood1_respawn.size; x_wood1_respawn++) {
                         batch.draw(texturewood_items,wood_items_respawn.get(x_wood1_respawn).getPosition().x-rat_meat.getWidth()/PIXEL_PER_METER/2,wood_items_respawn.get(x_wood1_respawn).getPosition().y-texturewood_items.getHeight()/PIXEL_PER_METER/2,10,10);
                         collectitems_respawn();
                     }
                     batch.end();
                     onetime_wood=false;
                 }
                 if(whichtree_respawn[1]==2){
                     if(onetime_wood2)wood_items2_respawn.add(throw_wood2_respawn.getWood_throw());
                     batch.begin();
                     for(x_wood2_respawn =0; x_wood2_respawn < array_xwood2_respawn.size; x_wood2_respawn++) {
                         batch.draw(texturewood_items,wood_items2_respawn.get(x_wood2_respawn).getPosition().x-texturewood_items.getWidth()/PIXEL_PER_METER/2,wood_items2_respawn.get(x_wood2_respawn).getPosition().y-texturewood_items.getHeight()/PIXEL_PER_METER/2,10,10);
                         collectitems_respawn();
                     }
                     batch.end();
                     onetime_wood2=false;
                 }
             }
             break;
             case 4:{
                 if(whichstone_respawn[0]==1){
                    if(onetime_stone) stone_items_respawn.add(throw_stone_respawn.getStone_throw());
                     batch.begin();
                     for(x_stone1_respawn =0; x_stone1_respawn < array_xstone1_respawn.size; x_stone1_respawn++) {
                         batch.draw(textureStone_items, array_xstone1_respawn.get(x_stone1_respawn)-textureStone_items.getWidth()/Stone_X, array_ystone1_respawn.get(x_stone1_respawn)-textureStone_items.getHeight()/Stone_Y, 10, 10);
                         collectitems_respawn();
                     }
                     batch.end();
                     onetime_stone=false;
                 }
                 if(whichstone_respawn[1]==2){
                     if(onetime_stone2)stone_items2_respawn.add(throw_stone2_respawn.getStone_throw());
                     batch.begin();
                     for(x_stone2_respawn =0; x_stone2_respawn < array_xstone2_respawn.size; x_stone2_respawn++) {
                         batch.draw(textureStone_items, array_xstone2_respawn.get(x_stone2_respawn)-textureStone_items.getWidth()/Stone_X, array_ystone2_respawn.get(x_stone2_respawn)-textureStone_items.getHeight()/Stone_Y, 10, 10);
                         collectitems_respawn();
                     }
                     batch.end();
                     onetime_stone2=false;
                 }
                 if(whichstone_respawn[2]==3){
                    if (onetime_stone3)stone_items3_respawn.add(throw_stone3_respawn.getStone_throw());
                     batch.begin();
                     for(x_stone3_respawn =0; x_stone3_respawn < array_xstone3_respawn.size; x_stone3_respawn++) {
                         batch.draw(textureStone_items, array_xstone3_respawn.get(x_stone3_respawn)-textureStone_items.getWidth()/Stone_X, array_ystone3_respawn.get(x_stone3_respawn)-textureStone_items.getHeight()/Stone_Y, 10, 10);
                         collectitems_respawn();
                     }
                     batch.end();
                     onetime_stone3=false;
                 }
                 if(whichstone_respawn[3]==4){
                     if (onetime_stone4)stone_items4_respawn.add(throw_stone4_respawn.getStone_throw());
                     batch.begin();
                     for(x_stone4_respawn =0; x_stone4_respawn < array_xstone4_respawn.size; x_stone4_respawn++) {
                         batch.draw(textureStone_items, array_xstone4_respawn.get(x_stone4_respawn)-textureStone_items.getWidth()/Stone_X, array_ystone4_respawn.get(x_stone4_respawn)-textureStone_items.getHeight()/Stone_Y, 10, 10);
                         collectitems_respawn();
                     }
                     batch.end();
                     onetime_stone4=false;
                 }
             }
             break;
             default:
                 break;
         }
     }
    private void collectitems() {
        switch (whichone){
            case 0:{
                    dxratitems = player1.getPosition().x - rat_items.getPosition().x;
                    dyratitems = player1.getPosition().y - rat_items.getPosition().y;
                    xratitems=dxratitems;
                    yratitems=dyratitems;
                    lengthratitems = Math.sqrt(xratitems * xratitems + yratitems * yratitems);
                    xratitems /= lengthratitems;
                    yratitems /= lengthratitems; // normalize (make it 1 unit length)
                    xratitems *= 7;
                    yratitems *= 7; // scale to our desired speed
                    if(lengthratitems>0&&lengthratitems<=10){
                        rat_items.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        rat_items.setLinearVelocity(0, 0);
                        getrat_items++;
                        ICollect=true;
                    }
                    if(ICollect) {
                        if (first) {
                            ISlots.add(rat_meat);
                            first = false;
                        }
                        for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==(rat_meat).getHeight()) IChange = false;
                            if(IChange)ix++;
                            System.out.println(ix);
                        }
                        if (ix == ISlots.size) {
                            ISlots.add(rat_meat);
                            ix = 0;
                            whichone=-1;
                        }
                        ICollect=false;
                        IChange = true;
                    }
            }
            break;
            case 1:
            {
                    dxsheepitems = player1.getPosition().x - sheep_items.getPosition().x;
                    dysheepitems = player1.getPosition().y - sheep_items.getPosition().y;
                    xsheepitems=dxsheepitems;
                    ysheepitems=dysheepitems;
                    lengthsheepitems = Math.sqrt(xsheepitems* xsheepitems + ysheepitems * ysheepitems);
                    xsheepitems /= lengthsheepitems;
                    ysheepitems /= lengthsheepitems; // normalize (make it 1 unit length)
                    xsheepitems *= 7;
                    ysheepitems *= 7; // scale to our desired speed
                    if(lengthsheepitems>0&&lengthsheepitems<=10){
                        sheep_items.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        sheep_items.setLinearVelocity(0, 0);
                        getsheep_meat++;
                        ICollect=true;
                }
                if(ICollect) {
                    if (first) {
                        ISlots.add(sheep_meat);
                        first = false;
                    }
                    for (int mmm = 0; mmm < ISlots.size&&!first; mmm++) {
                        if (ISlots.get(mmm).getHeight()==( sheep_meat).getHeight()) IChange = false;
                        if(IChange)ix++;
                        System.out.println(mmm+"nani?"+ix+"adsdsasds"+IChange+"asddsaadsad"+ISlots.size);
                    }
                    if (ix == ISlots.size) {
                        ISlots.add(sheep_meat);
                        whichone = -1;
                    }
                    ix = 0;
                    ICollect=false;
                    IChange = true;
                }
            }
            break;
            case 2: {
            }
            break;
            case 3:{
                if(whichtree[0]==1){
                        dxwood1items = player1.getPosition().x - wood_items.getPosition().x;
                        dywood1items = player1.getPosition().y - wood_items.getPosition().y;
                        xwood1items=dxwood1items;
                        ywood1items=dywood1items;
                        lengthwood1items = Math.sqrt(xwood1items * xwood1items + ywood1items * ywood1items);
                        xwood1items /= lengthwood1items;
                        ywood1items /= lengthwood1items; // normalize (make it 1 unit length)
                        xwood1items *= 7;
                        ywood1items *= 7; // scale to our desired speed
                        if(lengthwood1items>0&&lengthwood1items<=10){
                            wood_items.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            wood_items.setLinearVelocity(0, 0);
                            getwood_items1++;
                            ICollect=true;
                        }
                        if(ICollect) {
                            if (first) {
                                ISlots.add(texturewood_items);
                                first = false;
                            }
                            for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                                if (ISlots.get(mmm).getHeight()==(texturewood_items).getHeight()) IChange = false;
                                if(IChange)ix++;
                            }
                            if (ix == ISlots.size) {
                                ISlots.add(texturewood_items);
                                whichone=-1;
                            }
                            ix = 0;
                            ICollect=false;
                            IChange = true;
                        }
                }
                if(whichtree[1]==2){
                    dxwood2items = player1.getPosition().x - wood_items2.getPosition().x;
                    dywood2items = player1.getPosition().y - wood_items2.getPosition().y;
                    xwood2items=dxwood2items;
                    ywood2items=dywood2items;
                    lengthwood2items = Math.sqrt(xwood2items * xwood2items + ywood2items * ywood2items);
                        xwood2items /= lengthwood2items;
                        ywood2items/= lengthwood2items; // normalize (make it 1 unit length)
                        xwood2items *= 7;
                        ywood2items *= 7; // scale to our desired speed
                        if(lengthwood2items>0&&lengthwood2items<=10){
                            wood_items2.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            wood_items2.setLinearVelocity(0, 0);
                            getwood_items1++;
                            ICollect=true;
                        }
                        if(ICollect) {
                            if (first) {
                                ISlots.add(texturewood_items);
                                first = false;
                            }
                            for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                                if (ISlots.get(mmm).getHeight()==(texturewood_items).getHeight()) IChange = false;
                                if(IChange)ix++;
                            }
                            if (ix == ISlots.size) {
                                ISlots.add(texturewood_items);
                                whichone=-1;
                            }
                            ix = 0;
                            ICollect=false;
                            IChange = true;
                        }
                }
            }
            break;
            case 4:{
                if(whichstone[0]==1){
                    dxStoneitems = player1.getPosition().x - stone_items.getPosition().x;
                    dyStoneitems = player1.getPosition().y - stone_items.getPosition().y;
                    xStoneitems=dxStoneitems;
                    yStoneitems=dyStoneitems;
                    lengthStoneitems = Math.sqrt(xStoneitems * xStoneitems + yStoneitems * yStoneitems);
                    xStoneitems /= lengthStoneitems;
                    yStoneitems /= lengthStoneitems; // normalize (make it 1 unit length)
                    xStoneitems *= 7;
                    yStoneitems *= 7; // scale to our desired speed
                    if(lengthStoneitems>0&&lengthStoneitems<=10){
                        stone_items.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        stone_items.setLinearVelocity(0, 0);
                        getstone_items1++;
                        ICollect=true;
                    }
                    if(ICollect) {
                        if (first) {
                            ISlots.add(rockT);
                            first = false;
                        }
                        for (int mmm = 0; mmm < ISlots.size && !first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==(rockT).getHeight()) IChange = false;
                            if (IChange) ix++;
                            System.out.println("cbcbas"+ix+"cassacas"+IChange+"asasdsa"+ISlots.size);
                        }
                        if (ix == ISlots.size){
                            ISlots.add(rockT);
                            whichone = -1;
                        }
                        ix = 0;
                        ICollect = false;
                        IChange = true;
                    }
                }
                if(whichstone[1]==2){
                    dxStoneitems2 = player1.getPosition().x - stone_items2.getPosition().x;
                    dyStoneitems2 = player1.getPosition().y - stone_items2.getPosition().y;
                    xStoneitems2=dxStoneitems2;
                    yStoneitems2=dyStoneitems2;
                    lengthStoneitems2 = Math.sqrt(xStoneitems2 * xStoneitems2 + yStoneitems2 * yStoneitems2);
                    xStoneitems2 /= lengthStoneitems2;
                    yStoneitems2 /= lengthStoneitems2; // normalize (make it 1 unit length)
                    xStoneitems2 *= 7;
                    yStoneitems2 *= 7; // scale to our desired speed
                    if(lengthStoneitems2>0&&lengthStoneitems2<=10){
                        stone_items2.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        stone_items2.setLinearVelocity(0, 0);
                        getstone_items1++;
                        ICollect=true;
                    }
                    if(ICollect) {
                        if (first) {
                            ISlots.add(rockT);
                            first = false;
                        }
                        for (int mmm = 0; mmm < ISlots.size && !first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==(rockT).getHeight()) IChange = false;
                            if (IChange) ix++;
                        }
                        if (ix == ISlots.size) {
                            ISlots.add(rockT);
                            whichone = -1;
                        }
                        ix = 0;
                        ICollect = false;
                        IChange = true;
                    }
                }
                if(whichstone[2]==3){
                    dxStoneitems3 = player1.getPosition().x - stone_items3.getPosition().x;
                    dyStoneitems3 = player1.getPosition().y - stone_items3.getPosition().y;
                    xStoneitems3=dxStoneitems3;
                    yStoneitems3=dyStoneitems3;
                    lengthStoneitems3 = Math.sqrt(xStoneitems3 * xStoneitems3 + yStoneitems3 * yStoneitems3);
                    xStoneitems3 /= lengthStoneitems3;
                    yStoneitems3 /= lengthStoneitems3; // normalize (make it 1 unit length)
                    xStoneitems3 *= 7;
                    yStoneitems3 *= 7; // scale to our desired speed
                    if(lengthStoneitems3>0&&lengthStoneitems3<=10){
                        stone_items3.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        stone_items3.setLinearVelocity(0, 0);
                        getstone_items1++;
                        ICollect=true;
                    }
                    if(ICollect) {
                        if (first) {
                            ISlots.add(rockT);
                            first = false;
                        }
                        for (int mmm = 0; mmm < ISlots.size && !first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==(rockT).getHeight()) IChange = false;
                            if (IChange) ix++;
                        }
                        if (ix == ISlots.size) {
                            ISlots.add(rockT);
                            whichone = -1;
                        }
                        ix = 0;
                        ICollect = false;
                        IChange = true;
                    }
                }
                if(whichstone[3]==4) {
                    dxStoneitems4 = player1.getPosition( ).x - stone_items4.getPosition( ).x;
                    dyStoneitems4 = player1.getPosition( ).y - stone_items4.getPosition( ).y;
                    xStoneitems4 = dxStoneitems4;
                    yStoneitems4 = dyStoneitems4;
                    lengthStoneitems4 = Math.sqrt(xStoneitems4 * xStoneitems4 + yStoneitems4 * yStoneitems4);
                    xStoneitems4 /= lengthStoneitems4;
                    yStoneitems4 /= lengthStoneitems4; // normalize (make it 1 unit length)
                    xStoneitems4 *= 7;
                    yStoneitems4 *= 7; // scale to our desired speed
                    if (lengthStoneitems4 > 0 && lengthStoneitems4 <= 10) {
                        stone_items4.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        stone_items4.setLinearVelocity(0, 0);
                        getstone_items1++;
                        ICollect=true;
                    }
                    if (ICollect) {
                        if (first) {
                            ISlots.add(rockT);
                            first = false;
                        }
                        for (int mmm = 0; mmm < ISlots.size && !first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==(rockT).getHeight()) IChange = false;
                            if (IChange) ix++;
                        }
                        if (ix == ISlots.size) {
                            ISlots.add(rockT);
                            whichone = -1;
                        }
                        ix = 0;
                        ICollect = false;
                        IChange = true;
                    }
                }
            }
            break;
            default:
                break;
        }
    }

    private void collectitems_respawn(){
        switch (whichone_respawn){
            case 0:{
                for(y_i_respawn =0; y_i_respawn <rat_items_respawn.size; y_i_respawn++){
                    dxratitems_respawn = player1.getPosition().x - rat_items_respawn.get(y_i_respawn).getPosition().x;
                    dyratitems_respawn = player1.getPosition().y - rat_items_respawn.get(y_i_respawn).getPosition().y;
                    xratitems_respawn=dxratitems_respawn;
                    yratitems_respawn=dyratitems_respawn;
                    lengthratitems_respawn = Math.sqrt(xratitems_respawn * xratitems_respawn + yratitems_respawn * yratitems_respawn);
                    xratitems_respawn /= lengthratitems_respawn;
                    yratitems_respawn /= lengthratitems_respawn; // normalize (make it 1 unit length)
                    xratitems_respawn *= 7;
                    yratitems_respawn *= 7; // scale to our desired speed
                    if(lengthratitems_respawn>0&&lengthratitems_respawn<=10){
                        System.out.println("get rat items"+ y_i_respawn);
                        rat_items_respawn.get(y_i_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        rat_items_respawn.get(y_i_respawn).setLinearVelocity(0, 0);
                        array_xrat_respawn.set(y_i_respawn,rat_items_respawn.get(y_i_respawn).getPosition().x);
                        getrat_items++;
                        ICollect=true;
                    }
                    if(ICollect) {
                        for (int mmm = 0; mmm < ISlots.size &&!first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==(rat_meat).getHeight()) IChange = false;
                            if(IChange)ix++;
                        }
                        if (ix == ISlots.size) {
                            ISlots.add(rat_meat);
                            ix = 0;
                            whichone=-1;
                        }
                        ICollect=false;
                        IChange = true;
                    }
                }
            }
            break;
            case 1:
            {
                for(y_sheep_respawn =0; y_sheep_respawn <sheep_items_respawn.size; y_sheep_respawn++){
                    dxsheepitems_respawn = player1.getPosition().x - sheep_items_respawn.get(y_sheep_respawn).getPosition().x;
                    dysheepitems_respawn = player1.getPosition().y - sheep_items_respawn.get(y_sheep_respawn).getPosition().y;
                    xsheepitems_respawn=dxsheepitems_respawn;
                    ysheepitems_respawn=dysheepitems_respawn;
                    lengthsheepitems_respawn = Math.sqrt(xsheepitems_respawn * xsheepitems_respawn + ysheepitems_respawn * ysheepitems_respawn);
                    xsheepitems_respawn /= lengthsheepitems_respawn;
                    ysheepitems_respawn /= lengthsheepitems_respawn; // normalize (make it 1 unit length)
                    xsheepitems_respawn *= 7;
                    ysheepitems_respawn *= 7; // scale to our desired speed
                    if(lengthsheepitems_respawn>0&&lengthsheepitems_respawn<=10){
                        System.out.println("get sheep items"+ y_sheep_respawn);
                        sheep_items_respawn.get(y_sheep_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                        sheep_items_respawn.get(y_sheep_respawn).setLinearVelocity(0, 0);
                        array_xsheep_respawn.set(y_sheep_respawn,sheep_items_respawn.get(y_sheep_respawn).getPosition().x);
                        getsheep_meat++;
                        ICollect=true;
                    }
                    if(ICollect) {
                        for (int mmm = 0; mmm < ISlots.size&&!first; mmm++) {
                            if (ISlots.get(mmm).getHeight()==( sheep_meat).getHeight()) IChange = false;
                            if(IChange)ix++;
                            System.out.println(mmm+"nani?"+ix+"adsdsasds"+IChange+"asddsaadsad"+ISlots.size);
                        }
                        if (ix == ISlots.size) {
                            ISlots.add(sheep_meat);
                            whichone = -1;
                        }
                        ix = 0;
                        ICollect=false;
                        IChange = true;
                    }
                }
            }
            break;
            case 2: {
            }
            break;
            case 3:{
                if(whichtree_respawn[0]==1){
                    for(y_wood1_respawn =0; y_wood1_respawn <wood_items_respawn.size; y_wood1_respawn++){
                        dxwood1items_respawn = player1.getPosition().x - wood_items_respawn.get(y_wood1_respawn).getPosition().x;
                        dywood1items_respawn = player1.getPosition().y - wood_items_respawn.get(y_wood1_respawn).getPosition().y;
                        xwood1items_respawn=dxwood1items_respawn;
                        ywood1items_respawn=dywood1items_respawn;
                        lengthwood1items_respawn = Math.sqrt(xwood1items_respawn * xwood1items_respawn + ywood1items_respawn * ywood1items_respawn);
                        xwood1items_respawn /= lengthwood1items_respawn;
                        ywood1items_respawn /= lengthwood1items_respawn; // normalize (make it 1 unit length)
                        xwood1items_respawn *= 7;
                        ywood1items_respawn *= 7; // scale to our desired speed
                        if(lengthwood1items_respawn>0&&lengthwood1items_respawn<=10){
                            System.out.println("get wood(1) items"+ y_wood1_respawn);
                            wood_items_respawn.get(y_wood1_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            wood_items_respawn.get(y_wood1_respawn).setLinearVelocity(0, 0);
                            array_xwood1_respawn.set(y_wood1_respawn,wood_items_respawn.get(y_wood1_respawn).getPosition().x);
                            getwood_items1++;
                        }
                    }
                }
                if(whichtree_respawn[1]==2){
                    for(y_wood2_respawn =0; y_wood2_respawn <wood_items2_respawn.size; y_wood2_respawn++){
                        dxwood2items_respawn = player1.getPosition().x - wood_items2_respawn.get(y_wood2_respawn).getPosition().x;
                        dywood2items_respawn = player1.getPosition().y - wood_items2_respawn.get(y_wood2_respawn).getPosition().y;
                        xwood2items_respawn=dxwood2items_respawn;
                        ywood2items_respawn=dywood2items_respawn;
                        lengthwood2items_respawn = Math.sqrt(xwood2items_respawn * xwood2items_respawn + ywood2items_respawn * ywood2items_respawn);
                        xwood2items_respawn /= lengthwood1items_respawn;
                        ywood2items_respawn /= lengthwood1items_respawn; // normalize (make it 1 unit length)
                        xwood2items_respawn *= 7;
                        ywood2items_respawn *= 7; // scale to our desired speed
                        if(lengthwood2items_respawn>0&&lengthwood2items_respawn<=10){
                            System.out.println("get wood(1) items"+ y_wood2_respawn);
                            wood_items2_respawn.get(y_wood2_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            wood_items2_respawn.get(y_wood2_respawn).setLinearVelocity(0, 0);
                            array_xwood2_respawn.set(y_wood2_respawn,wood_items2_respawn.get(y_wood2_respawn).getPosition().x);
                            getwood_items1++;
                        }
                    }
                }
            }
            break;
            case 4:{
                if(whichstone_respawn[0]==1){
                    for(y_stone1_respawn =0; y_stone1_respawn <stone_items_respawn.size; y_stone1_respawn++){
                        dxStoneitems1_respawn = player1.getPosition().x - stone_items_respawn.get(y_stone1_respawn).getPosition().x;
                        dyStoneitems1_respawn = player1.getPosition().y - stone_items_respawn.get(y_stone1_respawn).getPosition().y;
                        xStoneitems1_respawn=dxStoneitems1_respawn;
                        yStoneitems1_respawn=dxStoneitems1_respawn;
                        lengthStoneitems1_respawn = Math.sqrt(xStoneitems1_respawn * xStoneitems1_respawn + yStoneitems1_respawn * yStoneitems1_respawn);
                        xStoneitems1_respawn /= lengthStoneitems1_respawn;
                        yStoneitems1_respawn /= lengthStoneitems1_respawn; // normalize (make it 1 unit length)
                        xStoneitems1_respawn *= 7;
                        yStoneitems1_respawn *= 7; // scale to our desired speed
                        if(lengthStoneitems1_respawn>0&&lengthStoneitems1_respawn<=10){
                            System.out.println("get stone(1) items"+ y_stone1_respawn);
                            stone_items_respawn.get(y_stone1_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            stone_items_respawn.get(y_stone1_respawn).setLinearVelocity(0, 0);
                            array_xstone1_respawn.set(y_stone1_respawn,stone_items_respawn.get(y_stone1_respawn).getPosition().x);
                            getstone_items1++;
                        }
                    }
                }
                if(whichstone_respawn[1]==2){
                    for(y_stone2_respawn =0; y_stone2_respawn <stone_items2_respawn.size; y_stone2_respawn++){
                        dxStoneitems2_respawn = player1.getPosition().x - stone_items2_respawn.get(y_stone2_respawn).getPosition().x;
                        dyStoneitems2_respawn = player1.getPosition().y - stone_items2_respawn.get(y_stone2_respawn).getPosition().y;
                        xStoneitems2_respawn=dxStoneitems2_respawn;
                        yStoneitems2_respawn=dxStoneitems2_respawn;
                        lengthStoneitems2_respawn = Math.sqrt(xStoneitems2_respawn * xStoneitems2_respawn + yStoneitems2_respawn * yStoneitems2_respawn);
                        xStoneitems2_respawn /= lengthStoneitems2_respawn;
                        yStoneitems2_respawn /= lengthStoneitems2_respawn; // normalize (make it 1 unit length)
                        xStoneitems2_respawn *= 7;
                        yStoneitems2_respawn *= 7; // scale to our desired speed
                        if(lengthStoneitems2_respawn>0&&lengthStoneitems2_respawn<=10){
                            System.out.println("get stone(1) items"+ y_stone2_respawn);
                            stone_items2_respawn.get(y_stone2_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            stone_items2_respawn.get(y_stone2_respawn).setLinearVelocity(0, 0);
                            array_xstone2_respawn.set(y_stone2_respawn,stone_items2_respawn.get(y_stone2_respawn).getPosition().x);
                            getstone_items1++;
                        }
                    }
                }
                if(whichstone_respawn[2]==3){
                    for(y_stone3_respawn =0; y_stone3_respawn <stone_items3_respawn.size; y_stone3_respawn++){
                        dxStoneitems3_respawn = player1.getPosition().x - stone_items3_respawn.get(y_stone3_respawn).getPosition().x;
                        dyStoneitems3_respawn = player1.getPosition().y - stone_items3_respawn.get(y_stone3_respawn).getPosition().y;
                        xStoneitems3_respawn=dxStoneitems3_respawn;
                        yStoneitems3_respawn=dxStoneitems3_respawn;
                        lengthStoneitems3_respawn = Math.sqrt(xStoneitems3_respawn * xStoneitems3_respawn + yStoneitems3_respawn * yStoneitems3_respawn);
                        xStoneitems3_respawn /= lengthStoneitems3_respawn;
                        yStoneitems3_respawn /= lengthStoneitems3_respawn; // normalize (make it 1 unit length)
                        xStoneitems3_respawn *= 7;
                        yStoneitems3_respawn *= 7; // scale to our desired speed
                        if(lengthStoneitems3_respawn>0&&lengthStoneitems3_respawn<=10){
                            System.out.println("get stone(1) items"+ y_stone1_respawn);
                            stone_items3_respawn.get(y_stone3_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            stone_items3_respawn.get(y_stone3_respawn).setLinearVelocity(0, 0);
                            array_xstone3_respawn.set(y_stone3_respawn,stone_items3_respawn.get(y_stone3_respawn).getPosition().x);
                            getstone_items1++;
                        }
                    }
                }
                if(whichstone_respawn[3]==4){
                    for(y_stone4_respawn =0; y_stone4_respawn <stone_items4_respawn.size; y_stone4_respawn++) {
                        dxStoneitems4_respawn = player1.getPosition( ).x - stone_items4_respawn.get(y_stone4_respawn).getPosition( ).x;
                        dyStoneitems4_respawn = player1.getPosition( ).y - stone_items4_respawn.get(y_stone4_respawn).getPosition( ).y;
                        xStoneitems4_respawn = dxStoneitems4_respawn;
                        yStoneitems4_respawn = dxStoneitems4_respawn;
                        lengthStoneitems4_respawn = Math.sqrt(xStoneitems4_respawn * xStoneitems4_respawn + yStoneitems4_respawn * yStoneitems4_respawn);
                        xStoneitems4_respawn /= lengthStoneitems4_respawn;
                        yStoneitems4_respawn /= lengthStoneitems4_respawn; // normalize (make it 1 unit length)
                        xStoneitems4_respawn *= 7;
                        yStoneitems4_respawn *= 7; // scale to our desired speed
                        if (lengthStoneitems4_respawn > 0 && lengthStoneitems4_respawn <= 10) {
                            System.out.println("get stone(4) items" + y_stone4_respawn);
                            stone_items4_respawn.get(y_stone4_respawn).setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                            stone_items4_respawn.get(y_stone4_respawn).setLinearVelocity(0, 0);
                            array_xstone4_respawn.set(y_stone4_respawn, stone_items4_respawn.get(y_stone4_respawn).getPosition( ).x);
                            getstone_items1++;
                        }
                    }
                }
            }
            break;
            default:
                break;
        }
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
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
        font.dispose();
        FontGenerator.dispose();
    }
      private void respawn() {
        stateTime+=Gdx.graphics.getRawDeltaTime();
        if(stateTime>=timerespawn_rat)
         if(respawntime_rat){
             stateTime=0;
             respawntime_rat=false;
             respawnreload=true;
             Rat rat=new Rat(world);
             ratbody_respawn=rat.getBody();
             ratbody_respawn.setGravityScale(0);
             movesides_respawn=true;
             moveright_respawn=true;
             moveleft_respawn=false;
             activefollowsystem_respawn=false;
             enableanimatonrat_respawn=false;
             animationright_rat_respawn=new Animation(1/3f,atlasright_rat.getRegions());
             animationleft_rat_respawn=new Animation(1/3f,atlasleft_rat.getRegions());
             aniamtionup_rat_respawn=new Animation(1/3f,atlasup_rat.getRegions());
             animationdown_rat_respawn=new Animation(1/3f,atlasdown_rat.getRegions());
         }
         if(stateTime>=timerespawn_goblin)
              if(respawntime_goblin){
             stateTime=0;
             respawntime_goblin=false;
             respawnreload_goblin=true;
                  Reacon reacon=new Reacon(world);
                  goblinbody_respawn =reacon.getBody();
                  goblinbody_respawn.setGravityScale(0);
                  movesidesgoblin_respawn=true;
                  moverightgoblin_respawn=true;
                  moveleftgoblin_respawn=false;
                  activefollowsystemgoblin_respawn =false;
                  enableanimatongoblin_respawn =false;
                  animationright_goblin_respawn=new Animation(1/3f,atlasright_goblin.getRegions());
                  animationleft_goblin_respawn=new Animation(1/3f,atlasleft_goblin.getRegions());
                  aniamtionup_goblin_respawn=new Animation(1/3f,atlasup_goblin.getRegions());
                  animationdown_goblin_respawn=new Animation(1/3f,atlasdown_goblin.getRegions());
                  respawnmove_goblin();
                  respawncheck_goblin();
              }
          if(stateTime>=timerespawn_sheep)
              if(respawntime_sheep) {
                  stateTime = 0;
                  respawnreload_sheep=true;
                  respawntime_sheep = false;
                  Sheep sheep = new Sheep(world);
                  sheepBody_respawn = sheep.getBody();
                  sheepBody_respawn.setGravityScale(0);
                  movesidessheep_respawn=true;
                  moverightsheep_respawn=true;
                  moveleftsheep_respawn=false;
                  activefollowsystemsheep_respawn =false;
                  enableanimatonsheep_respawn =false;
                  animationright_sheep_respawn=new Animation(1/3f,atlasright_sheep.getRegions());
                  animationleft_sheep_respawn=new Animation(1/3f,atlasleft_sheep.getRegions());
                  aniamtionup_sheep_respawn=new Animation(1/3f,atlasup_sheep.getRegions());
                  animationdown_sheep_respawn=new Animation(1/3f,atlasdown_sheep.getRegions());
                  respawnmove_sheep();
                  respawncheck_sheep();
              }
           if(stateTime>=timerespawn_wood) {
               if (respawntime_wood) {
                   stateTime=0;
                   respawntime_wood=false;
                   respawnreload_wood=true;
                   tree_brick=new Tree_Brick(world,1);
                   tree_brickbody_respawn=tree_brick.getBody();
                   tree_brickbody_respawn.setGravityScale(0);
                   Check_Tree1_respawn();
               }
               if(respawntime_wood2){
                   stateTime=0;
                   respawntime_wood2=false;
                   respawnreload_wood2=true;
                   tree_brick=new Tree_Brick(world,1,"hi");
                   tree_brickbody2_respawn=tree_brick.getBody2();
                   tree_brickbody2_respawn.setGravityScale(0);
                   Check_Tree2_respawn();
               }
           }
           if(stateTime>=timerespawn_stone){
              if(respawntime_stone){
                  stateTime=0;
                  respawntime_stone=false;
                  respawnreload_stone=true;
                  stone_brick=new Stone_brick(world,1);
                  Stone_Brickbody1_respawn= stone_brick.getBody();
                  Stone_Brickbody1_respawn.setGravityScale(0);
                  Check_stone1_respawn();
              }
              if(respawntime_stone2){
                  stateTime=0;
                  respawntime_stone2=false;
                  respawnreload_stone2=true;
                  stone_brick=new Stone_brick(world,"a");
                  Stone_Brickbody2_respawn= stone_brick.getBody2();
                  Stone_Brickbody2_respawn.setGravityScale(0);
                  Check_stone2_respawn();
              }
              if(respawntime_stone3){
                  stateTime=0;
                  respawntime_stone3=false;
                  respawnreload_stone3=true;
                  stone_brick=new Stone_brick(world,true);
                  Stone_Brickbody3_respawn= stone_brick.getBody3();
                  Stone_Brickbody3_respawn.setGravityScale(0);
                  Check_stone3_respawn();
              }
              if(respawntime_stone4){
                  stateTime=0;
                  respawntime_stone4=false;
                  respawnreload_stone4=true;
                  stone_brick=new Stone_brick(world,1,true);
                  Stone_Brickbody4_respawn= stone_brick.getBody4();
                  Stone_Brickbody4_respawn.setGravityScale(0);
                  Check_stone4_respawn();
              }
           }
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

    private void update() {
        world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
        checkall();
        Buildeverything();
    }
    private void checkall(){
        checkfish();
        movesideRat();
        checkrat();
        move_Reacon();
        move_Sheep();
        if(respawnreload)
            respawnmove_rat();
        if(respawnreload_goblin)respawnmove_goblin();
        if(respawnreload_sheep)respawnmove_sheep();
        checkReacon();
        checkSheep();
        Check_stone1();
        Check_stone2();
        Check_stone3();
        Check_stone4();
        if(respawnreload_stone)Check_stone1_respawn();
        if(respawnreload_stone2)Check_stone2_respawn();
        if(respawnreload_stone3)Check_stone3_respawn();
        if(respawnreload_stone4)Check_stone4_respawn();
        Check_Tree1();
        Check_Tree2();
        if(respawnreload_wood)Check_Tree1_respawn();
        if(respawnreload_wood2)Check_Tree2_respawn();
         if(respawnreload)respawncheck_rat();
         if(respawnreload_goblin)respawncheck_goblin();
         if(respawnreload_sheep)respawncheck_sheep();
         checkDenter();
    }

    private void checkfish() {
        float dxF ;
        dxF= player1.getPosition().x - FishPool.getPosition().x;
        float dyF ;
        dyF= player1.getPosition().y - FishPool.getPosition().y;
        double lengthF ;
        lengthF = Math.sqrt(dxF * dxF + dyF * dyF);
        dxF /= lengthF;
        dyF /= lengthF; // normalize (make it 1 unit length)
        dxF *= 10;
        dyF *= 10;
        if(lengthF>=0&&lengthF<=20&&myinputproccer.isHitenable()) {
            timehit++;
            if (timehit >2f*20) {
                timehit = 0;
                ICollect=true;
                IChange=true;
                ix=0;
                getfish_items++;
                if(ICollect) {
                    if (first) {
                        ISlots.add(FishT);
                        first = false;
                    }
                    for (int mmm1 = 0; mmm1 < ISlots.size &&!first; mmm1++) {
                        if (ISlots.get(mmm1).getHeight()==(FishT).getHeight()) IChange = false;
                        if(IChange)ix++;
                    }
                    if (ix == (ISlots.size)) {
                        ISlots.add(FishT);
                        ix = 0;
                    }
                    ICollect=false;
                    IChange = true;
                }
            }
        }
    }

    private void Buildeverything(){
        if (myinputproccer.isTestbuild())Build(stone);
        if (myinputproccer.isTestbuild())BuildT(tree);
    }
    private void worldcheck() {
        //0 playing
        //1 Stats
        //2
        //3
        //4
        batch=new SpriteBatch();
        FontGenerator =new FreeTypeFontGenerator(Gdx.files.internal("Courier New Italic font.ttf"));
        FontParameter =new FreeTypeFontGenerator.FreeTypeFontParameter();
        FontParameter.size=20;
        FontParameter.characters="_-abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.!'()>?";
        font4 = FontGenerator.generateFont(FontParameter);
        font4.setColor(Color.BLACK);
        FontGenerator.dispose();
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
        x_list=new ArrayList<Integer>();
        y_list=new ArrayList<Integer>();
        player = new Player(world,160,81*8);
        player1 = player.getBody();
        Rat rat=new Rat(world);
        ratbody=rat.getBody();
        ratbody.setGravityScale(0);
        Sheep sheep=new Sheep(world);
        sheepBody=sheep.getBody();
        sheepBody.setGravityScale(0);
        Reacon reacon=new Reacon(world);
        goblinbody =reacon.getBody();
        goblinbody.setGravityScale(0);
        stone_brick=new Stone_brick(world);
        Stone_Brickbody1= stone_brick.getBody();
        Stone_Brickbody1.setGravityScale(0);
        Stone_Brickbody2= stone_brick.getBody2();
        Stone_Brickbody2.setGravityScale(0);
        Stone_Brickbody3= stone_brick.getBody3();
        Stone_Brickbody3.setGravityScale(0);
        Stone_Brickbody4= stone_brick.getBody4();
        Stone_Brickbody4= stone_brick.getBody4();
        Stone_Brickbody4.setGravityScale(0);
        tree_brick=new Tree_Brick(world);
        tree_brickbody=tree_brick.getBody();
        tree_brickbody.setGravityScale(0);
        tree_brickbody2=tree_brick.getBody2();
        tree_brickbody2.setGravityScale(0);
        blockstone=new Body[100];
        blocktree=new Body[100];
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
        array_xrat_respawn =new Array<Float>();
        array_yrat_respawn =new Array<Float>();
        rat_items_respawn=new Array<Body>();
        array_xsheep_respawn =new Array<Float>();
        array_ysheep_respawn =new Array<Float>();
        sheep_items_respawn=new Array<Body>();
        stone_items_respawn=new Array<Body>();
        array_xstone1_respawn=new Array<Float>();
        array_ystone1_respawn=new Array<Float>();
        stone_items2_respawn=new Array<Body>();
        array_xstone2_respawn=new Array<Float>();
        array_ystone2_respawn=new Array<Float>();
        stone_items3_respawn=new Array<Body>();
        array_xstone3_respawn=new Array<Float>();
        array_ystone3_respawn=new Array<Float>();
        stone_items4_respawn=new Array<Body>();
        array_xstone4_respawn=new Array<Float>();
        array_ystone4_respawn=new Array<Float>();
        wood_items_respawn=new Array<Body>();
        array_xwood1_respawn=new Array<Float>();
        array_ywood1_respawn=new Array<Float>();
        wood_items2_respawn=new Array<Body>();
        array_xwood2_respawn=new Array<Float>();
        array_ywood2_respawn=new Array<Float>();
        invertoy_backgroundT=new Texture("background_invertoy.jpg");
        rockT=new Texture("items/rock.png");
        woodT=new Texture("items/wood_type.jpg");
        HungerBar=new Texture("ManaBar.png");
        whichone=-1;
        whichstone=new int[5];
        whichtree=new int[5];
        whichone_respawn=-1;
        whichstone_respawn=new int[5];
        whichtree_respawn=new int[5];
        Fish=new Fish(world);
        FishPool=Fish.getBody();
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
        DEnter=D.getBody();
        for(int i19=0;i19<3;i19++){
            ontimerooten.add(false);
        }
        howmanytimes_lefttoadd =level- level_Main;
        Main_reduce=level- level_Main;
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
        for(int i=0;i<6;i++) {
            SlotBuildSpace_X[i] = (w/2+72+45*i)*ascept_width;
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
    private void checkDenter(){
        dx_d= player1.getPosition().x - DEnter.getPosition().x;
        dy_D = player1.getPosition().y - DEnter.getPosition().y;
        length_D = Math.sqrt(dx_d * dx_d + dy_D * dy_D);
        if(length_D>=0&&length_D<=30){
            System.out.println("hmmmm");
           game.Dungeon_change(ISlots,1,Health,Level,ItemsCollect,first,hungers,stats);
        }
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
    private void BuildT(int tree1) {
        if(getwood_items1!=0)
            if(getwood_items1/4==1) {
                getwood_items1 -= 4;
                 tree_brick = new Tree_Brick(player1.getWorld(), player1.getPosition().x, player1.getPosition().y);
                bodybeforetree = tree_brick.getBodyB();
                bodybeforetree.setGravityScale(0);
                System.out.println("okkkk1 2 3  "+(int)player1.getPosition().x+" "+(int) bodybeforetree.getPosition().x);
                blocktree[placetree]= bodybeforetree;
                placetree++;
            }
    }
    public void Build(int stone1) {
        if(getstone_items1!=0)
            if(getstone_items1/4==1) {
                getstone_items1 -= 4;
                stone_brick = new Stone_brick(player1.getWorld(), player1.getPosition().x, player1.getPosition().y);
                bodybeforestone = stone_brick.getBodyB();
                bodybeforestone.setGravityScale(0);
                System.out.println("okkkk1   "+(int)player1.getPosition().x+" "+(int) bodybeforestone.getPosition().x);
                blockstone[placestone]= bodybeforestone;
                placestone++;
            }
    }
    private void Check_Tree2() {
        dx8 = player1.getPosition().x - tree_brickbody2.getPosition().x;
        dy8 = player1.getPosition().y - tree_brickbody2.getPosition().y;
        lengthTree2 = Math.sqrt(dx8 * dx8 + dy8 * dy8);
        if(lengthTree2>=0&&lengthTree2<=30&&myinputproccer.isHitenable()) {
            timehit6++;
            if(timehit6>2f&&i6<=5){
                i6++;
                timehit6=0;
                tree++;
            }
            if (timehit6 >10f&&i6>5) {
                whichone=3;
                whichtree[1]=2;
                throw_wood2=new Throw_items(world,tree_brickbody2.getPosition().x,tree_brickbody2.getPosition().y,whichone);
                tree_brickbody2.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                tree_brickbody2.setLinearVelocity(0, 0);
                timehit6 = 0;
                i6=0;
                respawntime_wood2=true;
            }
        }
    }

    private void Check_Tree1() {
        dx7 = player1.getPosition().x - tree_brickbody.getPosition().x;
        dy7 = player1.getPosition().y - tree_brickbody.getPosition().y;
        lengthTree = Math.sqrt(dx7 * dx7 + dy7 * dy7);
        if(lengthTree>=0&&lengthTree<=30&&myinputproccer.isHitenable()) {
            timehit5++;
            if(timehit5>2f&&i5<=5){
                i5++;
                timehit5=0;
                tree++;
            }
            if (timehit5 >10f&&i5>5) {
                whichone=3;
                whichtree[0]=1;
                throw_wood=new Throw_items(world,tree_brickbody.getPosition().x,tree_brickbody.getPosition().y,whichone);
                tree_brickbody.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                tree_brickbody.setLinearVelocity(0, 0);
                timehit5 = 0;
                i5=0;
                respawntime_wood=true;
            }
        }
    }

    private void Check_stone1(){
        dx3 = player1.getPosition().x - Stone_Brickbody1.getPosition().x;
        dy3 = player1.getPosition().y - Stone_Brickbody1.getPosition().y;
        lengthBrick = Math.sqrt(dx3 * dx3 + dy3 * dy3);
        if(lengthBrick>=0&&lengthBrick<=20&&myinputproccer.isHitenable()) {
            timehit++;
            if(timehit>3f&&i<=5){
                i++;
                timehit=0;
                stone++;
            }
            if (timehit >15f&&i>5) {
                whichone=4;
                whichstone[0]=1;
                throw_stone=new Throw_items(world,Stone_Brickbody1.getPosition().x,Stone_Brickbody1.getPosition().y,whichone);
                Stone_Brickbody1.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody1.setLinearVelocity(0, 0);
                timehit = 0;
                i=0;
                respawntime_stone=true;
            }
        }
    }

    private void Check_stone2(){
        dx4 = player1.getPosition().x - Stone_Brickbody2.getPosition().x;
        dy4 = player1.getPosition().y - Stone_Brickbody2.getPosition().y;
        lengthBrick2 = Math.sqrt(dx4 * dx4 + dy4 * dy4);
        if(lengthBrick2>=0&&lengthBrick2<=20&&myinputproccer.isHitenable()) {
            timehit2++;
            if(timehit2>3f&&i2<=5){
                i2++;
                timehit2=0;
                stone++;
            }
            if (timehit2 >15f&&i2>5) {
                whichone=4;
                whichstone[1]=2;
                throw_stone2=new Throw_items(world,Stone_Brickbody2.getPosition().x,Stone_Brickbody2.getPosition().y,whichone);
                Stone_Brickbody2.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody2.setLinearVelocity(0, 0);
                timehit2 = 0;
                i2=0;
                respawntime_stone2=true;
            }
        }
    }
    private void Check_stone3(){
        dx5 = player1.getPosition().x - Stone_Brickbody3.getPosition().x;
        dy5 = player1.getPosition().y - Stone_Brickbody3.getPosition().y;
        lengthBrick3 = Math.sqrt(dx5 * dx5 + dy5 * dy5);
        if(lengthBrick3>=0&&lengthBrick3<=20&&myinputproccer.isHitenable()) {
            timehit3++;
            if(timehit3>3f&&i3<=5){
                i3++;
                timehit3=0;
                stone++;
            }
            if (timehit3 >15f&&i3>5) {
                whichone=4;
                whichstone[2]=3;
                throw_stone3=new Throw_items(world,Stone_Brickbody3.getPosition().x,Stone_Brickbody3.getPosition().y,whichone);
                Stone_Brickbody3.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody3.setLinearVelocity(0, 0);
                timehit3 = 0;
                i3=0;
                respawntime_stone3=true;
            }
        }
    }
    private void Check_stone4(){
        dx6 = player1.getPosition().x - Stone_Brickbody4.getPosition().x;
        dy6 = player1.getPosition().y - Stone_Brickbody4.getPosition().y;
        lengthBrick4 = Math.sqrt(dx6 * dx6 + dy6 * dy6);
        if(lengthBrick4>=0&&lengthBrick4<=20&&myinputproccer.isHitenable()) {
            timehit4++;
            if(timehit4>3f&&i4<=5){
                i4++;
                timehit4=0;
                stone++;
            }
            if (timehit4 >15f&&i4>5) {
                whichone=4;
                whichstone[3]=4;
                throw_stone4=new Throw_items(world,Stone_Brickbody4.getPosition().x,Stone_Brickbody4.getPosition().y,whichone);
                Stone_Brickbody4.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody4.setLinearVelocity(0, 0);
                timehit4 = 0;
                i4=0;
                respawntime_stone4=true;
            }
        }
    }
     //respawn(stones,tree)
     private void Check_Tree2_respawn() {
         dx8_respawn = player1.getPosition().x - tree_brickbody2_respawn.getPosition().x;
         dy8_respawn = player1.getPosition().y - tree_brickbody2_respawn.getPosition().y;
         lengthTree2_respawn = Math.sqrt(dx8_respawn * dx8_respawn + dy8_respawn * dy8_respawn);
         if(lengthTree2_respawn>=0&&lengthTree2_respawn<=30&&myinputproccer.isHitenable()) {
             timehit6_respawn++;
             if(timehit6_respawn>2f&&i6_respawn<=5){
                 i6_respawn++;
                 timehit6_respawn=0;
                 tree++;
             }
             if (timehit6_respawn>10f&&i6_respawn>5) {
                 whichone_respawn=3;
                 whichtree_respawn[1]=2;
                 onetime_wood2=true;
                 array_xwood2_respawn.add(tree_brickbody2_respawn.getPosition().x);
                 array_ywood2_respawn.add(tree_brickbody2_respawn.getPosition().y);
                 throw_wood2_respawn=new Throw_items(world,tree_brickbody2_respawn.getPosition().x,tree_brickbody2_respawn.getPosition().y,whichone_respawn);
                 tree_brickbody2_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                 tree_brickbody2_respawn.setLinearVelocity(0, 0);
                 timehit6_respawn = 0;
                 i6_respawn=0;
                 respawntime_wood2=true;
             }
         }
     }

    private void Check_Tree1_respawn() {
        dx7_respawn = player1.getPosition().x - tree_brickbody_respawn.getPosition().x;
        dy7_respawn = player1.getPosition().y - tree_brickbody_respawn.getPosition().y;
        lengthTree_respawn = Math.sqrt(dx7_respawn * dx7_respawn + dy7_respawn * dy7_respawn);
        if(lengthTree_respawn>=0&&lengthTree_respawn<=30&&myinputproccer.isHitenable()) {
            timehit5_respawn++;
            if(timehit5_respawn>2f&&i5_respawn<=5){
                i5_respawn++;
                timehit5_respawn=0;
                tree++;
            }
            if (timehit5_respawn >10f&&i5_respawn>5) {
                whichone_respawn=3;
                whichtree_respawn[0]=1;
                onetime_wood=true;
                array_xwood1_respawn.add(tree_brickbody_respawn.getPosition().x);
                array_ywood1_respawn.add(tree_brickbody_respawn.getPosition().y);
                throw_wood_respawn=new Throw_items(world,tree_brickbody_respawn.getPosition().x,tree_brickbody_respawn.getPosition().y,whichone_respawn);
                tree_brickbody_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                tree_brickbody_respawn.setLinearVelocity(0, 0);
                timehit5_respawn = 0;
                i5_respawn=0;
                respawntime_wood=true;
            }
        }
    }

    private void Check_stone1_respawn(){
        dx3_respawn = player1.getPosition().x - Stone_Brickbody1_respawn.getPosition().x;
        dy3_respawn = player1.getPosition().y - Stone_Brickbody1_respawn.getPosition().y;
        lengthBrick_respawn = Math.sqrt(dx3_respawn * dx3_respawn + dy3_respawn * dy3_respawn);
        if(lengthBrick_respawn>=0&&lengthBrick_respawn<=20&&myinputproccer.isHitenable()) {
            timehit1_respawn++;
            if(timehit1_respawn>3f&&i_respawn<=5){
                i_respawn++;
                timehit1_respawn=0;
                stone++;
            }
            if (timehit1_respawn >15f&&i_respawn>5) {
                whichone_respawn=4;
                whichstone_respawn[0]=1;
                onetime_stone=true;
                System.out.println("Stone 1");
                array_xstone1_respawn.add(Stone_Brickbody1_respawn.getPosition().x);
                array_ystone1_respawn.add(Stone_Brickbody1_respawn.getPosition().y);
                throw_stone_respawn=new Throw_items(world,Stone_Brickbody1_respawn.getPosition().x,Stone_Brickbody1_respawn.getPosition().y,whichone_respawn);
                Stone_Brickbody1_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody1_respawn.setLinearVelocity(0, 0);
                timehit1_respawn = 0;
                i_respawn=0;
                respawntime_stone=true;
            }
        }
    }
    private void Check_stone2_respawn(){
        dx4_respawn = player1.getPosition().x - Stone_Brickbody2_respawn.getPosition().x;
        dy4_respawn = player1.getPosition().y - Stone_Brickbody2_respawn.getPosition().y;
        lengthBrick2_respawn = Math.sqrt(dx4_respawn * dx4_respawn + dy4_respawn * dy4_respawn);
        if(lengthBrick2_respawn>=0&&lengthBrick2_respawn<=20&&myinputproccer.isHitenable()) {
            timehit2_respawn++;
            if(timehit2_respawn>3f&&i2_respawn<=5){
                i2_respawn++;
                timehit2_respawn=0;
                stone++;
            }
            if (timehit2_respawn >15f&&i2_respawn>5) {
                whichone_respawn=4;
                whichstone_respawn[1]=2;
                onetime_stone2=true;
                System.out.println("Stone 2");
                array_xstone2_respawn.add(Stone_Brickbody2_respawn.getPosition().x);
                array_ystone2_respawn.add(Stone_Brickbody2_respawn.getPosition().y);
                throw_stone2_respawn=new Throw_items(world,Stone_Brickbody2_respawn.getPosition().x,Stone_Brickbody2_respawn.getPosition().y,whichone_respawn);
                Stone_Brickbody2_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody2_respawn.setLinearVelocity(0, 0);
                timehit2_respawn = 0;
                i2_respawn=0;
                respawntime_stone2=true;
            }
        }
    }
    private void Check_stone3_respawn(){
        dx5_respawn = player1.getPosition().x - Stone_Brickbody3_respawn.getPosition().x;
        dy5_respawn = player1.getPosition().y - Stone_Brickbody3_respawn.getPosition().y;
        lengthBrick3_respawn = Math.sqrt(dx5_respawn* dx5_respawn + dy5_respawn * dy5_respawn);
        if(lengthBrick3_respawn>=0&&lengthBrick3_respawn<=20&&myinputproccer.isHitenable()) {
            timehit3_respawn++;
            if(timehit3_respawn>3f&&i3_respawn<=5){
                i3_respawn++;
                timehit3_respawn=0;
                stone++;
            }
            if (timehit3_respawn >15f&&i3_respawn>5) {
                whichone_respawn=4;
                whichstone_respawn[2]=3;
                onetime_stone3=true;
                System.out.println("Stone 3");
                array_xstone3_respawn.add(Stone_Brickbody3_respawn.getPosition().x);
                array_ystone3_respawn.add(Stone_Brickbody3_respawn.getPosition().y);
                throw_stone3_respawn=new Throw_items(world,Stone_Brickbody3_respawn.getPosition().x,Stone_Brickbody3_respawn.getPosition().y,whichone_respawn);
                Stone_Brickbody3_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody3_respawn.setLinearVelocity(0, 0);
                timehit3_respawn = 0;
                i3_respawn=0;
                respawntime_stone3=true;
            }
        }
    }
    private void Check_stone4_respawn(){
        dx6_respawn = player1.getPosition().x - Stone_Brickbody4_respawn.getPosition().x;
        dy6_respawn = player1.getPosition().y - Stone_Brickbody4_respawn.getPosition().y;
        lengthBrick4_respawn = Math.sqrt(dx6_respawn * dx6_respawn + dy6_respawn * dy6_respawn);
        if(lengthBrick4_respawn>=0&&lengthBrick4_respawn<=20&&myinputproccer.isHitenable()) {
            timehit4_respawn++;
            if(timehit4_respawn>3f&&i4_respawn<=5){
                i4_respawn++;
                timehit4_respawn=0;
                stone++;
            }
            if (timehit4_respawn >15f&&i4_respawn>5) {
                whichone_respawn=4;
                whichstone_respawn[3]=4;
                onetime_stone4=true;
                System.out.println("Stone 4");
                array_xstone4_respawn.add(Stone_Brickbody4_respawn.getPosition().x);
                array_ystone4_respawn.add(Stone_Brickbody4_respawn.getPosition().y);
                throw_stone4_respawn=new Throw_items(world,Stone_Brickbody4_respawn.getPosition().x,Stone_Brickbody4_respawn.getPosition().y,whichone_respawn);
                Stone_Brickbody4_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                Stone_Brickbody4_respawn.setLinearVelocity(0, 0);
                timehit4_respawn= 0;
                i4_respawn=0;
                respawntime_stone4=true;
            }
        }
    }




    private void checkSheep(){
        timeloopsheep+=Gdx.graphics.getRawDeltaTime();
        dx1 = player1.getPosition().x - sheepBody.getPosition().x;
        dy1 = player1.getPosition().y - sheepBody.getPosition().y;
        x1=dx1;
        y1=dy1;
        lengthsheep = Math.sqrt(x1 * x1 + y1 * y1);
        x1 /= lengthsheep;
        y1 /= lengthsheep; // normalize (make it 1 unit length)
        x1 *= Sheep_Speed;
        y1 *= Sheep_Speed; // scale to our desired speed
        if(lengthsheep>0&&lengthsheep<=30&&myinputproccer.isHitenable()){
            //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
            //check the hatlh hit thing
            activefollowsystem1=true;
            hitforsheepenable=true;
        }
        if(activefollowsystem1){
            enableanimatonsheep=true;
            sheepBody.setLinearVelocity(new Vector2((float) x1, (float) y1));
        }
        if(timeloopsheep>5f){
            timeloopsheep-=5f;
            hitsheep=true;
        }
        if(hitsheep&&lengthsheep>=0&&lengthsheep<=20&&hitforsheepenable){
            hitsheep=false;
            if(Main_Immunity==0)Health-=0.2;
            else Health-=0.2/(Main_Immunity+1);
            System.out.println("Helath"+Health);
        }
        if(lengthsheep>=0&&lengthsheep<=20&&myinputproccer.isHitenable()) {
            timehit+=Gdx.graphics.getRawDeltaTime();
            if(timehit>3){
                timehit=0;
                if(Main_attack>0)hited_sheep+=1*(Main_attack+1);
                else hited_sheep++;
                System.out.println("hit  "+hited_sheep);
                if(sheepBody.getPosition().x>player1.getPosition().x)sheepBody.setTransform(new Vector2(sheepBody.getPosition().x+15,sheepBody.getPosition().y),0);//left
                if(sheepBody.getPosition().x<player1.getPosition().x)sheepBody.setTransform(new Vector2(sheepBody.getPosition().x-15,sheepBody.getPosition().y),0);//right
                if(sheepBody.getPosition().y>player1.getPosition().y)sheepBody.setTransform(new Vector2(sheepBody.getPosition().x,sheepBody.getPosition().y+15),0);//up
                if(sheepBody.getPosition().y<player1.getPosition().y)sheepBody.setTransform(new Vector2(sheepBody.getPosition().x,sheepBody.getPosition().y-15),0);//down
            }
            if (hited_sheep>4) {
                whichone=1;
                hited_sheep=0;
                throw_sheep=new Throw_items(world,sheepBody.getPosition().x,sheepBody.getPosition().y,whichone);
                sheepBody.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                sheepBody.setLinearVelocity(0, 0);
                Level+=2;
                timehit = 0;
                respawntime_sheep=true;
                timerespawn_sheep=5.0f;
            }
        }
        batch.begin();
        //fix the texture
        if((int)player1.getPosition().y/10<(int)sheepBody.getPosition().y/10&& enableanimatonsheep){
            movesidessheep=false;//make sides dont apper(animaton)
            batch.draw((TextureRegion) animationdown_sheep.getKeyFrame(timeloop4,true),sheepBody.getPosition().x-atlasdown_sheep.getTextures().first().getWidth()/Sheep_Down_X,sheepBody.getPosition().y-atlasdown_sheep.getTextures().first().getHeight()/Sheep_Down_Y,SheepSize,SheepSize);
        }
        if((int)player1.getPosition().y/10>(int)sheepBody.getPosition().y/10&& enableanimatonsheep){
            movesidessheep=false;
            batch.draw((TextureRegion) aniamtionup_sheep.getKeyFrame(timeloop4,true),sheepBody.getPosition().x-atlasup_sheep.getTextures().first().getWidth()/Sheep_Up_X,sheepBody.getPosition().y-atlasup_sheep.getTextures().first().getHeight()/Sheep_Up_Y,SheepSize,SheepSize);
        }
        if((int)player1.getPosition().y/10==(int)sheepBody.getPosition().y/10){
            movesidessheep=true;
            if((int)player1.getPosition().x<(int)sheepBody.getPosition().x&&enableanimatonsheep)batch.draw((TextureRegion) animationleft_sheep.getKeyFrame(timeloop4,true),sheepBody.getPosition().x-atlasleft_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody.getPosition().y-atlasleft_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
            if((int)player1.getPosition().x>(int)sheepBody.getPosition().x&&enableanimatonsheep)batch.draw((TextureRegion) animationright_sheep.getKeyFrame(timeloop4,true),sheepBody.getPosition().x-atlasright_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody.getPosition().y-atlasright_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
        }
        batch.end();
    }
    private void checkReacon(){
        timeloopreacon+=Gdx.graphics.getRawDeltaTime();
        dx2 = player1.getPosition().x - goblinbody.getPosition().x;
        dy2 = player1.getPosition().y - goblinbody.getPosition().y;
        x2=dx2;
        y2=dy2;
        lengthreacon = Math.sqrt(x2 * x2 + y2 * y2);
        x2 /= lengthreacon;
        y2 /= lengthreacon; // normalize (make it 1 unit length)
        x2 *= Goblin_Speed;
        y2 *= Goblin_Speed; // scale to our desired speed
        if(lengthreacon>0&&lengthreacon<=30&&myinputproccer.isHitenable()){
            //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
            //check the hatlh hit thing
            activefollowsystem2=true;
            hitforreaconenable=true;
        }
        if(activefollowsystem2){
            enableanimatonreacon=true;
            goblinbody.setLinearVelocity(new Vector2((float) x2, (float) y2));
        }
        if(timeloopreacon>5f){
            timeloopreacon-=5f;
            hitreacon=true;
        }
        if(hitreacon&&lengthreacon>=0&&lengthreacon<=20&&hitforreaconenable){
            hitreacon=false;
            if(Main_Immunity==0)Health-=0.1;
            else Health-=0.1/(Main_Immunity+1);
            System.out.println("Helath"+Health);
        }
        if(lengthreacon>=0&&lengthreacon<=20&&myinputproccer.isHitenable()) {
            timehit+=Gdx.graphics.getRawDeltaTime();
            if(timehit>3){
                timehit=0;
                if(Main_attack>0)hited_reacon+=1*(Main_attack+1);
                else hited_reacon++;
                System.out.println("hit  "+hited_reacon);
                if(goblinbody.getPosition().x>player1.getPosition().x)goblinbody.setTransform(new Vector2(goblinbody.getPosition().x+15,goblinbody.getPosition().y),0);//left
                if(goblinbody.getPosition().x<player1.getPosition().x)goblinbody.setTransform(new Vector2(goblinbody.getPosition().x-15,goblinbody.getPosition().y),0);//right
                if(goblinbody.getPosition().y>player1.getPosition().y)goblinbody.setTransform(new Vector2(goblinbody.getPosition().x,goblinbody.getPosition().y+15),0);//up
                if(goblinbody.getPosition().y<player1.getPosition().y)goblinbody.setTransform(new Vector2(goblinbody.getPosition().x,goblinbody.getPosition().y-15),0);//down
            }
            if (hited_reacon>2) {
                goblinbody.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                goblinbody.setLinearVelocity(0, 0);
                timehit = 0;
                hited_reacon=0;
                Level+=1;
                activefollowsystem2=false;
                respawntime_goblin=true;
                timerespawn_goblin=5.0f;
                whichone=2;
            }
        }
        batch.begin();
        if((int)player1.getPosition().y/10<(int) goblinbody.getPosition().y/10&& enableanimatonreacon){
            movesidesgoblin =false;//make sides dont apper(animaton)
            batch.draw((TextureRegion) animationdown_goblin.getKeyFrame(timeloop4,true), goblinbody.getPosition().x-atlasdown_goblin.getTextures().first().getWidth()/Goblin_Down_X, goblinbody.getPosition().y-atlasdown_goblin.getTextures().first().getHeight()/Goblin_Down_Y,GoblinSize,GoblinSize);
        }
        if((int)player1.getPosition().y/10>(int) goblinbody.getPosition().y/10&& enableanimatonreacon){
            movesidesgoblin =false;
            batch.draw((TextureRegion) aniamtionup_goblin.getKeyFrame(timeloop4,true), goblinbody.getPosition().x-atlasup_goblin.getTextures().first().getWidth()/Goblin_Up_X, goblinbody.getPosition().y-atlasup_goblin.getTextures().first().getHeight()/Goblin_Up_Y,GoblinSize,GoblinSize);
        }
        if((int)player1.getPosition().y/10==(int) goblinbody.getPosition().y/10) {
            movesidesgoblin = true;
                if((int)player1.getPosition().x<(int)goblinbody.getPosition().x&&enableanimatonreacon)batch.draw((TextureRegion) animationleft_goblin.getKeyFrame(timeloop4,true), goblinbody.getPosition().x-atlasleft_goblin.getTextures().first().getWidth()/ Goblin_Width_left, goblinbody.getPosition().y-atlasleft_goblin.getTextures().first().getHeight()/Goblin_Height,GoblinSize,GoblinSize);
                if((int)player1.getPosition().x>(int)goblinbody.getPosition().x&&enableanimatonreacon)batch.draw((TextureRegion) animationright_goblin.getKeyFrame(timeloop4,true), goblinbody.getPosition().x-atlasright_goblin.getTextures().first().getWidth()/Goblin_Width_right, goblinbody.getPosition().y-atlasright_goblin.getTextures().first().getHeight()/Goblin_Height,GoblinSize,GoblinSize);
        }
        batch.end();
    }
    private void checkrat(){
        timelooprat+=Gdx.graphics.getRawDeltaTime();
        dx = player1.getPosition().x - ratbody.getPosition().x;
        dy = player1.getPosition().y - ratbody.getPosition().y;
        x=dx;
        y=dy;
            length = Math.sqrt(x * x + y * y);
            x /= length;
            y /= length; // normalize (make it 1 unit length)
            x *= Rat_Speed;
            y *= Rat_Speed; // scale to our desired speed
            if(length>0&&length<=30&&myinputproccer.isHitenable()){
                //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
               //check the health hit thing
                activefollowsystem=true;
                hitforratenable=true;
            }
            if(activefollowsystem) {
                enableanimatonrat=true;
                ratbody.setLinearVelocity(new Vector2((float) x, (float) y));
            }
            //hit reload
            if(timelooprat>5f){
                timelooprat-=5f;
                hitrat=true;
            }
            if(hitrat&&length>=0&&length<=20&&hitforratenable){
                if(Main_Immunity==0)Health-=0.05;
                else Health-=0.05/(Main_Immunity+1);
                hitrat=false;
                System.out.println("Helath"+Health);
            }

        if(length>=0&&length<=20&&myinputproccer.isHitenable()) {
            timehit+=Gdx.graphics.getRawDeltaTime();
            if(timehit>3f){
                timehit=0;
                if(Main_attack>0)hited_rat+=1*(Main_attack+1);
                else hited_rat++;
                System.out.println("hit  "+hited_rat);
                if(ratbody.getPosition().x>player1.getPosition().x)ratbody.setTransform(new Vector2(ratbody.getPosition().x+15,ratbody.getPosition().y),0);//left
                if(ratbody.getPosition().x<player1.getPosition().x)ratbody.setTransform(new Vector2(ratbody.getPosition().x-15,ratbody.getPosition().y),0);//right
                if(ratbody.getPosition().y>player1.getPosition().y)ratbody.setTransform(new Vector2(ratbody.getPosition().x,ratbody.getPosition().y+15),0);//up
                if(ratbody.getPosition().y<player1.getPosition().y)ratbody.setTransform(new Vector2(ratbody.getPosition().x,ratbody.getPosition().y-15),0);//down
            }
        }
        if (hited_rat>1) {
            //last point
            hited_rat=0;
            whichone=0;
            throw_rat=new Throw_items(world,ratbody.getPosition().x,ratbody.getPosition().y,whichone);
            ratbody.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
            ratbody.setLinearVelocity(0, 0);
            activefollowsystem=false;
            Level+=0.5;
            timehit = 0;
            hited_rat=0;
            respawntime_rat=true;
            timerespawn_rat=5.0f;
        }
        batch.begin();
        if((int)player1.getPosition().y/10<(int)ratbody.getPosition().y/10&& enableanimatonrat){
            movesides=false;//make sides dont apper(animaton)
            batch.draw((TextureRegion) animationdown_rat.getKeyFrame(timeloop4,true),ratbody.getPosition().x-atlasdown_rat.getTextures().first().getHeight()/Rat_DOWN_X,ratbody.getPosition().y-atlasdown_rat.getTextures().first().getHeight()/Rat_DOWN_Y,RatSize,RatSize);
        }
        if((int)player1.getPosition().y/10>(int)ratbody.getPosition().y/10&& enableanimatonrat){
            movesides=false;
            batch.draw((TextureRegion) aniamtionup_rat.getKeyFrame(timeloop4,true),ratbody.getPosition().x-atlasup_rat.getTextures().first().getHeight()/Rat_UP_X,ratbody.getPosition().y-atlasup_rat.getTextures().first().getHeight()/Rat_UP_Y,RatSize,RatSize);
        }
        if((int)player1.getPosition().y/10==(int)ratbody.getPosition().y/10) {
            movesides=true;
            if((int)player1.getPosition().x<(int)ratbody.getPosition().x&&enableanimatonrat)batch.draw((TextureRegion) animationleft_rat.getKeyFrame(timeloop4,true),ratbody.getPosition().x-atlasleft_rat.getTextures().first().getWidth()/Rat_Width,ratbody.getPosition().y-atlasleft_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
            if((int)player1.getPosition().x>(int)ratbody.getPosition().x&&enableanimatonrat)batch.draw((TextureRegion) animationright_rat.getKeyFrame(timeloop4,true),ratbody.getPosition().x-atlasright_rat.getTextures().first().getWidth()/Rat_Width,ratbody.getPosition().y-atlasright_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
        }
            batch.end();
    }
    private void movesideRat(){
        timeloop+=Gdx.graphics.getRawDeltaTime();
        if(timeloop>periodloop&&moveright&&!enableanimatonrat&&movesides){
            timeloop-=periodloop;
            ratbody.setLinearVelocity(new Vector2(3*10,0));
            moveleft=true;
            moveright=false;
        }
        if(timeloop>periodloop&&moveleft&&!enableanimatonrat&&movesides){
            timeloop-=periodloop;
            ratbody.setLinearVelocity(new Vector2(-3*10,0));
            moveleft=false;
            moveright=true;
        }
        batch.begin();
        if(moveright&&movesides&&!enableanimatonrat)batch.draw((TextureRegion) animationleft_rat.getKeyFrame(timeloop4,true),ratbody.getPosition().x-atlasleft_rat.getTextures().first().getWidth()/Rat_Width,ratbody.getPosition().y-atlasleft_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
        if(moveleft&&movesides&&!enableanimatonrat)batch.draw((TextureRegion) animationright_rat.getKeyFrame(timeloop4,true),ratbody.getPosition().x-atlasright_rat.getTextures().first().getWidth()/Rat_Width,ratbody.getPosition().y-atlasright_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
        batch.end();
    }
    private void move_Sheep(){
        timeloop2+=Gdx.graphics.getRawDeltaTime();
        if(timeloop2>periodloopsheep&&moverightsheep&&!enableanimatonsheep&&movesidessheep){
            timeloop2-=periodloopsheep;
            sheepBody.setLinearVelocity(new Vector2(Sheep_Speed,0));
            moveleftsheep=true;
            moverightsheep=false;
        }
        if(timeloop2>periodloopsheep&&moveleftsheep&&!enableanimatonsheep&&movesidessheep){
            timeloop2-=periodloopsheep;
            sheepBody.setLinearVelocity(new Vector2(-Sheep_Speed,0));
            moveleftsheep=false;
            moverightsheep=true;
        }
        batch.begin();
        if(moverightsheep&&movesidessheep&&!enableanimatonsheep)batch.draw((TextureRegion) animationleft_sheep.getKeyFrame(timeloop4,true),sheepBody.getPosition().x-atlasleft_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody.getPosition().y-atlasleft_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
        if(moveleftsheep&&movesidessheep&&!enableanimatonsheep)batch.draw((TextureRegion) animationright_sheep.getKeyFrame(timeloop4,true),sheepBody.getPosition().x-atlasright_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody.getPosition().y-atlasright_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
        batch.end();
    }

    private void move_Reacon(){
        timeloop3+=Gdx.graphics.getRawDeltaTime();
        if(timeloop3>periodloopreacon&& moverightgoblin&&!enableanimatonreacon&&movesidesgoblin){
            timeloop3-=periodloopreacon;
            goblinbody.setLinearVelocity(new Vector2(Goblin_Speed,0));
            moveleftgoblin =true;
            moverightgoblin =false;
        }
        if(timeloop3>periodloopreacon&& moveleftgoblin&&!enableanimatonreacon&&movesidesgoblin){
            timeloop3-=periodloopreacon;
            goblinbody.setLinearVelocity(new Vector2(-Goblin_Speed,0));
            moveleftgoblin =false;
            moverightgoblin =true;
        }
        batch.begin();
        if(moverightgoblin && movesidesgoblin&&!enableanimatonreacon)batch.draw((TextureRegion) animationleft_goblin.getKeyFrame(timeloop4,true), goblinbody.getPosition().x-atlasleft_goblin.getTextures().first().getWidth()/ Goblin_Width_left, goblinbody.getPosition().y-atlasleft_goblin.getTextures().first().getHeight()/Goblin_Height,GoblinSize,GoblinSize);
        if(moveleftgoblin && movesidesgoblin&&!enableanimatonreacon)batch.draw((TextureRegion) animationright_goblin.getKeyFrame(timeloop4,true), goblinbody.getPosition().x-atlasright_goblin.getTextures().first().getWidth()/Goblin_Width_right, goblinbody.getPosition().y-atlasright_goblin.getTextures().first().getHeight()/Goblin_Height,GoblinSize,GoblinSize);
        batch.end();
    }
    
    private void respawnmove_rat() {
        timeloop_respawn+=Gdx.graphics.getRawDeltaTime();
        if(timeloop_respawn>periodloop&&moveright_respawn&&movesides_respawn&&!enableanimatonrat_respawn){
            timeloop_respawn-=periodloop;
            ratbody_respawn.setLinearVelocity(new Vector2(Rat_Speed,0));
            moveleft_respawn=true;
            moveright_respawn=false;
        }
        if(timeloop_respawn>periodloop&&moveleft_respawn&&movesides_respawn&&!enableanimatonrat_respawn){
            timeloop_respawn-=periodloop;
            ratbody_respawn.setLinearVelocity(new Vector2(-Rat_Speed,0));
            moveleft_respawn=false;
            moveright_respawn=true;
        }
        batch.begin();
        if(moveright_respawn&&movesides_respawn&&!enableanimatonrat_respawn)batch.draw((TextureRegion) animationleft_rat_respawn.getKeyFrame(timeloop4,true),ratbody_respawn.getPosition().x-atlasleft_rat.getTextures().first().getWidth()/Rat_Width,ratbody_respawn.getPosition().y-atlasleft_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
        if(moveleft_respawn&&movesides_respawn&&!enableanimatonrat_respawn)batch.draw((TextureRegion) animationright_rat_respawn.getKeyFrame(timeloop4,true),ratbody_respawn.getPosition().x-atlasright_rat.getTextures().first().getWidth()/Rat_Width,ratbody_respawn.getPosition().y-atlasleft_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
        batch.end();
    }
    
    private void respawnmove_goblin(){
        timeloop3_respawn+=Gdx.graphics.getRawDeltaTime();
        if(timeloop3_respawn>periodloopreacon&& moverightgoblin_respawn&&movesidesgoblin_respawn&&!enableanimatongoblin_respawn){
            timeloop3_respawn-=periodloopreacon;
            goblinbody_respawn.setLinearVelocity(new Vector2(Goblin_Speed,0));
            moveleftgoblin_respawn =true;
            moverightgoblin_respawn =false;
        }
        if(timeloop3_respawn>periodloopreacon&& moveleftgoblin_respawn&&movesidesgoblin_respawn&&!enableanimatongoblin_respawn){
            timeloop3_respawn-=periodloopreacon;
            goblinbody_respawn.setLinearVelocity(new Vector2(-Goblin_Speed,0));
            moveleftgoblin_respawn =false;
            moverightgoblin_respawn =true;
        }
        batch.begin();
        if(moverightgoblin_respawn && movesidesgoblin_respawn&&!enableanimatongoblin_respawn)batch.draw((TextureRegion) animationleft_goblin_respawn.getKeyFrame(timeloop4,true), goblinbody_respawn.getPosition().x-atlasleft_goblin.getTextures().first().getWidth()/Goblin_Width_left, goblinbody_respawn.getPosition().y-atlasleft_goblin.getTextures().first().getHeight()/Goblin_Height,GoblinSize,GoblinSize);
        if(moveleftgoblin_respawn && movesidesgoblin_respawn&&!enableanimatongoblin_respawn)batch.draw((TextureRegion) animationright_goblin_respawn.getKeyFrame(timeloop4,true), goblinbody_respawn.getPosition().x-atlasright_goblin.getTextures().first().getWidth()/Goblin_Width_right, goblinbody_respawn.getPosition().y-atlasright_goblin.getTextures().first().getHeight()/Goblin_Height,GoblinSize,GoblinSize);
        batch.end();
    }
    
    private void respawnmove_sheep(){
        timeloop2_sheep+=Gdx.graphics.getRawDeltaTime();
        if(timeloop2_sheep>periodloopsheep&&moverightsheep_respawn&&movesidessheep_respawn&&!enableanimatonsheep_respawn){
            timeloop2_sheep-=periodloopsheep;
            sheepBody_respawn.setLinearVelocity(new Vector2(Sheep_Speed,0));
            moveleftsheep_respawn=true;
            moverightsheep_respawn=false;
        }
        if(timeloop2_sheep>periodloopsheep&&moveleftsheep_respawn&&movesidessheep_respawn&&!enableanimatonsheep_respawn){
            timeloop2_sheep-=periodloopsheep;
            sheepBody_respawn.setLinearVelocity(new Vector2(-Sheep_Speed,0));
            moveleftsheep_respawn=false;
            moverightsheep_respawn=true;
        }
        batch.begin();
        if(moverightsheep_respawn&&movesidessheep_respawn&&!enableanimatonsheep_respawn)batch.draw((TextureRegion) animationleft_sheep_respawn.getKeyFrame(timeloop4,true),sheepBody_respawn.getPosition().x-atlasleft_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody_respawn.getPosition().y-atlasleft_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
        if(moveleftsheep_respawn&&movesidessheep_respawn&&!enableanimatonsheep_respawn)batch.draw((TextureRegion) animationright_sheep_respawn.getKeyFrame(timeloop4,true),sheepBody_respawn.getPosition().x-atlasright_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody_respawn.getPosition().y-atlasright_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
        batch.end();
    }
    private void respawncheck_rat(){
        timelooprat_respawn+=Gdx.graphics.getRawDeltaTime();
        dx_respawn = player1.getPosition().x - ratbody_respawn.getPosition().x;
        dy_respawn = player1.getPosition().y - ratbody_respawn.getPosition().y;
        x_respawn=dx_respawn;
        y_respawn=dy_respawn;
        length_respawn = Math.sqrt(x_respawn * x_respawn + y_respawn * y_respawn);
        x_respawn /= length_respawn;
        y_respawn /= length_respawn; // normalize (make it 1 unit length)
        x_respawn *= Rat_Speed;
        y_respawn *= Rat_Speed; // scale to our desired speed
        if(length_respawn>0&&length_respawn<=30&&myinputproccer.isHitenable()){
            //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
            //check the health hit thing
            activefollowsystem_respawn=true;
            hitforratenable_respawn=true;
        }
        if(activefollowsystem_respawn) {
            enableanimatonrat_respawn=true;
            ratbody_respawn.setLinearVelocity(new Vector2((float) x_respawn, (float) y_respawn));
        }
        //hit reload
        if(timelooprat_respawn>5f){
            timelooprat_respawn-=5f;
            hitrat_respawn=true;
        }
        if(hitrat_respawn&&length_respawn>=0&&length_respawn<=2&&hitforratenable_respawn){
            hitrat_respawn=false;
            if(Main_Immunity==0)Health-=0.05;
            else Health-=0.05/(Main_Immunity+1);
            System.out.println("Helath"+Health);
        }

        if(length_respawn>=0&&length_respawn<=20&&myinputproccer.isHitenable()) {
            timehit_respawn+=Gdx.graphics.getRawDeltaTime();
            if(timehit_respawn>3){
                timehit_respawn=0;
                if(Main_attack>0)hited_rat_respawn+=1*(Main_attack+1);
                else hited_rat_respawn++;
                System.out.println("hit  "+hited_rat_respawn);
                if(ratbody_respawn.getPosition().x>player1.getPosition().x)ratbody_respawn.setTransform(new Vector2(ratbody_respawn.getPosition().x+15,ratbody_respawn.getPosition().y),0);//left
                if(ratbody_respawn.getPosition().x<player1.getPosition().x)ratbody_respawn.setTransform(new Vector2(ratbody_respawn.getPosition().x-15,ratbody_respawn.getPosition().y),0);//right
                if(ratbody_respawn.getPosition().y>player1.getPosition().y)ratbody_respawn.setTransform(new Vector2(ratbody_respawn.getPosition().x,ratbody_respawn.getPosition().y+15),0);//up
                if(ratbody_respawn.getPosition().y<player1.getPosition().y)ratbody_respawn.setTransform(new Vector2(ratbody_respawn.getPosition().x,ratbody_respawn.getPosition().y-15),0);//down
            }
            if (hited_rat_respawn>1) {
                whichone_respawn=0;
                hited_rat_respawn=0;
                throw_rat_respawn=new Throw_items(world,ratbody_respawn.getPosition().x,ratbody_respawn.getPosition().y,whichone_respawn);
                array_xrat_respawn.add(ratbody_respawn.getPosition().x);
                array_yrat_respawn.add(ratbody_respawn.getPosition().y);
                Level+=0.5;
                ratbody_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                ratbody_respawn.setLinearVelocity(0, 0);
                activefollowsystem_respawn = false;
                timehit_respawn = 0;
                respawntime_rat = true;
                timerespawn_rat = 5.0f;
                onetime_rat =true;
            }
        }
        batch.begin();
        if((int)player1.getPosition().y/10<(int)ratbody_respawn.getPosition().y/10&& enableanimatonrat_respawn){
            movesides_respawn=false;//make sides dont apper(animaton)
            batch.draw((TextureRegion) animationdown_rat_respawn.getKeyFrame(timeloop4,true),ratbody_respawn.getPosition().x-atlasdown_rat.getTextures().first().getWidth()/Rat_DOWN_X,ratbody_respawn.getPosition().y-atlasdown_rat.getTextures().first().getHeight()/Rat_DOWN_Y,RatSize,RatSize);
        }
        if((int)player1.getPosition().y/10>(int)ratbody_respawn.getPosition().y/10&& enableanimatonrat_respawn){
            movesides_respawn=false;
            batch.draw((TextureRegion) aniamtionup_rat_respawn.getKeyFrame(timeloop4,true),ratbody_respawn.getPosition().x-atlasup_rat.getTextures().first().getWidth()/Rat_UP_X,ratbody_respawn.getPosition().y-atlasup_rat.getTextures().first().getHeight()/Rat_UP_Y,RatSize,RatSize);
        }
        if((int)player1.getPosition().y/10==(int)ratbody_respawn.getPosition().y/10) {
            movesides_respawn=true;
            if((int)player1.getPosition().x<(int)ratbody_respawn.getPosition().x&&enableanimatonrat_respawn)batch.draw((TextureRegion) animationleft_rat_respawn.getKeyFrame(timeloop4,true),ratbody_respawn.getPosition().x-atlasleft_rat.getTextures().first().getWidth()/Rat_Width,ratbody_respawn.getPosition().y-atlasleft_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
            if((int)player1.getPosition().x>(int)ratbody_respawn.getPosition().x&&enableanimatonrat_respawn)batch.draw((TextureRegion) animationright_rat_respawn.getKeyFrame(timeloop4,true),ratbody_respawn.getPosition().x-atlasright_rat.getTextures().first().getWidth()/Rat_Width,ratbody_respawn.getPosition().y-atlasright_rat.getTextures().first().getHeight()/Rat_Height,RatSize,RatSize);
        }
        batch.end();
    }
    private void respawncheck_goblin(){
        timeloopreacon_respawn+=Gdx.graphics.getRawDeltaTime();
        dx2_respawn = player1.getPosition().x - goblinbody_respawn.getPosition().x;
        dy2_respawn = player1.getPosition().y - goblinbody_respawn.getPosition().y;
        x2_respawn=dx2_respawn;
        y2_respawn=dy2_respawn;
        lengthreacon_respawn = Math.sqrt(x2_respawn * x2_respawn + y2_respawn * y2_respawn);
        x2_respawn /= lengthreacon_respawn;
        y2_respawn /= lengthreacon_respawn; // normalize (make it 1 unit length)
        x2_respawn *= Goblin_Speed;
        y2_respawn *= Goblin_Speed; // scale to our desired speed
        if(lengthreacon_respawn>0&&lengthreacon_respawn<=30&&myinputproccer.isHitenable()){
            System.out.println("hited reacon");
            //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
            //check the hatlh hit thing
            activefollowsystemgoblin_respawn =true;
            hitforreaconenable_respawn=true;
        }
        if(activefollowsystemgoblin_respawn){
            enableanimatongoblin_respawn =true;
            goblinbody_respawn.setLinearVelocity(new Vector2((float) x2_respawn, (float) y2_respawn));
        }
        if(timeloopreacon_respawn>5f){
            timeloopreacon_respawn-=5f;
            hitreacon_respawn=true;
        }
        if(hitreacon_respawn&&lengthreacon_respawn>=0&&lengthreacon_respawn<=20&&hitforreaconenable_respawn){
            System.out.println("the player is hited once 1");
            hitreacon_respawn=false;
            if(Main_Immunity==0)Health-=0.1;
            else Health-=0.1/(Main_Immunity+1);
            System.out.println("Helath"+Health);
        }
        if(lengthreacon_respawn>=0&&lengthreacon_respawn<=20&&myinputproccer.isHitenable()) {
            timehit_respawn+=Gdx.graphics.getRawDeltaTime();
            if(timehit_respawn>3){
                timehit_respawn=0;
                if(Main_attack>0) hited_goblin_respawn +=1*(Main_attack+1);
                else hited_goblin_respawn++;
                if(goblinbody_respawn.getPosition().x>player1.getPosition().x)goblinbody_respawn.setTransform(new Vector2(goblinbody_respawn.getPosition().x+15,goblinbody_respawn.getPosition().y),0);//left
                if(goblinbody_respawn.getPosition().x<player1.getPosition().x)goblinbody_respawn.setTransform(new Vector2(goblinbody_respawn.getPosition().x-15,goblinbody_respawn.getPosition().y),0);//right
                if(goblinbody_respawn.getPosition().y>player1.getPosition().y)goblinbody_respawn.setTransform(new Vector2(goblinbody_respawn.getPosition().x,goblinbody_respawn.getPosition().y+15),0);//up
                if(goblinbody_respawn.getPosition().y<player1.getPosition().y)goblinbody_respawn.setTransform(new Vector2(goblinbody_respawn.getPosition().x,goblinbody_respawn.getPosition().y-15),0);//down
            }
            if (hited_goblin_respawn >2) {
                hited_goblin_respawn =0;
                goblinbody_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                goblinbody_respawn.setLinearVelocity(0, 0);
                timehit_respawn = 0;
                Level+=1;
                activefollowsystemgoblin_respawn =false;
                respawntime_goblin=true;
                timerespawn_goblin=5.0f;
                whichone_respawn=2;
            }
        }
        batch.begin();
        if((int)player1.getPosition().y/10<(int) goblinbody_respawn.getPosition().y/10&& enableanimatongoblin_respawn){
            movesidesgoblin_respawn =false;//make sides dont apper(animaton)
            batch.draw((TextureRegion) animationdown_goblin_respawn.getKeyFrame(timeloop4,true), goblinbody_respawn.getPosition().x-atlasdown_goblin.getTextures().first().getWidth()/Goblin_Down_X,goblinbody_respawn.getPosition().y-atlasdown_goblin.getTextures().first().getHeight()/Goblin_Down_Y,GoblinSize,GoblinSize);
        }
        if((int)player1.getPosition().y/10>(int) goblinbody_respawn.getPosition().y/10&& enableanimatongoblin_respawn){
            movesidesgoblin_respawn =false;
            batch.draw((TextureRegion) aniamtionup_goblin_respawn.getKeyFrame(timeloop4,true),goblinbody_respawn.getPosition().x-atlasup_goblin.getTextures().first().getWidth()/Goblin_Up_X,goblinbody_respawn.getPosition().y-atlasup_goblin.getTextures().first().getHeight()/Goblin_Up_Y,GoblinSize,GoblinSize);
        }
        if((int)player1.getPosition().y/10==(int) goblinbody_respawn.getPosition().y/10) {
            movesidesgoblin_respawn = true;
            if ((int) player1.getPosition( ).x < (int) goblinbody_respawn.getPosition( ).x && enableanimatongoblin_respawn)
                batch.draw((TextureRegion) animationleft_goblin_respawn.getKeyFrame(timeloop4, true), goblinbody_respawn.getPosition( ).x - atlasleft_goblin.getTextures( ).first( ).getWidth( ) / Goblin_Width_left, goblinbody_respawn.getPosition( ).y - atlasleft_goblin.getTextures( ).first( ).getHeight( ) / Goblin_Height, GoblinSize, GoblinSize);
            if ((int) player1.getPosition( ).x > (int) goblinbody_respawn.getPosition( ).x && enableanimatongoblin_respawn)
                batch.draw((TextureRegion) animationright_goblin_respawn.getKeyFrame(timeloop4, true), goblinbody_respawn.getPosition( ).x - atlasright_goblin.getTextures( ).first( ).getWidth( ) / Goblin_Width_right, goblinbody_respawn.getPosition( ).y - atlasright_goblin.getTextures( ).first( ).getHeight( ) / Goblin_Height, GoblinSize, GoblinSize);
        }
        batch.end();
    }
    
    private void respawncheck_sheep(){
        timeloopsheep_respawn+=Gdx.graphics.getRawDeltaTime();
        dx1_respawn = player1.getPosition().x - sheepBody_respawn.getPosition().x;
        dy1_respawn = player1.getPosition().y - sheepBody_respawn.getPosition().y;
        x1_respawn=dx1_respawn;
        y1_respawn=dy1_respawn;
        lengthsheep_respawn = Math.sqrt(x1_respawn * x1_respawn + y1_respawn * y1_respawn);
        x1_respawn /= lengthsheep_respawn;
        y1_respawn /= lengthsheep_respawn; // normalize (make it 1 unit length)
        x1_respawn *= Sheep_Speed;
        y1_respawn *= Sheep_Speed; // scale to our desired speed
        if(lengthsheep_respawn>0&&lengthsheep_respawn<=30&&myinputproccer.isHitenable()){
            System.out.println("hited sheep");
            //TP THE ENEMY FAR AWAY AND dont let it move and kill it after that
            //check the hatlh hit thing
            activefollowsystemsheep_respawn =true;
            hitforsheepenable_respawn=true;
        }
        if(activefollowsystemsheep_respawn){
            enableanimatonsheep_respawn=true;
            sheepBody_respawn.setLinearVelocity(new Vector2((float) x1_respawn, (float) y1_respawn));
        }
        if(timeloopsheep_respawn>5f){
            timeloopsheep_respawn-=5f;
            hitsheep_respawn=true;
        }
        if(hitsheep_respawn&&lengthsheep_respawn>=0&&lengthsheep_respawn<=20&&hitforsheepenable){
            System.out.println("the player is hited once ");
            hitsheep_respawn=false;
            if(Main_Immunity==0)Health-=0.2;
            else Health-=0.2/(Main_Immunity+1);
            System.out.println("Helath"+Health);
        }
        if(lengthsheep_respawn>=0&&lengthsheep_respawn<=20&&myinputproccer.isHitenable()) {
            timehit_respawn+=Gdx.graphics.getRawDeltaTime();
            if(timehit_respawn>3){
                timehit_respawn=0;
                if(Main_attack>0)hited_sheep_respawn+=1*(Main_attack+1);
                else hited_sheep_respawn++;
                if(sheepBody_respawn.getPosition().x>player1.getPosition().x)sheepBody_respawn.setTransform(new Vector2(sheepBody_respawn.getPosition().x+15,sheepBody_respawn.getPosition().y),0);//left
                if(sheepBody_respawn.getPosition().x<player1.getPosition().x)sheepBody_respawn.setTransform(new Vector2(sheepBody_respawn.getPosition().x-15,sheepBody_respawn.getPosition().y),0);//right
                if(sheepBody_respawn.getPosition().y>player1.getPosition().y)sheepBody_respawn.setTransform(new Vector2(sheepBody_respawn.getPosition().x,sheepBody_respawn.getPosition().y+15),0);//up
                if(sheepBody_respawn.getPosition().y<player1.getPosition().y)sheepBody_respawn.setTransform(new Vector2(sheepBody_respawn.getPosition().x,sheepBody_respawn.getPosition().y-15),0);//down
            }
            if (hited_sheep_respawn>4) {
                whichone_respawn=1;
                hited_sheep_respawn=0;
                throw_sheep_respawn=new Throw_items(world,sheepBody_respawn.getPosition().x,sheepBody_respawn.getPosition().y,whichone_respawn);
                array_xsheep_respawn.add(sheepBody_respawn.getPosition().x);
                array_ysheep_respawn.add(sheepBody_respawn.getPosition().y);
                sheepBody_respawn.setTransform(camera.position.x * 233, camera.position.y * 233, 0);
                sheepBody_respawn.setLinearVelocity(0, 0);
                timehit_respawn = 0;
                Level+=2;
                respawntime_sheep=true;
                timerespawn_sheep=5.0f;
                onetime_sheep=true;
            }
        }
        batch.begin();
        //fix the texture
        if((int)player1.getPosition().y/10<(int)sheepBody_respawn.getPosition().y/10&& enableanimatonsheep_respawn){
            movesidessheep_respawn=false;//make sides dont apper(animaton)
            batch.draw((TextureRegion) animationdown_sheep_respawn.getKeyFrame(timeloop4,true),sheepBody_respawn.getPosition().x-atlasdown_sheep.getTextures().first().getWidth()/Sheep_Down_X,sheepBody_respawn.getPosition().y-atlasdown_sheep.getTextures().first().getHeight()/Sheep_Down_Y,SheepSize,SheepSize);
        }
        if((int)player1.getPosition().y/10>(int)sheepBody_respawn.getPosition().y/10&& enableanimatonsheep_respawn){
            movesidessheep_respawn=false;
            batch.draw((TextureRegion) aniamtionup_sheep_respawn.getKeyFrame(timeloop4,true),sheepBody_respawn.getPosition().x-atlasup_sheep.getTextures().first().getWidth()/Sheep_Up_X,sheepBody_respawn.getPosition().y-atlasup_sheep.getTextures().first().getHeight()/Sheep_Up_Y,SheepSize,SheepSize);
        }
        if((int)player1.getPosition().y/10==(int)sheepBody_respawn.getPosition().y/10)
        {
            movesidessheep_respawn=true;
            if((int)player1.getPosition().x<(int)sheepBody_respawn.getPosition().x&&enableanimatonsheep_respawn)batch.draw((TextureRegion) animationleft_sheep_respawn.getKeyFrame(timeloop4,true),sheepBody_respawn.getPosition().x-atlasleft_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody_respawn.getPosition().y-atlasleft_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
            if((int)player1.getPosition().x>(int)sheepBody_respawn.getPosition().x&&enableanimatonsheep_respawn)batch.draw((TextureRegion) animationright_sheep_respawn.getKeyFrame(timeloop4,true),sheepBody_respawn.getPosition().x-atlasright_sheep.getTextures().first().getWidth()/Sheep_Width,sheepBody_respawn.getPosition().y-atlasright_sheep.getTextures().first().getHeight()/Sheep_Height,SheepSize,SheepSize);
        }
        batch.end();
    }
}

