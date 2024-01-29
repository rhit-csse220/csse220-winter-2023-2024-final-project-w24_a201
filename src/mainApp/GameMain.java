package mainApp;

import java.awt.BorderLayout;
import java.util.Timer;

import javax.swing.JFrame;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * <br>Restrictions: None
 */
public class GameMain {
	
	
	private void runApp() {	
		JFrame frame = new JFrame("JETPACK JOYRIDE!!!");
        frame.setSize(1000, 500);
        System.out.println("Hello");
        
        //TODO: add components and timer here

        
        
        
        
        
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