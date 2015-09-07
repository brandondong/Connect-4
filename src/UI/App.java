package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Brandon on 2015-08-16.
 */
public class App extends JFrame {

    private Game game;

    public App() {
        super("Connect 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        add(new NewGameStarter());
        game = new OnePlayerGame();
        add(game, BorderLayout.NORTH);

        pack();
        centreOnScreen();
        setVisible(true);
    }

    public void updateSingle() {
        remove(game);
        game = new OnePlayerGame();
        add(game, BorderLayout.NORTH);
        validate();
    }

    public void updateDouble() {
        remove(game);
        game = new TwoPlayerGame();
        add(game, BorderLayout.NORTH);
        validate();
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
            JButton singleGame = new JButton("New Singleplayer Game");
            JButton doubleGame = new JButton("New Multiplayer Game");
            singleGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateSingle();
                }
            });
            doubleGame.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    updateDouble();
                }
            });

            add(singleGame);
            add(doubleGame);
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
