package ħ��;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MagicTower extends JFrame{			//������

	public MagicTower(Hero hero,MyPanel mp,Status st,MonsterManual mm) {
		
		this.setTitle("ħ ��");
		this.setVisible(false);
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize()); 
		//this.setSize(20*mp.Pro, 12*mp.Pro);
		 
		//this.setPreferredSize(new Dimension());
		this.setLocationRelativeTo(null);	
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		//this.setLayout(null);
		mp.setPreferredSize(new Dimension(12*MyPanel.Pro,12*MyPanel.Pro));
		st.setPreferredSize(new Dimension(4*MyPanel.Pro,12*MyPanel.Pro));
		mm.setPreferredSize(new Dimension(6*MyPanel.Pro,12*MyPanel.Pro));
		//mp.setBounds(4*MyPanel.Pro,0*MyPanel.Pro,12*MyPanel.Pro,12*MyPanel.Pro);    //  �����ֱ�Ϊ���꣬�ؼ��Ĺ��
        //st.setBounds(0,0*MyPanel.Pro,4*MyPanel.Pro,12*MyPanel.Pro);
		this.add("Center",mp);
		this.add("West",st);
		this.add("East",mm);
		//this.add("South",null);
		//this.add("North",null);
	    this.addKeyListener(mp);
	   //this.pack();
	}


}
