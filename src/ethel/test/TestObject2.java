package ethel.test;

import ethel.main.Entity;
import ethel.main.Ethel;
import ethel.main.Instance;
import ethel.main.Sprite;

public class TestObject2 extends Entity {

	public TestObject2(float x, float y) {
		super(x, y);
		sprite.textures.add(Ethel.texturebank.TEST2);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw() {
		drawDefault(Sprite.CORNER);
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

}
