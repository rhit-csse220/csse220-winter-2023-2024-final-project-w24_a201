package mainApp;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class GameMain {
	
	private static final int DELAY = 30;
	
	private void runApp() {	
		JFrame frame = new JFrame("JETPACK JOYRIDE!!!");
        frame.setSize(1000, 500);
        
        GameComponent component = new GameComponent();
        frame.add(component);
        GameListener gameListener = new GameListener(component);
        
        KeystrokeListener keystrokeHandler = new KeystrokeListener(component);
        frame.addKeyListener(keystrokeHandler);
        
        
        
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