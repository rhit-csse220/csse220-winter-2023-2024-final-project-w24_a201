package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class TrackingMissile extends Missile {

	
	public TrackingMissile(int x, int y, int speed, int width, int height, int radius) {
		super(x, y, speed, width, height, radius);
	}
	
	public void trackHero(Hero hero) {
	    int heroY = hero.getY();
	    if (this.y < heroY) {
	        this.y += 2;  
	    } else if (this.y > heroY) {
	        this.y -= 2;  
	    }
	}
	
	public void draw(Graphics g) {
        g.setColor(Color.GREEN); 
        g.fillOval(getX(), getY(), 2 * getRadius(), 2 * getRadius());
        g.setColor(Color.BLACK);
        g.fillRect(this.getX()+10, this.getY(), this.getWidth(), this.getHeight());      
    }

}
