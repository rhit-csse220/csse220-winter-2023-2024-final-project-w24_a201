package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
/**
 * Constructs a missile object and draws it and moves it on the screen
 */
public class Missile extends CollisionObject {
	protected int x; 
    protected int y; 
    private int speed;
    private int width;
    private int height;   
    private int radius;
    private GameComponent gameComponent;
    
    private static final int SCREEN_WIDTH = 1000;

    public Missile(int x, int y, int speed, int width, int height, int radius, GameComponent gameComponent) {
    	super(x, y, width, height);
    	this.x = x;
    	this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
        this.radius = radius;
        this.gameComponent = gameComponent;
    }

    public void draw(Graphics g) {
        g.setColor(Color.ORANGE); 
        g.fillOval(getX(), getY(), 2 * radius, 2 * radius);
        g.setColor(Color.BLACK);
        g.fillRect(this.x+10, this.y, this.width, this.height);
        
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

	@Override
    public void collideWith(Hero h) {
        Rectangle2D.Double missileBox = new Rectangle2D.Double(x, y, width, height);
        if (missileBox.intersects(h.getBoundingBox())) {
            gameComponent.switchLevel(gameComponent.getCurrentLevel());
            System.out.println(this.getClass().getSimpleName() + " collided with Hero. Switching level.");
        }
    }
    
}
