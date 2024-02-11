package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
/**
 * Creates and draws electrified barriers
 */
public class ElectricBarrier extends Barrier {
	
	private GameComponent gameComponent;
	
	public ElectricBarrier(int x, int y, int width, int height, GameComponent gameComponent) {
		super(x, y, width, height);
		this.gameComponent = gameComponent;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED); 
        g.fillRect(getX(), getY()+10, getWidth(), getHeight());
	}
	
	@Override
    public void collideWith(Hero h) {
		Rectangle2D.Double electricBarrierBox = new Rectangle2D.Double(x, y, width, height);
	    if (electricBarrierBox.intersects(h.getBoundingBox())) {
	        h.loseLives();
	        markToRemove(); 
	        System.out.println(this.getClass().getSimpleName() + " collided with Hero, restarting level");
	        gameComponent.switchLevel(gameComponent.getCurrentLevel());
	    }
    }
	
}
