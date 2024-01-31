package mainApp;

import java.awt.Color;
import java.awt.Graphics;

/*
 * Coin class controls creating and drawing the coin objects
 */
public class Coin {

	private int x; 
    private int y; 
    private int radius; 

    public Coin(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //draws the coin object
    public void draw(Graphics g) {
        g.setColor(Color.YELLOW); 
        g.fillOval(x, y, 2 * radius, 2 * radius);
    }

}
