package mainApp;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Creates and draws electrified barriers
 */
public class ElectricBarrier extends Barrier {


	public ElectricBarrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED); 
        g.fillRect(getX(), getY()+10, getWidth(), getHeight());
	}
}
