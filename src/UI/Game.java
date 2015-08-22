package UI;

import Model.Board;
import Model.Disc;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 2015-08-12.
 */
public abstract class Game extends JPanel {

    protected static final int SPACING = 64;
    protected static final int CIRCLE_RADIUS = 50;

    protected Board board;
    protected boolean isGameOver;

    public Game() {
        board = new Board();
        isGameOver = false;

        setPreferredSize(new Dimension(7 * SPACING, 6 * SPACING));
        setBackground(Color.BLUE);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

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

}
