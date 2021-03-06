package Tests;

import Model.Board;
import Model.Disc;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Brandon on 2015-08-13.
 */
public class BoardTest {

    private Board test;

    @Before
    public void setup() {
        test = new Board();
    }

    @Test
    public void testGetDiscAt() {
        assertEquals(null, test.getDiscAt(1, 1));
    }

    @Test
    public void testMakeMove() {
        test.makeMove(1);
        assertEquals(test.getDiscAt(1, 0), Disc.YELLOW);
        assertEquals(Disc.RED, test.getTurn());
        test.makeMove(1);
        assertEquals(test.getDiscAt(1, 1), Disc.RED);
    }

    @Test
    public void testIsOver() {
        assertFalse(test.isOver());
        test.makeMove(2);
        assertFalse(test.isOver());
        test.makeMove(3);
        test.makeMove(2);
        test.makeMove(3);
        test.makeMove(2);
        test.makeMove(3);
        test.makeMove(2);
        assertTrue(test.isOver());
    }

    @Test
    public void testNextMove() {
        Set<Board> nextMoves = test.nextMove();
        assertEquals(7, nextMoves.size());

        for (int i = 0; i < 6; i++) {
            assertTrue(test.makeMove(0));
        }
        assertEquals(6, test.nextMove().size());
        for (int i = 0; i < 6; i++) {
            assertTrue(test.makeMove(1));
        }
        assertEquals(5, test.nextMove().size());
    }

    @Test
    public void testGetValue() {
        assertEquals(2, test.getYellowBoardValue());
    }

}