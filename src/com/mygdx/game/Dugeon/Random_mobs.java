package com.mygdx.game.Dugeon;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

import java.util.ArrayList;
import java.util.Random;

public class Random_mobs {
    private Random random1;
    public ArrayList<Integer> MOBS;
    public  ArrayList<Integer> random_y_1;
    public ArrayList<Integer> random_x_1;
    public  int Randomroom;
    private TestBody testBody;
    public   int random_x;
    public   int random_y;
    private int random;
    public int stair_down_x;
    public int stair_down_y;
    public int stair_up_x;
    public int stair_up_y;
    public int[] holes_x;
    public int[] holes_y;
    public int Dungeon;
    public int floors;
    private int times;

    public Random_mobs(int floor){
        if(floor==1)Dungeon=1;
        if(floor>=2&&floor<=5){
            Random rand=new Random();
            Randomroom=rand.nextInt(3);
            switch (Randomroom){
                case 0:Dungeon=2;
                    break;
                case 1:Dungeon=3;
                    break;
                case 2:Dungeon=4;
                    break;
                case 3:Dungeon=5;
                    break;
            }
        }
        if(floor>=6&&floor<=8){
            Random rand=new Random();
            Randomroom=rand.nextInt(2);
            switch (Randomroom){
                case 0:Dungeon=6;
                break;
                case 1:Dungeon=7;
                break;
                case 2:Dungeon=8;
                break;
            }
        }
        if(floor>=9){
            Random rand=new Random();
            Randomroom=rand.nextInt(1);
            switch (Randomroom){
                case 0:Dungeon=9;
                    break;
                case 1:Dungeon=10;
                    break;
            }
        }
        System.out.println("randomRoomNExt "+Dungeon);
    }
     public void Random_enemys(int dungeon,ArrayList<Integer> x, ArrayList<Integer> y,int floor){
         random_x_1=new ArrayList<Integer>();
         random_y_1=new ArrayList<Integer>();
         MOBS=new ArrayList<Integer>();
         times=floor*3;
         System.out.println(times);
         if(dungeon==1){
            for(int i3 = 0; i3<times; i3++) {
                random1 = new Random( );
                MOBS.add(random1.nextInt(3));
            }
            int i2;
            for(int i=0;i<times;i++) {
                random_x_1.add((int) (Math.random( ) * x.size( )));
                random_y_1.add((int) (Math.random( ) * y.size( )));
                random_x_1.set(i, x.get(random_x_1.get(i)) * 32);
                random_y_1.set(i, y.get(random_y_1.get(i)) * 32);
            }
            for(i2=0; i2<MOBS.size()-1; i2++){
                while (MOBS.get(i2)==MOBS.get(i2+1)){
                    MOBS.set(i2,random1.nextInt(3));
                }
            }
            for (i2=0;i2<times;i2++){
                System.out.println("bruh " + MOBS.get(i2));
                System.out.println("X:" + random_x_1.get(i2)+"    Y: " +random_y_1.get(i2));
            }
        }
        if(dungeon>=2&&dungeon<=5){
            for(int i3 = 0; i3<times; i3++) {
                random1 = new Random( );
                MOBS.add(random1.nextInt(3));
            }
            int i2;
            for(int i=0;i<times;i++) {
                random_x_1.add((int) (Math.random( ) * x.size( )));
                random_y_1.add((int) (Math.random( ) * y.size( )));
                random_x_1.set(i, x.get(random_x_1.get(i)) * 32);
                random_y_1.set(i, y.get(random_y_1.get(i)) * 32);
            }
            for(i2=0; i2<MOBS.size()-1; i2++){
                while (MOBS.get(i2)==MOBS.get(i2+1)){
                    MOBS.set(i2,random1.nextInt(3));
                }
            }
            for (i2=0;i2<times;i2++){
                System.out.println("bruh " + MOBS.get(i2));
                System.out.println("X:" + random_x_1.get(i2)+"    Y: " +random_y_1.get(i2));
            }
        }
         if(dungeon>=6&&dungeon<=8){
             for(int i3 = 0; i3<times; i3++) {
                 random1 = new Random( );
                 MOBS.add(random1.nextInt(3));
             }
             int i2;
             for(int i=0;i<times;i++) {
                 random_x_1.add((int) (Math.random( ) * x.size( )));
                 random_y_1.add((int) (Math.random( ) * y.size( )));
                 random_x_1.set(i, x.get(random_x_1.get(i)) * 32);
                 random_y_1.set(i, y.get(random_y_1.get(i)) * 32);
             }
             for(i2=0; i2<MOBS.size()-1; i2++){
                 while (MOBS.get(i2)==MOBS.get(i2+1)){
                     MOBS.set(i2,random1.nextInt(3));
                 }
             }
             for (i2=0;i2<times;i2++){
                 System.out.println("bruh " + MOBS.get(i2));
                 System.out.println("X:" + random_x_1.get(i2)+"    Y: " +random_y_1.get(i2));
             }
         }
         if(dungeon>=9){
             for(int i3 = 0; i3<times; i3++) {
                 random1 = new Random( );
                 MOBS.add(random1.nextInt(3));
             }
             int i2;
             for(int i=0;i<times;i++) {
                 random_x_1.add((int) (Math.random( ) * x.size( )));
                 random_y_1.add((int) (Math.random( ) * y.size( )));
                 random_x_1.set(i, x.get(random_x_1.get(i)) * 32);
                 random_y_1.set(i, y.get(random_y_1.get(i)) * 32);
             }
             for(i2=0; i2<MOBS.size()-1; i2++){
                 while (MOBS.get(i2)==MOBS.get(i2+1)){
                     MOBS.set(i2,random1.nextInt(3));
                 }
             }
             for (i2=0;i2<times;i2++){
                 System.out.println("bruh " + MOBS.get(i2));
                 System.out.println("X:" + random_x_1.get(i2)+"    Y: " +random_y_1.get(i2));
             }
         }
     }
    public Random_mobs(ArrayList<Integer> x, ArrayList<Integer> y, World world1, int Dungeon, Body Player) {
        if(Dungeon==1) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for(int i=0;i<5;i++) {
                stair_down_x = x.get(1199) * 32;
                stair_down_y = y.get(1199) * 32;//for stair down
                stair_up_x = x.get(19) * 32;
                stair_up_y = y.get(2) * 32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m] = (x.get(hole_check)) * 32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m] = (y.get(hole_check2)) * 32;
                m++;
            }
        }
        if(Dungeon==2) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(2196)*32;
                stair_down_y=y.get(2196)*32;//for stair down
                stair_up_x=x.get(60)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==3) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(2164)*32;
                stair_down_y=y.get(2164)*32;//for stair down
                stair_up_x=x.get(60)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==4) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(2100)*32;
                stair_down_y=y.get(2100)*32;//for stair down
                stair_up_x=x.get(60)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==5) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(2930)*32;
                stair_down_y=y.get(2930)*32;//for stair down
                stair_up_x=x.get(60)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==6) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(3199)*32;
                stair_down_y=y.get(3199)*32;//for stair down
                stair_up_x=x.get(60)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==7) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(3100)*32;
                stair_down_y=y.get(3100)*32;//for stair down
                stair_up_x=x.get(19)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==8) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(3237)*32;
                stair_down_y=y.get(3230)*32;//for stair down
                stair_up_x=x.get(19)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==9) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(4000)*32;
                stair_down_y=y.get(4000)*32;//for stair down
                stair_up_x=x.get(60)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
        if(Dungeon==10) {
            holes_x=new int[5];
            holes_y=new int[5];
            int hole_check=0;
            int m=0;
            for (int i = 0; i < 5; i++) {
                random = (int) (Math.random( ) * 3);
                random_x = (int) (Math.random( ) * x.size( ));
                random_y = (int) (Math.random( ) * y.size( ));
                //testBody = new TestBody(world1, x.get(random_x) * 32, y.get(random_y) * 32);
                stair_down_x=x.get(4400)*32;
                stair_down_y=y.get(4400)*32;//for stair down
                stair_up_x=x.get(19)*32;
                stair_up_y=y.get(2)*32;//for stair up to ground
                hole_check = (int) (Math.random( ) * x.size( ));
                holes_x[m]=(x.get(hole_check))*32;
                int hole_check2 = (int) (Math.random( ) * y.size( ));
                holes_y[m]=(y.get(hole_check2))*32;
                System.out.println("x:"+holes_x[m]+"  y:"+holes_y[m]+"     "+stair_up_x+"  "+stair_up_y+"  "+stair_down_x+"   "+stair_down_y);
                m++;
                //  System.out.println("random   " + random + "   " + x.size( ) + "    " + y.size( ) + "   x:  " + x.get(random_x) * 32 + "   y:  " + y.get(random_y) * 32);
            }
        }
    }

}