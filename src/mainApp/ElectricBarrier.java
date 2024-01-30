package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class ElectricBarrier extends Barrier {


	public ElectricBarrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.ORANGE); 
        g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
