package ħ��;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class Java_JFrame extends JFrame implements ActionListener  
{  
    //����һ��JLayeredPane���ڷֲ�ġ�  
    JLayeredPane layeredPane;  
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������  
    JPanel jp;  
    JLabel jl;  
    ImageIcon image;  
    JPanel card;  
     CardLayout cl;  //�����趨��Ƭ
    //����һ����ť���ڲ��Եġ�  
    JButton jb;  
    JPanel jpanel;
    static MyButton button11;
    static MyButton button12;
    static MyButton button13;
    static MyButton button14;
    static MyButton button15;
    JPanel cardPanel;
    public Java_JFrame()  
    {  
        layeredPane=new JLayeredPane();  
        image=new ImageIcon("ͼƬ\\����3.jpg");//�����һ��ͼ�Ϳ��Կ���Ч����        
        //������������Щ����  
        
        
       	Image img = image.getImage();  						//
        img = img.getScaledInstance(1000, 1000, Image.SCALE_DEFAULT);   //��������Ӧ��С  
        image.setImage(img); //����ͼƬ����
        
        jp=new JPanel();  
        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  

        jl=new JLabel(image);  
//      jl.setBounds(0,0,image.getIconWidth(),image.getIconHeight());  
        jp.add(jl);  

        //����һ�����԰�ť  
        jpanel = new JPanel();
        jpanel.setLayout(null);
        jpanel.setPreferredSize(new Dimension(400, 400));  
        button11 = new MyButton("��ʼ��Ϸ");
        button12 = new MyButton("��ȡ�浵");
        button14 = new MyButton("������Ϸ");
        button15 = new MyButton("������Ϸ");
        button11.setBounds(400,300,200,50);
        button12.setBounds(400,370,200,50);
        button14.setBounds(400,440,200,50);
        button15.setBounds(400,510,200,50);
        jpanel.add(button11);
        jpanel.add(button12);
        jpanel.add(button14);
        jpanel.add(button15); 
       
        //��jp�ŵ���ײ㡣                                    /*��ι�ϵ�ɼ�����2�����ע��*/
        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);  
        //��jb�ŵ���һ��ĵط�  
        layeredPane.add(button11,JLayeredPane.MODAL_LAYER);  
        layeredPane.add(button12,JLayeredPane.MODAL_LAYER);   
        layeredPane.add(button14,JLayeredPane.MODAL_LAYER);  
        layeredPane.add(button15,JLayeredPane.MODAL_LAYER);  
        //layeredPane.add(cardPanel,JLayeredPane.MODAL_LAYER);   
        button11.addActionListener(this); 
        button12.addActionListener(this); 
        button14.addActionListener(this); 
        button15.addActionListener(this); 
        
        this.setLayeredPane(layeredPane);  
        this.setSize(image.getIconWidth(),image.getIconHeight());  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        this.setLocation(image.getIconWidth(),image.getIconHeight());  
        this.setVisible(true);  
        this.setSize(1000, 800);
        setLocationRelativeTo(null);
		setResizable(false);
    }
    
    public void actionPerformed(ActionEvent e) {  

        //����ź�Դ  
       if (button11.equals(e.getSource())) {  
        // J.cl.next(J.cardPanel);
       	setVisible(false);
       	
       		Main.hero.init();
       		Main.game.copyMap(Game.InitMap);
       		Main.ma.repaint();
       		Main.ma.setVisible(true);
       		
       }  
             
       else if (button12.equals(e.getSource())) {  
    	   
       		Main.rw.Show();
       	
     
       }  
     
       else if (button14.equals(e.getSource())) {  
          // Main.ag.setVisible(true);
           //code  
    	   Main.mp.Talk(8);
       }  
       else if (button15.equals(e.getSource())) {  
       	System.exit(0);
       //code    
       }  
   }
    
    
}


class Menu extends JFrame implements ActionListener{
	MyButton m1=new MyButton("��ȡ��Ϸ") ;
	MyButton m2=new MyButton("������Ϸ") ;
	MyButton m3=new MyButton("�������˵�") ;
	MyButton m4=new MyButton("������Ϸ") ;
	Menu(){
		 setUndecorated(true);	     
		 setSize(1000,800);
	     setLocationRelativeTo(null);
	     setLayout(new GridLayout(4,1));
	     //setDefaultCloseOperation(1);
	     m1.addActionListener(this);
	     m2.addActionListener(this);
	     m3.addActionListener(this);
	     m4.addActionListener(this);
	     
	     add(m1);
	     add(m2);
	     add(m3);
	     add(m4);
	     repaint();
	     setVisible(false);
	          	     
	}
	
	public void actionPerformed(ActionEvent e){ 
		if(m1.equals(e.getSource())){
	       	
			Main.rw.Show();
	   		Main.rw.setVisible(true);
	   		
	   		setVisible(false);
		}
		else if(m2.equals(e.getSource())) {
			
			Main.sw.Show();
	       	Main.sw.setVisible(true);
			
	   		setVisible(false);
			
			
		}
		else if(m3.equals(e.getSource())) {
			   		
	   		
	   		Main.jf.setVisible(true);
	   		Main.ma.setVisible(false);
	   		setVisible(false);
		}
		else if(m4.equals(e.getSource())) {
			
	   		setVisible(false);
		}
	} 
	
	
}

