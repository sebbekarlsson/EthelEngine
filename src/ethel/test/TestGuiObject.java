package ethel.test;

import java.awt.Font;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

import ethel.main.graphics.GuiInstance;

public class TestGuiObject extends GuiInstance {
	TrueTypeFont font = new TrueTypeFont(new Font(Font.SERIF,12,12), false);
	
	public TestGuiObject(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void tick() {
		y = Display.getHeight() - Mouse.getY();
		x = Mouse.getX();
		
	}

	@Override
	public void draw() {
		
		
		font.drawString(8, 8, "This is a test", Color.yellow);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		GL11.glColor3f(0, 0, 0);
		GL11.glBegin(GL11.GL_QUADS);
		
		GL11.glVertex2f(0, 0);
		GL11.glVertex2f(256, 0);
		GL11.glVertex2f(256, 96);
		GL11.glVertex2f(0, 96);
		
		GL11.glEnd();

		
	}

	@Override
	public void onInstantiation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestruction() {
		// TODO Auto-generated method stub
		
	}

}
