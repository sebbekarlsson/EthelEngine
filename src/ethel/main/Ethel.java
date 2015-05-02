package ethel.main;

import java.awt.Dimension;
import java.util.ArrayList;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import ethel.main.graphics.TextureBank;
import ethel.main.physics.Physics;
import ethel.test.TestScene;

public class Ethel {
	
	public static int WIDTH = 640;
	public static int HEIGHT = WIDTH / 16 * 9;
	public static int SCALE = 2;
	public static Dimension DISPLAY_SIZE = new Dimension(WIDTH * SCALE, HEIGHT * SCALE);
	public static String TITLE = "Game";
	public static int SYNC_FPS = 60;
	public static ArrayList<Scene> SCENES = new ArrayList<Scene>();
	public static int SCENEINDEX = 0;
	public static TextureBank texturebank;
	public static Physics physics = new Physics();
	
	public static void main(String[] args){
		new Ethel();
		
	}
	
	public Ethel(){
		try {
			Display.setDisplayMode(new DisplayMode(Ethel.DISPLAY_SIZE.width, Ethel.DISPLAY_SIZE.height));
			Display.setTitle(Ethel.TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		initGraphics();
		
		texturebank = new TextureBank();
		SCENES.add(new TestScene());
		
		physics.start();
		
		while(!Display.isCloseRequested()){
			Scene scene = Ethel.getCurrentScene();
			Camera camera = scene.camera;
			
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glClearColor(scene.backgroundcolor.getRed()/255, scene.backgroundcolor.getGreen()/255, scene.backgroundcolor.getBlue()/255, 1f);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			GL11.glColor3f(1, 1, 1);
			
			
			
			GL11.glPushMatrix();
			GL11.glTranslatef(-camera.x, -camera.y, -camera.z);
			
			getCurrentScene().update();
			
			GL11.glPopMatrix();

			Display.sync(Ethel.SYNC_FPS);
			Display.update();

		}
		
		System.out.println("Game was terminated");
		System.exit(0);
	}
	

	private void initGraphics(){
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
		GL11.glAlphaFunc(GL11.GL_GREATER,0.2f); 
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Ethel.DISPLAY_SIZE.width, Ethel.DISPLAY_SIZE.height, 0, -1, 100);
		//GLU.gluPerspective(45.0f, ((float)Ethel.DISPLAY_SIZE.width) / ((float)Ethel.DISPLAY_SIZE.height), -0.01f, 100f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		
	}
	
	public static Scene getCurrentScene(){
		return SCENES.get(SCENEINDEX);
	}
	
}
