package UI;

import Model.Board;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Set;

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
                    repaint();
                    return;
                }
                Set<Board> nextMoves = board.nextMove();
                if (nextMoves.isEmpty()) {
                    isGameOver = true;
                    repaint();
                    return;
                }

                paintComponent(getGraphics());

                int bestValue = -2000;
                for (Board next : nextMoves) {
                    int value = next.getYellowBoardValue();
                    if (value > bestValue) {
                        board = next;
                        bestValue = value;

                    }
                }
                repaint();
                if (board.isOver()) {
                    isGameOver = true;
                }
            }
        }
    }
}
