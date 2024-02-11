package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

/**
 * Makes and draws non-electrified barriers
 */
public class Barrier extends CollisionObject {

	protected int x;
	protected int y;
	protected int width;
	protected int height;

	public Barrier(int x, int y, int width, int height) {
		super(x, y, width, height);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(this.x, this.y, this.width, this.height);
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public void collideWith(Hero h) {
		Rectangle2D.Double barrierBox = new Rectangle2D.Double(x, y, width, height);
		if (barrierBox.intersects(h.getBoundingBox())) {
			if (h.getX() + h.getWidth() > this.x + 5) {
				// bottom barrier detection
				if (h.getY() <= this.y + this.height && h.getY() >= this.y) {
					h.setY(this.y + this.height);
				}
				// top barrier detection
				if (h.getY() + h.getWidth() >= this.y && h.getY() + h.getWidth() <= this.y + this.height) {
					h.setY(this.y - h.getWidth());
				}
			} else {
				h.setX(this.x - h.getWidth());
			}
		}
	}

}
