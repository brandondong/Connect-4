package Tests;

import Model.Board;
import Model.Disc;
import org.junit.Before;
import org.junit.Test;

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
        test.makeMove(1);
        assertEquals(test.getDiscAt(1, 1), Disc.RED);
    }

}