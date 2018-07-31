package ħ��;

import java.applet.AudioClip;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JApplet;

public class PlayMusic {  
    public static AudioClip loadSound(String filename) {  
        URL url = null;  
        try {  
            url = new URL("file:" + filename);  
        }   
        catch (MalformedURLException e) {;}  
        return JApplet.newAudioClip(url);  
    }  
    public void playatk() {  
        AudioClip christmas = loadSound("����/atk.wav");  
        christmas.play();  
    }  
    public void playdoor() {  
        AudioClip christmas = loadSound("����/door.wav");  
        christmas.play();  
    }  
    public void playget() {  
        AudioClip christmas = loadSound("����/get.wav");  
        christmas.play();  
    }  
    public void playstair() {  
        AudioClip christmas = loadSound("����/stair.wav");  
        christmas.play();  
    }  
    
    public void playBgm(int floor)
    {
    	int i=1;
    	if(floor==0)
    		i=1;
    	if(floor>0&&floor<5)
    		i=2;
    	if(floor>=5&&floor<8)
    		i=3;
    	if(floor>=8&&floor<10)
    		i=4;
    	if(floor==11)
    		i=5;
    	AudioClip christmas = loadSound("����/"+i+".wav");  
        christmas.play();
    }
}  

/*
class Bgm extends Thread{
	
	PlayMusic P=new PlayMusic();
	public void run() {

			P.playBgm(Main.hero.floor);

	}
	
	
}*/
