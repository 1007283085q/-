package 魔塔;

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
       	text.setFont(new Font("微软雅黑", 0, 30));
       	text.setForeground(Color.WHITE);
       	text.setOpaque(false);
       	layeredPane.add(text, new Integer(100),0); 
       	setBounds(370,38,1000,1000);
        // 层数: 100
        if(m==0)
        { ImageIcon bg = new ImageIcon("图片\\背景1.jpg");  //图片对象
       	Image img = bg.getImage();  						//
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);   //设置自适应大小  
        bg.setImage(img); //设置图片满屏
       	JLabel label = new JLabel(bg); 				
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("图片\\仙子6.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(490*1.05), (int)(490*(1.05)), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("图片\\男主.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==1)
        {
        	ImageIcon bg = new ImageIcon("图片\\背景6.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //设置图片满屏
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("图片\\22.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance((int)(722*0.6), (int)(812*(0.6)), Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 750);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("图片\\男主.png");
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
        	ImageIcon bg = new ImageIcon("图片\\背景5.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance((int)(1200*0.9),(int)(976*0.9), Image.SCALE_DEFAULT);  
            bg.setImage(img); //设置图片满屏
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            MyButton m1=new MyButton("续1s（+800生命）");
            MyButton m2=new MyButton("加4点攻击");
            MyButton m3=new MyButton("加4点防御");
            MyButton m4=new MyButton("结束商店");
            m1.setForeground(new Color(0,0,0));//设置前景色
            m2.setForeground(new Color(0,0,0));
            m3.setForeground(new Color(0,0,0));
            m4.setForeground(new Color(0,0,0));
            m1.setFont(new  java.awt.Font("微软雅黑",  1,  30));       
            m2.setFont(new  java.awt.Font("微软雅黑",  1,  30));       
            m3.setFont(new  java.awt.Font("微软雅黑",  1,  30));       
            m4.setFont(new  java.awt.Font("微软雅黑",  1,  30));       

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
        	ImageIcon bg = new ImageIcon("图片\\背景4.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //设置图片满屏
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("图片\\真刺客.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance((int)(877*0.6),(int)(998*0.6), Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 650);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("图片\\男主.png");
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
        	ImageIcon bg = new ImageIcon("图片\\老人与海.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //设置图片满屏
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("图片\\老人.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance(470, 650, Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 650);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("图片\\男主.png");
        	Image img2 = boy.getImage();  
            img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
            boy.setImage(img2); 
            JLabel blabel = new JLabel(boy);
            blabel.setBounds(0, 0, 450, 750);
            layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==6)
        {ImageIcon bg = new ImageIcon("图片\\背景6.jpg");
       	Image img = bg.getImage();  
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
        bg.setImage(img); //设置图片满屏
       	JLabel label = new JLabel(bg); 
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("图片\\老奶奶.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(147*1.5), (int)(375*1.5), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("图片\\男主.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);}
        else if(m==7)
        {ImageIcon bg = new ImageIcon("图片\\背景10.jpg");
       	Image img = bg.getImage();  
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
        bg.setImage(img); //设置图片满屏
       	JLabel label = new JLabel(bg); 
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("图片\\彪哥.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(147*1.5), (int)(375*1.5), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("图片\\男主.png");
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
        	ImageIcon bg = new ImageIcon("图片\\背景7.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //设置图片满屏
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
        	
        	
        }
        //对图片的不同对话的设置
        setContentPane(layeredPane);
        
       
        this.setVisible(true);
        this.requestFocus();
        addKeyListener(new KeyAdapter()//键盘监听按钮
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
        		                 //组合键
        		                 
        		                
        		                   
        		                	 }
        		           
        		         });
    }
    
    static void getflag(int m) 
    {
    	switch(m)
    	{
    	case 0:
    			messages=new String[]{". . . . . .",
    					"你醒了！",
    					"你是谁？我在哪里？",
    					"我是这个地方的仙女，你被这里的怪物撞倒了。",
    					"…剑，剑，我的剑在哪里？",
    					"邪恶的怪物拿走了你的剑，我只有时间来救你。",
    					"那么公主在哪里呢？我是来救公主的。",
    					"公主在这座塔里，但现在你没有足够的力量去打败那里的怪物。",
    					"那我该怎么办呢？我答应国王去救公主，我现在该怎么办？",
    					"别担心，勇敢的英雄，我可以借给你我的力量，这样你就能打败塔里的怪物。但是，你必须先找到我的东西。",
    					"找到什么？什么东西？",
    					"这是一个宝藏，中间有一块红宝石。",
    					"它做什么？",
    					"我是这座塔的卫兵，不久前，来自北方的怪物军队入侵了。他们占领了塔楼，把我的力量锁在十字架上，如果你能把它带给我，我就能恢复我的力量并把它们送给你。",
    					"……我会试试看的。",
    					"你的剑在第三层，你的盾在第五层，十字架在第七层。还有，楼上还有很多传说中的珍宝，他们会给你很大帮助的。",
    					"……但是，我该怎么进去呢？",
    					"我这儿有三把钥匙，把它们拿走，塔里有更多的钥匙，明智地使用它们。祝你好运，勇敢的英雄！",
    					};
    			break;
    	case 1:
    		messages=new String[]{"你把十字架拿回来了！现在我给你我的权力。…"};
    		break;
    	case 2:
    		messages=new String[]{"如果你有25点金币可以选择下面任意一项"};
    		break;
    	case 3:
    		messages =new String[]{"你得救了！",
    				"我叫阿兰竹，我是个刺客，我在潜入塔里时被邪恶俘虏。",
    				"不管你是谁，你都被释放了，现在离开塔楼。我要去救公主。",
    				"万物皆虚,万事皆允。加入兄弟会吧，我会为你打开LV2的大门。如果你能把我的镐带给我，我就能打开LV 18层"};
    		break;
    	case 4:
    		messages= new String[]{"这是你所说的鹤嘴锄吗？","你给我带来了鹤嘴锄！我会为你打开这条路，再见！",};
    		break;
    	case 5:
    		messages=new String[]{"你瞅啥！！！","我是来自盖亚大陆的勇者，我要去救公主，别拦我","哦，那你去吧","......","你怎么不按剧本来","抱歉导演没给我安排这个剧本","没有剧本就可以为所欲为啊","sorry,没有剧本真的可以为所欲为的"};
    		break;
    	case 6:
    		messages=new String[]{"こんにちは、こんにちは。","说人话","早上好呀","emmmm","小伙子加油好好干"};
    		break;
    	case 7:
    		messages=new String[]{
    				"嗯？ 换背景了？这是哪？",
    				"你终于来了！",
    				"看你这身装束，想必不是普通人，连画风都不一样，难道你就是传说中的魔王？",
    				"居然被看穿了！不错，在下Java大魔王  彪哥",
    				"→_→ 说好的你在21层呢，又不按套路出牌",
    				"emmmm  由于经费不足，加上制作团队偷懒，我们只好在这里相见了  ㄟ( ▔, ▔ )ㄏ",
    				"所以，我们是不是要打一架了",
    				"来吧，菜鸡，战胜我，大实验给你满分！！！",
    				"ojbk"
    				};    	
    		break;
    	case 8:
    		messages=new String[]{
    				
    				"本游戏是由团队原创设计，在传统的游戏规则上用自己所学知识独立写成，实现玩家打怪、获取道具、对话等功能，整体较为完善，但仍有不足，如果你有什么好的建议，欢迎和我们讨论交流！ φ(>ω<*) \nQQ：1007283085 \n\n魔塔之外，要你好看！  (▼ヘ▼#) "
    				
    				
    				
    				};
    		break;
    	}
    }


}
