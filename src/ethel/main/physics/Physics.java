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
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i = 0 ; i < Ethel.getCurrentScene().instances.size(); i++){
				Instance instance = Ethel.getCurrentScene().instances.get(i);
				Texture instance1_texture = instance.sprite.getCurrent();

				for(int ii = 0 ; ii < Ethel.getCurrentScene().instances.size(); ii++){
					Instance instance2 = Ethel.getCurrentScene().instances.get(ii);


					if(
							instance.x >= instance2.x && instance.x <= instance2.x+instance2.getPhysicalSize().getWidth() &&
							instance.y >= instance2.y && instance.y <= instance2.y+instance2.getPhysicalSize().getWidth()
							){
						instance.onCollision(instance2);
						instance2.onCollision(instance);
					}



				}

				if(Mouse.isButtonDown(0)){
					Camera camera = Ethel.getCurrentScene().camera;
					float camx = camera.x;
					float camy = camera.y;

					float mx = Mouse.getX() - (camera.z / Display.getWidth()) ;
					float my = (Display.getHeight() - Mouse.getY()) - (camera.z / Display.getHeight());

					if(mx >= instance.x-camx && mx <= instance.x+instance1_texture.getImageWidth()-camx &&
							my >= instance.y-camy && my <= instance.y+instance1_texture.getImageHeight()-camy){
						instance.onClick(0);
					}
				}


			}
		}

	}

}
