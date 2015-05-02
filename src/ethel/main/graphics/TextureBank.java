package ethel.main.graphics;

import java.io.FileInputStream;
import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureBank {
	
	public Texture TEST = loadTexture("png", "graphics/ship.png");
	public Texture TEST2 = loadTexture("png", "graphics/stone.png");

	public  Texture loadTexture(String extension, String path) {
		Texture texture = null;
		try {
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
			GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
			texture = TextureLoader.getTexture(extension, new FileInputStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return texture;
	}
}
