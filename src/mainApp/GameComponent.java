package mainApp;

import java.awt.Graphics;
import javax.swing.JComponent;

public class GameComponent extends JComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Hero hero;
	
	public GameComponent() {
		hero = new Hero(0, 430, 5);
	}

	public void drawScreen() {
		this.repaint();
	}

	public void updateGame() {
		hero.move();
		if ( hero.getX() > this.getWidth() - hero.getWidth() ) {
			hero.setX(this.getWidth() - hero.getWidth());
		} 
		if ( hero.getY() < 0) {
			hero.setY(0);
		} 
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		hero.draw(g);
	}

	public void fly() {
		hero.flyUp();
	}
	
}
