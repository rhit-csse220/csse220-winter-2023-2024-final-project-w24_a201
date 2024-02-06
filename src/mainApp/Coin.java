package mainApp;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Coin class controls creating and drawing the coin objects
 */
public class Coin extends CollisionObject {

    private int radius; 

    public Coin(int x, int y, int radius) {
    	super(x, y, radius*2, radius*2);
        this.radius = radius;
    }

    //draws the coin object
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW); 
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }

	@Override
	public void collideWith(Hero h) {
		if (this.overlaps(h)) {
			System.out.println(this + " collided with Hero");
		}
	}

    

}