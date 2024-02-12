package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * Used to listen for certain key presses and to do specific things when that key is pressed
 */
public class KeystrokeListener implements KeyListener {

	private GameComponent component;
	private Hero hero;
	private static final int SPACE_KEY_ID = 32;
	private static final int UP_ARROW_ID = 38;
	private static final int DOWN_ARROW_ID = 40;
	private static final int LEFT_ARROW_ID = 37;
	public KeystrokeListener(GameComponent component, Hero hero) {
		this.component = component;
		this.hero = hero;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == SPACE_KEY_ID) {
			hero.isFlying = true;
		}
		if (e.getKeyCode() == UP_ARROW_ID) {
            component.switchLevel(component.getCurrentLevel()+1);
        }
		if (e.getKeyCode() == DOWN_ARROW_ID) {
        	component.switchLevel(component.getCurrentLevel()-1);
        }
		if (e.getKeyCode() == LEFT_ARROW_ID) {
			hero.setSpeed(0);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == SPACE_KEY_ID) {
			hero.isFlying = false;
		}
		if (e.getKeyCode() == LEFT_ARROW_ID) {
			hero.setSpeed(5);
		}
	}

}