class ReadWindows extends JFrame implements ActionListener{
	
	
	MyButton m1=new MyButton("�浵1") ;
	MyButton m2=new MyButton("�浵2") ;
	MyButton m3=new MyButton("�浵3") ;
	MyButton m4=new MyButton("�浵4") ;
	
	ReadWindows(){
		 //setUndecorated(true);	     
		 setSize(1000,800);
	     setLocationRelativeTo(null);
	     setLayout(new GridLayout(2,2));
	     setDefaultCloseOperation(1);
	     setTitle("��ȡ��Ϸ");
	     updata();
	     m1.addActionListener(this);
	     m2.addActionListener(this);
	     m3.addActionListener(this);
	     m4.addActionListener(this);
	     
	     add(m1);
	     add(m2);
	     add(m3);
	     add(m4);
	     repaint();
	     setVisible(false);
	          
	     
	}
	
	void Show() {
		updata();
		setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e){ 
		if(m1.equals(e.getSource())){
	       	Main.game.read(Main.hero,1);
	   		Main.ma.repaint();
	   		Main.ma.setVisible(true);
	   		
	   		Main.me.setVisible(false);
	   		Main.jf.setVisible(false);
	   		setVisible(false);
		}
		else if(m2.equals(e.getSource())) {
			
	       	Main.game.read(Main.hero,2);
	   		Main.ma.repaint();
	   		Main.ma.setVisible(true);
	   		
	   		Main.me.setVisible(false);
	   		Main.jf.setVisible(false);
	   		setVisible(false);
			
			
		}
		else if(m3.equals(e.getSource())) {
			
	       	Main.game.read(Main.hero,3);
	   		Main.ma.repaint();
	   		Main.ma.setVisible(true);
	   		
	   		Main.me.setVisible(false);
	   		Main.jf.setVisible(false);
	   		setVisible(false);
		}
		else if(m4.equals(e.getSource())) {
			
	       	Main.game.read(Main.hero,4);
	   		Main.ma.repaint();
	   		Main.ma.setVisible(true);
	   		
	   		Main.me.setVisible(false);
	   		Main.jf.setVisible(false);
	   		setVisible(false);
		}
	} 
	
	void updata() {
		m1.setText(ReadTime(1));
		m2.setText(ReadTime(2));
		m3.setText(ReadTime(3));
		m4.setText(ReadTime(4));
		repaint();
	}
	String ReadTime(int n) {
		String t1,name;
		try {
			FileReader fr1 = new FileReader("hero"+n+".txt");
			BufferedReader br1=new BufferedReader(fr1);
			t1=br1.readLine();
			br1.close();
			fr1.close();
			name="�浵����:"+"\n"+t1;
			return name;
			
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	
}


class SaveWindows extends ReadWindows{
	SaveWindows()
	{
		super();
		setTitle("������Ϸ");
	}
	
	public void actionPerformed(ActionEvent e){ 
		if(m1.equals(e.getSource())){
	       Main.game.save(1);
	       
	   		Main.jf.setVisible(false);
	   		setVisible(false);
		}
		else if(m2.equals(e.getSource())) {
			
			 Main.game.save(2);
	   		
	   		
	   		Main.jf.setVisible(false);
	   		setVisible(false);
			
			
		}
		else if(m3.equals(e.getSource())) {
			
			 Main.game.save(3);
	   		
	   		
	   		Main.jf.setVisible(false);
	   		setVisible(false);
		}
		else if(m4.equals(e.getSource())) {
			
			 Main.game.save(4);
	   		
	   		
	   		Main.jf.setVisible(false);
	   		setVisible(false);
		}
	}
}



class aboutGame extends JFrame{
	static JTextArea text=new JTextArea(20,20);
	aboutGame(){
		 setSize(1000,800);
	     setLocationRelativeTo(null);
	     setVisible(false);
	     setDefaultCloseOperation(1);
	     text.setLineWrap(true);        //�����Զ����й��� 
	     text.setWrapStyleWord(true);            // ������в����ֹ���
	     this.setLayout(null);
	     text.setBounds(200,200,600,600);
	    	text.setEditable(false);
	       	text.setText("����Ϸ�����Ŷ�ԭ����ƣ��ڴ�ͳ����Ϸ���������Լ���ѧ֪ʶ����д�ɣ�ʵ����Ҵ�֡���ȡ���ߡ��Ի��ȹ��ܣ������Ϊ���ƣ������в��㣬�������ʲô�õĽ��飬��ӭ���������۽����� ��(>��<*)\r\n" + 
	       			"QQ��1007283085\r\n" + 
	       			"\n" +
	       			"ħ��֮�⣬Ҫ��ÿ���  (���ب�#) \r\n" + 
	       			"");
	       	text.setFont(new Font("΢���ź�", 0, 30));
	       	//text.setForeground(Color.WHITE);
	       	text.setOpaque(false);
	       	add(text);
	     
	}
	
}


