package mainApp;

import java.awt.Color;
import java.awt.Graphics;
/**
 * Creates the hero object that is controlled by the user
 */
public class Hero {

	private static final int HERO_WIDTH = 25;
	private static final int HERO_HEIGHT = 25;
	private static final int FLYING_SPEED = 5;
	
	private int x;
    private int y;
    private int speed;
    
    public Hero(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
    	return y;
    }
    
    public void setY(int y) {
    	this.y = y;
    }

    public void move() {
        x += speed;
    }


    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, HERO_WIDTH, HERO_HEIGHT);
    }

	public int getWidth() {
		return HERO_WIDTH;
	}

	public void flyUp() {
		y -= FLYING_SPEED;
	}
	
//	public void gravity() {
//		y += FLYING_SPEED;
//	}

}
