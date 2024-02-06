package mainApp;

import java.awt.geom.Rectangle2D;

public abstract class CollisionObject {

	protected int x;
	protected int y;
	private boolean shouldRemove;
	private int width;
	private int height;
	
	public CollisionObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void collideWith(Hero h);
	
	public Rectangle2D.Double getBoundingBox() {
		return new Rectangle2D.Double(this.x, this.y, getWidth(), getHeight());
	}
    
	public boolean overlaps(Hero h) {
		return getBoundingBox().intersects(h.getBoundingBox());
	}
	
	public double getX() {
		return this.x;
	} 
	
	public double getY() {
		return this.y;
	} 
	
	public double getWidth() {
		return this.width;
	} 
	
	public double getHeight() {
		return this.height;
	} 

}
