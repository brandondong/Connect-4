package Model;

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

    // Effects: returns true if a four disc connection can be made from the given position
    private boolean canConnect(int x, int y) {
        Disc color = discs[x][y];
        if (color == null) {
            return false;
        }

        if (x >= 3) {
            if (color.equals(discs[x - 1][y]) && color.equals(discs[x - 2][y]) && color.equals(discs[x - 3][y])) {
                return true;
            }
        }
        if (x <= 4) {
            if (color.equals(discs[x + 1][y]) && color.equals(discs[x + 2][y]) && color.equals(discs[x + 3][y])) {
                return true;
            }
        }
        if (y <= 2) {
            if (color.equals(discs[x][y + 1]) && color.equals(discs[x][y + 2]) && color.equals(discs[x][y + 3])) {
                return true;
            }
        }
        if (y >= 3) {
            if (color.equals(discs[x][y - 1]) && color.equals(discs[x][y - 2]) && color.equals(discs[x][y - 3])) {
                return true;
            }
        }

        return false;
    }

    public Disc[][] getDiscs() {
        return discs;
    }

    public Disc getTurn() {
        return turn;
    }
}
