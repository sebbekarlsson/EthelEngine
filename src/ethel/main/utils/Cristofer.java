package ethel.main.utils;

import java.awt.Point;
import java.util.Random;

public class Cristofer {
	public static Random random = new Random();
	
	public static float getAngle(Point target1, Point target2) {
	    float angle = (float) Math.toDegrees(Math.atan2(target1.y - target2.y, target1.x - target2.x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return angle;
	}
}
