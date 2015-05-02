package ethel.main;

public abstract class Entity extends Instance {
	public float dx, dy = 0;
	public float friction = 0.3f;

	public Entity(float x, float y) {
		super(x, y);
	}
	
	public void update(){
		updatePhysics();
		tick();
		draw();
	}
	
	public void addForce(float force, float direction){
		dx += Math.cos(Math.toRadians(direction)) * force;
		dy += Math.sin(Math.toRadians(direction)) * force;
	}
	
	private void updatePhysics(){
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
	}
}
