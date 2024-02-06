package mainApp;

import java.awt.geom.Rectangle2D;

public abstract class CollisionObject {

	protected int x;
	protected int y;
	private boolean shouldRemove;
	protected int width;
	protected int height;
	
	public CollisionObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void collideWith(Hero h);
	
	public boolean shouldRemove() {
		return this.shouldRemove;
	} 
	
	public void markToRemove() {
		this.shouldRemove = true;
	}
	
	public Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(this.x, this.y, width, height);
	}
    
	public boolean overlaps(Hero h) {
		return getBoundingBox().intersects(h.getBoundingBox());
	}
	
	public int getX() {
		return this.x;
	} 
	
	public int getY() {
		return this.y;
	} 
	
	public int getWidth() {
		return this.width;
	} 
	
	public int getHeight() {
		return this.height;
	} 

}
