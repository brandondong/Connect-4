package UI;

import Model.Board;
import Model.Disc;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 2015-08-12.
 */
public abstract class Game extends JFrame {

    public static final int SPACING = 64;
    public static final int CIRCLE_RADIUS = 50;

    protected Board board;
    protected boolean isGameOver;

    public Game() {
        super("Connect 4");
        board = new Board();
        isGameOver = false;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new Dimension(7 * SPACING, 6 * SPACING));
        setBackground(Color.BLUE);
        pack();
        centreOnScreen();
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        for (int x = 0; x < 7; x++) {
            for (int y = 0; y < 6; y++) {
                Disc next = board.getDiscAt(x, y);
                int xPos = x * SPACING + (SPACING - CIRCLE_RADIUS) / 2;
                int yPos = (5 - y) * SPACING + (SPACING - CIRCLE_RADIUS) / 2;

                if (next == null) {
                    g.setColor(Color.LIGHT_GRAY);
                } else if (next.equals(Disc.RED)) {
                    g.setColor(Color.RED);
                } else {
                    g.setColor(Color.YELLOW);
                }

                g.fillOval(xPos, yPos, CIRCLE_RADIUS, CIRCLE_RADIUS);
            }
        }
    }

    public Board getBoard() {
        return board;
    }

    public boolean getIsOver() {
        return isGameOver;
    }

    // Modifies: this
    // Effects: location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

}
