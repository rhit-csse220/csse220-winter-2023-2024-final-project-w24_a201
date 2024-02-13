package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

/*
 * Responsible for creating a coin that gives extra points
 */

public class SpecialCoin extends Coin {

	public static final int POINTS = 3;
	public SpecialCoin(int x, int y, int radius) {
		super(x, y, radius/2);
	}
	
	//draws the special coin object
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE); 
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }
    
    public void collideWith(Hero h) {
        Rectangle2D.Double coinBox = new Rectangle2D.Double(x, y, width, height);
        if (coinBox.intersects(h.getBoundingBox())) {
        	if (!this.shouldRemove()) {
        		for (int i=0;i<POINTS;i++) {
        			h.addScore();
        		}
        	}
            markToRemove();
        }
    }  

}
