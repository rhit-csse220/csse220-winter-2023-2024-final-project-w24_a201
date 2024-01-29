package mainApp;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
			System.out.println("Space Key Pressed");
			component.fly();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
