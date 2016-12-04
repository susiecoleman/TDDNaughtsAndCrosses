package test.me.susiecoleman;

import main.me.susiecoleman.Grid;
import main.me.susiecoleman.StateOfPlayChecks;
import main.me.susiecoleman.exceptions.InvalidGridIndexException;
import main.me.susiecoleman.exceptions.InvalidMoveException;
import org.junit.Test;

import static org.junit.Assert.*;

public class StateOfPlayChecksTest {

    @Test
    public void testNoCurrentWinnerEmptyGrid() {
        Grid grid = new Grid();
        assertFalse (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testNoCurrentWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertCross(0,2);
        grid.insertNaught(0,0);
        assertFalse (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testTopRowWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertCross(0,0);
        grid.insertCross(0,1);
        grid.insertCross(0,2);
        grid.insertNaught(1,1);
        grid.insertNaught(1,2);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testMiddleRowWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertCross(1,0);
        grid.insertCross(1,1);
        grid.insertCross(1,2);
        grid.insertNaught(0,1);
        grid.insertNaught(0,2);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testBottomRowWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertNaught(2,0);
        grid.insertNaught(2,1);
        grid.insertNaught(2,2);
        grid.insertCross(0,1);
        grid.insertCross(0,2);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testLeftColumnWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertNaught(0,0);
        grid.insertNaught(1,0);
        grid.insertNaught(2,0);
        grid.insertCross(0,1);
        grid.insertCross(0,2);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testMiddleColumnWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertNaught(0,1);
        grid.insertNaught(1,1);
        grid.insertNaught(2,1);
        grid.insertCross(0,0);
        grid.insertCross(0,2);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testRightColumnWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertNaught(0,2);
        grid.insertNaught(1,2);
        grid.insertNaught(2,2);
        grid.insertCross(0,0);
        grid.insertCross(0,1);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testLeftToRightDiagonalWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertNaught(0,0);
        grid.insertNaught(1,1);
        grid.insertNaught(2,2);
        grid.insertCross(1,0);
        grid.insertCross(0,1);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testRightToLeftDiagonalWinner() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertNaught(0,2);
        grid.insertNaught(1,1);
        grid.insertNaught(2,0);
        grid.insertCross(1,0);
        grid.insertCross(0,1);
        assertTrue (StateOfPlayChecks.hasWinner(grid));
    }

    @Test
    public void testMovesRemaining() {
        Grid grid = new Grid();
        assertFalse (StateOfPlayChecks.isStaleMate(grid));
    }

    @Test
    public void testNoMovesRemaining() throws InvalidMoveException, InvalidGridIndexException {
        Grid grid = new Grid();
        grid.insertCross(0,0);
        grid.insertCross(0,1);
        grid.insertCross(0,2);
        grid.insertCross(1,0);
        grid.insertCross(1,1);
        grid.insertCross(1,2);
        grid.insertCross(2,0);
        grid.insertCross(2,1);
        grid.insertCross(2,2);
        assertTrue (StateOfPlayChecks.isStaleMate(grid));
    }
}