package ethel.main;

public class Ethel {
	
	public static int WIDTH = 640;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int SCALE = 2;
	public static String TITLE = "Game";
	public static int SYNC_FPS = 60;
	
	public static void main(String[] args){
		new Ethel();
	}
	
	public Ethel(){
		new GameLoop();
	}
}
