package ethel.main.graphics;

import org.lwjgl.opengl.GL11;

import ethel.main.Sprite;

public abstract class GuiInstance {
	public float x,y,z = 0f;
	public Sprite sprite = new Sprite();
	
	public void update(){
		tick();
		draw();
	}

	protected void drawDefault(int ortho){
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);

		if(ortho == Sprite.CENTER){
			sprite.drawCenter();
		}else if(ortho == Sprite.CORNER){
			sprite.draw();
		}else{
			System.err.println("The sprite ortho is unavailable, game will terminate.");
			System.exit(1);
		}

		GL11.glPopMatrix();
	}
	

	public abstract void tick();
	public abstract void draw();
}
