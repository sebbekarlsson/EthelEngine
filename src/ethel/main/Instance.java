package ethel.main;

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
}
