package ethel.main;

import org.lwjgl.input.Mouse;

public class Camera extends Entity{
	private boolean zoomable = false;

	public Camera(float x, float y) {
		super(x, y);
		z = 1;
	}

	public void update(){
		if(zoomable){
			z += 0.1 * Mouse.getDWheel()/60;
		}
		tick();
		draw();
	}

	public void tick(){

	}

	public void draw(){

	}

	@Override
	public void onDestruction() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInstantiation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCollision(Instance instance) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(int clicktype) {
		// TODO Auto-generated method stub

	}
	
	public void setZoomable(boolean zoomable){
		this.zoomable = zoomable;
	}
}
