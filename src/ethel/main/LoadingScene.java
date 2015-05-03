package ethel.main;

import java.awt.Color;

public abstract class LoadingScene extends Scene {
	public int loadTime = 100;
	
	@Override
	public void init() {
		backgroundcolor = Color.BLUE;
		
	}

	@Override
	public void tick() {
		if(loadTime > 0){
			loadTime -= 1;
		}else{
			onComplete();
		}
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	public abstract void onComplete();

}
