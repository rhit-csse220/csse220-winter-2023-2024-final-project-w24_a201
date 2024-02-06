package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
/**
 * Creates the hero object that is controlled by the user
 */
public class Hero {

	private static final int HERO_WIDTH = 25;
	private static final int HERO_HEIGHT = 25;
	private static final int FLYING_SPEED = 5;
	private static final int GRAVITY = 5;
	
	private int x;
    private int y;
    private int speed;
    protected boolean isFlying;
    
    public Hero(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.isFlying = false;
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
		
		if (isFlying) {
			y -= FLYING_SPEED;
		}
		else {
		}
	}
	
	public void gravity() {
		if (!isFlying) {
            y += GRAVITY;  
        }
	}

	public Rectangle2D getBoundingBox() {
		return new Rectangle2D.Double(this.x, this.y, getWidth(), getWidth());
	}

}
