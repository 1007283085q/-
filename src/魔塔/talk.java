package 徴満;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class talk extends JFrame {

	static JTextArea text=new JTextArea(20,20);
	private int  count=0;
	static String[] messages;
    talk(int m) {
    	count=1;
    	requestFocus();
    	setVisible(false);
        setUndecorated(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        text.setLineWrap(true);
        JLayeredPane layeredPane = new JLayeredPane();
    	text.setBounds(100,750,800,200);
    	text.setEditable(false);
       	text.setText(messages[0]);
       	text.setFont(new Font("裏罷囘菜", 0, 30));
       	text.setForeground(Color.WHITE);
       	text.setOpaque(false);
       	layeredPane.add(text, new Integer(100),0); 
       	setBounds(370,38,1000,1000);
        // 蚊方: 100
        if(m==0)
        { ImageIcon bg = new ImageIcon("夕頭\\嘘尚1.jpg");  //夕頭斤��
       	Image img = bg.getImage();  						//
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);   //譜崔徭癖哘寄弌  
        bg.setImage(img); //譜崔夕頭諾徳
       	JLabel label = new JLabel(bg); 				
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("夕頭\\鷲徨6.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(490*1.05), (int)(490*(1.05)), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("夕頭\\槻麼.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==1)
        {
        	ImageIcon bg = new ImageIcon("夕頭\\嘘尚6.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //譜崔夕頭諾徳
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("夕頭\\22.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance((int)(722*0.6), (int)(812*(0.6)), Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 750);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("夕頭\\槻麼.png");
        	Image img2 = boy.getImage();  
            img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
            boy.setImage(img2); 
            JLabel blabel = new JLabel(boy);
            blabel.setBounds(0, 0, 450, 750);
            layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==2)
        {

        	text.setBounds(100,250,800,50);

           	text.setForeground(Color.red);
        	ImageIcon bg = new ImageIcon("夕頭\\嘘尚5.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance((int)(1200*0.9),(int)(976*0.9), Image.SCALE_DEFAULT);  
            bg.setImage(img); //譜崔夕頭諾徳
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            MyButton m1=new MyButton("偬1s��+800伏凋��");
            MyButton m2=new MyButton("紗4泣好似");
            MyButton m3=new MyButton("紗4泣契囮");
            MyButton m4=new MyButton("潤崩斌糾");
            m1.setForeground(new Color(0,0,0));//譜崔念尚弼
            m2.setForeground(new Color(0,0,0));
            m3.setForeground(new Color(0,0,0));
            m4.setForeground(new Color(0,0,0));
            m1.setFont(new  java.awt.Font("裏罷囘菜",  1,  30));       
            m2.setFont(new  java.awt.Font("裏罷囘菜",  1,  30));       
            m3.setFont(new  java.awt.Font("裏罷囘菜",  1,  30));       
            m4.setFont(new  java.awt.Font("裏罷囘菜",  1,  30));       

            m1.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
            		if(Main.hero.Money>=25)
            		{
            			Main.hero.HP+=800;
            			Main.hero.Money-=25;

            		}
            		        		}
        	});
            
            m2.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
            		if(Main.hero.Money>=25)
            		{
            			Main.hero.ATK+=4;
            			Main.hero.Money-=25;
            		}
        		}
        	});
            
            m3.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
            		if(Main.hero.Money>=25)
            		{
            			Main.hero.DEF+=4;
            			Main.hero.Money-=25;
            		}
            	}
        	});
            
            m4.addActionListener(new ActionListener() {
            	public void actionPerformed(ActionEvent evt) {
            		dispose();
        		}
        	});
            m1.setBounds(50, 330, 800,80);
            m2.setBounds(50, 430, 800,80);
            m3.setBounds(50, 530, 800,80);
            m4.setBounds(50, 630, 800,80);

            layeredPane.add(m1, new Integer(100),1);
            layeredPane.add(m2, new Integer(100),1);
            layeredPane.add(m3, new Integer(100),1);
            layeredPane.add(m4, new Integer(100),1);
            
        }
        else if(m==3)
        {
        	ImageIcon bg = new ImageIcon("夕頭\\嘘尚4.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //譜崔夕頭諾徳
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("夕頭\\寔缶人.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance((int)(877*0.6),(int)(998*0.6), Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 650);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("夕頭\\槻麼.png");
        	Image img2 = boy.getImage();  
            img2 = img2.getScaledInstance((int)(1700*0.27),(int) (2000*0.27), Image.SCALE_DEFAULT);  
            boy.setImage(img2); 
            JLabel blabel = new JLabel(boy);
            blabel.setBounds(0, 0, 400, 650);
            layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==4)
        {}
        else if(m==5)
        {
        	ImageIcon bg = new ImageIcon("夕頭\\析繁嚥今.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //譜崔夕頭諾徳
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("夕頭\\析繁.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance(470, 650, Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 650);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("夕頭\\槻麼.png");
        	Image img2 = boy.getImage();  
            img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
            boy.setImage(img2); 
            JLabel blabel = new JLabel(boy);
            blabel.setBounds(0, 0, 450, 750);
            layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==6)
        {ImageIcon bg = new ImageIcon("夕頭\\嘘尚6.jpg");
       	Image img = bg.getImage();  
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
        bg.setImage(img); //譜崔夕頭諾徳
       	JLabel label = new JLabel(bg); 
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("夕頭\\析通通.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(147*1.5), (int)(375*1.5), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("夕頭\\槻麼.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);}
        else if(m==7)
        {ImageIcon bg = new ImageIcon("夕頭\\嘘尚10.jpg");
       	Image img = bg.getImage();  
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
        bg.setImage(img); //譜崔夕頭諾徳
       	JLabel label = new JLabel(bg); 
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("夕頭\\焔悟.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(147*1.5), (int)(375*1.5), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("夕頭\\槻麼.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);}
        else if(m==8)
        {
        	
        	this.setSize(1000,1000);
        	this.setLocationRelativeTo(null);
        	setDefaultCloseOperation(1);
        	setUndecorated(false);
        	text.setBounds(200,200,600,600);
        	text.setForeground(Color.BLACK);
        	ImageIcon bg = new ImageIcon("夕頭\\嘘尚7.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //譜崔夕頭諾徳
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
        	
        	
        }
        //斤夕頭議音揖斤三議譜崔
        setContentPane(layeredPane);
        
       
        this.setVisible(true);
        this.requestFocus();
        addKeyListener(new KeyAdapter()//囚徒酌油梓泥
        		         {
        					
        		             public void keyPressed(KeyEvent e)
        		             {
        		            	
        		                 if(e.getKeyCode()==KeyEvent.VK_SPACE)
        		                 { 
        		                	if(count==messages.length) 
        		                {
        		                	 dispose();return;
        		                }
        		                	else
        		                {
        		                	text.setText(messages[count]);
        		                }
        		                 count++;
        		                 }
        		                 //怏栽囚
        		                 
        		                
        		                   
        		                	 }
        		           
        		         });
    }
    
    static void getflag(int m) 
    {
    	switch(m)
    	{
    	case 0:
    			messages=new String[]{". . . . . .",
    					"低佰阻��",
    					"低頁豊�仁參敖沈錚�",
    					"厘頁宸倖仇圭議鷲溺��低瓜宸戦議講麗弉宜阻。",
    					"´州��州��厘議州壓陳戦��",
    					"舒具議講麗鎮恠阻低議州��厘峪嗤扮寂栖照低。",
    					"椎担巷麼壓陳戦椿�仁卻農款塙�麼議。",
    					"巷麼壓宸恙満戦��徽�嶬敖稈屍俔禮撒珍α身ゴ魄楪農鏥長嵶錙�",
    					"椎厘乎奕担一椿�仁甸靦�忽藍肇照巷麼��厘�嶬攜痴�担一��",
    					"艶毅伉��啾糊議哂俛��厘辛參処公低厘議薦楚��宸劔低祥嬬嬉移満戦議講麗。徽頁��低駅倬枠孀欺厘議叫廉。",
    					"孀欺焚担�進加感�廉��",
    					"宸頁匯倖右茄��嶄寂嗤匯翠碕右墳。",
    					"万恂焚担��",
    					"厘頁宸恙満議寮汚��音消念��栖徭臼圭議講麗嘱錦秘盃阻。麿断媼糟阻満促��委厘議薦楚迄壓噴忖尺貧��泌惚低嬬委万揮公厘��厘祥嬬志鹸厘議薦楚旺委万断僕公低。",
    					"´´厘氏編編心議。",
    					"低議州壓及眉蚊��低議芹壓及励蚊��噴忖尺壓及鈍蚊。珊嗤��促貧珊嗤載謹勧傍嶄議寇右��麿断氏公低載寄逸廁議。",
    					"´´徽頁��厘乎奕担序肇椿��",
    					"厘宸隅嗤眉委埒革��委万断鎮恠��満戦嗤厚謹議埒革��苧崘仇聞喘万断。廝低挫塰��啾糊議哂俛��",
    					};
    			break;
    	case 1:
    		messages=new String[]{"低委噴忖尺鎮指栖阻�］嶬變匕�低厘議幡薦。´"};
    		break;
    	case 2:
    		messages=new String[]{"泌惚低嗤25泣署衛辛參僉夲和中販吭匯��"};
    		break;
    	case 3:
    		messages =new String[]{"低誼照阻��",
    				"厘出唖声幢��厘頁倖缶人��厘壓捻秘満戦扮瓜舒具拳族。",
    				"音砿低頁豊��低脅瓜瞥慧阻���嶬收訖�満促。厘勣肇照巷麼。",
    				"嵐麗峻倡,嵐並峻塋。紗秘儘宮氏杏��厘氏葎低嬉蝕LV2議寄壇。泌惚低嬬委厘議娯揮公厘��厘祥嬬嬉蝕LV 18蚊"};
    		break;
    	case 4:
    		messages= new String[]{"宸頁低侭傍議祭恁噛宅��","低公厘揮栖阻祭恁噛�［匯疥�低嬉蝕宸訳揃��壅需��",};
    		break;
    	case 5:
    		messages=new String[]{"低樺俵�。。�","厘頁栖徭固冉寄遜議啾宀��厘勣肇照巷麼��艶盛厘","填��椎低肇杏","......","低奕担音梓丞云栖","宇埜擬處短公厘芦電宸倖丞云","短嗤丞云祥辛參葎侭圀葎亜","sorry,短嗤丞云寔議辛參葎侭圀葎議"};
    		break;
    	case 6:
    		messages=new String[]{"こんにちは、こんにちは。","傍繁三","壼貧挫兔","emmmm","弌誌徨紗嗟挫挫孤"};
    		break;
    	case 7:
    		messages=new String[]{
    				"狹�� 算嘘尚阻�腎睚把庁�",
    				"低嶮噐栖阻��",
    				"心低宸附廾崩���覬慍司覇嬪�繁��銭鮫欠脅音匯劔��佃祇低祥頁勧傍嶄議徴藍��",
    				"肖隼瓜心刊阻�＿惨蹌�壓和Java寄徴藍  焔悟",
    				"★_★ 傍挫議低壓21蚊椿��嗽音梓耗揃竃兎",
    				"emmmm  喇噐将継音怎��紗貧崙恬妖錦裕請��厘断峪挫壓宸戦�犲�阻  ��( ��, �� )��",
    				"侭參��厘断頁音頁勣嬉匯尺阻",
    				"栖杏��暇痔��媾覆厘��寄糞刮公低諾蛍�。。�",
    				"ojbk"
    				};    	
    		break;
    	case 8:
    		messages=new String[]{
    				
    				"云嗄老頁喇妖錦圻幹譜柴��壓勧由議嗄老号夸貧喘徭失侭僥岑紛鏡羨亟撹��糞�嵳羲甸鮃屐∋馮ゝ西漾�斤三吉孔嬬��屁悶熟葎頼鋲��徽挽嗤音怎��泌惚低嗤焚担挫議秀咏��散哭才厘断網胎住送�� φ(>ω<*) \nQQ��1007283085 \n\n徴満岻翌��勣低挫心��  (��ヘ��#) "
    				
    				
    				
    				};
    		break;
    	}
    }


}
