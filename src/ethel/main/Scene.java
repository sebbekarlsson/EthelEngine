package ethel.main;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Scene {
	public Camera camera = new Camera(0f, 0f, 0f);
	public ArrayList<Instance> instances = new ArrayList<Instance>();
	public Color backgroundcolor = new Color(0,0,0);
	
	public void update(){
		updateInstances();
		tick();
		draw();
	}
	
	public abstract void tick();
	public abstract void draw();
	
	public void instantiate(Instance instance){
		instance.onInstantiation();
		instances.add(instance);
	}
	
	public void destroy(Instance instance){
		instance.onDestruction();
		instances.remove(instance);
	}
	
	private void updateInstances(){
		for(int i = 0; i < instances.size(); i++){
			Instance instance = instances.get(i);
			instance.update();
		}
	}
}
