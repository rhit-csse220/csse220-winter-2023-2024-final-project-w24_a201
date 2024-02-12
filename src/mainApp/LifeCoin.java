package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class LifeCoin extends Coin {

	public LifeCoin(int x, int y, int radius) {
		super(x, y, radius/2);
	}
	
	//draws the coin object
    public void draw(Graphics g) {
        g.setColor(Color.CYAN); 
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }

    @Override
    public void collideWith(Hero h) {
        Rectangle2D.Double coinBox = new Rectangle2D.Double(x, y, width, height);
        if (coinBox.intersects(h.getBoundingBox())) {
        	if (!this.shouldRemove()) {
        		h.addLives();
        		System.out.println("added life");
        	}
            markToRemove();
        }
    }  
    
}
