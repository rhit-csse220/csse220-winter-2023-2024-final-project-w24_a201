package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * used to listen for certain key presses to do specific things when a key is pressed
 */
public class KeystrokeListener implements KeyListener {

	private GameComponent component;
	
	public KeystrokeListener(GameComponent component) {
		this.component = component;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int spaceKey = 32;
		if (e.getKeyCode() == spaceKey) {
			component.fly();
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP) {
            component.switchLevel(component.getCurrentLevel()+1);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	component.switchLevel(component.getCurrentLevel()+1);
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
