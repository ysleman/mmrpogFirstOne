package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.Dugeon.Dungeon_1;
import com.mygdx.game.Dugeon.Dungeon_10;
import com.mygdx.game.Dugeon.Dungeon_2;
import com.mygdx.game.Dugeon.Dungeon_3;
import com.mygdx.game.Dugeon.Dungeon_4;
import com.mygdx.game.Dugeon.Dungeon_5;
import com.mygdx.game.Dugeon.Dungeon_6;
import com.mygdx.game.Dugeon.Dungeon_7;
import com.mygdx.game.Dugeon.Dungeon_8;
import com.mygdx.game.Dugeon.Dungeon_9;
import com.mygdx.game.Dugeon.Random_mobs;

import java.util.ArrayList;

public class MyGdxGame extends Game {
	SpriteBatch batch;
	Texture img;
	public Array<Texture> Islots1;
	public Random_mobs random;
	int Floor=1;
	private ArrayList<Integer> Dungeon_list;
	private float Health=1;
	private float Level=0;
	private int[] ItemsCollect;
	private boolean first1;
	private float[] Hunger;
	private int[] stats;
	private float hunger_reduce=1;
	private int Main_hunger=0;
	private int Main_health=0,Main_attack=0,Main_Immunity=0;
	private int howmanytimes_lefttoadd=0;
	private  int Main_reduce;

	@Override
	public void create ()
	{
		Dungeon_list=new ArrayList<Integer>();
		Islots1=new Array<Texture>();
		random=new Random_mobs(Floor);
		ItemsCollect=new int[15];
		Hunger=new float[2];
		stats=new int[7];
		first1=true;
		Hunger[0]=hunger_reduce;
		Hunger[1]=Main_hunger;
		stats[0]= (int) Level;
		stats[1]=Main_hunger;
		stats[2]=Main_Immunity;
		stats[3]=Main_attack;
		stats[4]=Main_health;
		stats[5]=howmanytimes_lefttoadd;
		stats[6]=Main_reduce;
		this.setScreen(new StartGame(this));
		//Change_Screen12();
		//this.setScreen(new Worldbegginerplace(Islots1, this, Health, Level, ItemsCollect,first1));
		//Dungeon_change(Islots1,1,Health,Level,ItemsCollect,first1,Hunger, stats);
	}
	public void Change_Screen12(){
		this.setScreen(new Worldbegginerplace(Islots1, this, Health, Level, ItemsCollect,first1,Hunger, stats));
	}
	public void Game_Over(float currnetnumLvl1, float currnetnumTime1, int currnetnumPointsUsed1, int currnetnumCreated1){
		this.setScreen(new Game_Over(this,currnetnumLvl1,currnetnumTime1,currnetnumPointsUsed1,currnetnumCreated1));
	}
	public void Dungeon_change(Array<Texture> Islots,int floor,float Health, float Level, int[] Items1Collect, boolean first,float[] hungers, int[] Stats){
		this.ItemsCollect=Items1Collect;
		this.setScreen(new Dungeon_1(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
		System.out.println(Items1Collect[0]);
	}
	public void Dungeon_change(Array<Texture> Islots, int num, int floor, ArrayList<Integer> Dungeon_list, float Health, float Level, int[] Items1Collect, boolean first, float[] hungers, int[] Stats){
		System.out.println("DUNGEON"+num);
		switch (num){
			case 2:this.setScreen(new Dungeon_2(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 3:this.setScreen(new Dungeon_3(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 4:this.setScreen(new Dungeon_4(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 5:this.setScreen(new Dungeon_5(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 6:this.setScreen(new Dungeon_6(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 7:this.setScreen(new Dungeon_7(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 8:this.setScreen(new Dungeon_8(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 9:this.setScreen(new Dungeon_9(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
			case 10:this.setScreen(new Dungeon_10(this,Islots,floor,Dungeon_list,Health,Level,Items1Collect,first,hungers,Stats));
				break;
		}
	}
	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {

	}
}

