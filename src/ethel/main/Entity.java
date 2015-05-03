package ethel.main;

import org.lwjgl.opengl.GL11;

public abstract class Entity extends Instance {
	public float dx, dy, dr = 0;
	public float friction = 0.3f;
	public float rotationfriction = 0.3f;

	public Entity(float x, float y) {
		super(x, y);
	}
	
	public void update(){
		GL11.glPushMatrix();
		GL11.glTranslatef(x, y, z);
		updatePhysics();
		tick();
		draw();
		GL11.glPopMatrix();
	}
	
	public void addForce(float force, float direction){
		dx += Math.cos(Math.toRadians(direction)) * force;
		dy += Math.sin(Math.toRadians(direction)) * force;
	}
	
	public void addRotationForce(float force, int x){
		if(x == 0){
			dr -= force;
		}else if(x == 1){
			dr += force;
		}else{
			System.err.println("The rotation of an object is incorrect");
			System.exit(1);
		}
	}
	
	private void updatePhysics(){
		
		x += dx;
		y += dy;
		sprite.rotation += dr;
		
		if(dx > 0){
			if(dx - friction < 0){
				dx = 0;
			}else{
				dx -= friction;
			}
		}
		
		if(dx < 0){
			if(dx + friction > 0){
				dx = 0;
			}else{
				dx += friction;
			}
		}
		
		if(dy > 0){
			if(dy - friction < 0){
				dy = 0;
			}else{
				dy -= friction;
			}
		}
		
		if(dy < 0){
			if(dy + friction > 0){
				dy = 0;
			}else{
				dy += friction;
			}
		}
		
		if(dr < 0){
			if(dr + rotationfriction > 0){
				dr = 0;
			}else{
				dr += friction;
			}
		}
		
		if(dr > 0){
			if(dr - rotationfriction < 0){
				dr = 0;
			}else{
				dr -= friction;
			}
		}
	}
	
	public float getForce(){
		float force = dx + dy;
		if(force < 0){
			force = force * -1;
		}
		
		return force/2;
	}
}
