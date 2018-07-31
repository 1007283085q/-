package 魔塔;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Game {
	/*常量定义*/
	/*地图数组*/
	/**/
	public static final int UP=3;
	public static final int DOWN=0;
	public static final int LEFT=1;
	public static final int RIGHT=2;
	public static final int fnum=12;		
	Hero hero;
	
	Game(Hero h){
		this.hero=h;
		copyMap(InitMap);
	}

	
	public static final int UPfloor[][]={
			{1,5},
			{9,5},
			{1,0},
			{10,1},
			{9,10},
			{9,0},
			{9,9},
			{10,5},
			{1,0},
			{3,6},
			{6,4},
			{10,1}
	};
	
	public static final int DOWNfloor[][]= {
			{1,5},
			{0,1},
			{9,0},
			{9,10},
			{9,0},
			{9,9},
			{10,5},
			{0,1},
			{3,6},
			{7,6},
			{9,0},
			{10,9}
	};
	
	public static final int MHP[]= {
			50,70,200,110,150,
			400,100,150,550,300,
			900,125,100,450,1500,
			1250,2000,3333,850,900,
			1200,250,500,500,700,
			3100,1300,2400,3000,15000,
			20000,30000,60000,99999
	};

	
	public static final int MATK[]= {
			20,15,35,25,40,
	        90,20,65,160,75,
	        450,50,200,150,560,
	        500,680,1200,350,750,
	        620,120,400,115,250,
	        1150,300,2612,2212,1000,
	        1333,1700,3400,5000
			
	};
	
	public static final int MDEF[]= {
			1,2,10,5,20,
	        50,5,30,90,45,
	        330,25,110,90,460,
	        400,590,1133,200,650,
	        520,70,260,65,125,
	        1050,150,2400,1946,1000,
	        1333,1500,3000,4000
			
	};
	
	public static final int MMoney[]= {
			1,2,5,5,8,
			15,3,10,25,13,
			50,10,30,22,60,
			55,70,112,45,77,
			65,20,47,15,32,
			92,40,146,132,100,
			133,250,390,0
	};
	
	public static final int MEXP[]= {
			1,2,5,4,6,
			12,3,8,20,10,
			50,7,25,19,60,
			55,65,100,40,70,
			75,17,45,15,30,
			80,35,125,116,100,
			133,220,343,0
	};
	
	public int map[][][]; 

	public static final int InitMap[][][]={
		{
			{1,3,3,3,3,-10,3,3,3,3,1},
			{1,3,3,3,3,0,3,3,3,3,1},
			{1,3,3,3,3,0,3,3,3,3,1},
			{1,3,3,3,3,0,3,3,3,3,1},
			{1,3,3,3,3,0,3,3,3,3,1},
			{1,3,3,3,3,0,3,3,3,3,1},
			{1,1,3,3,3,0,3,3,3,1,1},
			{1,1,1,1,1,7,1,1,1,1,1},
			{5,1,5,1,0,-44,0,1,5,1,5},
			{5,5,5,5,5,0,5,5,5,5,5},
			{5,5,5,5,5,0,5,5,5,5,5},

		},
		{	//第一关
		    {-10,0,-2,11,12,11,0,0,0,0,0},
		    {1,1,1,1,1,1,1,1,1,1,0},
		    {-7,0,14,7,0,1,-7,-2,-7,1,0},
		    {-2,15,-5,1,0,1,-7,-2,-7,1,0},
		    {1,7,1,1,0,1,1,1,13,1,0},
		    {-2,15,0,1,0,7,22,11,17,1,0},
		    {-6,0,-3,1,0,1,1,1,1,1,0},
		    {1,7,1,1,0,0,0,0,0,0,0},
		    {0,15,0,1,1,9,1,1,1,7,1},
		    {-7,-8,-2,1,-4,0,0,1,-2,20,-3},
		    {-7,-34,-2,1,0,-11,0,1,-2,-2,-2},
		},		
		{	//第二关
			{-11,1,0,30,0,1,-5,-6,-2,-4,1},
			{0,1,-5,1,-8,1,-5,-6,-2,-3,1},
			{0,1,-2,1,-2,1,-5,-6,-2,29,1},
			{0,1,-2,1,-2,1,1,1,1,7,1},
			{0,1,0,1,0,0,0,7,0,0,1},
			{0,1,7,1,1,7,1,1,7,1,1},
			{0,10,0,0,0,0,1,0,29,0,1},
			{0,1,7,1,1,8,1,10,1,10,1},
			{0,1,-2,1,-8,-7,1,0,1,0,1},
			{0,1,-2,1,-8,-7,1,0,1,0,1},
			{-10,1,-5,1,-8,-7,1,-40,1,-41,1},
		},
		{	//第三关
			{-21,12,-2,1,-45,-46,-47,1,1,1,1},
			{12,-2,0,1,0,0,0,1,0,17,0},
			{-2,14,0,1,1,7,1,1,0,1,0},
			{1,7,1,1,0,14,0,1,-2,1,12},
			{0,0,0,1,1,1,0,1,-2,1,17},
			{11,1,0,17,12,17,0,1,-2,1,12},
			{11,1,1,1,1,1,0,0,0,1,0},
			{0,0,0,0,0,1,1,7,1,1,0},
			{1,1,1,1,17,1,12,0,12,1,0},
			{1,0,0,0,0,1,-6,17,-2,1,0},
			{-11,0,1,1,1,1,-5,-8,-2,1,-10},
		},
		{	//第四关
			{0,13,0,1,0,-43,0,1,0,13,0},
			{7,1,7,1,0,0,0,1,7,1,7},
			{0,1,0,1,1,10,1,1,0,1,0},
			{0,1,14,1,18,19,18,1,14,1,0},
			{17,1,-7,1,-6,18,-6,1,-7,1,17},
			{17,1,-7,1,1,9,1,1,-7,1,17},
			{12,1,0,1,20,24,20,1,0,1,12},
			{0,1,0,1,-5,20,-5,1,0,1,0},
			{0,1,0,1,1,8,1,1,0,1,0},
			{0,1,0,1,-2,0,-2,1,0,1,0},
			{-10,1,0,13,0,0,0,13,0,1,-11},
	
		},

		{	//第五关
			{-35,1,-7,1,-8,22,0,0,22,-2,-3},
			{0,1,-5,1,22,0,0,0,0,22,-2},
			{18,1,0,1,15,0,1,1,7,1,1},
			{0,7,22,1,-25,15,1,0,20,15,-41},
			{18,1,0,1,1,1,1,0,0,0,15},
			{-5,1,0,0,0,17,14,0,0,0,0},
			{-4,1,1,13,1,1,1,1,0,0,0},
			{0,-40,1,13,1,0,0,0,20,24,0},
			{1,1,1,17,1,7,1,8,1,7,1},
			{0,0,1,0,1,17,1,-4,7,0,1},
			{-11,0,17,0,0,0,1,-2,1,-10,1},
		},
		{	//第六关
			{-31,16,1,-6,1,-2,35,-33,1,-8,-8},
			{16,-2,1,-5,1,0,-2,35,1,34,-8},
			{-2,19,8,0,8,19,0,-2,1,0,34},
			{0,0,1,24,1,0,0,0,1,33,0},
			{1,1,1,9,1,1,1,1,1,9,1},
			{0,0,23,0,-2,-2,-2,0,23,0,0},
			{0,1,1,1,1,1,1,1,1,1,1},
			{0,1,18,7,18,0,0,0,0,0,1},
			{0,1,7,1,7,1,1,1,1,8,1},
			{0,1,18,1,0,0,1,1,0,0,1},
			{0,0,0,1,-10,0,7,7,0,-11,1},
		},
		

		
		{	//第七关
			
			
			{-10,0,0,0,0,0,0,0,1,1,1},
			{1,1,0,19,1,8,1,16,0,1,1},
			{1,0,19,-6,1,37,1,-5,19,0,1},
			{0,0,1,1,1,8,1,1,1,0,0},
			{0,0,8,37,8,-32,8,37,8,0,0},
			{0,1,1,1,1,8,1,1,1,1,0},
			{0,1,-7,-5,1,37,1,-6,-7,1,0},
			{0,1,-2,-7,1,8,1,-7,-2,1,0},
			{0,1,1,-3,-3,-8,-3,-3,1,1,0},
			{0,0,1,1,1,9,1,1,1,0,0},
			{1,0,0,7,-11,0,0,7,0,0,1},
		},

		{	//第八关
			{-11,1,0,0,0,0,1,0,-2,16,0},
			{0,1,0,1,1,7,1,7,1,1,0},
			{0,1,0,1,0,0,8,0,0,1,-5},
			{0,1,0,1,32,1,1,1,18,1,13},
			{18,1,0,1,-7,1,-10,0,0,1,13},
			{19,1,-6,1,-7,1,1,1,1,1,0},
			{18,1,13,1,0,0,0,1,0,19,0},
			{0,1,13,1,1,1,24,1,7,1,1},
			{0,1,0,16,0,1,16,1,0,0,0},
			{0,1,1,1,7,1,0,1,1,1,0},
			{0,0,32,0,0,1,0,35,37,35,0},
		},
		{	//第九关
			{-30,-2,0,1,1,1,0,0,0,1,0},
			{-2,0,21,7,0,0,0,1,0,7,16},
			{1,7,1,1,0,1,1,1,0,1,-2},
			{0,0,0,1,0,1,0,0,0,1,-2},
			{0,0,0,9,0,1,-11,1,0,1,-7},
			{1,8,1,1,0,1,1,1,0,1,1},
			{-6,33,-5,1,32,1,-10,1,0,1,-7},
			{1,7,1,1,0,0,0,7,0,1,-2},
			{16,-7,16,1,1,8,1,1,0,1,-2},
			{-3,16,-7,1,34,32,34,1,0,7,16},
			{-22,-2,16,7,-8,34,-8,1,0,1,0},
		},
		{	//第十关
			{0,1,1,-6,21,1,21,-5,1,1,0},
			{0,0,1,1,7,1,7,1,1,0,33},
			{0,0,0,0,0,1,0,0,0,33,-8},
			{0,1,0,1,1,1,1,1,0,1,1},
			{18,1,0,0,-2,-2,-2,0,0,1,-2},
			{19,1,0,1,1,1,1,7,1,1,-2},
			{18,1,0,0,0,-11,1,0,7,19,0},
			{0,1,1,1,1,1,1,7,1,1,0},
			{0,1,-7,-6,-5,1,0,19,0,1,-2},
			{0,1,-7,-6,-5,9,32,1,32,1,-2},
			{-10,1,-7,-6,-5,1,-3,1,-3,1,-7},
	
		},
		{
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,-49,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0},
		}
	};


	void copyMap(int m[][][]){
		int i,j,k;
		map=new int[fnum][11][11];
		for(i=0;i<fnum;i++)
			for(j=0;j<11;j++)
				for(k=0;k<11;k++)
					map[i][j][k]=m[i][j][k];
	}
	

	
	void save(int num) {
	
		try {
			FileWriter fw;
			fw = new FileWriter("hero"+num+".txt");
			BufferedWriter bw=new BufferedWriter(fw);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			bw.write(df.format(new Date()));// new Date()为获取当前系统时间
			bw.newLine();
			
			
			bw.write(""+hero.LEVEL);
			bw.newLine();
			bw.write(""+hero.HP);
			bw.newLine();
			bw.write(""+hero.ATK);
			bw.newLine();
			bw.write(""+hero.DEF);
			bw.newLine();
			bw.write(""+hero.Money);
			bw.newLine();
			bw.write(""+hero.EXP);
			bw.newLine();
			bw.write(""+hero.yKey);
			bw.newLine();
			bw.write(""+hero.bKey);
			bw.newLine();
			bw.write(""+hero.rKey);
			bw.newLine();
			bw.write(""+hero.X);
			bw.newLine();
			bw.write(""+hero.Y);
			bw.newLine();
			bw.write(""+hero.floor);
			bw.newLine();
			bw.write(""+hero.cross);
			bw.newLine();
			bw.write(""+hero.jump);
			bw.newLine();
			for(int i=0;i<=11;i++)
			{
				bw.write(""+hero.makerFloor[i]);
				bw.newLine();
			}
			
			
			bw.close();
			fw.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		/////////////////////////////////////////////////
		try {
			FileWriter fw;
			fw = new FileWriter("map"+num+".txt");
			BufferedWriter bw=new BufferedWriter(fw);
			int i,j,k;
			for(i=0;i<Game.fnum;i++)
				for(j=0;j<11;j++)
					for(k=0;k<11;k++)
					{
						bw.write(""+map[i][j][k]);
						bw.newLine();
					}
			
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	void read(Hero hero,int num) {
		
			try {
			FileReader fr=new FileReader("hero"+num+".txt");
			BufferedReader br=new BufferedReader(fr); 
			String time=br.readLine();
			
			hero.LEVEL=Integer.parseInt(br.readLine());			
			hero.HP=Integer.parseInt(br.readLine());		
			hero.ATK=Integer.parseInt(br.readLine());
			hero.DEF=Integer.parseInt(br.readLine());
			hero.Money=Integer.parseInt(br.readLine());
			hero.EXP=Integer.parseInt(br.readLine());	
			hero.yKey=Integer.parseInt(br.readLine());	
			hero.bKey=Integer.parseInt(br.readLine());	
			hero.rKey=Integer.parseInt(br.readLine());		
			hero.X=Integer.parseInt(br.readLine());		
			hero.Y=Integer.parseInt(br.readLine());		
			hero.floor=Integer.parseInt(br.readLine());
			hero.cross=Integer.parseInt(br.readLine());
			hero.jump=Integer.parseInt(br.readLine());
			for(int i=0;i<=11;i++)
			{
				hero.makerFloor[i]=Integer.parseInt(br.readLine());
			}
			

			br.close();
			fr.close();		
		} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {			
					e.printStackTrace();
			}
		
		///////////////////////////////////////////////////	
			
			try {
			FileReader fr=new FileReader("map"+num+".txt");
			BufferedReader br=new BufferedReader(fr); 
			int i,j,k;
			for(i=0;i<Game.fnum;i++)
				for(j=0;j<11;j++)
					for(k=0;k<11;k++)
					{
						map[i][j][k]=Integer.parseInt(br.readLine());
					}
			
			
			
			br.close();		
			fr.close();
		} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {			
					e.printStackTrace();
			}
		
	}
	
	
}	





class Win extends Exception{
	public Win() {
		
	}
}

class Lost extends Exception{
	public Lost() {
		
	}
}
