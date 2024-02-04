package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class Missile {
	private int x; 
    private int y; 
    private int speed;
    private int width;
    private int height; 
    
    private int radius = 10;

    public Missile(int x, int y, int speed, int width, int height) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE); 
        g.fillOval(x, y, 2 * radius, 2 * radius);
        g.setColor(Color.BLACK);
        g.fillRect(this.x+10, this.y, this.width, this.height);
        
    }

    public void move() {
        x -= speed;
    }
    
}
