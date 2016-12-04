package main.me.susiecoleman;

import main.me.susiecoleman.exceptions.InvalidGridIndexException;
import main.me.susiecoleman.exceptions.InvalidMoveException;

public class Grid {

    private Square[][] grid = new Square[3][3];

    public Grid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new Square();
            }
        }
    }

    public Square[][] getGrid() {
        return grid;
    }

    public void insertCross(int row, int column) throws InvalidGridIndexException, InvalidMoveException {
        insertValue(new Cross(), row, column);
    }

    public void insertNaught(int row, int column) throws InvalidGridIndexException, InvalidMoveException {
        insertValue(new Naught(), row, column);
    }

    private void insertValue(Square square, int row, int column) throws InvalidGridIndexException, InvalidMoveException {
        checkGridReferenceInRange(row, column);
        if(grid[row][column].isEmpty()) {
            grid[row][column] = square;
        } else {
            throw new InvalidMoveException();
        }
    }

    public Square getSquare(int row, int column) throws InvalidGridIndexException {
        checkGridReferenceInRange(row, column);
        return grid[row][column];
    }

    public Square[] getRow(int rowIndex) throws InvalidGridIndexException {
        if(rowIndex >= grid.length) {
            throw new InvalidGridIndexException();
        } else {
            return grid[rowIndex];
        }
    }

    public String toString() {
        String display = "";
        for (Square[] row : grid) {
            for (Square square: row) {
                display += square.toString();
            }
            display += "\n";
        }
        return display;
    }

    private void checkGridReferenceInRange(int row, int column) throws InvalidGridIndexException {
        if(row >= grid.length || column >= grid.length){
            throw new InvalidGridIndexException();
        }
    }
}
