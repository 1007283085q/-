package ħ��;

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
       	text.setFont(new Font("΢���ź�", 0, 30));
       	text.setForeground(Color.WHITE);
       	text.setOpaque(false);
       	layeredPane.add(text, new Integer(100),0); 
       	setBounds(370,38,1000,1000);
        // ����: 100
        if(m==0)
        { ImageIcon bg = new ImageIcon("ͼƬ\\����1.jpg");  //ͼƬ����
       	Image img = bg.getImage();  						//
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);   //��������Ӧ��С  
        bg.setImage(img); //����ͼƬ����
       	JLabel label = new JLabel(bg); 				
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("ͼƬ\\����6.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(490*1.05), (int)(490*(1.05)), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("ͼƬ\\����.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==1)
        {
        	ImageIcon bg = new ImageIcon("ͼƬ\\����6.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //����ͼƬ����
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("ͼƬ\\22.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance((int)(722*0.6), (int)(812*(0.6)), Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 750);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("ͼƬ\\����.png");
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
        	ImageIcon bg = new ImageIcon("ͼƬ\\����5.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance((int)(1200*0.9),(int)(976*0.9), Image.SCALE_DEFAULT);  
            bg.setImage(img); //����ͼƬ����
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            MyButton m1=new MyButton("��1s��+800������");
            MyButton m2=new MyButton("��4�㹥��");
            MyButton m3=new MyButton("��4�����");
            MyButton m4=new MyButton("�����̵�");
            m1.setForeground(new Color(0,0,0));//����ǰ��ɫ
            m2.setForeground(new Color(0,0,0));
            m3.setForeground(new Color(0,0,0));
            m4.setForeground(new Color(0,0,0));
            m1.setFont(new  java.awt.Font("΢���ź�",  1,  30));       
            m2.setFont(new  java.awt.Font("΢���ź�",  1,  30));       
            m3.setFont(new  java.awt.Font("΢���ź�",  1,  30));       
            m4.setFont(new  java.awt.Font("΢���ź�",  1,  30));       

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
        	ImageIcon bg = new ImageIcon("ͼƬ\\����4.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //����ͼƬ����
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("ͼƬ\\��̿�.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance((int)(877*0.6),(int)(998*0.6), Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 650);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("ͼƬ\\����.png");
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
        	ImageIcon bg = new ImageIcon("ͼƬ\\�����뺣.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //����ͼƬ����
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
            
            ImageIcon girl = new ImageIcon("ͼƬ\\����.png");
        	Image img1 = girl.getImage();  
            img1 = img1.getScaledInstance(470, 650, Image.SCALE_DEFAULT);  
            girl.setImage(img1); 
            JLabel glabel = new JLabel(girl);
            glabel.setBounds(0, 0, 1500, 650);
            layeredPane.add(glabel, new Integer(100),1);
            
            ImageIcon boy = new ImageIcon("ͼƬ\\����.png");
        	Image img2 = boy.getImage();  
            img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
            boy.setImage(img2); 
            JLabel blabel = new JLabel(boy);
            blabel.setBounds(0, 0, 450, 750);
            layeredPane.add(blabel, new Integer(100),1);
        }
        else if(m==6)
        {ImageIcon bg = new ImageIcon("ͼƬ\\����6.jpg");
       	Image img = bg.getImage();  
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
        bg.setImage(img); //����ͼƬ����
       	JLabel label = new JLabel(bg); 
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("ͼƬ\\������.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(147*1.5), (int)(375*1.5), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("ͼƬ\\����.png");
    	Image img2 = boy.getImage();  
        img2 = img2.getScaledInstance((int)(1700*0.25),(int) (2000*0.25), Image.SCALE_DEFAULT);  
        boy.setImage(img2); 
        JLabel blabel = new JLabel(boy);
        blabel.setBounds(0, 0, 450, 750);
        layeredPane.add(blabel, new Integer(100),1);}
        else if(m==7)
        {ImageIcon bg = new ImageIcon("ͼƬ\\����10.jpg");
       	Image img = bg.getImage();  
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
        bg.setImage(img); //����ͼƬ����
       	JLabel label = new JLabel(bg); 
       	label.setBounds(0, 0, 1000, 1000);
        layeredPane.add(label, new Integer(100),-1);
        
        ImageIcon girl = new ImageIcon("ͼƬ\\���.png");
    	Image img1 = girl.getImage();  
        img1 = img1.getScaledInstance((int)(147*1.5), (int)(375*1.5), Image.SCALE_DEFAULT);  
        girl.setImage(img1); 
        JLabel glabel = new JLabel(girl);
        glabel.setBounds(0, 0, 1500, 750);
        layeredPane.add(glabel, new Integer(100),1);
        
        ImageIcon boy = new ImageIcon("ͼƬ\\����.png");
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
        	ImageIcon bg = new ImageIcon("ͼƬ\\����7.jpg");
           	Image img = bg.getImage();  
            img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);  
            bg.setImage(img); //����ͼƬ����
           	JLabel label = new JLabel(bg); 
           	label.setBounds(0, 0, 1000, 1000);
            layeredPane.add(label, new Integer(100),-1);
        	
        	
        }
        //��ͼƬ�Ĳ�ͬ�Ի�������
        setContentPane(layeredPane);
        
       
        this.setVisible(true);
        this.requestFocus();
        addKeyListener(new KeyAdapter()//���̼�����ť
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
        		                 //��ϼ�
        		                 
        		                
        		                   
        		                	 }
        		           
        		         });
    }
    
    static void getflag(int m) 
    {
    	switch(m)
    	{
    	case 0:
    			messages=new String[]{". . . . . .",
    					"�����ˣ�",
    					"����˭���������",
    					"��������ط�����Ů���㱻����Ĺ���ײ���ˡ�",
    					"�����������ҵĽ������",
    					"а��Ĺ�����������Ľ�����ֻ��ʱ�������㡣",
    					"��ô�����������أ��������ȹ����ġ�",
    					"���������������������û���㹻������ȥ�������Ĺ��",
    					"���Ҹ���ô���أ��Ҵ�Ӧ����ȥ�ȹ����������ڸ���ô�죿",
    					"���ģ��¸ҵ�Ӣ�ۣ��ҿ��Խ�����ҵ���������������ܴ������Ĺ�����ǣ���������ҵ��ҵĶ�����",
    					"�ҵ�ʲô��ʲô������",
    					"����һ�����أ��м���һ��챦ʯ��",
    					"����ʲô��",
    					"����������������������ǰ�����Ա����Ĺ�����������ˡ�����ռ������¥�����ҵ���������ʮ�ּ��ϣ�������ܰ��������ң��Ҿ��ָܻ��ҵ��������������͸��㡣",
    					"�����һ����Կ��ġ�",
    					"��Ľ��ڵ����㣬��Ķ��ڵ���㣬ʮ�ּ��ڵ��߲㡣���У�¥�ϻ��кܶഫ˵�е��䱦�����ǻ����ܴ�����ġ�",
    					"�������ǣ��Ҹ���ô��ȥ�أ�",
    					"�����������Կ�ף����������ߣ������и����Կ�ף����ǵ�ʹ�����ǡ�ף����ˣ��¸ҵ�Ӣ�ۣ�",
    					};
    			break;
    	case 1:
    		messages=new String[]{"���ʮ�ּ��û����ˣ������Ҹ����ҵ�Ȩ������"};
    		break;
    	case 2:
    		messages=new String[]{"�������25���ҿ���ѡ����������һ��"};
    		break;
    	case 3:
    		messages =new String[]{"��þ��ˣ�",
    				"�ҽа��������Ǹ��̿ͣ�����Ǳ������ʱ��а���²��",
    				"��������˭���㶼���ͷ��ˣ������뿪��¥����Ҫȥ�ȹ�����",
    				"�������,���½��ʡ������ֵܻ�ɣ��һ�Ϊ���LV2�Ĵ��š�������ܰ��ҵĸ�����ң��Ҿ��ܴ�LV 18��"};
    		break;
    	case 4:
    		messages= new String[]{"��������˵�ĺ������","����Ҵ����˺�������һ�Ϊ�������·���ټ���",};
    		break;
    	case 5:
    		messages=new String[]{"���ɶ������","�������Ը��Ǵ�½�����ߣ���Ҫȥ�ȹ�����������","Ŷ������ȥ��","......","����ô�����籾��","��Ǹ����û���Ұ�������籾","û�о籾�Ϳ���Ϊ����Ϊ��","sorry,û�о籾��Ŀ���Ϊ����Ϊ��"};
    		break;
    	case 6:
    		messages=new String[]{"����ˤ��ϡ�����ˤ��ϡ�","˵�˻�","���Ϻ�ѽ","emmmm","С���Ӽ��ͺúø�"};
    		break;
    	case 7:
    		messages=new String[]{
    				"�ţ� �������ˣ������ģ�",
    				"���������ˣ�",
    				"��������װ������ز�����ͨ�ˣ������綼��һ�����ѵ�����Ǵ�˵�е�ħ����",
    				"��Ȼ�������ˣ���������Java��ħ��  ���",
    				"��_�� ˵�õ�����21���أ��ֲ�����·����",
    				"emmmm  ���ھ��Ѳ��㣬���������Ŷ�͵��������ֻ�������������  ��( ��, �� )��",
    				"���ԣ������ǲ���Ҫ��һ����",
    				"���ɣ��˼���սʤ�ң���ʵ��������֣�����",
    				"ojbk"
    				};    	
    		break;
    	case 8:
    		messages=new String[]{
    				
    				"����Ϸ�����Ŷ�ԭ����ƣ��ڴ�ͳ����Ϸ���������Լ���ѧ֪ʶ����д�ɣ�ʵ����Ҵ�֡���ȡ���ߡ��Ի��ȹ��ܣ������Ϊ���ƣ������в��㣬�������ʲô�õĽ��飬��ӭ���������۽����� ��(>��<*) \nQQ��1007283085 \n\nħ��֮�⣬Ҫ��ÿ���  (���ب�#) "
    				
    				
    				
    				};
    		break;
    	}
    }


}
