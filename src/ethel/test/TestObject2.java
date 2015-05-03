package ethel.test;

import ethel.main.Entity;
import ethel.main.Ethel;
import ethel.main.Instance;
import ethel.main.Sprite;
import ethel.main.utils.Cristofer;

public class TestObject2 extends Entity {

	public TestObject2(float x, float y) {
		super(x, y);
		sprite.textures.add(Ethel.texturebank.TEST2);
	}

	@Override
	public void tick() {
		
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
		if(instance instanceof TestObject){
			addForce(((Entity) instance).getForce(), instance.sprite.rotation-90);
			addRotationForce(5f, Cristofer.random.nextInt(1));
		}
	}

	@Override
	public void onClick(int clicktype) {
		addForce(5f, Cristofer.random.nextInt(360));
		addRotationForce(5f, Cristofer.random.nextInt(1));
		
	}

}
