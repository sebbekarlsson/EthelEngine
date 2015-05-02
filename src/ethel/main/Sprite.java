package ethel.main;

import java.util.ArrayList;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

public class Sprite {
	public ArrayList<Texture> textures = new ArrayList<Texture>();
	public int textureIndex = 0;
	public float rotation = 0f;
	public static final int CORNER = 0;
	public static final int CENTER = 1;
	
	public Texture getCurrent(){
		return textures.get(textureIndex);
	}
	
	public void draw(){
		GL11.glRotatef(rotation, 0, 0, 1);
		GL11.glPushMatrix();
		getCurrent().bind();
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2d(0, 0);
		GL11.glVertex2f(0, 0);
		
		GL11.glTexCoord2d(getCurrent().getWidth(), 0);
		GL11.glVertex2f(getCurrent().getImageWidth(), 0);
		
		GL11.glTexCoord2d(getCurrent().getWidth(), getCurrent().getHeight());
		GL11.glVertex2f(getCurrent().getImageWidth(), getCurrent().getImageHeight());
		
		GL11.glTexCoord2d(0, getCurrent().getHeight());
		GL11.glVertex2f(0, getCurrent().getImageHeight());
		
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	public void drawCenter(){
		GL11.glRotatef(rotation, 0, 0, 1);
		GL11.glPushMatrix();
		getCurrent().bind();
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glTexCoord2d(0, 0);
		GL11.glVertex2f(-getCurrent().getImageWidth()/2, -getCurrent().getImageHeight()/2);
		
		GL11.glTexCoord2d(getCurrent().getWidth(), 0);
		GL11.glVertex2f(getCurrent().getImageWidth()/2, -getCurrent().getImageHeight()/2);
		
		GL11.glTexCoord2d(getCurrent().getWidth(), getCurrent().getHeight());
		GL11.glVertex2f(getCurrent().getImageWidth()/2, getCurrent().getImageHeight()/2);
		
		GL11.glTexCoord2d(0, getCurrent().getHeight());
		GL11.glVertex2f(-getCurrent().getImageWidth()/2, getCurrent().getImageHeight()/2);
		
		GL11.glEnd();
		GL11.glPopMatrix();
	}
	
	
}
