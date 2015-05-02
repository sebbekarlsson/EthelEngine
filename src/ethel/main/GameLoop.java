package ethel.main;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class GameLoop implements Runnable {
	Thread loop = new Thread(this);

	public GameLoop(){
		loop.start();
	}

	@Override
	public void run() {
		try {
			Display.setDisplayMode(new DisplayMode(Ethel.DISPLAY_SIZE.width, Ethel.DISPLAY_SIZE.height));
			Display.setTitle(Ethel.TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		
		initGraphics();
		
		while(!Display.isCloseRequested()){
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
			
			
			GL11.glColor3f(1, 0, 0);
			GL11.glDisable(GL11.GL_TEXTURE_2D);

			
			GL11.glPushMatrix();
			GL11.glTranslatef(0f, 0f, 0f);
			
			//draw here
			
			GL11.glPopMatrix();

			Display.sync(Ethel.SYNC_FPS);
			Display.update();

		}
		
		System.out.println("Game was terminated");
		System.exit(0);

	}
	
	private void initGraphics(){
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, Ethel.DISPLAY_SIZE.width, Ethel.DISPLAY_SIZE.height, 0, -1, 100);
		//GLU.gluPerspective(45.0f, ((float)Ethel.DISPLAY_SIZE.width) / ((float)Ethel.DISPLAY_SIZE.height), -0.01f, 100f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		
		
	}

}
