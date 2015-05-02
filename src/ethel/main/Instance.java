package ethel.main;

import org.lwjgl.opengl.GL11;

public abstract class Instance {
	public float x,y,z = 0f;
	public Sprite sprite = new Sprite();

	public Instance(float x, float y){
		this.x = x;
		this.y = y;
	}

	public void update(){
		tick();
		draw();
	}

	public abstract void tick();
	public abstract void draw();
	public abstract void onDestruction();
	public abstract void onInstantiation();
	public abstract void onCollision(Instance instance);


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
}
