package test.me.susiecoleman;

import main.me.susiecoleman.Cross;
import main.me.susiecoleman.Grid;
import main.me.susiecoleman.Naught;
import main.me.susiecoleman.Square;
import main.me.susiecoleman.exceptions.InvalidGridIndexException;
import main.me.susiecoleman.exceptions.InvalidMoveException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class GridTest {

    private Grid grid;

    @Before
    public void initObjects() {
        grid = new Grid();
    }

    @Test
    public void insertCrossIntoGrid() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertCross(0, 0);
        assert (grid.getGrid()[0][0] instanceof Cross);
    }

    @Test
    public void insertNaughtIntoGrid() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertNaught(2, 2);
        assert (grid.getGrid()[2][2] instanceof Naught);
    }

    @Test(expected = InvalidGridIndexException.class)
    public void throwExceptionWhenInvalidRowIndex() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertCross(3, 0);
    }

    @Test(expected = InvalidGridIndexException.class)
    public void throwExceptionWhenInvalidColumnIndex() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertNaught(0, 3);
    }

    @Test
    public void testGetSquareInGrid() throws InvalidGridIndexException {
        Square square = grid.getSquare(0, 0);
        assertTrue (square.isEmpty());
        assert (square.toString().equals("[ ]"));
    }

    @Test (expected = InvalidGridIndexException.class)
    public void testGetSquareInvalidGridIndex() throws InvalidGridIndexException {
        grid.getSquare(3, 0);
    }

    @Test
    public void testGetRowInGrid() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertCross(0,0);
        Square[] row = {new Cross(), new Square(), new Square()};
        assert (Arrays.equals(grid.getRow(0), row));
    }

    @Test (expected = InvalidGridIndexException.class)
    public void testGetRowInGridInvalidIndex() throws InvalidGridIndexException, InvalidMoveException {
        grid.getRow(3);
    }

    @Test
    public void displayEmptyGrid() {
        assertTrue (grid.toString().equals("[ ][ ][ ]\n[ ][ ][ ]\n[ ][ ][ ]\n"));
    }

    @Test
    public void displayGridWithCross() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertCross(0, 2);
        grid.insertCross(1, 2);
        assertTrue (grid.toString().equals("[ ][ ][X]\n[ ][ ][X]\n[ ][ ][ ]\n"));
    }

    @Test
    public void displayGridWithNaught() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertNaught(1, 0);
        grid.insertNaught(2, 2);
        assertTrue (grid.toString().equals("[ ][ ][ ]\n[O][ ][ ]\n[ ][ ][O]\n"));
    }

    @Test(expected = InvalidMoveException.class)
    public void onlyAllowInsertionIntoEmptySquare() throws InvalidGridIndexException, InvalidMoveException {
        grid.insertCross(1,2);
        grid.insertCross(1,2);
    }
}