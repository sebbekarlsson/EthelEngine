package ethel.test;

import org.lwjgl.input.Keyboard;

import ethel.main.Entity;
import ethel.main.Ethel;
import ethel.main.Instance;
import ethel.main.Sprite;

public class TestObject extends Entity {

	public TestObject(float x, float y) {
		super(x, y);
		sprite.textures.add(Ethel.texturebank.TEST);
	}

	@Override
	public void tick() {
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			sprite.rotation -= 4f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			sprite.rotation += 4f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			addForce(3f, sprite.rotation-90f);
		}
	}

	@Override
	public void draw() {
		drawDefault(Sprite.CENTER);
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
		if(instance instanceof TestObject2)
		Ethel.getCurrentScene().destroy(instance);
		
	}


}
