package Model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Brandon on 2015-08-12.
 */
public class Board {

    private Disc[][] discs;
    private Disc turn;

    public Board() {
        turn = Disc.YELLOW;
        discs = new Disc[7][6];
    }

    public Board(Disc[][] discs, Disc turn) {
        this.discs = discs;
        this.turn = turn;
    }

    // Requires: (x,y) coordinate is within board
    // Effects: returns the disc at a certain location
    public Disc getDiscAt(int x, int y) {
        return discs[x][y];
    }

    // Requires: 0 <= x < 7
    // Modifies: this
    // Effects: makes a move on the given column, returns true and switches turn if possible
    public boolean makeMove(int x) {
        for (int i = 0; i < 6; i++) {
            if (discs[x][i] == null) {
                discs[x][i] = turn;
                switchTurn();
                return true;
            }
        }
        return false;
    }

    // Modifies: this
    // Effects: switches to red's turn if it is currently yellow's and vice versa
    private void switchTurn() {
        if (turn.equals(Disc.RED)) {
            turn = Disc.YELLOW;
        } else {
            turn = Disc.RED;
        }
    }

    // Effects: returns a set of boards representing the next possible states from the current
    public Set<Board> nextMove() {
        Set<Board> moves = new HashSet<>();
        for (int i = 0; i < 7; i++) {
            Board move = new Board(discs.clone(), turn);
            if (move.makeMove(i)) {
                moves.add(move);
            }
        }
        return moves;
    }

    // Effects: returns true if the board is won
    public boolean isOver() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (canConnect(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    // Effects: returns the value of the board for yellow
    public int getValueForYellow() {
        int value = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                value += getValueAtPos(i, j);
            }
        }
        return value;
    }

    private int getValueAtPos(int x, int y) {
        Disc color = discs[x][y];
        List<List<Disc>> moves = getMovesAt(x, y);
        return 0;
    }

    private List<List<Disc>> getMovesAt(int x, int y) {
        List<List<Disc>> moveSet = new ArrayList<>();
        List<Disc> moves;

        if (discs[x][y] == null) {
            return moveSet;
        }

        if (x >= 3) {
            moves = new ArrayList<>();
            moves.add(discs[x - 1][y]);
            moves.add(discs[x - 2][y]);
            moves.add(discs[x - 3][y]);
            moveSet.add(moves);
            if (y <= 2) {
                moves = new ArrayList<>();
                moves.add(discs[x - 1][y + 1]);
                moves.add(discs[x - 2][y + 2]);
                moves.add(discs[x - 3][y + 3]);
                moveSet.add(moves);
            }
            if (y >= 3) {
                moves = new ArrayList<>();
                moves.add(discs[x - 1][y - 1]);
                moves.add(discs[x - 2][y - 2]);
                moves.add(discs[x - 3][y - 3]);
                moveSet.add(moves);
            }
        }
        if (x <= 3) {
            moves = new ArrayList<>();
            moves.add(discs[x + 1][y]);
            moves.add(discs[x + 2][y]);
            moves.add(discs[x + 3][y]);
            moveSet.add(moves);
            if (y <= 2) {
                moves = new ArrayList<>();
                moves.add(discs[x + 1][y + 1]);
                moves.add(discs[x + 2][y + 2]);
                moves.add(discs[x + 3][y + 3]);
                moveSet.add(moves);
            }
            if (y >= 3) {
                moves = new ArrayList<>();
                moves.add(discs[x + 1][y - 1]);
                moves.add(discs[x + 2][y - 2]);
                moves.add(discs[x + 3][y - 3]);
                moveSet.add(moves);
            }
        }
        if (y <= 2) {
            moves = new ArrayList<>();
            moves.add(discs[x][y + 1]);
            moves.add(discs[x][y + 2]);
            moves.add(discs[x][y + 3]);
            moveSet.add(moves);
        }
        if (y >= 3) {
            moves = new ArrayList<>();
            moves.add(discs[x][y - 1]);
            moves.add(discs[x][y - 2]);
            moves.add(discs[x][y - 3]);
            moveSet.add(moves);
        }
        return moveSet;
    }

    // Effects: returns true if a four disc connection can be made from the given position
    private boolean canConnect(int x, int y) {
        Disc color = discs[x][y];
        List<List<Disc>> moves = getMovesAt(x, y);

        for (List<Disc> next : moves) {
            if (isAllSameColor(color, next)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAllSameColor(Disc color, List<Disc> discs) {
        for (Disc next : discs) {
            if (!color.equals(next)) {
                return false;
            }
        }
        return true;
    }

    public Disc[][] getDiscs() {
        return discs;
    }

    public Disc getTurn() {
        return turn;
    }
}
