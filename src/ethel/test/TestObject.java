package ethel.test;

import org.lwjgl.input.Keyboard;

import ethel.main.Entity;
import ethel.main.Ethel;
import ethel.main.Instance;
import ethel.main.Sprite;
import ethel.main.utils.Cristofer;

public class TestObject extends Entity {

	public TestObject(float x, float y) {
		super(x, y);
		sprite.textures.add(Ethel.texturebank.TEST);
	}

	@Override
	public void tick() {
		if(Keyboard.isKeyDown(Keyboard.KEY_LEFT)){
			addRotationForce(0.6f, 0);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_RIGHT)){
			addRotationForce(0.6f, 1);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
			addForce(3f, sprite.rotation-90f);
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			TestObject2 obj = new TestObject2(x,y);
			obj.addForce(Cristofer.random.nextFloat()*30, sprite.rotation-90);
			Ethel.getCurrentScene().instantiate(obj);
			
		}
		
		if(Keyboard.isKeyDown(Keyboard.KEY_C)){
			for(int i = 0; i < Ethel.getCurrentScene().instances.size(); i++){
				if(Ethel.getCurrentScene().instances.get(i) instanceof TestObject2)
				Ethel.getCurrentScene().destroy(Ethel.getCurrentScene().instances.get(i));
			}
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
		if(instance instanceof TestObject2){
			((Entity) instance).addForce(0.1f, (sprite.rotation-90));
			((Entity) instance).addRotationForce(Cristofer.random.nextFloat()/3,Cristofer.random.nextInt(1));
		}

	}

	@Override
	public void onClick(int clicktype) {
		// TODO Auto-generated method stub
		
	}


}
