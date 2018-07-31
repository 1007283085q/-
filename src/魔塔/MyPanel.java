package 魔塔;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;


public class MyPanel extends  JPanel implements KeyListener{			//游戏主界面

	public static int Pro=90;												//比例
	MonsterShake ms=new MonsterShake(this);
	Hero hero;
	Game game;
	//Status st;
	int initx;
	int inity;
	
	Point Doorxy=new Point(0,0);
	Point Fightxy=new Point(0,0);
	
	int fcnt;
	int Doorcolor;
	int Monstercnt=1;
	int Doorcnt;
	int Herocnt;
	
	static Image imagM[][]=new Image[33][5];
	static Image imagL[]=new Image[11];
	static Image imagP[]=new Image[60];
	static Image imagD[][]=new Image[4][4];
	static Image imagF[]=new Image[3];
	
	
	static PlayMusic P=new PlayMusic();
	static void initimage() {
		int i;
		int j;
		for(i=1;i<=32;i++)
			for(j=1;j<=4;j++)
				imagM[i][j]=GameUtil.getImage("怪物\\"+i+" ("+j+").png");
		for(i=0;i<=10;i++)
			imagL[i]=GameUtil.getImage("地形\\地形"+i+".png");
		for(i=2;i<=49;i++)
			imagP[i]=GameUtil.getImage("道具\\"+"-"+i+".png");
		for(i=0;i<4;i++)
			for(j=0;j<4;j++)
			{
				imagD[i][j]=GameUtil.getImage("门\\"+(i+1)+" ("+(j+1)+").png");
			}
		for(i=1;i<=2;i++)
		{
			imagF[i]=GameUtil.getImage("战斗\\"+i+".png");
		}
	}
	
	Point initP=new Point(0,0);
	public MyPanel(Hero h,Game g) {
		hero=h;
		game=g;
		initimage();
		ms.start();
		//this.setLayout(null);
		//this.setSize(12*Pro,12*Pro);
		//this.setBounds(100,0,12*Pro,12*Pro);
		
	}
	
	public void keyPressed(KeyEvent e) { 					//键盘监听
		if(hero.ismove||hero.isopen||hero.isfight||hero.ispick) return;
		HeroShake hs=new HeroShake(this);	
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_UP:		
			
			hero.dir=Game.UP;
			hero.ismove=true;
			MoveJudge(Game.UP);
			
			hs.start();
			break;
			
		case KeyEvent.VK_DOWN:		
			
			hero.dir=Game.DOWN;
			hero.ismove=true;
			MoveJudge(Game.DOWN);
			hs.start();
			break;
		
		case KeyEvent.VK_LEFT:
			
			hero.dir=Game.LEFT;
			hero.ismove=true;
			MoveJudge(Game.LEFT);
			hs.start();
			break;
		
		case KeyEvent.VK_RIGHT:  
			
			hero.dir=Game.RIGHT;
			hero.ismove=true;
			MoveJudge(Game.RIGHT);
			hs.start();
			break;
			
		case KeyEvent.VK_ESCAPE:

			Main.me.setVisible(true);;
			
		}
		
