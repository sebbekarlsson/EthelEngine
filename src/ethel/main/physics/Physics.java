package ethel.main.physics;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.opengl.Texture;

import ethel.main.Camera;
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
			try {
				//java is bynligt
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0 ; i < Ethel.getCurrentScene().instances.size(); i++){
				Instance instance = Ethel.getCurrentScene().instances.get(i);
				Texture instance1_texture = instance.sprite.getCurrent();

				for(int ii = 0 ; ii < Ethel.getCurrentScene().instances.size(); ii++){
					Instance instance2 = Ethel.getCurrentScene().instances.get(ii);
					Texture instance2_texture = instance2.sprite.getCurrent();

					if(true){
						if(
								instance.x >= instance2.x && instance.x <= instance2.x+instance2_texture.getImageWidth() &&
								instance.y >= instance2.y && instance.y <= instance2.y+instance2_texture.getImageHeight()
								){
							instance.onCollision(instance2);
							instance2.onCollision(instance);
						}

					}

				}

				if(Mouse.isButtonDown(0)){
					Camera camera = Ethel.getCurrentScene().camera;
					float camx = camera.x;
					float camy = camera.y;
					if(Mouse.getX() >= instance.x-camx && Mouse.getX() <= instance.x+instance1_texture.getImageWidth()-camx &&
							(Display.getHeight() - Mouse.getY()) >= instance.y-camy && (Display.getHeight() - Mouse.getY()) <= instance.y+instance1_texture.getImageHeight()-camy){
						instance.onClick(0);
					}
				}


			}
		}

	}

}
