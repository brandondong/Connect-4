package UI;

import Model.Board;

/**
 * Created by Brandon on 2015-08-12.
 */
public abstract class Game {

    private Board board;

    public Game() {
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }
}
