package ethel.main.physics;

import org.newdawn.slick.opengl.Texture;

import ethel.main.Ethel;
import ethel.main.Instance;

public class Physics implements Runnable {
	Thread thread = new Thread(this);

	public void start(){
		thread.start();
	}

	@Override
	public void run() {
		while(true){
			for(int i = 0 ; i < Ethel.getCurrentScene().instances.size(); i++){
				Instance instance = Ethel.getCurrentScene().instances.get(i);
				//Texture instance_texture = instance.sprite.getCurrent();

				for(int ii = 0 ; ii < Ethel.getCurrentScene().instances.size(); ii++){
					Instance instance2 = Ethel.getCurrentScene().instances.get(ii);
					Texture instance2_texture = instance.sprite.getCurrent();

					if(instance2 != instance){
						if(
								instance.x >= instance2.x && instance.x <= instance2.x+instance2_texture.getImageWidth() &&
								instance.y >= instance2.y && instance.y <= instance2.y+instance2_texture.getImageHeight()
								){
							System.out.println("col");
							instance.onCollision(instance2);
							instance2.onCollision(instance);
						}

					}

				}
			}
		}

	}

}
