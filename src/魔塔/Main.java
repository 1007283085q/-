package Ä§Ëþ;

public class Main {

	public static Java_JFrame jf=new Java_JFrame();
	public static Hero hero=new Hero();
	public static Game game=new Game(hero);
	public static Status st=new Status(hero);
	public static MonsterManual mm=new MonsterManual(game);
	public static MyPanel mp=new MyPanel(hero,game);		
	public static MagicTower ma=new MagicTower(hero,mp,st,mm);
	public static ReadWindows rw=new ReadWindows();
	public static SaveWindows sw=new SaveWindows();
	public static Menu me=new Menu();
	public static aboutGame ag=new aboutGame();
	public static void main(String[] args) {
		
		
	}

}
