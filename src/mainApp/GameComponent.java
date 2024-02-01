package mainApp;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
/**
 * This class is responsible for updating and drawing what is on the screen.
 */

public class GameComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final int STARTING_X = 0;
	private static final int STARTING_Y = 380;
	private static final int STARTING_SPEED = 5;
	
	private Hero hero;
	
	private int currentLevel = 1; 
    private ArrayList<Barrier> barriers = new ArrayList<>();
    private ArrayList<Coin> coins = new ArrayList<>();
    private ArrayList<ElectricBarrier> electricBarriers = new ArrayList<>();  
    private static final int BARRIER_WIDTH = 20;  
    private static final int BARRIER_HEIGHT = 20;
    private static final int COIN_RADIUS = 10;
    private static final int MAX_LEVELS = 2;
    
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
	
	public void loadLevel(String filename) throws InvalidLevelFormatException {
        barriers.clear();
        coins.clear();
        electricBarriers.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            int expectedLineLength = 50;

            while ((line = reader.readLine()) != null) {
            	if (line.length() != expectedLineLength) {
            		barriers.clear();
                    coins.clear();
                    electricBarriers.clear();
                    switchLevel(1);
                    throw new InvalidLevelFormatException("Inconsistent line lengths in the level file");
                }

                for (int col = 0; col < line.length(); col++) {
                    char symbol = line.charAt(col);
                    int x = col * BARRIER_WIDTH;
                    int y = row * BARRIER_HEIGHT;

                    if (symbol == 'B') {
                        barriers.add(new Barrier(x, y, BARRIER_WIDTH, BARRIER_HEIGHT));
                    } 
                    else if (symbol == 'E') {
                        electricBarriers.add(new ElectricBarrier(x, y, BARRIER_WIDTH, BARRIER_HEIGHT));
                    } 
                    else if (symbol == 'C') {
                        coins.add(new Coin(x, y, COIN_RADIUS));
                    } 
                }
                row++;
            }
        } 
        catch (IOException ioe) {
            System.err.println("Error loading level from file: " + ioe.getMessage());
            switchLevel(1);
        }
    }
	
	public void switchLevel(int newLevel) {
		try {
	        if (newLevel >= 1 && newLevel <= MAX_LEVELS) {
	            currentLevel = newLevel;
	            hero.setX(0); 
	            hero.setY(380);
	            loadLevel("Levels/level" + currentLevel + ".txt");
	        }
	    } catch (InvalidLevelFormatException e) {
	        System.err.println("Invalid level format: " + e.getMessage());
	    }
    }
	
	@Override
    protected void paintComponent(Graphics g) {
    	super.paintComponent(g);
        for (Barrier barrier : barriers) {
            barrier.draw(g);
        }
        for (ElectricBarrier electricBarrier : electricBarriers) {
        	electricBarrier.draw(g);
        }
        for (Coin coin : coins) {
            coin.draw(g);
        }
        hero.draw(g);
    }

	public void fly() {
		hero.flyUp();
	}

	public int getCurrentLevel() {
		return currentLevel;
	}
	
}
