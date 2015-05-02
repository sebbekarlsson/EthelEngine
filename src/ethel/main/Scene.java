package ethel.main;

import java.util.ArrayList;

public abstract class Scene {
	public Camera camera = new Camera(0f, 0f, 0f);
	public ArrayList<Instance> instances = new ArrayList<Instance>();
	
	public void update(){
		updateInstances();
		tick();
		draw();
	}
	
	public abstract void tick();
	public abstract void draw();
	
	private void updateInstances(){
		for(int i = 0; i < instances.size(); i++){
			Instance instance = instances.get(i);
			instance.update();
		}
	}
}
