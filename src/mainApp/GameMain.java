package mainApp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @W24_A201 Paul Cleary, Brady Strawmyer, Ethan Spiece
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class GameMain {
	
	private static final int DELAY = 40;
	private static final int FRAME_HEIGHT = 450;
	private static final int FRAME_WIDTH = 1000;
	
	private void runApp() {	
		JFrame frame = new JFrame("JETPACK JOYRIDE!!!");
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        
        GameComponent component = new GameComponent();
        frame.add(component);
        GameListener gameListener = new GameListener(component);
        
        JLabel label = new JLabel("Score: " + component.getHero().getScore() + "\n  Lives: " + component.getHero().getLives());
        frame.add(label, BorderLayout.NORTH);
        
        Hero hero = component.getHero();
		KeystrokeListener keystrokeHandler = new KeystrokeListener(component, hero);
        frame.addKeyListener(keystrokeHandler);
        
        try {
			component.loadLevel("Levels/level1.txt");
		} catch (InvalidLevelFormatException e) {
			e.printStackTrace();
		}
        
        Timer timer = new Timer(DELAY, gameListener);
		timer.start();
        
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		GameMain mainApp = new GameMain();
		mainApp.runApp();		
	} // main

}