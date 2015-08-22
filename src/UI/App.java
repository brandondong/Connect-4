package UI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 2015-08-16.
 */
public class App extends JFrame {

    private static final int SPACING = 64;

    private Game game;

    public App() {
        super("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        game = new OnePlayerGame();
        add(game);

        pack();
        centreOnScreen();
        setVisible(true);
    }

    // Modifies: this
    // Effects: location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    private class NewGameStarter extends JPanel {

        public NewGameStarter() {
            setBackground(Color.LIGHT_GRAY);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
