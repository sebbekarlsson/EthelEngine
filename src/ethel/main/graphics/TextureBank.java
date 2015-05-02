package ethel.main.graphics;

import java.io.FileInputStream;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class TextureBank {
	public static Texture loadTexture(String extension, String path){
		Texture texture = null;
		try {
			texture = TextureLoader.getTexture(extension, new FileInputStream(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return texture;
	}
}
