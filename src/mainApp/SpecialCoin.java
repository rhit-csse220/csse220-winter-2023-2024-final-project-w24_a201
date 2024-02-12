package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

public class SpecialCoin extends Coin {

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
        		h.addScore();
        		h.addScore();
        		h.addScore();
        		System.out.println("added life");
        	}
            markToRemove();
        }
    }  

}
