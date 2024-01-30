package mainApp;

import java.awt.Graphics;
import javax.swing.JComponent;
/**
 * This class is responsible for updating and drawing what is on the screen.
 */

public class GameComponent extends JComponent {


	private static final long serialVersionUID = 1L;
	private static final int STARTING_X = 0;
	private static final int STARTING_Y = 430;
	private static final int STARTING_SPEED = 5;
	private Hero hero;
	
	public GameComponent() {
		hero = new Hero(STARTING_X, STARTING_Y, STARTING_SPEED);
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
