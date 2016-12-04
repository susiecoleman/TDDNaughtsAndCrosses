package main.me.susiecoleman;

import main.me.susiecoleman.exceptions.InvalidGridIndexException;

public class StateOfPlayChecks {

    private Grid grid;
    private int gridSize;

    private StateOfPlayChecks(Grid grid) {
        this.grid = grid;
        gridSize = grid.getGrid().length;
    }

    public static boolean hasWinner(Grid grid) {
        StateOfPlayChecks stateOfPlayChecks = new StateOfPlayChecks(grid);
        return stateOfPlayChecks.hasWinner();
    }

    private Boolean hasWinner() {
        return isWinningRow() || isWinningColumn() || checkWinningDiagonals();
    }

    private boolean isWinningRow() {
        try {
            boolean isWinningRow = false;
            for (int i = 0; i < gridSize; i++) {
                if (isWinningThreeSquares(grid.getRow(i))) {
                    isWinningRow = true;
                }
            }
            return isWinningRow;
        } catch (InvalidGridIndexException e) {
            return false;
        }
    }

    private boolean isWinningColumn() {
        try {
            boolean isWinningColumn = false;
            for (int i = 0; i < gridSize; i++) {
                Square[] column = new Square[3];
                for (int j = 0; j < gridSize; j++) {
                    column[j] = grid.getSquare(j,i);
                }
                if (isWinningThreeSquares(column)) {
                    isWinningColumn = true;
                }
            }
            return isWinningColumn;
        } catch (InvalidGridIndexException e) {
            return false;
        }
    }

    private boolean checkWinningDiagonals() {
        return checkLeftToRight() || checkRightToLeft();
    }

    private boolean checkLeftToRight() {
        try {
            Square[] row = {grid.getSquare(0, 0), grid.getSquare(1, 1), grid.getSquare(2, 2)};
            return isWinningThreeSquares(row);
        } catch (InvalidGridIndexException e) {
            return false;
        }
    }

    private boolean checkRightToLeft() {
        try {
            Square[] row = {grid.getSquare(0,2), grid.getSquare(1,1), grid.getSquare(2,0)};
            return isWinningThreeSquares(row);
        } catch (InvalidGridIndexException e) {
            return false;
        }
    }

    private boolean isWinningThreeSquares(Square[] row) {
        if(squaresAreFull(row)){
            String square1String = row[0].toString();
            String square2String = row[1].toString();
            String square3String = row[2].toString();
            return square1String.equals(square2String) && square2String.equals(square3String);
        }
        else {
            return false;
        }
    }

    private boolean squaresAreFull(Square[] row) {
        return !(row[0].isEmpty() || row[1].isEmpty() || row[2].isEmpty());
    }

    public static boolean isStaleMate(Grid grid) {
        boolean isEmptySquaresRemaining = false;
        for (Square[] row: grid.getGrid()) {
            for (Square square: row) {
                if (square.isEmpty()) {
                    isEmptySquaresRemaining = true;
                }
            }
        }
        return !isEmptySquaresRemaining;
    }
}
