package 魔塔;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import java.util.Set;
import java.util.HashSet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;

class Point{								//坐标类								
Point(int X,int Y)
{
	this.x=X;
	this.y=Y;
}
int x;
int y;
}

class Stuff{								//状态基类
	public int HP,ATK,DEF,Money,EXP;
}


class Monster extends Stuff{				//怪物类
	Monster(int h,int a,int d,int m,int e)
	{
		this.HP=h;
		this.DEF=d;
		this.ATK=a;
		this.Money=m;
		this.EXP=e;
	}
}

public class Hero extends Stuff{    		//英雄类

	int LEVEL;
	int X;
	int Y;
	int dir;
	
	int yKey;
	int bKey;
	int rKey;
	int floor;
	int cross;
	int makerFloor[]=new int [12];
	int jump;
	
	boolean ismove;							//是否在移动
	boolean isopen;							//是否在开门
	boolean isfight;
	boolean ispick;
	boolean istalking;
	Image imag[][]=new Image[4][4];
	
	Hero(){
		init();
		
	}
	Hero(int l,int h,int a,int d,int m,int e,int x,int y,int f,int yk,int bk,int rk,int cr)
	{
		init(l,h,a,d,m,e,x,y,f,yk,bk,rk,cr);
	}
		
	void initImage()						//加载图片
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			imag[i][j]=GameUtil.getImage("人物\\"+i+"-"+j+".png");
		}	
	}
	void init() {
		initImage();

		dir=0;
		this.LEVEL=1;
		this.HP=1000;
		this.ATK=999999;
		this.DEF=10;
		this.Money=0;
		this.EXP=0;
		this.X=5;
		this.Y=9;
		this.floor=0;
		this.yKey=1;
		this.bKey=1;
		this.rKey=1;
		this.cross=0;
		this.makerFloor[0]=1;
		
	}
	
	void init(int l,int h,int a,int d,int m,int e,int x,int y,int f,int yk,int bk,int rk,int cr)
	{
		dir=0;
		this.LEVEL=l;
		this.HP=h;
		this.ATK=a;
		this.DEF=d;
		this.Money=m;
		this.EXP=e;
		this.X=x;
		this.Y=y;
		this.floor=f;
		this.yKey=yk;
		this.bKey=bk;
		this.rKey=rk;
		this.cross=cr;
		initImage();
	}

}

