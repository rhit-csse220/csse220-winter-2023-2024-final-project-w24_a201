package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class Hero {

	private int x;
    private int y;
    private int speed;
    private boolean isFlying;


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
        g.fillRect(x, y, 50, 50);
    }

}
