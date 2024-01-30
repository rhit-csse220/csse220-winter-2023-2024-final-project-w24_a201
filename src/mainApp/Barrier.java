package mainApp;

import java.awt.Color;
import java.awt.Graphics;

public class Barrier {

	private int x; 
    private int y; 
    private int width;
    private int height; 

    public Barrier(int x, int y, int width, int height, boolean isElectrified) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    //draws the barrier object
    public void draw(Graphics g) {
        g.setColor(Color.GRAY); 
        g.fillRect(x, y, width, height);
    }

}
