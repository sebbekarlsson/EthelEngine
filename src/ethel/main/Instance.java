package ethel.main;

import java.awt.Dimension;

import org.lwjgl.opengl.GL11;

public abstract class Instance {
	public float x,y = 0f;
	public float z = -99f;
	public Sprite sprite = new Sprite();
	protected Dimension physicalSize = new Dimension(16,16);

	public Instance(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void update(){
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		tick();
		draw();
		GL11.glPopMatrix();
	}

	public abstract void tick();
	public abstract void draw();
	public abstract void onDestruction();
	public abstract void onInstantiation();
	public abstract void onCollision(Instance instance);
	public abstract void onClick(int clicktype);


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
	
	public void setPhysicalSize(Dimension size){
		this.physicalSize = size;
	}
	
	public Dimension getPhysicalSize(){
		return this.physicalSize;
	}
}
