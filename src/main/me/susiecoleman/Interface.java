package main.me.susiecoleman;
import main.me.susiecoleman.exceptions.InvalidGridIndexException;
import main.me.susiecoleman.exceptions.InvalidMoveException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interface {

    private Grid grid;
    private boolean isNaughtGo;
    private BufferedReader reader;

    public Interface() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        isNaughtGo = true;
        grid = new Grid();
    }

    private String turnIndicator() {
        return isNaughtGo ? "Naught's turn" : "Cross's turn";
    }

    private void updateGrid(int row, int column) throws InvalidMoveException, InvalidGridIndexException {
        if(isNaughtGo){
            grid.insertNaught(row, column);
        } else {
            grid.insertCross(row, column);
        }
    }

    private void takeTurn() throws InvalidMoveException, InvalidGridIndexException, IOException {
        System.out.println("Enter Row Coordinate between 0 and 2:");
        int row = Integer.parseInt(reader.readLine());
        System.out.println("Enter Column Coordinate between 0 and 2:");
        int column = Integer.parseInt(reader.readLine());
        updateGrid(row, column);
        isNaughtGo = !isNaughtGo;
    }

    private boolean isGameIsOver() {
        return StateOfPlayChecks.hasWinner(grid) || StateOfPlayChecks.isStaleMate(grid);
    }

    public void gamePlay() {
        System.out.println("Naughts and Crosses!");
        while(!isGameIsOver()) {
            System.out.println(turnIndicator());
            System.out.println(grid);
            try {
                takeTurn();
            } catch (InvalidMoveException e) {
                System.out.println("Not a valid move, try again");
            } catch (InvalidGridIndexException e) {
                System.out.println("Invalid reference choose a number between 0 and 2, try again");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Game over!");
        System.out.println(grid);
    }
}