		this.repaint();
		
	}
	
    public void keyTyped(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
    
	void MoveJudge (int D) {
		int tx,ty;
		tx=hero.X;
		ty=hero.Y;
		PlayMusic P=new PlayMusic();
		
		switch(D){
			case Game.UP:ty--;break;
			case Game.DOWN:ty++;break;
			case Game.LEFT:tx--;break;
			case Game.RIGHT:tx++;break;
		}
		if(tx>=0&&tx<11&&ty>=0&&ty<11) {
			int n=game.map[hero.floor][ty][tx];
			if(n==0) {										//空地
				hero.X=tx;
				hero.Y=ty;

			}
			else if(n>0&&n<=6) {;}							//其他地形
			else if(n>6&&n<=10) {							//门
				//DoorShake ds=new DoorShake(this);
				
				
				if(n==7&&hero.yKey>0)
				{					
					hero.yKey--;
					openingDoor(hero.floor,ty,tx);				
				}
				if(n==8&&hero.bKey>0)
				{					
					hero.bKey--;
					openingDoor(hero.floor,ty,tx);
				}
				if(n==9&&hero.rKey>0)
				{				
					hero.rKey--;
					openingDoor(hero.floor,ty,tx);				
				}
							
			}
			else if(n>10) {									//怪物
				
				
				
				int LostHP=fight(n);
				if(hero.HP-LostHP>0)
				{
					hero.isfight=true;
					hero.HP-=LostHP;
					//Update();								//更新
					hero.X=tx;
					hero.Y=ty;
					Fightxy.x=tx;
					Fightxy.y=ty;
					FightShake fs=new FightShake(this);
					fs.start();
					hero.Money+=Game.MMoney[n-11];
					hero.EXP+=Game.MEXP[n-11];
					game.map[hero.floor][ty][tx]=0;
					
					if(game.map[4][3][5]==0&&game.map[4][2][5]==10) {
						openingDoor(4,2,5);
					}
					if(game.map[4][0][5]==0&&game.map[2][6][1]==10) {
						openingDoor(2,6,1);
					}
					if(game.map[11][5][5]==0&&game.map[11][0][0]==0) {
						game.map[11][0][0]=-11;
					}
						
					
				}
				else
				{
					//throw new Lost();						//游戏失败
				}
				P.playatk();
				//hero.isfight=false;
			}
			else if(n==-10) {
				hero.floor++;
				
				P.playBgm(hero.floor);
				hero.makerFloor[hero.floor]=1;
				hero.X=Game.UPfloor[hero.floor][1];
				hero.Y=Game.UPfloor[hero.floor][0];
			}
			else if(n==-11) {
				hero.floor--;
				
				P.playBgm(hero.floor);
				hero.X=Game.DOWNfloor[hero.floor][1];
				hero.Y=Game.DOWNfloor[hero.floor][0];
			}
			else if(n<=-40&&n>=-49) {
				if(n==-40)
					Talk(5);
				else if(n==-41)
				{
					Talk(6);
				}
				else if(n==-42)
				{
					Talk(8);
				}
				else if(n==-43)
				{
					Talk(3);
					game.map[hero.floor][ty][tx]=0;
					if(game.map[4][0][5]==0&&game.map[2][6][1]==10&&game.map[2][7][7]==10&&game.map[2][7][9]==10) {
						openingDoor(2,6,1);
						openingDoor(2,7,7);
						openingDoor(2,7,9);
					}
				}
				else if(n==-44)
				{
					Talk(0);
					game.map[0][8][5]=0;
					game.map[0][8][4]=-48;
					
				}
				else if(n==-46)
				{
					Talk(2);
				}
					
				else if(n==-48&&hero.cross==1)
				{
					Talk(1);
					
				}
				else if(n==-49) {
					Talk(7);
					game.map[hero.floor][tx][ty]=40;
					
				}
				
			}
				
			else  {									//道具	
				hero.ispick=true;
				if(n<=-2&&n>=-4)								//钥匙
				{
					if(n==-2) hero.yKey++;
					else if(n==-3) hero.bKey++;
					else if(n==-4) hero.rKey++;
				}
				if(n==-5) hero.ATK+=3;
				if(n==-6) hero.DEF+=3;
				if(n==-7) hero.HP+=100;
				if(n==-8) hero.HP+=400;
				if(n==-9) hero.HP+=600;
				if(n==-20) hero.ATK+=10;
				if(n==-21) hero.ATK+=10;
				if(n==-22) hero.ATK+=70;
				if(n==-23) hero.ATK+=70;
				if(n==-24) hero.ATK+=110;
				if(n==-25) hero.DEF+=10;
				if(n==-26) hero.DEF+=50;
				if(n==-27) hero.DEF+=85;
				if(n==-28) hero.DEF+=120;
				if(n==-29) ;
				if(n==-30) ;
				if(n==-31) {hero.LEVEL+=3;hero.ATK+=21;hero.DEF+=21;hero.HP+=3000;};
				if(n==-32) {hero.cross=1;};
				if(n==-33) hero.Money+=300;
				if(n==-34) {hero.jump=1;};
				if(n==-35) {hero.yKey++;hero.bKey++;hero.rKey++;};
				if(n==-36) hero.HP*=2;
				
				game.map[hero.floor][ty][tx]=0;
				hero.X=tx;
				hero.Y=ty;
				P.playget();
				hero.ispick=false;
			}
			
		}
	}
    
	void Talk(int i) {
		hero.istalking=true;
		talk.getflag(i);
		talk t=new talk(i);
		t.requestFocus();
		hero.istalking=false;
	}
	
	void openingDoor(int floor,int ty,int tx) {
		Doorxy.x=tx;
		Doorxy.y=ty;
		Doorcolor=game.map[floor][ty][tx]-7;
		hero.isopen=true;
		new DoorShake(this).start();	
		P.playdoor();
		game.map[floor][ty][tx]=0;
	}
	
    int fight(int n) {
    	Monster m=new Monster(Game.MHP[n-11],Game.MATK[n-11],Game.MDEF[n-11],Game.MMoney[n-11],Game.MEXP[n-11]);
    	int hurt1,hurt2;
    	hurt1=hero.ATK-m.DEF;					//英雄对怪物伤害
    	hurt2=m.ATK-hero.ATK;					//怪物对英雄伤害
    			    	
    	if(hurt2<=0)
    		hurt2=0;
    	if(hurt1<=0)
    		return 9999999;
    	else
    	{
    		return (m.HP/hurt1)*hurt2;
    	}
    	
    }
	
    
    public void paint(Graphics g) {						
    	super.paint(g);
    	
    	drawMap(g);
    	drawHero(g);
    	drawFight(g);
    }

    public void drawFight(Graphics g) {
    	if(hero.isfight) {
    		g.drawImage(imagF[fcnt],Fightxy.x*Pro,Fightxy.y*Pro,Pro,Pro,null);
    	}
    }
    
    public void drawHero(Graphics g) {					//绘制英雄
    	g.drawImage(hero.imag[hero.dir][Herocnt],hero.X*Pro,hero.Y*Pro,Pro,Pro,null);
    }

    public void drawMonster(Graphics g,int x,int y,int n) {
    	
    	g.drawImage(imagM[n-10][Monstercnt],x*Pro,y*Pro,Pro,Pro,null);
    }
    
    public void drawProp(Graphics g,int x,int y,int n) {
    	g.drawImage(imagP[-n],x*Pro,y*Pro,Pro,Pro,null);
    }
    
    public void drawLand(Graphics g,int x,int y,int n) { 	
		g.drawImage(imagL[n],x*Pro,y*Pro,Pro,Pro,null);
    }
    
    public void drawMap(Graphics g) {
    	int i;
    	int j;

    	int n;
    	for(i=0;i<11;i++)
    	{
    		for(j=0;j<11;j++)
    		{
    			n=game.map[hero.floor][i][j];
    			if(n>=0&&n<=10)
    			{
    				drawLand(g,j,i,n);
    			}
    			else if(n<=2)
    			{
    				drawLand(g,j,i,0);
    				drawProp(g,j,i,n);
    			}
    			else if(n>0)
    			{
    				drawLand(g,j,i,0);
    				drawMonster(g,j,i,n);
    			}
    		}
    	}
    	Update();
    	if(hero.isopen) {
    		n=game.map[hero.floor][Doorxy.y][Doorxy.x];
    		g.drawImage(imagD[Doorcolor][Doorcnt-1],Doorxy.x*Pro,Doorxy.y*Pro,Pro,Pro,null);
    	}

    }
    
    
    void Update() {
    	Main.st.repaint();
    //  Main.mm.updata();
    }
    
}
	
	
	
	
class Shake extends Thread{ 					//动画基类
	protected MyPanel mp;
	protected int cnt;
	Shake(MyPanel m){
		this.mp=m;
	}
	public void run() {}
	
}

