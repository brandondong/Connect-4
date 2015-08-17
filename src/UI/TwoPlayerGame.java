package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Brandon on 2015-08-16.
 */
public class TwoPlayerGame extends Game {

    public TwoPlayerGame() {
        addMouseListener(new DoubleMouseHandler());
    }

    public class DoubleMouseHandler extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            if (!isGameOver) {
                int x = e.getX() / SPACING;
                if (board.makeMove(x) && board.isOver()) {
                    isGameOver = true;
                }
                repaint();
            }
        }
    }
}
