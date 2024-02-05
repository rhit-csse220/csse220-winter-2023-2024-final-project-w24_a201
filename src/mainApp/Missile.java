package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class Missile {
	protected int x; 
    protected int y; 
    private int speed;
    private int width;
    private int height;   
    private int radius;
    
    private static final int SCREEN_WIDTH = 1000;

    public Missile(int x, int y, int speed, int width, int height, int radius) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE); 
        g.fillOval(getX(), getY(), 2 * getRadius(), 2 * getRadius());
        g.setColor(Color.BLACK);
        g.fillRect(this.getX()+10, this.getY(), this.getWidth(), this.getHeight());
        
    }

    public void move() {
    	x -= speed;
    	if (this.x + this.width <= 0) {
            this.x = SCREEN_WIDTH;
        }
    }

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getRadius() {
		return radius;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void trackHero(Hero hero) {
		
	}
    
}
