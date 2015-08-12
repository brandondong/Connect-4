package Model;

/**
 * Created by Brandon on 2015-08-12.
 */
public class Board {

    private Disc[][] discs;
    private boolean isYellowTurn;

    public Board() {
        isYellowTurn = true;
        discs = new Disc[7][6];
    }

    public Disc[][] getDiscs() {
        return discs;
    }

    public boolean isYellowTurn() {
        return isYellowTurn;
    }
}
