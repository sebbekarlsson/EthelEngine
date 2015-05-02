package ethel.main;

import java.util.ArrayList;

import org.newdawn.slick.opengl.Texture;

public class Sprite {
	public ArrayList<Texture> textures = new ArrayList<Texture>();
	public int textureIndex = 0;
	
	public Texture getCurrent(){
		return textures.get(textureIndex);
	}
}
