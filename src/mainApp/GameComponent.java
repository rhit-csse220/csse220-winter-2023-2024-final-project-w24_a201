package mainApp;

import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * This class is responsible for updating and drawing what is on the screen.
 */

public class GameComponent extends JComponent {

	private static final long serialVersionUID = 1L;
	private static final int STARTING_X = 0;
	private static final int STARTING_Y = 380;
	private static final int STARTING_SPEED = 5;
	private static final int MAX_LEVEL = 3;

	private Hero hero;
	private JLabel label;

	private int currentLevel = 1;
	private ArrayList<Barrier> barriers = new ArrayList<>();
	private ArrayList<Coin> coins = new ArrayList<>();
	private ArrayList<Missile> missiles = new ArrayList<>();

	private ArrayList<CollisionObject> objects = new ArrayList<>();

	private static final int BARRIER_WIDTH = 20;
	private static final int BARRIER_HEIGHT = 20;
	private static final int COIN_RADIUS = 10;
	private static final int MISSILE_WIDTH = 10;
	private static final int MISSILE_HEIGHT = 20;
	private static final int MISSILE_SPEED = 5;
	private static final int MISSILE_RADIUS = 10;

	public GameComponent(JLabel label) {
		hero = new Hero(STARTING_X, STARTING_Y, STARTING_SPEED);
		this.label = label;
	}

	public Hero getHero() {
		return hero;
	}

	public void drawScreen() {
		this.repaint();
	}

	public void addObjects() {
		objects.addAll(coins);
		objects.addAll(missiles);
		objects.addAll(barriers);
	}

	public void updateGame() {
		updateLabel(this.label);

		if (hero.getX() + hero.getWidth() >= this.getWidth()) {
			switchLevel(currentLevel + 1);
		}

		// adds objects to collision object list
		addObjects();

		// for hero movement
		hero.move();
		hero.gravity();
		hero.flyUp();

		// handles collisions
		handleCollisions();

		// keep the hero on the screen
		if (hero.getX() > this.getWidth() - hero.getWidth()) {
			hero.setX(this.getWidth() - hero.getWidth());
		}
		if (hero.getY() < 0) {
			hero.setY(0);
		}
		if (hero.getY() > this.getHeight() - hero.getWidth()) {
			hero.setY(this.getHeight() - hero.getWidth());
		}

		// for missile movement
		for (Missile missile : missiles) {
			missile.move();
			missile.trackHero(hero);
		}

	}

	public void handleCollisions() {

		ArrayList<CollisionObject> objectsCopy = new ArrayList<>(objects);

		for (CollisionObject o : objectsCopy) {
			o.collideWith(this.hero);
		}

		ArrayList<CollisionObject> shouldRemove = new ArrayList<>();

		// mark objects that need to be removed
		for (CollisionObject object : objects) {
			if (object.shouldRemove()) {
				shouldRemove.add(object);
			}
		}

		// remove marked objects
		for (CollisionObject object : shouldRemove) {
			removeObject(object);
		}

	}

	public void removeObject(CollisionObject object) {
		if (coins.contains(object)) {
			coins.remove(object);
		} else if (missiles.contains(object)) {
			missiles.remove(object);
		}
	}

	public void loadLevel(String filename) throws InvalidLevelFormatException {
		clearAll();

		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			int row = 0;
			int expectedLineLength = 50;

			while ((line = reader.readLine()) != null) {
				if (line.length() != expectedLineLength) {
					clearAll();
					switchLevel(1);
					throw new InvalidLevelFormatException("Inconsistent line lengths in the level file");
				}

				for (int col = 0; col < line.length(); col++) {
					char symbol = line.charAt(col);
					int x = col * BARRIER_WIDTH;
					int y = row * BARRIER_HEIGHT;

					if (symbol == 'B') {
						barriers.add(new Barrier(x, y, BARRIER_WIDTH, BARRIER_HEIGHT));
					} else if (symbol == 'E') {
						barriers.add(new ElectricBarrier(x, y, BARRIER_WIDTH, BARRIER_HEIGHT, this));
					} else if (symbol == 'C') {
						coins.add(new Coin(x, y, COIN_RADIUS));
					} else if (symbol == 'L') {
						coins.add(new LifeCoin(x, y, COIN_RADIUS));
					} else if (symbol == 'S') {
						coins.add(new SpecialCoin(x, y, COIN_RADIUS));
					} else if (symbol == 'M') {
						missiles.add(
								new Missile(x, y, MISSILE_SPEED, MISSILE_WIDTH, MISSILE_HEIGHT, MISSILE_RADIUS, this));
					} else if (symbol == 'T') {
						missiles.add(new TrackingMissile(x, y, MISSILE_SPEED, MISSILE_WIDTH, MISSILE_HEIGHT,
								MISSILE_RADIUS, this));
					}
				}
				row++;
			}
		} catch (IOException ioe) {
			System.err.println("Error loading level from file: " + ioe.getMessage());
			if (currentLevel > 1) {
				switchLevel(currentLevel - 1);
			} else {
				switchLevel(1);
			}
		}
	}

	public void switchLevel(int newLevel) {
		try {
			if (hero.getLives() <= 0) {
				System.out.println("YOU LOST!");
				System.out.print("FINAL SCORE: " + hero.getScore());
				restart();

			} else if (newLevel > MAX_LEVEL && hero.getX() + hero.getWidth() >= this.getWidth()) {
				System.out.println("YOU WIN!");
				System.out.print("FINAL SCORE: " + hero.getScore());
				restart();

			} else {
				currentLevel = newLevel;
				hero.setX(STARTING_X);
				hero.setY(STARTING_Y);
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
		for (Coin coin : coins) {
			coin.draw(g);
		}
		for (Missile missile : missiles) {
			missile.draw(g);
		}
		hero.draw(g);
	}

	public void restart() {
		int answer = JOptionPane.showConfirmDialog(this, "Play Again?");
		if (answer == 1 || answer == 2) {
			System.exit(0);
		} else {
			clearAll();
			hero.setScore(0);
			hero.setLives(3);
			switchLevel(1);
		}
	}

	private void clearAll() {
		barriers.clear();
		coins.clear();
		missiles.clear();
		objects.clear();

	}

	public void fly() {
		hero.flyUp();
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void gravity() {
		hero.gravity();
	}

	public void updateLabel(JLabel label) {
		label.setText("Score: " + this.getHero().getScore() + "\n  Lives: " + this.getHero().getLives());
	}

}
