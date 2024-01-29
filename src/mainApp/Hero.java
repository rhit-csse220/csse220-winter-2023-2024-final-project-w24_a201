package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class Hero {

	private static final int HERO_X = 25;
	private static final int HERO_Y = 25;
	
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
        g.fillRect(x, y, HERO_X, HERO_Y);
    }

	public int getWidth() {
		return HERO_X;
	}

}
