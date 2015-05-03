package ethel.main.graphics;

import org.lwjgl.opengl.GL11;

import ethel.main.Sprite;

public abstract class GuiInstance {
	public float x,y = 0f;
	public float z = 1f;
	public Sprite sprite = new Sprite();
	
	public void update(){
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		tick();
		draw();
		GL11.glPopMatrix();
	}

	protected void drawDefault(int ortho){
		
		

		if(ortho == Sprite.CENTER){
			sprite.drawCenter();
		}else if(ortho == Sprite.CORNER){
			sprite.draw();
		}else{
			System.err.println("The sprite ortho is unavailable, game will terminate.");
			System.exit(1);
		}

	
	}
	

	public abstract void tick();
	public abstract void draw();
	public abstract void onInstantiation();
	public abstract void onDestruction();
}
