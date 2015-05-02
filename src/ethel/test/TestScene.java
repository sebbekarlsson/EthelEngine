package ethel.test;

import java.awt.Color;
import java.util.Random;

import org.lwjgl.opengl.Display;

import ethel.main.Ethel;
import ethel.main.Instance;
import ethel.main.Scene;

public class TestScene extends Scene {
	Random random = new Random();
	
	@Override
	public void tick() {
		for(int i = 0; i < Ethel.getCurrentScene().instances.size(); i++){
			Instance instance = Ethel.getCurrentScene().instances.get(i);
			if(instance instanceof TestObject){
				camera.x = (instance.x - Display.getWidth()/2);
				camera.y = (instance.y - Display.getHeight()/2);
			}
		}
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		backgroundcolor = Color.green;
		
		instantiate(new TestObject(120,120));
		
		for(int i = 0; i < 100; i++)
		instantiate(new TestObject2(random.nextInt(Display.getWidth()),random.nextInt(Display.getHeight())));
		
	}

}
