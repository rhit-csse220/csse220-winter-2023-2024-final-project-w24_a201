package mainApp;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Listener object responsible for "ticking"
 */
public class GameListener implements ActionListener {

	private GameComponent gameComponent;

    public GameListener(GameComponent gameComponent) {
        this.gameComponent = gameComponent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        advanceOneTick();
    }

    public void advanceOneTick() {
        gameComponent.updateGame();
        gameComponent.drawScreen();
    }
}
