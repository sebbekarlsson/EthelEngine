package ethel.main;

import java.awt.Color;
import java.util.ArrayList;

import org.lwjgl.opengl.GL11;

import ethel.main.graphics.GuiInstance;

public abstract class Scene {
	public Camera camera = new Camera(0f, 0f, 0f);
	public ArrayList<Instance> instances = new ArrayList<Instance>();
	public ArrayList<GuiInstance> guiinstances = new ArrayList<GuiInstance>();
	public Color backgroundcolor = new Color(0,0,0);
	public boolean init = false;
	
	public void update(){
		GL11.glTranslatef(-camera.x, -camera.y, -camera.z);
		GL11.glPushMatrix();
		updateInstances();
		tick();
		draw();
		GL11.glPopMatrix();
		GL11.glLoadIdentity();
		updateGuiInstances();

	}
	
	public abstract void init();
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
	
	public void instantiate(GuiInstance instance){
		instance.onInstantiation();
		guiinstances.add(instance);
	}
	
	public void destroy(GuiInstance instance){
		instance.onDestruction();
		guiinstances.remove(instance);
	}
	
	private void updateInstances(){
		for(int i = 0; i < instances.size(); i++){
			Instance instance = instances.get(i);
			instance.update();
		}
	}
	private void updateGuiInstances(){
		for(int i = 0; i < guiinstances.size(); i++){
			GuiInstance instance = guiinstances.get(i);
			instance.update();
		}
	}
}