class MonsterShake extends Shake{				//刷新怪物动作
	MonsterShake(MyPanel m) {
		super(m);	
	}
	public synchronized void run() {
		while(true) {
		mp.Monstercnt++;
		mp.Monstercnt=mp.Monstercnt%4+1;
		mp.repaint();
		
		Main.mm.Mcnt++;
		Main.mm.Mcnt=Main.mm.Mcnt%4+1;
		Main.mm.repaint();
		Main.mm.updata();
		try {
			this.sleep(250);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
}


class DoorShake extends Shake{

	DoorShake(MyPanel m) {
		super(m);
	}
	public synchronized void run() {
		mp.Doorcnt=1;
		while(true) {
			if(mp.hero.isopen)
			{
				
				mp.Doorcnt++;
				
				try {
					this.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mp.repaint();
				if(mp.Doorcnt==4)
				{
					mp.hero.isopen=false;
					return;
				}
			}
		}
	}
	
}


class FightShake extends Shake{

	FightShake(MyPanel m) {
		super(m);
	}
	public synchronized void run() {
		for(int i=1;i<=2;i++)
		{
			mp.fcnt=i;
			mp.repaint();
			try {
				this.sleep(70);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		mp.hero.isfight=false;
	}
	
}


class HeroShake extends Shake{					//刷新人物动作

	
	HeroShake(MyPanel m) {
		super(m);	
	}
	public synchronized void run() {
		while(true) {
			if(mp.hero.ismove)
			{
				mp.Herocnt++;
				mp.Herocnt%=4;
				try {
					HeroShake.sleep(20);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				mp.repaint();
				if(mp.Herocnt==0)
				{
					mp.hero.ismove=false;
					return;
				}
			}
		}
	}
	
}






class MonsterManual extends JPanel{
	Game game;
	Font font=new Font("黑体",Font.PLAIN,20);
	Image back=GameUtil.getImage("背景\\背景4.jpg");
	boolean MLife[]=new boolean[60];
	int Mcnt=1;
	MonsterManual(Game g)
	{
		game=g;
		updata();
	}
	
	void updata()
	{
		int i,j,n;
		for( i=0;i<=40;i++)  
	    {  
	        MLife[i]=false;//进行赋初值  
	    }  
		for(i=0;i<11;i++)
			for(j=0;j<11;j++)
			{
				n=game.map[Main.hero.floor][i][j];
				if(n>10)
					MLife[n-10]=true;
			}
		repaint();
	}
	
	
	public void paint(Graphics g) {	
		int i,j,n;
		int cnt=0;
		
    	super.paint(g);
    	g.drawImage(back, 0, 0, 6*MyPanel.Pro,12*MyPanel.Pro,null);
		for(i=1;i<32;i++)
		{
			if(MLife[i])
			{
				g.setFont(font);
				g.setColor(Color.white);
				g.drawImage(Main.mp.imagM[i][Mcnt], 0, Main.mp.Pro*cnt,Main.mp.Pro-10,Main.mp.Pro-10,null );
				g.drawString("生命 "+Game.MHP[i-1] ,100,45*(cnt)*2+25);
				g.drawString("攻击 "+Game.MATK[i-1] ,200,45*(cnt)*2+25);
				g.drawString("防御 "+Game.MDEF[i-1] ,300,45*(cnt)*2+25);
				g.drawString("金币 "+Game.MMoney[i-1] ,100,45*(cnt)*2+65);
				g.drawString("经验 "+Game.MEXP[i-1] ,200,45*(cnt)*2+65);
				g.drawString("损失 "+Main.mp.fight(i+10) ,300,45*(cnt)*2+65);
				cnt++;
			}
	}
}
}


class Status extends JPanel implements ActionListener{
	Hero hero;
	String s;
	JButton bu=new JButton("设置");
	static Image imagS[]=new Image[20];
	Font font=new Font("黑体",Font.BOLD,55);
	MyButton m1=new MyButton("") ;
	Image back=GameUtil.getImage("背景\\背景5.jpg");
	MyButton m2=new MyButton("") ;
	Status(Hero h)
	{
		hero=h;
		setLayout(null);
		int i;
		for(i=1;i<=4;i++)
			imagS[i]=GameUtil.getImage("状态\\"+i+".png");
		
		ImageIcon u=new ImageIcon("图片\\向上.png");
		Image up=u.getImage();
		up=up.getScaledInstance(50, 30, Image.SCALE_DEFAULT);
		u.setImage(up);
		m1.setIcon(u);
		m1.setBounds(270, 890, 60, 30);
		
		ImageIcon d=new ImageIcon("图片\\向下.png");
		Image down=d.getImage();
		down=down.getScaledInstance(50, 30, Image.SCALE_DEFAULT);
		d.setImage(down);
		m2.setIcon(d);
		m2.setBounds(270, 930, 60, 30);
		
		m1.addActionListener(this);
	    m2.addActionListener(this);
		if(hero.jump==0)
		{
			m1.setVisible(false);
			m2.setVisible(false);
		}
		add(m1);
		add(m2);
	}			
	
	public void actionPerformed(ActionEvent e){ 
		if(m1.equals(e.getSource())){
	       	if(hero.makerFloor[hero.floor+1]==1)
	       	{
	       		hero.floor++;
				
				hero.X=Game.UPfloor[hero.floor][1];
				hero.Y=Game.UPfloor[hero.floor][0];
	       	}
			
		}
		else if(m2.equals(e.getSource())) {
			if(hero.floor-1>=0&&hero.makerFloor[hero.floor-1]==1)
			{
				hero.floor--;
				
				hero.X=Game.DOWNfloor[hero.floor][1];
				hero.Y=Game.DOWNfloor[hero.floor][0];
			}
	       	
		}
	}
	
	public void paint(Graphics g) {	
		
    	super.paint(g);
		if(hero.jump==1)
		{
			m1.setVisible(true);
			m2.setVisible(true);
		}
		
		//g.drawImage(back, 0, 0, 4*MyPanel.Pro,12*MyPanel.Pro,null);
    	g.drawImage(imagS[1],0,0,MyPanel.Pro+10,MyPanel.Pro+10,null);   
    	g.setFont(font);
    	//g.setColor(Color.white);
    	g.drawString("等级：" ,130,100);
    	s=""+hero.LEVEL;
    	g.drawString(s,300,100);
    	g.drawString("生命：", 30, 180);
    	s=""+hero.HP;
    	g.drawString(s,200,180);
    	g.drawString("攻击：", 30, 255);
    	s=""+hero.ATK;
    	g.drawString(s,200,255);
    	g.drawString("防御：", 30, 330);
    	s=""+hero.DEF;
    	g.drawString(s,200,330);
    	g.drawString("金币：", 30, 405);
    	s=""+hero.Money;
    	g.drawString(s,200,405);
    	g.drawString("经验：", 30, 480);
    	s=""+hero.EXP;
    	g.drawString(s,200,480);
    	
    	g.drawImage(imagS[2],30,520,MyPanel.Pro,MyPanel.Pro,null);
    	s=""+hero.yKey+"个";
    	g.drawString(s,180,585);
    	g.drawImage(imagS[3],30,640,MyPanel.Pro,MyPanel.Pro,null);
    	s=""+hero.bKey+"个";
    	g.drawString(s,180,705);
    	g.drawImage(imagS[4],30,760,MyPanel.Pro,MyPanel.Pro,null);
    	s=""+hero.rKey+"个";
    	g.drawString(s,180,825);
    	s="第 "+hero.floor+" 关";
    	g.drawString(s,50,940);
    }

}

	
	
	
	
