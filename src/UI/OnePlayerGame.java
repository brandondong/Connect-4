package UI;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Brandon on 2015-08-16.
 */
public class OnePlayerGame extends Game {

    public OnePlayerGame() {
        board.makeMove(3);
        addMouseListener(new SingleMouseHandler());
    }

    public class SingleMouseHandler extends MouseAdapter {

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
