package conRefactorizacionTicTacToe;

import sinRefactorizacionTicTacToe.TicTacToe;

public class TicTacToe_Refact
{
    private static final int TOTALROWS = 3;
    private static final int TOTALCOLUMNS = 3;

    public enum Cell {
        EMPTY, CROSS, NOUGHT
    }

    private TicTacToe.Cell[][] grid;
    private char turn;

    public enum GameState {
        PLAYING, DRAW, CROSS_WON, NOUGHT_WON
    }

    private TicTacToe.GameState currentGameState;

    public TicTacToe_Refact() {
        grid = new TicTacToe.Cell[TOTALROWS][TOTALCOLUMNS];
        initGame();
    }

    private void initGame() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                grid[row][col] = TicTacToe.Cell.EMPTY;
            }
        }
        currentGameState = TicTacToe.GameState.PLAYING;
        turn = 'X';
    }

    public void resetGame() {
        initGame();
    }

    public int getTotalRows() {
        return TOTALROWS;
    }

    public int getTotalColumns() {
        return TOTALCOLUMNS;
    }


    public TicTacToe.Cell getCell(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS) {
            return grid[row][column];
        } else {
            return null;
        }
    }

    public char proximoJugador() {
        return turn;
    }

    //////////////////////////// Miguel estuvo aqui ///////////////////////////////////////////////////
    public void jugar(int row, int column) {
        if (row >= 0 && row < TOTALROWS && column >= 0 && column < TOTALCOLUMNS ) {
            posicion_OcupadoDesacupada(row,column);
        }
        else{
            posicion_fuerdaDelTablero(row, column);
        }
    }
    private void posicion_OcupadoDesacupada(int row, int column){
        if(grid[row][column] == TicTacToe.Cell.EMPTY) {
            grid[row][column] = (turn == 'X') ? TicTacToe.Cell.CROSS : TicTacToe.Cell.NOUGHT;
            updateGameState(turn, row, column);
            turn = (turn == 'X') ? 'O' : 'X';
        }
        else{
            throw new RuntimeException("Esta posicion esta ocupada");
        }
    }
    private void posicion_fuerdaDelTablero(int row, int column){
        if(row >= TOTALROWS || row<0) {
            throw new RuntimeException("Saliste del tablero fuera del eje x");
        }
        if(column >= TOTALCOLUMNS || column<0){
            throw new RuntimeException("Saliste del tablero fuera del eje y");
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    private void updateGameState(char turn, int row, int column) {
        if (hasWon(turn, row, column)) {
            currentGameState = (turn == 'X') ? TicTacToe.GameState.CROSS_WON : TicTacToe.GameState.NOUGHT_WON;
        } else if (isDraw()) {
            currentGameState = TicTacToe.GameState.DRAW;
        }

    }

    private boolean isDraw() {
        for (int row = 0; row < TOTALROWS; ++row) {
            for (int col = 0; col < TOTALCOLUMNS; ++col) {
                if (grid[row][col] == TicTacToe.Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWon(char turn, int row, int column) {
        TicTacToe.Cell token = (turn == 'X') ? TicTacToe.Cell.CROSS : TicTacToe.Cell.NOUGHT;
        return (grid[row][0] == token
                && grid[row][1] == token && grid[row][2] == token
                || grid[0][column] == token
                && grid[1][column] == token && grid[2][column] == token
                || row == column
                && grid[0][0] == token && grid[1][1] == token && grid[2][2] == token
                || row + column == 2
                && grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
    }

    public TicTacToe.GameState getGameState() {
        return currentGameState;
    }

}
